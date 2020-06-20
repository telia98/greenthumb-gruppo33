package greenthumbGeneral;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Homepage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel logoPanel;
	private JPanel appNamePanel;
	private JPanel welcomePanel;
	private JPanel infoPanel;
	private JPanel loginPanel;
	
	public Homepage() {
		Font fontBig = new Font("Herculanum", Font.BOLD, 45);
		Font fontMedium = new Font("Herculanum", Font.BOLD, 25);
		Font font = new Font("Comic sans", Font.PLAIN, 13);
		
		logoPanel= new JPanel();
		logoPanel.setBackground(Color.WHITE);
		appNamePanel= new JPanel();
		appNamePanel.setBackground(Color.WHITE);
		welcomePanel= new JPanel();
		welcomePanel.setBackground(Color.WHITE);
		infoPanel= new JPanel();
		infoPanel.setBackground(Color.WHITE);
		loginPanel= new JPanel();
		loginPanel.setBackground(Color.WHITE);
		
		//elementi logoPanel
		JButton logo=new JButton();
		
		//qui puoi settare le dimensioni del tuo pulsante , la foto si adattera (Se però le proporzioni non sono giuste si deforma anche)
		logo.setPreferredSize(new Dimension(250,250));
		
		try {
			Image logoImg=ImageIO.read(new File("/Users/teresaelia/git/greenthumb-gruppo33/greenthumb/img/logo.png"));
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
		
		//elementi appNamePanel
		JLabel appName=new JLabel("<html><center>GreenThumb</center></html>");
		appName.setFont(fontBig);
		appName.setForeground(new Color(45,174,0));
		appName.setVisible(true);
		appNamePanel.add(appName);
		
		//elementi welcomePanel
		JLabel welcome=new JLabel("<html><center> Benvenuto! <br></center><html>");
		welcome.setFont(fontMedium);
		welcome.setForeground(new Color(45,174,0)); //RGB colore verde del logo
		welcomePanel.add(welcome);
		
		//elementi infoPanel
		JLabel infoApp = new JLabel("<html><center>L'applicazione ti dà la possibilità di<br>gestire i tuoi impianti d'irrigazione,<br>monitorare le relative spese<br>e verificare lo stato delle tue colture.<br><br>Effettua il login per cominciare!<br><br><br><br></center></html>");
		infoApp.setFont(font);
		infoPanel.add(infoApp,BorderLayout.NORTH);
		
		//elementi loginPanel
		JButton login=new JButton("Login");
        login.setForeground(new Color(45,174,0));
		login.setFont(fontMedium);
		login.setFocusPainted(false); 
		login.setVisible(true);
		loginPanel.add(login);
		
		//setting Jpanel schermata homepage
		logoPanel.setVisible(true);
		appNamePanel.setVisible(true);
		welcomePanel.setVisible(true);
		infoPanel.setVisible(true);
		loginPanel.setVisible(true);
		
		setLayout(new GridLayout(5,1));
		add(logoPanel);
		add(appNamePanel);
		add(welcomePanel);
		add(infoPanel);
		add(loginPanel);
	}

}
