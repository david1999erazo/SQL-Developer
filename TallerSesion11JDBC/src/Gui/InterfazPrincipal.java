package Gui;

import java.sql.Connection;
import java.sql.SQLException;

import ConsultasSQL.Reportes;
import Tables.ConexionOracle;
import Tables.Curso;
import Tables.Estudiante;
import Tables.Matricula;
import Tables.Profesor;

public class InterfazPrincipal {

	public static void main(String[] args) throws Exception {

		Reportes r = new Reportes();
		
		//Put your user and password to connected with SQL Developer 
		Connection con = ConexionOracle.getConnection("P09551_1_4", "P09551_1_4_20191");
		Curso c = new Curso(con);
		Estudiante e = new Estudiante(con);
		Matricula m = new Matricula(con);
		Profesor p = new Profesor(con);

		System.out.println();
		
		// Delete table
		try {

			m.drop_table();
			System.out.println("La tabla Matricula fue eliminada");
			c.drop_table();
			System.out.println("La tabla Curso fue eliminada");
			p.drop_table();
			System.out.println("La tabla Profesor fue eliminada");
			e.drop_table();
			System.out.println("La tabla Estudiante fue eliminada");

		} catch (Exception e2) {

			System.out.println("No existen las tablas en la base de datos");

		}

		System.out.println();
		// Create tables
		try {

			e.create_table();
			System.out.println("La tabla Matricula fue creada");
			p.create_table();
			System.out.println("La tabla Curso fue creada");
			c.create_table();
			System.out.println("La tabla Profesor fue creada");
			m.create_table();
			System.out.println("La tabla Estudiante fue creada");

		} catch (Exception e2) {
			System.out.println("Ya existen las tablas en la base de datos");
		}

		System.out.println();
		// Insert record
		try {
			
			e.insert();
			System.out.println("Los datos de los estudiantes fueron insertados");
			p.insert();
			System.out.println("Los datos de los profesores fueron insertados");
			c.insert();
			System.out.println("Los datos de los cursos fueron insertados");
			m.insert();
			System.out.println("Los datos de las matriculas fueron insertadas");
			
		} catch (Exception e2) {
			System.out.println("Ya existen datos con el mismo ID");
		}
		
		// Report results
		
		System.out.println();
		System.out.println(r.consult());

	}
}
