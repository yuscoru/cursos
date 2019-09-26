package com.yuscoru.cursos.model.mappers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.yuscoru.cursos.model.entities.ProfesorEntity;
import com.yuscoru.cursos.model.mappers.ProfesorMapper;

@RunWith(SpringRunner.class)
@MybatisTest
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
