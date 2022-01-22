package org.brokenarrow.storage.util.builderclass;

import org.brokenarrow.storage.util.TypeOfContainers;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Builder class to create container data.
 */

public final class ContainerData {

	private final UUID playerId;
	private final String upgrade;
	private final TypeOfContainers.TypeOfContainer typeOfContainer;
	private final String containerFileName;
	private final int numberOfPages;
	private final int amountPlaceForFree;
	private final long totalAmountPickedUp;
	private final long totalAmountTeleportedItems;
	private final long totalAmountItemsSold;
	private final long totalCraftAmount;
	private final long timeBeforeReset;
	private final double totalSoldAmount;
	private final boolean filterWhiteBlack;
	private final ItemStack[] filterItems;
	private final ItemStack[] chestContents;
	private final List<Location> linkContainerLinkedToLocation;
	private final BigInteger amountOfItems;
	private final Builder builder;

	private ContainerData(Builder builder) {
		this.playerId = builder.playerId;
		this.upgrade = builder.upgrade;
		this.typeOfContainer = builder.typeOfContainer;
		this.containerFileName = builder.containerFileName;
		this.numberOfPages = builder.numberOfPages;
		this.amountPlaceForFree = builder.amountPlaceForFree;
		this.totalAmountPickedUp = builder.totalAmountPickedUp;
		this.totalAmountTeleportedItems = builder.totalAmountTeleportedItems;
		this.totalAmountItemsSold = builder.totalAmountItemsSold;
		this.totalCraftAmount = builder.totalCraftAmount;
		this.timeBeforeReset = builder.timeBeforeReset;
		this.totalSoldAmount = builder.totalSoldAmount;
		this.filterWhiteBlack = builder.filterWhiteBlack;
		this.filterItems = builder.filterItems;
		this.chestContents = builder.chestContents;
		this.linkContainerLinkedToLocation = builder.linkContainerLinkedToLocation;
		this.amountOfItems = builder.amountOfItems;
		this.builder = builder;
	}

	/**
	 * Get the player some place the container.
	 *
	 * @return player uuid.
	 */
	public UUID getPlayerId() {
		return playerId;
	}

	/**
	 * Get the update of this container.
	 *
	 * @return current update.
	 */
	public String getUpgrade() {
		return upgrade;
	}

	/**
	 * Get type of container.
	 *
	 * @return container type.
	 */
	public TypeOfContainers.TypeOfContainer getTypeOfContainer() {
		return typeOfContainer;
	}

	/**
	 * Get Container FileName.
	 *
	 * @return container filename.
	 */
	public String getContainerFileName() {
		return containerFileName;
	}

	/**
	 * Get number of pages the container have.
	 *
	 * @return amount  if pages this continer have.
	 */
	public int getNumberOfPages() {
		return numberOfPages;
	}

	/**
	 * Get number of free placments.
	 *
	 * @return amount of free placments.
	 */
	public int getAmountPlaceForFree() {
		return amountPlaceForFree;
	}

	/**
	 * Get the number of items the continer have picked up.
	 *
	 * @return total amount.
	 */
	public long getTotalAmountPickedUp() {
		return totalAmountPickedUp;
	}

	/**
	 * Get the number of items the continer have teleported.
	 *
	 * @return total amount.
	 */
	public long getTotalAmountTeleportedItems() {
		return totalAmountTeleportedItems;
	}

	/**
	 * Get the number of items the continer have sold.
	 *
	 * @return total amount.
	 */
	public long getTotalAmountItemsSold() {
		return totalAmountItemsSold;
	}

	/**
	 * Get the number of items the continer have crafted.
	 *
	 * @return total amount.
	 */
	public long getTotalCraftAmount() {
		return totalCraftAmount;
	}

	/**
	 * Get time before it will reset free placement.
	 *
	 * @return total amount.
	 */
	public long getTimeBeforeReset() {
		return timeBeforeReset;
	}

	/**
	 * Get the amount of money it have sold for.
	 *
	 * @return total amount.
	 */
	public double getTotalSoldAmount() {
		return totalSoldAmount;
	}

	/**
	 * Get if it set to white or blacklist.
	 *
	 * @return true if it a whitelist.
	 */
	public boolean isFilterWhiteBlack() {
		return filterWhiteBlack;
	}

	/**
	 * Get filteritems inside the white/blacklist gui.
	 *
	 * @return itemstaks or air if no item exist.
	 */
	public ItemStack[] getFilterItems() {
		return filterItems;
	}

	/**
	 * Get container contients (itemstacks).
	 *
	 * @return itemstaks or air if no item exist.
	 */
	public ItemStack[] getChestContents() {
		return chestContents;
	}

	/**
	 * Get link and suction contianer all location it are linked too.
	 *
	 * @return list of location or null/empty list of not exist any locations.
	 */
	public List<Location> getLinkContainerLinkedToLocation() {
		return linkContainerLinkedToLocation;
	}

	/**
	 * Get total amount of items inside the container.
	 *
	 * @return amount of items the contriner have.
	 */
	public BigInteger getAmountOfItems() {
		return amountOfItems;
	}

	/**
	 * Get instance of the builder class to get set values
	 * and change old values.
	 *
	 * @return builder instance.
	 */
	public Builder getBulder() {
		return builder;
	}

