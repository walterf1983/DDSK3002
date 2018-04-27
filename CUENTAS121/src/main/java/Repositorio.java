import java.util.ArrayList;

public class Repositorio {
	
	private JsonGenerico json;
	
	public Repositorio(String pathFile){
		this.json=new JsonCliente(pathFile);
	}
	
	public String getAll(){
		
		return json.getSerialized();
	}

	public void changePath(String pathFile) {
		this.json.changePath(pathFile);
	}

	public Item buscarItem(String item){
		return ( this.json).buscarItem(item);
		
	}

	public ArrayList<Item> getAllItem() {
		return this.json.getAllItem();
	}
	
	
}
