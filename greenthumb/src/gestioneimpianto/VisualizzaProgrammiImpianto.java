package gestioneimpianto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import amministrazione.Amministrazione;
import general.Homepage;
import general.Tester;
import gestioneterreno.GestioneTerreno;
import statopiante.StatoPiante;
import utility.Impianto;
import utility.ProgrammaIrrigazione;

public class VisualizzaProgrammiImpianto extends JPanel {

	private static final long serialVersionUID = 1L;
	JPanel upBarPanel; //barra con il logo e il bottone di uscita
	JPanel nameSectionBarPanel; //barra con il nome della sezione
	JPanel infoPanel;
	JPanel infoProgramma; //informazioni singolo programma d'irrigazione
	JPanel downBarPanel; //barra delle icone delle sezioni
	JPanel programmiPanel; //lista dei programmi d'irrigazione e relative informazioni
	JPanel aggiungiPanel; //pannello per l'aggiunta di un programma alla lista di quelli dell'impianto
	JPanel modificaPanel; //pannello per la modifica di un programma d'irrigazione
	
	public VisualizzaProgrammiImpianto(JFrame frame,Impianto impianto,ProgrammaIrrigazione programma) {
		Font fontBig = new Font("Herculanum", Font.BOLD, 30);
		Font fontSmall=new Font("Herculanum", Font.PLAIN, 10);
		Font fontMedium = new Font("Herculanum", Font.BOLD, 16);
		Font font = new Font("Comic sans", Font.PLAIN, 13);
		
		System.out.println(programma);
		
		upBarPanel=new JPanel();
		upBarPanel.setBackground(Color.WHITE);
		nameSectionBarPanel=new JPanel();
		nameSectionBarPanel.setBackground(Color.WHITE);
		infoPanel=new JPanel();
		infoPanel.setBackground(Color.WHITE);
		downBarPanel=new JPanel();
		downBarPanel.setBackground(Color.WHITE);
		programmiPanel= new JPanel();
		programmiPanel.setBackground(Color.WHITE);
		aggiungiPanel= new JPanel();
		aggiungiPanel.setBackground(Color.WHITE);
		infoProgramma=new JPanel();
		infoProgramma.setBackground(Color.WHITE);
		modificaPanel=new JPanel();
		modificaPanel.setBackground(Color.WHITE);
		
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
			
			//recupero immagine del bottone di uscita
			Image exitImg=ImageIO.read(new File("img/exit.png"));
			exitImg=exitImg.getScaledInstance(40,40,Image.SCALE_SMOOTH);
			ImageIcon exitIcon=new ImageIcon(exitImg);
			exit.setIcon(exitIcon); 
			exit.setBorder(null); 
			exit.setFocusPainted(false);
			exit.setVisible(true);
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
				frame.add(new Homepage(frame));
			}
		}
		ActionListener logoListener=new LogoListener();
		logo.addActionListener(logoListener);
		
		upBarPanel.setLayout(new GridLayout(2,5));
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
		
		//inizio elementi nameSectionBarPanel
		JLabel sectionName=new JLabel("<html><center>gestione impianto</center></html>");
		sectionName.setFont(fontBig);
		sectionName.setForeground(new Color(89,105,109));
		sectionName.setVisible(true);
		nameSectionBarPanel.add(sectionName);
		//fine elementi nameSectionBarPanel
		
		//inizio elementi infoPanel
		JLabel info=new JLabel(impianto.getNome());
		info.setFont(fontMedium);
		infoPanel.add(info);
		//fine elementi infoPanel
		
		//inizio elementi programmiPanel
		JLabel selection=new JLabel("<html>Seleziona dalla lista il programma d'irrigazione<br>di cui vuoi visualizzare i dettagli</html>");
		selection.setFont(font);
		selection.setForeground(new Color(89,105,109));
		JComboBox<String> comboprogrammi=new JComboBox<String>();
		comboprogrammi.addItem("");
		ArrayList<ProgrammaIrrigazione> lista=Tester.getProgrammi();
		for(ProgrammaIrrigazione p: lista) {
			if (p.getImpianto().getNome().equals(impianto.getNome()))
				comboprogrammi.addItem(p.getNome());
		}
		
		class ComboListener implements ActionListener {
			
			public void actionPerformed(ActionEvent event) {
			
				String op=(String) comboprogrammi.getSelectedItem();
				for(ProgrammaIrrigazione p: lista) {
					if (p.getNome().equals(op)) {
						setVisible(false);
						frame.add(new VisualizzaProgrammiImpianto(frame,impianto,p));
					}
				}
			}
		}
		ActionListener listener=new ComboListener();
		comboprogrammi.addActionListener(listener);	
		
		programmiPanel.add(selection);
		programmiPanel.add(comboprogrammi);
		//fine elementi programmiPanel
		
		//inizio elementi infoProgramma
		JLabel dettagliProgramma = new JLabel();
		
		if (programma!=null) {
			String prog="<html>Programma: " + programma.getNome() + "<br>Tipologia: " + programma.getTipologia() + "<br>Potenza: " + String.valueOf(programma.getPotenzaGetto()) + " e rotazione: ";
			Boolean rotazione=programma.isRotazioneGetto();
			if (rotazione!=false)
				prog+="ON<br>";
			else
				prog+="OFF<br>";
			prog+="Orario irrigazione: " + programma.getOraInizio().toString() + " - " + programma.getOraFine().toString() + "</html>";
			dettagliProgramma.setText(prog);
		
			infoProgramma.add(dettagliProgramma);
		} else {
			dettagliProgramma=new JLabel("");
			infoProgramma.add(dettagliProgramma);
		}
		//fine elementi infoProgramma

		//inizio elementi modificaPanel
		if (programma!=null) {
			JButton modificaProgramma=new JButton("modifica programma d'irrigazione");
			
			class ModificaListener implements ActionListener {
				
				public void actionPerformed(ActionEvent event) {
					setVisible(false);
					frame.add(new ImpostazioniProgramma(frame,impianto,programma));
				}
			}
			ActionListener modificalistener=new ModificaListener();
			modificaProgramma.addActionListener(modificalistener);	
			
			modificaProgramma.setForeground(new Color(89,105,109));
			modificaProgramma.setFont(fontMedium);
			modificaProgramma.setFocusPainted(false); 
			modificaProgramma.setVisible(true);
			modificaPanel.add(modificaProgramma);
		} else {
			JLabel label=new JLabel("");
			modificaPanel.add(label);
		}
		//fine elementi modificaPanel
		
		//inizio elementi aggiungiPanel
		JLabel dettagli=new JLabel("<html><center>Clicca il bottone per aggiungere<br>un nuovo programma d'irrigazione</center></html>");
		dettagli.setFont(font);
		dettagli.setForeground(new Color(89,105,109));
		JButton aggiungi=new JButton("aggiungi nuovo programma");
		
		class AggiungiListener implements ActionListener {
			
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
				frame.add(new ImpostazioniProgramma(frame,impianto,null));
			}
		}
		ActionListener aggiungilistener=new AggiungiListener();
		aggiungi.addActionListener(aggiungilistener);	
		
		aggiungi.setForeground(new Color(89,105,109));
		aggiungi.setFont(fontMedium);
		aggiungi.setFocusPainted(false); 
		aggiungi.setVisible(true);
		aggiungiPanel.add(dettagli);
		aggiungiPanel.add(aggiungi);
		//fine elementi aggiungiPanel
		
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
			statoPiante.setFocusPainted(false); 
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
		infoPanel.setVisible(true);
		programmiPanel.setVisible(true);
		aggiungiPanel.setVisible(true);
		downBarPanel.setVisible(true);
		infoProgramma.setVisible(true);
		modificaPanel.setVisible(true);
		
		setLayout(new GridLayout(8,1));
		add(upBarPanel);
		add(nameSectionBarPanel);
		add(infoPanel);
		add(aggiungiPanel);
		add(programmiPanel);
		add(infoProgramma);
		add(modificaPanel);
		add(downBarPanel);
	}
}
