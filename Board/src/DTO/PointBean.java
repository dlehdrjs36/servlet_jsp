package DTO;

public class PointBean {

	private String id;
	private int total_point;
	private int save;
	private int use;
	
	public PointBean() {
		
	}  	
	public PointBean( String id, int total_point, int save, int use) {
		this.id = id;
		this.total_point = total_point;
		this.save = save;
		this.use = use;
	}	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTotal_point() {
		return total_point;
	}
	public void setTotal_point(int total_point) {
		this.total_point = total_point;
	}
	public int getSave() {
		return save;
	}
	public void setSave(int save) {
		this.save = save;
	}
	public int getUse() {
		return use;
	}
	public void setUse(int use) {
		this.use = use;
	}
	
}
