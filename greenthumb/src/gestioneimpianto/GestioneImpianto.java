package gestioneimpianto;

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
import general.Homepage;
import general.MenuPrincipale;
import gestioneterreno.GestioneTerreno;
import statopiante.StatoPiante;

public class GestioneImpianto extends JPanel {

	private static final long serialVersionUID = 1L;
	JPanel upBarPanel; //barra con il logo e il bottone di uscita
	JPanel nameSectionBarPanel; //barra con il nome della sezione
	JPanel contenutoPanel; //contenuto della schermata
	JPanel downBarPanel; //barra delle icone delle sezioni
	JPanel emptyPanel;
	JPanel imgPanel; //pannello per l'immagine della sezione
	JPanel empty3Panel;
	
	public GestioneImpianto(JFrame frame) {
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
		empty3Panel=new JPanel();
		empty3Panel.setBackground(Color.WHITE);
		imgPanel=new JPanel();
		imgPanel.setBackground(Color.WHITE);
		
		//inizio elementi upBarPanel
		JButton logo=new JButton();		
		logo.setPreferredSize(new Dimension(100,100)); 
		JButton exit=new JButton();
		exit.setPreferredSize(new Dimension(90,90));

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
			logo.setFocusPainted(false);
			logo.setVisible(true);
			logo.invalidate();

		} catch(Exception e) {
			e.printStackTrace();
		}
		class ExitListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false); 
				frame.add(new Homepage(frame));
			}
		}
		ActionListener exitListener=new ExitListener();
		exit.addActionListener(exitListener);
		
		class LogoListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				frame.add(new MenuPrincipale(frame));
			}
		}
		ActionListener logoListener=new LogoListener();
		logo.addActionListener(logoListener);
		
		upBarPanel.setLayout(new GridLayout(2,5));
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
		JLabel sectionName=new JLabel("<html><center>gestione impianto</center></html>");
		sectionName.setFont(fontBig);
		sectionName.setForeground(new Color(89,105,109));
		sectionName.setVisible(true);
		nameSectionBarPanel.add(sectionName);
		//fine elementi nameSectionBarPanel
		
		//inizio elementi imgPanel
		JButton immagine=new JButton();
		try {
			Image img=ImageIO.read(new File("img/manoImpianto.png"));
			img=img.getScaledInstance(75,75,Image.SCALE_SMOOTH);
			ImageIcon iconaimg=new ImageIcon(img);
			immagine.setIcon(iconaimg); 
			immagine.setBorder(null); 
			immagine.setFocusPainted(false);
			immagine.setVisible(true);
			immagine.invalidate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		imgPanel.add(immagine);
		//fine elementi imgPanel
		
		//inizio elementi contenutoPanel
		JButton gotoVisualizzaPiani=new JButton("Visualizza piani d'irrigazione   >");
		gotoVisualizzaPiani.setFocusPainted(false);
		gotoVisualizzaPiani.setBorder(null); 
		gotoVisualizzaPiani.setFont(font);
		JButton gotoAggiungiImpianti=new JButton("Aggiungi impianto   >");
		gotoAggiungiImpianti.setFocusPainted(false);
		gotoAggiungiImpianti.setBorder(null); 
		gotoAggiungiImpianti.setFont(font);
		contenutoPanel.add(gotoVisualizzaPiani);
		contenutoPanel.add(gotoAggiungiImpianti);
		
		class PianiListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				frame.add(new SelezioneImpianto(frame));
			}
		}
		ActionListener pianiListener=new PianiListener();
		gotoVisualizzaPiani.addActionListener(pianiListener);
		
		class AggiungiListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				frame.add(new AggiungiImpianto(frame)); 
			}
		}
		ActionListener aggiungiListener=new AggiungiListener();
		gotoAggiungiImpianti.addActionListener(aggiungiListener);
		//fine elementi contenutoPanel
		
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
			amministrazione.setFocusPainted(false); 
			amministrazione.setVisible(true);
			
			//recupero immagine gestione terreno
			Image gocciaImg=ImageIO.read(new File("img/terrenoLogo.png"));
			gocciaImg=gocciaImg.getScaledInstance(40,50,Image.SCALE_SMOOTH);
			ImageIcon icona2=new ImageIcon(gocciaImg);
			gestioneTerreno.setIcon(icona2); 
			gestioneTerreno.setBorder(null); 
			gestioneTerreno.setFocusPainted(false);
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
			gestioneImpianto.setFocusPainted(false);
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
				setVisible(false);
				frame.add(new GestioneTerreno(frame));
			}
		}
		ActionListener terrenoListener=new TerrenoListener();
		gestioneTerreno.addActionListener(terrenoListener);
		
		class PianteListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false); 
				frame.add(new StatoPiante(frame));
			}
		}
		ActionListener pianteListener=new PianteListener();
		statoPiante.addActionListener(pianteListener);
		
		class ImpiantoListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				frame.add(new GestioneImpianto(frame));
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
		emptyPanel.setVisible(true);
		empty3Panel.setVisible(true);
		downBarPanel.setVisible(true);
		imgPanel.setVisible(true);
		setLayout(new GridLayout(7,1));
		add(upBarPanel);
		add(nameSectionBarPanel);
		add(imgPanel);
		add(emptyPanel);
		add(contenutoPanel);
		add(empty3Panel);
		add(downBarPanel);
	}
}
