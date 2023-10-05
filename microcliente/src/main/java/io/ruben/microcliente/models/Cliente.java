package io.ruben.microcliente.models;

import java.time.LocalDate;

public class Cliente {

    private int idCliente;
    private String idMenu;
    private double platosConsumidos;
    private double totalPrecio;
    private LocalDate fecha;

    public Cliente() {

    }

    public Cliente(int idCliente, String idMenu, double platosConsumidos, double totalPrecio, LocalDate fecha) {
        this.idCliente = idCliente;
        this.idMenu = idMenu;
        this.platosConsumidos = platosConsumidos;
        this.totalPrecio = totalPrecio;
        this.fecha = fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(String idMenu) {
        this.idMenu = idMenu;
    }

    public double getPlatosConsumidos() {
        return platosConsumidos;
    }

    public void setPlatosConsumidos(double platosConsumidos) {
        this.platosConsumidos = platosConsumidos;
    }

    public double getTotalPrecio() {
        return totalPrecio;
    }

    public void setTotalPrecio(double totalPrecio) {
        this.totalPrecio = totalPrecio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Cliente [idCliente=" + idCliente + ", idMenu=" + idMenu + ", platosConsumidos=" + platosConsumidos
                + ", totalPrecio=" + totalPrecio + ", fecha=" + fecha + "]";
    }
}
