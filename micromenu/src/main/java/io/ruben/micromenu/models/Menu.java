package io.ruben.micromenu.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    private int idMenu;
    private String plato;
    private double precioUnitario;
    private int stock;

    public Menu() {
    }

    public Menu(int idMenu, String plato, double precioUnitario, int stock) {
        super();
        this.idMenu = idMenu;
        this.plato = plato;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getPlato() {
        return plato;
    }

    public void setPlato(String plato) {
        this.plato = plato;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "MenuRepository [idMenu=" + idMenu + ", plato=" + plato + ", precioUnitario=" + precioUnitario
                + ", stock=" + stock + "]";
    }
}