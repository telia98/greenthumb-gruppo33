package gestioneterreno;

import java.awt.BorderLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import amministrazione.Amministrazione;
import general.Homepage;
import general.Tester;
import gestioneimpianto.GestioneImpianto;
import statopiante.StatoPiante;
import utility.Impianto;
import utility.ProgrammaIrrigazione;

public class ModalitaAutomatica extends JPanel{
	
	private static final long serialVersionUID = 1L;
	JPanel upBarPanel; //barra con il logo e il bottone di uscita
	JPanel nameSectionBarPanel; //barra con il nome della sezione
	JPanel testoPanel; //panel per la descrizione di cosa si andr‡ a fare
	JPanel dropdownPanel; //panel per la selezione del programma
	JPanel textAreaPanel; 
	JPanel textAreaPanel2; 
	JPanel attivaPanel; // panel con bottone attiva
	JPanel downBarPanel; //barra delle icone delle sezioni
	
	public ModalitaAutomatica(JFrame frame,Impianto impianto, ProgrammaIrrigazione pr) {
	System.out.println(pr);	
		Font fontBig = new Font("Herculanum", Font.BOLD, 30);
		Font fontSmall=new Font("Herculanum", Font.PLAIN, 10);
		Font fontMedium = new Font("Herculanum", Font.BOLD, 16);
		Font font = new Font("Comic sans", Font.PLAIN, 13);
		Font fontMin = new Font("Comic sans", Font.PLAIN, 10);
		Font fontMax = new Font("Comic sans", Font.PLAIN, 16); 
		
		
		upBarPanel=new JPanel();
		upBarPanel.setBackground(Color.WHITE);
		nameSectionBarPanel=new JPanel();
		nameSectionBarPanel.setBackground(Color.WHITE);
		testoPanel= new JPanel();
		testoPanel.setBackground(Color.WHITE);
		dropdownPanel=new JPanel();
		dropdownPanel.setBackground(Color.WHITE);
		textAreaPanel=new JPanel();
		textAreaPanel.setBackground(Color.WHITE);
		textAreaPanel2=new JPanel();
		textAreaPanel2.setBackground(Color.WHITE);
		attivaPanel= new JPanel();
		attivaPanel.setBackground(Color.WHITE);
		downBarPanel=new JPanel();
		downBarPanel.setBackground(Color.WHITE);
		
		//inizio elementi upBarPanel
		JButton logo=new JButton();		
		logo.setPreferredSize(new Dimension(100,100)); //qui puoi settare le dimensioni del tuo pulsante , la foto si adatter√†
		JButton exit=new JButton();
		exit.setPreferredSize(new Dimension(90,90)); //qui puoi settare le dimensioni del tuo pulsante, la foto si adatter√†

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
		
		//action listener per i bottoni
		class ExitListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false); //rendo invisibile il pannello del menu principale
				frame.add(new Homepage(frame)); //aggiungiamo al frame il pannello della homepage
			}
		}
		ActionListener exitListener=new ExitListener();
		exit.addActionListener(exitListener);
		
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
		
		//inizio elementi nameSectionBarPanel
		JLabel sectionName=new JLabel("<html><center>Modalit‡ automatica</center></html>");
		sectionName.setFont(fontBig);
		sectionName.setForeground(new Color(0,138,177));
		
		sectionName.setVisible(true);
		nameSectionBarPanel.add(sectionName);
		//fine elementi nameSectionBarPanel
		
				
		//inizio elementi testoPanel
		JLabel info = new JLabel("<html><center>Scegli quale programma attivare<br>per l'impianto selezionato.<br><br><br></center></html>");
		info.setFont(font);
		testoPanel.add(info,BorderLayout.NORTH);
		//fine elementi testPanel
		
		
		//inizio elementi dropdownPanel
		
		JComboBox<String> selezioneProgramma = new JComboBox<String>();
		selezioneProgramma.addItem("");
		
		ArrayList<ProgrammaIrrigazione> listaP = Tester.getProgrammi(); 
			for(ProgrammaIrrigazione p: listaP) {
				if (p.getImpianto().equals(impianto))
					selezioneProgramma.addItem(p.getNome());
			}
	
			
			dropdownPanel.add(selezioneProgramma, BorderLayout.NORTH);
			//fine elementi dropdownPanel
			
			//inizio elementi textAreaPanel
			Impianto imp=null;
			String prog="";
			String impiantoo="";
			
			if(pr!=null) {
					 imp= pr.getImpianto();
					 imp.getCodice();
					 imp.getNome();
					 imp.getCitta();
					 imp.getVia();
					 imp.getCivico();
					 impiantoo="<br>Codice:" +imp.getCodice() + " - nome:" +  imp.getNome()  
					 	+ "<br>locazione:" + imp.getCitta()+ ", " +  imp.getVia() + imp.getCivico() + "</html>"; 
					 
					 pr.getOraInizio();
					 pr.getOraFine();
					 pr.getTipologia();
					 pr.getPotenzaGetto();
					 pr.isRotazioneGetto();
					 prog="<br>ora inizio:" +pr.getOraInizio() + "- ora fine:" +  pr.getOraFine()  
							 	+ "<br>" + pr.getTipologia()+ " con potenza " +  pr.getPotenzaGetto() 
							 		+",rotazione "; 
					if(pr.isRotazioneGetto())
						prog=prog + "ON</html>";
					else
						prog=prog +"OFF</html>";
					JLabel dati = new JLabel("<html>Dati tecnici impianto:" + impiantoo);//text area dove verranno caricati i dati impianto con l'action listener
					dati.setFont(font);
					dati.setVisible(true);
					textAreaPanel.add(dati,BorderLayout.EAST);
						
					JLabel dati2 = new JLabel("<html>Info programma:" + prog); //text area dove verranno caricate le info del programma con l'action listener
					dati2.setFont(font);
					dati2.setVisible(true);
					textAreaPanel2.add(dati2,BorderLayout.EAST);
			}	

			class ComboBoxListener implements ActionListener {
				
				public void actionPerformed(ActionEvent event) {
					String prog=(String) selezioneProgramma.getSelectedItem();
					ArrayList<ProgrammaIrrigazione> lista = Tester.getProgrammi(); 
					
					for(ProgrammaIrrigazione p: lista) {
						if(p.getNome().equals(prog)) {
							setVisible(false);
							frame.add(new ModalitaAutomatica(frame,impianto,p));
						}
					}
					
				}
			}
			
			ActionListener list= new ComboBoxListener();
			selezioneProgramma.addActionListener(list);	
	
		//inizio elementi attivaPanel
		JButton attiva = new JButton("Attiva ora"); 	
		attivaPanel.add(attiva);
		
		class ButtonListener implements ActionListener {
			
			public void actionPerformed(ActionEvent e) {
				
				if(pr!=null) {
				
				JOptionPane.showMessageDialog(null, "<html>ATTENZIONE! Il programma Ë stato impostato correttamente.<br></html>","Message",1);
				setVisible(false);
				frame.add(new GestioneTerreno(frame)); 
				
				} else 
					
					JOptionPane.showMessageDialog(null, "<html>ATTENZIONE! Non hai selezionato nessun programma da attivare.<br></html>","Message",1);
			}
		}
		
		ActionListener actli = new ButtonListener(); 
		attiva.addActionListener(actli);
		//fine elementi attivaPanel
		
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
		
		//action listener per i bottoni
		class AmministrazioneListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false); //rendo invisibile il pannello della homepage
				frame.add(new Amministrazione(frame)); //aggiungiamo al frame il pannello del login
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
		testoPanel.setVisible(true);
		dropdownPanel.setVisible(true);
		textAreaPanel.setVisible(true);
		textAreaPanel2.setVisible(true);
		attivaPanel.setVisible(true);
		downBarPanel.setVisible(true);
		
		setLayout(new GridLayout(8,1));
		
		add(upBarPanel);
		add(nameSectionBarPanel);
		add(testoPanel);
		add(dropdownPanel);
		add(textAreaPanel);
		add(textAreaPanel2);
		add(attivaPanel);
		add(downBarPanel);
	}

}
