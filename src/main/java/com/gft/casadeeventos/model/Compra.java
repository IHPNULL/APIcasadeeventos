package com.gft.casadeeventos.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;


@Entity
public class Compra {
	
	public Compra(Long iDevento, String evento, double total, Date datacompra, int qtd) {
		super();
		IDevento = iDevento;
		this.evento = evento;
		this.qtd = qtd;
		this.total = total;
		this.datacompra = datacompra;
	}
	
	public Compra() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long IDevento;

	private String evento;
	
	private int qtd;
	
	private double total;
	
	private Date datacompra;

	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIDevento() {
		return IDevento;
	}
	public void setIDevento(Long iDevento) {
		IDevento = iDevento;
	}
	
	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getDatacompra() {
		return datacompra;
	}

	public void setDatacompra(Date datacompra) {
		this.datacompra = datacompra;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Compra other = (Compra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}