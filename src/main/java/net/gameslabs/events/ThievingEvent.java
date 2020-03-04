package net.gameslabs.events;

import net.gameslabs.api.Player;
import net.gameslabs.api.PlayerEvent;
import net.gameslabs.model.Thieving.Stall;

public class ThievingEvent extends PlayerEvent {
	
	private final Stall stall;

	public ThievingEvent(Player player, Stall stall) {
		super(player);
		this.stall = stall;
	}

	public Stall getStall() {
		return stall;
	}

}