	/**
	 * Helpclass to build your data.
	 */
	public static class Builder {
		private UUID playerId;
		private String upgrade = "";
		private TypeOfContainers.TypeOfContainer typeOfContainer;
		private String containerFileName;
		private int numberOfPages = 1;
		private int amountPlaceForFree;
		private long totalAmountPickedUp = 0;
		private long totalAmountTeleportedItems = 0;
		private long totalAmountItemsSold = 0;
		private long totalCraftAmount = 0;
		private long timeBeforeReset;
		private double totalSoldAmount = 0;
		private boolean filterWhiteBlack;
		private ItemStack[] filterItems = new ItemStack[0];
		private ItemStack[] chestContents = new ItemStack[0];
		private List<Location> linkContainerLinkedToLocation = new ArrayList<>();
		private BigInteger amountOfItems = BigInteger.valueOf(0);


		/**
		 * Set the player some placed the container.
		 *
		 * @param playerId player uuid.
		 * @return builder instance.
		 */
		public Builder setPlayerId(UUID playerId) {
			this.playerId = playerId;
			return this;
		}

		/**
		 * Set update of this container. It used when read yaml file for get right update.
		 *
		 * @param upgrade name, use a yaml key to get the update.
		 * @return builder instance.
		 */
		public Builder setUpgrade(String upgrade) {
			this.upgrade = upgrade;
			return this;
		}

		/**
		 * Set Chesttype of this container.
		 *
		 * @param typeOfContainer type of container.
		 * @return builder instance.
		 */
		public Builder setTypeOfContainer(TypeOfContainers.TypeOfContainer typeOfContainer) {
			this.typeOfContainer = typeOfContainer;
			return this;
		}

		/**
		 * The filename for this container type.
		 *
		 * @param containerFileName the yaml filename the conainer shall take settings from.
		 * @return builder instance.
		 */
		public Builder setContainerFileName(String containerFileName) {
			this.containerFileName = containerFileName;
			return this;
		}

		/**
		 * Set number of pages for this container
		 *
		 * @param numberOfPages the amount of pages to set.
		 * @return builder instance.
		 */
		public Builder setNumberOfPages(int numberOfPages) {
			this.numberOfPages = numberOfPages;
			return this;
		}

		/**
		 * Set amount free placements.
		 *
		 * @param amountPlaceForFree you set.
		 * @return builder instance.
		 */
		public Builder setAmountPlaceForFree(int amountPlaceForFree) {
			this.amountPlaceForFree = amountPlaceForFree;
			return this;
		}

		/**
		 * Set amount of item container pickup.
		 *
		 * @param totalAmountPickedUp total amount picked up.
		 * @return builder instance.
		 */
		public Builder setTotalAmountPickedUp(long totalAmountPickedUp) {
			this.totalAmountPickedUp = totalAmountPickedUp;
			return this;
		}

		/**
		 * Set amount of items teleported between containers.
		 *
		 * @param totalAmountTeleportedItems amount of items teleported.
		 * @return builder instance.
		 */
		public Builder setTotalAmountTeleportedItems(long totalAmountTeleportedItems) {
			this.totalAmountTeleportedItems = totalAmountTeleportedItems;
			return this;
		}

		/**
		 * Set amount of item sold.
		 *
		 * @param totalAmountItemsSold set amount sold inside the container.
		 * @return builder instance.
		 */
		public Builder setTotalAmountItemsSold(long totalAmountItemsSold) {
			this.totalAmountItemsSold = totalAmountItemsSold;
			return this;
		}

		/**
		 * Set amount of item crafted.
		 *
		 * @param totalCraftAmount total amount crafted.
		 * @return builder instance.
		 */
		public Builder setTotalCraftAmount(long totalCraftAmount) {
			this.totalCraftAmount = totalCraftAmount;
			return this;
		}

		/**
		 * Set time on container before it reset the counter,
		 * for free placements.
		 *
		 * @param timeBeforeReset the continer curently have.
		 * @return builder instance.
		 */
		public Builder setTimeBeforeReset(long timeBeforeReset) {
			this.timeBeforeReset = timeBeforeReset;
			return this;
		}

		/**
		 * Set amount of item sold.
		 *
		 * @param totalSoldAmount total amount sold.
		 * @return builder instance.
		 */
		public Builder setTotalSoldAmount(double totalSoldAmount) {
			this.totalSoldAmount = totalSoldAmount;
			return this;
		}

		/**
		 * Set if it shall be white or black list.
		 *
		 * @param filterWhiteBlack set it to true if you want white list.
		 * @return builder instance.
		 */
		public Builder setFilterWhiteBlack(boolean filterWhiteBlack) {
			this.filterWhiteBlack = filterWhiteBlack;
			return this;
		}

		/**
		 * Set filteritems.
		 *
		 * @param filterItems the items you want to add.
		 * @return builder instance.
		 */

		public Builder setFilterItems(ItemStack[] filterItems) {
			this.filterItems = filterItems;
			return this;
		}

		/**
		 * Save container contents.
		 *
		 * @param chestContents the itemstacks some shall be saved
		 * @return builder instance.
		 */
		public Builder setChestContents(ItemStack[] chestContents) {
			this.chestContents = chestContents;
			return this;
		}

		/**
		 * Set locations for the container has linked too.
		 *
		 * @param linkContainerLinkedToLocation location of the container you has linked too.
		 * @return builder instance.
		 */
		public Builder setLinkContainerLinkedToLocation(List<Location> linkContainerLinkedToLocation) {
			this.linkContainerLinkedToLocation = linkContainerLinkedToLocation;
			return this;
		}

		/**
		 * Set amount of items continer have.
		 *
		 * @param amountOfItems amount of items.
		 * @return builder instance.
		 */
		public Builder setAmountOfItems(BigInteger amountOfItems) {
			this.amountOfItems = amountOfItems;
			return this;
		}

		/**
		 * build your data you have set before.
		 *
		 * @return ContainerData instance;
		 */
		public ContainerData build() {
			return new ContainerData(this);

		}
	}

}
