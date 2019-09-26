package com.yuscoru.cursos.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.yuscoru.cursos.endpoints.GestorCursosEndPoint;

@Configuration
public class JerseyConfig  extends ResourceConfig{
	   public JerseyConfig() {
	        register(GestorCursosEndPoint.class);
	    }

}
