package net.gameslabs.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerInventory {

	// I didn't include a stack limit for items as for this assignment.
	
	// Limiting inventory size to 36 slots + offhand in this case.
	private final int inventorySize = 37;
	private List<PlayerItem> inventory;
	
	public PlayerInventory() {
		inventory = new ArrayList<>();
	}
	
	// Get the PlayerItem object from the inventory list.
	public PlayerItem getItem(int id) {
		PlayerItem result = null;
		for (PlayerItem pItem : inventory) {
			if (pItem.getId() == id) {
				result = pItem;
			}
		}
		return result;
	}
	
	/*
	 * Check if the inventory contains the PlayerItem with the given id
	 * to avoid duplicate stacks.
	 */
	public boolean hasItem(int id) {
		boolean result = false;
		for (PlayerItem pItem : inventory) {
			if (pItem.getId() == id) {
				result = true;
			}
		}
		return result;
	}
	
	/*
	 * Check if the inventory contains the PlayerItem with the given id
	 * to avoid duplicate stacks.
	 */
	public boolean hasItemAmount(int id, int amount) {
		boolean result = false;
		for (PlayerItem pItem : inventory) {
			if (pItem.getId() == id &&
					pItem.getAmount() == amount) {
				result = true;
			}
		}
		return result;
	}
	
	/*
	 * Adds the PlayerItem to the PlayerInventory.
	 * If the item is already inside the PlayerInventory it just increases the amount.
	 * Otherwise it will add a new PlayerItem object to it.
	 */
	public boolean addItem(int id, int amount) {
		if (this.inventory.size() == this.inventorySize || amount <= 0 || id <= 0) return false;
		if (hasItem(id)) {
			PlayerItem pItem = getItem(id);
			pItem.setAmount(pItem.getAmount() + amount);
			return true;
		} else {
			return inventory.add(new PlayerItem(id, amount));
		}
	}
	
	public boolean removeItem(int id, int amount) {
		if (this.inventory.size() == 0 || !hasItem(id)) return false;
		PlayerItem pItem = getItem(id);
		if (pItem.getAmount() <= amount) {
			this.inventory.remove(pItem);
		} else {
			pItem.setAmount(pItem.getAmount() - amount);
		}
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("PlayerInventory [%s]", inventory.stream().map(obj -> obj.toString()).collect(Collectors.joining(", ")));
	}
	
}
