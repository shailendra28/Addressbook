package com.Addressbook;
import java.util.ArrayList;
import java.util.Scanner;
//Created a nested Class with the variables
 class ContactDetails {
    public String firstname, lastname;
    public String address, city, state;
    public String zip;
    public String phoneNumber;
    public String email;
    //Constructor of ContactDetails
    public ContactDetails(String firstname, String lastname, String address, String city, String state, String zip, String phonenumber, String email) {
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
    public ContactDetails() {}

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
    public static class AddressBook {
        ArrayList<ContactDetails> contactList = new ArrayList<ContactDetails>();
        String addressBookName,firstname;
        Scanner scan = new Scanner(System.in);
        int i;
        ContactDetails contactDetailObject = new ContactDetails();

        boolean checkDuplicate() {
            System.out.println("Firstname : ");
            firstname = scan.nextLine();
            for (ContactDetails contact: contactList) {
                if(contact.firstname.equals(firstname)) {
                    System.out.println("Contact already exist");
                    return true;
                }
            }
            return false;
        }

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

                ContactDetails contact = new ContactDetails(firstname, lastname, address, city, state, zip, phonenumber, email);
                contactList.add(contact);
            }
        }
        //Added method to edit contact
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
        //Added method to deleteContact
        public void deleteContact() {
            System.out.println("Enter name of contact to delete : ");
            String deleteCon = scan.nextLine();
            for (i = 0; i < contactList.size(); i++) {
                if (contactList.get(i).firstname.equalsIgnoreCase(deleteCon)) {
                    contactList.remove(i);
                }
            }
        }
        //Printing ContactDetails
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
    }
    //Main Method
    public static class AddressBookMain {
        private static ArrayList<AddressBook> adbook = new ArrayList<AddressBook>();
        public static void main(String args[]) {
            //Taking Choice from user
            int r = 0;
            String choice = "y";
            Scanner scan = new Scanner(System.in);
            AddressBook addressObject = new AddressBook();
            System.out.println("Welcome to Address Book Program!");//Printing welcome message
            while (r != 3) {
                //Printing the message to the user to make a choice
                System.out.println("1.CREATE AN ADDRESS BOOK");
                System.out.println("2.ACCESS AN ADDRESS BOOK");
                System.out.println("3.EXIT THE APPLICATION");
                r = scan.nextInt();
                switch (r) {
                    //If the user choose this case the user have to provide the name of AddressBook to create
                    case 1:
                        System.out.println("Enter the name of address book to be created");
                        String name = scan.next();
                        AddressBook book = new AddressBook();
                        book.addressBookName = name;
                        adbook.add(book);
                        break;
                    //If the user choose this case then user have to provide previous AddressBook Name to access
                    case 2:
                        int key = 0;
                        System.out.println("Enter the address book name to be accessed");
                        String accessBook = scan.next();
                        for (int j = 0; j < adbook.size(); j++) {
                            if (adbook.get(j).addressBookName.equalsIgnoreCase(accessBook)) {
                                int switchChoice = 0;
                                while (switchChoice != 5) {
                                    System.out.println("Enter 1: add 2: edit 3: delete 4: view 5: exit");
                                    System.out.println("Enter choice : ");
                                    switchChoice = scan.nextInt();
                                    choice = "y";
                                    //Switch case
                                    switch (switchChoice) {
                                        //If the user choose this case then user must provide the more contact to the AddressBook
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
}

