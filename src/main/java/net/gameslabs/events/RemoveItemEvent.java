package net.gameslabs.events;

import net.gameslabs.api.Player;
import net.gameslabs.api.PlayerEvent;

public class RemoveItemEvent extends PlayerEvent {

	private final int id;
	private final int amount;

	public RemoveItemEvent(Player player, int id, int amount) {
		super(player);
		this.id = id;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public int getAmount() {
		return amount;
	}

}