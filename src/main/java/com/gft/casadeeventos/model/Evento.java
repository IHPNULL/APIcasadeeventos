package com.gft.casadeeventos.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@SequenceGenerator(name = "evento_seq", sequenceName = "")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@NotNull(message = "Insira o nome do Evento")
	@NotEmpty(message = "Insira o nome do Evento")
	private String Nomeevento;

	private String descr;

	private String talento;

	@NotNull(message = "Insira o organizador do Evento")
	@NotEmpty(message = "Insira o organizador do Evento")
	private String organizador;

	@ManyToOne
	@JoinColumn
	private Casa local;

	private double preco = 0;

	@NotNull(message = "insira o limite de ingressos")
	private Integer ingressos;

	private int ingressosd;

	@NotNull(message = "Insira a data no formato: dia/mes/ano")
	@DateTimeFormat(pattern = "dd/MM/yyy")
	@Temporal(TemporalType.DATE)
	private Date data;

	private boolean grat = true;

	public String getNomeevento() {
		return Nomeevento;
	}

	public void setNomeevento(String nomeevento) {
		Nomeevento = nomeevento;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return Nomeevento;
	}

	public void setNome(String nome) {
		Nomeevento = nome;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getTalento() {
		return talento;
	}

	public void setTalento(String talento) {
		this.talento = talento;
	}

	public String getOrganizador() {
		return organizador;
	}

	public void setOrganizador(String organizador) {
		this.organizador = organizador;
	}

	public Casa getLocal() {
		return local;
	}

	public void setLocal(@NotNull(message = "insira o local") Casa local) {
		this.local = local;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Integer getIngressos() {
		return ingressos;
	}

	public void setIngressos(Integer ingressos) {
		this.ingressos = ingressos;
	}

	public int getIngressosd() {
		return ingressosd;
	}

	public void setIngressosd(int ingressosd) {
		this.ingressosd = ingressosd;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean isGrat() {
		return grat;
	}

	public void setGrat(boolean grat) {
		this.grat = grat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}
}
