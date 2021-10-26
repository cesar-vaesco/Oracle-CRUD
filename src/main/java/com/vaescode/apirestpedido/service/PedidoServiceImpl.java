package com.vaescode.apirestpedido.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.vaescode.apirestpedido.entity.Pedido;
import com.vaescode.apirestpedido.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	@Override
	@Transactional
	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	@Override
	@Transactional
	public Pedido update(Pedido usuario) {
		return pedidoRepository.save(usuario);
	}

	@Override
	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}

	@Override
	public Pedido findById(Long id) {
		return pedidoRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		pedidoRepository.deleteById(id);
	}

}
