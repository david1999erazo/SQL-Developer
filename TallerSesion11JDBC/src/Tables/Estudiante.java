package Tables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Estudiante {

	private Connection con;

	public Estudiante(Connection c) {
		con = c;
	}

	public void create_table() throws Exception {
		PreparedStatement stmt = con.prepareStatement("CREATE TABLE Estudiante (" + "codigo VARCHAR2(50 CHAR) NOT NULL,"
				+ "nombre VARCHAR2(50 CHAR) NOT NULL," + "nombre_programa VARCHAR2(50 CHAR) NOT NULL,"
				+ "promedio_acumulado NUMBER NOT NULL," + "fecha_nacimiento DATE NOT NULL," + "PRIMARY KEY (codigo))");
		stmt.execute();
		System.out.println("Table created");
	}

	public void drop_table() throws Exception {
		PreparedStatement stmt = con.prepareStatement("DROP TABLE Estudiante");
		stmt.execute();
		System.out.println("Table deleted");
	}

	public void insert() throws Exception {

		BufferedReader br = new BufferedReader(new FileReader(new File("./sources/Estudiantes.txt")));
		String line = br.readLine();

		while (line != null) {
			add(line.split(","));
			line = br.readLine();
		}

		System.out.println("finish");
	}

	public void add(String[] data) {
		String sentence = "INSERT INTO Estudiante VALUES (" + data[0] + "," + data[1] + "," + data[2] + "," + data[3]
				+ "," + data[4] + "," + data[5] + ")";
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sentence);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
