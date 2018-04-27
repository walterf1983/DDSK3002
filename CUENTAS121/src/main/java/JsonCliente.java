import java.util.ArrayList;
import java.util.stream.Collectors;

import com.google.gson.reflect.TypeToken;

public class JsonCliente extends JsonGenerico {

	public JsonCliente(String pathFile) {
		super(pathFile);
	}

	@Override
	public Item buscarItem(String item) {
			return(Cliente)super.buscarItem(item);
	}
	
	@Override
	public ArrayList<Item> getAllItem() {
		return super.getAllItem();
	}

}
