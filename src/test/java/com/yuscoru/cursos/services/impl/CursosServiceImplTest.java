package com.yuscoru.cursos.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

import com.yuscoru.cursos.model.entities.CursoEntity;
import com.yuscoru.cursos.model.mappers.CursoMapper;

@RunWith(MockitoJUnitRunner.class)
public class CursosServiceImplTest {
	@Mock
	private CursoMapper cursoMapper;
	@InjectMocks
	private CursosServiceImpl cursosServiceImpl;

	@Test
	public void givenCursosBBDDConDatosWhenConsultaCursosThenListadoCursosConDatos() throws Exception {
		
		assertFalse(whenConsultaCursos(givenCursosBDDConDatos()).isEmpty());
		
	}

	@Test
	public void givenCursosBBDDVaciosWhenConsultaCursosThenListadoCursosVacio() throws Exception {
		
		assertTrue(whenConsultaCursos(givenCursosBDDVacio()).isEmpty());
		
	}

	@Test
	public void givenCursosBBDDNullWhenConsultaCursosThenListadoNull() throws Exception {
		
		assertNull(whenConsultaCursos(givenCursosBDDNull()));
		
	}

	private List<CursoEntity> whenConsultaCursos(List<CursoEntity> listCursosBDD) {
		when(cursoMapper.getCursos()).thenReturn(listCursosBDD);
		return cursosServiceImpl.consultaCatalogoCursos();
	}


	private  List<CursoEntity> givenCursosBDDConDatos() {
		List<CursoEntity> listCursosBBDD = new ArrayList<CursoEntity>();
		CursoEntity curso = new CursoEntity();
		listCursosBBDD.add(curso);
		return listCursosBBDD;
	}

	private  List<CursoEntity> givenCursosBDDVacio() {
		List<CursoEntity> listCursosBBDD = new ArrayList<CursoEntity>();
		return listCursosBBDD;
	}
	
	private  List<CursoEntity> givenCursosBDDNull() {
		return null;
	}
	
	@Test
	public void testAltaCurso() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

}