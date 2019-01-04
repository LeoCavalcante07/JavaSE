package main;

import dao.ProdutoDao;
import model.Produto;
import view.ProdutoView;

public class Run {

	public static void main(String[] args) {
		//ProdutoView v = new ProdutoView();
		//v.setVisible(true);
		
		Produto produto = new Produto();
		produto.setDescricaoProduto("impressora");
		produto.setPrecoProduto(100);

		
		ProdutoDao dao = new ProdutoDao();
		dao.inserir(produto);

	}

}
