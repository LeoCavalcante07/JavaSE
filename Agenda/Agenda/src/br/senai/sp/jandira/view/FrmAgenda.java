package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmAgenda extends JFrame {

	private JPanel painelPrincipal;
	private JTable tableContatos;
	JScrollPane scrollTabela;
	JPanel painelTabela;
	
	public FrmAgenda() {
		setTitle("Agenda de Contatos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(new Color(0, 0, 0));
		painelTitulo.setBounds(0, 0, 434, 55);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		JLabel lblAgenda = new JLabel("    Agenda");
		lblAgenda.setForeground(new Color(245, 245, 245));
		lblAgenda.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/agenda.png")));
		lblAgenda.setFont(new Font("Chiller", Font.BOLD, 30));
		lblAgenda.setBounds(53, 11, 178, 33);
		painelTitulo.add(lblAgenda);
		
		painelTabela = new JPanel();
		painelTabela.setBorder(new TitledBorder(null, "Meus Contatos: ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		painelTabela.setBounds(10, 66, 414, 184);
		painelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);
		
		
		
		
		/*
		tableContatos = new JTable();
		tableContatos.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "", ""},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID", "NOME", "E-MAIL"
			}
		));
		scrollTabela.setViewportView(tableContatos);
		*/
		 
		
	}
	
	
	public void criarTabela(){
		scrollTabela = new JScrollPane();
		scrollTabela.setBounds(23, 21, 369, 152);
		painelTabela.add(scrollTabela);
		
		
		DefaultTableModel modeloTabela = new DefaultTableModel();
		Object[] linhas = new Object[3];
		
		int i = 0;
		while(i<5){
			linhas[0] = "1";
			linhas[1] = "Maria";
			linhas[2] = "maria@uol.com";
			modeloTabela.addRow(linhas);
			i++;
		}
		
		
		String[] titulo = {"ID", "NOME", "E-MAIL"};
		
		modeloTabela.setColumnIdentifiers(titulo);
		
		tableContatos.setModel(modeloTabela);
		
		
		
		
	}
	
	
	
	
}
