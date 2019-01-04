package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Produto;

public class ProdutoDao {

	private Connection con;
	private PreparedStatement stm;
	private ResultSet rs;
	public ArrayList<Produto> listaProdutos = new ArrayList<>();
	
	public ProdutoDao(){
		con = new Conexao().getConexao();
		
	}
	
	public void inserir(Produto produto){
		String sql = "insert into tbl_produto(descricaoProduto, precoProduto) values(?, ?)";
		
		
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, produto.getDescricaoProduto());
			stm.setDouble(2, produto.getPrecoProduto());
			stm.execute();
			stm.close();
			System.out.println("Inserido com sucesso");
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		
	
	}
	
	
	public void deletar(int idProduto){
		String sql = "delete from tbl_produto where idProduto = ?";
		
		
		try {
			stm = con.prepareStatement(sql);
			stm.setInt(1, idProduto);			
			stm.execute();
			stm.close();
			System.out.println("Deletado com sucesso");
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		
	
	}	
	
	
	public void atualizar(Produto produto){
		String sql = "update tbl_produto set descricaoProduto = ?, precoProduto = ? where idProduto = ?";
		
		
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, produto.getDescricaoProduto());
			stm.setDouble(2, produto.getPrecoProduto());
			stm.setInt(3, produto.getIdProduto());
			stm.execute();
			stm.close();
			
			System.out.println("Atualizado com sucesso");
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		
	
	}	
	
	
	public ArrayList<Produto> listarTodos(){
		String sql = "select * from tbl_produto";
		
		
		
		try{
			stm = con.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				Produto produto = new Produto();
				produto.setDescricaoProduto(rs.getString("descricaoProduto"));
				produto.setPrecoProduto(rs.getDouble("precoProduto"));
				produto.setIdProduto(rs.getInt("idProduto"));
				System.out.println(produto.getIdProduto()+", "+produto.getDescricaoProduto()+", "+produto.getPrecoProduto());
				listaProdutos.add(produto);
			}
			
			
		}catch(SQLException e1){
			System.out.println("Erro na listagem");
			e1.printStackTrace();
		}
		
		
		
		return listaProdutos;
	} 
	
	
	
	public ArrayList<Produto> filtro(String pesquisa){
		String sql = "select * from tbl_produto where descricaoProduto like '%?%'";
		
		
		
		try{
			stm = con.prepareStatement(sql);
			stm.setString(1, pesquisa);
			rs = stm.executeQuery();
			while(rs.next()){
				Produto produto = new Produto();
				produto.setDescricaoProduto(rs.getString("descricaoProduto"));
				produto.setPrecoProduto(rs.getDouble("precoProduto"));
				produto.setIdProduto(rs.getInt("idProduto"));
				
				listaProdutos.add(produto);
			}
			
			
		}catch(SQLException e1){
			System.out.println("Erro na listagem");
			e1.printStackTrace();
		}
		
		
		
		return listaProdutos;
	} 
	
}
