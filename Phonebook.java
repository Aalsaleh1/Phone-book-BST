import java.util.*;

public class Phonebook {
	private BST MyContactList;
	private LinkedList_ADT<Event> MyEventList;
	private LinkedList_ADT<Appointment> MyAppointmentList;
	public Scanner input = new Scanner(System.in); // check

	public Phonebook() { // big o(1) total = 2
		MyContactList = new BST();// 1
		MyEventList = new LinkedList_ADT<>();// 1
		MyAppointmentList = new LinkedList_ADT<>();
	}

	public void searchcontact() {// bigO(n) total=5n+29
		if (MyContactList.empty()) {// 1
			System.out.println("Your contact list is empty");// 1
			return;// 1
		}
		int select; // 1

		System.out.print("Enter search criteria:\r\n" + "1.Name\r\n" + "2.Phone Number\r\n" + "3.Email Address\r\n"
				+ "4.Address\r\n" + "5.Birthday\r\n" + "Enter your choice: ");// 1
		select = input.nextInt();// 1
		input.nextLine();

		switch (select) {// 1
		case 1:
			System.out.print("enter contact's name: ");// 1 finished case 1 for name
			String currentname = input.nextLine();// 1

			Contact contname = MyContactList.searchByname(currentname);// n

			if (contname != null) {// 1 // if we find the name we print the details else we break
				System.out.println("Contact found!");// 1
				System.out.println(contname.toString());// 1
			} else// 1
				System.out.print("cant find contact");// 1
			break;// 1

		case 2:
			System.out.print("enter contact's phone: "); // 1 finished case 2 which is similar to case 1
			String currentphone = input.nextLine();// 1

			Contact contphone = MyContactList.searchByphone(currentphone);// n

			if (contphone != null) {// 1 // same as case 1
				System.out.println("Contact found!");// 1
				System.out.println(contphone.toString());// 1
			} else// 1
				System.out.print("Contact not found!");// 1
			break;// 1

		case 3:
			System.out.print("enter contact's email: ");// 1
			String inputemail = input.nextLine();// 1

			MyContactList.searchByemail(inputemail);

			break;// 1

		case 4:// 1
			System.out.print("enter contact's address: ");// 1
			String currentadress = input.nextLine();// 1

			MyContactList.searchByaddress(currentadress);// n

			break;// 1
		case 5: // 1
			System.out.print("enter contact's birth: ");// 1
			String currentbirth = input.nextLine();// 1

			MyContactList.searchBybirthday(currentbirth);// n

			break;// 1
		default:// 1
			System.out.println("Invalid input");// 1
		}
	}// 
//}

