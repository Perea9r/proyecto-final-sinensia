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

    /**
     * La función "pedidos()" devuelve una lista de todos los objetos Pedido del
     * pedidoRepository.
     * 
     * @return El método devuelve una Lista de objetos Pedido.
     */
    @Override
    public List<Pedido> pedidos() {
        return pedidoRepository.findAll();
    }

    /**
     * La función `altaPedido` comprueba el stock y el precio de un artículo del
     * menú, crea un nuevo
     * pedido si hay suficiente stock y actualiza la cantidad de stock.
     * 
     * @param idMenu   La identificación del menú para el cual se realiza el pedido.
     * @param unidades El parámetro "unidades" representa el número de unidades de
     *                 un elemento del menú
     *                 que el usuario quiere pedir.
     */
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