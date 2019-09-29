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
		
		assertFalse(whenConsultaCursos(givenCursosBDDConDatos(),true).isEmpty());
		
	}

	@Test
	public void givenOrdenarPorTituloAscWhenConsultaCursosThenListadoCursosOrdenada() throws Exception {
		
		List<CursoEntity> cursos = whenConsultaCursos(givenCursosBDDConDatos(),true); 
		assertTrue(cursos.get(0).getTitulo().equalsIgnoreCase("ANGULAR"));
		assertTrue(cursos.get(cursos.size()-1).getTitulo().equalsIgnoreCase("ZIP"));
		
	}
	@Test
	public void givenOrdenarPorTituloDescWhenConsultaCursosThenListadoCursosOrdenada() throws Exception {
		List<CursoEntity> cursos = whenConsultaCursos(givenCursosBDDConDatos(),false); 
		assertTrue(cursos.get(0).getTitulo().equalsIgnoreCase("ZIP"));
		assertTrue(cursos.get(cursos.size()-1).getTitulo().equalsIgnoreCase("ANGULAR"));
	}
	@Test
	public void givenCursosBBDDVaciosWhenConsultaCursosThenListadoCursosVacio() throws Exception {
		
		assertTrue(whenConsultaCursos(givenCursosBDDVacio(),true).isEmpty());
		
	}

	@Test
	public void givenCursosBBDDNullWhenConsultaCursosThenListadoNull() throws Exception {
		
		assertTrue(whenConsultaCursos(givenCursosBDDNull(),true).isEmpty());
		
	}

	@Test
	public void givenListaCursosWhenConsultaCursosThenDevuelveSoloActivos() throws Exception {
		
		assertNull(whenConsultaCursos(givenCursosBDDConDatos(),true)
				.stream()
				.filter(curso -> !curso.isActivo())
				.findAny()
				.orElse(null));
		
	}

	private List<CursoEntity> whenConsultaCursos(List<CursoEntity> listCursosBDD,boolean asc) {
		when(cursoMapper.getCursos()).thenReturn(listCursosBDD);
		return cursosServiceImpl.consultaCatalogoCursos(asc);
	}


	private  List<CursoEntity> givenCursosBDDConDatos() {
		List<CursoEntity> listCursosBBDD = new ArrayList<CursoEntity>();
		CursoEntity curso1 = new CursoEntity();
		curso1.setActivo(true);
		curso1.setTitulo("MERGE");
		CursoEntity curso2 = new CursoEntity();
		curso2.setActivo(false);
		CursoEntity curso3 = new CursoEntity();
		curso3.setActivo(true);
		curso3.setTitulo("ZIP");
		CursoEntity curso4 = new CursoEntity();
		curso4.setActivo(true);
		curso4.setTitulo("ANGULAR");
		CursoEntity curso5 = new CursoEntity();
		curso5.setActivo(true);
		curso5.setTitulo("PROTRACTOR");
		CursoEntity curso6 = new CursoEntity();
		curso6.setActivo(true);
		curso6.setTitulo("JERSEY");
		listCursosBBDD.add(curso1);
		listCursosBBDD.add(curso2);
		listCursosBBDD.add(curso3);
		listCursosBBDD.add(curso4);
		listCursosBBDD.add(curso5);
		listCursosBBDD.add(curso6);
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