	public void menu() // bigO(n^3) total=N^3+3n^2+5n+60
	{
		String select;// 1
		int run = 0;// 1
		System.out.println("Welcome to the BST Phonebook!");// 1
		while(run!=1) {
				System.out.println("\n*************************************");
				System.out.println("\nPlease choose an option:");
				System.out.println("1.Add a contact");
				System.out.println("2.Search for a contact");
				System.out.println("3.Delete a contact");
				System.out.println("4.Schedule an event");
				System.out.println("5.Print event details");
				System.out.println("6.Print contact by first name");
				System.out.println("7.Print all events alphabetically");
				System.out.println("8.Exit");
				System.out.print("\nEnter your choice: ");

				select = input.nextLine();// 1

				switch (select) {// 1
				case "1":// 1
					Contact addcontacts = addcontact();// n
					if (addcontacts != null) {// 1
						MyContactList.insert(addcontacts);// n
						System.out.println(" added successfully!");// 1

					}

					break;// 1

				case "2":
					searchcontact();// n
					break;// 1

				case "3": // 1
					if (MyContactList.empty()) // 1
					{
						System.out.println("contact list is empty");// 1
						break;// 1
					}
					System.out.print("enter contact's name:");// 1
					String tmpname = input.nextLine();// 1

					Contact tmpcontact = MyContactList.searchByname(tmpname);// n

					if (tmpcontact != null)// 1
					{
						delete(tmpcontact);// n^2
						deleteEvent(tmpcontact.getContactName());// n^2
						deleteAppointment(tmpcontact.getContactName());
						System.out.println(tmpname+" has been deleted and removed from events and appointments lists");// 1
					} else // 1
						System.out.println(tmpname+"not found!");// 1
					break;// 1

				case "4": // 1
					System.out.println("Enter add criteria: ");// 1
					System.out.println("1. Event");// 1
					System.out.println("2. Appointment");// 1
					System.out.print("Enter your choice: ");// 1
					int choice=0;
					try { choice = input.nextInt();// 1
					}
					catch(Exception e) {System.out.println("Invalid input!");
					}
					input.nextLine();

					if (choice == 1) {// 1
						addevent();
					} else if (choice == 2)// 1
					{
						addAppointment();
					} 
					break;// 1

				case "5": // 1
					System.out.println("Enter search criteria: ");// 1
					System.out.println("1.contact name");// 1
					System.out.println("2.Event tittle");// 1
					System.out.print("Enter your choice: ");// 1
					int choice1=0;
					try { choice1 = input.nextInt();// 1
					}
					catch(Exception e) {System.out.println("Invalid input! Please enter a valid choice.\npress enter to continue");
					
					}
					input.nextLine();

					if (choice1 == 1) {// 1
						System.out.print("Enter the contact name: ");// 1
					} else if (choice1 == 2)// 1
					{
						System.out.print("Enter the event title: ");// 1
					} 
					String name = input.nextLine();// 1

					printEventDetails(name, choice1);// n
					break;

				case "6": // 1
					if (MyContactList.empty()) // 1
					{
						System.out.println("contact list is empty");// 1
						break;// 1
					}
					System.out.print("Enter the first name: ");// 1
					String tmpfirst = input.nextLine();// 1

					if (tmpfirst == null)// 1
						System.out.println("no name was entered");// 1

					else// 1
						MyContactList.search_firstname(tmpfirst);// n^2

					break;// 1

				case "7":// 1
					printEventSorted();// n
					break;// 1

				case "8":// 1
					MyContactList.print_all();
					System.out.println("goodbye!");// 1
					run = 1;// 1
					break;// 1

				default:// 1
					System.out.println("Invalid input!");// 1
					break;
				}
			} 
				// break;
				
			}
		
	

	public Contact addcontact() {// bigO(n) total=2n+18
		System.out.println("Enter contact details:");

		System.out.print("Name: ");// 1
		String name = input.nextLine();
		if (MyContactList.searchByname(name) != null) {// n
			System.out.println("A contact with the same name already exists.");// 1
			return null;// 1
		}
		System.out.print("Phone Number: ");
		String phoneNumber = input.nextLine();
		if (MyContactList.searchByphone(phoneNumber) != null) {// n
			System.out.println("A contact with the same number already exists.");// 1
			return null;// 1
		}

		System.out.print("Email Address: ");
		String emailAddress = input.nextLine();
		System.out.print("Address: ");
		String address = input.nextLine();
		System.out.print("Birthday: ");
		String birthday = input.nextLine();
		System.out.print("Notes: ");
		String notes = input.nextLine();

		Contact c = new Contact(name, phoneNumber, emailAddress, address, birthday, notes);// 1

		return c;// 1
	}

	public void delete(Contact contactToBeDeleted) { // bigO(n^2) n^2+5n+3

		// deletes contacts with the same name as user inputs
		if (MyContactList.findkey(contactToBeDeleted.getContactName())) // n
			MyContactList.removeKey(contactToBeDeleted.getContactName()); // n
		return;

	}

