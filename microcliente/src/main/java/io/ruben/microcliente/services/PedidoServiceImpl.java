package io.ruben.microcliente.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.ruben.microcliente.models.Menu;
import io.ruben.microcliente.models.Pedido;
import io.ruben.microcliente.repositories.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PedidoRepository pedidoRepository;

    private String url = "http://localhost:8080/";

    @Override
    public List<Pedido> pedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public void altaPedido(int idMenu, int unidades) {
        Integer stockMenu = restTemplate.getForObject(url + "stock/" + idMenu, Integer.class);
        Double precioMenu = restTemplate.getForObject(url + "precio/" + idMenu, Double.class);

        if (stockMenu != null && precioMenu != null && stockMenu > unidades
                && (restTemplate.getForObject(url + "precio/" + idMenu, Double.class) != null)) {

            double totalPedido = precioMenu
                    * unidades;

            pedidoRepository.save(new Pedido(0, idMenu, unidades, totalPedido, LocalDate.now()));

            restTemplate.put(url + "menu/" + idMenu + "/" + (stockMenu - unidades),
                    Menu.class);
        }
    }
}