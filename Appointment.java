/*************Information***************
CLASS: BST.java
CSC212 Data structures - Project phase II
Fall 2023
EDIT DATE:
3-12-2023
TEAM:

AUTHORS:

Abdulaziz Alsaleh 

****************************************/
public class Appointment implements Comparable<Appointment>{
	private String title, date,location;

	private Contact appointmentContact;
	
	
	
	
	public Appointment() {
		
	}
	public Appointment(String title, String date, String location, Contact appointmentContact) {//4 bigO(1)
		this.title = title;//1
		this.date = date;//1
		this.location = location;//1
		this.appointmentContact = appointmentContact;//1
	}
	public String getTitle() {//1 BigO(1)
		return title;//1
	}
	public void setTitle(String title) {//1 bigO(1)
		this.title = title;//1
	}
	
	public String getDate() {//1 bigO(1)
		return date;//1
	}
	public void setDate_Time(String date) {//1 bigO(1)
		this.date = date;//1
	}
	public String getLocation() {//1 bigO(1)
		return location;//1
	}
	public void setLocation(String location) {//1 bigO(1)
		this.location = location;//1
	}
	public Contact getContactinvolved() {//1 bigO(1)
		return appointmentContact;//1
	}
	public void setContactinvolved(Contact contact) {//1 BigO(1)
		this.appointmentContact = contact;//1
	}
	@Override
	public int compareTo(Appointment o) {//1 bigO(1)
		return title.compareTo(o.title);//1
	}
	
	@Override
	public String toString() {//1+1  BigO(1)
		return "Appointment Title: " + title + "\nDateandTime: " + date + "\nLocation: " + location + "\nContact:"
				+ appointmentContact.getContactName();//1 for getContactName
		//1
	}
	
	
}