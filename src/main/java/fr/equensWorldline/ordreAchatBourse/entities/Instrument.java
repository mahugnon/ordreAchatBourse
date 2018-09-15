package fr.equensWorldline.ordreAchatBourse.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
public class Instrument implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeInstrument;
	private double prix;
	@OneToMany(mappedBy="instrument",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Collection<Ordre> ordres;
	public Instrument() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getCodeInstrument() {
		return codeInstrument;
	}
	public void setCodeInstrument(Long codeInstrument) {
		this.codeInstrument = codeInstrument;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	@JsonIgnore
	public Collection<Ordre> getOrdres() {
		return ordres;
	}
	@JsonSetter
	public void setOrdres(Collection<Ordre> ordres) {
		this.ordres = ordres;
	}
	public Instrument(double prix) {
		super();
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "Instrument [codeInstrument=" + codeInstrument + ", prix=" + prix + "]";
	}


}
