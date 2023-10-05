package io.ruben.microcliente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ruben.microcliente.models.Pedido;
import io.ruben.microcliente.services.PedidoService;

@RestController
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

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
}