package shopmenu;

public class Upgrade {
	
	private int multiple;
	private int cost;
	private String desc;
	
	public Upgrade(int multiple, int cost, String desc) {
		this.multiple = multiple;
		this.cost = cost;
		this.desc = desc;
	}
	
	public int getMultiple() {
		return multiple;
	}

	public int getCost() {
		return cost;
	}

	public String getDesc() {
		return desc;
	}
}
