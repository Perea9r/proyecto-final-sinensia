package io.ruben.micromenu.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ruben.micromenu.models.Menu;
import io.ruben.micromenu.repositories.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuRepository repository;

    public List<Menu> getMenu() {
        return repository.findAll();
    }

    @Override
    public void actualizarMenu(int idMenu, int stock) {
        repository.findById(idMenu)
                .ifPresent(menu -> {
                    menu.setStock(stock);
                    repository.save(menu);
                });
    }

    @Override
    public Menu buscarMenu(int idMenu) {
        Optional<Menu> menu = repository.findById(idMenu);
        return menu.isPresent() ? menu.get() : null;
    }

    @Override
    public int buscarStockProducto(int idMenu) {
        return repository.getReferenceById(idMenu).getStock();
    }

    @Override
    public double buscarPrecioProducto(int idMenu) {
        return repository.getReferenceById(idMenu).getPrecio();
    }
}