	public void deleteEvent(String contactToBeDeleted) { // bigO(n^2) total=n^2+4n+4
		boolean deleted = false;
		boolean removed_event = false;
		if (MyEventList.empty())// 1
		{ // no events to delete
			return;// 1
		}

		MyEventList.findfirst();// 1

		while (!MyEventList.last()) // n
		{ // events to delete
			MyEventList.retreive().geteventContacts().findfirst();
			while (!MyEventList.retreive().geteventContacts().last()) {
				if (MyEventList.retreive().geteventContacts().retreive().getContactName().equals(contactToBeDeleted))// n
				{
					MyEventList.retreive().geteventContacts().remove();
					if (MyEventList.retreive().geteventContacts().empty()) {
						MyEventList.remove();
						removed_event = true;
					}
					deleted = true;
					break;

				}
				MyEventList.retreive().geteventContacts().findnext();
			}
			if (!removed_event) {
				if (!deleted) {
					if (MyEventList.retreive().geteventContacts().retreive().getContactName().equals(contactToBeDeleted))// n
					{
						MyEventList.retreive().geteventContacts().remove();
						if (MyEventList.retreive().geteventContacts().empty()) {
							MyEventList.remove();
							removed_event = true;
						}
					}
				}
				if (!removed_event)
					MyEventList.findnext();// n
			}
			removed_event = false;
			deleted = false;
		}

		MyEventList.retreive().geteventContacts().findfirst();
		while (!MyEventList.retreive().geteventContacts().last()) {
			if (MyEventList.retreive().geteventContacts().retreive().getContactName().equals(contactToBeDeleted))// n
			{
				MyEventList.retreive().geteventContacts().remove();
				if (MyEventList.retreive().geteventContacts().empty()) {
					MyEventList.remove();
				}
				deleted = true;
				break;

			}
			MyEventList.retreive().geteventContacts().findnext();
		}
		if (!deleted) {
			if (MyEventList.retreive().geteventContacts().retreive().getContactName().equals(contactToBeDeleted))// n
			{
				MyEventList.retreive().geteventContacts().remove();
				if (MyEventList.retreive().geteventContacts().empty()) {
					MyEventList.remove();
				}
			}
		}

	}

	public void deleteAppointment(String contactToBeDeleted) { // bigO(n^2) total=n^2+4n+4

		if (MyAppointmentList.empty())// 1
		{ 
			return;// 1
		}

		MyAppointmentList.findfirst();// 1

		while (!MyAppointmentList.last()) // n
		{
			if (MyAppointmentList.retreive().getContactinvolved().getContactName().equals(contactToBeDeleted))// n
			{
				MyAppointmentList.remove();// n*n
			} else// n
				MyAppointmentList.findnext();// n
		}
		if (MyAppointmentList.retreive().getContactinvolved().getContactName().equals(contactToBeDeleted))// 1
			MyAppointmentList.remove();// n
	}

	public void addevent() // bigO(n) total=4n+18
	{
		String newname = "";
		int index = 0;
		LinkedList_ADT<Contact> LinkMyContactList = new LinkedList_ADT<>();

		System.out.print("Enter event title: ");
		String eventTitle = input.nextLine();
		if (searchevent(eventTitle)) // n
		{
			System.out.println("You already have an Event with this name.");
			return;// 1
		}

		else// 1
		{
			System.out.print("Enter contact's name spreated by comma: ");// 1
			String cname = input.nextLine();// 1

			do {
				newname = extractnames(cname, index);

				Contact cc = MyContactList.searchByname(newname);// n
				if (cc == null) // 1
				{
					System.out.println("no contact found with this name : " + newname);// 1
					return;// 1
				} else {
					LinkMyContactList.Insert(cc);
				}

				int windex = 0;
				while (windex < newname.length() + 1)// n+1
				{
					index++;// n
					windex++;// n
				}

			} while (newname != null && index < cname.length());

			System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");// 1
			String eventDayandTime = input.nextLine();

			boolean isConflictDate = isConflict(eventDayandTime, newname);
			if (isConflictDate) {
				System.out.println(
						"The Event has NOT been scheduled because you already have an event/appointment on this date and time.");
				return;
			}

			

			System.out.print("Enter event location: ");// 1
			String eventLocation = input.nextLine();// 1
			Event newEvent = new Event(eventTitle, eventDayandTime, eventLocation, LinkMyContactList);// 1
			MyEventList.Insert(newEvent);// n
			System.out.println("Event scheduled successfully! ");// 1

		}

	}

