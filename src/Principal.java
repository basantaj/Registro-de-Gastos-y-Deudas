
public class Principal {

	public static void main(String[] args) {
		new Conexion().conectar();
		MenuPrincipal menu = new MenuPrincipal();
		menu.mostrar();
		
	}

}
