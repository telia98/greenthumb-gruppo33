package amministrazione;

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

import general.Homepage;

public class SelezioneImp2 extends JPanel{
	
	private static final long serialVersionUID = 1L;
	JPanel upBarPanel; //barra con il logo e il bottone di uscita
	
		public SelezioneImp2(JFrame frame) {
			Font fontBig = new Font("Herculanum", Font.BOLD, 30);
			Font fontSmall=new Font("Herculanum", Font.PLAIN, 10);
			Font fontMedium = new Font("Herculanum", Font.BOLD, 16);
			Font font = new Font("Comic sans", Font.PLAIN, 13);
			
			upBarPanel=new JPanel();
			upBarPanel.setBackground(Color.WHITE);
			
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
			
			
			upBarPanel.setVisible(true);
			setLayout(new GridLayout(8,1));
			
			add(upBarPanel);
	}
}
