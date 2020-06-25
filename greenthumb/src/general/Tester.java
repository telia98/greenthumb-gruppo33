package general;

import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JFrame;

import utility.Impianto;
import utility.ProgrammaIrrigazione;

public class Tester {

	private static ArrayList<ProgrammaIrrigazione> listaProgrammi;
	private static ArrayList<Impianto> listaImpianti;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//creazione impianti
		Impianto impianto1=new Impianto("XCR46FR5","impianto giardino","Via San Giacomo","23","Napoli");
		Impianto impianto2=new Impianto("XBV56GV1","impianto campagna","Via Appia","103","Caserta");
		
		//creazione programmi
		ProgrammaIrrigazione programmaA=new ProgrammaIrrigazione(impianto1,"programma A",10,false,LocalTime.of(6,00),LocalTime.of(8,00),"a getto continuo");
		ProgrammaIrrigazione programmaB=new ProgrammaIrrigazione(impianto1,"programma B",10,true,LocalTime.of(5,00),LocalTime.of(7,00),"a getto continuo");
		ProgrammaIrrigazione programmaC=new ProgrammaIrrigazione(impianto2,"programma C",6,true,LocalTime.of(9,00),LocalTime.of(11,00),"a intervalli regolari");
		
		//creazione lista programmi
		listaProgrammi=new ArrayList<ProgrammaIrrigazione>();
		listaProgrammi.add(programmaA);
		listaProgrammi.add(programmaB);
		listaProgrammi.add(programmaC);
		
		System.out.println(listaProgrammi);
		
		//creazione lista impianti
		listaImpianti=new ArrayList<Impianto>();
		listaImpianti.add(impianto1);
		listaImpianti.add(impianto2);
		
		System.out.println(listaImpianti);
		JFrame frame=new JFrame(); //per far partire la simulazione del dispositivo scelto
		frame.add(new Homepage(frame));
		frame.setLocation(550,100);
		frame.setSize(340,580);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	}

	public static ProgrammaIrrigazione getProgramma(String programma) {
		
		for(ProgrammaIrrigazione p: listaProgrammi) {
			String nome=p.getNome();
			if (nome.equals(programma))
				return p;
		}
		
		return null;
	}
	
	public static Impianto getImpianto(String impianto) {
		
		for(Impianto p: listaImpianti) {
			String nome=p.getNome();
			if (nome.equals(impianto))
				return p;
		}
		
		return null;
	}
	
	public static ArrayList<ProgrammaIrrigazione> getProgrammi(){
		return listaProgrammi;
	}
	
	public static ArrayList<Impianto> getImpianti(){
		return listaImpianti;
	}
	
	public static void addProgramma(ProgrammaIrrigazione programma) {
		listaProgrammi.add(programma);
	}
	
	public static void addImpianto(Impianto impianto) {
		listaImpianti.add(impianto);
	}
}
