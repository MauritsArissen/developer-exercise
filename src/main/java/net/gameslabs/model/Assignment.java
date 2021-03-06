package net.gameslabs.model;

import java.util.Arrays;

import net.gameslabs.api.Component;
import net.gameslabs.api.ComponentRegistry;
import net.gameslabs.api.Player;
import net.gameslabs.components.ChartComponent;
import net.gameslabs.events.GetPlayerLevel;
import net.gameslabs.events.GetPlayerXp;
import net.gameslabs.events.GiveItemEvent;
import net.gameslabs.events.GiveXpEvent;
import net.gameslabs.events.MiningEvent;
import net.gameslabs.events.RemoveItemEvent;
import net.gameslabs.events.ThievingEvent;
import net.gameslabs.implem.PlayerImplem;
import net.gameslabs.model.Mining.Ore;
import net.gameslabs.model.Thieving.Stall;

public class Assignment {

    protected final ComponentRegistry registry;
    private final Player mainPlayer;

    public Assignment(Component ... myComponentsToAdd) {
        registry = new ComponentRegistry();
        Arrays.asList(myComponentsToAdd).forEach(registry::registerComponent);
        registry.registerComponent(new ChartComponent());
        registry.load();
        mainPlayer = PlayerImplem.newPlayer("MyPlayer");
    }

    public final void run() {
    	// Give base xp mainPlayer skills
        registry.sendEvent(new GiveXpEvent(mainPlayer, Skill.CONSTRUCTION, 25));
        registry.sendEvent(new GiveXpEvent(mainPlayer, Skill.EXPLORATION, 25));
        registry.sendEvent(new GiveXpEvent(mainPlayer, Skill.MINING, 25));
        registry.sendEvent(new GiveXpEvent(mainPlayer, Skill.THIEVING, 25));
        
        // Run events for the inventory component assignment
        registry.sendEvent(new GiveItemEvent(mainPlayer, 1, 30));
        registry.sendEvent(new GiveItemEvent(mainPlayer, 1, 22));
        registry.sendEvent(new GiveItemEvent(mainPlayer, 54, 1));
        registry.sendEvent(new GiveItemEvent(mainPlayer, 33, 213));
        registry.sendEvent(new GiveItemEvent(mainPlayer, 78, 3));
        registry.sendEvent(new GiveItemEvent(mainPlayer, 78, 1));
        registry.sendEvent(new RemoveItemEvent(mainPlayer, 33, 13));
        registry.sendEvent(new RemoveItemEvent(mainPlayer, 78, 2));
        
        // Run events for the mining component assignment
        registry.sendEvent(new MiningEvent(mainPlayer, Ore.TIN));
        registry.sendEvent(new MiningEvent(mainPlayer, Ore.TIN));
        registry.sendEvent(new MiningEvent(mainPlayer, Ore.TIN));
        registry.sendEvent(new MiningEvent(mainPlayer, Ore.TIN));
        registry.sendEvent(new MiningEvent(mainPlayer, Ore.TIN));
        registry.sendEvent(new MiningEvent(mainPlayer, Ore.TIN));
        registry.sendEvent(new MiningEvent(mainPlayer, Ore.TIN));
        registry.sendEvent(new MiningEvent(mainPlayer, Ore.TIN));
        registry.sendEvent(new MiningEvent(mainPlayer, Ore.TIN));
        registry.sendEvent(new MiningEvent(mainPlayer, Ore.TIN));
        registry.sendEvent(new MiningEvent(mainPlayer, Ore.COAL));
        
        // Run events for the bonus thieving component assignment
        registry.sendEvent(new ThievingEvent(mainPlayer, Stall.TEA));
        registry.sendEvent(new ThievingEvent(mainPlayer, Stall.TEA));
        registry.sendEvent(new ThievingEvent(mainPlayer, Stall.TEA));
        registry.sendEvent(new ThievingEvent(mainPlayer, Stall.TEA));
        registry.sendEvent(new ThievingEvent(mainPlayer, Stall.TEA));
        registry.sendEvent(new ThievingEvent(mainPlayer, Stall.TEA));
        registry.sendEvent(new ThievingEvent(mainPlayer, Stall.TEA));
        registry.sendEvent(new ThievingEvent(mainPlayer, Stall.TEA));
        registry.sendEvent(new ThievingEvent(mainPlayer, Stall.TEA));
        registry.sendEvent(new ThievingEvent(mainPlayer, Stall.TEA));
        registry.sendEvent(new ThievingEvent(mainPlayer, Stall.TEA));
        registry.sendEvent(new ThievingEvent(mainPlayer, Stall.TEA));
        registry.sendEvent(new ThievingEvent(mainPlayer, Stall.CAKE));
        registry.sendEvent(new ThievingEvent(mainPlayer, Stall.CAKE));
        registry.sendEvent(new ThievingEvent(mainPlayer, Stall.CAKE));
        registry.sendEvent(new ThievingEvent(mainPlayer, Stall.CAKE));
        registry.sendEvent(new ThievingEvent(mainPlayer, Stall.CAKE));
        registry.sendEvent(new ThievingEvent(mainPlayer, Stall.CAKE));
        registry.sendEvent(new ThievingEvent(mainPlayer, Stall.CAKE));
        registry.sendEvent(new ThievingEvent(mainPlayer, Stall.CAKE));
        registry.sendEvent(new ThievingEvent(mainPlayer, Stall.FRUIT));
        registry.sendEvent(new ThievingEvent(mainPlayer, Stall.FRUIT));
        registry.sendEvent(new ThievingEvent(mainPlayer, Stall.FRUIT));
        registry.sendEvent(new ThievingEvent(mainPlayer, Stall.FRUIT));
        
        GetPlayerLevel getPlayerLevel = new GetPlayerLevel(mainPlayer, Skill.CONSTRUCTION);
        log("Player level", mainPlayer, getPlayerLevel.getLevel());
        runChecks();
        registry.unload();
    }

