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

    @GetMapping(value = "/menus", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Menu>> platos() {
        List<Menu> platos = service.getMenu();
        return new ResponseEntity<>(platos, HttpStatus.OK);
    }

    @GetMapping("/menu/{idMenu}")
    public ResponseEntity<Menu> buscarMenu(@PathVariable int idMenu) {
        Menu plato = service.buscarMenu(idMenu);
        if (plato != null) {
            return new ResponseEntity<>(plato, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/menu/{idMenu}/{stock}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Menu>> actualizarMenu(@PathVariable int idMenu, @PathVariable int stock) {
        service.actualizarMenu(idMenu, stock);
        return new ResponseEntity<>(service.getMenu(), HttpStatus.OK);
    }

    @GetMapping(value = "/precio/{idMenu}", produces = MediaType.APPLICATION_JSON_VALUE)
    public double buscarPrecioProducto(@PathVariable int idMenu) {
        return service.buscarPrecioProducto(idMenu);
    }

    @GetMapping(value = "/stock/{idMenu}", produces = MediaType.APPLICATION_JSON_VALUE)
    public int buscarStockProducto(@PathVariable int idMenu) {
        return service.buscarStockProducto(idMenu);
    }
}
