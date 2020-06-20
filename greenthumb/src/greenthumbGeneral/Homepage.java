package greenthumbGeneral;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Homepage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel logoPanel;
	private JPanel infoPanel;
	private JPanel loginPanel;
	
	public Homepage() {
		Font font = new Font("Comic sans", Font.BOLD, 17);
		
		logoPanel= new JPanel();
		infoPanel= new JPanel();
		loginPanel= new JPanel();
		
		//elementi logoPanel
		JButton logo=new JButton();
		logo.setContentAreaFilled(false); 
		logo.setBorder(null); 
		logo.setFocusPainted(false); //per non far uscire i bordi blu del bottone quando selezionato
		logo.setIcon(new ImageIcon("img/logo.png"));
		logo.setSize(100, 100);
		logo.setVisible(true);
		
		JLabel appName=new JLabel("<html><center>GreenThumb</center></html>");
		appName.setFont(font);
		appName.setForeground(new Color(45,174,0));
		appName.setVisible(true);
		
		logoPanel.setLayout(new GridLayout(2,3)); //2 righe, 3 colonne
		logoPanel.add(new JLabel(""));
		logoPanel.add(logo);
		logoPanel.add(new JLabel(""));
		logoPanel.add(new JLabel(""));
		logoPanel.add(appName);
		logoPanel.add(new JLabel(""));
		
		//elementi infoPanel
		JLabel welcome=new JLabel("<html><center> Benvenuto! <br><br></center><html>");
		welcome.setFont(font);
		welcome.setForeground(new Color(45,174,0)); //RGB colore verde del logo
		JLabel infoApp = new JLabel("<html><center>L'applicazione ti dà la possibilità di<br>gestire i tuoi impianti d'irrigazione e i relativi costi,<br>e verificare lo stato delle tue colture.<br><br>Effettua il login per cominciare!</center></html>");
		infoPanel.add(welcome);
		infoPanel.add(infoApp);
		
		//elementi loginPanel
		JButton login=new JButton("Login");
		login.setForeground(new Color(45,174,0));
		login.setFont(font);
		logo.setFocusPainted(false); 
		login.setSize(300,500);
		login.setVisible(true);
		loginPanel.add(login); //aggiungo il pannello a sud del frame
		
		//setting Jpanel schermata homepage
		logoPanel.setVisible(true);
		infoPanel.setVisible(true);
		loginPanel.setVisible(true);
		
		setLayout(new GridLayout(3,1));
		add(logoPanel);
		add(infoPanel);
		add(loginPanel);
	}

}
