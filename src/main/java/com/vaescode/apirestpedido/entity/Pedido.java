package com.vaescode.apirestpedido.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pedidos")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String articulo;
	
	
	private String descripcion;
	private Double costo;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date pedidoGenerado;
	
	@PrePersist
	public void prePresist() {
		pedidoGenerado = new Date();
	} 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public Date getPedidoGenerado() {
		return pedidoGenerado;
	}

	public void setPedidoGenerado(Date pedidoGenerado) {
		this.pedidoGenerado = pedidoGenerado;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", articulo=" + articulo + ", descripcion=" + descripcion + ", costo=" + costo
				+ ", pedidoGenerado=" + pedidoGenerado + "]";
	}
	
	

}
