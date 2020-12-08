package finalProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Akhil Sebastian 658
 *
 */
public class MainPage implements ActionListener {
	
	private static JPanel panelMainPage;
	private static JFrame frameMainPage;
	private static JLabel headinglabel1;
	private static JButton existButton;
	private static JButton newButton;
	
	public void mainPage() {
		
		panelMainPage = new JPanel();
		frameMainPage = new JFrame();
		frameMainPage.setSize(700,500);
		frameMainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frameMainPage.add(panelMainPage);
		
		panelMainPage.setLayout(null);
		
		frameMainPage.setVisible(true);
		
		headinglabel1 = new JLabel("Welcome to XYZ Bank");
		headinglabel1.setBounds(210,100,300,25);
		panelMainPage.add(headinglabel1);
		
		existButton = new JButton("Login");
        existButton.setBounds(160, 250, 80, 25);
        existButton.addActionListener(new MainPage());
        panelMainPage.add(existButton);
        
		JLabel headinglabel2 = new JLabel("Existing Customer ");
		headinglabel2.setBounds(150,300,300,25);
		panelMainPage.add(headinglabel2);
		
		newButton = new JButton("Signup");
        newButton.setBounds(450, 250, 80, 25);
        newButton.addActionListener(new MainPage());
        panelMainPage.add(newButton);
		
		JLabel headinglabel3 = new JLabel("New Customer ");
		headinglabel3.setBounds(450,300,300,25);
		panelMainPage.add(headinglabel3);
		
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==newButton){
			frameMainPage.dispose();
			System.out.println("new");
		}
		if(e.getSource()==existButton){
			frameMainPage.dispose();
			System.out.println("old");
		}
		
	
		
	}

}
