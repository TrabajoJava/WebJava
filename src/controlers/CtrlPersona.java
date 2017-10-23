
package controlers;

import java.util.ArrayList;

import data.DataPersona;
import entity.Persona;

public class CtrlPersona {

	
	private DataPersona dataPer;
	private ArrayList<Persona> pers;
	
	public CtrlPersona(){
		dataPer = new DataPersona();
		pers= new ArrayList<Persona>();	
		
	
	}

	public void add(Persona per){
		dataPer.add(per);
	}
	
	public void deletebydni(Persona per){
		
		dataPer.deleteByDni(per);
		
	}
	
	public ArrayList<Persona> getall(){
		
		pers = dataPer.getAll();
		return pers;
		
	}
	
	public Persona getbydni(Persona per){
		
		return dataPer.getByDni(per);
	}
	
	public Persona getbyid(int id){
		
		return dataPer.getbyid(id);
		
	}
	
	public void update(Persona per){
		
		dataPer.update(per);
	}
	
	
}
