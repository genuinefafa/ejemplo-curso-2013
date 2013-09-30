package foo.curso.models;

import java.util.GregorianCalendar;

import foo.curso.entities.Alumno;

public class AlumnoForm {
	private String nombre;
	private String apellido;
	private int legajo;
	private String dia;
	private String mes;
	private String ano;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public Alumno crearAlumno(){
			GregorianCalendar greg = new GregorianCalendar(Integer.parseInt(ano),Integer.parseInt(mes)-1, Integer.parseInt(dia) );
			Alumno unAlumno = Alumno.crearAlumno(nombre, apellido, legajo, greg.getTime());
		
		return unAlumno;		
	}
	
}
