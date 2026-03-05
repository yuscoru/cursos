package com.yuscoru.cursos.services.mybatisimpl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.yuscoru.cursos.model.entities.ProfesorEntity;
import com.yuscoru.cursos.model.mybatismappers.ProfesorMapper;
import com.yuscoru.cursos.services.mybatisimpl.ProfesoresServiceMybatisImpl;

@ExtendWith(MockitoExtension.class)
public class ProfesoresServiceMybatisImplTest {
	@Mock
	private ProfesorMapper profesorMapper;
	@InjectMocks
	private ProfesoresServiceMybatisImpl profesoresServiceImpl;

	@Test
	public void givenHayProfesoresBBDDWhenconsultaThendevuelvelistaprofesores() throws Exception {
		assertFalse(whenCallConsultaProfesores(givenProfesoresenBBDDcondatos()).isEmpty());
	}

	@Test
	public void givenProfesoressBBDDnullWhenconsultaThendevuelvelistaNull() throws Exception {
		assertNull(whenCallConsultaProfesores(null));
	}

	@Test
	public void givenProfesoresBBDDVaciaWhenconsultaThendevuelvelistaSinDatos() throws Exception {
		assertTrue(whenCallConsultaProfesores(givenProfesoresenBBDDVacia()).isEmpty());
	}
	private List<ProfesorEntity> whenCallConsultaProfesores(List<ProfesorEntity> profesoresBBDD) {
		when(profesorMapper.getProfesores()).thenReturn(profesoresBBDD);
		return profesoresServiceImpl.consultaProfesores();
	}

	private List<ProfesorEntity> givenProfesoresenBBDDcondatos() {
		List<ProfesorEntity> profesoresBBDD = new ArrayList<>();
		ProfesorEntity profesor = new ProfesorEntity();
		profesoresBBDD.add(profesor);
		return profesoresBBDD;
	}

	private List<ProfesorEntity> givenProfesoresenBBDDVacia() {
		List<ProfesorEntity> profesoresBBDD = new ArrayList<>();
		return profesoresBBDD;
	}
}
