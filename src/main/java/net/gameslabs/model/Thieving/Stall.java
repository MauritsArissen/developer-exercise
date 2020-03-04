package net.gameslabs.model.Thieving;

public enum Stall {
	TEA("tea", 8001, 1, 5, 10),
	CAKE("cake", 8002, 2, 10, 20),
	FRUIT("fruit", 8003, 3, 15, 30),
	GEM("gem", 8004, 4, 20, 40);
	
	private final String name;
	private final int playerItemId;
	private final int levelReq;
	private final int expDrop;
	private final int failPercentage;
	
	private Stall(String name, int playerItemId, int levelReq, int expDrop, int failPercentage) {
		this.name = name;
		this.playerItemId = playerItemId;
		this.levelReq = levelReq;
		this.expDrop = expDrop;
		this.failPercentage = failPercentage;
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
	
	public int getFailPercentage() {
		return failPercentage;
	}
}
