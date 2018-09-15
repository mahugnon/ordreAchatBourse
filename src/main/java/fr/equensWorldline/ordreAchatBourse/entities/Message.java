package fr.equensWorldline.ordreAchatBourse.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
public class Message implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
private Long idMessage;
private double montantNet;
private double montantBrut;
private Long codeISBN;
private Long codeClient;
private Long numCompte;
private String msg;
@OneToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CODE_ORDRE")
private Ordre ordre;
public Message() {
	super();
}
public Message(double montantNet, double montantBrut) {
	super();
	this.montantNet = montantNet;
	this.montantBrut = montantBrut;
}
public Long getIdMessage() {
	return idMessage;
}
public void setIdMessage(Long idMessage) {
	this.idMessage = idMessage;
}
public double getMontantNet() {
	return montantNet;
}
public void setMontantNet(double montantNet) {
	this.montantNet = montantNet;
}
public double getMontantBrut() {
	return montantBrut;
}
public void setMontantBrut(double montantBrut) {
	this.montantBrut = montantBrut;
}
@JsonIgnore
public Ordre getOrdre() {
	return ordre;
}
@JsonSetter
public void setOrdre(Ordre ordre) {
	this.ordre = ordre;
}

public Long getCodeISBN() {
	return codeISBN;
}
public void setCodeISBN(Long codeISBN) {
	this.codeISBN = codeISBN;
}
public Long getNumCompte() {
	return numCompte;
}
public void setNumCompte(Long numCompte) {
	this.numCompte = numCompte;
}

public Long getCodeClient() {
	return codeClient;
}
public void setCodeClient(Long codeClient) {
	this.codeClient = codeClient;
}

public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
@Override
public String toString() {
	return "Message [idMessage=" + idMessage + ", montantNet=" + montantNet + ", montantBrut=" + montantBrut
			+ ", codeISBN=" + codeISBN + ", codeClient=" + codeClient + ", numCompte=" + numCompte + ", msg=" + msg
			+ "]";
}


}
