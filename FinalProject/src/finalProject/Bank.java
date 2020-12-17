/**
 * 
 */
package finalProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;  

/**
 * @author Sohel Tharani - 616
 *
 */

//@SohelTharani616
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
	static void menu() throws IOException 
	{
		//Collect what user want to do from given options
		String userInput = JOptionPane.showInputDialog(null, "Press 1 for Customer Login \n Press 2 for Banker Login");
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
			menu();
				break;
		}
	}
	
	//@SohelTharani616
	//Main Method
	public static void main(String[] args) 
	{
		
		try {
			ls = BankUtility.readAccountFromFile();					//ReadFiles from BankUtility.java file
			clientList = BankUtility.readClientFromFile();			// ReadClient from BankUtility.java file
			JOptionPane.showMessageDialog(null, "LAMBTON BANK");
			menu();			//Goto Menu class
		}catch(Exception  e) {
			JOptionPane.showMessageDialog(null, "Operation failed due to inavlid input. Please start again.");
			/*
			 * try { 
			 * 		menu(); 
			 * } catch (IOException e1) { // TODO Auto-generated catch block
			 * e1.print(); }
			 */
		}
	}
	
	//SohelTharani616
	//Provides SubMenu to user
	private static void subMenu(String clientId, String accNoInput) throws IOException 
	{
		//Ask user for its choice that he want to do
		String choice1 = JOptionPane.showInputDialog(null, "1. To Display Account Details \n "
				+ "2. To Display Account Balance  \n"
				+ "3. To Update Account Details  \n"
				+ "4. To Deposit Money  \n"
				+ "5. To Draw Money \n"
				+ "6. To Transfer Money to other account within Bank \n"
				+ "7. To Pay Bills  \n"
				+ "8. Go to Main Menu \n"
				+ "9. To Exit \n"
				+ "Please enter your choice :: ");
			
		//Retrieve the account
		int choice = Integer.parseInt(choice1);
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
				depositMoney(acc);
				subMenu(clientId,accNoInput);	//Again ask user that what he want to do
				break;
				
			case 5 :
				withdrawMoney(acc);
				subMenu(clientId,accNoInput);	//Again ask user that what he want to do
				break;
			case 6 :
				transferMoney(acc);
				subMenu(clientId,accNoInput);	//Again ask user that what he want to do
				break;
			case 7 :
				payBills(acc);
				subMenu(clientId,accNoInput);	//Again ask user that what he want to do
				break;
			case 8 :
				menu();		//Goto Main menu
				break;
				
			case 9 :
				JOptionPane.showMessageDialog(null, "Exiting Thank you ...");
				System.exit(0);				//Exit the system
				
		}
	}
		
	//@SohelTharani616
	//Deposit Money method
	private static void depositMoney(Account acc) 
	{	
		//Ask for Deposit Amount
		
		
		String amt = JOptionPane.showInputDialog(null, "Please enter the amount to deposit. ");
		double amount = Double.parseDouble(amt);
		acc.setBalance(acc.getBalance() +amount);
		System.out.println("Deposit done");
		System.out.println("New Balance ::" + acc.getBalance());
		JOptionPane.showMessageDialog(null, "Deposite done \n "+"New Balance ::" + acc.getBalance());
			
	}


	//@SohelTharani616
	//This method will transfer money to another account
	private static void transferMoney(Account acc) 
	{
		// TODO Auto-generated method stub
		
		//Ask for account number
		String accNo2 = JOptionPane.showInputDialog(null, "Please enter the account no to which money need to transfer.");
		
		Account ac2 = getAccount(accNo2);
		
		//Check for account
		if(ac2 == null) 
		{
			JOptionPane.showMessageDialog(null, "Account do not exist");
			return;
		}

		//Ask for amount
		String amt = JOptionPane.showInputDialog(null, "Please enter the amount to transfer.");
		double amount = Double.parseDouble(amt);
			
		//Check for balance availability. If available then transfer
		if(acc.getBalance() > amount) 
		{
			acc.setBalance(acc.getBalance() -amount);
			ac2.setBalance(ac2.getBalance() +amount);
			JOptionPane.showMessageDialog(null, "Transfer done \n New Balance :: "+acc.getBalance());			
		} 
		else 
		{
			JOptionPane.showMessageDialog(null, "Low balance  can't be allowed to transfer");
		}
	}


	//@SohelTharani616
	//Update existing account details
	private static void updateAccountDetail(Account ac) 
	{
		// TODO Auto-generated method stub
		
		//Ask for first name to update
		String fName = JOptionPane.showInputDialog(null, "Please enter the first name. ");
		ac.setfName(fName);
		
		//Ask for last name to update
		ac.setlName(JOptionPane.showInputDialog(null, "Please enter the last name. "));
		
		//Ask for address to update
		ac.setAddress(JOptionPane.showInputDialog(null, "Please enter the address. "));
		
		//Ask for phone number to update
		ac.setPhoneNo(JOptionPane.showInputDialog(null, "Please enter the phone no. "));
		
		//Save details to file
		BankUtility.saveClientToFile(clientList);
		
	}
		
	//@SohelTharani616
	//This method is for registering a new user
	public static void Registration() throws IOException
	{
		
		JOptionPane.showMessageDialog(null, "Registration");
		
		//Accept Client Name & Password
		String clientName = JOptionPane.showInputDialog(null, "Enter a client:");	
		String password = JOptionPane.showInputDialog(null, "Enter a Password:");
		
		//Create  new client
		Client client = new Client();
			//to add client
			
	}
		
}