package Tables;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionOracle {

	
	

	
	
	public static Connection getConnection(String username, String password) {
		System.out.println("-------- Prueba de Registro de Oracle JDBC ------");
		Connection con = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection
				("jdbc:Oracle:thin:@//200.3.193.24:1522/ESTUD",username,password);
		} catch (Exception e) {
		System.out.println("¡Oracle JDBC Driver no encontrado!");
		e.printStackTrace();
		
		}
		System.out.println("¡Oracle JDBC Driver Registrado!");
		
		return con;
	}
	

	public static void main(String[] args) {
		
	}
	
	
}
