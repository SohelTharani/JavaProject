/**
 * 
 */
package finalProject;

import java.io.Serializable;
import java.util.ArrayList;

import java.io.Serializable;
import java.util.ArrayList;

 /* @author HariniSivakumar-495
 *
 */

public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;

	static int count =10001;
	
	String clientId;
	String clientName;
	String password;
	ArrayList<Account>  accounts = new ArrayList<Account>();
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	
}