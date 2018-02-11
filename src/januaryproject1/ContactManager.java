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
        // creates the file that we are going to write to 
        FileWriter fw = new FileWriter("contacts.txt");
        //connects to the file writer. Job is to allow you to write to the file like a system.out.println 
        PrintWriter pw = new PrintWriter(fw); 

        pw.println("This is a sentence"); //Delete this soon 
        
        //closes the FileWriter 
        fw.close(); 
        
        
        
        
        // read
        
        FileReader fr = new FileReader("contacts.txt");//creates a new FileReader with a pointer called 'fr' and that accepts the file 'contacts.txt' as the parameter of its constructor method 
        BufferedReader br = new BufferedReader(fr); // allows reading with readline
        
        String currentline = br.readLine();//Creates a String called currentline which equals one line in the file that is read 
        
        while (currentline!=null) //while the currentline is not empty or is not null, the following code will be executed 
        {
            // do stuff with currentline
            
            System.out.println(currentline); //prints the current line 
            
            // go next line
            currentline = br.readLine(); //makes the currentline equal to the line the BufferedReader reads 
            
        }
        
        fr.close(); //closes the FileReader 
        
    }
    
    void write(String filename, Vector<Contact> contacts) throws IOException{
        // creates the file that we are going to write to 
        FileWriter fw = new FileWriter(filename); 
        //connects to the file writer. Job is to allow you to write to the file like a system.out.println 
        PrintWriter pw = new PrintWriter(fw); 
        
        //for loop to loop through all the contacts 
        for (int i=0; i<contacts.size(); i++) 
        {
            //makes a pointer to the i'th contact called 'c'
            Contact c = contacts.get(i); 
            //prints out the information about the contact in the file
            pw.println(c.getFirstName()+","+c.getLastName()+","+c.getPhoneNumber()+","+c.getEmail());
        }
        //close the FileReader 
        fw.close(); 
        
    }
    
       Vector<Contact> read(String filename) throws FileNotFoundException, IOException
       {
       Vector<Contact> vector = new Vector<Contact>();
       
       //makes a new FileReader with a pointer called 'fr' that accepts the file 
       //'contacts.txt' as the parameter of its constructor method 
        FileReader fr = new FileReader(filename); 
        BufferedReader br = new BufferedReader(fr); // allows reading with readline
        String currentline = br.readLine();
       // do stuff with currentline
        
       while (currentline!=null)
        {
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
    
    
