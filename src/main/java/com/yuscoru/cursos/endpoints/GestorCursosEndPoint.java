package com.yuscoru.cursos.endpoints;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
		if(requestValida(curso)) {
			return Response.ok().entity(cursosServicio.altaCurso(curso)).build();
		}else {
			return Response.status(400).build();
		}
    }

	private boolean requestValida(CursoEntity curso) {
		if(curso.getHoras()<=0
			|| curso.getIdProfesor()<=0
			|| "".equals(curso.getNivel())
			|| "".equals(curso.getTitulo())){
			
			return false;
		}
		return true;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultaCursos(
			@DefaultValue("true") @QueryParam("ascendente") boolean ascendente
			) {
		return Response.ok().entity(cursosServicio.consultaCatalogoCursos(ascendente)).build();
    }
}