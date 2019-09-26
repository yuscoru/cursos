package com.yuscoru.cursos.model.dao;

import com.yuscoru.cursos.model.entity.CursoEntity;

public interface CursoDAO {
	
	public CursoEntity insertaCurso(int id);
	public CursoEntity consultaCursos();

}
