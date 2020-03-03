package net.gameslabs.events;

import net.gameslabs.api.Player;
import net.gameslabs.api.PlayerEvent;
import net.gameslabs.model.Skill;

public class GetPlayerXp extends PlayerEvent {
    private final Skill skill;
    private int xp;

    public GetPlayerXp(Player player, Skill skill) {
        super(player);
        this.skill = skill;
    }

    public Skill getSkill() {
        return skill;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
