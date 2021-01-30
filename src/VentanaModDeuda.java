import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaModDeuda extends JFrame {


	private JPanel contentPane;
	private JTextField segundoTxt;
	private JTextField deudaTxt;
	private JTextField fechaDeuTxt;
	private JTextField resolucionTxt;
	private boolean resuelto;


	
	public void mostrar() {
		setTitle("Modificacion de Deudas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 466, 300);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		segundoTxt = new JTextField();
		segundoTxt.setBounds(10, 101, 118, 20);
		contentPane.add(segundoTxt);
		segundoTxt.setColumns(10);
		
		deudaTxt = new JTextField();
		deudaTxt.setBounds(138, 101, 86, 20);
		contentPane.add(deudaTxt);
		deudaTxt.setColumns(10);
		
		fechaDeuTxt = new JTextField();
		fechaDeuTxt.setBounds(330, 101, 104, 20);
		contentPane.add(fechaDeuTxt);
		fechaDeuTxt.setColumns(10);
		
		JLabel lblCompra = new JLabel("Segundo:");
		lblCompra.setLabelFor(segundoTxt);
		lblCompra.setBounds(10, 76, 91, 14);
		contentPane.add(lblCompra);
		
		JLabel lblCosto = new JLabel("Deuda:");
		lblCosto.setBounds(138, 76, 67, 14);
		contentPane.add(lblCosto);
		
		JLabel lblCosto_1 = new JLabel("Deudor:");
		lblCosto_1.setBounds(234, 76, 46, 14);
		contentPane.add(lblCosto_1);
		
		JLabel lblVendedor = new JLabel("Fecha Deuda:");
		lblVendedor.setLabelFor(fechaDeuTxt);
		lblVendedor.setBounds(330, 76, 91, 14);
		contentPane.add(lblVendedor);
		
		final JCheckBox resolucionCheck = new JCheckBox("Resuelta:");
		resolucionCheck.setBounds(20, 128, 97, 23);
		contentPane.add(resolucionCheck);
		
		
		resolucionCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(resolucionCheck.isSelected()){
					resolucionTxt.setEditable(true);
					resuelto=true;
				}else{
					resolucionTxt.setEditable(false);
					resuelto=false;
					resolucionTxt.setText("null");}
				
			}
		});
		
		
		final JComboBox deudorCombo = new JComboBox();
		deudorCombo.setModel(new DefaultComboBoxModel(new String[] {"Yo", "Otro"}));
		deudorCombo.setBounds(234, 101, 67, 20);
		contentPane.add(deudorCombo);
		
		final JButton modificarBtn = new JButton("Modificar");
		modificarBtn.setEnabled(false);
		modificarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarDeuda bu = new BuscarDeuda();
				ModDeuda mo = new ModDeuda();
				try {
					if (bu.buscar(deudaTxt.getText(),fechaDeuTxt.getText())){
					mo.modificar(segundoTxt.getText(), deudaTxt.getText(), deudorCombo.getSelectedItem().toString(), fechaDeuTxt.getText(), resolucionTxt.getText(), resuelto);
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		modificarBtn.setBounds(60, 221, 105, 23);
		contentPane.add(modificarBtn);
		
		JButton buscarBtn = new JButton("Buscar");
		buscarBtn.setBounds(175, 221, 115, 23);
		buscarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!deudaTxt.getText().equals("")&&!fechaDeuTxt.getText().equals("")){
					BuscarDeuda bu = new BuscarDeuda();
					if(bu.buscar(deudaTxt.getText(), fechaDeuTxt.getText())){
					segundoTxt.setText(bu.segundo);
					deudorCombo.setSelectedItem(bu.deudor);
					resolucionTxt.setText(bu.fechaResolucion);
					
					if(!resolucionTxt.getText().equals("")){
					resolucionCheck.setSelected(true);
					resuelto=true;
				
					}else{resuelto=false; resolucionCheck.setSelected(false);}
					
					modificarBtn.setEnabled(true);
					System.out.println(resuelto);
					}
				}else{
					JOptionPane.showMessageDialog(contentPane, "Rellene los campos de deuda y fecha!", "ERROR DE ENTRADA", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		contentPane.add(buscarBtn);
		
		JButton cancelarBtn = new JButton("Cancelar");
		cancelarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelarBtn.setBounds(300, 221, 107, 23);
		contentPane.add(cancelarBtn);
		
		JLabel lblIngresoDeGasto = new JLabel("MODIFICACION DE DEUDAS");
		lblIngresoDeGasto.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresoDeGasto.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblIngresoDeGasto.setBounds(10, 11, 367, 44);
		contentPane.add(lblIngresoDeGasto);
		
		
		
		resolucionTxt = new JTextField();
		resolucionTxt.setEditable(false);
		resolucionTxt.setText("null");
		resolucionTxt.setBounds(29, 160, 86, 20);
		contentPane.add(resolucionTxt);
		resolucionTxt.setColumns(10);
		
		JButton btnL = new JButton("L");
		btnL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaListadoDeudas lis = new VentanaListadoDeudas();
				lis.mostrar();
				// TODO LISTADO DE DEUDAS
			}
		});
		btnL.setBounds(387, 172, 47, 38);
		contentPane.add(btnL);
		
		
		setVisible(true);
	}
	
	public boolean confirmarEntrada(String segundo, String deuda, String fechaD, String fechaR){
		if(!segundo.equals("")&&!deuda.equals("") && !fechaD.equals("") && !fechaR.equals("")){
			if(esFecha(fechaD)){
				if(!fechaR.equals("null")){
					if(esFecha(fechaR)){
						return true;
					}
					
				}
				return true;
			}
			
		}else{
			JOptionPane.showMessageDialog(null, "RELLENAR TODOS LOS CAMPOS", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return false;
	}
	
	

	
	private boolean esFecha(String fc){
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		df.setLenient(false);
		try {

			Date d = df.parse(fc);
			System.out.println("Fecha correcta!");
			System.out.println(fc);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Revise las fechas!", "ERROR DE FORMATO", JOptionPane.ERROR_MESSAGE);
			return false;

		}
		return true;
	}


}
