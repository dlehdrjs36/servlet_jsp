package DTO;

public class PointHistoryBean {

	private String type;
	
	private String id;
	private int point;
	private int flag;
	private String p_date;
		  
	public PointHistoryBean() {
		 
	} 	
	public PointHistoryBean(String id, int point, int flag, String type, String p_date) {
		this.id = id;
		this.point = point;
		this.flag = flag;
		this.type = type;
		this.p_date = p_date;
	}	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getP_date() {
		return p_date;
	}
	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
}
