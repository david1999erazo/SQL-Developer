import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class Estudiante {
	
	private Connection con;
	public Estudiante() {
		con =  ConexionOracle.getConnection("P09551_1_4", "P09551_1_4_20191");
	} 
	public void create_table() throws Exception {
		PreparedStatement stmt = con.prepareStatement("CREATE TABLE Estudiante (codigo VARCHAR2(50 CHAR) NOT NULL,"
				+ "nombre VARCHAR2(50 CHAR) NOT NULL,nombre_programa VARCHAR2(50 CHAR) NOT NULL,"
				+ "promedio_acumulado NUMBER NOT NULL,fecha_nacimiento DATE NOT NULL,PRIMARY KEY (codigo))");
		stmt.execute();
	}

	public void drop_table() throws Exception {
		PreparedStatement stmt = con.prepareStatement("DROP TABLE Estudiante");
		stmt.execute();
	}

	public void insert(String codigo,String nombre,String nombre_programa,
			double promedio_acumaulado,Date fecha_Nacimiento) throws Exception{
		
		String x = "INSERT INTO Estudiante"+
				"VALUES('"+codigo+"','"+nombre+"','"+nombre_programa+"','"+promedio_acumaulado+"','"+fecha_Nacimiento+"))";

		PreparedStatement stmt = con.prepareStatement(x);
		stmt.execute();
	}

	public static void main(String[] args) {
		Estudiante e = new Estudiante();
		try {
			e.drop_table();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
