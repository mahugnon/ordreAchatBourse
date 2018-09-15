package fr.equensWorldline.ordreAchatBourse.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
@Entity
public class CompteBanquaire implements Serializable{
	@Id 
private Long numeroCompte;
private double solde;
@ManyToOne
@JoinColumn(name="CODE_CLIENT")
private Client client;
public CompteBanquaire() {
	super();
	// TODO Auto-generated constructor stub
}
public CompteBanquaire(Long numeroCompte, double solde) {
	super();
	this.numeroCompte = numeroCompte;
	this.solde = solde;
}
public Long getNumeroCompte() {
	return numeroCompte;
}
public void setNumeroCompte(Long numeroCompte) {
	this.numeroCompte = numeroCompte;
}
public double getSolde() {
	return solde;
}
public void setSolde(double solde) {
	this.solde = solde;
}
public Client getClient() {
	return client;
}
public void setClient(Client client) {
	this.client = client;
}

@Override
public String toString() {
	return "CompteBanquaire [numeroCompte=" + numeroCompte + ", solde=" + solde + "]";
}

}
