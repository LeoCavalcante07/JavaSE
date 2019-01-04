package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Produto;

public class ProdutoDao {

	private Connection con;
	private PreparedStatement stm;
	
	public ProdutoDao(){
		con = new Conexao().getConexao();
		
	}
	
	public void inserir(Produto produto){
		String sql = "insert into tbl_produto(descricaoProduto, precoProduto)";
		
		
		try {
			stm = con.prepareStatement(sql);
			stm.setString(0, produto.getDescricaoProduto());
			stm.setDouble(1, produto.getPrecoProduto());
			stm.execute();
			stm.close();
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		
	
	}
	
}
