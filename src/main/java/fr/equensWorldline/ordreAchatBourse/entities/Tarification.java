package fr.equensWorldline.ordreAchatBourse.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
@Entity
public class Tarification implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private Boolean etat;
private String type;
private double minCond;
private double maxCond;
private double valeurTarif;
private Date dateCreation;
public Tarification() {
	super();
}
public Tarification(Boolean etat, double minCond, double maxCond, double valeurTarif) {
	super();
	this.etat = etat;
	this.minCond = minCond;
	this.maxCond = maxCond;
	this.valeurTarif = valeurTarif;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Boolean getEtat() {
	return etat;
}
public void setEtat(Boolean etat) {
	this.etat = etat;
}
public double getMinCond() {
	return minCond;
}
public void setMinCond(double minCond) {
	this.minCond = minCond;
}
public double getMaxCond() {
	return maxCond;
}
public void setMaxCond(double maxCond) {
	this.maxCond = maxCond;
}
public double getValeurTarif() {
	return valeurTarif;
}
public void setValeurTarif(double valeurTarif) {
	this.valeurTarif = valeurTarif;
}
public double tarifé(double montantBrut) {
	return montantBrut;
}

public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public Date getDateCreation() {
	return dateCreation;
}
public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}
@Override
public String toString() {
	return "Tarification [id=" + id + ", etat=" + etat + ", minCond=" + minCond + ", maxCond=" + maxCond
			+ ", valeurTarif=" + valeurTarif + ", dateCreation=" + dateCreation + "]";
}


}
