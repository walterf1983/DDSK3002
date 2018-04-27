import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonGenerico implements JsonInterface {
	
	protected Gson gson;
	private BufferedReader bufferedReader;
	protected String serialized="";
	private File file;
	private String pathFile;
	private FileReader fileReader;
	
	public JsonGenerico(String pathFile){
		gson=new Gson();
		this.pathFile=pathFile;
		this.serialized=serialize();
	}
	
	public String serialize(){
		 try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
			 String stringSerialized="";
	         this.file=new File(this.pathFile);
	         this.fileReader=new FileReader(this.file);
	         this.bufferedReader=new BufferedReader(this.fileReader);

	         // Lectura del fichero
	         String linea; 
	         while((linea=this.bufferedReader.readLine())!=null){
	        	stringSerialized=stringSerialized.concat(linea);	
	         }
	         this.serialized= stringSerialized;
		 }
	     catch(Exception e){
	    	 JOptionPane.showMessageDialog(null,"No se encontro el Archivo");
	    	 this.pathFile=JOptionPane.showInputDialog("Ingrese el nuevo Path");
	    	 this.serialized=this.serialize();
	      }finally{
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         try{                    
	            if( null != this.fileReader ){   
	               fileReader.close();     
	            }                  
	         }catch (Exception e2){ 
	            System.out.println("No se pudo cerrar el archivo");
	         }
	      }
		return this.serialized;	
	}

	public String changePath(String newPathFile){
		this.pathFile=newPathFile;
		this.serialized=this.serialize();
		return serialized;
	}
	
	@Override
	public Item buscarItem(String item) {
			ArrayList<Item> items=new ArrayList<Item>();
			items=this.gson.fromJson(this.serialized, new TypeToken<ArrayList<Cliente>>(){}.getType());
			return items.stream().
					filter(i->i.getClave().equalsIgnoreCase(item))
					.collect(Collectors.toList())
					.get(0);
	}
		
	@Override
	public ArrayList<Item> getAllItem() {
		return this.gson.fromJson(this.serialized, new TypeToken<ArrayList<Cliente>>(){}.getType());
	}
	
	public String getSerialized() {
		return serialized;
	}

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}


}


