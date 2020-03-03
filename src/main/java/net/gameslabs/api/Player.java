package net.gameslabs.api;

import net.gameslabs.model.Item.PlayerInventory;

public interface Player {
    String getId();
    String getName();
    PlayerInventory getInventory();
}
