package com.Addressbook;
import java.util.*;
import java.util.stream.Collectors;
//Created a nested Class with the variables
class ContactDetail {
    public String firstname, lastname;
    public String address, city, state;
    public String zip;
    public String phoneNumber;
    public String email;
    //Constructor of ContactDetails
    public ContactDetail(String firstname, String lastname, String address, String city, String state, String zip, String phonenumber, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phonenumber;
        this.email = email;
    }
    //Taking Input from the user
    public ContactDetail() {}

    public String getFirstName() {
        return firstname;
    }
    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }
    public String getLastName() {
        return lastname;
    }
    public void setLastName(String lastName) {
        this.lastname = lastName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public String getPhoneNo() {
        return phoneNumber;
    }
    public void setPhoneNo(String phno) {
        this.phoneNumber = phno;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
//Creating an Array List of AddressBook
class AddressBook {
    ArrayList<ContactDetail> contactList = new ArrayList<ContactDetail>();
    String addressBookName,firstname;
    Scanner scan = new Scanner(System.in);
    int i;
    ContactDetail contactDetailObject = new ContactDetail();
    // Checking Duplicate entries
    boolean checkDuplicate() {
        System.out.println("Firstname : ");
        firstname = scan.nextLine();
        for (ContactDetail contact: contactList) {
            if(contact.firstname.equals(firstname)) {
                System.out.println("Contact already exist");
                return true;
            }
        }
        return false;
    }
    //Adding ContactDetails and printing
    public void addContactDetails() {
        if(!checkDuplicate()) {
            System.out.println("Lastname : ");
            String lastname = scan.nextLine();
            System.out.println("Address : ");
            String address = scan.nextLine();
            System.out.println("City : ");
            String city = scan.nextLine();
            System.out.println("State : ");
            String state = scan.nextLine();
            System.out.println("Zip : ");
            String zip = scan.nextLine();
            System.out.println("PhoneNumber : ");
            String phonenumber = scan.nextLine();
            System.out.println("Email : ");
            String email = scan.nextLine();

            ContactDetail contact = new ContactDetail(firstname, lastname, address, city, state, zip, phonenumber, email);
            contactList.add(contact);
        }
    }
    // Editing Contact if any changes required
    public void editContact() {
        System.out.println("Enter name of contact to edit : ");
        String nameToEdit = scan.nextLine();
        for (i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).firstname.equalsIgnoreCase(nameToEdit)) {
                System.out.println("Edit Firstname : ");
                String firstname = scan.nextLine();
                contactList.get(i).setFirstName(firstname);

                System.out.println("Edit Lastname : ");
                String lastname = scan.nextLine();
                contactList.get(i).setLastName(lastname);

                System.out.println("Edit Address : ");
                String address = scan.nextLine();
                contactList.get(i).setAddress(address);

                System.out.println("Edit City : ");
                String city = scan.nextLine();
                contactList.get(i).setCity(city);

                System.out.println("Edit State : ");
                String state = scan.nextLine();
                contactList.get(i).setState(state);

                System.out.println("Edit Zip : ");
                String zip = scan.nextLine();
                contactList.get(i).setZip(zip);

                System.out.println("Edit PhoneNumber : ");
                String phonenumber = scan.nextLine();
                contactList.get(i).setPhoneNo(phonenumber);

                System.out.println("Edit Email : ");
                String email = scan.nextLine();
                contactList.get(i).setEmail(email);
            }
        }
    }
    //Deleting as per the choice of contact by the user
    public void deleteContact() {
        System.out.println("Enter name of contact to delete : ");
        String deleteCon = scan.nextLine();
        for (i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).firstname.equalsIgnoreCase(deleteCon)) {
                contactList.remove(i);
            }
        }
    }
    //print ContactDetails to view
    public void printContactDetails() {
        System.out.println("Enter name of contact to view : ");
        String nameToView = scan.nextLine();
        for (i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).firstname.equalsIgnoreCase(nameToView)) {
                System.out.println("Firstname : " + contactList.get(i).firstname);
                System.out.println("Lastname : " + contactList.get(i).lastname);
                System.out.println("Address : " + contactList.get(i).address);
                System.out.println("City : " + contactList.get(i).city);
                System.out.println("State : " + contactList.get(i).state);
                System.out.println("Zip : " + contactList.get(i).zip);
                System.out.println("PhoneNumber : " + contactList.get(i).phoneNumber);
                System.out.println("Email : " + contactList.get(i).email);
            }
        }
    }
    //Searching contact With Same City
    public void contactWithSameCity() {
        System.out.println("Enter city name to search contact's :");
        String citySearch = scan.nextLine();
        for (ContactDetail contact: contactList) {
            List<ContactDetail> personByCity = contactList.stream().filter(myContact -> myContact.getCity().equals(citySearch)).collect(Collectors.toList());
            for (ContactDetail myContact: personByCity) {
                System.out.println("Name:"+ contact.getFirstName()+" "+contact.getLastName());
            }
        }
    }
    //Searching contact With Same State
    public void contactWithSameState() {
        System.out.println("Enter state name to search contact's :");
        String stateSearch = scan.nextLine();
        for (ContactDetail contact: contactList) {
            List<ContactDetail> personByState = contactList.stream().filter(myContact -> myContact.getState().equals(stateSearch)).collect(Collectors.toList());
            for (ContactDetail myContact: personByState) {
                System.out.println("Name:"+ contact.getFirstName()+" "+contact.getLastName());
            }
        }
    }
    //Count person With Same City
    public void countWithSameCity() {
        System.out.println("Enter city name to search contact's :");
        String citySearch = scan.nextLine();
        for (ContactDetail contact: contactList) {
            List<ContactDetail> countByCity = contactList.stream().filter(myContact -> myContact.getCity().equals(citySearch)).collect(Collectors.toList());
            for (ContactDetail myContact: countByCity) {
                System.out.println("Number of people from "+citySearch+" are:"+ countByCity.stream().count());
            }
        }
    }
    //Count person With Same State
    public void countWithSameState() {
        System.out.println("Enter city name to search contact's :");
        String stateSearch = scan.nextLine();
        for (ContactDetail contact: contactList) {
            List<ContactDetail> countByState = contactList.stream().filter(myContact -> myContact.getCity().equals(stateSearch)).collect(Collectors.toList());
            for (ContactDetail myContact: countByState) {
                System.out.println("Number of people from "+stateSearch+" are:"+ countByState.stream().count());
            }
        }
    }
    public static Comparator<ContactDetail> compareFirstName = new Comparator<ContactDetail>() {
        @Override
        public int compare(ContactDetail contactDetail, ContactDetail t1) {
            String tempFirstName1 = contactDetail.getFirstName();
            String tempFirstName2 = contactDetail.getFirstName();
            return tempFirstName1.compareTo(tempFirstName2);
        }
    };
    //sorting contact by name of the person
    public void sortContact(ArrayList<AddressBook> adbook) {
        Collections.sort(contactList, AddressBook.compareFirstName);
        for(ContactDetail contact: contactList) {
            System.out.println(contact.getFirstName());
        }
    }
    public static Comparator<ContactDetail> compareCity = new Comparator<ContactDetail>() {
        @Override
        public int compare(ContactDetail contactDetail, ContactDetail t2) {
            String tempCity1 = contactDetail.getCity();
            String tempCity2 = contactDetail.getCity();
            return tempCity1.compareTo(tempCity2);
        }
    };
    //sorting contact by city
    public void sortContacts(ArrayList<AddressBook> adbook) {
        Collections.sort(contactList, AddressBook.compareCity);
        for(ContactDetail contact: contactList) {
            System.out.println(contact.getCity());
        }
    }

}
//Main Class
public class AddressBookMain {
    private static ArrayList<AddressBook> adbook = new ArrayList<AddressBook>();
    public static void main(String args[]) {
        //Making choice by the user
        int r = 0;
        String choice = "y";
        Scanner scan = new Scanner(System.in);
        AddressBook addressObject = new AddressBook();
        System.out.println("Welcome to Address Book Program!");//Welcome message to the user
        while (r != 3) {
            System.out.println("1.CREATE AN ADDRESS BOOK");
            System.out.println("2.ACCESS AN ADDRESS BOOK");
            System.out.println("3.EXIT THE APPLICATION");
            r = scan.nextInt();
            //Switch case
            switch (r) {
                case 1:
                    //User need to provide address book name to create
                    System.out.println("Enter the name of address book to be created");
                    String name = scan.next();
                    AddressBook book = new AddressBook();
                    book.addressBookName = name;
                    adbook.add(book);
                    break;
                case 2:
                    //User need to provide that already has been created
                    int key = 0;
                    System.out.println("Enter the address book name to be accessed");
                    String accessBook = scan.next();
                    for (int j = 0; j < adbook.size(); j++) {
                        if (adbook.get(j).addressBookName.equalsIgnoreCase(accessBook)) {
                            int switchChoice = 0;
                            while (switchChoice != 5) {
                                System.out.println("Enter \n1: add \n2: edit \n3: delete \n4: view \n5: View persons in same city \n6: View persons in same state \n7: exit"+
                                        "\n7: count of people from same city \n8: count of people from same state \n9: sort contact \n10: sort contact by city2                       \n10: exit");
                                System.out.println("Enter choice : ");
                                switchChoice = scan.nextInt();
                                choice = "y";
                                switch (switchChoice) {
                                    case 1:
                                        while (choice.equals("y")) {
                                            addressObject.addContactDetails();
                                            System.out.println("Do you want add more contact : ");
                                            choice = scan.next();
                                        }
                                        break;

                                    case 2:
                                        addressObject.editContact();
                                        break;

                                    case 3:
                                        addressObject.deleteContact();
                                        break;

                                    case 4:
                                        addressObject.printContactDetails();
                                        break;

                                    case 5:
                                        addressObject.contactWithSameCity();
                                        break;

                                    case 6:
                                        addressObject.contactWithSameState();
                                        break;
                                    case 7:
                                        addressObject.countWithSameCity();
                                        break;

                                    case 8:
                                        addressObject.countWithSameState();
                                        break;

                                    case 9:
                                        addressObject.sortContact(adbook);
                                        break;
                                    case 10:
                                        addressObject.sortContacts(adbook);
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                    }
            }
        }
    }
}