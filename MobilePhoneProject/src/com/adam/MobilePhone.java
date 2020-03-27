package com.adam;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
    public static ArrayList<Contacts> contactsList = new ArrayList<Contacts>();
    public static Scanner sc = new Scanner(System.in);


    public static void addContact(){
        System.out.println("Enter Name: ");
        String contactName = sc.nextLine();
        System.out.println("Enter Number: ");
        int contactNumber = sc.nextInt();
        Contacts newContact = new Contacts(contactName, contactNumber);
        contactsList.add(newContact);

    }

    public static boolean queryContact(String contactName){
        for(int i = 0; i <= contactsList.size(); i++){
            if(contactsList.get(i).getName() == contactName){
                return true;
            }
        }
        return false;

    }

    public static void removeContact(String removedContact){
        if(queryContact(removedContact) == false){
            System.out.println("ERROR: Contact not found");
        } else {
            for(int i = 0; i <= contactsList.size(); i++){
                if(contactsList.get(i).getName() == removedContact){
                    contactsList.remove(contactsList.get(i));
                }
            }
        }
    }


}
