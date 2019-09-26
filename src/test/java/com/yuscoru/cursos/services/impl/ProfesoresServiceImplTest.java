package com.yuscoru.cursos.services.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

import com.yuscoru.cursos.model.entities.ProfesorEntity;
import com.yuscoru.cursos.model.mappers.ProfesorMapper;

@RunWith(MockitoJUnitRunner.class)
public class ProfesoresServiceImplTest {
	@Mock
	private ProfesorMapper profesorMapper;
	@InjectMocks
	private ProfesoresServiceImpl profesoresServiceImpl;

	@Test
	public void givenProfesoresWhenconsultaThendevuelvelistaprofesores() throws Exception {
		givenProfesoresinBBDD();
		List<ProfesorEntity> listaProfesores = whenCallConsultaProfesores();
		thenDevuelveListaProfesores(listaProfesores);
	}

	@Test
	public void WhenconsultaThendevuelvelistaNull() throws Exception {
		when(profesorMapper.getProfesores()).thenReturn(null);
		List<ProfesorEntity> listaProfesores = whenCallConsultaProfesores();
		thenDevuelveListaNull(listaProfesores);
	}

	@Test
	public void WhenconsultaThendevuelvelistaSinDatos() throws Exception {
		when(profesorMapper.getProfesores()).thenReturn(new ArrayList<>());
		List<ProfesorEntity> listaProfesores = whenCallConsultaProfesores();
		thenDevuelveListaSinDatos(listaProfesores);
	}
	private void thenDevuelveListaProfesores(List<ProfesorEntity> listaProfesores) {
		//then
		assertFalse(listaProfesores.isEmpty());
	}

	private void thenDevuelveListaSinDatos(List<ProfesorEntity> listaProfesores) {
		//then
		assertTrue(listaProfesores.isEmpty());
	}

	private void thenDevuelveListaNull(List<ProfesorEntity> listaProfesores) {
		//then
		assertNull(listaProfesores);
	}

	private List<ProfesorEntity> whenCallConsultaProfesores() {
		List<ProfesorEntity> listaProfesores = profesoresServiceImpl.consultaProfesores();
		return listaProfesores;
	}

	private void givenProfesoresinBBDD() {
		List<ProfesorEntity> listaBBDD = new ArrayList<>();
		ProfesorEntity profesor = new ProfesorEntity();
		listaBBDD.add(profesor);
		when(profesorMapper.getProfesores()).thenReturn(listaBBDD);
	}

}
