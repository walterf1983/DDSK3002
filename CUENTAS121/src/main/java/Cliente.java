import java.util.ArrayList;
import java.util.stream.Collectors;

public class Cliente extends Item {
	
	private ArrayList<Cuenta>cuentas;
	private String dni;
	
	public Cliente(double saldo, String dni) {
		super(dni);
		this.cuentas =new ArrayList<Cuenta>();
		this.dni = dni;
	}

	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public ArrayList<Cuenta> getCuentasConSaldoMayorA(double saldo) {
		return   this.cuentas
				.stream()
				.filter(cuenta->cuenta.SaldoMayorA(saldo))
				.collect(Collectors.toCollection(ArrayList::new));
	}
	

}
