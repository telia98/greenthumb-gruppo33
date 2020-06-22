package general;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

import amministrazione.Amministrazione;
import gestioneimpianto.GestioneImpianto;
import gestioneterreno.GestioneTerreno;
import statopiante.StatoPiante;

public class MenuPrincipale extends JPanel {

	private static final long serialVersionUID = 1L;
	JPanel exitPanel;
	JPanel logoPanel;
	JPanel appNamePanel;
	JPanel amministrazionePanel;
	JPanel gestioneTerrenoPanel;
	JPanel statoPiantePanel;
	JPanel gestioneImpiantoPanel;
	JPanel emptyPanel;
	
	public MenuPrincipale(JFrame frame) {
		Font fontBig = new Font("Herculanum", Font.BOLD, 45);
		Font fontMedium = new Font("Herculanum", Font.BOLD, 25);
		Font font = new Font("Comic sans", Font.BOLD, 13);
		
		exitPanel=new JPanel();
		exitPanel.setBackground(Color.WHITE);
		logoPanel=new JPanel();
		logoPanel.setBackground(Color.WHITE);
		appNamePanel=new JPanel();
		appNamePanel.setBackground(Color.WHITE);
		amministrazionePanel=new JPanel();
		amministrazionePanel.setBackground(Color.WHITE);
		gestioneTerrenoPanel=new JPanel();
		gestioneTerrenoPanel.setBackground(Color.WHITE);
		statoPiantePanel=new JPanel();
		statoPiantePanel.setBackground(Color.WHITE);
		gestioneImpiantoPanel=new JPanel();
		gestioneImpiantoPanel.setBackground(Color.WHITE);
		emptyPanel=new JPanel();
		emptyPanel.setBackground(Color.WHITE);
		
		//inzio elementi exitPanel
		JButton exit=new JButton();
		exit.setPreferredSize(new Dimension(90,90)); //qui puoi settare le dimensioni del tuo pulsante, la foto si adatterà

		try {
			Image exitImg=ImageIO.read(new File("img/exit.png"));
			exitImg=exitImg.getScaledInstance(40,40,Image.SCALE_SMOOTH);
			ImageIcon exitIcon=new ImageIcon(exitImg);
			exit.setIcon(exitIcon); 
			exit.setBorder(null); 
			exit.setFocusPainted(false); //per non far uscire i bordi blu del bottone quando selezionato
			exit.setVisible(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		exitPanel.setLayout(new GridLayout(1,4)); //1 riga, 3 colonne
		exitPanel.add(new JLabel(""));
		exitPanel.add(new JLabel(""));
		exitPanel.add(new JLabel(""));
		exitPanel.add(exit);
		
		class ExitListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false); //rendo invisibile il pannello del menu principale
				frame.add(new Homepage(frame)); //aggiungiamo al frame il pannello della homepage
			}
		}
		
		//collego il listener al bottone login
		ActionListener exitListener=new ExitListener();
		exit.addActionListener(exitListener);
		
		//fine elementi exitPanel
		
		//inizio elementi logoPanel
		JButton logo=new JButton();
		logo.setPreferredSize(new Dimension(180,180)); //qui puoi settare le dimensioni del tuo pulsante , la foto si adattera (Se però le proporzioni non sono giuste si deforma anche)

		try {
			Image logoImg=ImageIO.read(new File("img/logo.png"));
			logoImg=logoImg.getScaledInstance(80,80,Image.SCALE_SMOOTH);
			ImageIcon icona=new ImageIcon(logoImg);
			logo.setIcon(icona); 
			logo.setBorder(null); 
			logo.invalidate();
			logo.setFocusPainted(false); //per non far uscire i bordi blu del bottone quando selezionato
			logo.setVisible(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		logoPanel.setLayout(new GridLayout(1,3)); //1 riga, 3 colonne
		logoPanel.add(new JLabel(""));
		logoPanel.add(logo);
		logoPanel.add(new JLabel(""));
		//fine elementi logoPanel
		
		//inizio elementi appNamePanel
		JLabel appName=new JLabel("<html><center>GreenThumb</center></html>");
		appName.setFont(fontMedium);
		appName.setForeground(new Color(45,174,0));
		appName.setVisible(true);
		appNamePanel.add(appName);
		//fine elementi appNamelPanel
		
		//inizio elementi amministrazionePanel
		JButton amministrazione=new JButton();
		amministrazione.setPreferredSize(new Dimension(40,40)); //qui puoi settare le dimensioni del tuo pulsante , la foto si adattera (Se però le proporzioni non sono giuste si deforma anche)

		try {
			Image soldiImg=ImageIO.read(new File("img/adminLogo.png"));
			soldiImg=soldiImg.getScaledInstance(35,35,Image.SCALE_SMOOTH);
			ImageIcon icona=new ImageIcon(soldiImg);
			amministrazione.setIcon(icona); 
			amministrazione.setBorder(null); 
			amministrazione.setFocusPainted(false); //per non far uscire i bordi blu del bottone quando selezionato
			amministrazione.setVisible(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		JButton gotoAmministrazione=new JButton("Amministrazione   >");
		gotoAmministrazione.setFocusPainted(false);
		gotoAmministrazione.setForeground(new Color(230,202,60));
		gotoAmministrazione.setBorder(null); 
		gotoAmministrazione.setFont(font);
		
		amministrazionePanel.add(amministrazione);
		amministrazionePanel.add(gotoAmministrazione);
		
		class AmministrazioneListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false); //rendo invisibile il pannello del menu principale
				frame.add(new Amministrazione(frame)); //aggiungiamo al frame il pannello della homepage
			}
		}
		
		//collego il listener al bottone login
		ActionListener amministrazioneListener=new AmministrazioneListener();
		gotoAmministrazione.addActionListener(amministrazioneListener);
		//fine elementi amministrazionePanel
		
		//inizio elementi gestioneTerrenoPanel
		JButton terreno=new JButton();
		terreno.setPreferredSize(new Dimension(40,40)); //qui puoi settare le dimensioni del tuo pulsante , la foto si adattera (Se però le proporzioni non sono giuste si deforma anche)

		try {
			Image gocciaImg=ImageIO.read(new File("img/terrenoLogo.png"));
			gocciaImg=gocciaImg.getScaledInstance(35,35,Image.SCALE_SMOOTH);
			ImageIcon icona=new ImageIcon(gocciaImg);
			terreno.setIcon(icona); 
			terreno.setBorder(null); 
			terreno.setFocusPainted(false); //per non far uscire i bordi blu del bottone quando selezionato
			terreno.setVisible(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		JButton gotoGestioneterreno=new JButton("Gestione terreno   >");
		gotoGestioneterreno.setFocusPainted(false);
		gotoGestioneterreno.setForeground(new Color(0,138,177));
		gotoGestioneterreno.setBorder(null); 
		gotoGestioneterreno.setFont(font);
		
		gestioneTerrenoPanel.add(terreno);
		gestioneTerrenoPanel.add(gotoGestioneterreno);
		
		class GestioneTerrenoListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false); //rendo invisibile il pannello del menu principale
				frame.add(new GestioneTerreno(frame)); //aggiungiamo al frame il pannello della homepage
			}
		}
		
