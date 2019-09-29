package com.yuscoru.cursos.services;

import java.util.List;

import com.yuscoru.cursos.model.entities.CursoEntity;

public interface CursosService {
	
	public List<CursoEntity> consultaCatalogoCursos(boolean asc);
	public CursoEntity altaCurso(CursoEntity nuevoCurso);

}
