package utility;

import java.time.LocalTime;

public class ProgrammaIrrigazione {

	private Impianto impianto;
	private String nome;
	private int potenzaGetto;
	private boolean rotazioneGetto;
	private LocalTime oraInizio;
	private LocalTime oraFine;
	private String tipologia;
	
	public ProgrammaIrrigazione(Impianto impianto,String nome, int potenzaGetto, boolean rotazioneGetto, LocalTime oraInizio, LocalTime oraFine, String tipologia) {
		super();
		this.impianto = impianto;
		this.nome = nome;
		this.potenzaGetto = potenzaGetto;
		this.rotazioneGetto = rotazioneGetto;
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
		this.tipologia = tipologia;
	}

	public int getPotenzaGetto() {
		return potenzaGetto;
	}

	public void setPotenzaGetto(int potenzaGetto) {
		this.potenzaGetto = potenzaGetto;
	}

	public boolean isRotazioneGetto() {
		return rotazioneGetto;
	}

	public void setRotazioneGetto(boolean rotazioneGetto) {
		this.rotazioneGetto = rotazioneGetto;
	}

	public LocalTime getOraInizio() {
		return oraInizio;
	}

	public void setOraInizio(LocalTime oraInizio) {
		this.oraInizio = oraInizio;
	}

	public LocalTime getOraFine() {
		return oraFine;
	}

	public void setOraFine(LocalTime oraFine) {
		this.oraFine = oraFine;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	
	public Impianto getImpianto() {
		return impianto;
	}

	public void setImpianto(Impianto impianto) {
		this.impianto = impianto;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "ProgrammaIrrigazione [impianto=" + impianto + ", nome=" + nome + ", potenzaGetto=" + potenzaGetto + ", rotazioneGetto=" + rotazioneGetto
				+ ", oraInizio=" + oraInizio + ", oraFine=" + oraFine + ", tipologia=" + tipologia + "]";
	}
}
