package com.yuscoru.cursos.model.mybatismappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.yuscoru.cursos.model.entities.CursoEntity;
import com.yuscoru.cursos.model.entities.ProfesorEntity;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface CursoMapper {
	
    @Select("SELECT ID_CURSO, NIVEL_CURSO, HORAS_CURSO, TITULO_CURSO, ACTIVO_CURSO, ID_PROFESOR FROM CURSOS WHERE ID_CURSO = #{id}")
    @Results(value = {
                @Result(property = "id", column = "ID_CURSO"),
                @Result(property = "nivel", column = "NIVEL_CURSO"),
                @Result(property = "horas", column = "HORAS_CURSO"),
                @Result(property = "titulo", column = "TITULO_CURSO"),
                @Result(property = "activo", column = "ACTIVO_CURSO"),
                @Result(property = "idProfesor", column = "ID_PROFESOR"),
                @Result(property = "profesor",  javaType = ProfesorEntity.class, 
                	    column = "ID_PROFESOR",
                	    one=@One(select = "com.yuscoru.cursos.model.mybatismappers.ProfesorMapper.getProfesor"))

            })
    public CursoEntity getCurso(@Param("id") int id);

    @Select("SELECT ID_CURSO, NIVEL_CURSO, HORAS_CURSO, TITULO_CURSO, ACTIVO_CURSO, ID_PROFESOR FROM CURSOS")
    @Results(value = {
                @Result(property = "id", column = "ID_CURSO"),
                @Result(property = "nivel", column = "NIVEL_CURSO"),
                @Result(property = "horas", column = "HORAS_CURSO"),
                @Result(property = "titulo", column = "TITULO_CURSO"),
                @Result(property = "activo", column = "ACTIVO_CURSO"),
                @Result(property = "idProfesor", column = "ID_PROFESOR"),
                @Result(property = "profesor",  javaType = ProfesorEntity.class, 
                	    column = "ID_PROFESOR",
                	    one=@One(select = "com.yuscoru.cursos.model.mybatismappers.ProfesorMapper.getProfesor"))
            })
    public List<CursoEntity> getCursos();
    
    @Insert("INSERT INTO CURSOS(NIVEL_CURSO, HORAS_CURSO, TITULO_CURSO, ACTIVO_CURSO, ID_PROFESOR) VALUES(#{nivel}, #{horas}, #{titulo}, #{activo}, #{idProfesor})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="ID")
    public int save(CursoEntity nuevoCurso);
}
