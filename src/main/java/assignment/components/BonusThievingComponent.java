package assignment.components;

import net.gameslabs.api.Component;
import net.gameslabs.api.Player;
import net.gameslabs.events.GetPlayerLevel;
import net.gameslabs.events.GiveItemEvent;
import net.gameslabs.events.GiveXpEvent;
import net.gameslabs.events.ThievingEvent;
import net.gameslabs.model.Skill;
import net.gameslabs.model.Thieving.Stall;

public class BonusThievingComponent extends Component {

	@Override
	public void onLoad() {
		registerEvent(ThievingEvent.class, this::onThieving);
	}
	
	public void onThieving(ThievingEvent event) {
		Player player = event.getPlayer();
		Stall stall = event.getStall();
		
		GetPlayerLevel getPlayerLevel = new GetPlayerLevel(player, Skill.THIEVING);
		send(getPlayerLevel);
		
		if (getPlayerLevel.getLevel() < stall.getLevelReq()) {
			event.setCancelled(true);
			return;
		}
		
		int rng = (int) Math.round(Math.random() * 100);
		if (rng <= stall.getFailPercentage()) {
			System.out.println("You've failed pickpocketing a " + stall.getName() + " stall");
			event.setCancelled(true);
			return;
		}
		
		send(new GiveXpEvent(player, Skill.THIEVING, stall.getExpDrop()));
		send(new GiveItemEvent(player, stall.getPlayerItemId(), 1));
	}

	@Override
	public void onUnload() {
		// TODO Auto-generated method stub
		
	}

}
