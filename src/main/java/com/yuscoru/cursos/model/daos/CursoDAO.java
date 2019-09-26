package com.yuscoru.cursos.model.daos;

import com.yuscoru.cursos.model.entities.CursoEntity;

public interface CursoDAO {
	
	public CursoEntity insertaCurso(int id);
	public CursoEntity consultaCursos();

}
