import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaListadoDeudas extends JFrame {

	private JPanel contentPane;
	private JTextField añoTxt;
	private JTextField segundoTxt;

	
	public void mostrar() {
		setTitle("Listado de Deudas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 200, 357, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		añoTxt = new JTextField();
		añoTxt.setText("No");
		añoTxt.setEnabled(false);
		añoTxt.setBounds(96, 112, 53, 20);
		contentPane.add(añoTxt);
		añoTxt.setColumns(10);
		
		segundoTxt = new JTextField();
		segundoTxt.setText("No");
		segundoTxt.setEnabled(false);
		segundoTxt.setBounds(169, 112, 75, 20);
		contentPane.add(segundoTxt);
		segundoTxt.setColumns(10);
		
		final JComboBox deudorCombo = new JComboBox();
		deudorCombo.setEnabled(false);
		deudorCombo.setModel(new DefaultComboBoxModel(new String[] {"No", "Yo", "Otro"}));
		deudorCombo.setBounds(263, 112, 53, 20);
		contentPane.add(deudorCombo);
		
		final JComboBox mesCombo = new JComboBox();
		mesCombo.setEnabled(false);
		mesCombo.setModel(new DefaultComboBoxModel(new String[] {"No", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		mesCombo.setBounds(19, 112, 53, 20);
		contentPane.add(mesCombo);
		
		final JCheckBox mesCheck = new JCheckBox("Mes");
		mesCheck.setBounds(19, 65, 59, 23);
		contentPane.add(mesCheck);
		mesCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mesCheck.isSelected()){ 
					mesCombo.setEnabled(true);
				}else{
					mesCombo.setEnabled(false); 
					mesCombo.setSelectedItem("No");
					}
				
			}
		});
		
		final JCheckBox anioCheck = new JCheckBox("A\u00F1o");
		anioCheck.setBounds(96, 65, 59, 23);
		contentPane.add(anioCheck);
		anioCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(anioCheck.isSelected()){ 
					añoTxt.setEnabled(true);
				}else{
					añoTxt.setEnabled(false); 
					añoTxt.setText("No");
					}
				
				
			}
		});
		
		final JCheckBox deudorCheck = new JCheckBox("Deudor");
		deudorCheck.setBounds(263, 65, 82, 23);
		contentPane.add(deudorCheck);
		deudorCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(deudorCheck.isSelected()){ 
					deudorCombo.setEnabled(true);
				}else{
					deudorCombo.setEnabled(false); 
					deudorCombo.setSelectedItem("No");
					}
				
			}
		});
		
		final JCheckBox segundoCheck = new JCheckBox("Segundo");
		segundoCheck.setBounds(169, 65, 92, 23);
		contentPane.add(segundoCheck);
		segundoCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(segundoCheck.isSelected()){ 
					segundoTxt.setEnabled(true);
				}else{
					segundoTxt.setEnabled(false); 
					segundoTxt.setText("No");
					}
				
			}
		});
		
		
		
		
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(73, 205, 89, 23);
		contentPane.add(btnListar);
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarDeudas mos = new MostrarDeudas();
				try {
					mos.mostrar(mesCombo.getSelectedItem().toString(),añoTxt.getText(),segundoTxt.getText(),deudorCombo.getSelectedItem().toString());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(193, 205, 89, 23);
		contentPane.add(btnSalir);
		
		JLabel lblFiltros = new JLabel("Filtros:");
		lblFiltros.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFiltros.setBounds(19, 11, 322, 39);
		contentPane.add(lblFiltros);
		
		setVisible(true);
	}

}
