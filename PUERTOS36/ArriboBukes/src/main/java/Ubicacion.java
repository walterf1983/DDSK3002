import java.util.ArrayList;

public class Ubicacion {

	private ArrayList<Zona>zonas=new ArrayList<Zona>();
	private String identrificador;
	
	
	public Ubicacion(ArrayList<Zona> zonas, String identrificador) {
		super();
		this.zonas = zonas;
		this.identrificador = identrificador;
	}

	public ArrayList<Zona> getZonas() {
		return zonas;
	}

	public void recorrerZonasDe(String identificadorUbicacion){
		System.out.println("UBICACION:"+identificadorUbicacion);
		zonas.stream().forEach(zona->zona.dameZonaDe(identificadorUbicacion));
	}

	public String getIdentrificador() {
		return identrificador;
	}

}
