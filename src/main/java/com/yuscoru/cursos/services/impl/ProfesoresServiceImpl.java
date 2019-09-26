package com.yuscoru.cursos.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yuscoru.cursos.model.entities.ProfesorEntity;
import com.yuscoru.cursos.model.mappers.ProfesorMapper;
import com.yuscoru.cursos.services.ProfesoresService;

@Service
public class ProfesoresServiceImpl implements ProfesoresService{
	
	private ProfesorMapper profesorMapper;
	
	public ProfesoresServiceImpl(ProfesorMapper profesorMapper) {
		super();
		this.profesorMapper = profesorMapper;
	}

	@Override
	public List<ProfesorEntity> consultaProfesores() {
		return profesorMapper.getProfesores();
	}
}
