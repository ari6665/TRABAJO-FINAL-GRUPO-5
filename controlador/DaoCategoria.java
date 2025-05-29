/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.Categoria;
import modelo.conexion;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class DaoCategoria {
    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insertar(Categoria c){
        
        String SQL="insert into categorias(categoria)VALUES (?)";
      
       try {
            con = cn.conectar();
            ps = con.prepareStatement(SQL);
            ps.setString(1, c.getNomCategoria());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;
        }
    }
    
  public List<Categoria> listarCategorias() {
      List<Categoria> listaCategorias = new ArrayList<>();
       String consultaSQL = "SELECT * FROM categorias";
        try{
          con=(Connection) cn.conectar();
          ps=con.prepareStatement(consultaSQL);
          rs=ps.executeQuery();
          
          while(rs.next()){
              Categoria categoria = new Categoria();
            categoria.setIdCategoria(rs.getInt(1));
            categoria.setNomCategoria(rs.getString(2));
            listaCategorias.add(categoria);

          }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return listaCategorias; 
     }
    
    public boolean editar(Categoria categoria) {
     String SQL ="update categorias set categoria=? where idCategoria=?";
    try {
        con = cn.conectar();
        ps = con.prepareStatement(SQL);
        ps.setString(1, categoria.getNomCategoria());
        ps.setInt(2, categoria.getIdCategoria());
        
         return ps.executeUpdate() > 0;
    } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, e);
        return false;
      }
    }
    
    public boolean eliminar(Categoria c) {
    String SQL = "delete from categorias where idCategoria=?";
    try {
        con = cn.conectar();
        ps = con.prepareStatement(SQL);
        
        ps.setInt(1, c.getIdCategoria());
        int filasAfectadas = ps.executeUpdate();
         return filasAfectadas > 0;
         
    } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, e);
        return false;
    }
}

    public boolean buscar(Categoria c) {
    String SQL = "select * from categorias where idCategoria=?";
    
    try {
        con = cn.conectar();
        ps = con.prepareStatement(SQL);
        ps.setInt(1, c.getIdCategoria());
        rs = ps.executeQuery();
        if (rs.next()) {
            c.setIdCategoria(rs.getInt(1));
            c.setNomCategoria(rs.getString(2));
            return true;
        } else {
            return false;
        }
    } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, e);
        return false;
    }
  }
}
