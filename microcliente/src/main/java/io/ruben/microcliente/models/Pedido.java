package io.ruben.microcliente.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    private int idPedido;
    private int idMenu;
    private int unidades;
    private double total;
    @Column(columnDefinition = "DATE")
    private LocalDate fecha;

    public Pedido() {
    }

    public Pedido(int idPedido, int idMenu, int unidades, double total, LocalDate fecha) {
        this.idPedido = idPedido;
        this.idMenu = idMenu;
        this.unidades = unidades;
        this.total = total;
        this.fecha = fecha;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Pedido [idPedido=" + idPedido + ", idMenu=" + idMenu + ", unidades=" + unidades
                + ", total=" + total + ", fecha=" + fecha + "]";
    }
}