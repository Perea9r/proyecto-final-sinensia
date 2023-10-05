package io.ruben.micromenu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/menus")
    public List<Menu> getPlatos() {
        return menuService.getMenus();
    }

    @PostMapping("/menu")
    public Menu addPlato(@RequestBody Menu menu) {
        return menuService.crearMenu(menu);
    }

    @PutMapping("/menu/{id}")
    public Menu updatePlato(@PathVariable int idMenu, @RequestBody Menu menu) {
        menu.setIdMenu(idMenu);
        return menuService.actualizarMenu(menu);
    }

    @DeleteMapping("/menu/{id}")
    public void deletePlato(@PathVariable int idMenu) {
        menuService.eliminarMenu(idMenu);
    }

    @GetMapping("/menu/{id}")
    public Menu buscarPlato(@PathVariable int idMenu) {
        return menuService.buscarMenu(idMenu);
    }
}
