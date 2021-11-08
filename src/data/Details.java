package data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Details {

	private String firstName;
	private String middleName;
	private String lastName;
	private String prefix;
	private String street;
	private String apt;
	private String city;
	private String zip;
	private String dob;

	public Details(String firstName, String middleName, String lastName, String prefix, String street, String apt,
			String city, String zip, String dob) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.prefix = prefix;
		this.street = street;
		this.apt = apt;
		this.city = city;
		this.zip = zip;
		this.dob = dob;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPrefix() {
		return prefix;
	}
	public String getStreet() {
		return street;
	}
	public String getApt() {
		return apt;
	}
	public String getCity() {
		return city;
	}
	public String getZip() {
		return zip;
	}
	public String getDob() {
		return dob;
	}
	public String getTodaysDate() {
		return getDate();
	}

	public String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		return dateFormat.format(new Date());
	}
}
