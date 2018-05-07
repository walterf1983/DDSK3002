import java.util.ArrayList;

public class Zona {

	private double anchoPermitido;
	private double altoPermitido;
	private String descripcion;
	private String identificador;
	
	public Zona(double anchoPermitido, double altoPermitido, String descripcion, String identificador) {
		super();
		this.anchoPermitido = anchoPermitido;
		this.altoPermitido = altoPermitido;
		this.descripcion = descripcion;
		this.identificador = identificador;
	}	
	
	public String getIdentificador() {
		return identificador;
	}
	
	public void dameZonaDe(String identificadorUbicacion) {
		System.out.println("ZONA: "+this.descripcion+" "+this.identificador);
	}

	public boolean entra(Buke buke) {
		return buke.menosAncho(this.anchoPermitido)& buke.menosAlto(this.altoPermitido);
	}

	public boolean estaEn(ArrayList<Arribo> arribos) {
		return arribos.stream().anyMatch(e->e.getZona().equalsIgnoreCase(this.identificador));
	}

	


}
