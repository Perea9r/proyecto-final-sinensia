package io.ruben.micromenu.services;

import java.util.List;

import io.ruben.micromenu.models.Menu;

public interface MenuService {
    List<Menu> getMenu();

    void actualizarMenu(int idMenu, int stock);

    Menu buscarMenu(int idMenu);

    double precioProducto(int idMenu);

    int stockProducto(int idMenu);
}