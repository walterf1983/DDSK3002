
public class Cuenta {

	private double saldo;
	private int numero;
	
	public Cuenta(double saldo, int numero){
		this.saldo=saldo;
		this.numero=numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public boolean SaldoMayorA(double saldo) {
		return this.saldo>saldo;
	}
	
}
