package com.yuscoru.cursos.model.mybatismappers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.transaction.annotation.Transactional;

import com.yuscoru.cursos.model.entities.CursoEntity;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Transactional
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
		nuevoCurso.setActivo(true);
		nuevoCurso.setHoras(120);
		nuevoCurso.setIdProfesor(5);
		nuevoCurso.setNivel("Medio");
		nuevoCurso.setTitulo("ESTE TITULO NO PUEDE SUPERAR LOS 200 CARACTERES");
		assertEquals(1,whenAltaCurso(nuevoCurso));
	}

    @Test
    public void testDivisionWithException() {
		CursoEntity nuevoCurso = new CursoEntity();
		nuevoCurso.setActivo(true);
		nuevoCurso.setHoras(120);
		nuevoCurso.setIdProfesor(8);
		nuevoCurso.setNivel("Medio");
		nuevoCurso.setTitulo("ESTE TITULO NO PUEDE SUPERAR LOS 200 CARACTERES");
		assertThrows(Exception.class, () -> whenAltaCurso(nuevoCurso));
    }

    private int whenAltaCurso(CursoEntity nuevoCurso) {
		return cursoMapper.save(nuevoCurso );
	}
}
