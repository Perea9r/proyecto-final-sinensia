package io.ruben.microcliente.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    private int idMenu;
    private String plato;
    private double precio;
    private int stock;

    public Menu() {
    }

    public Menu(int idMenu, String plato, double precio, int stock) {
        this.idMenu = idMenu;
        this.plato = plato;
        this.precio = precio;
        this.stock = stock;
    }

    public int getidMenu() {
        return idMenu;
    }

    public void setidMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getPlato() {
        return plato;
    }

    public void setPlato(String plato) {
        this.plato = plato;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Menu [idMenu=" + idMenu + ", plato=" + plato + ", precio="
                + precio + ", stock=" + stock + "]";
    }

}
