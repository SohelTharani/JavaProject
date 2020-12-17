/**
 * 
 */
package finalProject;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * @author Himadri Shukla - 696
 *
 */

//create BankUtility class
public class BankUtility 
{
	//To write and save the data to the file
	public static void saveToFile(ArrayList<Account> ac){
	// adding exception
		//This is try and catch block
		try {
			//To write data to the file outputfile.txt
            FileOutputStream f = new FileOutputStream(new File("outputFile.txt"),false);
            ObjectOutputStream o = new ObjectOutputStream(f);
		
            for(Account a :ac)
            	o.writeObject(a);

            o.close();
            f.close();

        } catch (FileNotFoundException e) 
		{
        	JOptionPane.showInputDialog(null, "File not found");
        } catch (IOException e) {
        	JOptionPane.showInputDialog(null, "Error initializing stream");
        } 
	}
	
	//To save client's data into the file
	public static void saveClientToFile(ArrayList<Client> ac){
		
		try {
            FileOutputStream f = new FileOutputStream(new File("outputFile.txt"),false);
            ObjectOutputStream o = new ObjectOutputStream(f);

            for(Client a :ac)
            	o.writeObject(a);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
        	JOptionPane.showInputDialog(null, "File not found");
        } catch (IOException e) {
        	JOptionPane.showInputDialog(null, "Error initializing stream");
        } 
	}

	//To read client's data from the file	
	public static ArrayList<Client> readClientFromFile(){
		//Creating an list of data into the array
		ArrayList<Client> objectsList = new ArrayList<>();
		boolean cont = true;
		int max =10001;
		
		 try  {
		
			 File yourFile = new File("outputFile.txt");
			 yourFile.createNewFile();	 
		 FileInputStream fis = new FileInputStream(yourFile);
		  ObjectInputStream input = new ObjectInputStream(fis);
		while (cont) {
		    Client obj = (Client)input.readObject();
		    if(max<Integer.parseInt(obj.getClientId())) {
		    	max = Integer.parseInt(obj.getClientId());
		    }
		       
		    if (obj != null) {
		      objectsList.add(obj);
		    } else {
		      cont = false;
		    }
		  }
		input.close();
        fis.close();
		 }catch (Exception e) {
		    // System.out.println(e.printStackTrace());
		  }
		//counting  total entry
		Client.count = max;
		return objectsList;
		
	}
	
	//To read account information from the file
	public static ArrayList<Account> readAccountFromFile(){
		
		ArrayList<Account> objectsList = new ArrayList<>();
		boolean cont = true;
		int max =1001;
		 try  {
		
			 File yourFile = new File("outputFile.txt");	//All the data will be saved in outputFile.txt
			 yourFile.createNewFile();	 
		 FileInputStream fis = new FileInputStream(yourFile);
		  ObjectInputStream input = new ObjectInputStream(fis);
		while (cont) {
			
		    Client obj = (Client)input.readObject();
		    
		    if (obj != null) {
		    	
		    	objectsList.addAll(obj.getAccounts());	
		    } else {
		      cont = false;
		    }
		  }
		input.close();
        fis.close();
		 }catch (Exception e) {
		    // System.out.println(e.printStackTrace());
		  }
		
		Account.count = max;
		return objectsList;
		
	}
}