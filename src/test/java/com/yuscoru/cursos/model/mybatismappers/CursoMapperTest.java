package com.yuscoru.cursos.model.mybatismappers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.yuscoru.cursos.model.entities.CursoEntity;
import com.yuscoru.cursos.model.mybatismappers.CursoMapper;

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

	@Test
	public void testAltaCurso() throws Exception {
		CursoEntity nuevoCurso = new CursoEntity();
		nuevoCurso.setActivo(1);
		nuevoCurso.setHoras(120);
		nuevoCurso.setIdProfesor(5);
		nuevoCurso.setNivel("Medio");
		nuevoCurso.setTitulo("ESTE TITULO NO PUEDE SUPERAR LOS 200 CARACTERES");
		assertEquals(1,whenAltaCurso(nuevoCurso));
	}

    @Test(expected = Exception.class)
    public void testDivisionWithException() {
		CursoEntity nuevoCurso = new CursoEntity();
		nuevoCurso.setActivo(1);
		nuevoCurso.setHoras(120);
		nuevoCurso.setIdProfesor(8);
		nuevoCurso.setNivel("Medio");
		nuevoCurso.setTitulo("ESTE TITULO NO PUEDE SUPERAR LOS 200 CARACTERES");
		whenAltaCurso(nuevoCurso);
    }

    private int whenAltaCurso(CursoEntity nuevoCurso) {
		return cursoMapper.save(nuevoCurso );
	}
}
