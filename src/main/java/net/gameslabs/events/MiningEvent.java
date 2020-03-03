package net.gameslabs.events;

import net.gameslabs.api.Player;
import net.gameslabs.api.PlayerEvent;
import net.gameslabs.model.Ore;

public class MiningEvent extends PlayerEvent {

	private final Ore ore;
	
	public MiningEvent(Player player, Ore ore) {
		super(player);
		this.ore = ore;
	}
	
	public Ore getOre() {
		return this.ore;
	}
	
}
