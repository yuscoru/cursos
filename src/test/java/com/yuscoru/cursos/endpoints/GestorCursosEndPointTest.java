package com.yuscoru.cursos.endpoints;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.yuscoru.cursos.model.entities.CursoEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GestorCursosEndPointTest {

	 @LocalServerPort
	    private int port;

	    @Autowired
	    private TestRestTemplate restTemplate;

	    @Test
	    public void givenPeticionGETCursosWhenWorkEndpointThenResponse200() throws Exception {
	    	ResponseEntity<String> response =  this.restTemplate.getForEntity(new StringBuffer("http://localhost:").append(port).append("/rest/api/v1/cursos").toString(),String.class);
	    	assertEquals(200, response.getStatusCodeValue());
	    }

	    @Test
	    public void givenPeticionPOSTCursoWhenWorkEndpointThenResponse200() throws Exception {
	    	Object cursoEntity = new CursoEntity();
			HttpEntity<CursoEntity> request = new HttpEntity(cursoEntity);
	    	ResponseEntity<String> response =  this.restTemplate.postForEntity(new StringBuffer("http://localhost:").append(port).append("/rest/api/v1/cursos/curso").toString(),request,String.class);
	    	assertEquals(200, response.getStatusCodeValue());
	    }
}
