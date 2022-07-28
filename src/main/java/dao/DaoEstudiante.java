package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Estudiante;

import utils.JpaUtils;

public class DaoEstudiante {

	public static Estudiante find(Long id) {
		EntityManager em=JpaUtils.getEmf().createEntityManager();
		Estudiante estudiante=null;
		try {
			estudiante=em.find(Estudiante.class, id);
		}catch(Exception ex) {
			System.out.println("ups !!! ocurrio un error buscando el estudiante");
			ex.printStackTrace();
		}
		
		return estudiante;
	}
	
	public static void create(Estudiante curso) {
		EntityManager em=JpaUtils.getEmf().createEntityManager();
		em.getTransaction().begin(); // es como abrir un canal de comunicacion con la BD
		try {
			em.persist(curso); // esta haciendo un INSERT
			em.getTransaction().commit();			
		}catch(Exception ex) {
			em.getTransaction().rollback();
			System.out.println("ups !!! ocurrio un error creando el estudiante");
			ex.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	public static void update(Estudiante curso) {
		EntityManager em=JpaUtils.getEmf().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		try {
			em.merge(curso);// esta haciendo un UPDATE
			tx.commit();
			System.out.println("actualizacion exitosa!!");
		}catch(Exception ex) {
			tx.rollback();
			System.out.println("ups !!! ocurrio un error creando el estudiante");
			ex.printStackTrace();
		}finally {
			em.close();
		}
	}

	public static void delete(Long id) {
		EntityManager em=JpaUtils.getEmf().createEntityManager();
		em.getTransaction().begin();
		try {
			Estudiante p=DaoEstudiante.find(id);
			em.remove(p);
			em.getTransaction().commit();
		}catch(Exception ex) {
			System.out.println("Estudiante borrado!!");
			ex.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	/**
	 * Consultar Estudiantes que tienen java
	 * @return List<String> estudiantes
	 */
	public static List<String> findEstudiantesJava() {
        EntityManager em = JpaUtils.getEmf().createEntityManager();
        Query consulta = em.createNativeQuery("Select ec.fk_estudiante from estudiante_cursos ec where ec.fk_curso=1 ");
        List<?> estudiantes = consulta.getResultList();
        
        List<String> estudiantesNombre=new ArrayList<String>();
        for (Object cod : estudiantes) {
        	Estudiante estudiante=DaoEstudiante.find(Long.parseLong(cod+""));
        	estudiantesNombre.add(estudiante.getNombre());
		}
        return estudiantesNombre;
    }
	/**
	 * Consultar Estudiantes que tienen java y va mysql
	 * @return List<String> estudiantes
	 */
	public static List<String> findEstudiantesJavayMysql() {
        EntityManager em = JpaUtils.getEmf().createEntityManager();
        Query consulta = em.createNativeQuery("Select ec.fk_estudiante from estudiante_cursos ec where ec.fk_curso=1 and ec.fk_curso=5 ");
        List<?> estudiantes = consulta.getResultList();
        
        List<String> estudiantesNombre=new ArrayList<String>();
        for (Object cod : estudiantes) {
        	Estudiante estudiante=DaoEstudiante.find(Long.parseLong(cod+""));
        	estudiantesNombre.add(estudiante.getNombre());
		}
        return estudiantesNombre;
    }
	
		/**
		 * Obtener los alumnos con más cursos
		 * @return List<String> estudiantes
		 */
		public static List<String> findAlumnosMásCursos() {
	        EntityManager em = JpaUtils.getEmf().createEntityManager();
	        Query consulta = em.createNativeQuery("select estudiante from (select ec.fk_estudiante estudiante,count(ec.fk_curso) as cursos from estudiante_cursos ec  group by ec.fk_estudiante) cursostabla where  cursos = (select count(fk_curso) curso from estudiante_cursos group by fk_estudiante order by curso desc limit 1)");
	        List<?> estudiantes = consulta.getResultList();
	        
	        List<String> estudiantesNombre=new ArrayList<String>();
	        for (Object cod : estudiantes) {
	        	Estudiante estudiante=DaoEstudiante.find(Long.parseLong(cod+""));
	        	estudiantesNombre.add(estudiante.getNombre());
			}
	        return estudiantesNombre;
	    }
		
		/**
		 * Obtener los alumnos con menos cursos
		 * @return List<String> estudiantes
		 */
		public static List<String> findAlumnosMenosCursos() {
	        EntityManager em = JpaUtils.getEmf().createEntityManager();
	        Query consulta = em.createNativeQuery("select estudiante from (select ec.fk_estudiante estudiante,count(ec.fk_curso) as cursos from estudiante_cursos ec  group by ec.fk_estudiante) cursostabla where  cursos = (select count(fk_curso) curso from estudiante_cursos group by fk_estudiante order by curso asc limit 1)");
	        List<?> estudiantes = consulta.getResultList();
	        
	        List<String> estudiantesNombre=new ArrayList<String>();
	        for (Object cod : estudiantes) {
	        	Estudiante estudiante=DaoEstudiante.find(Long.parseLong(cod+""));
	        	estudiantesNombre.add(estudiante.getNombre());
			}
	        return estudiantesNombre;
	    }
		
	
}