	private String extractnames(String namelist, int index) {

		char currentChar = namelist.charAt(index);// 1
		String fullname = "";// 1

		while (currentChar != ',' && index < namelist.length())// n+1
		{
			fullname += currentChar;// n
			index++;// n
			if (index < namelist.length())// n
			{
				currentChar = namelist.charAt(index);// n
			}
		}

		return fullname;// 1

	}

	private boolean isConflict(String eventDayandTime, String nameContact) {
		boolean isConflictA = isConflictAppoinment(eventDayandTime, nameContact);
		if (isConflictA)
			return true;
		boolean isConflictE = isConflictEvent(eventDayandTime, nameContact);
		if (isConflictE)
			return true;

		return false;	}

	private boolean isConflictEvent(String eventDayandTime, String nameContact) {
	
		if (MyEventList.empty()) {
			return false;
		}
		MyEventList.findfirst();

		while (!MyEventList.last()) {

		
			if (eventDayandTime.equalsIgnoreCase(MyEventList.retreive().getDate())) {
			
				return true; // conflict found!
			}
			MyEventList.findnext();
		}

		
		if (eventDayandTime.equalsIgnoreCase(MyEventList.retreive().getDate())) {
			return true; // conflict found!
		}

	
		return false;
		
	}

	private boolean isConflictAppoinment(String eventDayandTime, String nameContact) {
		
		if (MyAppointmentList.empty()) {
			return false; 
		}
		MyAppointmentList.findfirst();

		while (!MyAppointmentList.last()) {

			if (eventDayandTime.equalsIgnoreCase(MyAppointmentList.retreive().getDate())) {
				return true;
			}
			MyAppointmentList.findnext();
		}

		if (eventDayandTime.equalsIgnoreCase(MyAppointmentList.retreive().getDate())) {
			return true; 
		}

		return false;
		
	}

	public void addAppointment() // bigO(n) total=4n+18
	{
		System.out.print("Enter Appointment title: ");// 1
		String appointmentTitle = input.nextLine();// 1

		if (searchAppointment(appointmentTitle)) // n
		{
			System.out.println("You already have an Appointment with this name.");
			return;// 1
		}

		else// 1
		{
			System.out.print("Enter contact's name: ");// 1
			String appointmentContactName = input.nextLine();// 1
			Contact cc = MyContactList.searchByname(appointmentContactName);// n
			if (cc == null) // 1
			{
				System.out.println("no contact found with this name");// 1
				return;// 1
			} else // 1
			{
				System.out.print("Enter Appointment date and time (MM/DD/YYYY HH:MM): ");// 1
				String appointmentDayandTime = input.nextLine();// 1

				boolean isConflictDate = isConflict(appointmentDayandTime, appointmentContactName);
				if (isConflictDate) {
					System.out.println(
							"The Appointment has NOT been scheduled because you already have an event/appointment on this date and time.");
					return;
				}

				System.out.print("Enter Appointment location: ");// 1
				String appointmentlocation = input.nextLine();// 1
				Appointment a = new Appointment(appointmentTitle, appointmentDayandTime, appointmentlocation,
						MyContactList.searchByname(appointmentContactName));// 1
				MyAppointmentList.Insert(a);// n
				System.out.println("Appointment scheduled successfully! ");// 1
			}

		}

	}

