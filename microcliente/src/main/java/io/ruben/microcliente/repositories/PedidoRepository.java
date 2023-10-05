package io.ruben.microcliente.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.ruben.microcliente.models.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    /**
     * La función obtiene la suma total de pedidos para una fecha determinada.
     * 
     * @param fecha El parámetro "fecha" es de tipo LocalDate y representa la fecha
     *              de la cual se desea
     *              obtener la suma total de los pedidos.
     * @return El método devuelve un valor Doble, que representa la suma de la
     *         columna "total" en la
     *         tabla "Pedido" para una fecha determinada.
     */
    @Query(value = "SELECT SUM(total) FROM Pedido WHERE fecha = :fecha")
    Double obtenerTotalPedidosPorFecha(@Param("fecha") LocalDate fecha);
}
