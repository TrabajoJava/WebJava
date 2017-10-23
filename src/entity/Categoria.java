package entity;

public class Categoria {
	
	//private enum idcat {Encargado, Administrador, Usuario}; ver si se puede hacer asi
	private String nombrecat;
	private int idcat;
	
	public String getNombrecat() {
		return nombrecat;
	}
	public void setNombrecat(String nombrecat) {
		this.nombrecat = nombrecat;
	}
	public int getIdcat() {
		return idcat;
	}
	public void setIdcat(int idcat) {
		this.idcat = idcat;
	}
	
	public Categoria(String nombrecat, int idcat) {
		this.nombrecat = nombrecat;
		this.idcat = idcat;
	}
	public Categoria() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	
	
}
