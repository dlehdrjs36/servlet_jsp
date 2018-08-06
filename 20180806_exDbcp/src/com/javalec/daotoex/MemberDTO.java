package com.javalec.daotoex;
// 부르는 빈도  3.DTO = 1.data bean = 2.VO객체 : 클래스 멤버변수,[생성자]없어도됨 ,getter,setter 정도만 있어야함. 행위(동작)은 있어서는 안됨. 


//dto는 보통(Spring: VO객체 or 현업:데이타 빈)으로 부름. dto는 잘사용안하는 단어.  
// member만 정의되어 있음. getter, setter 필요. 레코드를  Arraylist<DTO타입> 으로 담아서 사용함.
// VO객체는 DAO가 이용함. DTO(VO) 스스로가 이용하는것은 아님.
public class MemberDTO {

	private String name;
	private String id;
	private String pw;
	private String phone1;
	private String phone2;
	private String phone3;
	private String gender;
	
	// null(비어있는) 생성자. 갯수가 몇개든지 처리가능. 비어있는생성자는 만들어 놓는것이 좋다. 보통 비어있는 생성자 하나만 만듬.
	public MemberDTO() {
		
	}
	//생성자
	public MemberDTO(String name, String id, String pw, String phone1, String phone2, String phone3, String gender) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
