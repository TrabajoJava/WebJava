package data;

import java.sql.*;
import java.util.ArrayList;
import entity.*;

/*y este tambien*/

public class DataTipoElemento {

	public ArrayList<TipoElemento> getAllTipos(){
		
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<TipoElemento> tipos = new ArrayList<TipoElemento>();
		
		try {
			stmt= FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from tipoelementos");
			if(rs!=null){
				while(rs.next()){
					TipoElemento tl = new TipoElemento();
					tl.setCantmaxreservaspendientes(rs.getInt("cantmaxreservaspendientes"));
					tl.setIdtipo(rs.getInt("id_tipo"));
					tl.setNombretipo(rs.getString("nombre_tipo"));
					tipos.add(tl);
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
		return tipos;
		
		
	}
	
	
	public void add(TipoElemento lib){
		PreparedStatement stmt = null;
		ResultSet keyResultSet=null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into tipoelementos(id_tipo,nombre_tipo,cantmaxreservaspendientes) values(?,?,?)"
					,PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, lib.getIdtipo());
			stmt.setString(2, lib.getNombretipo());
			stmt.setInt(3,lib.getCantmaxreservaspendientes());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				lib.setIdtipo(keyResultSet.getInt(1)); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public TipoElemento getbyId(int idtipo){
		PreparedStatement stmt=null;
		ResultSet rs = null;
		TipoElemento t = null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select id_tipo, nombre_tipo, cantmaxreservaspendientes from tipoelementos where id_tipo=?");
			stmt.setInt(1, idtipo);
			rs = stmt.executeQuery();
			if(rs!=null && rs.next()){	
				t = new TipoElemento();				
				t.setIdtipo(rs.getInt("id_tipo"));
				t.setNombretipo(rs.getString("nombre_tipo"));
				t.setCantmaxreservaspendientes(rs.getInt("cantmaxreservaspendientes"));

										}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
			try {
				if(rs!=null) rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			return t;
}

	public void update(TipoElemento te){
		
		PreparedStatement stmt = null;
		
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("update tipoelementos set id_tipo = ?, nombre_tipo = ?, cantmaxreservaspendientes= ? where id_tipo = ?");
			stmt.setInt(1, te.getIdtipo());
			stmt.setString(2, te.getNombretipo());
			stmt.setInt(3, te.getCantmaxreservaspendientes());
			stmt.setInt(4, te.getIdtipo());
			
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
	
	
	
	public void deletebyid(TipoElemento te){
		
		PreparedStatement stmt = null;
		PreparedStatement stmt2 =null;
		//PreparedStatement stmt3=null;
		int idtipo = te.getIdtipo();
		
		try {
			
			//stmt3 =  FactoryConexion.getInstancia().getConn().prepareStatement("delete from reservas r inner join elementos e on e.id_elemento = r.id_elemento where id_tipo = ?;");
			stmt =  FactoryConexion.getInstancia().getConn().prepareStatement("delete from elementos where id_tipo =?");
			
			stmt2 = FactoryConexion.getInstancia().getConn().prepareStatement("delete from tipoelementos where id_tipo =?");
			stmt.setInt(1, idtipo);
			stmt2.setInt(1, idtipo);
			stmt.executeUpdate();
			stmt2.executeUpdate();
			
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
