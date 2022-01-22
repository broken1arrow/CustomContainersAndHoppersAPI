
# CustomContainersAndHoppersAPI info

You have several methods you can use and also events. You have also lot more inside to use (most of the methods have javadoc´s).
Most of the methods you get acces from the main class, only ContainerRegistry and PreferenceSettingsRegistery have other way 
to acces the class methods.

To acces cache for containers or playerdata 
```
//And you have acces to all methods you need.
ContainerRegistryAPI.getInstance()

//This is to acces all settings player have set or you get defult from settings.yml
//also you can also get players party list.
PreferenceSettingsRegisteryApi.getInstance()
```

To acces the containers to add or remove items. The plugin will create and make the holders automatic when plugin start and 
new containers player place or in some cases when open the container.
```
// you can use this if you also want the inventory also get created (if not set player to null or use method below)
CustomContainersMainClass.getInstance().getInventoryHoldersCached().createOrGetInventoryHolder(Location, UUID);

// return the inventoryholder on location or null if it not exist and need be created first.
CustomContainersMainClass.getInstance().getInventoryHoldersCached().getInventoryHolder(Location);
```


# Custom events when container pull or add items to container, you can also cancel some of the event.

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
