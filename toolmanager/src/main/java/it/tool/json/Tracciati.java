package it.tool.json;

import java.util.Date;

public class Tracciati {
	
	//private String titolo;
	private String abiMittente;
	private String abiDestinatario;
	private Date dataCaricamento;
	private Date dataValuta;
	private String idRapporto;
	private String note;
	private double saldoIniziale;
	private double saldoFinale;
	
	public Tracciati( String abiMittente , String abiDestinatario , Date dataCaricamento , 
			  String idRapporto, double saldoIniziale , double saldoFinale) {
		
		//this.titolo = titolo;
		this.abiMittente = abiMittente;
		this.abiDestinatario = abiDestinatario;
		this.dataCaricamento = dataCaricamento;
		//this.dataValuta = dataValuta;
		this.idRapporto = idRapporto;
		this.saldoIniziale = saldoIniziale;
		this.saldoFinale = saldoFinale;
		//this.note = note;
	}
	

	public String getAbiMittente() {
		return this.abiMittente;
	}

	public void setAbiMittente(String abiMittente) {
		this.abiMittente = abiMittente;
	}

	public String getAbiDestinatario() {
		return abiDestinatario;
	}

	public void setAbiDestinatario(String abiDestinatario) {
		this.abiDestinatario = abiDestinatario;
	}

	public Date getDataCaricamento() {
		return dataCaricamento;
	}

	public void setDataCaricamento(Date dataCaricamento) {
		this.dataCaricamento = dataCaricamento;
	}

	public Date getDataValuta() {
		return dataValuta;
	}

	public void setDataValuta(Date dataValuta) {
		this.dataValuta = dataValuta;
	}

	public String getContoReciproco() {
		return idRapporto;
	}

	public void setContoReciproco(String idRapporto) {
		this.idRapporto = idRapporto;
	}

	public double getSaldoIniziale() {
		return saldoIniziale;
	}

	public void setSaldoIniziale(double saldoIniziale) {
		this.saldoIniziale = saldoIniziale;
	}

	public double getSaldoFinale() {
		return saldoFinale;
	}

	public void setSaldoFinale(double saldoFinale) {
		this.saldoFinale = saldoFinale;
	}
	
	public String getNote() {
		
		return note;
	}
	
	public void setNote(String note) {
		
		this.note = note;
	}

	@Override
	public String toString() {
		return "Tracciati [abiMittente=" + abiMittente + ", abiDestinatario=" + abiDestinatario + ", dataCaricamento="
				+ dataCaricamento + ", dataValuta=" + dataValuta + ", contoReciproco=" + idRapporto + ", note="
				+ note + ", saldoIniziale=" + saldoIniziale + ", saldoFinale=" + saldoFinale + "]";
	}	
}
