
public class Buke {
	
	private String codigoInternacional;
	private String nombre;
	private String bandera;
	private double ancho;
	private double alto;
	
	public Buke(String codigoInternacional, String nombre, String bandera, double ancho, double alto) {
		super();
		this.codigoInternacional = codigoInternacional;
		this.nombre = nombre;
		this.bandera = bandera;
		this.ancho = ancho;
		this.alto = alto;
	}

	public boolean entra(Zona zona) {
		return zona.entra(this);
	}

	public boolean menosAncho(double anchoPermitido) {
		return this.ancho<=anchoPermitido;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean menosAlto(double altoPermitido) {
		return this.alto<=altoPermitido;
	}
	
	

}
