package ejecutable;

import dao.DaoCurso;
import dao.DaoEstudiante;
import model.Curso;
import model.Estudiante;

public class Main {

	public static void main(String[] args) {
		
		Curso c=DaoCurso.find(2L);
		System.out.println("---- Curso de base de datos -----------");
		System.out.println(c);
		System.out.println(c.getNombre());
		
		
		Estudiante e=DaoEstudiante.find(2L);
		System.out.println("---- Estudiante de base de datos -----------");
		System.out.println(e);
		System.out.println(e.getNombre());
		
		System.out.println("*******************");
		System.out.println("Estudiantes de java: ");
		System.out.println("--------------------");
		
		for (String estudiantes : DaoEstudiante.findEstudiantesJava()) {
			System.out.println(estudiantes);
		}
		System.out.println("_______________________");
		System.out.println("****************");
		
		System.out.println("*******************");
		System.out.println("Estudiantes con más cursos: ");
		System.out.println("--------------------");
		
		for (String estudiantes : DaoEstudiante.findAlumnosMásCursos()) {
			System.out.println(estudiantes);
		}
		System.out.println("_______________________");
		System.out.println("****************");
		
		System.out.println("*******************");
		System.out.println("Estudiantes con menos cursos: ");
		System.out.println("--------------------");
		
		for (String estudiantes : DaoEstudiante.findAlumnosMenosCursos()) {
			System.out.println(estudiantes);
		}
		System.out.println("_______________________");
		System.out.println("****************");
		
		System.out.println("*******************");
		System.out.println("Estudiantes de java  y mysql: ");
		System.out.println("--------------------");
		
		for (String estudiantes : DaoEstudiante.findEstudiantesJavayMysql()) {
			System.out.println(estudiantes);
		}
		System.out.println("_______________________");
		System.out.println("****************");
		
		
		

	}

}
