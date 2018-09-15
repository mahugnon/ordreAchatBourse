package fr.equensWorldline.ordreAchatBourse.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity

public class Ordre implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOrdre;
	private Integer quantité;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "CODE_CLIENT")
	private Client client;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "CODE_INSTRUMENT")
	private Instrument instrument;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false, mappedBy = "ordre")
	private Message message;
	private String typeOrdre;
	public Ordre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdOrdre() {
		return idOrdre;
	}

	public void setIdOrdre(Long idOrdre) {
		this.idOrdre = idOrdre;
	}

	public Integer getQuantité() {
		return quantité;
	}

	public void setQuantité(Integer quantité) {
		this.quantité = quantité;
	}
@JsonIgnore
	public Client getClient() {
		return client;
	}
@JsonSetter
	public void setClient(Client client) {
		this.client = client;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
@JsonIgnore
	public Message getMessage() {
		return message;
	}
@JsonSetter
	public void setMessage(Message message) {
		this.message = message;
	}

	public String getTypeOrdre() {
		return typeOrdre;
	}

	public void setTypeOrdre(String typeOrdre) {
		this.typeOrdre = typeOrdre;
	}

	@Override
	public String toString() {
		return "Ordre [idOrdre=" + idOrdre + ", quantité=" + quantité + ", client=" + client + ", instrument="
				+ instrument + ", typeOrdre=" + typeOrdre + "]";
	}

	

}
