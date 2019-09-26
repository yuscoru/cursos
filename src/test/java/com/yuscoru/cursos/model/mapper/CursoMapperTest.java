package com.yuscoru.cursos.model.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.yuscoru.cursos.model.entity.CursoEntity;

@RunWith(SpringRunner.class)
@MybatisTest
public class CursoMapperTest{
	
	@Autowired
	private CursoMapper cursoMapper;
	@Test
	public void testGetCurso() throws Exception {
		CursoEntity curso = cursoMapper.getCurso(1);
		assertEquals("QUIMICA FISICA 1",curso.getTitulo());
		assertEquals("ZINEDINE ZIDANE",curso.getProfesor().getNombre());
	}

	@Test
	public void testGetCursos() throws Exception {
		List<CursoEntity> listCursos = cursoMapper.getCursos();
		assertEquals(29,listCursos.size());
	}

}
