package com.gft.casadeeventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.casadeeventos.model.Compra;
import com.gft.casadeeventos.repository.compras;
import com.gft.casadeeventos.services.exceptions.CompraNaoEncontradaException;

@Service
public class CompraService {

	@Autowired
	private compras comps;
	
	public List<Compra> buscarHistorico() {
		return comps.findAll();
	}
	
	public Compra buscarEspecifico(Long id) {
		Compra comp = comps.findById(id).get();

			if (comp == null) {
				throw new CompraNaoEncontradaException("A compra não pode ser encontrado!");
			}
			return comp;
	}
}
