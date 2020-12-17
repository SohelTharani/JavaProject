/**
 * 
 */
package finalProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;  

/**
 * @author Sohel Tharani - 616, Ahmed Raza - 520
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
		client.setPassword(password);				//Set password for new client
		client.setClientId(++Client.count + "");	//Provide client ID
		clientList.add(client);						//Insert client in the list
		accountCreation(client);					//Create account by asking more personal details
			
	}
	
	//@AhmedRaza520
			//This method will provide the Account lists
			private static void listAccount() 
			{
				System.out.println("Account no  \t Account Name");
				for(Account ac : ls)		//ls is the ArrayList of Account
				{
					System.out.println(ac.getAccNo() + "\t" +ac.getfName() +" " + ac.getlName());
				}
			}
			
			//@AhmedRaza520
			//This method will check whether account exists or not
			private static void accountActivity() throws IOException 
			{
				
				String clientId = JOptionPane.showInputDialog(null, "Enter Your ClientId:");
				String password = JOptionPane.showInputDialog(null, "Enter Your Password:");
					
				if(checkClientExist(clientId,password)) 
				{
						
					String accountNo = JOptionPane.showInputDialog(null, "Please enter the account no to operate :");
					if(checkAccoutnExist(accountNo)) 
					{
						subMenu(clientId,accountNo);
					} 
					else 
					{
						JOptionPane.showMessageDialog(null, "Invalid Account No");
					}	
				} 
				else 
				{
					JOptionPane.showMessageDialog(null, "Username password not exist");
				}
			}
				
			//@AhmedRaza520
			//This method will pay all the bills
			private static void payBills(Account acc) 
			{
				System.out.println("Please enter the amount to pay bills. ");
				String amt = JOptionPane.showInputDialog(null, "Please enter the amount to pay bills. ");
				double amount = Double.parseDouble(amt);
				
				//This if-else will check whether the account have sufficient balance or not
				
				if(acc.getBalance() > amount) {
					acc.setBalance(acc.getBalance() -amount);		// Deduct entered account
					
					JOptionPane.showMessageDialog(null, "Payment done \n  New Balance ::\n" + acc.getBalance());
				} 
				else 
				{
					JOptionPane.showInputDialog(null, "Low balance  can't be allowed to pay");
				}
					
			}
				
			//@AhmedRaza520
			//This method will withdraw money with 10% of Transaction charges
			private static void withdrawMoney(Account acc) 
			{
				System.out.println("Please enter the amount to withdraw. ");
					
				//Ask user for input
				String amt = JOptionPane.showInputDialog(null, "Please enter the amount to withdraw. ");
				double amount = Double.parseDouble(amt);		//Convert String to Double
					
				//Check if balance is available or not
				if(acc.getBalance() > (amount +amount*0.10) ) 
				{
					acc.setBalance(acc.getBalance() -amount -amount*0.10);		//10% Transaction Charges
				
					JOptionPane.showMessageDialog(null, "Withdraw done \n "+"New Balance ::" + acc.getBalance() + "Transaction charges :: " + amount*0.10);
				} 
				else 
				{
					JOptionPane.showMessageDialog(null, "Low balance  can't be allowed to withdraw");
				}
			}
				
			//@AhmedRaza520
			//This method will displays the account balance
			private static void printAccountBalance(Account acc) 
			{
				JOptionPane.showMessageDialog(null, "Account balance is ::" + acc.getBalance());
			}



			//@AhmedRaza520
			// displays the account details 
			private static void printAccountDeatil(Account acc) 
			{		
					
				JOptionPane.showMessageDialog(null, acc.toString());
				
			}



			//@AhmedRaza520
			//This method will display T/F according to the condition  
			static boolean checkAccoutnExist(String acc) 
			{
					
				boolean exist = false;
				try {
					for(Account ac : ls) 
					{
						if(ac.getAccNo() == Integer.parseInt(acc)) // checking for account existence
						{
							exist =true;
						}
					}
					}catch (Exception e) {
				}
				return exist;
			}
				
			//@AhmedRaza520
			//This method provide account number
			static Account getAccount(String accNo) 
			{		
				Account acc = null;
				try 
				{
					for(Account ac : ls) 
					{
						if(ac.getAccNo() == Integer.parseInt(accNo)) 
						{
							acc =ac;
						}
					}
				}catch (Exception e) 
				{
				}
				return acc;
			}
				
			//@AhmedRaza520
			//This method is for the bank representative to log in to do banking
			public static void BankerLogin() throws IOException
			{
				String userName = JOptionPane.showInputDialog(null, "Enter Your Username:");
					
				String password = JOptionPane.showInputDialog(null, "Enter Your Password:");
				
				//Banker Username & password is Admin and Admin respectively
				//It will check whether the username and password is correct or not.
				if ("Admin".equals(password))
				{
					JOptionPane.showMessageDialog(null, "Login Successfull");
					String choice = JOptionPane.showInputDialog(null, "1. To create Client account \n 2. Add account for existing client  "
								+  "\n 3.To Logout \n Enter your choice:");
					if(choice .equals("1")) 
					{
						Registration();
					}else if (choice.equals("2"))
					{			
						addAccountForClient();
					} 
							
					else if (choice.equals("3"))
					{			
						JOptionPane.showMessageDialog(null, "Log out Successfull");
					}
							
							
							
				}
				else JOptionPane.showMessageDialog(null, "Incorrect Password");
			}
			
		//@SohelTharani616
			//This method will ask for more personal details from the user to create an account
		private static void accountCreation(Client client) 
		{
			String 	accType = JOptionPane.showInputDialog(null, "What type of Account do you want to create?\nPress 1 for Saving Account"
															+ "\nPress 2 for Business Account" + "\nPress 3 for Joint Account");
			int aT = Integer.parseInt(accType);
			
			double balance=0; //Initialize Balance
			
			String firstName = JOptionPane.showInputDialog(null, "Enter Your First Name:");
			
			String lastName = JOptionPane.showInputDialog(null, "Enter Your Last Name:");
			String AccNumS, b;
			
			
			Account ac = new Account();
			ac.setfName(firstName);
			ac.setlName(lastName);
			ac.setAccNo(Account.count+1 );		//Provide unique account number
			switch(aT)
			{
			case 1: 
					ac.setType("Saving Account");	
			
					String gender = JOptionPane.showInputDialog(null, "Enter your Gender:\nPress 1 for Male\nPress 2 for Female\n Press 3 for Others");
					int g = Integer.parseInt(gender);
					if (g==1)
						ac.setGender("Male"); 
					else if (g==2)
						ac.setGender("Female"); 
					else if (g==3)
						ac.setGender("Others"); 
					else JOptionPane.showMessageDialog(null, "Invalid Input");
					
					String age = JOptionPane.showInputDialog(null, "Enter your Age:");
					ac.setAge(age); 
					
					String bal = JOptionPane.showInputDialog(null, "Enter your inital balance:");
					ac.setBalance(Double.parseDouble(bal));
					ls.add(ac);
					client.getAccounts().add(ac);
					BankUtility.saveClientToFile(clientList);		//Save details to Client's ArrayList
					break;
				case 2: 
					ac.setType("Business Account");	
					String orgName = JOptionPane.showInputDialog(null, "Enter your Organization Name:");
					ac.setOrgName(orgName); 
					String bal1 = JOptionPane.showInputDialog(null, "Enter your inital balance:");
					ac.setBalance(Double.parseDouble(bal1));
					ls.add(ac);
					client.getAccounts().add(ac);
					BankUtility.saveClientToFile(clientList);		//Save details to Client's ArrayList
					break;
				case 3: 
					ac.setType("Joint Account");	
					String age1 = JOptionPane.showInputDialog(null, "Enter your Age:");
					ac.setAge(age1); 
					String jointAccName = JOptionPane.showInputDialog(null, "Enter Joint-Account Holder's Full Name:");
					ac.setJointName(jointAccName);
					String jointAge = JOptionPane.showInputDialog(null, "Enter Joint-Account Holder's Age:");
					ac.setAge2(jointAge);
					String bal2 = JOptionPane.showInputDialog(null, "Enter your inital balance:");
					ac.setBalance(Double.parseDouble(bal2));
					ls.add(ac);
					client.getAccounts().add(ac);					
					BankUtility.saveClientToFile(clientList);		//Save details to Client's ArrayList
					break;

				default: JOptionPane.showMessageDialog(null, "Invalid Input");
			}
					
			JOptionPane.showMessageDialog(null, "Client and Acccount Created Successfully \n Client ID ::" + client.getClientId()
				+ " \n Account No :: "+ac.getAccNo());
		}
		// HariniSivakumar-495
		static Client checkClientExist(String clientId) {
			
			boolean exist = false;
			Client c = null;
				try {
					for(Client ct :clientList) {
						if(ct.getClientId().equals(clientId))  {
							c=ct;
						}
					}
				}catch (Exception e) {
				}
				return c;
			}
		
		
		
		public static void addAccountForClient() {
			
			//@HariniSivakumar-495
			String clientId = JOptionPane.showInputDialog(null, "Add Account for client \n"
					+ "Enter a client id:");
			
			Client c =checkClientExist(clientId);
			if(c!=null) {
				accountCreation(c);
			}else {
				JOptionPane.showMessageDialog(null, "Client ID doesn't exist");
			}
			
		}
		
		//@AhmedRaza520 
		//Check Client existence in the clientList
		static boolean checkClientExist(String clientId, String password) 
		{	
			boolean exist = false;
			try {
					for(Client ct :clientList) 
					{
						if(ct.getClientId().equals(clientId) && ct.getPassword().equals(password) ) 
						{
								exist =true;
						}
					}
				}catch (Exception e) {
					}
					return exist;
		}
}