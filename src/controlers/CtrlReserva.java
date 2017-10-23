package controlers;

import java.util.ArrayList;

import data.DataReserva;
import entity.Persona;
import entity.Reserva;

public class CtrlReserva {
	

	private DataReserva dataRes;
	private ArrayList<Reserva> res;
	
	public CtrlReserva(){
		dataRes = new DataReserva();
		res= new ArrayList<Reserva>();	
		
	
	}
	
	public void add(Reserva res){
		dataRes.addReserva(res);
	}

public ArrayList<Reserva> getall(){
		
		res = dataRes.getAll();
		return res;
		
	}

public ArrayList<Reserva> getMisReservas(int idPersona){
	
	return dataRes.getMisReservas(idPersona);
	
}

public void delete(Reserva re){
	
	dataRes.delete(re);
}
	
}
