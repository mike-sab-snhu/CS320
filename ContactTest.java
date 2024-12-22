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

class ContactTest {

	@Test
	//test to see if contacts are created properly
	void testContactCreate() {
		
		//creating test contact within limitations
		Contact testContact = new Contact("Saul", "Goodman", "1234567899", "123 Main Road, Albuquerque, NM");
		
		//testing to see if object is created as intended
		assertTrue(testContact.getUniqID().length() == 10);
		assertTrue(testContact.getFirstName().equals("Saul"));
		assertTrue(testContact.getLastName().equals("Goodman"));
		assertTrue(testContact.getPhoneNum().equals("1234567899"));
		assertTrue(testContact.getContAddress().equals("123 Main Road, Albuquerque, NM"));
	
		//testing to see if object attributes can be set
		Assertions.assertAll(() -> {
			testContact.setFirstName("Saulito");
			testContact.setLastName("Guzman");
			testContact.setPhoneNum("1234567899");
			testContact.setContAddress("123 Main Road, Albuquerque, NM");
		});
		
		//testing setters to account for branches
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setFirstName("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setFirstName(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setLastName("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setLastName(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setPhoneNum("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setPhoneNum(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setContAddress("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setContAddress(null);
		});
	}
	
	@Test
	//testing to see if exceptions are thrown for bad first name
	void testContactBadCreateFirstName() {
		
		//testing to see if exception is thrown
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact testContact = new Contact("SaulXXXXXXXXXXXX", "Goodman", "1234567899", "123 Main Road, Albuquerque, NM");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact testContact = new Contact(null, "Goodman", "1234567899", "123 Main Road, Albuquerque, NM");
		});
	}

	@Test
	//testing to see if exceptions are thrown for bad last name
	void testContactBadCreateLastName() {

		//testing to see if exception is thrown
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact testContact = new Contact("Saul", "GoodmanXXXXXXXXXXX", "1234567899", "123 Main Road, Albuquerque, NM");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact testContact = new Contact("Saul", null, "1234567899", "123 Main Road, Albuquerque, NM");
		});
	}
	
	@Test
	//testing to see if exceptions are thrown for bad phone number
	void testContactBadCreatePhone() {

		//testing to see if exception is thrown
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact testContact = new Contact("Saul", "Goodman", "1234567899XXXX", "123 Main Road, Albuquerque, NM");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact testContact = new Contact("Saul", "Goodman", null, "123 Main Road, Albuquerque, NM");
		});
	}
	
	@Test
	//testing to see if exceptions are thrown for bad address
	void testContactBadCreateAddress() {

		//testing to see if exception is thrown
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact testContact = new Contact("Saul", "Goodman", "1234567899", "123 Main Road, Albuquerque, NM XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact testContact = new Contact("Saul", "Goodman", "1234567899", null);
		});
	}
	
}
