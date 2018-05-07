
 public abstract class Servicio {

	 protected int personalNecesario;

	 public Servicio(int personalNecesario) {
		super();
		this.personalNecesario = personalNecesario;
	}

	public abstract boolean operar(Puerto puerto);
}