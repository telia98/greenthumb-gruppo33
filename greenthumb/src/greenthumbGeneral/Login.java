package greenthumbGeneral;

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

public class Login extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel logoPanel;
	private JPanel appNamePanel;
	private JPanel loginPanel;
	
	public Login() {
		
		Font fontBig = new Font("Herculanum", Font.BOLD, 45);
		Font fontMedium = new Font("Herculanum", Font.BOLD, 25);
		Font font = new Font("Comic sans", Font.PLAIN, 13);
		
		logoPanel= new JPanel();
		logoPanel.setBackground(Color.WHITE);
		appNamePanel= new JPanel();
		appNamePanel.setBackground(Color.WHITE);
		loginPanel= new JPanel();
		loginPanel.setBackground(Color.WHITE);
		
		// inizio elementi logoPanel
		JButton logo=new JButton();
				
		logo.setPreferredSize(new Dimension(250,250)); //qui puoi settare le dimensioni del tuo pulsante , la foto si adattera (Se però le proporzioni non sono giuste si deforma anche)

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
		// fine elementi logoPanel
				
		//inizio elementi appNamePanel
		JLabel appName=new JLabel("<html><center>GreenThumb</center></html>");
		appName.setFont(fontMedium);
		appName.setForeground(new Color(45,174,0));
		appName.setVisible(true);
		appNamePanel.add(appName);
		//fine elementi appNamePanel
		
		logoPanel.setVisible(true);
		appNamePanel.setVisible(true);
		loginPanel.setVisible(true);
		add(logoPanel);
		add(appNamePanel);
		add(loginPanel);
		setVisible(true);
	}
}
