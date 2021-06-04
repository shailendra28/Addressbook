package com.Addressbook;
//Declare contactDetail class with the variable
class contactDetail {
    public final String firstname, lastname;
    public final String address, city, state;
    public final String zip;
    public final String phoneNumber;
    public final String email;
    // Create constructor of class contactDetail with parameter
    public contactDetail(String firstname, String lastname, String address, String city, String state, String zip, String phonenumber, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phonenumber;
        this.email = email;
    }

    public void printContactDetails() {
        System.out.println("Firstname : " + firstname);
        System.out.println("Lastname : " + lastname);
        System.out.println("Address : " + address);
        System.out.println("City : " + city);
        System.out.println("State : " + state);
        System.out.println("Zip : " + zip);
        System.out.println("PhoneNumber : " + phoneNumber);
        System.out.println("Email : " + email);
    }
    //Main Method
    public static class AddressBookMain {
        public static void main(String[] args) {
            System.out.println("Welcome to the Address Book Program");//Print the welcome message
            //Following statement would create an object contact
            contactDetail contact = new contactDetail("Shailendra", "Yadav", "Chembur", "Mumbai", "Maharashtra", "400071", "8779796556", "yshailendrakumar1768@gmail.com");
            //calling printContactDetails
            contact.printContactDetails();
        }
    }
}
