import java.util.ArrayList;

public class Capitan {
	
	private String nombre;
	private Buke buke;
	
	public String getNombre() {
		return nombre;
	}
	
	public Buke getBuke() {
		return buke;
	}
	
	public Capitan(String nombre, Buke buke) {
		super();
		this.nombre = nombre;
		this.buke = buke;
	}
	
	public void avisarArribo(Puerto puerto,ArrayList<Servicio>servicios,LLegada llegada,int personalArribo){
		puerto.registrarArribo(this,servicios,llegada,personalArribo);
	}

	
}
