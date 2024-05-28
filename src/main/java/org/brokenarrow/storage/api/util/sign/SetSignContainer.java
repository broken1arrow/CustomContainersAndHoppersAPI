package org.brokenarrow.storage.api.util.sign;


import org.broken.arrow.serialize.library.utility.Pair;
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

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for setting up sign on the container.
 */
public class SetSignContainer {
    private final Location blockLoc;
    private final BlockFace blockFace;
    private final SignUtility signLines;
    private final Material signType;

    /**
     * Constructs a SetSignContainer object with the given parameters.
     *
     * @param signType  The type of sign to place.
     * @param blockLoc  The location of the block to place the sign on.
     * @param signLines The utility object containing sign text.
     */
    public SetSignContainer(final Material signType, final Location blockLoc, final SignUtility signLines) {
        this(signType, null, blockLoc, signLines);
    }

    /**
     * Constructs a SetSignContainer object with the given parameters.
     *
     * @param signType        The type of sign to place.
     * @param prioritizedFace The prioritized block face.
     * @param blockLoc        The location of the block to place the sign on.
     * @param signLines       The utility object containing sign text.
     */
    public SetSignContainer(final Material signType, BlockFace prioritizedFace, final Location blockLoc, final SignUtility signLines) {
        this.blockLoc = blockLoc;
        this.signType = signType;
        this.signLines = signLines;
        this.blockFace = prioritizedFace != null ? prioritizedFace : getFace(blockLoc);
    }

    /**
     * Places a sign on the block location.
     *
     * @return The location of the placed sign, or null if unsuccessful.
     */
    @Nullable
    public Pair<Location, BlockFace> placeSign() {
        if (this.blockFace != null) {
            BlockFace[] facesToCheck = getBlockFaces(this.blockFace);
            for (BlockFace face : facesToCheck) {
                Block block = blockLoc.getBlock().getRelative(face);
                if (face == BlockFace.UP || face == BlockFace.DOWN) {
                    block = block.getRelative(this.blockFace);
                }
                Location location = setBlockData(face, block);
                if (location != null) {
                    return new Pair<>(location, face);
                }
            }
        }
        return null;
    }

    /**
     * Get all block faces.
     *
     * @param prioritizedFace the prioritized facing of the sign.
     * @return array of blackfaces.
     */
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

    /**
     * Set the data to the world.
     *
     * @param face  the facing of the sign.
     * @param block the block to set the sig on.
     * @return the location where it places the sign or null if it could not place the sign.
     */
    public Location setBlockData(final BlockFace face, final Block block) {

        if (face != null && isEmpty(block)) {
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

    /**
     * Set the state for the sign.
     *
     * @param state the state.
     */
    private void setState(final Sign state) {
        SignText frontText = signLines.getFront();
        SignText backText = signLines.getBack();

        if (frontText != null) setText(frontText, state, true);
        if (backText != null) setText(backText, state, false);

        state.update(true);
    }

    /**
     * Set the text on the sign.
     *
     * @param signText the text to set on the sign.
     * @param front    if the text should be on the front.
     * @param state    the current block state.
     */
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

    /**
     * check if the block is same as the sign material or is empty.
     *
     * @param block the block to check.
     * @return true if the sign is same or air.
     */
    private boolean isEmpty(final Block block) {
        return block.getType() == this.signType || block.isEmpty();
    }

    /**
     * get the face where you want to place the sign.
     *
     * @param blockLoc the location of the block.
     * @return the block face.
     */
    private BlockFace getFace(final Location blockLoc) {
        Block block = blockLoc.getBlock();
        if (block.getBlockData() instanceof Directional) {
            Directional directionalMeta = (Directional) block.getBlockData();
            BlockFace blockFace = directionalMeta.getFacing();
            if (blockFace == BlockFace.UP || blockFace == BlockFace.DOWN)
                return BlockFace.EAST;
            return directionalMeta.getFacing();
        }
        return null;
    }

    /**
     * Set the block-facing.
     *
     * @param original the original facing.
     * @return the blackface to set the block towards.
     */
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