package net.gameslabs.events;

import net.gameslabs.api.Player;
import net.gameslabs.api.PlayerEvent;

public class HasItemEvent extends PlayerEvent {
	
	private final int id;
	private final int amount;
	private boolean result;

	public HasItemEvent(Player player, int id, int amount) {
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

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
	
}
