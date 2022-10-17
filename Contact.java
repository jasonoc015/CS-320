package contact;

public class Contact {
	private String id;
	private String firstName;
	private String lastName;
	private String number;
	private String address;
	
	public Contact(String id, String firstName, String lastName, String number, String address) {
		if (id == null || id.length() >= 10) {
			throw new IllegalArgumentException("Invalid id");
		}
		if (firstName == null || firstName.length() >= 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if (lastName == null || lastName.length() >= 10) {
			throw new IllegalArgumentException("Invali last name");
		}
		if (number == null || number.length() != 10) {
			throw new IllegalArgumentException("Invalid number number");
		}
		if (address == null || address.length() >= 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.address = address;
	}
	
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() >= 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() >= 10) {
			throw new IllegalArgumentException("Invali last name");
		}
		this.lastName = lastName;		
	}
	
	public void setNumber(String number) {
		if (number == null || number.length() != 10) {
			throw new IllegalArgumentException("Invalid number number");
		}
		this.number = number;
	}
	
	public void setAddress(String address) {
		if (address == null || address.length() >= 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		this.address = address;
	}
	
	public String getID() {
		return this.id;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public String getAddress() {
		return this.address;
	}
}
