package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "cursos")
public class Curso implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nombre;
	private Long creditos;

	@ManyToMany(mappedBy = "cursos", cascade = CascadeType.ALL, targetEntity = Estudiante.class)
	private Set<Estudiante> estudiantes;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * getters && setters
	 * 
	 * @return
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

	public Long getCreditos() {
		return creditos;
	}

	public void setCreditos(Long creditos) {
		this.creditos = creditos;
	}

	public Set<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Set<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}


}
