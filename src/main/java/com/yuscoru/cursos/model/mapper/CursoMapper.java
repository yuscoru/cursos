package com.yuscoru.cursos.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.yuscoru.cursos.model.entity.CursoEntity;
import com.yuscoru.cursos.model.entity.ProfesorEntity;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.One;

@Mapper
public interface CursoMapper {
	
    @Select("SELECT ID_CURSO, NIVEL_CURSO, HORAS_CURSO, TITULO_CURSO, ACTIVO_CURSO, ID_PROFESOR FROM CURSOS WHERE ID_CURSO = #{id}")
    @Results(value = {
                @Result(property = "id", column = "ID_CURSO"),
                @Result(property = "nivel", column = "NIVEL_CURSO"),
                @Result(property = "horas", column = "HORAS_CURSO"),
                @Result(property = "titulo", column = "TITULO_CURSO"),
                @Result(property = "activo", column = "ACTIVO_CURSO"),
                @Result(property = "profesor",  javaType = ProfesorEntity.class, 
        	    column = "ID_PROFESOR",
        	    one=@One(select = "com.yuscoru.cursos.model.mapper.ProfesorMapper.getProfesor"))
            })
    public CursoEntity getCurso(@Param("id") int id);

    @Select("SELECT ID_CURSO, NIVEL_CURSO, HORAS_CURSO, TITULO_CURSO, ACTIVO_CURSO, ID_PROFESOR FROM CURSOS")
    @Results(value = {
                @Result(property = "id", column = "ID_CURSO"),
                @Result(property = "nivel", column = "NIVEL_CURSO"),
                @Result(property = "horas", column = "HORAS_CURSO"),
                @Result(property = "titulo", column = "TITULO_CURSO"),
                @Result(property = "activo", column = "ACTIVO_CURSO"),
                @Result(property = "profesor",  javaType = ProfesorEntity.class, 
                	    column = "ID_PROFESOR",
                	    one=@One(select = "com.yuscoru.cursos.model.mapper.ProfesorMapper.getProfesor"))
            })
    public List<CursoEntity> getCursos();
}
