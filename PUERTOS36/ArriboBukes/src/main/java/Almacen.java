import java.util.ArrayList;
import java.util.stream.Collectors;

public class Almacen extends Servicio {

	private int bultos;
	
	public Almacen(int personalNecesario,int bultos) {
		super(personalNecesario);
		this.bultos=bultos;
	}

	@Override
	public boolean operar(Puerto puerto) {
		if(puerto.puedoAlmacenar(this.bultos)){
			Deposito deposito=puerto.almacenes.stream().
							filter(d->d.puedeAlmacenar(this.bultos)).
							collect(Collectors.toCollection(ArrayList::new)).
							get(0);
			deposito.almacenar(bultos);
			System.out.println("Se pudo almacenar");
			return true;
		}
		System.out.println("No se pudo almacenar");
		return false;
	}

}
