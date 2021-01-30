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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class VentanaIngresoDeuda extends JFrame {

	private JPanel contentPane;
	private JTextField segundoTxt;
	private JTextField deudaTxt;
	private JTextField fechaDeuTxt;
	private JTextField resolucionTxt;
	private boolean resuelto;

	
	
	public void mostrar() {
		setTitle("Ingreso de Deudas");
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
		
		final JComboBox deudorCombo = new JComboBox();
		deudorCombo.setModel(new DefaultComboBoxModel(new String[] {"Yo", "Otro"}));
		deudorCombo.setBounds(234, 101, 67, 20);
		contentPane.add(deudorCombo);
		
		JButton confirmarBtn = new JButton("Confirmar");
		confirmarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IngresoDeuda in = new IngresoDeuda();
				if(confirmarEntrada(segundoTxt.getText(), deudaTxt.getText(), fechaDeuTxt.getText(), resolucionTxt.getText())){
					try {
						in.agregarDeuda(segundoTxt.getText(), deudaTxt.getText(),deudorCombo.getSelectedItem().toString() , fechaDeuTxt.getText(), resolucionTxt.getText(),resuelto);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "ERROR, PUEDE QUE LA ENTRADA YA EXISTA", "ERROR", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
					
					System.out.println("BIEN!");
				}
			}
		});
		confirmarBtn.setBounds(100, 221, 105, 23);
		contentPane.add(confirmarBtn);
		
		JButton cancelarBtn = new JButton("Cancelar");
		cancelarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelarBtn.setBounds(213, 221, 107, 23);
		contentPane.add(cancelarBtn);
		
		JButton btnL = new JButton("L");
		btnL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaListadoDeudas lis = new VentanaListadoDeudas();
				lis.mostrar();
			}
		});
		btnL.setBounds(379, 171, 47, 38);
		contentPane.add(btnL);
		
		JLabel lblIngresoDeGasto = new JLabel("INGRESO DE DEUDAS(ACLARAR MONTO)");
		lblIngresoDeGasto.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblIngresoDeGasto.setBounds(20, 11, 414, 44);
		contentPane.add(lblIngresoDeGasto);
		
		
		
		resolucionTxt = new JTextField();
		resolucionTxt.setEditable(false);
		resolucionTxt.setText("null");
		resolucionTxt.setBounds(29, 160, 86, 20);
		contentPane.add(resolucionTxt);
		resolucionTxt.setColumns(10);
		
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
