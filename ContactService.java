/*
 * Mike Sabeiha
 * SNHU CS320
 * Module 6
 * 20241208
 * 
 * */

package ContServ;
import java.util.ArrayList;

public class ContactService {
	
	//creates list to store contacts
	public static ArrayList<Contact> listContacts = new ArrayList<Contact>();
	
	//lists all contacts based on their uniqID
	public static void ShowContact() {
		long sizeList = listContacts.size();
		String temp = null;
		
		//for loop
		for(int i = 0; i < sizeList; i++) {
			temp = listContacts.get(i).getUniqID();
			System.out.println(temp);
		}
	}
	
	//new contact method
	public static void NewContact(String fn, String ln, String pn, String ad) {
		
		//new instance
		Contact newContact = new Contact(fn, ln, pn, ad);
		
		//object added to list
		listContacts.add(newContact);
		
		//success message printed
		System.out.println("New contact created with Unique ID:");
		System.out.println(newContact.getUniqID());
		return;
	}
	
	//update method
	public static void UpdateContact(String x, String option, String update) {
		Contact temp = null; //temp contact object
		long sizeList = listContacts.size(); //size gauge
		
		for(int i = 0; i < sizeList; i++) { //for loop
			temp = listContacts.get(i); //grabs the next object in the list
			if (temp.getUniqID().equals(x)) { //if it's a match for user input
				
				//print found message for convenience
				System.out.println("Contact Found.  Updating...");
				
				//update based on which option user entered
				if (option == "first") {temp.setFirstName(update);}
				if (option == "last") {temp.setLastName(update);}
				if (option == "number") {temp.setPhoneNum(update);}
				if (option == "address") {temp.setContAddress(update);}
				
				//if the made a mistake, let them know
				else {System.out.println("Option not found");}
			}
		}
	}
	
	//method to delete contacts based on uniqID
	public static void DelContact(String x) {
		long sizeList = listContacts.size(); //size gauge
		
		for(int i = 0; i < sizeList; i++) { //for loop
			if (listContacts.get(i).getUniqID().equals(x)) { //if it's a match for user input
				
				//print found message for convenience
				System.out.println("Contact Found.  Deleting...");
				
				//delete object at location in list
				listContacts.remove(i);
				break;
			}
				//if the made a mistake, let them know
			else {System.out.println("Option not found");}
		}
	}
	
	
}
