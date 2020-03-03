package assignment.components;

import net.gameslabs.api.Component;
import net.gameslabs.api.Player;
import net.gameslabs.events.GetPlayerLevel;
import net.gameslabs.events.GiveItemEvent;
import net.gameslabs.events.GiveXpEvent;
import net.gameslabs.events.MiningEvent;
import net.gameslabs.model.Ore;
import net.gameslabs.model.Skill;

public class MyMiningComponent extends Component {

	@Override
	public void onLoad() {
		registerEvent(MiningEvent.class, this::onMining);
	}
	
	public void onMining(MiningEvent event) {
		Player player = event.getPlayer();
		Ore ore = event.getOre();
		
		GetPlayerLevel getPlayerLevel = new GetPlayerLevel(player, Skill.MINING);
		send(getPlayerLevel);
		
		if (getPlayerLevel.getLevel() < ore.getLevelReq()) {
			event.setCancelled(true);
			return;
		}
		
		send(new GiveXpEvent(player, Skill.MINING, ore.getExpDrop()));
		send(new GiveItemEvent(player, ore.getPlayerItemId(), 1));
	}

	@Override
	public void onUnload() {
		// TODO Auto-generated method stub
		
	}

}
