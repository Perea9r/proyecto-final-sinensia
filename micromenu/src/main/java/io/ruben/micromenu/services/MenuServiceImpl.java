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

    /**
     * La función `actualizarMenu` actualiza el stock de un elemento del menú con el
     * id dado.
     * 
     * @param idMenu La identificación del menú que necesita ser actualizado.
     * @param stock  El parámetro stock representa el nuevo valor de stock que se
     *               actualizará para el
     *               elemento del menú con la identificación especificada.
     */
    @Override
    public void actualizarMenu(int idMenu, int stock) {
        Optional<Menu> optionalMenu = repository.findById(idMenu);
        if (optionalMenu.isPresent()) {
            Menu menu = optionalMenu.get();
            menu.setStock(stock);
            repository.save(menu);
        }
    }

    /**
     * La función busca un menú con una ID determinada en un repositorio y lo
     * devuelve si lo encuentra; de
     * lo contrario, devuelve nulo.
     * 
     * @param idMenu La identificación del menú que desea buscar.
     * @return El método devuelve un objeto Menú.
     */
    @Override
    public Menu buscarMenu(int idMenu) {
        Optional<Menu> menu = repository.findById(idMenu);
        return menu.isPresent() ? menu.get() : null;
    }

    /**
     * La función `stockProducto` devuelve el stock de un producto en función de su
     * ID de menú.
     * 
     * @param idMenu El parámetro `idMenu` es un número entero que representa el ID
     *               de un elemento del
     *               menú.
     * @return El método devuelve un valor entero, que es el stock de un producto
     *         con el ID de menú
     *         determinado.
     */
    @Override
    public int stockProducto(int idMenu) {
        return repository.getReferenceById(idMenu).getStock();
    }

    /**
     * La función `precioProducto` devuelve el precio de un producto según su
     * ID de menú.
     * 
     * @param idMenu El parámetro `idMenu` es un número entero que representa el ID
     *               de un elemento del
     *               menú.
     * @return El método devuelve un valor doble, que es el precio de un producto.
     */
    @Override
    public double precioProducto(int idMenu) {
        return repository.getReferenceById(idMenu).getPrecio();
    }
}
