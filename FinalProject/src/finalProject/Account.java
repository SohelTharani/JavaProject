/**
 * 
 */
package finalProject;

import java.io.Serializable;

/**
 * @author akhil Sebastian C0794658
 *
 */

public class Account  implements Serializable 
{
	/**
	 * @param args
	 * @throws IOException 
	 */
	
	// variables declaration
	private static final long serialVersionUID = 1L;
	
	
	static int count =1001;
	
	String fName;
	String lName;
	String phoneNo;
	String address;
	Integer accNo;
	String type;
	String gender;
	String age;
	String orgName;
	String age2;
	String jointName;
	
	Double balance = 0.0;
	
	
	// generating  getters for user information
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getAge2() {
		return age2;
	}
	public void setAge2(String age2) {
		this.age2 = age2;
	}
	public String getJointName() {
		return jointName;
	}
	public void setJointName(String jointName) {
		this.jointName = jointName;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public Integer getAccNo() {
		return accNo;
	}
	
	//Account No. was not providing unique Acc No because accNo was not incremented.
	public void setAccNo(int accNo) {
		this.accNo = accNo+1;
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	// For user information
	
	public Account(String fName, String lName, String phoneNo, String address, int accNo) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.phoneNo = phoneNo;
		this.address = address;
		count=count+1;
		this.accNo = count;
		
	}
	@Override
	
	//   user information as per the account type selected
	public String toString() {
		if(type.equalsIgnoreCase("Saving Account")) {
			return "Account First Name = " + fName + " \n Last Name = " + lName + " \n Gender = "+
					gender + " \n  + age = "+age + " \n balance = "+ balance;
		}else if (type.equalsIgnoreCase("Business Account")){
			
			return "Account First Name = " + fName + " \n Last Name = " + lName + " \n Organization = "+
					orgName +  " \n balance = "+ balance;
			
		}else {
			return "Account First Name = " + fName + " \n Last Name = " + lName + " \n Joint-Account Holder's Full Name = "+
					jointName + " \n  + Joint-Account Holder's age = "+age2 +  " \n balance = "+ balance;
			
		}
		
		
	}
	// Returning account types and account number
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Account.count = count;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setAccNo(Integer accNo) {
		this.accNo = accNo;
	}
	
	
	
	
}