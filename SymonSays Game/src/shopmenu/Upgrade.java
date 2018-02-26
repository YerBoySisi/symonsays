package shopmenu;

public class Upgrade {
	
	private int multiple;
	private int cost;
	private int level;
	private String desc;
	
	public Upgrade(int multiple, int cost, int level, String desc) {
		this.multiple = multiple;
		this.cost = cost;
		this.level = level;
		this.desc = desc;
	}
	
	public int getMultiple() {
		return multiple;
	}

	public int getCost() {
		return cost;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getDesc() {
		return desc;
	}
}
