package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {

	static String nullString = null;
	static Contact globalTestContact = new Contact(
			"21", 
			"Aaron", 
			"Rodgers", 
			"1234567890", 
			"30 Skeleton Key");
	
	@Test
	void contactNullArguments() {
		// id 
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(nullString, "Aaron", "Rodgers", "1234567890", "30 Skeleton Key");
		});
		
		// first name
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("21", nullString, "Rodgers", "1234567890", "30 Skeleton Key");
		});
		
		// last name
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("21", "Aaron", nullString, "1234567890", "30 Skeleton Key");
		});
		
		// number
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("21", "Aaron", "Rodgers", nullString, "30 Skeleton Key");
		});
		
		// address
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("21", "Aaron", "Rodgers", "1234567890", nullString);
		});
		
	}
	
	@Test
	void contactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789010", "Aaron", "Rodgers", "1234567890", "30 Skeleton Key");
		});
	}
	
	@Test
	void contactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("21", "AAAAAAAAAAron", "Rodgers", "1234567890", "30 Skeleton Key");
		});
	}
	
	@Test
	void contactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("21", "Aaron", "RRRRRRRRRRodgers", "1234567890", "30 Skeleton Key");
		});
	}
	
	@Test 
	void contactNumberWrongLength(){
		// less than 10 digits
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("21", "Aaron", "Rodgers", "123", "30 Skeleton Key");
		});
		
		// more than 10 digits
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("21", "Aaron", "Rodgers", "12345678900000", "30 Skeleton Key");
		});
	}
	
	@Test
	void contactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("21", "Aaron", "Rodgers", "1234567890", "30 Skeleton Key rjgvhdvjsrfgbwrgfbvrghi");
		});
	}
	
	@Test
	void contactIDGetter() {
		Contact testContact = new Contact("21", "Aaron", "Rodgers", "1234567890", "30 Skeleton Key");
		assertEquals("21", testContact.getID());
	}
	
	@Test 
	void contactFirstNameGetter() {
		assertEquals("Aaron", globalTestContact.getFirstName());
	}
	
	@Test
	void contactLastNameGetter() {
		assertEquals("Rodgers", globalTestContact.getLastName());
	}
	
	@Test
	void contactNumberGetter() {
		assertEquals("1234567890", globalTestContact.getNumber());
	}
	
	@Test
	void contactAddressGetter() {
		assertEquals("30 Skeleton Key", globalTestContact.getAddress());		
	}
	
	@Test 
	void contactFirstNameSetter() {
		// no error case
		Contact testContact = new Contact("21", "Aaron", "Rodgers", "1234567890", "30 Skeleton Key");
		testContact.setFirstName("Josh");
		assertEquals("Josh", testContact.getFirstName());
		
		// null case
		String nullString = null;
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setFirstName(nullString);
		});
		
		// too long case
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setFirstName("AAAAAAAAAAAAAAron");
		});
	}
	
	@Test
	void contactLastNameSetter() {
		// no error case
		Contact testContact = new Contact("21", "Aaron", "Rodgers", "1234567890", "30 Skeleton Key");
		testContact.setLastName("Allen");
		assertEquals("Allen", testContact.getLastName());
		
		// null case
		String nullString = null;
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setLastName(nullString);
		});
		
		// too long case
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setLastName("RRRRRRRRRRRRodgers");
		});
	}
	
	@Test
	void contactNumberSetter() {
		// no error case
		Contact testContact = new Contact("21", "Aaron", "Rodgers", "1234567890", "30 Skeleton Key");
		testContact.setNumber("0987654321");
		assertEquals("0987654321", testContact.getNumber());
		
		// null case
		String nullString = null;
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setNumber(nullString);
		});
		
		// too long case
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setLastName("34624624345629854245628564");
		});
	}
	
	@Test
	void contactAddressSetter() {
		// no error case
		Contact testContact = new Contact("21", "Aaron", "Rodgers", "1234567890", "30 Skeleton Key");
		testContact.setAddress("7779 Phantom Drive");
		assertEquals("7779 Phantom Drive", testContact.getAddress());
		
		// null case
		String nullString = null;
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setAddress(nullString);
		});
		
		// too long case
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setAddress("edqgqbhwrferjgqwrefkervbrwrwevrwbfvgwvrwhivrihifh");
		});
	}
	
}