	public boolean searchAppointment(String title) // bigO(n) total=3n+8
	{

		if (MyAppointmentList.empty()) // 1
		{
			return false;// 1
		}

		MyAppointmentList.findfirst();// 1

		while (!MyAppointmentList.last())// n+1
		{
			if ((MyAppointmentList.retreive()).getTitle().equalsIgnoreCase(title))// n
				return true;// 1
			MyAppointmentList.findnext();// n
		}

		if (MyAppointmentList.retreive().getTitle().equalsIgnoreCase(title))// 1 // for last case
			return true;// 1

		return false;// 1

	}

	public boolean searchevent(String title) // bigO(n) total=3n+8
	{

		if (MyEventList.empty()) // 1
		{
			return false;// 1
		}

		MyEventList.findfirst();// 1

		while (!MyEventList.last())// n+1
		{
			if ((MyEventList.retreive()).getTitle().equalsIgnoreCase(title))// n
				return true;// 1
			MyEventList.findnext();// n
		}

		if (MyEventList.retreive().getTitle().equalsIgnoreCase(title))// 1 // for last case
			return true;// 1

		return false;// 1

	}

	public boolean searchdateAppointment(String Date)// bigO(n) total=3n+8
	{

		if (MyAppointmentList.empty()) // 1
		{
			return false;// 1
		}

		MyAppointmentList.findfirst();// 1

		while (!MyAppointmentList.last())// n+1
		{
			if ((MyAppointmentList.retreive()).getDate().equalsIgnoreCase(Date))// n
				return true;// 1
			MyAppointmentList.findnext();// n
		}

		if (MyAppointmentList.retreive().getDate().equalsIgnoreCase(Date)) // 1 for last case
			return true;// 1

		return false;// 1

	}

	public boolean searchdateEvent(String DateTime)// bigO(n) total=3n+8
	{

		if (MyEventList.empty()) // 1
		{
			return false;// 1
		}

		MyEventList.findfirst();// 1

		while (!MyEventList.last())// n+1
		{
			if ((MyEventList.retreive()).getDate().equalsIgnoreCase(DateTime))// n
				return true;// 1
			MyEventList.findnext();// n
		}

		if (MyEventList.retreive().getDate().equalsIgnoreCase(DateTime)) // 1 for last case
			return true;// 1

		return false;// 1

	}

