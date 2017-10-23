package entity;

import java.sql.Date;

public class Reserva {
	
	private int id_elemento, id_persona;
	private String detalle;
	private Date fecha_inicio, fecha_fin;
	
	public int getId_elemento() {
		return id_elemento;
	}
	public void setId_elemento(int id_elemento) {
		this.id_elemento = id_elemento;
	}
	public int getId_persona() {
		return id_persona;
	}
	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public Reserva(int id_elemento, int id_persona, String detalle, Date fecha_inicio, Date fecha_fin) {
		this.id_elemento = id_elemento;
		this.id_persona = id_persona;
		this.detalle = detalle;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}
	public Reserva() {
	}
	
	
	

	
	
}
