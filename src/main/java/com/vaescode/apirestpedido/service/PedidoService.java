package com.vaescode.apirestpedido.service;

import java.util.List;


import com.vaescode.apirestpedido.entity.Pedido;

public interface PedidoService {

	public Pedido save(Pedido pedido);

	public Pedido update(Pedido pedido);

	public List<Pedido> findAll();

	public Pedido findById(Long id);
	
	public void delete(Long id);

}
