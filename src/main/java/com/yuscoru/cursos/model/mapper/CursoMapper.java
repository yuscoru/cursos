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
                @Result(property = "profesor",  javaType = CursoEntity.class, 
                	    column = "ID_PROFESOR",
                	    one=@One(select = "getProfesor")),
            })
    public ProfesorEntity getCurso(@Param("id") int id);

    @Select("SELECT ID_PROFESOR, NOMBRE_PROFESOR FROM PROFESORES")
    @Results(value = {
            @Result(property = "id", column = "ID_PROFESOR"),
            @Result(property = "nombre", column = "NOMBRE_PROFESOR"),
            })
    public List<ProfesorEntity> getCursos();
}
