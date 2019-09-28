package com.yuscoru.cursos.services.mybatisimpl;

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
import com.yuscoru.cursos.model.mybatismappers.CursoMapper;
import com.yuscoru.cursos.services.mybatisimpl.CursosServiceMybatisImpl;

@RunWith(MockitoJUnitRunner.class)
public class CursosServiceMybatisImplTest {
	@Mock
	private CursoMapper cursoMapper;
	@InjectMocks
	private CursosServiceMybatisImpl cursosServiceImpl;

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
		
		assertTrue(whenConsultaCursos(givenCursosBDDNull()).isEmpty());
		
	}

	@Test
	public void givenListaCursosWhenConsultaCursosThenDevuelveSoloActivos() throws Exception {
		
		assertNull(whenConsultaCursos(givenCursosBDDConDatos())
				.stream()
				.filter(curso -> curso.getActivo() == 0)
				.findAny()
				.orElse(null));
		
	}

	private List<CursoEntity> whenConsultaCursos(List<CursoEntity> listCursosBDD) {
		when(cursoMapper.getCursos()).thenReturn(listCursosBDD);
		return cursosServiceImpl.consultaCatalogoCursos();
	}


	private  List<CursoEntity> givenCursosBDDConDatos() {
		List<CursoEntity> listCursosBBDD = new ArrayList<CursoEntity>();
		CursoEntity curso1 = new CursoEntity();
		curso1.setActivo(1);
		CursoEntity curso2 = new CursoEntity();
		curso2.setActivo(0);
		listCursosBBDD.add(curso1);
		listCursosBBDD.add(curso2);
		return listCursosBBDD;
	}

	private  List<CursoEntity> givenCursosBDDVacio() {
		List<CursoEntity> listCursosBBDD = new ArrayList<CursoEntity>();
		return listCursosBBDD;
	}
	
	private  List<CursoEntity> givenCursosBDDNull() {
		return null;
	}
}
