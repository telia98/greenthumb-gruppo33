package utility;

public class Impianto {

	private String codice;
	private String nome;
	private String via;
	private String civico;
	private String citta;
	
	public Impianto(String c,String n,String v, String civ, String ci) {
		codice=c;
		nome=n;
		via=v;
		civico=civ;
		citta=ci;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCivico() {
		return civico;
	}

	public void setCivico(String civico) {
		this.civico = civico;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	@Override
	public String toString() {
		return "Impianto [codice=" + codice + ", nome=" + nome + ", via=" + via + ", civico=" + civico + ", citta="
				+ citta + "]";
	}
}
