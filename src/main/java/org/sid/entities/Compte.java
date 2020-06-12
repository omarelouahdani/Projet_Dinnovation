package org.sid.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Compte implements Serializable {
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private int  idCompte;
	private String CIN;
	private String CNE;
	private String gmail;
	private Date dateNaissance;
	private Boolean status ;
	
	public Compte(String cIN, String cNE, String gmail, Date dateNaissance) {
		super();
		CIN = cIN;
		CNE = cNE;
		this.gmail = gmail;
		status = false;
		this.dateNaissance = dateNaissance;
	
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public int getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	public String getCNE() {
		return CNE;
	}
	public void setCNE(String cNE) {
		CNE = cNE;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	

}
