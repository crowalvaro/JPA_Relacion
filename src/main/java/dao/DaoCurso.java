package dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Curso;
import utils.JpaUtils;

public class DaoCurso {

	public static Curso find(Long id) {
		EntityManager em=JpaUtils.getEmf().createEntityManager();
		Curso curso=null;
		try {
			curso=em.find(Curso.class, id);
		}catch(Exception ex) {
			System.out.println("ups !!! ocurrio un error buscando el curso");
			ex.printStackTrace();
		}
		
		return curso;
	}
	
	public static void create(Curso curso) {
		EntityManager em=JpaUtils.getEmf().createEntityManager();
		em.getTransaction().begin(); // es como abrir un canal de comunicacion con la BD
		try {
			em.persist(curso); // esta haciendo un INSERT
			em.getTransaction().commit();			
		}catch(Exception ex) {
			em.getTransaction().rollback();
			System.out.println("ups !!! ocurrio un error creando el curso");
			ex.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	public static void update(Curso curso) {
		EntityManager em=JpaUtils.getEmf().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		try {
			em.merge(curso);// esta haciendo un UPDATE
			tx.commit();
			System.out.println("actualizacion exitosa!!");
		}catch(Exception ex) {
			tx.rollback();
			System.out.println("ups !!! ocurrio un error creando el curso");
			ex.printStackTrace();
		}finally {
			em.close();
		}
	}

	public static void delete(Long id) {
		EntityManager em=JpaUtils.getEmf().createEntityManager();
		em.getTransaction().begin();
		try {
			Curso p=DaoCurso.find(id);
			em.remove(p);
			em.getTransaction().commit();
		}catch(Exception ex) {
			System.out.println("Curso borrado!!");
			ex.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	
}
