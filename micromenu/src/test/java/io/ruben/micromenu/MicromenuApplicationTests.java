package io.ruben.micromenu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.ruben.micromenu.controllers.MenuController;
import io.ruben.micromenu.models.Menu;
import io.ruben.micromenu.services.MenuService;

@SpringBootTest
class MicromenuApplicationTests {
	@Mock
	private MenuService service;

	@InjectMocks
	private MenuController controller;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	/**
	 * La función de prueba prueba la funcionalidad de buscar un elemento de menú
	 * existente.
	 */
	@Test
	public void testBuscarMenuExistente() {
		Menu menu = new Menu();
		menu.setidMenu(1);
		menu.setPlato("Hamburguesa");
		menu.setPrecio(10.0);
		when(service.buscarMenu(1)).thenReturn(menu);

		ResponseEntity<Menu> respuesta = controller.buscarMenu(1);

		assertNotNull(respuesta);
		assertEquals(HttpStatus.OK, respuesta.getStatusCode());

		Menu menuDevuelto = respuesta.getBody();
		assertNotNull(menuDevuelto);
		assertEquals(1, menuDevuelto.getidMenu());
		assertEquals("Hamburguesa", menuDevuelto.getPlato());
		assertEquals(10.0, menuDevuelto.getPrecio());
	}

/**
 * La función testBuscarMenuNoExistente prueba el escenario donde no existe un menú.
 */
	@Test
    public void testBuscarMenuNoExistente() {
        when(service.buscarMenu(1)).thenReturn(null);

        ResponseEntity<Menu> respuesta = controller.buscarMenu(1);

        assertNotNull(respuesta);
        assertEquals(HttpStatus.NOT_FOUND, respuesta.getStatusCode());
        assertNull(respuesta.getBody());
    }

	/**
	 * La función testStockProductoExistente prueba si el método stockProducto en el
	 * controlador devuelve
	 * el stock esperado para un producto existente.
	 */
	@Test
	public void testStockProductoExistente() {

		int stockEsperado = 10;
		when(service.stockProducto(1)).thenReturn(stockEsperado);

		int stockActual = controller.stockProducto(1);

		assertEquals(stockEsperado, stockActual);
	}

/**
 * Este caso de prueba comprueba si el stock de un producto inexistente se devuelve correctamente como
 * 0.
 */
	@Test
    public void testStockProductoNoExistente() {
        when(service.stockProducto(1)).thenReturn(0);
        int stockActual = controller.stockProducto(1);

        assertEquals(0, stockActual);
    }

}
