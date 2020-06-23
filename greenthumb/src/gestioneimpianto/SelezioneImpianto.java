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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import general.Homepage;

public class SelezioneImpianto extends JPanel {
	
	private static final long serialVersionUID = 1L;
	JPanel upBarPanel; //barra con il logo e il bottone di uscita
	JPanel nameSectionBarPanel; //barra con il nome della sezione
	JPanel contenutoPanel; //contenuto della schermata
	JPanel downBarPanel; //barra delle icone delle sezioni
	JPanel comboboxPanel; //combo box per la selezione di un impianto dalla lista
	JPanel emptyPanel;
	JPanel empty3Panel;
	JPanel infoPanel;
	
	public SelezioneImpianto(JFrame frame) {
		Font fontBig = new Font("Herculanum", Font.BOLD, 30);
		Font fontSmall=new Font("Herculanum", Font.PLAIN, 10);
		
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
		comboboxPanel=new JPanel();
		comboboxPanel.setBackground(Color.WHITE);
		infoPanel=new JPanel();
		infoPanel.setBackground(Color.WHITE);
		
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
		JLabel sectionName=new JLabel("<html><center>Seleziona Impianto</center></html>");
		sectionName.setFont(fontBig);
		sectionName.setForeground(new Color(89,105,109));
		
		sectionName.setVisible(true);
		nameSectionBarPanel.add(sectionName);
		//fine elementi nameSectionBarPanel
		
		//inizio elementi contenutoPanel
		JLabel message=new JLabel("<html><center>Seleziona dalla lista<br>l'impianto che desideri controllare.<br></center></html>");
		contenutoPanel.add(message);
		//fine elementi contenutoPanel
		
		//inizio elementi infoPanel
		JLabel message2=new JLabel("<html><center>La tua selezione sarà mantenuta<br>per tutte le operazioni successive.</center></html>");
		infoPanel.add(message2);
		//fine elementi infoPanel
		
		//inizio elementi comboboxPanel
		JComboBox<String> listaImpianti=new JComboBox<String>();
		listaImpianti.addItem(" ");
		listaImpianti.addItem("impianto 1");
		listaImpianti.addItem("impianto 2");
		listaImpianti.setEditable(false);
		comboboxPanel.add(listaImpianti);
		
		class ComboListener implements ActionListener {
			
			public void actionPerformed(ActionEvent event) {
			
				String op=(String) listaImpianti.getSelectedItem();
				
				if (op.equals("impianto 1")) {
					JOptionPane.showMessageDialog(null,"<html>Hai selezionato:<br>impianto 1</html>","Message",1);
					setVisible(false);
					frame.add(new VisualizzaProgrammiImpianto(frame,"impianto 1"));
				}
				
				if (op.equals("impianto 2")) {
					JOptionPane.showMessageDialog(null,"<html>Hai selezionato:<br>impianto 2</html>","Message",1);
					setVisible(false);
					frame.add(new VisualizzaProgrammiImpianto(frame,"impianto 2"));
				}
			}
		}
		ActionListener listener=new ComboListener();
		listaImpianti.addActionListener(listener);		
		//fine elementi comboboxPanel
		
		upBarPanel.setVisible(true);
		nameSectionBarPanel.setVisible(true);
		contenutoPanel.setVisible(true);
		emptyPanel.setVisible(true);
		empty3Panel.setVisible(true);
		downBarPanel.setVisible(true);
		comboboxPanel.setVisible(true);
		infoPanel.setVisible(true);
		
		setLayout(new GridLayout(8,1));
		add(upBarPanel);
		add(nameSectionBarPanel);
		add(contenutoPanel);
		add(infoPanel);
		add(comboboxPanel);
		add(emptyPanel);
		add(empty3Panel);
		add(downBarPanel);
	}
}
