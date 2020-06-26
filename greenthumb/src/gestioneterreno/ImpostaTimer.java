package gestioneterreno;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalTime;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import amministrazione.Amministrazione;
import general.Homepage;
import gestioneimpianto.GestioneImpianto;
import statopiante.StatoPiante;

public class ImpostaTimer extends JPanel {
	private static final long serialVersionUID = 1L;
	JPanel upBarPanel; //barra con il logo e il bottone di uscita
	JPanel nameSectionBarPanel; //barra con il nome della sezione
	JPanel testoPanel; //panel di testo esplicativo
	JPanel timerPanel; 
	JPanel bottonePanel; 
	JPanel downBarPanel; //barra delle icone delle sezioni

	
	public ImpostaTimer (JFrame frame) {
				
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
		testoPanel=new JPanel();
		testoPanel.setBackground(Color.WHITE);
		timerPanel=new JPanel(); 
		timerPanel.setBackground(Color.WHITE);
		bottonePanel=new JPanel(); 
		bottonePanel.setBackground(Color.WHITE);
		downBarPanel=new JPanel();
		downBarPanel.setBackground(Color.WHITE);

		
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
				JLabel sectionName=new JLabel("<html><center>Timer</center></html>");
				sectionName.setFont(fontBig);
				sectionName.setForeground(new Color(0,138,177));
				
				sectionName.setVisible(true);
				nameSectionBarPanel.add(sectionName);
				//fine elementi nameSectionBarPanel
				
				
				//inizio elementi testoPanel
				JLabel testo = new JLabel("<html><center>Imposta un timer per la data odierna<br><br><br></center></html>");
				testo.setFont(font);
				testo.setFont(fontMax);
				
				testo.setVisible(true);
				testoPanel.add(testo);
				//fine elementi testoPanel
				
				//inizio elementi timerPanel
				JLabel labelTime = new JLabel("Durata irrigazione: "); 
				JComboBox comboRa = new JComboBox(); 
				for(int i=0; i<24; i++) {
					comboRa.addItem(i);
				}
				
				JLabel lab = new JLabel(":"); 
				
				JComboBox comboMin = new JComboBox(); 
				for(int i=0; i<60; i++) {
					comboMin.addItem(i);
				}
				labelTime.setFont(font);
				labelTime.setVisible(true);
				lab.setFont(font);
				lab.setVisible(true);
				timerPanel.add(labelTime);
				timerPanel.add(comboRa);
				timerPanel.add(lab);
				timerPanel.add(comboMin);	 				
				//fine elementi timerPanel
				
				
				//inizio elementi bottonePanel
				JButton bott = new JButton("Imposta"); 
				bott.setForeground(new Color(0,138,177));
				bott.setFont(fontMedium);
				bott.setFocusPainted(false); 
				bott.setVisible(true);
				bottonePanel.add(bott);
				
				
				class ButtonListener implements ActionListener {
					
					public void actionPerformed(ActionEvent event) {
						
						int se=Integer.parseInt(comboRa.getSelectedItem().toString());
						int semin=Integer.parseInt(comboMin.getSelectedItem().toString());
						if(se!=0||semin!=0) {
						int j=JOptionPane.showConfirmDialog(null, "<html>Sei sicuro<br>di voler impostare questo timer?</html>","Attenzione!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						if(j==JOptionPane.YES_OPTION) {
							JOptionPane.showMessageDialog(null, "<html>Il timer e' stato impostato.<br>Partira' da adesso<br>e durera':" + se + "h e " + semin + " minuti." + " </html>","Attenzione!",1);
							setVisible(false);
							frame.add(new GestioneTerreno(frame));
						} else {
							JOptionPane.showMessageDialog(null, "<html>Annullando l'operazione<br>non sara' impostato<br>alcun timer.</html>","Attenzione!",1);
							setVisible(false);
							frame.add(new ModalitaIrrigazione(frame,null));
							}
						
						} else {
							
							JOptionPane.showMessageDialog(null, "<html>Attenzione!<br>Non hai impostato la durata.</html>","Message",1);
							setVisible(false);
							frame.add(new ImpostaTimer(frame));

						}
					}
				}
				
				ActionListener li= new ButtonListener(); 
				bott.addActionListener(li);
				//fine elementi bottonePanel
				
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
				timerPanel.setVisible(true);
				bottonePanel.setVisible(true);
				downBarPanel.setVisible(true);

				
				setLayout(new GridLayout(6,1));
				
				add(upBarPanel);
				add(nameSectionBarPanel);
				add(testoPanel);
				add(timerPanel);
				add(bottonePanel);
				add(downBarPanel);
				
				
		
	}

}
