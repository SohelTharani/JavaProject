/**
 * 
 */
package finalProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author Akhil Sebastian-658
 *
 */

public class Login  implements ActionListener{
	private static JPanel panelLogin;
	private static JFrame frameLogin;
	private static JLabel usernamelabel;
	private static JTextField usernameText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton loginButton, cancelButton;
	private String username, password;
	
	
	
	public void loginPage() {
		panelLogin = new JPanel();
		frameLogin = new JFrame();
		frameLogin.setSize(700,500);
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frameLogin.add(panelLogin);
		
		panelLogin.setLayout(null);
		JLabel headinglabel = new JLabel("Please enter your username and password");
		headinglabel.setBounds(210,100,300,25);
		panelLogin.add(headinglabel);
		
		usernamelabel = new JLabel("USERNAME");
		usernamelabel.setBounds(200,150,80,25);
		panelLogin.add(usernamelabel);
		
		usernameText = new JTextField(20);
        usernameText.setBounds(300,150,165,25);
        panelLogin.add(usernameText);
		
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(200,200,80,25);
        panelLogin.add(passwordLabel);
        
        passwordText = new JPasswordField(20);
        passwordText.setBounds(300,200,165,25);
        panelLogin.add(passwordText);
        
        loginButton = new JButton("Login");
        loginButton.setBounds(320, 250, 80, 25);
        loginButton.addActionListener(new Login());
        panelLogin.add(loginButton);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(320, 300, 80, 25);
        cancelButton.addActionListener(new Login());
        panelLogin.add(cancelButton);
                
		frameLogin.setVisible(true);
		
		
		
	
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==loginButton){
			frameLogin.dispose();
			username = usernameText.getText();
			password = passwordText.getText();
			if(username.equals("user") && password.equals("pass")) {
			System.out.println("login");
			}else
				System.out.println("fail");
				
			
		}
		if(e.getSource()==cancelButton){
			frameLogin.dispose();
			System.out.println("cancel");
		}
		
		
	}
	

}
