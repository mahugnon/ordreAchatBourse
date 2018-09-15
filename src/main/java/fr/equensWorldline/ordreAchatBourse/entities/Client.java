package fr.equensWorldline.ordreAchatBourse.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Client implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClient;
	private String nom;
	private String prenom;
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<Ordre> ordres;
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<CompteBanquaire> compteBanquaires;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	@JsonIgnore
	public Collection<Ordre> getOrdres() {
		return ordres;
	}
@JsonSetter
	public void setOrdres(Collection<Ordre> ordres) {
		this.ordres = ordres;
	}
@JsonIgnore
	public Collection<CompteBanquaire> getCompteBanquaires() {
		return compteBanquaires;
	}
@JsonSetter
	public void setCompteBanquaires(Collection<CompteBanquaire> compteBanquaires) {
		this.compteBanquaires = compteBanquaires;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Long getIdClient() {
		return idClient;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

}
