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
    private MenuRepository menuRepository;

    @Override
    public List<Menu> getMenus() {
        return menuRepository.findAll();
    }

    @Override
    public Menu actualizarMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu buscarMenu(int idMenu) {
        Optional<Menu> menu = menuRepository.findById(idMenu);
        return menu.isPresent() ? menu.get() : null;
    }

    @Override
    public Menu crearMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public List<Menu> eliminarMenu(int idMenu) {
        menuRepository.deleteById(idMenu);
        return menuRepository.findAll();
    }
}
