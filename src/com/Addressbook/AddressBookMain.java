package com.Addressbook;
import java.util.ArrayList;
import java.util.Scanner;
//Declare contactDetail class with the variable
class contactDetail {
    public String firstname, lastname;
    public String address, city, state;
    public int zip;
    public long phoneNumber;
    public String email;
    //Created constructor of contactDetail
    public contactDetail(String firstname, String lastname, String address, String city, String state, int zip, long phonenumber, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phonenumber;
        this.email = email;
    }
    //Taking Input from the user for the FirstName
    public String getFirstName() {
        return firstname;
    }
    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }
    //Taking Input from the user for the LastName
    public String getLastName() {
        return lastname;
    }
    public void setLastName(String lastName) {
        this.lastname = lastName;
    }
    //Taking Input from the user for the Address
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    //Taking Input from the user for the City
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    //Taking Input from the user for the State
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    //Taking Input from the user for the Zip
    public int getZip() {
        return zip;
    }
    public void setZip(int zip) {
        this.zip = zip;
    }
    //Taking Input from the user for the PhoneNo
    public long getPhoneNo() {
        return phoneNumber;
    }
    public void setPhoneNo(long phno) {
        this.phoneNumber = phno;
    }
    public String getEmail() {
        return email;
    }
    //Taking Input from the user for the Email
    public void setEmail(String email) {
        this.email = email;
    }
}
class addressBook {
    // Creating ArrayList
    private ArrayList<contactDetail> contactList = new ArrayList<contactDetail>();
    Scanner sc = new Scanner(System.in);
    public void insertContact(contactDetail contactDetailObject) {
        contactList.add(contactDetailObject);
    }
    //Added editContact
    public void editContact(String nameToEdit) {
        for(contactDetail editContact: contactList) {
            if(editContact.getFirstName().equals(nameToEdit)) {
                System.out.println("Edit Firstname : ");
                String firstname = sc.nextLine();
                editContact.setFirstName(firstname);
                System.out.println("Edit Lastname : ");
                String lastname = sc.nextLine();
                editContact.setLastName(lastname);
                System.out.println("Edit Address : ");
                String address = sc.nextLine();
                editContact.setAddress(address);
                System.out.println("Edit City : ");
                String city = sc.nextLine();
                editContact.setCity(city);
                System.out.println("Edit State : ");
                String state = sc.nextLine();
                editContact.setState(state);
                System.out.println("Edit Zip : ");
                int zip = sc.nextInt();
                editContact.setZip(zip);
                System.out.println("Edit PhoneNumber : ");
                long phonenumber = sc.nextLong();
                sc.nextLine();
                editContact.setPhoneNo(phonenumber);
                System.out.println("Edit Email : ");
                String email = sc.nextLine();
                editContact.setEmail(email);
            }
        }
    }
   //Added delete
    public void delete(String nameToDelete) {
        int i=0;
        for(i=0;i<contactList.size();i++) {
            if(contactList.get(i).firstname.equals(nameToDelete)) {
                contactList.remove(i);
                System.out.println("Contact is Deleted");
            }
            else
            {
                System.out.println("Contact not found!");
            }
        }
    }
    //Printing contactDetails
    public void printContactDetails() {
        for(contactDetail getInfo: contactList) {
            System.out.println("Firstname : " + getInfo.getFirstName());
            System.out.println("Lastname : " + getInfo.getLastName());
            System.out.println("Address : " + getInfo.getAddress());
            System.out.println("City : " + getInfo.getCity());
            System.out.println("State : " + getInfo.getState());
            System.out.println("Zip : " + getInfo.getZip());
            System.out.println("PhoneNumber : " + getInfo.getPhoneNo());
            System.out.println("Email : " + getInfo.getEmail());
        }

    }

}public class AddressBookMain {
    public static void main(String args[])
    {
        // get input from the user in primitive types such as int, long, double, byte, float, short, etc
        Scanner scan = new Scanner(System.in);
        //created an object addressObject
        addressBook addressObject = new addressBook();
        String choice = "y";
        System.out.println("Wellcome to Address Book Program!");//Printing Welcome Message
        while(true) {
            System.out.println("Enter 1: add 2: edit 3: delete 4: view 5: exit");
            System.out.println("Enter choice : ");
            int switchChoice = scan.nextInt();
            scan.nextLine();
            switch(switchChoice) {
                case 1:
                    while(choice.equals("y")) {
                        System.out.println("Firstname : ");
                        String firstname = scan.nextLine();
                        System.out.println("Lastname : ");
                        String lastname = scan.nextLine();
                        System.out.println("Address : ");
                        String address = scan.nextLine();
                        System.out.println("City : ");
                        String city = scan.nextLine();
                        System.out.println("State : ");
                        String state = scan.nextLine();
                        System.out.println("Zip : ");
                        int zip = scan.nextInt();
                        System.out.println("PhoneNumber : ");
                        long phonenumber = scan.nextLong();
                        System.out.println("Email : ");
                        scan.nextLine();
                        String email = scan.nextLine();
                        System.out.println("Do you want add more contact : ");
                        choice = scan.nextLine();
                        contactDetail contact = new contactDetail(firstname, lastname, address, city, state, zip, phonenumber, email);
                        addressObject.insertContact(contact);
                    }
                    break;
                case 2:
                    System.out.println("Enter name of contact to edit : ");
                    String nameToEdit = scan.nextLine();
                    addressObject.editContact(nameToEdit);
                    break;
                case 3:
                    System.out.println("Enter name of contact to edit : ");
                    String deleteCon = scan.nextLine();
                    addressObject.delete(deleteCon);
                    break;
                case 4:
                    System.out.println("Contact List : ");
                    addressObject.printContactDetails();
                    break;
                default:
                    System.exit(0);
            }
        }

    }
}