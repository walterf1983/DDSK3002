import java.util.ArrayList;

public class sistemaPortuarioDeArribos {

	public static void main(String[] args) {
	
		ArrayList<Zona>zonas1=new ArrayList<Zona>();
		zonas1.add(new Zona(100, 200,"Sector Norte","A1"));
		zonas1.add(new Zona(200, 400,"Sector sur","A2"));
		zonas1.add(new Zona(500, 700,"Sector Norte","A3"));
		zonas1.add(new Zona(1000, 2000,"Sector Norte","A4"));
		zonas1.add(new Zona(1500, 2500,"Sector Oeste","A5"));
		Ubicacion ubicacionA=new Ubicacion(zonas1,"A");
		
		ArrayList<Zona>zonas2=new ArrayList<Zona>();
		zonas2.add(new Zona(1500,2500,"Sector Oeste","B1"));
		zonas2.add(new Zona(1000,2000,"Sector Este","B2"));
		zonas2.add(new Zona(500, 700,"Sector Este","B3"));
		zonas2.add(new Zona(200, 400,"Sector Sur","B4"));
		zonas2.add(new Zona(100, 200,"Sector Sur","B5"));
		Ubicacion ubicacionB=new Ubicacion(zonas2,"B");
		
		ArrayList<Zona>zonas3=new ArrayList<Zona>();
		zonas3.add(new Zona(1500,2500,"Sector Oeste","C1"));
		zonas3.add(new Zona(1000,2000,"Sector Este","C2"));
		zonas3.add(new Zona(500, 700,"Sector Este","C3"));
		Ubicacion ubicacionC=new Ubicacion(zonas3,"C");
		
		ArrayList<Ubicacion>ubicaciones=new ArrayList<Ubicacion>();
		ubicaciones.add(ubicacionA);
		ubicaciones.add(ubicacionB);
		ubicaciones.add(ubicacionC);
		
		ArrayList<Deposito>almacenes=new ArrayList<Deposito>();
		almacenes.add(new Deposito(100,100));
		almacenes.add(new Deposito(40,50));
		Puerto puerto=new Puerto(ubicaciones,5,almacenes,false);
		//puerto.recorrerPuerto();
		
		Capitan capitan1=new Capitan("BarbaRoja",new Buke("23432","Pelirroja" ,"Fantasia", 400,400));
		Capitan capitan2=new Capitan("Salinas",new Buke("234232","El Romanel" ,"España", 100,100));
		
		
		ArrayList<Servicio>servicios1=new ArrayList<Servicio>();
		servicios1.add(new Almacen(8,7));
		servicios1.add(new Almacen(4,10));
		
		ArrayList<Servicio>servicios2=new ArrayList<Servicio>();
		servicios2.add(new CargaDescarga(8, "Codesa",5));
		servicios2.add(new Bunker(1,puerto.isServicioBunker()));
		
		
		capitan1.avisarArribo(puerto, servicios1,new LLegada(20190701,1400),5);
		capitan2.avisarArribo(puerto, servicios2,new LLegada(20190701,1400),4);
		capitan2.avisarArribo(puerto, null,new LLegada(20190701,1400),7);
		capitan2.avisarArribo(puerto, null,new LLegada(20190701,1400),12);

	}

}
