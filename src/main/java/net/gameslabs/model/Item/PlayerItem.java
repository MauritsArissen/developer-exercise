package net.gameslabs.model.Item;

public class PlayerItem {
	
	private int id;
	private int amount;
	
	public PlayerItem(int id, int amount) {
		this.id = id;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return String.format("PlayerItem{id:%s,amount:%s}", getId(), getAmount());
	}

}
