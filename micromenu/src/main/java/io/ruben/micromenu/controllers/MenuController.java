package io.ruben.micromenu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ruben.micromenu.models.Menu;
import io.ruben.micromenu.services.MenuService;

@RestController
public class MenuController {
    @Autowired
    MenuService service;

    /**
     * Esta función Java devuelve una lista de menús como respuesta JSON.
     * 
     * @return Se devuelve un objeto ResponseEntity que contiene una lista de
     *         objetos Menú.
     */
    @GetMapping(value = "/menus", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Menu>> platos() {
        List<Menu> platos = service.getMenu();
        return new ResponseEntity<>(platos, HttpStatus.OK);
    }

    /**
     * Esta función de Java recupera un elemento de menú según su ID y lo devuelve
     * como ResponseEntity, con
     * el estado OK si se encuentra o NOT_FOUND si no se encuentra.
     * 
     * @param idMenu La identificación del menú que debe buscarse.
     * @return El método devuelve un objeto ResponseEntity. Si se encuentra el
     *         objeto Menú, devolverá un
     *         objeto ResponseEntity con el objeto Menú y el estado HttpStatus.OK.
     *         Si no se encuentra el objeto
     *         Menú, devolverá un objeto ResponseEntity con estado
     *         HttpStatus.NOT_FOUND.
     */
    @GetMapping("/menu/{idMenu}")
    public ResponseEntity<Menu> buscarMenu(@PathVariable int idMenu) {
        Menu plato = service.buscarMenu(idMenu);
        if (plato != null) {
            return new ResponseEntity<>(plato, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Esta función de Java actualiza el stock de un elemento del menú y devuelve
     * una lista de todos los
     * elementos del menú.
     * 
     * @param idMenu La identificación del elemento del menú que debe actualizarse.
     * @param stock  El parámetro "stock" es un valor entero que representa la nueva
     *               cantidad de stock para
     *               un elemento del menú.
     * @return El método devuelve un objeto ResponseEntity que contiene una lista de
     *         objetos de menú y un
     *         código HttpStatus de OK.
     */
    @PutMapping(value = "/menu/{idMenu}/{stock}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Menu>> actualizarMenu(@PathVariable int idMenu, @PathVariable int stock) {
        service.actualizarMenu(idMenu, stock);
        return new ResponseEntity<>(service.getMenu(), HttpStatus.OK);
    }

    /**
     * Esta función de Java recupera el precio de un producto en función de su ID de
     * menú.
     * 
     * @param idMenu El parámetro idMenu es un número entero que representa el ID de
     *               un elemento del menú.
     * @return El método devuelve un valor doble, que representa el precio de un
     *         producto.
     */
    @GetMapping(value = "/precio/{idMenu}", produces = MediaType.APPLICATION_JSON_VALUE)
    public double precioProducto(@PathVariable int idMenu) {
        return service.precioProducto(idMenu);
    }

    /**
     * Esta función de Java recupera la cantidad de existencias de un producto en
     * función de su ID de menú.
     * 
     * @param idMenu El parámetro idMenu es un número entero que representa el ID de
     *               un elemento del menú.
     * @return Un valor entero que representa el stock de un producto con el idMenu
     *         dado.
     */
    @GetMapping(value = "/stock/{idMenu}", produces = MediaType.APPLICATION_JSON_VALUE)
    public int stockProducto(@PathVariable int idMenu) {
        return service.stockProducto(idMenu);
    }
}
