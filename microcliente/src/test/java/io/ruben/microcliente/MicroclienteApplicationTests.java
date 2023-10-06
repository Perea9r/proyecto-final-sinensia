package io.ruben.microcliente;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.ruben.microcliente.controllers.PedidoController;
import io.ruben.microcliente.controllers.PedidoController.FechaNoEncontradaException;
import io.ruben.microcliente.repositories.PedidoRepository;

@SpringBootTest
class MicroclienteApplicationTests {

	@Mock
	private PedidoRepository pedidoRepository;

	@InjectMocks
	private PedidoController controller;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testObtenerTotalPedidosPorFechaExistente() {
		Double totalEsperado = 100.0;
		when(pedidoRepository.obtenerTotalPedidosPorFecha(LocalDate.now())).thenReturn(totalEsperado);

		ResponseEntity<Double> respuesta = controller.obtenerTotalPedidosPorFecha(LocalDate.now());

		assertNotNull(respuesta);
		assertEquals(HttpStatus.OK, respuesta.getStatusCode());

		Double totalActual = respuesta.getBody();
		assertNotNull(totalActual);
		assertEquals(totalEsperado, totalActual);
	}

	@Test
	public void testObtenerTotalPedidosPorFechaNoExistente() {
		// Configurar el repositorio para devolver null
		LocalDate fecha = LocalDate.now();
		when(pedidoRepository.obtenerTotalPedidosPorFecha(fecha)).thenReturn(null);

		// Llamar al método obtenerTotalPedidosPorFecha del controlador
		Exception excepcion = assertThrows(FechaNoEncontradaException.class, () -> {
			controller.obtenerTotalPedidosPorFecha(fecha);
		}, "La fecha " + fecha + " no se encontró en la base de datos");

		// Verificar que se lanzó una excepción con el mensaje esperado
		assertNotNull(excepcion);
	}
}
