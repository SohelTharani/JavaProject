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
	
		//@SohelTharani616
	public static void addAccountForClient() {
		
		
		String clientId = JOptionPane.showInputDialog(null, "Add Account for client \n"
				+ "Enter a client id:");
		
		//Client c =checkClientExist(clientId);
		if(c!=null) {
			accountCreation(c);
		}else {
			JOptionPane.showMessageDialog(null, "Client ID doesn't exist");
		}
		
	}
	//@SohelTharani616
	public static void Registration() throws IOException
	{
		
		JOptionPane.showMessageDialog(null, "Registration");
		
		String clientName = JOptionPane.showInputDialog(null, "Enter a client:");	
		String password = JOptionPane.showInputDialog(null, "Enter a Password:");
		
		/*Client client = new Client();
		client.setPassword(password);
		client.setClientId(++Client.count + "");
		clientList.add(client);		
		accountCreation(client);
		*/
	}
	
