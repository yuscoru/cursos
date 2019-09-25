package com.yuscoru.cursos.model.entity;

import java.io.Serializable;

public class CursoEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nivel;
	private String horas;
	private String titulo;
	private int activo;
	private ProfesorEntity profesor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getHoras() {
		return horas;
	}
	public void setHoras(String horas) {
		this.horas = horas;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	public ProfesorEntity getProfesor() {
		return profesor;
	}
	public void setProfesor(ProfesorEntity profesor) {
		this.profesor = profesor;
	}

}
