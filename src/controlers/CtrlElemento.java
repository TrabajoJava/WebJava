package controlers;

import java.sql.Date;
import java.util.ArrayList;

import data.DataElemento;
import entity.Elemento;




public class CtrlElemento {

	private DataElemento dataElemento;
	private ArrayList<Elemento> elemento;
	
	public CtrlElemento(){
		dataElemento = new DataElemento();
		elemento= new ArrayList<Elemento>();	
	
	}

	public void add(Elemento elemento){
		dataElemento.add(elemento);
	}
	
	public ArrayList<Elemento> getAll()
	{
		return dataElemento.getAll();
		
	}
	public ArrayList<Elemento> getDisp(Date fini,Date ffin,int tipo)
	{
		return dataElemento.getDisponibles(fini, ffin, tipo);
		
	}
	
	
	public void deletebyid(Elemento e){
		
		dataElemento.deleteById(e);
		
	}
	
	public Elemento getbyid(Elemento e)
	{
		
		return dataElemento.getById(e);
	}
	
}