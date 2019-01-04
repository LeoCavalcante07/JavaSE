package dao;

import java.sql.Connection;
import java.sql.DriverManager;



public class Conexao {
	
	public static Connection con;
	
	public Connection getConexao(){
		
		con = null;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =  DriverManager.getConnection("jdbc:mysql://localhost/db_mercado?useTimezone=true&serverTimezone=UTC", "root", "bcd127");
			
		}catch (Exception erro){
			System.out.println("Houve um erro na  conexao" );
			throw new RuntimeException("Erro: "+erro);
		}
		
		return con;
	}
	
}
