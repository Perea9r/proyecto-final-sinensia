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

    /**
     * Esta función recupera una lista de menús que se han consumido dentro de un
     * rango de fechas
     * específico y tienen suficiente stock disponible.
     * 
     * @param fechaInicio La fecha de inicio de la consulta.
     * @param fechaFin    La fecha de finalización del periodo del que deseas
     *                    recuperar los menús consumidos.
     * @param menuId      El parámetro menuId se utiliza para especificar el ID del
     *                    menú del que desea recuperar
     *                    los menús consumidos.
     * @return El método devuelve una lista de objetos de menú.
     */
}
