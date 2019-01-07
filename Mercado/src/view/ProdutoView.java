package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.ProdutoDao;
import model.Produto;
import table.ProdutoTableModel;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProdutoView extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtDesc;
	private JTextField txtPreco;
	public ProdutoDao dao;
	public Produto produto;
	public ProdutoTableModel modeloTabela;
	public ArrayList<Produto> produtos;
	
	private JTextField txtFiltro;



	public ProdutoView() {
		
		dao = new ProdutoDao();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 417);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDesc = new JLabel("Descri\u00E7\u00E3o:");
		lblDesc.setBounds(28, 49, 58, 14);
		contentPane.add(lblDesc);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setEnabled(false);
		lblCodigo.setBounds(28, 24, 46, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		lblPreco.setBounds(28, 77, 46, 14);
		contentPane.add(lblPreco);
		
		txtId = new JTextField();
		txtId.setBounds(83, 18, 355, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtDesc = new JTextField();
		txtDesc.setColumns(10);
		txtDesc.setBounds(83, 46, 355, 20);
		contentPane.add(txtDesc);
		
		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		txtPreco.setBounds(83, 74, 355, 20);
		contentPane.add(txtPreco);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(232, 105, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(133, 105, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				produto = new Produto();
				produto.setDescricaoProduto(txtDesc.getText());
				produto.setPrecoProduto(Double.valueOf(txtPreco.getText()));
				dao.inserir(produto);
				criarTabela();
			}
		});
		btnSalvar.setBounds(331, 105, 89, 23);
		contentPane.add(btnSalvar);
		

		produtos = dao.listarProdutos();
		criarTabela(produtos);

		JLabel lblFiltrar = new JLabel("Filtrar:");
		lblFiltrar.setBounds(28, 326, 40, 14);
		contentPane.add(lblFiltrar);
		
		txtFiltro = new JTextField();
		txtFiltro.setBounds(65, 323, 297, 20);
		contentPane.add(txtFiltro);
		txtFiltro.setColumns(10);
		
		JButton btnFiltrar = new JButton("GO");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String filtro = txtFiltro.getText();
				
				produtos.removeAll(produtos);//limpa o array
				
				produtos = dao.listarProdutos(filtro);
			
				criarTabela(produtos);
				
			}
		});
		btnFiltrar.setBounds(367, 322, 70, 23);
		contentPane.add(btnFiltrar);
		

	}
	
	
	public void criarTabela(ArrayList<Produto> produtos){
		
		
		
		JTable tbProdutos = new JTable();
		tbProdutos.setBounds(30, 153, 408, 144);
		JScrollPane scrollTabela = new JScrollPane(tbProdutos);
		scrollTabela.setBounds(30, 153, 408, 144);
		contentPane.add(scrollTabela);
		
		


				
		modeloTabela = new ProdutoTableModel(produtos);
		tbProdutos.setModel(modeloTabela);

	}
	
	
	public void criarTabela(){
		
		produtos = dao.listarProdutos();
		
		JTable tbProdutos = new JTable();
		tbProdutos.setBounds(30, 153, 408, 144);
		JScrollPane scrollTabela = new JScrollPane(tbProdutos);
		scrollTabela.setBounds(30, 153, 408, 144);
		contentPane.add(scrollTabela);
		
		
		//modeloTabela.fireTableRowsInserted(tbProdutos.get, lastRow);

				
		modeloTabela = new ProdutoTableModel(produtos);
		tbProdutos.setModel(modeloTabela);

	}
	
	
}
