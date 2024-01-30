package org.brokenarrow.storage.api.util.sign;

import org.brokenarrow.storage.api.util.ServerVersion;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.Rotatable;
import org.bukkit.block.sign.Side;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SetSignContainer {
	private final Location blockLoc;
	private final BlockFace blockFace;
	private final SignUtility signLines;
	private final Material signType;

	public SetSignContainer(final Material signType, final Location blockLoc, final SignUtility signLines) {
		this(signType, null, blockLoc, signLines);
	}

	public SetSignContainer(final Material signType, BlockFace prioritizedFace, final Location blockLoc, final SignUtility signLines) {
		this.blockLoc = blockLoc;
		this.signType = signType;
		this.signLines = signLines;
		this.blockFace = prioritizedFace != null ? prioritizedFace : getFace(blockLoc);
	}

	@Nullable
	public Location placeSign() {
		if (this.blockFace != null) {
			BlockFace[] facesToCheck = getBlockFaces(this.blockFace);
			for (BlockFace face : facesToCheck) {
				Block block = blockLoc.getBlock().getRelative(face);
				if (face == BlockFace.UP || face == BlockFace.DOWN) {
					block = block.getRelative(this.blockFace);
				}
				Location location = setBlockData(face, block);
				if (location != null) return location;
			}
		}
		return null;
	}

	@NotNull
	private BlockFace[] getBlockFaces(BlockFace prioritizedFace) {
		List<BlockFace> facesSet = new ArrayList<>();
		facesSet.add(prioritizedFace);
		facesSet.add(prioritizedFace.getOppositeFace());
		facesSet.add(BlockFace.WEST);
		facesSet.add(BlockFace.EAST);
		facesSet.add(BlockFace.SOUTH);
		facesSet.add(BlockFace.NORTH);
		facesSet.add(BlockFace.UP);
		facesSet.add(BlockFace.DOWN);
		return facesSet.toArray(new BlockFace[0]);
	}

	private Location setBlockData(final BlockFace face, final Block block) {
		if (isEmpty(block)) {
			block.setType(this.signType);
			BlockData blockData = block.getBlockData();

			if (blockData instanceof Rotatable) {
				Rotatable signData = (Rotatable) blockData;
				signData.setRotation(setFace(face));
				block.setBlockData(signData);
			}
			if (blockData instanceof org.bukkit.block.data.type.WallSign) {
				org.bukkit.block.data.type.WallSign signData = (org.bukkit.block.data.type.WallSign) blockData;
				signData.setFacing(setFace(face));
				block.setBlockData(signData);
			}
			Sign state = (Sign) block.getState();
			setState(state);
			return block.getLocation();
		}
		return null;
	}

	private void setState(final Sign state) {
		SignText frontText = signLines.getFront();
		SignText backText = signLines.getBack();

		if (frontText != null) setText(frontText, state, true);
		if (backText != null) setText(backText, state, false);

		state.update(true);
	}

	private void setText(final SignText signText, final Sign state, final boolean front) {
		for (int i = 0; i < 3; i++) {
			String line = signText.getSignLine(i);
			if (line == null) continue;

			if (org.brokenarrow.storage.api.util.ServerVersion.atLeast(ServerVersion.v1_20)) {
				state.getSide(front ? Side.FRONT : Side.BACK).setLine(i, line);
			} else {
				state.setLine(i, line);
			}

		}
	}

	private boolean isEmpty(final Block block) {
		return block.isEmpty() || block.getType() == this.signType;
	}

	private BlockFace getFace(final Location blockLoc) {
		Block block = blockLoc.getBlock();
		if (block.getBlockData() instanceof Directional) {
			Directional directionalMeta = (Directional) block.getBlockData();
			return directionalMeta.getFacing();
		}
		return null;
	}

	private BlockFace setFace(final BlockFace original) {
		switch (original) {
			case UP:
			case DOWN:
				return blockFace;
			default:
				return original;
		}
	}
}