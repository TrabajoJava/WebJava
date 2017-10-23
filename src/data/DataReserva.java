package data;

import java.sql.*;
import java.util.ArrayList;
import entity.*;

public class DataReserva {
	public ArrayList<Reserva> getAll(){
			Statement stmt=null;
			ResultSet rs=null;
			ArrayList<Reserva> res= new ArrayList<Reserva>();
			
			try {
				stmt = FactoryConexion.getInstancia().getConn().createStatement();
				rs = stmt.executeQuery("select * from reservas");
				if(rs!=null){
					while(rs.next()){					
					Reserva r=new Reserva();
					r.setId_elemento(rs.getInt("id_elemento"));
					r.setId_persona(rs.getInt("id_persona"));
					r.setFecha_inicio(rs.getDate("fecha_inicio"));
					r.setFecha_fin(rs.getDate("fecha_fin"));
					r.setDetalle(rs.getString("detalle"));
					res.add(r);
					
					} 			
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			try {
				if(rs!=null) rs.close(); 
				if(stmt!=null) stmt.close(); 
				FactoryConexion.getInstancia().releaseConn();  
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return res;		
			}
	
	
	
	
	public ArrayList<Reserva> getMisReservas(int idPersona){
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<Reserva> res= new ArrayList<Reserva>();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from reservas where id_persona = ?");
			stmt.setInt(1, idPersona);
			rs = stmt.executeQuery();
			if(rs!=null){
				while(rs.next()){					
				Reserva r=new Reserva();
				r.setId_elemento(rs.getInt("id_elemento"));
				r.setId_persona(rs.getInt("id_persona"));
				r.setFecha_inicio(rs.getDate("fecha_inicio"));
				r.setFecha_fin(rs.getDate("fecha_fin"));
				r.setDetalle(rs.getString("detalle"));
				res.add(r);
				
				} 			
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		try {
			if(rs!=null) rs.close(); 
			if(stmt!=null) stmt.close(); 
			FactoryConexion.getInstancia().releaseConn();  
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return res;		
		}
	
	
	public void addReserva(Reserva res){
		PreparedStatement stmt = null;

		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into reservas(id_elemento, id_persona,fecha_inicio, fecha_fin, detalle) values(?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, res.getId_elemento());
			stmt.setInt(2, res.getId_persona());
			stmt.setDate(3, res.getFecha_inicio());
			stmt.setDate(4,res.getFecha_fin());
			stmt.setString(5, res.getDetalle());
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
}
		
		
	public void delete(Reserva re){
		PreparedStatement stmt = null;
		try {
			stmt =  FactoryConexion.getInstancia().getConn().prepareStatement("delete from reservas where id_elemento=? and id_persona=? and fecha_inicio=? and fecha_fin=?");
			stmt.setInt(1, re.getId_elemento());
			stmt.setInt(2, re.getId_persona());
			stmt.setDate(3, re.getFecha_inicio());
			stmt.setDate(4, re.getFecha_fin());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
		
		
	}
	

	