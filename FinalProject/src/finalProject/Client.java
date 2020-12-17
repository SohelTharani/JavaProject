/**
 * 
 */
package finalProject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author HariniSivakumar-495
 *
 */

public class Client implements Serializable {
	
	// Variable de declaration
	private static final long serialVersionUID = 1L;

	static int count =10001;
	
	String clientId;
	String clientName;
	String password;
	
	
	ArrayList<Account>  accounts = new ArrayList<Account>();
	// Returning  Client id 
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	// Returning  Client name 
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	// Client's password
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//Client,S account
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	
	
	
}
