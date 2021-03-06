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

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


import amministrazione.Amministrazione;
import general.Homepage;
import gestioneimpianto.GestioneImpianto;
import statopiante.StatoPiante;
import utility.Impianto;

public class ModalitaIrrigazione extends JPanel {
	
	private static final long serialVersionUID = 1L;
	JPanel upBarPanel; //barra con il logo e il bottone di uscita
	JPanel nameSectionBarPanel; //barra con il nome della sezione
	JPanel testoPanel; //panel per la descrizione di cosa si andr� a fare
	JPanel testoPanel2;
	JPanel automaticaPanel; //panel con bottone automatica
	JPanel manualePanel; // panel con bottone manuale
	JPanel confermaPanel; // panel con bottone conferma
	JPanel downBarPanel; //barra delle icone delle sezioni
	JPanel imgPanel; //pannello per l'immagine della sezione
	
	public ModalitaIrrigazione (JFrame frame, Impianto impianto) {
		
		Font fontBig = new Font("Herculanum", Font.BOLD, 30);
		Font fontSmall=new Font("Herculanum", Font.PLAIN, 10);
		Font fontMedium = new Font("Herculanum", Font.BOLD, 16);
		Font font = new Font("Comic sans", Font.PLAIN, 13);
		Font fontMin = new Font("Comic sans", Font.PLAIN, 10); 
		
		upBarPanel=new JPanel();
		upBarPanel.setBackground(Color.WHITE);
		nameSectionBarPanel=new JPanel();
		nameSectionBarPanel.setBackground(Color.WHITE);
		testoPanel= new JPanel();
		testoPanel.setBackground(Color.WHITE);
		testoPanel2= new JPanel();
		testoPanel2.setBackground(Color.WHITE);
		automaticaPanel=new JPanel();
		automaticaPanel.setBackground(Color.WHITE);
		manualePanel= new JPanel();
		manualePanel.setBackground(Color.WHITE);
		confermaPanel= new JPanel();
		confermaPanel.setBackground(Color.WHITE);
		downBarPanel=new JPanel();
		downBarPanel.setBackground(Color.WHITE);
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
				upBarPanel.add(new JLabel(""));
				upBarPanel.add(new JLabel(""));
				upBarPanel.add(new JLabel(""));
				upBarPanel.add(appName);
				upBarPanel.add(new JLabel(""));
				upBarPanel.add(new JLabel(""));
				//fine elementi upBarPanel
				
				//inizio elementi nameSectionBarPanel
				JLabel sectionName=new JLabel("<html><center>Come vuoi irrigare?</center></html>");
				sectionName.setFont(fontBig);
				sectionName.setForeground(new Color(0,138,177));
				
				sectionName.setVisible(true);
				nameSectionBarPanel.add(sectionName);
				//fine elementi nameSectionBarPanel
				
				//inizio elementi testoPanel
				JLabel info = new JLabel("<html><center>Abilita la modalita'<br>con cui desideri irrigare.<br><br><br></center></html>");
				info.setFont(font);
				testoPanel.add(info,BorderLayout.NORTH);
				//fine elementi testoPanel
				
				//inizio testoPanel 2
				JLabel info2 = new JLabel("<html><center>N.B. La modalita' automatica eè selezionabile solo se<br>e' stato gia' aggiunto un programma di irrigazione.<br><br><br></center></html>");
				info2.setFont(fontMin);
				testoPanel2.add(info2,BorderLayout.NORTH);
				//fine testoPanel 2
				
				//inizio elementi panel con i tre bottoni
				JRadioButton automatica= new JRadioButton("Automatica"); 
				automatica.setSelected(false);
				JRadioButton manuale = new JRadioButton("Manuale"); 
				manuale.setSelected(true);
				ButtonGroup both = new ButtonGroup(); 
				both.add(automatica);
				both.add(manuale);
				
				JButton conferma= new JButton("Conferma");
				conferma.setForeground(new Color(0,138,177));
				conferma.setFont(fontMedium);
				conferma.setFocusPainted(false);

				automaticaPanel.add(automatica);
				manualePanel.add(manuale);
				confermaPanel.add(conferma);
				
				
				class ButtonGroupListener implements ActionListener {
					
					public void actionPerformed(ActionEvent event) {
						if(manuale.isSelected()) {
							frame.add(new ImpostaTimer(frame)); 
							JOptionPane.showMessageDialog(null, "<html>Imposta la durata<br>dell'irrigazione di oggi.</html>","Message",1);
							setVisible(false);
							
						} else
						
							if(automatica.isSelected()) {
								setVisible(false);
								frame.add(new ModalitaAutomatica(frame,impianto,null)); 
						}
						
					}
				}
				
				ActionListener listn= new ButtonGroupListener(); 
				conferma.addActionListener(listn);
				//fine elementi panel con i tre bottoni
				
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
				testoPanel2.setVisible(true);
				automaticaPanel.setVisible(true);
				manualePanel.setVisible(true);
				confermaPanel.setVisible(true);

				
				downBarPanel.setVisible(true);
				imgPanel.setVisible(true);
				
				setLayout(new GridLayout(9,1));
				
				add(upBarPanel);
				add(nameSectionBarPanel);
				add(imgPanel);
				add(testoPanel);
				add(testoPanel2);
				
				add(automaticaPanel);
				add(manualePanel);
				add(confermaPanel);

				add(downBarPanel);
		
	}

}
