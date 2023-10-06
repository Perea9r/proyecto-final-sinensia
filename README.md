# MICROSERVICIOS MENU/PEDIDO

Este proyecto es un ejemplo de microservicio con Spring Boot. El microservicio se encarga de gestionar los pedidos y el menu. Pedido hace peticiones a menu para obtener los datos de los productos y elimina el stock de los platos que se han pedido, cuando un plato se queda sin stock se elimina el plato del menu.

## Requisitos

- Java 17 🍵
- Maven 3.9 🍵
- Spring Boot 3.1.4 🍃
- Spring Boot Web Starter 🍃
- H2 Database 💽
- Spring Boot Test Starter 🧪
- Mockito Core 5.5.0 🧪

## Instalación

1. Clona el repositorio en tu máquina local.
2. Abre una terminal en la carpeta raíz del proyecto y ejecuta el siguiente comando para compilar el proyecto: `mvn clean install` esto generará la carpeta `target` con nuestro proyecto compilado en un archivo JAR.
3. Ejecutar el proyecto con el comando `run` de Spring Boot en cada paquete.
4. La aplicación ya debería estar disponible en [localhost:8080](http://localhost:8080) y [localhost:8081](http://localhost:8081)

## Uso

**GET /menus** - Obtener todos los menus.
**POST /menu** - Crear un menu.
**GET /menu/{idMenu}** - Obtener un menu por su id.
**PUT /menu/{idMenu}/{stock}** - Actualizar un menu buscandolo por su id y su stock.
**DELETE /menu/{idMenu}** - Eliminar un menu por su id.
**GET /menu/{precio}** - Obtener un menu por su precio.
___
**GET /pedidos** - Obtener todos los pedidos.
**POST /pedido/{idPedido}/{unidades}** Da de alta un pedido.
**GET /pedido/{fecha}** - Retorna el total de un pedido por fecha.

## Licencia

MIT License Copyright (c)
