package point.dto;


import java.sql.Timestamp;

public class PointHistoryDto{

	private String id;
	private int point;
	private int flag;
	private Timestamp p_date;
	
	public PointHistoryDto() {
		 
	} 
	
	public PointHistoryDto(String id, int point, int flag, Timestamp p_date) {
		this.id = id;
		this.point = point;
		this.flag = flag;
		this.p_date = p_date;
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

	public Timestamp getP_date() {
		return p_date;
	}

	public void setP_date(Timestamp p_date) {
		this.p_date = p_date;
	}
	
}
