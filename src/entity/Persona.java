package entity;

public class Persona {
	
	private int id;
	private String dni, nombre, apellido, usuario, contrasena;
	private boolean habilitado;
		
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	
	public Persona() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Persona(int id, String dni, String nombre, String apellido, boolean habilitado, String usuario,
			String contrasena) {
		
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.habilitado = habilitado;
		this.usuario = usuario;
		this.contrasena = contrasena;
		
	}
	
	
	
	
	
	
	

}
