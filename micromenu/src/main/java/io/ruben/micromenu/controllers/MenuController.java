package io.ruben.micromenu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.ruben.micromenu.models.Menu;
import io.ruben.micromenu.services.MenuService;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping(value = "/menus", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Menu> getPlatos() {
        return menuService.getMenus();
    }

    @PostMapping(value = "/menu", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Menu addPlato(@RequestBody Menu menu) {
        return menuService.crearMenu(menu);
    }

    @PutMapping(value = "/menu", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Menu>> updatePlato(@RequestBody Menu menu) {
        menuService.actualizarMenu(menu);
        return new ResponseEntity<>(menuService.getMenus(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/menu/{idMenu}")
    public ResponseEntity<List<Menu>> deletePlato(@PathVariable int idMenu) {
        List<Menu> menus = menuService.eliminarMenu(idMenu);
        return new ResponseEntity<>(menus, HttpStatus.OK);
    }

    @GetMapping(value = "/menu/{idMenu}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Menu buscarPlato(@PathVariable int idMenu) {
        return menuService.buscarMenu(idMenu);
    }
}
