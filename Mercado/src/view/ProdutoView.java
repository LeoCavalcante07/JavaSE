package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
	public JTable tbProdutos;
	public ProdutoDao dao;
	public Produto produto;



	public ProdutoView() {
		
		dao = new ProdutoDao();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 368);
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
		btnLimpar.setBounds(299, 105, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(194, 105, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				produto = new Produto();
				produto.setDescricaoProduto(txtDesc.getText());
				produto.setPrecoProduto(Double.valueOf(txtPreco.getText()));
				dao.inserir(produto);
			}
		});
		btnSalvar.setBounds(398, 105, 89, 23);
		contentPane.add(btnSalvar);
		
		
		tbProdutos = new JTable();
		tbProdutos.setBounds(28, 174, 410, 106);
		contentPane.add(tbProdutos);
		

		
		tbProdutos.setModel(new DefaultTableModel(
			new Object[][] {
				{new Integer(1), "impressora", new Double(100.0)},
				{new Integer(2), "computador", new Double(100.0)},
				{new Integer(4), "notebook", new Double(90.0)},
			},
			new String[] {
				"ID", "Descri\u00E7\u00E3o", "Pre\u00E7o"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		

	}
	
	

	
}
