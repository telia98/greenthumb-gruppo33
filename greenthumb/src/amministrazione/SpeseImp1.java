package amministrazione;

import utility.Impianto;
import java.awt.BorderLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gestioneterreno.GestioneTerreno;
import general.Homepage;
import general.MenuPrincipale;
import gestioneimpianto.GestioneImpianto;
import statopiante.StatoPiante;

public class SpeseImp1 extends JPanel {

	private static final long serialVersionUID = 1L;
	JPanel upBarPanel; //barra con il logo e il bottone di uscita
	JPanel nameSectionBarPanel; //barra con il nome della sezione
	JPanel contenutoPanel; //contenuto della schermata
	JPanel downBarPanel; //barra delle icone delle sezioni
	JPanel emptyPanel;
	JPanel imgPanel; //pannello per l'immagine della sezione
	JPanel contenuto2Panel;
	JPanel newPanel;
	
	
	public SpeseImp1(JFrame frame, Impianto impianto) {
		Font fontBig = new Font("Herculanum", Font.BOLD, 30);
		Font fontSmall=new Font("Herculanum", Font.PLAIN, 10);
		Font fontMedium = new Font("Herculanum", Font.BOLD, 16);
		Font font = new Font("Comic sans", Font.PLAIN, 13);
		
		upBarPanel=new JPanel();
		upBarPanel.setBackground(Color.WHITE);
		nameSectionBarPanel=new JPanel();
		nameSectionBarPanel.setBackground(Color.WHITE);
		contenutoPanel=new JPanel();
		contenutoPanel.setBackground(Color.WHITE);
		downBarPanel=new JPanel();
		downBarPanel.setBackground(Color.WHITE);
		emptyPanel=new JPanel();
		emptyPanel.setBackground(Color.WHITE);
		imgPanel=new JPanel();
		imgPanel.setBackground(Color.WHITE);
		contenuto2Panel=new JPanel();
		contenuto2Panel.setBackground(Color.WHITE);
		newPanel=new JPanel();
		newPanel.setBackground(Color.WHITE);
		
		//inizio elementi upBarPanel
		JButton logo=new JButton();		
		logo.setPreferredSize(new Dimension(100,100)); //qui puoi settare le dimensioni del tuo pulsante , la foto si adatterà
		JButton exit=new JButton();
		exit.setPreferredSize(new Dimension(90,90)); //qui puoi settare le dimensioni del tuo pulsante, la foto si adatterà

		JLabel appName=new JLabel("<html><center>GreenThumb</center></html>");
		appName.setFont(fontSmall);
		appName.setForeground(new Color(45,174,0));
		appName.setVisible(true);
		
		try {
			//recupero immagine del logo
			Image logoImg=ImageIO.read(new File("img/logo.png"));
			logoImg=logoImg.getScaledInstance(40,40,Image.SCALE_SMOOTH);
			ImageIcon icona=new ImageIcon(logoImg);
			logo.setIcon(icona); 
			logo.setBorder(null); 
			logo.setFocusPainted(false); //per non far uscire i bordi blu del bottone quando selezionato
			logo.setVisible(true);
			logo.invalidate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		class LogoListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false); //rendo invisibile il pannello del login
				frame.add(new MenuPrincipale(frame)); //aggiungiamo al frame il pannello della homepage
			}
		}
		
		//collego il listener al bottone login
		ActionListener logoListener=new LogoListener();
		logo.addActionListener(logoListener);
		
		upBarPanel.setLayout(new GridLayout(2,5)); //1 riga, 3 colonne
		upBarPanel.add(new JLabel(""));
		upBarPanel.add(new JLabel(""));
		upBarPanel.add(logo);
		upBarPanel.add(new JLabel(""));
		upBarPanel.add(new JLabel(""));
		upBarPanel.add(new JLabel(""));
		upBarPanel.add(new JLabel(""));
		upBarPanel.add(appName);
		upBarPanel.add(new JLabel(""));
		upBarPanel.add(new JLabel(""));
		//fine elementi upBarPanel
		
		//inizio elementi nameSectionBarPanel
		JLabel sectionName=new JLabel("<html><center>spese impianto</center></html>");
		sectionName.setFont(fontBig);
		sectionName.setForeground(new Color(230,202,60));
		
		sectionName.setVisible(true);
		nameSectionBarPanel.add(sectionName);
		//fine elementi nameSectionBarPanel
		
		//inizio elementi imgPanel
		JLabel infoApp = new JLabel("<html><center>inserisci parametro</center></html>");
		infoApp.setFont(font);
		imgPanel.add(infoApp,BorderLayout.NORTH);
		//fine elementi imgPanel
		
		//inizio elementi contenutoPanel
		JLabel infoAppa = new JLabel("<html><center>BUDGET</center></html>");
		infoAppa.setFont(font);
		contenutoPanel.add(infoAppa,BorderLayout.NORTH);
		
		JButton button1= new JButton("ON");
		button1.setForeground(new Color(230,202,60));
		contenutoPanel.add(button1);
		
		button1.addActionListener(
				new ActionListener() {
			        public void actionPerformed(ActionEvent e) {
			        	JOptionPane.showMessageDialog(null,"<html> parametro budget disattivato </html", "Message", 1);
						setVisible(false);
						frame.add(new SelezioneImp1(frame, impianto));
			        }
			    } 
			);
		//fine elementi contenutoPanel
		
		
		//inizio newPanel
		JLabel infoAppk = new JLabel("<html><center>Il parametro numerico che viene inserito<br>deve essere privo di frazione decimale</center></html>");
		infoAppk.setFont(font);
		newPanel.add(infoAppk,BorderLayout.NORTH);
		//fine newPanel
		
		//inizio elementi contenuto2Panel
		JTextField etat = new JTextField( 10);
		contenuto2Panel.add(etat);
		
		JButton button2= new JButton("PROCEDI");
		button2.setForeground(new Color(230,202,60));
		contenuto2Panel.add(button2);
		
		button2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String etas = ""; 
	    		int etad = 0;
	    		try {
	    			etas = etat.getText();
	    			etad = Integer.parseInt(etas);
	    		} catch (Exception ex) {
	    			ex.printStackTrace();
	    		}
	    			 	        	
	    		int bolletta= 1000;
	    			        	
	    		if(bolletta <= etad) { 
	    				JOptionPane.showMessageDialog(null,"<html> budget inserito </html", "Message", 1);
	    				setVisible(false);
	    				frame.add(new SegnaleVerdeImp1(frame, impianto));
	    		} else if(bolletta > etad)  {
	    			    JOptionPane.showMessageDialog(null,"<html> budget inserito </html", "Message", 1);
	    				setVisible(false);
	    				frame.add(new SegnaleRossoImp1(frame, impianto));
	    		}
	    	 }
	    });    
		//fine elementi contenuto2Panel
	
		//inizio elementi downBarPanel
		JButton amministrazione=new JButton();
		amministrazione.setPreferredSize(new Dimension(150,200));
		JButton gestioneTerreno=new JButton();
		gestioneTerreno.setPreferredSize(new Dimension(150,200));
		JButton statoPiante=new JButton();
		statoPiante.setPreferredSize(new Dimension(150,200));
		JButton gestioneImpianto=new JButton();
		gestioneImpianto.setPreferredSize(new Dimension(150,200));
		
		try {
			//recupero immagine amministrazione
			Image soldiImg=ImageIO.read(new File("img/adminLogo.png"));
			soldiImg=soldiImg.getScaledInstance(40,50,Image.SCALE_SMOOTH);
			ImageIcon icona=new ImageIcon(soldiImg);
			amministrazione.setIcon(icona); 
			amministrazione.setBorder(null); 
			amministrazione.setFocusPainted(false); //per non far uscire i bordi blu del bottone quando selezionato
			amministrazione.setVisible(true);
			
			//recupero immagine gestione terreno
			Image gocciaImg=ImageIO.read(new File("img/terrenoLogo.png"));
			gocciaImg=gocciaImg.getScaledInstance(40,50,Image.SCALE_SMOOTH);
			ImageIcon icona2=new ImageIcon(gocciaImg);
			gestioneTerreno.setIcon(icona2); 
			gestioneTerreno.setBorder(null); 
			gestioneTerreno.setFocusPainted(false); //per non far uscire i bordi blu del bottone quando selezionato
			gestioneTerreno.setVisible(true);
			
			//recupero immagine stato piante
			Image boccettaImg=ImageIO.read(new File("img/pianteLogo.png"));
			boccettaImg=boccettaImg.getScaledInstance(40,50,Image.SCALE_SMOOTH);
			ImageIcon icona3=new ImageIcon(boccettaImg);
			statoPiante.setIcon(icona3); 
			statoPiante.setBorder(null); 
			statoPiante.setFocusPainted(false); //per non far uscire i bordi blu del bottone quando selezionato
			statoPiante.setVisible(true);
			
			//recupero immagine gestione impianto
			Image attrezzoImg=ImageIO.read(new File("img/impiantoLogo.png"));
			attrezzoImg=attrezzoImg.getScaledInstance(40,50,Image.SCALE_SMOOTH);
			ImageIcon icona4=new ImageIcon(attrezzoImg);
			gestioneImpianto.setIcon(icona4); 
			gestioneImpianto.setBorder(null); 
			gestioneImpianto.setFocusPainted(false); //per non far uscire i bordi blu del bottone quando selezionato
			gestioneImpianto.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		class AmministrazioneListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false); 
				frame.add(new Amministrazione(frame));
			}
		}
		ActionListener amministrazioneListener=new AmministrazioneListener();
		amministrazione.addActionListener(amministrazioneListener);
		
		class TerrenoListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false); //rendo invisibile il pannello della homepage
				frame.add(new GestioneTerreno(frame)); //aggiungiamo al frame il pannello del login
			}
		}
		ActionListener terrenoListener=new TerrenoListener();
		gestioneTerreno.addActionListener(terrenoListener);
		
		class PianteListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false); //rendo invisibile il pannello della homepage
				frame.add(new StatoPiante(frame)); //aggiungiamo al frame il pannello del login
			}
		}
		ActionListener pianteListener=new PianteListener();
		statoPiante.addActionListener(pianteListener);
		
		class ImpiantoListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false); //rendo invisibile il pannello della homepage
				frame.add(new GestioneImpianto(frame)); //aggiungiamo al frame il pannello del login
			}
		}
		ActionListener impiantoListener=new ImpiantoListener();
		gestioneImpianto.addActionListener(impiantoListener);
		
		amministrazione.setVisible(true);
		gestioneTerreno.setVisible(true);
		statoPiante.setVisible(true);
		gestioneImpianto.setVisible(true);
		
		downBarPanel.setLayout(new GridLayout(1,4));
		downBarPanel.add(amministrazione);
		downBarPanel.add(gestioneTerreno);
		downBarPanel.add(statoPiante);
		downBarPanel.add(gestioneImpianto);
		//fine elementi downBarPanel
		
		upBarPanel.setVisible(true);
		nameSectionBarPanel.setVisible(true);
		contenutoPanel.setVisible(true);
		contenuto2Panel.setVisible(true);
		emptyPanel.setVisible(true);
		downBarPanel.setVisible(true);
		imgPanel.setVisible(true);
		newPanel.setVisible(true);
		setLayout(new GridLayout(8,1));
		add(upBarPanel);
		add(nameSectionBarPanel);
		add(imgPanel);
		add(contenutoPanel);
		add(newPanel);
		add(contenuto2Panel);
		add(emptyPanel);
		add(downBarPanel);
	}

}

