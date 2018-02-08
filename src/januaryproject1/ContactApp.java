/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package januaryproject1;

/**
 *
 * @author MarcoAyala
 */
public class ContactApp {
    Contact[] contacts = new Contact [10000]; 
    int contactCount = 0; 
    
    
    
    void addContact(String firstName, String lastName, String phoneNumber, String email){ 
        Contact contact = new Contact(); 
        contact.setFirstName(firstName); 
        contact.setLastName(lastName);
        contact.setPhoneNumber(phoneNumber);
        contact.setEmail(email);
        
        contacts[contactCount++] = contact; 
    }
    
    void deleteContact(int r){
        
        // check if the entry is null
        
        if (r<0){
            throw new RuntimeException("Nothing selected");
        }
        
        if (contacts[r] == null){
            throw new RuntimeException("There is nothing here");
        }
        
        // normal -- null the entry, shift everything down
        
        contacts[r]= null; 
       
        for (int i=r;i<9999;i++){
            contacts[i] = contacts[i+1]; 
 
        }
        
                   
        
    }
    
    Contact selectContact(int q){
        return contacts[q];
    }
    
    Contact getContact(int k){
        
        //error checking
        if (k < 0) {
            throw new RuntimeException("Nothing selected");
        }

        if (contacts[k] == null) {
            throw new RuntimeException("There is nothing here");
        }
        
        //normal
        
        return contacts[k];
        
    }
    
    
    Contact[] getContactsList (){
        return contacts; 
    }
    
}
