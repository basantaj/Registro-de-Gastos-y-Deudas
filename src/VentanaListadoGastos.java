import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaListadoGastos extends JFrame {

	private JPanel contentPane;
	private JTextField añoTxt;
	private JTextField costoTxt;
	private JTextField mayorTxt;
	private JTextField menorTxt;
	private JTextField vendedorTxt;


	public void mostrar() {
		setTitle("Listado de Gastos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JComboBox mesCombo = new JComboBox();
		mesCombo.setModel(new DefaultComboBoxModel(new String[] {"N", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		mesCombo.setEnabled(false);
		mesCombo.setBounds(10, 48, 52, 20);
		contentPane.add(mesCombo);
		
		añoTxt = new JTextField();
		añoTxt.setText("N");
		añoTxt.setEnabled(false);
		añoTxt.setBounds(10, 107, 86, 20);
		contentPane.add(añoTxt);
		añoTxt.setColumns(10);
		
		JPanel costoPanel = new JPanel();
		costoPanel.setBorder(new TitledBorder(null, "Costo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		costoPanel.setBounds(325, 23, 109, 192);
		contentPane.add(costoPanel);
		costoPanel.setLayout(null);
		
		costoTxt = new JTextField();
		costoTxt.setText("N");
		costoTxt.setEnabled(false);
		costoTxt.setBounds(6, 104, 66, 20);
		costoPanel.add(costoTxt);
		costoTxt.setColumns(10);
		
		mayorTxt = new JTextField();
		mayorTxt.setText("N");
		mayorTxt.setEnabled(false);
		mayorTxt.setBounds(6, 165, 66, 20);
		costoPanel.add(mayorTxt);
		mayorTxt.setColumns(10);
		
		menorTxt = new JTextField();
		menorTxt.setText("N");
		menorTxt.setEnabled(false);
		menorTxt.setBounds(6, 45, 66, 20);
		costoPanel.add(menorTxt);
		menorTxt.setColumns(10);
		
		final JCheckBox menorCheck = new JCheckBox("Menor a");
		menorCheck.setBounds(6, 16, 97, 23);
		costoPanel.add(menorCheck);
		menorCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(menorCheck.isSelected()){
					menorTxt.setEnabled(true);
				}else{
					menorTxt.setEnabled(false);
					menorTxt.setText("N");
				}
				
			}
		});
		
		final JCheckBox igualCheck = new JCheckBox("Exactamente");
		igualCheck.setBounds(6, 72, 97, 23);
		costoPanel.add(igualCheck);
		igualCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(igualCheck.isSelected()){
					costoTxt.setEnabled(true);
				}else{
					costoTxt.setEnabled(false);
					costoTxt.setText("N");
				}
				
			}
		});
		
		final JCheckBox mayorCheck = new JCheckBox("Mayor a");
		mayorCheck.setBounds(6, 131, 97, 23);
		costoPanel.add(mayorCheck);
		mayorCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mayorCheck.isSelected()){
					mayorTxt.setEnabled(true);
				}else{
					mayorTxt.setEnabled(false);
					mayorTxt.setText("N");
				}
				
			}
		});
		
		vendedorTxt = new JTextField();
		vendedorTxt.setText("N");
		vendedorTxt.setEnabled(false);
		vendedorTxt.setBounds(10, 168, 86, 20);
		contentPane.add(vendedorTxt);
		vendedorTxt.setColumns(10);
		
		final JComboBox tarjetaCombo = new JComboBox();
		tarjetaCombo.setModel(new DefaultComboBoxModel(new String[] {"N", "Si", "No"}));
		tarjetaCombo.setEnabled(false);
		tarjetaCombo.setBounds(168, 48, 52, 20);
		contentPane.add(tarjetaCombo);
		
		final JComboBox importadoCombo = new JComboBox();
		importadoCombo.setModel(new DefaultComboBoxModel(new String[] {"N", "Si", "No"}));
		importadoCombo.setEnabled(false);
		importadoCombo.setBounds(168, 107, 52, 20);
		contentPane.add(importadoCombo);
		
		final JCheckBox mesCheck = new JCheckBox("Mes");
		mesCheck.setBounds(10, 19, 97, 23);
		contentPane.add(mesCheck);
		mesCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mesCheck.isSelected()){
					mesCombo.setEnabled(true);
				}else{
					mesCombo.setEnabled(false);
					mesCombo.setSelectedItem("N");
				}
				
			}
		});
		
		final JCheckBox añoCheck = new JCheckBox("A\u00F1o");
		añoCheck.setBounds(10, 77, 97, 23);
		contentPane.add(añoCheck);
		añoCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(añoCheck.isSelected()){
					añoTxt.setEnabled(true);
				}else{
					añoTxt.setEnabled(false);
					añoTxt.setText("N");
				}
				
			}
		});
		
		final JCheckBox vendedorCheck = new JCheckBox("Vendedor");
		vendedorCheck.setBounds(10, 138, 97, 23);
		contentPane.add(vendedorCheck);
		vendedorCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(vendedorCheck.isSelected()){
					vendedorTxt.setEnabled(true);
				}else{
					vendedorTxt.setEnabled(false);
					vendedorTxt.setText("N");
				}
				
			}
		});
		
		final JCheckBox tarjetaCheck = new JCheckBox("Tarjeta");
		tarjetaCheck.setBounds(168, 19, 97, 23);
		contentPane.add(tarjetaCheck);
		tarjetaCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tarjetaCheck.isSelected()){
					tarjetaCombo.setEnabled(true);
				}else{
					tarjetaCombo.setEnabled(false);
					tarjetaCombo.setSelectedItem("N");
				}
				
			}
		});
		
		final JCheckBox importadoCheck = new JCheckBox("Importado");
		importadoCheck.setBounds(168, 75, 97, 23);
		contentPane.add(importadoCheck);
		importadoCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(importadoCheck.isSelected()){
					importadoCombo.setEnabled(true);
				}else{
					importadoCombo.setEnabled(false);
					importadoCombo.setSelectedItem("N");
				}
				
			}
		});
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(97, 220, 89, 23);
		contentPane.add(btnListar);
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarGastos mos = new MostrarGastos();
				try {
					mos.mostrar(mesCombo.getSelectedItem().toString(), añoTxt.getText(), costoTxt.getText(), mayorTxt.getText(), menorTxt.getText(), vendedorTxt.getText(), tarjetaCombo.getSelectedItem().toString(), importadoCombo.getSelectedItem().toString());
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(contentPane, "Algo salio mal!", "ERROR", JOptionPane.ERROR_MESSAGE);
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
		btnSalir.setBounds(225, 220, 89, 23);
		contentPane.add(btnSalir);
		
		setVisible(true);
	}

}
