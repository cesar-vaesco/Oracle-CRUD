package com.vaescode.apirestpedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaescode.apirestpedido.entity.Pedido;

public interface PedidoRepository  extends JpaRepository<Pedido, Long>{

}
