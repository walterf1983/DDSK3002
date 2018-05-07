import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class Puerto {

	private ArrayList<Ubicacion>ubicaciones=new ArrayList<Ubicacion>();
	private ArrayList<Arribo>arribos=new ArrayList<Arribo>();
	private Servicio servicio;
	public ArrayList<Deposito> almacenes=new ArrayList<Deposito>();
	private boolean servicioBunker;
	
	public boolean isServicioBunker() {
		return servicioBunker;
	}

	public void agregarArribo(Arribo arribo){
		arribos.add(arribo);
	}
	
	public Puerto(ArrayList<Ubicacion> ubicaciones,int personalAtrake,ArrayList<Deposito>almacenes,boolean servicioBunker) {
		super();
		this.ubicaciones = ubicaciones;
		this.almacenes=almacenes;
		this.servicioBunker=servicioBunker;
	}
	
	void recorrerPuerto(){
		ubicaciones.stream().forEach(e->e.recorrerZonasDe(e.getIdentrificador()));
	}

	public void registrarArribo(Capitan capitan, ArrayList<Servicio> servicios,LLegada llegada,int personalArribo) {
		System.out.println(capitan.getNombre()+" "+capitan.getBuke().getNombre());
		System.out.println("-----------------------------------------");
		if(servicios!=null)
			for(Servicio s:servicios){
				if(!s.operar(this)){
					if(1==JOptionPane.showConfirmDialog(null,"Desea igualmente determinar arribo")){
						System.out.println("No confirma arribo");
						System.out.println("");
						return;
					};
				};
			}
		this.servicio=new Atrake(personalArribo, capitan, llegada);
		this.servicio.operar(this);
		System.out.println("");
	}
	
	public ArrayList<Ubicacion> getUbicaciones() {
		return ubicaciones;
	}

	public ArrayList<Arribo> getArribos() {
		return arribos;
	}

	public boolean puedoAlmacenar(int bultos) {
		return this.almacenes.
				stream().anyMatch(d->d.puedeAlmacenar(bultos));
	}

	
}
