package gestioneimpianto;

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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import general.Homepage;
import general.MenuPrincipale;
import general.Tester;
import utility.Impianto;
import utility.ProgrammaIrrigazione;

public class ImpostazioniProgramma extends JPanel {
	
	private static final long serialVersionUID = 1L;
	JPanel upBarPanel; //barra con il logo e il bottone di uscita
	JPanel nameSectionBarPanel; //barra con il nome della sezione
	JPanel closePanel; //pannello per l'icona di uscita
	JPanel nomeProgrammaPanel; //pannello per il nome del programm
	JPanel gettoPanel; //pannello per impostazioni getto d'acqua
	JPanel rotazionePanel; //pannello per impostazioni rotazione getto d'acqua
	JPanel inizioFinePanel; //pannello per impostazioni orario inizio-fine irrigazione
	JPanel tipoPanel; //pannello per impostazioni tipologia irrigazione
	JPanel bottonePanel; //pannello per bottone salva/aggiungi
	
	public ImpostazioniProgramma(JFrame frame, Impianto impianto, ProgrammaIrrigazione programma) {
		Font fontBig = new Font("Herculanum", Font.BOLD, 28);
		Font fontSmall=new Font("Herculanum", Font.PLAIN, 10);
		Font fontMedium = new Font("Herculanum", Font.BOLD, 16);
		Font font = new Font("Comic sans", Font.PLAIN, 13);
		
		LocalTime fo=null;
		String ti="";
		
		upBarPanel=new JPanel();
		upBarPanel.setBackground(Color.WHITE);
		nameSectionBarPanel=new JPanel();
		nameSectionBarPanel.setBackground(Color.WHITE);
		closePanel=new JPanel();
		closePanel.setBackground(Color.WHITE);
		nomeProgrammaPanel=new JPanel();
		nomeProgrammaPanel.setBackground(Color.WHITE);
		gettoPanel=new JPanel();
		gettoPanel.setBackground(Color.WHITE);
		rotazionePanel=new JPanel();
		rotazionePanel.setBackground(Color.WHITE);
		inizioFinePanel=new JPanel();
		inizioFinePanel.setBackground(Color.WHITE);
		tipoPanel=new JPanel();
		tipoPanel.setBackground(Color.WHITE);
		bottonePanel=new JPanel();
		bottonePanel.setBackground(Color.WHITE);
		
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
		JLabel sectionName;
		if (programma!=null) {
			sectionName=new JLabel("<html><center>modifica programma</center></html>");
			sectionName.setFont(fontBig);
			sectionName.setForeground(new Color(89,105,109));
			sectionName.setVisible(true);
		} else {
			sectionName=new JLabel("<html><center>aggiungi programma</center></html>");
			sectionName.setFont(fontBig);
			sectionName.setForeground(new Color(89,105,109));
			sectionName.setVisible(true);
		}
		nameSectionBarPanel.add(sectionName);
		//fine elementi nameSectionBarPanel
		
		//inizio elementi closePanel
		JButton close=new JButton();		
		close.setPreferredSize(new Dimension(70,70));
		try {
			//recupero immagine per il close
			Image closeImg=ImageIO.read(new File("img/close.png"));
			closeImg=closeImg.getScaledInstance(30,30,Image.SCALE_SMOOTH);
			ImageIcon icona2=new ImageIcon(closeImg);
			close.setIcon(icona2); 
			close.setBorder(null); 
			close.setFocusPainted(false);
			close.setVisible(true);
			close.invalidate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		class CloseListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int j=JOptionPane.showConfirmDialog(null,"<html>Confermi di voler annullare<br>la tua richiesta di operazione?<br><br>Tutte le modifiche effettuate<br>saranno perse.</html>","Attenzione!",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if (j==JOptionPane.OK_OPTION) {
					setVisible(false);
					if (programma!=null)
						frame.add(new VisualizzaProgrammiImpianto(frame,impianto,programma));
					else
						frame.add(new VisualizzaProgrammiImpianto(frame,impianto,null));
				} else {
					//ritorno alla schermata di prima
				}
			}
		}
		ActionListener closeListener=new CloseListener();
		close.addActionListener(closeListener);
		
		closePanel.setLayout(new GridLayout(1,4));
		closePanel.add(new JLabel(""));
		closePanel.add(new JLabel(""));
		closePanel.add(new JLabel(""));
		closePanel.add(close);
		//fine elementi closePanel
		
		//inizio elementi nomeProgrammaPanel
		JLabel nomeP=new JLabel("nome programma");
		nomeP.setFont(font);
		JTextField inputNome=new JTextField("",10);
		if (programma!=null) {
			inputNome.setText(programma.getNome());
		}
		nomeProgrammaPanel.add(nomeP);
		nomeProgrammaPanel.add(inputNome);
		//fine elementi nomeProgrammaPanel
		
		//inizio elementi gettoPanel
		JLabel getto=new JLabel("potenza del getto d'acqua (scala 1-15)");
		getto.setFont(font);
		JTextField inputGetto=new JTextField("",3);
		if (programma!=null) {
			inputGetto.setText(String.valueOf(programma.getPotenzaGetto()));
		}
		gettoPanel.add(getto);
		gettoPanel.add(inputGetto);
		//fine elementi gettoPanel
		
		//inizio elementi rotazionePanel
		JLabel rotazione=new JLabel("rotazione idrante");
		rotazione.setFont(font);
		JRadioButton onOff=new JRadioButton();
		if (programma!=null) {
			if (programma.isRotazioneGetto()==false)
				onOff.setSelected(false);
			else
				onOff.setSelected(true);
		}

		rotazionePanel.add(rotazione);
		rotazionePanel.add(onOff);
		//fine elementi rotazionePanel
		
		//inizio elementi inizioFinePanel
		JLabel inizio=new JLabel("ora di inizio irrigazione");
		inizio.setFont(font);
		JComboBox comboH=new JComboBox();
		for(int i=0;i<24;i++) 
			comboH.addItem(i);
		JLabel sep=new JLabel(" : ");
		JComboBox comboMin=new JComboBox();
		for(int i=0;i<60;i++) 
			comboMin.addItem(i);
		
		inizioFinePanel.add(inizio);
		inizioFinePanel.add(comboH);
		inizioFinePanel.add(sep);
		inizioFinePanel.add(comboMin);

		JLabel fine=new JLabel("ora di fine irrigazione");
		fine.setFont(font);
		JComboBox comboHF=new JComboBox();
		for(int i=0;i<24;i++) 
			comboHF.addItem(i);
		JLabel sep2=new JLabel(" : ");
		JComboBox comboMinF=new JComboBox();
		for(int i=0;i<60;i++) 
			comboMinF.addItem(i);
		
		inizioFinePanel.add(fine);
		inizioFinePanel.add(comboHF);
		inizioFinePanel.add(sep2);
		inizioFinePanel.add(comboMinF);
		//fine elementi iniziofinePanel
		
		//inizio elementi tipoPanel
		ButtonGroup tipologia=new ButtonGroup();
		JRadioButton radioTipo1=new JRadioButton("a getto continuo");
		JRadioButton radioTipo2=new JRadioButton("a intervalli regolari di 20 minuti");
		tipologia.add(radioTipo1);
		tipologia.add(radioTipo2);
		
		tipoPanel.setLayout(new GridLayout(2,1));
		tipoPanel.add(radioTipo1);
		tipoPanel.add(radioTipo2);
		//fine elementi tipoPanel
		
		//inizio elementi bottonePanel
		JButton button;
		if (programma!=null) {
			button=new JButton("salva modifiche");
			button.setForeground(new Color(89,105,109));
			button.setFont(fontMedium);
			button.setFocusPainted(false); 
			button.setVisible(true);
			
			class ModificaListener implements ActionListener {

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int j=JOptionPane.showConfirmDialog(null,"<html>Confermi il salvataggio<br>delle modifiche<br> effettuate al programma?</html>","Attenzione!",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
					if (j==JOptionPane.OK_OPTION) {
						String np=inputNome.getText();
						int pg=Integer.parseInt(inputGetto.getText());
						boolean rg=false;
						if (onOff.isSelected())
							rg=true;
						else
							rg=false;
						int hInizio=Integer.parseInt(comboH.getSelectedItem().toString());
						int minInizio=Integer.parseInt(comboMin.getSelectedItem().toString());
						LocalTime io=LocalTime.of(hInizio,minInizio);
						int hFine=Integer.parseInt(comboHF.getSelectedItem().toString());
						int minFine=Integer.parseInt(comboMinF.getSelectedItem().toString());
						LocalTime fo=LocalTime.of(hFine,minFine);
						String ti=null;
						if (radioTipo1.isSelected())
							ti=radioTipo1.getText();
						else
							ti=radioTipo2.getText();
						
						if (np.equals("") || pg==0 || io.equals("") || fo.equals("") || ti.equals("")) 
							JOptionPane.showMessageDialog(null,"<html>E' necessario settare<br>tutte le impostazioni<br>del programma</html>","Message",1);
						else {
							ProgrammaIrrigazione modificato=new ProgrammaIrrigazione(impianto,np,pg,rg,io,fo,ti);
							System.out.println(modificato);
							Tester.getProgrammi().remove(programma);
							System.out.println(Tester.getProgrammi());
							Tester.addProgramma(modificato);
							System.out.println(Tester.getProgrammi());
						
							JOptionPane.showMessageDialog(null,"<html>La modifica<br>del programma d'irrigazione<br>è avvenuta con successo<br><br>Per attivarlo<br>proseguire nella sezione<br>'Gestione terreno' all'opzione<br>irrigazione automatica</html>","Message",1);
							setVisible(false);
							frame.add(new VisualizzaProgrammiImpianto(frame,modificato.getImpianto(),modificato));
						}
					}
				}
			}
			ActionListener modificaListener=new ModificaListener();
			button.addActionListener(modificaListener);
			
		} else {
			button=new JButton("aggiungi programma d'irrigazione");
			button.setForeground(new Color(89,105,109));
			button.setFont(fontMedium);
			button.setFocusPainted(false); 
			button.setVisible(true);
			
			class AggiungiListener implements ActionListener {

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int j=JOptionPane.showConfirmDialog(null,"<html>Confermi di voler salvare<br>il programma d'irrigazione<br>appena inserito?</html>","Attenzione!",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
					if (j==JOptionPane.OK_OPTION) {
						String np=inputNome.getText();
						int pg;
						if (inputGetto.getText().equals(""))
							pg=0;
						else
							pg=Integer.parseInt(inputGetto.getText());
						boolean rg=false;
						if (onOff.isSelected())
							rg=true;
						else
							rg=false;
						int hInizio=Integer.parseInt(comboH.getSelectedItem().toString());
						int minInizio=Integer.parseInt(comboMin.getSelectedItem().toString());
						LocalTime io=LocalTime.of(hInizio,minInizio);
						int hFine=Integer.parseInt(comboHF.getSelectedItem().toString());
						int minFine=Integer.parseInt(comboMinF.getSelectedItem().toString());
						LocalTime fo=LocalTime.of(hFine,minFine);
						String ti=null;
						if (radioTipo1.isSelected())
							ti=radioTipo1.getText();
						else
							ti=radioTipo2.getText();
						
						if (np.equals("") || pg==0 || io.equals("") || fo.equals("") || ti.equals("")) 
							JOptionPane.showMessageDialog(null,"<html>E' necessario settare<br>tutte le impostazioni<br>del programma</html>","Message",1);
						else {
							ProgrammaIrrigazione programma=new ProgrammaIrrigazione(impianto,np,pg,rg,io,fo,ti);
							System.out.println(programma);
							Tester.addProgramma(programma);
							System.out.println(Tester.getProgrammi());
							
							JOptionPane.showMessageDialog(null,"<html>Il programma d'irrigazione<br>è stato inserito con successo<br><br>Per attivarlo<br>proseguire nella sezione<br>'Gestione terreno' all'opzione<br>irrigazione automatica</html>","Message",1);
							setVisible(false);
							frame.add(new VisualizzaProgrammiImpianto(frame,programma.getImpianto(),programma));
							}
					} else {
						setVisible(false);
						frame.add(new VisualizzaProgrammiImpianto(frame,impianto,null));
					}
				}
			}
			ActionListener aggiungiListener=new AggiungiListener();
			button.addActionListener(aggiungiListener);
		}
		
		bottonePanel.add(button);
		//fine elementi bottonePanel
		
		upBarPanel.setVisible(true);
		nameSectionBarPanel.setVisible(true);
		closePanel.setVisible(true);
		nomeProgrammaPanel.setVisible(true);
		gettoPanel.setVisible(true);
		rotazionePanel.setVisible(true);
		inizioFinePanel.setVisible(true);
		tipoPanel.setVisible(true);
		bottonePanel.setVisible(true);
		
		setLayout(new GridLayout(9,1));
		add(upBarPanel);
		add(nameSectionBarPanel);
		add(closePanel);
		add(nomeProgrammaPanel);
		add(gettoPanel);
		add(rotazionePanel);
		add(inizioFinePanel);
		add(tipoPanel);
		add(bottonePanel);
	}
}
