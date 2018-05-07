
public class Deposito {

	private int ocupacion;
	private int ocupacionMaxima;
	
	public Deposito(int ocupacion, int ocupacionMaxima) {
		super();
		this.ocupacion = ocupacion;
		this.ocupacionMaxima = ocupacionMaxima;
	}
	
	public boolean puedeAlmacenar(int bultos) {
		return bultos<=(ocupacionMaxima-ocupacion);
	}
	
	public void almacenar(int bultos){
		this.ocupacion=this.ocupacion+bultos;
	}

}
