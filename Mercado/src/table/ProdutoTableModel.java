package table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Produto;

public class ProdutoTableModel extends AbstractTableModel{
	
	public static final int COL_ID_PRODUTO = 0;
	public static final int COL_DESCRICAO_PRODUTO = 1;
	public static final int COL_PRECO_PRODUTO = 2;
	
	public ArrayList<Produto> listaProdutos;
	
	public  ProdutoTableModel(ArrayList<Produto>lista) {
		listaProdutos = new ArrayList<Produto>(lista);
		
		//listaProdutos.removeAll(listaProdutos);
		
	}
	

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return listaProdutos.size();
	}

	@Override
	public Object getValueAt(int linhas, int colunas) {
		Produto produto = listaProdutos.get(linhas);
		if(colunas == COL_ID_PRODUTO){
			return produto.getIdProduto();
			
		}if(colunas == COL_DESCRICAO_PRODUTO){
			return produto.getDescricaoProduto();
		}if(colunas == COL_PRECO_PRODUTO){
			return produto.getPrecoProduto();
		}
		return "";
		
			
		
	}

	@Override
	public String getColumnName(int colunas){
		if(colunas == COL_ID_PRODUTO){
			return "ID";
			
		}if(colunas == COL_DESCRICAO_PRODUTO){
			return "Descrição";
		}if(colunas == COL_PRECO_PRODUTO){
			return "Preço";
		}
			return "";
		
	}
	
}
