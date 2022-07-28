package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;




@Entity
@Table(name="estudiantes")
public class Estudiante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	
	private String apellido;
	
	private String identificacion;
	
	
	@ManyToMany
	@JoinTable(name="estudiante_cursos", joinColumns= @JoinColumn(name="fk_estudiante"), inverseJoinColumns=@JoinColumn(name="fk_curso"))
	private Set<Curso>cursos;

	
	/**
	 * getters && setters
	 * 
	 */
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


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


	public String getIdentificacion() {
		return identificacion;
	}


	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}


	public Set<Curso> getCursos() {
		return cursos;
	}


	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
}
