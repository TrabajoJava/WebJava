package entity;

public class TipoElemento {

	private int idtipo,cantmaxreservaspendientes;
	private String nombretipo;  
	   
	
	
	public int getIdtipo() {
		return idtipo;
	}
	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}
	public String getNombretipo() {
		return nombretipo;
	}
	public void setNombretipo(String nombretipo) {
		this.nombretipo = nombretipo;
	}
	public int getCantmaxreservaspendientes() {
		return cantmaxreservaspendientes;
	}
	public void setCantmaxreservaspendientes(int cantmaxreservaspendientes) {
		this.cantmaxreservaspendientes = cantmaxreservaspendientes;
	}
	
	public TipoElemento(int idtipo, String nombretipo, int cantmaxreservaspendientes) {
		this.idtipo = idtipo;
		this.nombretipo = nombretipo;
		this.cantmaxreservaspendientes = cantmaxreservaspendientes;
	}
	
	public TipoElemento() {
		// TODO Auto-generated constructor stub
	}
	

	
}
