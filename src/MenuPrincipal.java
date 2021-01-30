import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup grupoRadio = new ButtonGroup();
	private String opcion="";
	
	SystemTray tray;
	ImageIcon icono = new ImageIcon("recursos/icono.png");
	Image img = icono.getImage();
	
	
	public void barraHerramientas(){
		if(SystemTray.isSupported()){
			final TrayIcon iconoBarra = new TrayIcon(img);
			iconoBarra.setToolTip("Organizador de plata");
			iconoBarra.setPopupMenu(null); /// TODO POPUP MENU
			iconoBarra.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MenuPrincipal.this.setVisible(true);
					MenuPrincipal.this.setExtendedState(MenuPrincipal.NORMAL);
					SystemTray.getSystemTray().remove(iconoBarra);
					
				}
			});
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowIconified(WindowEvent e) {
					MenuPrincipal.this.setVisible(false);
					try {
						SystemTray.getSystemTray().add(iconoBarra);
					} catch (AWTException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}

				
			});
			
			
		}
		
	}
	
	public void mostrar() {
		
		setResizable(false);
		setIconImage(img);
		setTitle("LA PLATA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 433, 169);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccion = new JLabel("ACCION:");
		lblAccion.setBounds(185, 9, 72, 20);
		contentPane.add(lblAccion);
		
		JRadioButton ingresoRadio = new JRadioButton("Ingreso");
		grupoRadio.add(ingresoRadio);
		ingresoRadio.setBounds(48, 36, 78, 23);
		contentPane.add(ingresoRadio);
		ingresoRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcion="INGRESO";

			}
		});
		
		JRadioButton bajaRadio = new JRadioButton("Baja");
		grupoRadio.add(bajaRadio);
		bajaRadio.setBounds(138, 36, 64, 23);
		contentPane.add(bajaRadio);
		bajaRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcion="BAJA";
				
			}
		});
		
		JRadioButton modRadio = new JRadioButton("Modificaci\u00F3n");
		grupoRadio.add(modRadio);
		modRadio.setBounds(203, 36, 107, 23);
		contentPane.add(modRadio);
		modRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcion="MODIFICACION";
				
			}
		});
		
		JRadioButton listaRadio = new JRadioButton("Listado");
		grupoRadio.add(listaRadio);
		listaRadio.setBounds(309, 36, 78, 23);
		contentPane.add(listaRadio);
		listaRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcion="LISTADO";
				
			}
		});
		
		JButton gastosBtn = new JButton("Gastos");
		gastosBtn.setBounds(88, 80, 89, 23);
		contentPane.add(gastosBtn);
		gastosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(opcion){
				
				case "INGRESO":
					VentanaIngresoGasto venIG = new VentanaIngresoGasto();
					venIG.mostrar();
					break;
				case "BAJA":
					VentanaBajaGasto venBG = new VentanaBajaGasto();
					venBG.mostrar();
					break;
				case "MODIFICACION":
					VentanaModGasto venMG=new VentanaModGasto();
					venMG.mostrar();
					break;
				case "LISTADO":
					VentanaListadoGastos venLG=new VentanaListadoGastos();
					venLG.mostrar();
					break;
				default:
					JOptionPane.showMessageDialog(contentPane, "Elija una opcion", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					break;
				}

			}
		});
		
		JButton deudasBtn = new JButton("Deudas");
		deudasBtn.setBounds(241, 80, 89, 23);
		contentPane.add(deudasBtn);
		deudasBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(opcion+" de Deudas");
				switch(opcion){
				
				case "INGRESO":
					VentanaIngresoDeuda venID = new VentanaIngresoDeuda();
					venID.mostrar();
					break;
				case "BAJA":
					VentanaBajaDeuda venBD= new VentanaBajaDeuda();
					venBD.mostrar();
					break;
				case "MODIFICACION":
					VentanaModDeuda venMD=new VentanaModDeuda();
					venMD.mostrar();
					break;
				case "LISTADO":
					VentanaListadoDeudas venLD = new VentanaListadoDeudas();
					venLD.mostrar();
					break; 
				default:
					JOptionPane.showMessageDialog(contentPane, "Elija una opcion", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					break;
				
				}
				
			}
		});
		
		barraHerramientas();
		setVisible(true);
	}
}
