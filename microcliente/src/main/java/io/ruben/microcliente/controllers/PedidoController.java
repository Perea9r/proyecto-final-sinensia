package io.ruben.microcliente.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ruben.microcliente.models.Pedido;
import io.ruben.microcliente.repositories.PedidoRepository;
import io.ruben.microcliente.services.PedidoService;

@RestController
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @Autowired
    PedidoRepository pedidoRepository;

    /**
     * La función "pedidos" devuelve una lista de objetos Pedido.
     * 
     * @return Se devuelve una lista de objetos Pedido.
     */
    @GetMapping(value = "/pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pedido> pedidos() {
        return pedidoService.pedidos();
    }

    /**
     * Esta función Java maneja la creación de un nuevo pedido llamando al método
     * `altaPedido` desde la
     * clase `pedidoService` con el ID del menú y la cantidad proporcionados.
     * 
     * @param idMenu   La identificación del menú para el cual se realiza el pedido.
     * @param unidades El parámetro "unidades" representa el número de unidades del
     *                 elemento del menú que
     *                 el usuario desea pedir.
     */
    @PostMapping(value = "/pedido/{idMenu}/{unidades}")
    public void altaPedido(@PathVariable int idMenu, @PathVariable int unidades) {
        pedidoService.altaPedido(idMenu, unidades);
    }

    /**
     * La función "obtenerTotalPedidosPorFecha" recupera el monto total de pedidos
     * para una fecha
     * determinada y lo devuelve como una ResponseEntity.
     * 
     * @param fecha El parámetro "fecha" es un objeto LocalDate que representa una
     *              fecha específica. Se
     *              utiliza para recuperar la cantidad total de pedidos para esa
     *              fecha de la base de datos.
     * @return El método devuelve un objeto ResponseEntity con un valor Doble.
     */
    @GetMapping("/total/{fecha}")
    public ResponseEntity<Double> obtenerTotalPedidosPorFecha(
            @PathVariable("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        Double total = pedidoRepository.obtenerTotalPedidosPorFecha(fecha);
        if (total == null) {
            throw new FechaNoEncontradaException("La fecha " + fecha + " no se encontró en la base de datos");
        } else {
            return ResponseEntity.ok(total);
        }
    }

    /**
     * La clase "FechaNoEncontradaException" es una clase de excepción personalizada
     * en Java que extiende
     * la clase RuntimeException.
     */
    public class FechaNoEncontradaException extends RuntimeException {
        public FechaNoEncontradaException(String message) {
            super(message);
        }
    }
}