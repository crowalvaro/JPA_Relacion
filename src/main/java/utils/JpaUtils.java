package utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
private static final EntityManagerFactory emf;

// el inicializado static, reemplaza al constructor de instancias
static {
	try {
	emf=Persistence.createEntityManagerFactory("JPA_Relacion");
	} catch (Throwable ex) {
		System.out.println("La sesion de factoria no se pudo inicializar " + ex);
		throw new ExceptionInInitializerError(ex);
	}
}

public static EntityManagerFactory getEmf() {
	return emf;
}
}
