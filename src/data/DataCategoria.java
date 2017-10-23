package data;

import java.sql.*;
import java.util.ArrayList;

import entity.*;

public class DataCategoria {
	
	public ArrayList<Categoria> getAllCategorias(){
		
		Statement stmt = null;
		ResultSet rs = null;
		
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		
		try {
			stmt= FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from categorias");
			if(rs!=null){
				while(rs.next()){
					Categoria cat = new Categoria();
					cat.setIdcat(rs.getInt("id_cat")); 
					cat.setNombrecat(rs.getString("nombre_cat"));
					categorias.add(cat);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorias;
		
		
		
		
		
	}
	
	
	
}



