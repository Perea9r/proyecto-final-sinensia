package io.ruben.microcliente.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
    private static final String ERROR_ELIMINANDO_MENU = "Error eliminando el menú";

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
     * La función `altaPedido` crea un nuevo pedido comprobando la disponibilidad de
     * stock, calculando el
     * precio total, guardando el pedido en el repositorio, actualizando el stock y
     * eliminando el menú si el stock se agota.
     * 
     * @param idMenu   La identificación del menú para el cual se realiza el pedido.
     * @param unidades El parámetro "unidades" representa el número de unidades de
     *                 un elemento del menú que
     *                 el usuario quiere pedir.
     */
    @Override
    public void altaPedido(int idMenu, int unidades) {
        Integer stockMenu = restTemplate.getForObject(url + "stock/" + idMenu, Integer.class);
        Double precioMenu = restTemplate.getForObject(url + "precio/" + idMenu, Double.class);

        if (stockMenu != null && precioMenu != null && stockMenu >= unidades) {
            double totalPedido = precioMenu * unidades;
            pedidoRepository.save(new Pedido(0, idMenu, unidades, totalPedido, LocalDate.now()));
            restTemplate.put(url + "menu/" + idMenu + "/" + (stockMenu - unidades), Menu.class);
            if (stockMenu == unidades) {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("http://localhost:8081/menu/" + idMenu))
                        .DELETE()
                        .build();
                try {
                    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    if (response.statusCode() != 200) {
                        throw new NullPointerException(ERROR_ELIMINANDO_MENU);
                    }
                } catch (IOException e) {
                    throw new NullPointerException(ERROR_ELIMINANDO_MENU);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new NullPointerException(ERROR_ELIMINANDO_MENU);
                }
            }
        }
    }

    /**
     * La función devuelve una lista de menús que se han consumido según la
     * disponibilidad de existencias
     * dentro de un rango de fechas y un ID de menú específicos.
     * 
     * @param fechaInicio La fecha de inicio del periodo del que se quieren obtener
     *                    los menús consumidos.
     * @param fechaFin    La fecha de finalización del periodo del que se quieren
     *                    obtener los menús
     *                    consumidos.
     * @param menuId      El ID del menú del que deseas obtener los menús
     *                    consumidos.
     * @return Se devuelve una lista de objetos de menú.
     */
}