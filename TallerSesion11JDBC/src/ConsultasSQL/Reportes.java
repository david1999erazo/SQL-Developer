package ConsultasSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Tables.ConexionOracle;

public class Reportes {
	
	
	public String consult() throws SQLException {
		Connection con =  ConexionOracle.getConnection("P09551_1_4", "P09551_1_4_20191");
		Statement stmt = con.createStatement();
		String report = ("************ INICIO REPORTE DE CURSOS POR ESTUDIANTE **************\n");
		String consult = 
		"SELECT e.codigo , e.nombre x , c.nombre y, c.horario, c.salon, p.nombre z FROM Estudiante E "
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
			String n = rs.getString("x");
			String cn = rs.getString("y");
			String h = rs.getString("horario");
			String s = rs.getString("salon");
			String p = rs.getString("z");
			report += (c+"\t"+n+"\t"+cn+"\t"+h+"\t"+s+"\t"+p+"\n");
		}
		
		report += ("******************** FIN REPORTE ********************");
		
		return report;
	}
	
}
