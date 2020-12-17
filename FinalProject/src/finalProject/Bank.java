/**
 * 
 */
package finalProject;


import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*; 
import java.io.IOException;

/**
 * @author Sohel Tharani - 616
 *
 */

//@SohelTharani520- 1
public class Bank 
{
	
	/**
	 * @param args
	 * @throws IOException 
	 */

	//Create an ArrayList which will store account details
	static  ArrayList<Account> ls = new ArrayList<Account>();
	
	//Create an ArrayList which will store client details
	static  ArrayList<Client> clientList = new ArrayList<Client>();
	static Scanner lineScanner = new Scanner(System.in);
	static JFrame f =new JFrame(); 
	
	//Welcome Page aka menu page
	static void menu() throws IOException {
		
		//Collect what user want to do from given options
		String userInput = JOptionPane.showInputDialog(null, "Press 1 for Customer Login \n Press 2 for Banker Login \n Press 3 for Registration");
		int option = Integer.parseInt(userInput);
		
		switch(option)
		{
		case 1: 
			accountActivity(); //Re direct to accountActivity class	
			menu();
				break;
		case 2: 
			 BankerLogin();	//Re direct to BankerLogin class
			menu();
				break;
		case 3:
			Registration(); //Redirect to Registration class 
				break;
		
		}
	}

	//@SohelTharani616
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try { 
					//Will ReadFiles from BankUtility.java file
			// ReadClient from BankUtility.java file
			JOptionPane.showMessageDialog(null, "LAMBTON BANK");
			menu();	//Goto Menu class
			
		}catch(Exception  e) {
			JOptionPane.showMessageDialog(null, "Operation failed due to inavlid input. Please start again.");
			/*
			 * try 
			 * { 
			 * 		menu(); 
			 * }catch (IOException e1) 
			 * { 
			 * 		// TODO Auto-generated catch block
			 * 		e1.print(); 
			 * }
			 */
		}
		
	}
	
	
	//@SohelTharani616
		private static void subMenu(String clientId, String accNoInput) throws IOException 
		{
			//Ask user for its choice that he want to do
			String choice1 = JOptionPane.showInputDialog(null, "1. To Display Account Details \n "
					+ "2. To Display Account Balance  \n"
					+ "3. To Update Account Details  \n"
					+ "4. To Draw Money \n"
					+ "5. To Transfer Money to other account within Bank \n"
					+ "6. To Pay Bills  \n"
					+ "7. Go to Main Menu \n"
					+ "8. To Exit \n"
					+ "Please enter your choice :: ");
			
			
			int choice = Integer.parseInt(choice1);
			
			//Retrieve the account
			Account acc  = getAccount(accNoInput);
			switch(choice) {
				case 1 :
					printAccountDeatil(acc);		//Print Account Details
					subMenu(clientId,accNoInput);	//Again ask user that what he want to do
					break;
				case 2 :
					printAccountBalance(acc);
					subMenu(clientId,accNoInput);	//Again ask user that what he want to do
					break;
				case 3 :
					updateAccountDetail(acc);
					subMenu(clientId,accNoInput);	//Again ask user that what he want to do
					break;
				case 4 :
					withdrawMoney(acc);
					subMenu(clientId,accNoInput);	//Again ask user that what he want to do
					break;
				case 5 :
					transferMoney(acc);
					subMenu(clientId,accNoInput);	//Again ask user that what he want to do
					break;
				case 6 :
					payBills(acc);
					subMenu(clientId,accNoInput);	//Again ask user that what he want to do
					break;
				case 7 :
					menu();	//Goto Main menu
					break;
					
				case 8 :
					System.out.println("Exiting Thank you ...");
					System.exit(0);					//Exit the system
					
			}
		}
		
		//@SohelTharani616
		//Add an account on client's demand
		public static void addAccountForClient() {
			
			
			String clientId = JOptionPane.showInputDialog(null, "Add Account for client \n"
					+ "Enter a client id:");
			
			Client c =checkClientExist(clientId);		//Check wether user exists or not
			if(c!=null) 
			{
				accountCreation(c); //if not then create account
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Client ID does exist");	 
			}
			
		}
		//@SohelTharani616
		//Registration for new account
		public static void Registration() throws IOException
		{
			
			JOptionPane.showMessageDialog(null, "Registration");
			
			String clientName = JOptionPane.showInputDialog(null, "Enter a client:");	//Ask for clients ID
			String password = JOptionPane.showInputDialog(null, "Enter a Password:");	//ask to enter a password
			
			Client client = new Client();		//Create a new client
			//client.setPassword(password);		//Set password
			//client.setClientId(++Client.count + "");	//setclient id
			clientList.add(client);				//
			//accountCreation(client);			
			
		}
		
}
		