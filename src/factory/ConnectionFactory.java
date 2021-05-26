package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory {
	
	//Nome do user no workbench
	private static final String USERNAME = "root";
	
	private static final String PASSWORD = "";
	
	//caminho db, port
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/produto";
	
	
	/*
	 * conexão com o banco
	 * */

	public static Connection createConnectionToMySQL() throws Exception {
		
		//faz com o que a classe seja carregada pela JVM
		Class.forName("com.mysql.jdbc.Driver");
			
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	
		return connection;
	}
	
	public static void main(String[] args) throws Exception {

		Connection con = createConnectionToMySQL();
		
		if(con!=null) {
			System.out.println("Conexão obtida com sucesso!");
		con.close();
		}
	
	}
}
	

