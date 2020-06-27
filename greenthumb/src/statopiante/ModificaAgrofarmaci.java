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

public class ModificaAgrofarmaci extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public static ArrayList<String> farmaco = new ArrayList<String>();
	JPanel upBarPanel; //barra con il logo e il bottone di uscita
	JPanel nameSectionBarPanel; //barra con il nome della sezione
	JPanel miscelaAgrofarmaciPanel; //contenuto seconda parte della schermata
	JPanel downBarPanel; //barra delle icone delle sezioni
	JPanel modificaPanel; //bottone ottimizza
	JPanel imgPanel; //pannello per l'immagine della sezione
	JPanel miscelaAgrofarmaci2Panel;//contesuto seconda parte della schermata
	
	public ModificaAgrofarmaci (JFrame frame) {
		
		//Font fontBig = new Font("Herculanum", Font.BOLD, 30);
		Font fontSmall=new Font("Herculanum", Font.PLAIN, 10);
		Font fontMedium = new Font("Herculanum", Font.BOLD, 16);
		Font font = new Font("Comic sans", Font.PLAIN, 13);
		
		
		
		upBarPanel=new JPanel();
		upBarPanel.setBackground(Color.WHITE);
		nameSectionBarPanel=new JPanel();
		nameSectionBarPanel.setBackground(Color.WHITE);
		miscelaAgrofarmaciPanel=new JPanel();
		miscelaAgrofarmaciPanel.setBackground(Color.WHITE);
		downBarPanel=new JPanel();
		downBarPanel.setBackground(Color.WHITE);
		modificaPanel=new JPanel();
		modificaPanel.setBackground(Color.WHITE);
		imgPanel=new JPanel();
		imgPanel.setBackground(Color.WHITE);
		miscelaAgrofarmaci2Panel=new JPanel();
		miscelaAgrofarmaci2Panel.setBackground(Color.WHITE);
		
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
		
		
		//inizio elementi imgPanel
		
		JLabel testo=new JLabel("<html><center>elimina o aggiungi agrofarmaci alla miscela</center></html>");
		testo.setFont(font);
		testo.setForeground(new Color(92,202,98));
		testo.setVisible(true);
		imgPanel.add(testo);
		//fine elementi imgPanel
		
		
		//inizio elementi miscelaAgrofarmaci
		miscelaAgrofarmaciPanel.setLayout(new GridLayout(3,3));
		
		JCheckBox enovit= new JCheckBox("enovit");
		JCheckBox contraxs= new JCheckBox("contraxs stange");
		JCheckBox quintamon= new JCheckBox("quintamon");
		
		miscelaAgrofarmaciPanel.add(enovit);
		miscelaAgrofarmaciPanel.add(new JLabel(""));
		miscelaAgrofarmaciPanel.add(contraxs);
		miscelaAgrofarmaciPanel.add(new JLabel(""));
		miscelaAgrofarmaciPanel.add(quintamon);
		miscelaAgrofarmaciPanel.add(new JLabel(""));
		
	        
	        if(enovit.isSelected()){  
	            farmaco.add("enovit");
	        }  
	        if(contraxs.isSelected()){  
	        	farmaco.add("contraxs stange");
	        }  
	        if(quintamon.isSelected()){  
	        	farmaco.add("quintamon");
	        }  
		//fine elementi miscelaAgrofarmaci
		
		
		
		//inizio elementi miscelaAgrofarmaci2
	    miscelaAgrofarmaci2Panel.setLayout(new GridLayout(3,3));
	    
		JCheckBox ziram= new JCheckBox("ziram 80");
		JCheckBox diledit= new JCheckBox("diledit");
		JCheckBox bromcid= new JCheckBox("bromcid");
		
		miscelaAgrofarmaci2Panel.add(ziram);
		miscelaAgrofarmaci2Panel.add(new JLabel(""));
		miscelaAgrofarmaci2Panel.add(diledit);
		miscelaAgrofarmaci2Panel.add(new JLabel(""));
		miscelaAgrofarmaci2Panel.add(bromcid);
		
		 
	        if(ziram.isSelected()){  
	        	farmaco.add("ziram 80");
	        }  
	        if(diledit.isSelected()){  
	        	farmaco.add("ziram 80");
	        }  
	        if(bromcid.isSelected()){  
	        	farmaco.add("ziram 80");
	        }  
		//fine elementi miscelaAgrofarmaci2
	
		
		//inizio bottone modificaAgro
		JButton modificaAgro=new JButton("conferma modifica");
		modificaAgro.setForeground(new Color(96,202,92));
		modificaAgro.setFont(fontMedium);
		modificaAgro.setFocusPainted(false); 
		modificaAgro.setVisible(true);
		
		class modificaAgroListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int j=JOptionPane.showConfirmDialog(null,"<html>Confermi di voler modificare<br>la miscela di agrofarmaci?</html>","Attenzione!",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if (j==JOptionPane.OK_OPTION) {
					if(enovit.isSelected()){  
						farmaco.add("enovit");
					}  
					if(contraxs.isSelected()){  
						farmaco.add("contraxs stange");
					}  
					if(quintamon.isSelected()){  
						farmaco.add("quintamon");
					}  
					if(ziram.isSelected()){  
						farmaco.add("ziram 80");
					} 	 
					if(diledit.isSelected()){  
						farmaco.add("ziram 80");
					}  
					if(bromcid.isSelected()){  
						farmaco.add("ziram 80");
					}  
					JOptionPane.showMessageDialog(null,"<html>La miscela di agrofarmaci<br>è stata modificata<br>con successo</html>","Message",1);
					setVisible(false);
					frame.add(new Agrofarmaci(frame));
				} else {
					
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
		miscelaAgrofarmaciPanel.setVisible(true);
		miscelaAgrofarmaci2Panel.setVisible(true);
		modificaPanel.setVisible(true);
		downBarPanel.setVisible(true);
		imgPanel.setVisible(true);
		setLayout(new GridLayout(7,1));
		add(upBarPanel);
		add(nameSectionBarPanel);
		add(imgPanel);
		add(miscelaAgrofarmaciPanel);
		add(miscelaAgrofarmaci2Panel);
		add(modificaPanel);
		add(downBarPanel);
		
		
		
	}
	

}
