package io.ruben.microcliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MicroclienteApplication {

	/**
	 * La función crea y devuelve un objeto RestTemplate utilizando
	 * RestTemplateBuilder.
	 * 
	 * @param builder `RestTemplateBuilder` es una clase de utilidad proporcionada
	 *                por Spring Boot que
	 *                ayuda a crear instancias de `RestTemplate`. Proporciona
	 *                métodos convenientes para configurar varios
	 *                aspectos de `RestTemplate`, como tiempos de espera,
	 *                convertidores de mensajes, interceptores, etc.
	 * @return El método devuelve un objeto RestTemplate.
	 */
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroclienteApplication.class, args);
	}

}
