package com.yuscoru.cursos.endpoints;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.NoOpResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class GestorProfesoresEndPointTest {
	 	@LocalServerPort
	    private int port;

	    private final RestTemplate restTemplate = createRestTemplate();

	    private static RestTemplate createRestTemplate() {
	        RestTemplate template = new RestTemplate();
	        template.setErrorHandler(new NoOpResponseErrorHandler());
	        return template;
	    }

	    @Test
	    public void givenPeticionGETProfesoresWhenWorkEndpointThenResponse200() throws Exception {
	    	ResponseEntity<String> response = restTemplate.getForEntity(
	    			"http://localhost:" + port + "/rest/api/v1/profesores", String.class);
	    	assertEquals(200, response.getStatusCode().value());
	    }

}
