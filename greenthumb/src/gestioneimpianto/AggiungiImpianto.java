
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import amministrazione.Amministrazione;
import general.Homepage;
import general.MenuPrincipale;
import general.Tester;
import gestioneterreno.GestioneTerreno;
import statopiante.StatoPiante;
import utility.Impianto;

public class AggiungiImpianto extends JPanel {
	
	private static final long serialVersionUID = 1L;
	JPanel upBarPanel; //barra con il logo e il bottone di uscita
	JPanel nameSectionBarPanel; //barra con il nome della sezione
	JPanel downBarPanel; //barra delle icone delle sezioni
	JPanel infoPanel; //barra per informazioni generali
	JPanel codImpiantoPanel; //pannello per il codice dell'impianto da inserire
	JPanel nomeImpiantoPanel; //pannello per il nome dell'impianto da inserire
	JPanel posImpiantoPanel; //pannello per la locazione dell'impianto da inserire
	JPanel viaImpiantoPanel; //pannello per la via dell'impianto da inserire
	JPanel civicoImpiantoPanel; //pannello per il civico dell'impianto da inserire
	JPanel cittaImpiantoPanel; //pannello per la citta' dell'impianto da inserire
	JPanel buttonPanel; //pannello per il bottone di aggiunta
	
	public AggiungiImpianto(JFrame frame) {
		Font fontBig = new Font("Herculanum", Font.BOLD, 30);
		Font fontSmall=new Font("Herculanum", Font.PLAIN, 10);
		Font fontMedium = new Font("Herculanum", Font.BOLD, 16);
		Font font = new Font("Comic sans", Font.PLAIN, 13);
		
		upBarPanel=new JPanel();
		upBarPanel.setBackground(Color.WHITE);
		nameSectionBarPanel=new JPanel();
		nameSectionBarPanel.setBackground(Color.WHITE);
		infoPanel=new JPanel();
		infoPanel.setBackground(Color.WHITE);
		downBarPanel=new JPanel();
		downBarPanel.setBackground(Color.WHITE);
		codImpiantoPanel=new JPanel();
		codImpiantoPanel.setBackground(Color.WHITE);
		nomeImpiantoPanel=new JPanel();
		nomeImpiantoPanel.setBackground(Color.WHITE);
		posImpiantoPanel=new JPanel();
		posImpiantoPanel.setBackground(Color.WHITE);
		viaImpiantoPanel=new JPanel();
		viaImpiantoPanel.setBackground(Color.WHITE);
		civicoImpiantoPanel=new JPanel();
		civicoImpiantoPanel.setBackground(Color.WHITE);
		cittaImpiantoPanel=new JPanel();
		cittaImpiantoPanel.setBackground(Color.WHITE);
		buttonPanel=new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		
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
		
		class LogoListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				frame.add(new MenuPrincipale(frame));
			}
		}
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
		JLabel sectionName=new JLabel("<html><center>aggiungi impianto</center></html>");
		sectionName.setFont(fontBig);
		sectionName.setForeground(new Color(89,105,109));
		
		sectionName.setVisible(true);
		nameSectionBarPanel.add(sectionName);
		//fine elementi nameSectionBarPanel
		
		//inizio elementi infoPanel
		JLabel info=new JLabel("<html><center>Inserisci i dati indicati<br>per registrare il tuo impianto d'irrigazione<br>al sistema GreenThumb</center></html>");
		infoPanel.add(info);
		//fine elementi infoPanel
		
		//inizio elementi codImpiantoPanel
		JLabel codice=new JLabel("Codice impianto");
		JTextField inputCodice=new JTextField("",10);
		
		JButton questionCod=new JButton();
		questionCod.setPreferredSize(new Dimension(40,40));
		try {
			//recupero immagine del punto interrogativo
			Image questionImg=ImageIO.read(new File("img/question.png"));
			questionImg=questionImg.getScaledInstance(20,20,Image.SCALE_SMOOTH);
			ImageIcon icona=new ImageIcon(questionImg);
			questionCod.setIcon(icona); 
			questionCod.setBorder(null); 
			questionCod.setFocusPainted(false);
			questionCod.setVisible(true);
			questionCod.invalidate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		class questioCodiceListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null,"<html>Inserisci il codice riportato <br>sulla confezione dell'impianto</html>","Codice impianto",1);
			}
		}
		ActionListener codiceListener=new questioCodiceListener();
		questionCod.addActionListener(codiceListener);
		
		codImpiantoPanel.add(codice);
		codImpiantoPanel.add(inputCodice);
		codImpiantoPanel.add(questionCod);
		//fine elementi codImpiantoPanel
		
		//inizio elementi nomeImpiantoPanel
		JLabel nomeImpianto=new JLabel("Nome impianto");
		JTextField inputNome=new JTextField("",10);
		JButton questionNome=new JButton();
		questionNome.setPreferredSize(new Dimension(40,40));
		
		try {
			//recupero immagine del punto interrogativo
			Image questionImg=ImageIO.read(new File("img/question.png"));
			questionImg=questionImg.getScaledInstance(20,20,Image.SCALE_SMOOTH);
			ImageIcon icona=new ImageIcon(questionImg);
			questionNome.setIcon(icona); 
			questionNome.setBorder(null); 
			questionNome.setFocusPainted(false);
			questionNome.setVisible(true);
			questionNome.invalidate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		class QuestionNomeListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null,"<html>Inserisci una breve descrizione<br>per facilitarti il ricoscimento<br>dell'impianto</html>","Nome impianto",1);
			}
		}
		ActionListener nomeListener=new QuestionNomeListener();
		questionNome.addActionListener(nomeListener);
		
		nomeImpiantoPanel.add(nomeImpianto);
		nomeImpiantoPanel.add(inputNome);
		nomeImpiantoPanel.add(questionNome);
		//fine elementi nomeImpiantoPanel
		
		//inizio elementi posImpiantoPanel
		JLabel locazione=new JLabel("<html><center>Inserisci l'indirizzo<br>dove sarà locato l'impianto</center></html>");
		posImpiantoPanel.add(locazione);
		//fine elementi posImpiantoPanel
		
		//inizio elementi viaImpiantoPanel
		JLabel via=new JLabel("- Via");	
		JTextField inputVia=new JTextField("",10);
		viaImpiantoPanel.add(via);
		viaImpiantoPanel.add(inputVia);
		//fine elementi viaImpiantoPanel
		
		//inizio elementi civicoImpiantoPanel
		JLabel civico=new JLabel("- N° civico");	
		JTextField inputCivico=new JTextField("",5);
		civicoImpiantoPanel.add(civico);
		civicoImpiantoPanel.add(inputCivico);
		//fine elementi civicoImpiantoPanel
		
		//inizio elementi cittaImpiantoPanel
		JLabel citta=new JLabel("- Citta'");	
		JTextField inputCitta=new JTextField("",6);
		cittaImpiantoPanel.add(citta);
		cittaImpiantoPanel.add(inputCitta);
		//fine elementi cittaImpiantoPanel
		
		//inizio elementi buttonPanel
		JButton aggiungi=new JButton("aggiungi impianto");
		aggiungi.setForeground(new Color(89,105,109));
		aggiungi.setFont(fontMedium);
		aggiungi.setFocusPainted(false); 
		aggiungi.setVisible(true);
		
		class AggiungiListener implements ActionListener {
			
			Impianto impianto=null;
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int j=JOptionPane.showConfirmDialog(null,"<html>Confermi di voler aggiungere<br>l'impianto al sistema?</html>","Attenzione!",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if (j==JOptionPane.OK_OPTION) {
					//conferma di voler aggiungere l'impianto
					impianto=new Impianto(inputNome.getText(),inputCodice.getText(),inputVia.getText(),inputCivico.getText(),inputCitta.getText());
					Tester.addImpianto(impianto);
					System.out.println("impianto aggiunto:" + Tester.getImpianti().toString());
					JOptionPane.showMessageDialog(null,"<html>L'aggiunta del nuovo impianto<br>è avvenuta con successo</html>","Message",1);
					setVisible(false);
					frame.add(new GestioneImpianto(frame));
				} else if (j==JOptionPane.CANCEL_OPTION) {
					//rimango alla schermata attuale senza apportare modifiche
				} else {
					//annullo la richiesta di aggiunta impianto
					setVisible(false);
					frame.add(new GestioneImpianto(frame));
				}
			}
		}
		ActionListener aggiungiListener=new AggiungiListener();
		aggiungi.addActionListener(aggiungiListener);
		
		buttonPanel.add(aggiungi);
		//fine elementi buttonPanel
		
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
		
		//action listener per i bottoni
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
		codImpiantoPanel.setVisible(true);
		nomeImpiantoPanel.setVisible(true);
		posImpiantoPanel.setVisible(true);
		viaImpiantoPanel.setVisible(true);
		civicoImpiantoPanel.setVisible(true);
		cittaImpiantoPanel.setVisible(true);
		downBarPanel.setVisible(true);
		infoPanel.setVisible(true);
		buttonPanel.setVisible(true);
		
		setLayout(new GridLayout(11,1));
		add(upBarPanel);
		add(nameSectionBarPanel);
		add(infoPanel);
		add(codImpiantoPanel);
		add(nomeImpiantoPanel);
		add(posImpiantoPanel);
		add(viaImpiantoPanel);
		add(civicoImpiantoPanel);
		add(cittaImpiantoPanel);
		add(buttonPanel);
		add(downBarPanel);
	}
}
