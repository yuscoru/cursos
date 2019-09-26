package com.yuscoru.cursos.services.mybatisimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yuscoru.cursos.model.entities.CursoEntity;
import com.yuscoru.cursos.model.mybatismappers.CursoMapper;
import com.yuscoru.cursos.services.CursosService;

@Service
public class CursosServiceImpl implements CursosService{

	private CursoMapper cursoMapper;
	
	
	public CursosServiceImpl(CursoMapper cursoMapper) {
		super();
		this.cursoMapper = cursoMapper;
	}

	@Override
	public List<CursoEntity> consultaCatalogoCursos() {
		return cursoMapper.getCursos();
	}

	@Override
	public CursoEntity altaCurso(CursoEntity nuevoCurso) {
		return null;
	}

}
