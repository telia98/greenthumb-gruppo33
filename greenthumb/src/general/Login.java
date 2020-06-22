package general;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel logoPanel;
	private JPanel appNamePanel;
	private JPanel usernamePanel;
	private JPanel passwordPanel;
	private JPanel loginPanel;
	
	public Login(JFrame frame) {
		Font fontBig = new Font("Herculanum", Font.BOLD, 45);
		Font fontMedium = new Font("Herculanum", Font.BOLD, 25);
		Font font = new Font("Comic sans", Font.PLAIN, 15);
		
		logoPanel= new JPanel();
		logoPanel.setBackground(Color.WHITE);
		appNamePanel= new JPanel();
		appNamePanel.setBackground(Color.WHITE);
		usernamePanel= new JPanel();
		usernamePanel.setBackground(Color.WHITE);
		passwordPanel= new JPanel();
		passwordPanel.setBackground(Color.WHITE);
		loginPanel= new JPanel();
		loginPanel.setBackground(Color.WHITE);
		
		
		// inizio elementi logoPanel
		JButton logo=new JButton();
				
		logo.setPreferredSize(new Dimension(200,200)); //qui puoi settare le dimensioni del tuo pulsante , la foto si adattera (Se però le proporzioni non sono giuste si deforma anche)

		try {
			Image logoImg=ImageIO.read(new File("img/logo.png"));
			logoImg=logoImg.getScaledInstance(80,80,Image.SCALE_SMOOTH);
			ImageIcon icona=new ImageIcon(logoImg);
			logo.setIcon(icona); 
			logo.setBorder(null); 
			logo.setFocusPainted(false); //per non far uscire i bordi blu del bottone quando selezionato
			logo.setVisible(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
				
		logoPanel.setLayout(new GridLayout(1,3)); //1 riga, 3 colonne
		logoPanel.add(new JLabel(""));
		logoPanel.add(logo);
		logoPanel.add(new JLabel(""));
		
		class LogoListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false); //rendo invisibile il pannello del login
				frame.add(new Homepage(frame)); //aggiungiamo al frame il pannello della homepage
			}
		}
		
		//collego il listener al bottone login
		ActionListener logoListener=new LogoListener();
		logo.addActionListener(logoListener);
		
		// fine elementi logoPanel
				
		//inizio elementi appNamePanel
		JLabel appName=new JLabel("<html><center>GreenThumb</center></html>");
		appName.setFont(fontMedium);
		appName.setForeground(new Color(45,174,0));
		appName.setVisible(true);
		appNamePanel.add(appName);
		//fine elementi appNamePanel
		
		//inizio elementi usernamePanel
		JLabel username=new JLabel("<html><center>nome utente</center></html>");
		username.setFont(font);
		JTextField usernameInput=new JTextField("camilla_rossi",10);
		usernameInput.setEditable(false);
		usernamePanel.add(username);
		usernamePanel.add(usernameInput);
		//fine elementi usernamePanel
		
		//inizio elementi passwordPanel
		JLabel password=new JLabel("<html><center>password</center></html>");
		password.setFont(font);
		JTextField passwordInput=new JTextField("*********",10);
		passwordInput.setEditable(false);
		passwordPanel.add(password);
		passwordPanel.add(passwordInput);
		//fine elementi passwordPanel
		
		//inizio elementi loginPanel
		JButton accedi=new JButton("accedi");
		accedi.setForeground(new Color(45,174,0));
		accedi.setFont(fontMedium);
		accedi.setFocusPainted(false); 
		accedi.setVisible(true);
		
		class LoginListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false); //rendo invisibile il pannello della homepage
				frame.add(new MenuPrincipale(frame)); //aggiungiamo al frame il pannello del login
			}
		}
		
		//collego il listener al bottone login
		ActionListener loginListener=new LoginListener();
		accedi.addActionListener(loginListener);
		
		loginPanel.add(accedi);
		//fine elementi loginPanel
		
		setLayout(new GridLayout(5,1));
		logoPanel.setVisible(true);
		appNamePanel.setVisible(true);
		usernamePanel.setVisible(true);
		passwordPanel.setVisible(true);
		loginPanel.setVisible(true);
		add(logoPanel);
		add(appNamePanel);
		add(usernamePanel);
		add(passwordPanel);
		add(loginPanel);
		setVisible(true);
	}    
}
