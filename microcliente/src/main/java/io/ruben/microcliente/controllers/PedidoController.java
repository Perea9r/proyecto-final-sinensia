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

    @GetMapping(value = "/pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pedido> pedidos() {
        return pedidoService.pedidos();
    }

    @PostMapping(value = "/pedido/{idMenu}/{unidades}")
    public void altaPedido(@PathVariable int idMenu, @PathVariable int unidades) {
        pedidoService.altaPedido(idMenu, unidades);
    }
}