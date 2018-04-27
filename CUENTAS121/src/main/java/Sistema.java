import java.util.ArrayList;
import java.util.stream.Collectors;

public class Sistema {
	
	private ArrayList<Cliente> clientes;
	private Repositorio repositorio;

	public Sistema() {
		super();
		this.clientes =new ArrayList<Cliente>();
	}
	
	public void start(String pathFile){
		this.repositorio=new Repositorio(pathFile);
		this.clientes=this.repositorio.getAllItem().
				stream()
				.map(i->(Cliente)i)
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public void changePath(String pathFile){
		this.repositorio.changePath(pathFile);
	}
	
	public Cliente buscarCliente(String dni){
		
		return  (Cliente)this.repositorio.buscarItem(dni);
	}
	
	public int contarCuentasDeClienteConSaldoMayorA(String dni,double saldo){
		Cliente cliente=buscarCliente(dni);
		ArrayList<Cuenta>cuentas=cliente.getCuentasConSaldoMayorA(saldo);
		System.out.println("\nLa cantidad de cuentas ue superan ese monto son:");
		return cuentas.size();
		
	}


	public String volcarBaseDeDatos(){
		return this.repositorio.getAll();
	}

}

