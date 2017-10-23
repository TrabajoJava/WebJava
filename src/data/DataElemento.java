package data;
import java.sql.*;
import java.util.ArrayList;
import entity.*;

public class DataElemento {
			public ArrayList <Elemento> getAll(){
				Statement stmt=null;
				ResultSet rs=null;
				ArrayList<Elemento> lib= new ArrayList<Elemento>();
				
				try {
					stmt = FactoryConexion.getInstancia().getConn().createStatement();
					rs = stmt.executeQuery("select * from elementos"); 
					if(rs!=null){
						while(rs.next()){
						int id_elemento = 0;
						String nombre_elemento = null;
						int id_tipo = 0;
						
						Elemento l = new Elemento(id_elemento,nombre_elemento, id_tipo);
						l.setIdElemento(rs.getInt("id_elemento"));
						l.setNombreElemento(rs.getString("nombre_elemento"));
						l.setIdtipo(rs.getInt("id_tipo"));
						lib.add(l);
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if (rs!=null) {rs.close();}
					if (stmt!=null) {stmt.close();}
					FactoryConexion.getInstancia().releaseConn();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return lib;
			}
						
		
			public Elemento getById(Elemento el) {
				
					PreparedStatement stmt=null;
					ResultSet rs=null;
					int codigo = el.getIdElemento();
				try {
					stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from elementos where id_elemento=?");
					stmt.setInt(1, codigo);
					rs = stmt.executeQuery(); 
					if (rs!=null && rs.next()){
						
						//ver si hace falta crear el elemento
						el.setIdtipo(rs.getInt("id_tipo"));
						el.setIdElemento(rs.getInt("id_elemento"));
						el.setNombreElemento(rs.getString("nombre_elemento"));
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					if(rs!=null) rs.close();
					if(stmt!=null)stmt.close();
					FactoryConexion.getInstancia().releaseConn();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				return el;
				
			}
			public void add(Elemento lib){
				PreparedStatement stmt = null;
				ResultSet keyResultSet=null;
				
				try {
					stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into elementos(id_elemento,nombre_elemento,id_tipo) values(?,?,?)"
							,PreparedStatement.RETURN_GENERATED_KEYS);
					stmt.setInt(1, lib.getIdElemento());
					stmt.setString(2, lib.getNombreElemento());
					stmt.setInt(3, lib.getIdtipo());
					
					//Aca revisar, le mando o no le mando el id? (Autoincremental)
					stmt.executeUpdate();
					keyResultSet=stmt.getGeneratedKeys();
					if(keyResultSet!=null && keyResultSet.next()){
						lib.setIdElemento(keyResultSet.getInt(1)); 
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
			
			public void deleteById(Elemento el){
				
				PreparedStatement stmt = null;
				
				
				try {
					
					stmt =  FactoryConexion.getInstancia().getConn().prepareStatement("delete from elementos where id_elemento =?");
					
					stmt.setInt(1, el.getIdElemento());
				
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
			
			public void update(Elemento lib){
				PreparedStatement stmt = null;
			
				try {
					stmt = FactoryConexion.getInstancia().getConn().prepareStatement("update elementos set nombre_elemento=?, id_tipo=?");
					stmt.setString(1, lib.getNombreElemento());
					stmt.setInt(2, lib.getIdtipo());
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
			
			public ArrayList <Elemento> getDisponibles(Date fini,Date ffin,int tipo){
				PreparedStatement stmt=null;
				ResultSet rs=null;
				ArrayList<Elemento> lib= new ArrayList<Elemento>();
				
				try {
					stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from elementos el where el.id_tipo = ? and el.id_elemento not in ( select ele.id_elemento from elementos ele inner join reservas res on ele.id_elemento = res.id_elemento where ((? >= res.fecha_inicio and ? <= res.fecha_fin) or (? >= res.fecha_inicio and ? <= res.fecha_fin) or (? <= res.fecha_fin and ? >= res.fecha_fin)) and ele.id_tipo = ?)");
					stmt.setInt(1, tipo);
					stmt.setDate(2, ffin);
					stmt.setDate(3, fini);
					stmt.setDate(4, fini);
					stmt.setDate(5, ffin);
					stmt.setDate(6, fini);
					stmt.setDate(7, ffin);
					stmt.setInt(8, tipo);
					rs = stmt.executeQuery(); 
					if(rs!=null){
						while(rs.next()){
						Elemento l = new Elemento();
						l.setIdElemento(rs.getInt("id_elemento"));
						l.setNombreElemento(rs.getString("nombre_elemento"));
						l.setIdtipo(rs.getInt("id_tipo"));
						lib.add(l);
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if (rs!=null) {rs.close();}
					if (stmt!=null) {stmt.close();}
					FactoryConexion.getInstancia().releaseConn();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return lib;
			}
		
}
