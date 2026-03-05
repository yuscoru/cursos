package com.yuscoru.cursos.model.mybatismappers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.transaction.annotation.Transactional;

import com.yuscoru.cursos.model.entities.ProfesorEntity;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Transactional
public class ProfesorMapperTest{
	
	@Autowired
	private ProfesorMapper profesorMapper;
	
	@Test
	public void testGetProfesor() throws Exception {
		ProfesorEntity profesor = profesorMapper.getProfesor(3);
		assertEquals("KURK KOBAIN",profesor.getNombre());
	}

	@Test
	public void testGetProfesores() throws Exception {
		List<ProfesorEntity> listProfesores =  profesorMapper.getProfesores();
		assertEquals(6,listProfesores.size());
	}

}
