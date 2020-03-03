package assignment.components;

import net.gameslabs.api.Component;
import net.gameslabs.events.GiveItemEvent;
import net.gameslabs.events.HasItemEvent;
import net.gameslabs.events.RemoveItemEvent;
import net.gameslabs.model.Item.PlayerInventory;

public class MyInventoryComponent extends Component {

	@Override
	public void onLoad() {
		registerEvent(GiveItemEvent.class, this::onGiveItem);
		registerEvent(RemoveItemEvent.class, this::onRemoveItem);
		registerEvent(HasItemEvent.class, this::onHasItem);
	}

	public void onGiveItem(GiveItemEvent event) {
		PlayerInventory inventory = event.getPlayer().getInventory();
		if (!inventory.addItem(event.getId(), event.getAmount())) {
			event.setCancelled(true);
		}
	}
	
	public void onRemoveItem(RemoveItemEvent event) {
		PlayerInventory inventory = event.getPlayer().getInventory();
		if (!inventory.removeItem(event.getId(), event.getAmount())) {
			event.setCancelled(true);
		}
	}
	
	public void onHasItem(HasItemEvent event) {
		PlayerInventory inventory = event.getPlayer().getInventory();
		event.setResult(inventory.hasItemAmount(event.getId(), event.getAmount()));
	}
	
	@Override
	public void onUnload() {
		// TODO Auto-generated method stub
	}

}
