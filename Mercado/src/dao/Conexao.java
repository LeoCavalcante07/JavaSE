package dao;

import java.sql.Connection;
import java.sql.DriverManager;



public class Conexao {
	
	public Connection getConexao(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/db_mercado", "root", "bcd127");
			
		}catch (Exception erro){
			System.out.println("Houve um erro na  c onexao" );
			throw new RuntimeException("Erro: "+erro);
		}
	}
	
}