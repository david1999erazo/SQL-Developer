package Tables;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Matricula {
	private Connection con;
	public Matricula() {
		con =  ConexionOracle.getConnection("P09551_1_4", "P09551_1_4_20191");
	} 
	public void create_table() throws Exception {
		PreparedStatement stmt = con.prepareStatement(
	
				"CREATE TABLE Matricula ("
					    +"estudiante VARCHAR2(50 CHAR) NOT NULL,"
					    +"curso NUMBER NOT NULL,"
					    +"PRIMARY KEY (estudiante, curso),"
					    +"FOREIGN KEY (estudiante) REFERENCES Estudiante,"
					    +"FOREIGN KEY (curso) REFERENCES Curso)"
				
				);
		stmt.execute();
		System.out.println("Table created");
	}

	public void drop_table() throws Exception {
		PreparedStatement stmt = con.prepareStatement("DROP TABLE Matricula");
		stmt.execute();
		System.out.println("Table deleted");
	}

	public void insert() throws Exception{
		
		BufferedReader br = new BufferedReader(new FileReader(new File("./sources/Matriculas.txt")));
		String line = br.readLine();
		
		while(line!=null) {
			add(line.split(","));
			line = br.readLine();
		}
		
		System.out.println("finish");
	}

	public void add(String[] data) {
		String sentence = "INSERT INTO Matricula VALUES ("+data[0]+","+data[1]+")";	
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sentence);
			stmt.execute();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Matricula m = new Matricula();
		try {
			m.create_table();
			m.insert();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
