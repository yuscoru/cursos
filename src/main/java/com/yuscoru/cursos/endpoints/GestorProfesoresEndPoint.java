package com.yuscoru.cursos.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.yuscoru.cursos.services.ProfesoresService;

@Component
@Path("/rest/api/v1/profesores")
public class GestorProfesoresEndPoint {

	private ProfesoresService profesoresService;
	
    public GestorProfesoresEndPoint(ProfesoresService profesoresService) {
		super();
		this.profesoresService = profesoresService;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultaCursos() {
		return Response.ok().entity(profesoresService.consultaProfesores()).build();
    }
}
