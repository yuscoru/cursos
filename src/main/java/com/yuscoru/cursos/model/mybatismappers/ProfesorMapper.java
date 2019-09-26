package com.yuscoru.cursos.model.mybatismappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.yuscoru.cursos.model.entities.ProfesorEntity;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProfesorMapper {
	
    @Select("SELECT ID_PROFESOR, NOMBRE_PROFESOR FROM PROFESORES WHERE ID_PROFESOR = #{id}")
    @Results(value = {
                @Result(property = "id", column = "ID_PROFESOR"),
                @Result(property = "nombre", column = "NOMBRE_PROFESOR")
            })
    public ProfesorEntity getProfesor(@Param("id") int id);

    @Select("SELECT ID_PROFESOR, NOMBRE_PROFESOR FROM PROFESORES")
    @Results(value = {
            @Result(property = "id", column = "ID_PROFESOR"),
            @Result(property = "nombre", column = "NOMBRE_PROFESOR")
            })
    public List<ProfesorEntity> getProfesores();
}
