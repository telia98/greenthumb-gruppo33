package gestioneterreno;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GestioneTerreno extends JPanel {

	private static final long serialVersionUID = 1L;
	JPanel upBarPanel; //barra con il logo e il bottone di uscita
	JPanel upBar2Panel; //barra per il nome dell'app
	JPanel nameSectionBarPanel; //barra con il nome della sezione
	JPanel contenutoPanel; //contenuto della schermata
	JPanel downBarPanel; //barra delle icone delle sezioni
	JPanel emptyPanel;
	JPanel empty2Panel;
	JPanel imgPanel; //pannello per l'immagine della sezione
	
	public GestioneTerreno(JFrame frame) {
		Font fontBig = new Font("Herculanum", Font.BOLD, 45);
		Font fontSmall=new Font("Herculanum", Font.BOLD, 10);
		Font fontMedium = new Font("Herculanum", Font.BOLD, 16);
		Font font = new Font("Comic sans", Font.PLAIN, 13);
		
		upBarPanel=new JPanel();
		upBarPanel.setBackground(Color.WHITE);
		upBar2Panel=new JPanel();
		upBar2Panel.setBackground(Color.WHITE);
		nameSectionBarPanel=new JPanel();
		nameSectionBarPanel.setBackground(Color.WHITE);
		contenutoPanel=new JPanel();
		contenutoPanel.setBackground(Color.WHITE);
		downBarPanel=new JPanel();
		downBarPanel.setBackground(Color.WHITE);
		emptyPanel=new JPanel();
		emptyPanel.setBackground(Color.WHITE);
		empty2Panel=new JPanel();
		empty2Panel.setBackground(Color.WHITE);
		imgPanel=new JPanel();
		imgPanel.setBackground(Color.WHITE);
		
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
			
			//recupero immagine del bottone di uscita
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
		
		upBarPanel.setLayout(new GridLayout(2,5)); //1 riga, 3 colonne
		upBarPanel.add(new JLabel(""));
		upBarPanel.add(new JLabel(""));
		upBarPanel.add(logo);
		upBarPanel.add(new JLabel(""));
		upBarPanel.add(exit);
		upBarPanel.add(new JLabel(""));
		upBarPanel.add(new JLabel(""));
		upBarPanel.add(appName);
		upBarPanel.add(new JLabel(""));
		upBarPanel.add(new JLabel(""));
		//fine elementi upBarPanel
		
		//inizio elementi upBar2panel
		/*JLabel appName=new JLabel("<html><center>GreenThumb</center></html>");
		appName.setFont(fontSmall);
		appName.setForeground(new Color(45,174,0));
		appName.setVisible(true);
		
		upBar2Panel.setLayout(new GridLayout(1,5));
		upBar2Panel.add(new JLabel(""));
		upBar2Panel.add(new JLabel(""));
		upBar2Panel.add(appName);
		upBar2Panel.add(new JLabel(""));
		upBar2Panel.add(new JLabel(""));*/
		//fine elementi upBar2Panel
		
		//inizio elementi nameSectionBarPanel
		JLabel sectionName=new JLabel("<html><center>gestione terreno</center></html>");
		sectionName.setFont(fontMedium);
		sectionName.setForeground(new Color(0,138,177));
		
		sectionName.setVisible(true);
		nameSectionBarPanel.add(sectionName);
		//fine elementi nameSectionBarPanel
		
		//inizio elementi imgPanel
		JButton immagine=new JButton();
		//immagine.setPreferredSize(new Dimension(400,400)); //qui puoi settare le dimensioni del tuo pulsante , la foto si adattera (Se però le proporzioni non sono giuste si deforma anche)

		try {
			Image img=ImageIO.read(new File("img/manoAcqua.png"));
			img=img.getScaledInstance(65,65,Image.SCALE_SMOOTH);
			ImageIcon iconaimg=new ImageIcon(img);
			immagine.setIcon(iconaimg); 
			immagine.setBorder(null); 
			immagine.setFocusPainted(false); //per non far uscire i bordi blu del bottone quando selezionato
			immagine.setVisible(true);
			immagine.invalidate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		imgPanel.add(immagine);
		//fine elementi imgPanel
		
		//inizio elementi contenutoPanel
		//fine elementi contenutoPanel
		
		//inizio elementi downBarPanel
		JButton amministrazione=new JButton();
		amministrazione.setPreferredSize(new Dimension(150,150));
		JButton gestioneTerreno=new JButton();
		gestioneTerreno.setPreferredSize(new Dimension(150,150));
		JButton statoPiante=new JButton();
		statoPiante.setPreferredSize(new Dimension(150,150));
		JButton gestioneImpianto=new JButton();
		gestioneImpianto.setPreferredSize(new Dimension(150,150));
		
		try {
			//recupero immagine amministrazione
			Image soldiImg=ImageIO.read(new File("img/adminLogo.png"));
			soldiImg=soldiImg.getScaledInstance(40,40,Image.SCALE_SMOOTH);
			ImageIcon icona=new ImageIcon(soldiImg);
			amministrazione.setIcon(icona); 
			amministrazione.setBorder(null); 
			amministrazione.setFocusPainted(false); //per non far uscire i bordi blu del bottone quando selezionato
			amministrazione.setVisible(true);
			
			//recupero immagine gestione terreno
			Image gocciaImg=ImageIO.read(new File("img/terrenoLogo.png"));
			gocciaImg=gocciaImg.getScaledInstance(40,40,Image.SCALE_SMOOTH);
			ImageIcon icona2=new ImageIcon(gocciaImg);
			gestioneTerreno.setIcon(icona2); 
			gestioneTerreno.setBorder(null); 
			gestioneTerreno.setFocusPainted(false); //per non far uscire i bordi blu del bottone quando selezionato
			gestioneTerreno.setVisible(true);
			
			//recupero immagine stato piante
			Image boccettaImg=ImageIO.read(new File("img/pianteLogo.png"));
			boccettaImg=boccettaImg.getScaledInstance(40,40,Image.SCALE_SMOOTH);
			ImageIcon icona3=new ImageIcon(boccettaImg);
			statoPiante.setIcon(icona3); 
			statoPiante.setBorder(null); 
			statoPiante.setFocusPainted(false); //per non far uscire i bordi blu del bottone quando selezionato
			statoPiante.setVisible(true);
			
			//recupero immagine gestione impianto
			Image attrezzoImg=ImageIO.read(new File("img/impiantoLogo.png"));
			attrezzoImg=attrezzoImg.getScaledInstance(40,40,Image.SCALE_SMOOTH);
			ImageIcon icona4=new ImageIcon(attrezzoImg);
			gestioneImpianto.setIcon(icona4); 
			gestioneImpianto.setBorder(null); 
			gestioneImpianto.setFocusPainted(false); //per non far uscire i bordi blu del bottone quando selezionato
			gestioneImpianto.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
		upBar2Panel.setVisible(true);
		nameSectionBarPanel.setVisible(true);
		contenutoPanel.setVisible(true);
		emptyPanel.setVisible(true);
		empty2Panel.setVisible(true);
		downBarPanel.setVisible(true);
		imgPanel.setVisible(true);
		setLayout(new GridLayout(8,1));
		add(upBarPanel);
		add(upBar2Panel);
		add(nameSectionBarPanel);
		add(imgPanel);
		add(contenutoPanel);
		add(emptyPanel);
		add(empty2Panel);
		add(downBarPanel);
	}
}
