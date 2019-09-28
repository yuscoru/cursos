package com.yuscoru.cursos.services.mybatisimpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yuscoru.cursos.model.entities.CursoEntity;
import com.yuscoru.cursos.model.mybatismappers.CursoMapper;
import com.yuscoru.cursos.services.CursosService;

@Service
public class CursosServiceMybatisImpl implements CursosService{

	private CursoMapper cursoMapper;
	
	
	public CursosServiceMybatisImpl(CursoMapper cursoMapper) {
		super();
		this.cursoMapper = cursoMapper;
	}

	@Override
	public List<CursoEntity> consultaCatalogoCursos() {
		return Optional.ofNullable(cursoMapper.getCursos())
                .orElseGet(Collections::emptyList)
				.stream()
				.filter(curso -> curso!= null && curso.isActivo())
				.collect(Collectors.toList());
	}

	@Override
	public CursoEntity altaCurso(CursoEntity nuevoCurso) {
		cursoMapper.save(nuevoCurso);
		return nuevoCurso;
	}

}
