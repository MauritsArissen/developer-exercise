package net.gameslabs.model.Mining;

public enum Ore {
	TIN("tin", 9001, 1, 4),
	COPPER("copper", 9002, 1, 4),
	IRON("iron", 9003, 3, 10),
	COAL("coal", 9004, 5, 20);
	
	private final String name;
	private final int playerItemId;
	private final int levelReq;
	private final int expDrop;
	
	private Ore(String name, int playerItemId, int levelReq, int expDrop) {
		this.name = name;
		this.playerItemId = playerItemId;
		this.levelReq = levelReq;
		this.expDrop = expDrop;
	}

	public String getName() {
		return name;
	}

	public int getPlayerItemId() {
		return playerItemId;
	}

	public int getLevelReq() {
		return levelReq;
	}

	public int getExpDrop() {
		return expDrop;
	}
	
}
