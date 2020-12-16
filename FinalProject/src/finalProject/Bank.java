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
	
	
	//@AhmedRaza520 (After Account.java)
	private static void listAccount() {
		
		System.out.println("Account no  \t Account Name");
		for(Account ac : ls)
		{
			System.out.println(ac.getAccNo() + "\t" +ac.getfName() +" " + ac.getlName());
		}
	}
	
	//@SohelTharani616 (After BankUtility.java)
	public static void main(String[] args) 
	{
		
		try { 
			ls = BankUtility.readAccountFromFile();			//ReadFiles from BankUtility.java file
			clientList = BankUtility.readClientFromFile();	// ReadClient from BankUtility.java file
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
			 * 		e1.printStackTrace(); 
			 * }
			 */
		}
		
	}
		
	//@AhmedRaza520
	private static void accountActivity() throws IOException 
	{
		//Ask for clientId
		String clientId = JOptionPane.showInputDialog(null, "Enter Your ClientId:");
		
		//Ask for password
		String password = JOptionPane.showInputDialog(null, "Enter Your Password:");
		
		
		if(checkClientExist(clientId,password)) {
			
			String accountNo = JOptionPane.showInputDialog(null, "Please enter the account no to operate :");
			if(checkAccoutnExist(accountNo)) 
			{
				subMenu(clientId,accountNo);
			} 
			else 
			{
				JOptionPane.showMessageDialog(null, "Invalid Account No");
			}
			
			
		} else {
			JOptionPane.showMessageDialog(null, "Username password not exist");
		}
	}
	
	//@SohelTharani616-1
	private static void subMenu(String clientId, String accNoInput) throws IOException 
	{
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
		Account acc  = getAccount(accNoInput);
		switch(choice) {
			case 1 :
				printAccountDeatil(acc);
				subMenu(clientId,accNoInput);
				break;
			case 2 :
				printAccountBalance(acc);
				subMenu(clientId,accNoInput);
				break;
			case 3 :
				updateAccountDetail(acc);
				subMenu(clientId,accNoInput);
				break;
			case 4 :
				withdrawMoney(acc);
				subMenu(clientId,accNoInput);
				break;
			case 5 :
				transferMoney(acc);
				subMenu(clientId,accNoInput);
				break;
			case 6 :
				payBills(acc);
				subMenu(clientId,accNoInput);
				break;
			case 7 :
				menu();
				break;
				
			case 8 :
				System.out.println("Exiting Thank you ...");
				System.exit(0);
				
		}
	}
	
	//@AhmedRaza520 (after account.java)
	private static void payBills(Account acc) {
		
		System.out.println("Please enter the amount to pay bills. ");
		String amt = JOptionPane.showInputDialog(null, "Please enter the amount to pay bills. ");
		double amount = Double.parseDouble(amt);
		if(acc.getBalance() > amount) {
			acc.setBalance(acc.getBalance() -amount);
			
			JOptionPane.showMessageDialog(null, "Payment done \n  New Balance ::\n" + acc.getBalance());
			System.out.println("Payment done");
			System.out.println("New Balance ::" + acc.getBalance());
		} else {
			System.out.println("Low balance  can't be allowed to pay");
		}
		
	}



	//@SohelTharani616 (after account.java)
	private static void withdrawMoney(Account acc) {
		System.out.println("Please enter the amount to withdraw. ");
		
		String amt = JOptionPane.showInputDialog(null, "Please enter the amount to withdraw. ");
		double amount = Double.parseDouble(amt);
		if(acc.getBalance() > amount) 
		{
			
			acc.setBalance(acc.getBalance() -amount);
			System.out.println("Withdraw done");
			System.out.println("New Balance ::" + acc.getBalance());
			
			
			JOptionPane.showMessageDialog(null, "Withdraw done \n "+"New Balance ::" + acc.getBalance());
		} else {
			JOptionPane.showMessageDialog(null, "Low balance  can't be allowed to withdraw");
			System.out.println("Low balance  can't be allowed to withdraw");
		}
	}



	//@AhmedRaza520 After account.java
	private static void transferMoney(Account acc) {
		// TODO Auto-generated method stub
		
		System.out.println("Please enter the account no to which money need to transfer. ");

		String accNo2 = JOptionPane.showInputDialog(null, "Please enter the account no to which money need to transfer.");
		
		Account ac2 = getAccount(accNo2);
		
		if(ac2 == null) {
			JOptionPane.showMessageDialog(null, "Account no not exist");
			System.out.println("Account no not exist");
			return;
		}

		System.out.println("Please enter the amount to transfer. ");
		String amt = JOptionPane.showInputDialog(null, "Please enter the amount to transfer.");
		double amount = Double.parseDouble(amt);
		
		if(acc.getBalance() > amount) {
			acc.setBalance(acc.getBalance() -amount);
			ac2.setBalance(ac2.getBalance() +amount);
			JOptionPane.showMessageDialog(null, "Transfer done \n New Balance :: "+acc.getBalance());
			System.out.println("Transfer done");
			System.out.println("New Balance ::" + acc.getBalance());
			
		} else {
			JOptionPane.showMessageDialog(null, "Low balance  can't be allowed to transfer");
			System.out.println("Low balance  can't be allowed to transfer");
		}
	}



	//@SohelTharani616 (after account.java)
	private static void updateAccountDetail(Account ac) {
		// TODO Auto-generated method stub
		
		String fName = JOptionPane.showInputDialog(null, "Please enter the first name. ");
		System.out.println("Please enter the first name. ");
		ac.setfName(fName);
		
		
		System.out.println("Please enter the last name.  ");
		ac.setlName(JOptionPane.showInputDialog(null, "Please enter the last name. "));
		System.out.println("Please enter the address.  ");
		
		ac.setAddress(JOptionPane.showInputDialog(null, "Please enter the address. "));
		
		System.out.println("Please enter the phone no  ");
		ac.setPhoneNo(JOptionPane.showInputDialog(null, "Please enter the phone no. "));
		
		BankUtility.saveClientToFile(clientList);
		
	}



	//@AhmedRaza520 (after account.java)
	private static void printAccountBalance(Account acc) {
		
		JOptionPane.showMessageDialog(null, "Account balance is ::" + acc.getBalance());
		System.out.println("Account balance is ::" + acc.getBalance());
		
	}



	//@AhmedRaza520
	private static void printAccountDeatil(Account acc) {
		
		
		JOptionPane.showMessageDialog(null, acc.toString());
		System.out.println(acc.toString());
	}



	//@AhmedRaza520(after account.java)
	static boolean checkAccoutnExist(String acc) {
		
	boolean exist = false;
		try {
			for(Account ac : ls) {
				if(ac.getAccNo() == Integer.parseInt(acc)) {
					exist =true;
				}
			}
		}catch (Exception e) {
		}
		return exist;
	}
	
	//@AhmedRaza520 (after client.java)
	static boolean checkClientExist(String clientId, String password) {
		
		boolean exist = false;
			try {
				for(Client ct :clientList) {
					if(ct.getClientId().equals(clientId) && ct.getPassword().equals(password) ) {
						exist =true;
					}
				}
			}catch (Exception e) {
			}
			return exist;
		}
	//@AhmedRaza520 (after client.ajav)
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

	//@AhmedRaza520(after account.java)
	static Account getAccount(String accNo) {
		
		Account acc = null;
			try {
				for(Account ac : ls) {
					if(ac.getAccNo() == Integer.parseInt(accNo)) {
						acc =ac;
					}
				}
			}catch (Exception e) {
			}
			return acc;
		}
	
	//@SohelTharani616 can do it
	public static void addAccountForClient() {
		
		
		String clientId = JOptionPane.showInputDialog(null, "Add Account for client \n"
				+ "Enter a client id:");
		
		Client c =checkClientExist(clientId);
		if(c!=null) {
			accountCreation(c);
		}else {
			JOptionPane.showMessageDialog(null, "Client ID doesn't exist");
		}
		
	}
	//@SohelTharani616 cdi
	public static void Registration() throws IOException
	{
		
		JOptionPane.showMessageDialog(null, "Registration");
		
		String clientName = JOptionPane.showInputDialog(null, "Enter a client:");	
		String password = JOptionPane.showInputDialog(null, "Enter a Password:");
		
		Client client = new Client();
		client.setPassword(password);
		client.setClientId(++Client.count + "");
		clientList.add(client);		
		accountCreation(client);
		
	}
	
	//@SohelTharani616 Hold for account.java
	private static void accountCreation(Client client) {
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
		ac.setAccNo(++Account.count );
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
				BankUtility.saveClientToFile(clientList);
				break;

		case 2: 
				ac.setType("Business Account");	
				String orgName = JOptionPane.showInputDialog(null, "Enter your Organization Name:");
				ac.setOrgName(orgName); 
				String bal1 = JOptionPane.showInputDialog(null, "Enter your inital balance:");
				ac.setBalance(Double.parseDouble(bal1));
				ls.add(ac);
				client.getAccounts().add(ac);
				BankUtility.saveClientToFile(clientList);
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
				BankUtility.saveClientToFile(clientList);
				break;

		default: JOptionPane.showMessageDialog(null, "Invalid Input");
		}
			
		JOptionPane.showMessageDialog(null, "Client and Acccount Created Successfully \n Client ID ::" + client.getClientId()
		+ " \n Account No :: "+ac.getAccNo());
	}
	
	
	//@AhmedRaza520
	public static void BankerLogin() throws IOException
	{
		String userName = JOptionPane.showInputDialog(null, "Enter Your Username:");
		//Open the File
		
			String password = JOptionPane.showInputDialog(null, "Enter Your Password:");
			if ("Admin".equals(password))
			{
				JOptionPane.showMessageDialog(null, "Login Successfull");
				String choice = JOptionPane.showInputDialog(null, "1. To create Client account \n 2. Add account for existing client  \n 3.To Logout \n Enter your choice:");
				if(choice .equals("1")) {
					Registration();
				}else if (choice.equals("2")){
					
					addAccountForClient();
				} 
				
				else if (choice.equals("3")){
					
					JOptionPane.showMessageDialog(null, "Log out Successfull");
				}
				
				
			}
			else JOptionPane.showMessageDialog(null, "Incorrect Password");
	}
	
}
