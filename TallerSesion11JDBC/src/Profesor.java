import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Profesor {
	private Connection con;
	public Profesor() {
		con =  ConexionOracle.getConnection("P09551_1_4", "P09551_1_4_20191");
	} 
	public void create_table() throws Exception {
		PreparedStatement stmt = con.prepareStatement(
				"CREATE TABLE Profesor("
					    +"codigo NUMBER NOT NULL,"
					    +"nombre VARCHAR2 (50 CHAR) NOT NULL,"
					    +"departamento NUMBER NOT NULL,"
					    +"PRIMARY KEY (codigo))"
				
				);
		stmt.execute();
		System.out.println("Table created");
	}

	public void drop_table() throws Exception {
		PreparedStatement stmt = con.prepareStatement("DROP TABLE Profesor");
		stmt.execute();
		System.out.println("Table deleted");
	}

	public void insert() throws Exception{
		
		BufferedReader br = new BufferedReader(new FileReader(new File("./sources/Profesores.txt")));
		String line = br.readLine();
		
		while(line!=null) {
			add(line.split(","));
			line = br.readLine();
		}
		
		System.out.println("finish");
	}

	public void add(String[] data) {
		String sentence = "INSERT INTO Profesor VALUES ("+data[0]+","+data[1]+","+data[2]+")";	
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sentence);
			stmt.execute();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Profesor p = new Profesor();
		try {
			
			p.create_table();
			p.insert();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
