package io.ruben.microcliente.services;

import java.util.List;

import io.ruben.microcliente.models.Pedido;

public interface PedidoService {
    void altaPedido(int idMenu, int unidades);

    List<Pedido> pedidos();
}