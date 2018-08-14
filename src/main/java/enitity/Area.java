package enitity;

public class Area {

	private int id;
	private String name;
	private int areaLevel;
	private int parent_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAreaLevel() {
		return areaLevel;
	}
	public void setAreaLevel(int areaLevel) {
		this.areaLevel = areaLevel;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public Area(int id, String name, int areaLevel, int parent_id) {
		super();
		this.id = id;
		this.name = name;
		this.areaLevel = areaLevel;
		this.parent_id = parent_id;
	}
	public Area() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Area [id=" + id + ", name=" + name + ", areaLevel=" + areaLevel + ", parent_id=" + parent_id + "]\n";
	}
	
	
}
