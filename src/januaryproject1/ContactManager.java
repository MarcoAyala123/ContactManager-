/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package januaryproject1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

/**
 *
 * @author MarcoAyala
 */
public class ContactManager {
    
    public static void main (String args[]) throws IOException{
        FileWriter fw = new FileWriter("boo.txt"); // creates the file that we are going to write to 
        PrintWriter pw = new PrintWriter(fw); //connects to the file writer. Job is to allow you to write to the file like a system.out.println 

        pw.println("This is a sentence");
        
        fw.close();
        
        
        
        
        // read
        
        FileReader fr = new FileReader("boo.txt");
        BufferedReader br = new BufferedReader(fr); // allows reading with readline
        
        String currentline = br.readLine();
        
        while (currentline!=null)
        {
            // do stuff with currentline
            
            System.out.println(currentline);
            
            // go next line
            currentline = br.readLine();
            
        }
        
        fr.close();
        
    }
    
    void write(String filename, Vector<Contact> contacts) throws IOException{
        FileWriter fw = new FileWriter(filename); // creates the file that we are going to write to 
        PrintWriter pw = new PrintWriter(fw); //connects to the file writer. Job is to allow you to write to the file like a system.out.println 
        
        for (int i=0; i<contacts.size(); i++)
        {
            Contact c = contacts.get(i);
            pw.println(c.getFirstName()+","+c.getLastName()+","+c.getPhoneNumber()+","+c.getEmail());
        }
        fw.close();
        
    }
    
       Vector<Contact> read(String filename) throws FileNotFoundException, IOException
       {
       Vector<Contact> vector = new Vector<Contact>();
       
        FileReader fr = new FileReader("boo.txt");
        BufferedReader br = new BufferedReader(fr); // allows reading with readline
        
        String currentline = br.readLine();
        
        while (currentline!=null)
        {
            // do stuff with currentline
            
            System.out.println(currentline);
            
            String[] data = currentline.split(",");
            
            Contact contact = new Contact(); 
             contact.setFirstName(data[0]); 
             contact.setLastName(data[1]);
             contact.setPhoneNumber(data[2]);
             contact.setEmail(data[3]);
             
             vector.add(contact);
            // go next line
            currentline = br.readLine();
            
            
        }
        
        return vector;
        
        
        
       }
        
    }
    
    
