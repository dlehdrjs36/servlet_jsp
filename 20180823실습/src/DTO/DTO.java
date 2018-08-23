package DTO;

public class DTO {
	private String FirstName;
	private String LastName;
	
	
	public DTO() {
		
	}
	
	
	public DTO( String FirstName, String LastName)  {
		
		this.FirstName = FirstName;
		this.LastName = LastName;
	}


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	@Override
	public String toString() {
		return "DTO [FirstName=" + FirstName + ", LastName=" + LastName + "]";
	}
	
	
	
	
}
