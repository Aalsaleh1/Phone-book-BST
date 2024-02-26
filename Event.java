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
public class Event implements Comparable<Event>{
	private String title , dateTime , location;
	private LinkedList_ADT<Contact> eventContacts;
	
	
	
	
	
	public Event(String title, String dateTime, String location, LinkedList_ADT<Contact> eventContacts) {//4 bigO(1)
		this.title = title;//1
		this.dateTime = dateTime;//1
		this.location = location;//1
		this.eventContacts = eventContacts;//1
	}
	public String getTitle() {//1 BigO(1)
		return title;//1
	}
	public void setTitle(String title) {//1 bigO(1)
		this.title = title;//1
	}
	
	public String getDate() {//1 bigO(1)
		return dateTime;//1
	}
	public void setDate(String dateTime) {//1 bigO(1)
		this.dateTime = dateTime;//1
	}
	public String getLocation() {//1 bigO(1)
		return location;//1
	}
	public void setLocation(String location) {//1 bigO(1)
		this.location = location;//1
	}
	public LinkedList_ADT<Contact> geteventContacts() {//1 bigO(1)
		return eventContacts;//1
	}
	public void seteventContacts(LinkedList_ADT<Contact> eventContacts) {//1 BigO(1)
		this.eventContacts = eventContacts;//1
	}
	@Override
	public int compareTo(Event o) {//1 bigO(1)
		return this.title.compareToIgnoreCase(o.title);//1
	}
	public int compareTo(Appointment o) {//1 bigO(1)
		return this.title.compareToIgnoreCase(o.getTitle());//1
	}
	
	@Override
	public String toString() {//1+1  BigO(1)
		String event = "Event Title: " + title + "\nDate_Time: " + dateTime + "\nLocation: " + location+ "\nContacts:";
		String contact = "";
		eventContacts.findfirst();
		while(!eventContacts.last()) {
			contact += " " +eventContacts.retreive().getContactName() +" ,";//1 for getContactName
			eventContacts.findnext();
		}
		contact += " " +eventContacts.retreive().getContactName();//1 for getContactName
		
		return event + contact;
		
		//1
	}
	
	
}