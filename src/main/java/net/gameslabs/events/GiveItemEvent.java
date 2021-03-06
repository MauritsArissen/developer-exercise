package net.gameslabs.events;

import net.gameslabs.api.Player;
import net.gameslabs.api.PlayerEvent;

public class GiveItemEvent extends PlayerEvent {
	
	private final int id;
	private final int amount;

	public GiveItemEvent(Player player, int id, int amount) {
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
