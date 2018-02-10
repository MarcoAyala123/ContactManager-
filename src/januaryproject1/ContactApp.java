/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package januaryproject1;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author MarcoAyala
 */
public class ContactApp {
    Vector<Contact> contacts = new Vector<>(); 
    
    
    
    void addContact(Contact c)
    {
        contacts.add(c);
    }
    
    void addContact(String firstName, String lastName, String phoneNumber, String email){ 
        Contact contact = new Contact(); 
        contact.setFirstName(firstName); 
        contact.setLastName(lastName);
        contact.setPhoneNumber(phoneNumber);
        contact.setEmail(email);
        
        contacts.add(contact); 
    }
    
    void deleteContact(int r){
        
        // check if the entry is null
        
        if (r<0){
            throw new RuntimeException("Nothing selected");
        }
                
        // normal -- null the entry, shift everything down
       contacts.remove(r);
                   
        
    }
    
    Contact selectContact(int q){
        return contacts.get(q);
    }
    
    Contact getContact(int k){
        
        //error checking
        if (k < 0) {
            throw new RuntimeException("Nothing selected");
        }
        
        return contacts.get(k);
        
    }
    
    
    Vector<Contact> getContactsList (){
        return contacts; 
    }
    
}
