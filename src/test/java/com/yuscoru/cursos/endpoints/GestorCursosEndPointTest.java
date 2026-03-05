package com.yuscoru.cursos.endpoints;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.NoOpResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.yuscoru.cursos.model.entities.CursoEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GestorCursosEndPointTest {

	 @LocalServerPort
	    private int port;

	    private final RestTemplate restTemplate = createRestTemplate();

	    private static RestTemplate createRestTemplate() {
	        RestTemplate template = new RestTemplate();
	        template.setErrorHandler(new NoOpResponseErrorHandler());
	        return template;
	    }

	    @Test
	    public void givenPeticionGETCursosWhenWorkEndpointThenResponse200() throws Exception {
	    	ResponseEntity<String> response = restTemplate.getForEntity(
	    			"http://localhost:" + port + "/rest/api/v1/cursos", String.class);
	    	assertEquals(200, response.getStatusCode().value());
	    }

	    @Test
	    public void givenPeticionPOSTCursoWhenWorkEndpointThenResponse200() throws Exception {
	    	CursoEntity cursoEntity = new CursoEntity();
	    	cursoEntity.setActivo(true);
	    	cursoEntity.setHoras(99);
	    	cursoEntity.setIdProfesor(1);
	    	cursoEntity.setTitulo("PRUEBA DESDE TEST");
	    	cursoEntity.setNivel("MEDIO");
	    	HttpEntity<CursoEntity> request = new HttpEntity<>(cursoEntity);
	    	ResponseEntity<String> response = restTemplate.postForEntity(
	    			"http://localhost:" + port + "/rest/api/v1/cursos/curso", request, String.class);
	    	assertEquals(200, response.getStatusCode().value());
	    }

	    @Test
	    public void givenPeticionPOSTNoValidaWhenWorkEndpointThenResponse400() throws Exception {
	    	CursoEntity cursoEntity = new CursoEntity();
	    	cursoEntity.setTitulo("PRUEBA DESDE TEST");
	    	cursoEntity.setNivel("MEDIO");
	    	HttpEntity<CursoEntity> request = new HttpEntity<>(cursoEntity);
	    	ResponseEntity<String> response = restTemplate.postForEntity(
	    			"http://localhost:" + port + "/rest/api/v1/cursos/curso", request, String.class);
	    	assertEquals(404, response.getStatusCode().value());
	    }
}
