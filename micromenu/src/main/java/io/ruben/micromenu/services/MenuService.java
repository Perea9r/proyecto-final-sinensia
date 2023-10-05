package io.ruben.micromenu.services;

import java.util.List;

import io.ruben.micromenu.models.Menu;

public interface MenuService {
    List<Menu> getMenus();

    Menu actualizarMenu(Menu menu);

    Menu buscarMenu(int idMenu);

    Menu crearMenu(Menu menu);

    void eliminarMenu(int idMenu);
}