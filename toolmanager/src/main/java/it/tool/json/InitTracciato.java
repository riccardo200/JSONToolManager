package it.tool.json;

import java.util.Date;

public class InitTracciato {
	
	private String abiMittente;
	private String abiDestinatario;
	private Date dataCaricamento;
	private Date dataContabile;
	private String idRapporto;
	private double saldoIniziale;
	private double saldoFinale;
	private String divisa;
	
	
	public InitTracciato( String abiMittente , String abiDestinatario , Date dataCaricamento , 
	          String idRapporto, double saldoIniziale , double saldoFinale, String divisa) {
		
		this.abiMittente = abiMittente;
		this.abiDestinatario = abiDestinatario;
		this.dataCaricamento = dataCaricamento;
		this.divisa = divisa;
		this.dataContabile = dataContabile;
		this.idRapporto = idRapporto;
		this.saldoIniziale = saldoIniziale;
		this.saldoFinale = saldoFinale;
		//this.note = note;
}


	public String getAbiMittente() {
		return abiMittente;
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


	public Date getDataContabile() {
		return dataContabile;
	}


	public void setDataContabile(Date dataContabile) {
		this.dataContabile = dataContabile;
	}


	public String getIdRapporto() {
		return idRapporto;
	}


	public void setIdRapporto(String idRapporto) {
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


	public String getDivisa() {
		return divisa;
	}


	public void setDivisa(String divisa) {
		this.divisa = divisa;
	}


}
