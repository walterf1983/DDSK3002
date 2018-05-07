import java.util.ArrayList;

public class CargaDescarga extends Servicio{

	private String empresaConsignataria;
	private int personalDescarga;
	
	public CargaDescarga(int personalNecesario,String consignataria,int personalDescarga) {
		super(personalNecesario);
		this.empresaConsignataria=consignataria;
		this.personalDescarga=personalDescarga;
	}

	@Override
	public boolean operar(Puerto puerto) {
		System.out.println("Se envia mail a:"+this.empresaConsignataria);
		return true;
		
	}

}
