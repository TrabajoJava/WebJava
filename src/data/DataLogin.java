package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Persona;
import ui.Login;

public class DataLogin {
	
	public Persona compara(Persona per){
		Persona p = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select id, nombre, apellido, dni, habilitado, usuario, contrasena FROM personas where usuario=? and contrasena = ?");
		stmt.setString(1, per.getUsuario());
		stmt.setString(2, per.getContrasena());
		rs = stmt.executeQuery();
			if (rs != null && rs.next()){
				p = new Persona();
				p.setId(rs.getInt("id"));
				p.setApellido(rs.getString("apellido"));
				p.setNombre(rs.getString("nombre"));
				p.setDni(rs.getString("dni"));
				p.setHabilitado(rs.getBoolean("habilitado"));
				p.setUsuario(rs.getString("usuario"));
				p.setContrasena(rs.getString("contrasena"));
			}
		} catch (SQLException e){
			e.printStackTrace();
			}
		
		try{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e){
			
			e.printStackTrace();
		}
		
		return p;
	}


}