    private void runChecks() {
    	if (getLevel(mainPlayer, Skill.EXPLORATION) != 1) throw new AssignmentFailed("Exploration XP should be set to level 1");
    	if (getLevel(mainPlayer, Skill.MINING) != 2) throw new AssignmentFailed("Mining XP should be set to level 2");
    	if (getLevel(mainPlayer, Skill.CONSTRUCTION) != 2) throw new AssignmentFailed("Construction XP should be set to level 2");
        if (getXp(mainPlayer, Skill.MINING) != 65) throw new AssignmentFailed("Mining XP should be 65 xp");
        if (!mainPlayer.getInventory().hasItemAmount(1, 52)) throw new AssignmentFailed("The mainPlayer should have the item with id 1 and an amount of 52");
        if (!mainPlayer.getInventory().hasItemAmount(54, 1)) throw new AssignmentFailed("The mainPlayer should have the item with id 54 and an amount of 1");
        if (!mainPlayer.getInventory().hasItemAmount(33, 200)) throw new AssignmentFailed("The mainPlayer should have the item with id 33 and an amount of 200");
        if (!mainPlayer.getInventory().hasItemAmount(78, 2)) throw new AssignmentFailed("The mainPlayer should have the item with id 78 and an amount of 2");
        if (!mainPlayer.getInventory().hasItemAmount(9001, 10)) throw new AssignmentFailed("The mainPlayer should have the item with id 9001 and an amount of 10");
        if (mainPlayer.getInventory().hasItem(9004)) throw new AssignmentFailed("The mainPlayer can't have item 9004 since his mining level isn't 5");
        
        // Displays for thieving component
        System.out.println(String.format("Amount of tea: %s", mainPlayer.getInventory().getItem(8001).getAmount()));
        System.out.println(String.format("Amount of cake: %s", mainPlayer.getInventory().getItem(8002).getAmount()));
        System.out.println(String.format("Amount of fruit: %s", mainPlayer.getInventory().getItem(8003).getAmount()));
        System.out.println(String.format("Thieving - Level: %s - Xp: %s", getLevel(mainPlayer, Skill.THIEVING), getXp(mainPlayer, Skill.THIEVING)));
    }

    private int getLevel(Player player, Skill skill) {
        GetPlayerLevel getPlayerLevel = new GetPlayerLevel(mainPlayer, skill);
        registry.sendEvent(getPlayerLevel);
        return getPlayerLevel.getLevel();
    }
    
    private int getXp(Player player, Skill skill) {
    	GetPlayerXp getPlayerXp = new GetPlayerXp(mainPlayer, skill);
    	registry.sendEvent(getPlayerXp);
    	return getPlayerXp.getXp();
    }

    public void log(Object ... arguments) {
        System.out.println(Arrays.asList(arguments).toString());
    }
}
