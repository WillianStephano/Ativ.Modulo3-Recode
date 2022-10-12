package conection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySQL {

	public static Connection createConnectionMySQL() throws Exception {
		
		
		//carrecar a classe pelo JVM
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Conecta com o bd
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway?user=root&password=Macaconu.1");
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		
		//recupera a conecção com o bd
		Connection con = createConnectionMySQL();
		
		//valida se esta conectado
		
		if(con != null) {
			System.out.println(con + "\n Bd conectado");
			con.close();
		}
		
	}
}
