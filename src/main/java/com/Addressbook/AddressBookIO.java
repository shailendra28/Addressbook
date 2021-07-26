package com.Addressbook;

import com.google.gson.Gson;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public class AddressBookIO {
    public static String File = "AddressBook.txt";
    public static String MyCSV = "AddressBook.csv";
    public static String MyJSON= "AddressBook.json";

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
    public void writeContactToCSV(List<ContactDetail> contactDetailList) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        try {
            Writer writer = Files.newBufferedWriter(Paths.get(MyCSV));
            StatefulBeanToCsv statefulBeanToCsv = new StatefulBeanToCsvBuilder(writer).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
            statefulBeanToCsv.write(contactDetailList);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readContactFromCsv() {
        try {
            Files.lines(new File("AddressBook.csv").toPath()).forEach(System.out::println);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeContactToJSON(List<ContactDetail> contactsList) throws IOException {
        Gson gson = new Gson();
        FileWriter fileWriter = new FileWriter(MyJSON);
        gson.toJson(contactsList, fileWriter);
        fileWriter.close();
    }
    public void readContactFromJSON() throws IOException {
        Files.lines(new File("AddressBook.json").toPath()).forEach(System.out::println);
    }

    public static void main(String[] args)throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException {
        AddressBookIO addressBookIO = new AddressBookIO();
        ContactDetail[] arrayOfContact= {
                new ContactDetail("shailendra", "yadav", "chembur", "mumbai", "maharashtra", "400071", "8779796556", "syadav@gmail.com") ,
                new ContactDetail("devendra", "jadhav", "dadar", "jainpur", "utterpradesh", "451201", "99695506645", "djadhav@gmail.com")
        };
        addressBookIO.writeData(Arrays.asList(arrayOfContact));
        addressBookIO.writeContactToCSV(Arrays.asList(arrayOfContact));
        addressBookIO.readContactFromCsv();
        addressBookIO.writeContactToJSON(Arrays.asList(arrayOfContact));
        addressBookIO.readContactFromJSON();
        addressBookIO.printData();
    }
}