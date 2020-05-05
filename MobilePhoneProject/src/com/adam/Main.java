package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static MobilePhone mobilePhone = new MobilePhone(("0039 330 44404"));

    public static void main(String[] args) {
	// create a program that implements a simple mobile phone with the following capabilities
        //able to store, modify, remove and query contact names
        // you will want to create a separate class for Contacts (name and phone number)
        // Create a master class(MobilePhone) that holds the arraylist of contacts
        //the MobilePhone class has the fucitonality listed above
        //add a menu of options that are avaialble
        //Options: quit, print list of contacts, add new contact, update existing contact, remove contact
        // and search/find contact
        //when adding or updating be sure to check if the contact already exists
        //be sure not to expose the inner workings of the arraylist to mobile phone
        //e.g. no inits, no .get(i), etc
        // mobilePhone should do everything with contact objects only


        boolean quit = false;
        startPhone();
        printActions();
        while(!quit){
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action){
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }



    }


    private static void addNewContact(){
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println("New contact added: " + name + ", phone = " + phone);

        } else {
            System.out.println("Cannot add: " + name + " already on file");
        }
    }

    private static void startPhone(){
        System.out.println("Starting phone....");
    }

    private static void updateContact(){
        System.out.println("Enter existing contact name");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number");
        String newNumber = scanner.nextLine();

        Contact newContact = Contact.createContact(newName, newNumber);
        if(mobilePhone.updateContact(existingContactRecord, newContact)){
            System.out.println("Successfully updated record");

        } else {
            System.out.println("Error updating records");
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        if(mobilePhone.removeContact(existingContactRecord)){
            System.out.println("Successfully deleted");

        } else {
            System.out.println("Error deleting");
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("name: " + existingContactRecord.getName() + "Phone number is " + existingContactRecord.getPhoneNumber());

    }


    private static void printActions(){
        System.out.println("\nAvailable actions: \npress");
        System.out.println("0 - shutdown\n" +
                "1 - to print contacts\n" +
                "2 - to add a new contact\n" +
                "3 - to update an existing contact\n" +
                "4 - to remove a contact\n" +
                "5 - to query if an existing contact exists\n" +
                "6 -  print a list of available actions:");

        System.out.println("Choose your action");
    }
}