		//collego il listener al bottone login
		ActionListener gestioneTerrenoListener=new GestioneTerrenoListener();
		gotoGestioneterreno.addActionListener(gestioneTerrenoListener);
		//fine elementi gestioneTerrenoPanel
		
		//inizio elementi statoPiantePanel
		JButton piante=new JButton();
		piante.setPreferredSize(new Dimension(40,40)); //qui puoi settare le dimensioni del tuo pulsante , la foto si adattera (Se però le proporzioni non sono giuste si deforma anche)

		try {
			Image boccettaImg=ImageIO.read(new File("img/pianteLogo.png"));
			boccettaImg=boccettaImg.getScaledInstance(35,35,Image.SCALE_SMOOTH);
			ImageIcon icona=new ImageIcon(boccettaImg);
			piante.setIcon(icona); 
			piante.setBorder(null); 
			piante.setFocusPainted(false); //per non far uscire i bordi blu del bottone quando selezionato
			piante.setVisible(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		JButton gotoStatoPiante=new JButton("Stato piante   >");
		gotoStatoPiante.setFocusPainted(false);
		gotoStatoPiante.setForeground(new Color(27,156,22));
		gotoStatoPiante.setBorder(null); 
		gotoStatoPiante.setFont(font);
		
		statoPiantePanel.add(piante);
		statoPiantePanel.add(gotoStatoPiante);
		
		class StatoPianteListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false); //rendo invisibile il pannello del menu principale
				frame.add(new StatoPiante(frame)); //aggiungiamo al frame il pannello della homepage
			}
		}
		
		//collego il listener al bottone login
		ActionListener statoPianteListener=new StatoPianteListener();
		gotoStatoPiante.addActionListener(statoPianteListener);
		//fine elementi statoPiantePanel
		
		//inizio elementi gestioneImpiantoPanel
		JButton impianto=new JButton();
		impianto.setPreferredSize(new Dimension(40,40)); //qui puoi settare le dimensioni del tuo pulsante , la foto si adattera (Se però le proporzioni non sono giuste si deforma anche)

		try {
			Image attrezzoImg=ImageIO.read(new File("img/impiantoLogo.png"));
			attrezzoImg=attrezzoImg.getScaledInstance(35,35,Image.SCALE_SMOOTH);
			ImageIcon icona=new ImageIcon(attrezzoImg);
			impianto.setIcon(icona); 
			impianto.setBorder(null); 
			impianto.setFocusPainted(false); //per non far uscire i bordi blu del bottone quando selezionato
			impianto.setVisible(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		JButton gotoGestioneImpianto=new JButton("Gestione impianto   >");
		gotoGestioneImpianto.setFocusPainted(false);
		gotoGestioneImpianto.setForeground(new Color(89,105,109));
		gotoGestioneImpianto.setBorder(null); 
		gotoGestioneImpianto.setFont(font);
		
		gestioneImpiantoPanel.add(impianto);
		gestioneImpiantoPanel.add(gotoGestioneImpianto);
		
		class GestioneImpiantoListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false); //rendo invisibile il pannello del menu principale
				frame.add(new GestioneImpianto(frame)); //aggiungiamo al frame il pannello della homepage
			}
		}
		
		//collego il listener al bottone login
		ActionListener gestioneImpiantoListener=new GestioneImpiantoListener();
		gotoGestioneImpianto.addActionListener(gestioneImpiantoListener);
		//fine elementi gestioneImpiantoPanel
		
		setLayout(new GridLayout(8,1));
		exitPanel.setVisible(true);
		logoPanel.setVisible(true);
		appNamePanel.setVisible(true);
		amministrazionePanel.setVisible(true);
	    gestioneTerrenoPanel.setVisible(true);
		statoPiantePanel.setVisible(true);
		gestioneImpiantoPanel.setVisible(true);
		emptyPanel.setVisible(true);
		add(exitPanel);
		add(logoPanel);
		add(appNamePanel);
		add(amministrazionePanel);
		add(gestioneTerrenoPanel);
		add(statoPiantePanel);
		add(gestioneImpiantoPanel);
		add(emptyPanel);
		setVisible(true);
		
	}
}
