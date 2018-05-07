import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class Atrake extends Servicio {

	private Capitan capitan;
	private LLegada llegada;
	
	public Atrake(int personalNecesario,Capitan capitan, LLegada llegada) {
		super(personalNecesario);
		this.capitan=capitan;
		this.llegada=llegada;
	}

	@Override
	public boolean operar(Puerto puerto) {
		boolean ok=false;
		Arribo arribo=null;
		
		ArrayList<Arribo>arribos=new ArrayList<Arribo>();
		if(this.todosLosSectoresDisponiblesEnFecha(llegada.getFecha(),puerto.getArribos())){
			arribo=this.asignarSectorApropiadoPara(capitan.getBuke(),puerto.getUbicaciones(),llegada);
		}else{
			if(this.todosLosSectoresDisponiblesEnHoraDeFecha(llegada.getHora(),llegada.getFecha(),puerto.getArribos())){
				arribo=this.asignarSectorApropiadoPara(capitan.getBuke(),puerto.getUbicaciones(),llegada);
			}else{
				arribos=this.traerArribosDeHoraEnFecha(llegada.getHora(),llegada.getFecha(),puerto.getArribos());
				arribo=this.buscarSectorLibre(arribos,capitan.getBuke(),llegada,puerto.getUbicaciones());	
			}	
		}
		if(arribo!=null){
			System.out.println(arribo.getZona());
			puerto.agregarArribo(arribo);
			ok=true;
		}else{
			JOptionPane.showMessageDialog(null, "No hay disponibilidad, cambie fecha y hora");
			this.llegada.setFecha(Integer.parseInt(JOptionPane.showInputDialog("Ingrese fecha en el formato aaammdd")));
			this.llegada.setHora(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la hora en el formato hhmm")));
			this.operar(puerto);
			
		}
		return ok;
		
	}

	public Arribo buscarSectorLibre(ArrayList<Arribo> arribos,Buke buke,LLegada llegada,ArrayList<Ubicacion>ubicaciones) {
		Ubicacion ubicacion=null;
		Arribo arribo=null;
		ArrayList<Zona>zonas=new ArrayList<Zona>();
		Zona zona=null;
		
		for(int i=0;i<ubicaciones.size()&arribo==null;i++){
			ubicacion=ubicaciones.get(i);
			zonas=ubicacion.getZonas();
			for(int j=0;j<zonas.size()&arribo==null;j++){
				zona=zonas.get(j);
				if(!zona.estaEn(arribos)& buke.entra(zona)){
					arribo=new Arribo(llegada.getFecha(), llegada.getHora(), zona.getIdentificador(),buke.getNombre());
				}
			}
		}
		if(arribo==null){
			System.out.println("No hay disponibilidad:Enviar Mensaje Al capitan por cambio de fecha u hora");
		}
		return arribo;
	}

	public ArrayList<Arribo> traerArribosDeHoraEnFecha(int hora,int fecha,ArrayList<Arribo>arribos) {
		return arribos.
				stream().
				filter(e->e.getHoraArribo()==hora&e.getFechaArribo()==fecha).
				collect(Collectors.toCollection(ArrayList::new));
	}

	public boolean todosLosSectoresDisponiblesEnHoraDeFecha(int hora,int fecha,ArrayList<Arribo>arribos) {
		ArrayList<Arribo>arribosB=new ArrayList<Arribo>();
		arribosB=this.traerArribosDeFecha(fecha,arribos);
		return arribosB.stream().allMatch(e->e.getHoraArribo()!=hora);
	}

	public ArrayList<Arribo> traerArribosDeFecha(int fecha,ArrayList<Arribo>arribos) {
		return  arribos.
				stream().
				filter(e->e.getFechaArribo()==fecha).
				collect(Collectors.toCollection(ArrayList::new));
	}

	public Arribo asignarSectorApropiadoPara(Buke buke,ArrayList<Ubicacion>ubicaciones,LLegada llegada) {
		Zona zonaB=null;
		Ubicacion ubicacionB=null;
		for(int i=0; i<ubicaciones.size()& zonaB==null;i++){
			ubicacionB=ubicaciones.get(i);
			for(int j=0;j<ubicacionB.getZonas().size()& zonaB==null;j++){
				if(buke.entra(ubicacionB.getZonas().get(j))){
					zonaB=ubicacionB.getZonas().get(j);
				}
			}
		}
		return new Arribo(llegada.getFecha(),llegada.getHora(), zonaB.getIdentificador(), buke.getNombre());
	}

	public boolean todosLosSectoresDisponiblesEnFecha(int fecha,ArrayList<Arribo>arribos){
		return arribos.stream().allMatch(e->e.getFechaArribo()!=fecha);
	}
}
