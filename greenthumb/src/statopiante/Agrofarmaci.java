package statopiante;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import amministrazione.Amministrazione;
import general.Homepage;
import general.MenuPrincipale;
import gestioneimpianto.GestioneImpianto;
import gestioneterreno.GestioneTerreno;
import statopiante.ModificaAgrofarmaci;

public class Agrofarmaci extends JPanel {
	private static final long serialVersionUID = 1L;
	public static ArrayList<String> farmaco = new ArrayList<String>();
	
	JPanel upBarPanel; //barra con il logo e il bottone di uscita
	JPanel nameSectionBarPanel; //barra con il nome della sezione
	JPanel modificheRiportatePanel; //contenuto seconda parte della schermata
	JPanel downBarPanel; //barra delle icone delle sezioni
	JPanel modificaPanel; //bottone ottimizza
	JPanel imgPanel; //pannello per l'immagine della sezione
	JPanel modificheRiportate2Panel;//contesuto seconda parte della schermata
	
	public Agrofarmaci (JFrame frame) {
		//Font fontBig = new Font("Herculanum", Font.BOLD, 30);
		Font fontSmall=new Font("Herculanum", Font.PLAIN, 10);
		Font fontMedium = new Font("Herculanum", Font.BOLD, 16);
		Font font = new Font("Comic sans", Font.PLAIN, 13);
		
		upBarPanel=new JPanel();
		upBarPanel.setBackground(Color.WHITE);
		nameSectionBarPanel=new JPanel();
		nameSectionBarPanel.setBackground(Color.WHITE);
		modificheRiportatePanel=new JPanel();
		modificheRiportatePanel.setBackground(Color.WHITE);
		downBarPanel=new JPanel();
		downBarPanel.setBackground(Color.WHITE);
		modificaPanel=new JPanel();
		modificaPanel.setBackground(Color.WHITE);
		imgPanel=new JPanel();
		imgPanel.setBackground(Color.WHITE);
		modificheRiportate2Panel=new JPanel();
		modificheRiportate2Panel.setBackground(Color.WHITE);
		
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
		JLabel sectionName=new JLabel("<html><center>Stato Attuale</center></html>");
		sectionName.setFont(fontMedium);
		sectionName.setForeground(new Color(92,202,98));
		sectionName.setVisible(true);
		nameSectionBarPanel.add(sectionName);
		//fine elementi nameSectionBarPanel
		
		JButton immagine=new JButton();
		JButton immagine2=new JButton();
		//inizio elementi imgPanel
		try {
			Image grafico1=ImageIO.read(new File("img/grafico1.png"));
			grafico1=grafico1.getScaledInstance(50,50,Image.SCALE_SMOOTH);
			ImageIcon iconaimg=new ImageIcon(grafico1);
			immagine.setIcon(iconaimg); 
			immagine.setBorder(null); 
			immagine.setFocusPainted(false); //per non far uscire i bordi blu del bottone quando selezionato
			immagine.setVisible(true);
			immagine.invalidate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		imgPanel.add(immagine);
		try {
			Image grafico2=ImageIO.read(new File("img/grafico2.png"));
			grafico2=grafico2.getScaledInstance(50,50,Image.SCALE_SMOOTH);
			ImageIcon iconaimg=new ImageIcon(grafico2);
			immagine2.setIcon(iconaimg); 
			immagine2.setBorder(null); 
			immagine2.setFocusPainted(false); //per non far uscire i bordi blu del bottone quando selezionato
			immagine2.setVisible(true);
			immagine2.invalidate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		imgPanel.add(immagine2);
		
		JLabel testo=new JLabel("<html><center>Miscela Agrofarmaci</center></html>");
		testo.setFont(fontMedium);
		testo.setForeground(new Color(92,202,98));
		testo.setVisible(true);
		
		modificheRiportatePanel.add(testo);
		//fine elementi imgPanel
		if (farmaco.size() == 0) {
			JLabel testo2=new JLabel("<html><center><br>non risulta essere stato aggiunto <br> nessun tipo di agrofarmaco durante l' irrigazione</center></html>");
			testo2.setFont(font);
			testo2.setForeground(new Color(0,0,0));
			testo2.setVisible(true);
			
			modificheRiportatePanel.add(testo2);
		}
		
		
		//inizio elementi modificheRiportate
		modificheRiportate2Panel.setLayout(new GridLayout(3,3));
		
		Collections.sort(farmaco); // Sort farmaco
		for (String i : farmaco) {
			JCheckBox c= new JCheckBox(i);
		    c.setEnabled(false);
		    modificheRiportate2Panel.add(new JLabel(""));
		    modificheRiportate2Panel.add(c);
		    modificheRiportate2Panel.add(new JLabel(""));
		 }
		 //fine elementi modificheRiportate

		//inizio bottone modificaAgro bottone
	  		JButton modificaAgro=new JButton("modifica Agrofarmaci");
	  		modificaAgro.setForeground(new Color(96,202,92));
	  		modificaAgro.setFont(fontMedium);
	  		modificaAgro.setFocusPainted(false); 
	  		modificaAgro.setVisible(true);
	  		
	  		class modificaAgroListener implements ActionListener {

	  			public void actionPerformed(ActionEvent e) {
	  				
	  					int i =JOptionPane.showConfirmDialog(null, "<html>vuoi procedere<br>alla modifica<br>della miscela<br>di agrofarmaci?</html>", "attenzione", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
	  					if(i == JOptionPane.YES_OPTION){
	  						setVisible(false); 
	  						frame.add(new ModificaAgrofarmaci(frame));
	  					}else {
	  						setVisible(false); 
	  						frame.add(new Agrofarmaci(frame));
	  					}		
	  				  	
	  			}
	  		}
	  		
	  		
	  		//collego il listener al bottone ottimizza
	  		ActionListener modificaAgroListener=new modificaAgroListener();
	  		modificaAgro.addActionListener(modificaAgroListener);
	  		modificaPanel.add(modificaAgro);
	  		//fine bottone ottimizza

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
		modificheRiportatePanel.setVisible(true);
		modificheRiportate2Panel.setVisible(true);
		modificaPanel.setVisible(true);
		downBarPanel.setVisible(true);
		imgPanel.setVisible(true);
		setLayout(new GridLayout(7,1));
		add(upBarPanel);
		add(nameSectionBarPanel);
		add(imgPanel);
		add(modificheRiportatePanel);
		add(modificheRiportate2Panel);
		add(modificaPanel);
		add(downBarPanel);
		
	}
	

}
