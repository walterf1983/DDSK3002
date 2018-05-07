
public class Bunker extends Servicio{

	private boolean servicioDisponible;
	
	public Bunker(int personalNecesario,boolean servicioDisponible) {
		super(personalNecesario);
		this.servicioDisponible=servicioDisponible;
	}

	@Override
	public boolean operar(Puerto puerto) {
		if(servicioDisponible){
			System.out.println("Puede cargar combustible");
		}else{
			System.out.println("No puede cargar combustible");
		}
		return servicioDisponible;
	}

}
