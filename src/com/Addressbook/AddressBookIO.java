package com.Addressbook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddressBookIO {
    public static String File = "AddressBook.txt";

    public void writeData(List<ContactDetail> contactsList) {
        StringBuffer buffer = new StringBuffer();
        contactsList.forEach(contact -> {
            String contactData = contact.toString().concat("\n");
            buffer.append(contactData);
        });
        try {
            Files.write(Paths.get(File), buffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printData() {
        try {
            Files.lines(new File("AddressBook.txt").toPath()).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AddressBookIO addressBookIO = new AddressBookIO();
        ContactDetail[] arrayOfContact= {
                new ContactDetail("shailendra", "yadav", "chembur", "mumbai", "maharashtra", "400071", "8779796556", "syadav@gmail.com") ,
                new ContactDetail("devendra", "jadhav", "dadar", "jainpur", "utterpradesh", "451201", "99695506645", "djadhav@gmail.com")
        };

        addressBookIO.writeData(Arrays.asList(arrayOfContact));
        addressBookIO.printData();
    }

    public List<ContactDetail> readData() {
        List<ContactDetail> addressBookList = new ArrayList<ContactDetail>();

        try {
            Files.lines(new File("AddressBook.txt").toPath())
                    .map(line -> line.trim())
                    .forEach(line -> System.out.println(line));
        }catch (IOException x){
            x.printStackTrace();
        }
        return addressBookList;
    }
}