
public class Arribo {

	private int fechaArribo;
	private int horaArribo;
	private String zona;
	private String nombreBuke;
	
	public String getZona() {
		return zona;
	}

	public int getFechaArribo() {
		return fechaArribo;
	}

	public int getHoraArribo() {
		return horaArribo;
	}

	public Arribo(int fechaArribo, int horaArribo, String zona,String nombreBuke) {
		super();
		this.fechaArribo = fechaArribo;
		this.horaArribo = horaArribo;
		this.nombreBuke=nombreBuke;
		this.zona = zona;
	}
	
}
