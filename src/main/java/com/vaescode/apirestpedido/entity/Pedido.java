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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pedidos")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 50)
	@NotNull(message = "El nombre no puede ser nulo")
	@Size(min = 2, message = "El nombre debe de tener más de dos caracteres")
	private String articulo;
	

	@Column(nullable = false, length = 50, unique = true)
	@NotNull(message = "Se requiere descripción del árticulo")
	@Size(min = 2, message = "El descripción debe tener al menos dos caracteres")
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
