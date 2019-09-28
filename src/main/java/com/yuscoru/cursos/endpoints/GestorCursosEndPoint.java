package com.yuscoru.cursos.endpoints;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.yuscoru.cursos.model.entities.CursoEntity;
import com.yuscoru.cursos.services.CursosService;

@Component
@Path("/rest/api/v1/cursos")
public class GestorCursosEndPoint {

	private CursosService cursosServicio;
	
    public GestorCursosEndPoint(CursosService cursosServicio) {
		super();
		this.cursosServicio = cursosServicio;
	}

	@POST
	@Path("/curso")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response altaCurso(CursoEntity curso) {
		return Response.ok().entity(cursosServicio.altaCurso(curso)).build();
    }

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultaCursos() {
		return Response.ok().entity(cursosServicio.consultaCatalogoCursos()).build();
    }
}
