package com.vaescode.apirestpedido.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vaescode.apirestpedido.entity.Pedido;
import com.vaescode.apirestpedido.service.PedidoService;

@RestController
@RequestMapping("/api")
public class PedidoController {

	private static final Logger log = LoggerFactory.getLogger(PedidoController.class);

	@Autowired
	PedidoService pedidoService;

	@PostMapping(path = "/crear/pedido")
	public ResponseEntity<?> crearPedido(@RequestBody Pedido pedido) {

		try {
			Pedido nuevoPedido = pedidoService.save(pedido);
			log.info("Creando pedido con data {}", pedido);
			return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Error al generar el registro:   " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = "/pedidos")
	public ResponseEntity<?> listarPedidos() {
		log.info("Listando todos los pedidos");

		List<Pedido> pedidos = pedidoService.findAll();
		return new ResponseEntity<>(pedidos, pedidos.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@GetMapping(path = "/pedido/{id}")
	public ResponseEntity<?> listarPedido(@PathVariable("id") Long pedidoId) {
		// Optional<Usuario> opt = usuarioRepository.findById(id);
		// Optional<Pedido> pedidoDB = Optional.of(pedidoService.findById(pedidoId));
		Pedido pedidoActual = pedidoService.findById(pedidoId);

		if (pedidoActual == null) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} else {
			log.info("Obteniendo inspeccion con id {}", pedidoId);
			return new ResponseEntity<>(pedidoActual, HttpStatus.OK);

		}

	}

	@DeleteMapping(path = "/eliminar/pedido/{id}")
	public ResponseEntity<?> eliminarPedido(@PathVariable("id") Long pedidoId) {

		Optional<Pedido> pedidoDB = Optional.ofNullable(pedidoService.findById(pedidoId));

		log.info("pedidoDB: " + pedidoDB.toString());
		try {
			if (pedidoDB.isPresent()) {
				pedidoService.delete(pedidoId);
				return new ResponseEntity<>("El registro con el id '" + pedidoId + "' ha sido eliminado",
						HttpStatus.OK);
			} else if (pedidoDB.isEmpty()) {
				log.info("No existe producto con el id seleccionado");
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		return null;

	}

	@PutMapping(path = "/actualizar/pedido/{id}")
	public ResponseEntity<?> actualizarPedido(@RequestBody Pedido pedido, @PathVariable("id") Long pedidoId) {

		Pedido pedidoActual = pedidoService.findById(pedidoId);
		Pedido pedidoActualizado = null;

		if (pedidoActual == null) {
			return new ResponseEntity<>("El registro con el id " + pedidoId + " no existe", HttpStatus.NOT_FOUND);
		}

		try {

			pedidoActual.setArticulo(pedido.getArticulo());
			pedidoActual.setDescripcion(pedido.getDescripcion());
			pedidoActual.setCosto(pedido.getCosto());

			pedidoActualizado = pedidoService.save(pedidoActual);

			return new ResponseEntity<>(pedidoActualizado, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

}