	public void printEventDetails(String info, int choice) {
		
//		System.out.println("*********************************************"+info+"*******************************************************");
		
		
		LinkedList_ADT<Event> ll = new LinkedList_ADT<Event>();
		LinkedList_ADT<Appointment> ll2 = new LinkedList_ADT<>();

		MyEventList.findfirst();
		MyAppointmentList.findfirst();

		// ======================================================================================
		if (choice == 1) {// contact name
			while (!MyEventList.CheckIfNull() && !MyAppointmentList.CheckIfNull()) {

				MyEventList.retreive().geteventContacts().findfirst();
				while (!MyEventList.retreive().geteventContacts().CheckIfNull()) {
					if (MyEventList.retreive().geteventContacts().retreive().getContactName().equalsIgnoreCase(info))
						ll.Insert(MyEventList.retreive());
					MyEventList.retreive().geteventContacts().findnext();
				}

				if (MyAppointmentList.retreive().getContactinvolved().getContactName().equalsIgnoreCase(info))
					ll2.Insert(MyAppointmentList.retreive());

				MyEventList.findnext();
				MyAppointmentList.findnext();
			}
			// ================================== should complete the rest list

			if (MyAppointmentList.CheckIfNull()) {
				while (!MyEventList.CheckIfNull()) {
					MyEventList.retreive().geteventContacts().findfirst();
					while (!MyEventList.retreive().geteventContacts().CheckIfNull()) {
						if (MyEventList.retreive().geteventContacts().retreive().getContactName().equalsIgnoreCase(info))
							ll.Insert(MyEventList.retreive());
						MyEventList.retreive().geteventContacts().findnext();
					}
					// ll.Insert(MyEventList.retreive());
					MyEventList.findnext();
				}
			} else if (MyEventList.CheckIfNull()) {
				while (!MyAppointmentList.CheckIfNull()) {
					if (MyAppointmentList.retreive().getContactinvolved().getContactName().equalsIgnoreCase(info))
						ll2.Insert(MyAppointmentList.retreive());
					MyAppointmentList.findnext();
				}
			}
			// =====================================================================================================
		} else if (choice == 2) {
			while (!MyEventList.CheckIfNull() && !MyAppointmentList.CheckIfNull()) {
				if (MyEventList.retreive().getTitle().equalsIgnoreCase(info)) {
					ll.Insert(MyEventList.retreive());
				}
				MyEventList.findnext();

				if (MyAppointmentList.retreive().getTitle().equalsIgnoreCase(info))
					ll2.Insert(MyAppointmentList.retreive());
				MyAppointmentList.findnext();

			}
		}

		while (!MyEventList.CheckIfNull()) {
			if (MyEventList.retreive().getTitle().equalsIgnoreCase(info))
				ll.Insert(MyEventList.retreive());
			MyEventList.findnext();

		}

		while (!MyAppointmentList.CheckIfNull()) {
			if (MyAppointmentList.retreive().getTitle().equalsIgnoreCase(info))
				ll2.Insert(MyAppointmentList.retreive());
			MyAppointmentList.findnext();
		}
		// ============================================================================
		ll.findfirst();// event
		ll2.findfirst();// app

		while (!ll.CheckIfNull() && !ll2.CheckIfNull()) {
			int y = ll.retreive().compareTo(ll2.retreive());
			if (y == 0) {
				System.out.println(ll.retreive().toString());
				System.out.println(ll2.retreive().toString());
				ll.findnext();
				ll2.findnext();
			} else if (y > 0) {
				System.out.println(ll2.retreive().toString());
				ll2.findnext();
			} else {
				System.out.println(ll.retreive().toString());
				ll.findnext();
			}
		}
		// while end

		if (ll.CheckIfNull()) {
			while (!ll2.CheckIfNull()) {
				System.out.println(ll2.retreive().toString());
				ll2.findnext();
			}
		} else if (ll2.CheckIfNull()) {
			while (!ll.CheckIfNull()) {
				System.out.println(ll.retreive().toString());
				ll.findnext();
			}
		}
	}

	public String extractfirstName(String fullname) // bigO(n) total=5n+5
	{ // this method is to extract each first name form the list of contact

		int index = 0;// 1
		char currentChar = fullname.charAt(index);// 1
		String firstname = "";// 1

		while (currentChar != ' ' && index < fullname.length())// n+1
		{
			firstname += currentChar;// n
			index++;// n
			if (index < fullname.length())// n
			{
				currentChar = fullname.charAt(index);// n
			}
		}

		return firstname;// 1

	}

	public void printEventSorted() // bigO(n) total=3n+6
	{
		MyAppointmentList.findfirst();
		MyEventList.findfirst();
		while (!MyAppointmentList.CheckIfNull() && !MyEventList.CheckIfNull()) {
			int y = MyEventList.retreive().compareTo(MyAppointmentList.retreive());
			if (y == 0) {
				System.out.println(MyEventList.retreive().toString());
				System.out.println(MyAppointmentList.retreive().toString());
				MyEventList.findnext();
				MyAppointmentList.findnext();
			} else if (y > 0) {
				System.out.println(MyAppointmentList.retreive().toString());
				MyAppointmentList.findnext();
			} else {
				System.out.println(MyEventList.retreive().toString());
				MyEventList.findnext();
			}

		}
		if (MyEventList.CheckIfNull()) {
			while (!MyAppointmentList.CheckIfNull()) {
				System.out.println(MyAppointmentList.retreive().toString());
				MyAppointmentList.findnext();
			}
		} else if (MyAppointmentList.CheckIfNull()) {
			while (!MyEventList.CheckIfNull()) {
				System.out.println(MyEventList.retreive().toString());
				MyEventList.findnext();
			}
		}

	}

}