package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

	static Contact[] globalContacts = {
			new Contact("1", "Arron", "Rodgers", "1234567890", "1 Packers Drive"),
			new Contact("2", "Josh", "Allen", "0987654321", "2 Bills Drive"),
			new Contact("3", "Joe", "Buck", "1111111111", "3 NBC Drive")
		};
	
	
	@Test
	void contactServiceAddContacts() {
		// normal case
		ContactService service = new ContactService();
		service.addContact("1", "Arron", "Rodgers", "1234567890", "1 Packers Drive");
		Contact[] returned = service.getContacts();
		assertEquals(1, returned.length);
		assertEquals(returned[0].getID(), globalContacts[0].getID());
		
		// error adding existing contact to array
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("1", "Arron", "Rodgers", "1234567890", "1 Packers Drive");
		});
	}
	
	@Test 
	void contactServiceDeleteContacts(){
		// Pre-existing contacts case
		// build contacts list
		ContactService service = new ContactService();
		service.addContact("1", "Arron", "Rodgers", "1234567890", "1 Packers Drive");
		service.addContact("2", "Josh", "Allen", "0987654321", "2 Bills Drive");
		service.addContact("3", "Joe", "Buck", "1111111111", "3 NBC Drive");
		service.addContact("4", "Troy", "Aikman", "2222222222", "4 NBC Drive");
		Contact[] returned = service.getContacts();
		assertEquals(4, returned.length);
		// delete contact
		service.deleteContact("2");
		returned = service.getContacts();
		// check length
		assertEquals(3, returned.length);
		// check contacts
		assertEquals("1", returned[0].getID());
		assertEquals("3", returned[1].getID());
		assertEquals("4", returned[2].getID());
		// one last loop through check
		for (int i = 0; i < returned.length; i++) {
			if (returned[i].getID().equals("2")) {
				fail("Element was not deleted");
			}
		}
		
		// No pre-existing (empty) contacts
		service = new ContactService();
		service.deleteContact("2");
		// this should essentially do nothing
		// and is included for code coverage
	}
	
	@Test
	void contactServiceUpdateFirstName() {
		// build a contact
		ContactService service = new ContactService();
		service.addContact("1", "Arron", "Rodgers", "1234567890", "1 Packers Drive");
		service.addContact("2", "Josh", "Allen", "0987654321", "2 Bills Drive");
		// update field
		service.updateFirstName("1", "Apple");
		Contact[] returned = service.getContacts();
		assertEquals("Apple", returned[0].getFirstName());
	}
	
	@Test
	void contactServiceUpdateLastName() {
		// build a contact
		ContactService service = new ContactService();
		service.addContact("1", "Arron", "Rodgers", "1234567890", "1 Packers Drive");
		service.addContact("2", "Josh", "Allen", "0987654321", "2 Bills Drive");
		// update field
		service.updateLastName("1", "Sauce");
		Contact[] returned = service.getContacts();
		assertEquals("Sauce", returned[0].getLastName());
	}

	@Test
	void contactServiceUpdateNumber() {
		// build a contact
		ContactService service = new ContactService();
		service.addContact("1", "Arron", "Rodgers", "1234567890", "1 Packers Drive");
		service.addContact("2", "Josh", "Allen", "0987654321", "2 Bills Drive");
		// update field
		service.updateNumber("1", "1111111111");
		Contact[] returned = service.getContacts();
		assertEquals("1111111111", returned[0].getNumber());
	}
	
	@Test
	void contactServiceUpdateAddress() {
		// build a contact
		ContactService service = new ContactService();
		service.addContact("1", "Arron", "Rodgers", "1234567890", "1 Packers Drive");
		service.addContact("2", "Josh", "Allen", "0987654321", "2 Bills Drive");
		// update field
		service.updateAddress("1", "123 State Farm Court");
		Contact[] returned = service.getContacts();
		assertEquals("123 State Farm Court", returned[0].getAddress());
	}
	
}
