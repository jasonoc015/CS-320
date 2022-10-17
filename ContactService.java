package contact;

public class ContactService {
	private Contact[] contacts = {};
	
	public ContactService() {
		
	}
	
	public Contact[] getContacts() {
		return contacts;
	}
	
	public void addContact(String id, String firstName, String lastName, String number, String address) {
		// loop through the contacts array
		for (int i = 0; i < contacts.length; i++) {
			// find any id's that match the one passed in
			if (contacts[i].getID().equals(id)) {
				// can't have 2 contacts with matching id's
				throw new IllegalArgumentException("Invalid ID: one already exists");
			}
		}
		// create a new contact
		Contact newContact = new Contact(id, firstName, lastName, number, address);
		
		// create a copy array
		Contact[] copyContacts = new Contact[contacts.length+1];
		
		//add the elements of the contacts array to the copy array
		for (int j = 0; j < contacts.length; j++) {
			copyContacts[j] = contacts[j];
		}
		
		// add the new contact to the copy contacts
		copyContacts[copyContacts.length-1] = newContact;
		
		// set the contacts array to the copyContacts array
		contacts = copyContacts;
	}
	
	public void deleteContact(String id) {
		// loop through the contacts array 
		for(int i = 0; i < contacts.length; i++) {
			if (contacts[i].getID().equals(id)) {
				// create a new array with length 1 less than contacts
				Contact[] copyContacts = new Contact[contacts.length-1];
				// copy the contacts (except the deleted contact) to new array
				int k = 0;
				for (int j = 0; j < contacts.length; j++) {
				    if (j != i) {
				        copyContacts[k++] = contacts[j];
				    }
				}
				// set contacts to the new array
				contacts = copyContacts;
				// exit
				return;
			}
		}
	}
	
	public void updateFirstName(String id, String firstName) {
		// loop through the contacts array
		for (int i = 0; i < contacts.length; i++) {
			// find the contact with matching id
			if (contacts[i].getID().equals(id)) {
				// update the field
				contacts[i].setFirstName(firstName);
			}
		}
	}
	
	public void updateLastName(String id, String lastName) {
		// loop through the contacts array
		for (int i = 0; i < contacts.length; i++) {
			// find the contact with matching id
			if (contacts[i].getID().equals(id)) {
				// update the field
				contacts[i].setLastName(lastName);
			}
		}
	}
	
	public void updateNumber(String id, String number) {
		// loop through the contacts array
		for (int i = 0; i < contacts.length; i++) {
			// find the contact with matching id
			if (contacts[i].getID().equals(id)) {
				// update the field
				contacts[i].setNumber(number);
			}
		}
	}
	
	public void updateAddress(String id, String address) {
		// loop through the contacts array
		for (int i = 0; i < contacts.length; i++) {
			// find the contact with matching id
			if (contacts[i].getID().equals(id)) {
				// update the field
				contacts[i].setAddress(address);
			}
		}
	}
	
}
