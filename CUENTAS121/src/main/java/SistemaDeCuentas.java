import java.util.Scanner;

public class SistemaDeCuentas {

	public static void main(String[] args) {
		Scanner consola=new Scanner(System.in);
		Sistema sistemaControl=new Sistema();
		sistemaControl.start("Clientes1");
		
		//Carga de la Base
		System.out.println("Desea Cambiar de Base de datos si/enter u otro");
		if(consola.nextLine().equalsIgnoreCase("si")){
			System.out.println("Ingrese el nombre de la base de datos");
			sistemaControl.changePath(consola.nextLine());
		};
	
		//Sistema de Cuentas
		System.out.println("BASE JSON");
		System.out.println(sistemaControl.volcarBaseDeDatos());
		System.out.println("BIENVENIDO AL SISTEMA DE CUENTAS");
		System.out.println("");
		System.out.println("Ingrese el dni del cliente");
		String dni=consola.nextLine();
		System.out.println("Ingrese el saldo de comparacion");
		String saldo=consola.nextLine();
		System.out.println(sistemaControl.contarCuentasDeClienteConSaldoMayorA(dni, Double.parseDouble(saldo)));
		
		}

}
