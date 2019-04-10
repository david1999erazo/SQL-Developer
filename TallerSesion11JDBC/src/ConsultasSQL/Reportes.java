package ConsultasSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Tables.ConexionOracle;

public class Reportes {
	
	
	public void consult() throws SQLException {
		Connection con =  ConexionOracle.getConnection("P09551_1_4", "P09551_1_4_20191");
		Statement stmt = con.createStatement();
		
		String consult = 
		"SELECT e.codigo , e.nombre , c.nombre, c.horario, c.salon, p.nombre FROM Estudiante E "
		+"INNER JOIN Matricula M "
		+"ON e.codigo = m.estudiante "
		+"INNER JOIN curso C "
		+"ON m.curso = c.codigo "
		+"INNER JOIN profesor P "
		+"ON c.profesor = p.codigo "
		+"ORDER BY e.nombre";
		
		ResultSet rs = stmt.executeQuery(consult);
		
		while (rs.next()) {
			String c = rs.getString("codigo");
			String n = rs.getString("nombre");
			String cn = rs.getString("nombre");
			String h = rs.getString("horario");
			String s = rs.getString("salon");
			String p = rs.getString("nombre");
			System.out.println(c+","+n+","+cn+","+h+","+s+","+p);
			}
		
	}
	
	public static void main(String[] args) {
		Reportes r = new Reportes();
		try {
			r.consult();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
