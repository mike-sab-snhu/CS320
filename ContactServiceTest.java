/*
 * Mike Sabeiha
 * SNHU CS320
 * Module 6
 * 20241208
 * 
 * */

package ContServ;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	
	@Test
	//test to add new contact to list
	void testAddNewContact() {
		ContactService.NewContact("Saul", "Goodman", "1234567899", "123 Main Road, Albuquerque, NM");
		assertTrue(ContactService.listContacts.get(0).getUniqID().length() == 10);
		assertTrue(ContactService.listContacts.get(0).getFirstName().equals("Saul"));
		assertTrue(ContactService.listContacts.get(0).getLastName().equals("Goodman"));
		assertTrue(ContactService.listContacts.get(0).getPhoneNum().equals("1234567899"));
		assertTrue(ContactService.listContacts.get(0).getContAddress().equals("123 Main Road, Albuquerque, NM"));
		assertTrue(ContactService.listContacts.size() != 0);

	}
	
	@Test
	//test to see if null additions are rejected
	void testAddBadContactsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.NewContact(null, "x", "x", "x");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.NewContact("x", null, "x", "x");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.NewContact("x", "x", null, "x");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.NewContact("x", "x", "x", null);
		});
	}
	
	@Test
	//test to see if bad additions are rejected
	void testAddBadContacts() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.NewContact("XXXXXXXXXXXXXXXXXXXXXXXX", "x", "x", "x");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.NewContact("x", "XXXXXXXXXXXXXXXXXXXXXXXXXX", "x", "x");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.NewContact("x", "x", "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "x");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.NewContact("x", "x", "x", "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		});
	}

	@Test
	//test to see if the update feature works
	void testUpdateContactInformation() {
		
		//creating a new object with known values
		ContactService.NewContact("Saul", "Goodman", "1234567899", "123 Main Road, Albuquerque, NM");
		
		//pulling the uniqID for the new object and updating information
		ContactService.UpdateContact(ContactService.listContacts.get(0).getUniqID(), "first", "Frank");
		assertTrue(ContactService.listContacts.get(0).getFirstName().equals("Frank"));
		
		ContactService.UpdateContact(ContactService.listContacts.get(0).getUniqID(), "last", "Frank");
		assertTrue(ContactService.listContacts.get(0).getLastName().equals("Frank"));
		
		ContactService.UpdateContact(ContactService.listContacts.get(0).getUniqID(), "number", "0000000000");
		assertTrue(ContactService.listContacts.get(0).getPhoneNum().equals("0000000000"));
		
		ContactService.UpdateContact(ContactService.listContacts.get(0).getUniqID(), "address", "Down the Road");
		assertTrue(ContactService.listContacts.get(0).getContAddress().equals("Down the Road"));
	}
	
	@Test
	//test to delete contacts
	void testDeleteContact() {
		
		//creating test contact just in case
		ContactService.NewContact("Frank", "Fritchard", "0000000000", "Big House on Red Street");
		String testContactUniqID = ContactService.listContacts.get(0).getUniqID();
		long beforeSize = ContactService.listContacts.size();
		
		//deleting
		ContactService.DelContact(testContactUniqID);
		long afterSize = ContactService.listContacts.size();
		
		//verifying
		assertTrue(afterSize < beforeSize);
		
	}
	
	@Test
	//test to delete contacts
	void testDeleteContactBadSpelling() {
		
		//creating test contact just in case
		ContactService.NewContact("Frank", "Fritchard", "0000000000", "Big House on Red Street");
		String testContactUniqID = ContactService.listContacts.get(0).getUniqID();
		long beforeSize = ContactService.listContacts.size();
		
		//deleting
		ContactService.DelContact("wrongID");
		long afterSize = ContactService.listContacts.size();
		
		//verifying
		assertTrue(afterSize == beforeSize);
		
	}
	
	@Test
	//test to run through contact list
	void testLoopContactList() {
		Assertions.assertNotNull(ContactService.listContacts);
		ContactService.ShowContact();
	}
	
}
