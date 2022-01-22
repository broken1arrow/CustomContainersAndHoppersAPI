
# CustomContainersAndHoppersAPI info

You have several methods you can use and also events. You have also a lot more inside to use (most of the methods have java docs) and
Most of the methods you get access from the main class, only ContainerRegistry and PreferenceSettingsRegistery have another way 
to access the class methods.

To access cache for containers or playerdata 
```
//And you have access to all methods you need.
ContainerRegistryAPI.getInstance()

//This is to access all settings players have set or you get default from settings.yml
//also you can get a player's party list.
PreferenceSettingsRegisteryApi.getInstance()
```

To access the containers to add or remove items. The plugin will create and make the holders automatic when the plugin start and 
new containers player place or in some cases when opening the container.
```
// you can use this if you also want the inventory also get created (if not set the player to null or use the method below)
CustomContainersMainClass.getInstance().getInventoryHoldersCached().createOrGetInventoryHolder(Location, UUID);

// return the inventoryholder on location or null if it does not exist and needs to be created first.
CustomContainersMainClass.getInstance().getInventoryHoldersCached().getInventoryHolder(Location);
```


# Custom events when containers pull or add items to the container, you can also cancel some of the events.

## This event gets triggered before the item gets teleported to inventory. 


```

	@EventHandler
	public void onTeleportItems(final PreHopperTeleportEvent event) {
		//You have asses to isCancelled() and setCancelled() and where 
		//it send items from and too and the array of items it try to teleport.  
	}

```


## This event gets triggered after items get teleported to inventory.


```
	@EventHandler
	public void onTeleportItemsAfter(final PostHopperTeleportEvent  event) {
		//Is more like monitor if the item get send, you have this method to check it 
		//isItemTeleported() and rest are same as PreHopperTeleportEvent (but you can´t cancelled the event).  
	}
```

## This event gets triggered before the item gets moved to inventory (is similar to bukkit InventoryMoveItemEvent).


```
	@EventHandler
	public void hoperMoveItem(final PreHopperMoveItemEvent event) {
		//add your code here, you have acres to isCancelled() and setCancelled() and
		//locations from and to container (get only triggered if item try to move to conatiner or 
		//from container if hopper are connected).
	}

```


## This event gets triggered before the item gets picked up.


```
	@EventHandler
	public void hoperMoveItem(final PreSuctionEvent event) {
		//add your code here, you have acres to isCancelled() and setCancelled() and
		//locations from the item location and to container (this event get trigged when hopper try pick up 
		//items).
	}

```
