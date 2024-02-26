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

public class Contact implements Comparable<Contact>{
private String contactName,phoneNumber, emailAddress ,address ,birthday, note;




public int compareTo(Contact o) {//1 bigO(1)
	return this.contactName.compareToIgnoreCase(o.contactName);//1
	
}

public Contact(String contactName, String phoneNumber, String emailAddress, String address, String birthday, String note)//6 bigO(1) 
	{this.contactName = contactName;//1
	this.phoneNumber = phoneNumber;//1
	this.emailAddress = emailAddress;//1
	this.address = address;//1
	this.birthday = birthday;//1
	this.note = note;//1
}





public String getContactName()//1   bigO(1)
{
	return contactName;//1
}
public void setContactName(String contactName)//1    bigO(1)
{
	this.contactName = contactName;//1
}
public String getNote()//1    bigO(1)	
{
	return note;//1
}
public void setNote(String note) //1    bigO(1)
{
	this.note = note;//1
}
public String getEmailAddress()//1    bigO(1) 
{
	return emailAddress;//1
}
public void setEmailAddress(String emailAddress) {//1   bigO(1)
	this.emailAddress = emailAddress;//1
}
public String getAddress() //1 bigO(1)
{
	return address;//1
}
public void setAddress(String address)//1 bigO(1) 
{
	this.address = address;//1
}
public String getBirthday() //1 bigO(1)
{
	return birthday;//1
}
public void setBirthday(String birthday) //1 bigO(1)
{
	this.birthday = birthday;//1
}
public String getPhoneNumber()//1 bigO(1)
{
	return phoneNumber;//1
}
public void setPhoneNumber(String phoneNumber)//1 bigO(1)
{
	this.phoneNumber = phoneNumber;//1
}

@Override // made to string method here
public String toString() {//1 bigO(1)
	return "Name:" + contactName + "\nPhoneNumber:" + phoneNumber + "\nEmailAddress:" + emailAddress
			+ "\nAddress:" + address + "\nBirthday:" + birthday + "\nNote:" + note;//1
}
 


}