/*
 * Mike Sabeiha
 * SNHU CS320
 * Module 6
 * 20241208
 * 
 * */

package ContServ;
import java.util.UUID;

public class Contact {
	
	//attributes for each contact
	private String uniqID;
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String contAddress;
	
	//input driven constructor
	public Contact(String firstName, String lastName, String phoneNum, String contAddress) {	
		UUID uuid = UUID.randomUUID();
		this.uniqID = uuid.toString().substring(0,10);
		
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid Name");
		}
		else {this.firstName = firstName;}
		
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Name");
		}
		else {this.lastName = lastName;}
		
		if(phoneNum == null || phoneNum.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone");
		}
		else {this.phoneNum = phoneNum;}
		
		if(contAddress == null || contAddress.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		else {this.contAddress = contAddress;}

	}
	
	//getter for uniqID
	public String getUniqID() {return this.uniqID;}
	
	//setter getter for firstName
	public void setFirstName(String x) {
		if(x == null || x.length() > 10) {
			System.out.println("Invalid Name");
			throw new IllegalArgumentException("Invalid Name");
		}
		else {this.firstName = x;}}
	public String getFirstName() {return this.firstName;}
	
	//setter getter for lastName
	public void setLastName(String x) {
		if(x == null || x.length() > 10) {
			System.out.println("Invalid Name");
			throw new IllegalArgumentException("Invalid Name");
		}
		else {this.lastName = x;}}
	public String getLastName() {return this.lastName;}
	
	//setter getter for phoneNum
	public void setPhoneNum(String x) {
		if(x == null || x.length() != 10) {
			System.out.println("Phone");
			throw new IllegalArgumentException("Invalid Phone");
		}
		else {this.phoneNum = x;}}
	public String getPhoneNum() {return this.phoneNum;}

	//setter getter for contAddress
	public void setContAddress(String x) {
		if(x == null || x.length() > 30) {
			System.out.println("Invalid Address");
			throw new IllegalArgumentException("Invalid Address");
		}
		else {this.contAddress = x;}}
	public String getContAddress() {return this.contAddress;}

}
