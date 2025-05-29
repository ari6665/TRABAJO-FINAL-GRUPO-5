/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.entradas;
import modelo.conexion;

/**
 *
 * @author User
 */
public class DaoEntradas {
    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insertar(entradas e){
        
        String SQL="insert into entrada (nomProd, stock, idCategoria, fecha, idProveedor, precioE, precioV, total) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
      
       try {
            con = cn.conectar();
            ps = con.prepareStatement(SQL);
            ps.setString(1, e.getNomProd());
            ps.setInt(2, e.getStock());
            ps.setInt(3, e.getIdCategoria());
            ps.setDate(4, e.getFecha());
            ps.setInt(5, e.getIdProveedor());
            ps.setDouble(6, e.getPrecioE());
            ps.setDouble(7, e.getPrecioV());
            ps.setDouble(8, e.getTotal());
            
            return ps.executeUpdate() > 0;
         } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            return false;
        }
   }
    
     public List<entradas> listarEntradas() {
      List<entradas> listaEntradas = new ArrayList<>();
       String consultaSQL = "SELECT * FROM entrada";
        try{
          con=(Connection) cn.conectar();
          ps=con.prepareStatement(consultaSQL);
          rs=ps.executeQuery();
          
          while(rs.next()){
            entradas e = new entradas();
            e.setIdEntrada(rs.getInt(1));
            e.setNomProd(rs.getString(2));
            e.setStock(rs.getInt(3));
            e.setIdCategoria(rs.getInt(4));
            e.setFecha(rs.getDate(5));
            e.setIdProveedor(rs.getInt(6));
            e.setPrecioE(rs.getDouble(7));
            e.setPrecioV(rs.getDouble(8));
            e.setTotal(rs.getDouble(9));
            listaEntradas.add(e);

          }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return listaEntradas; 
     }

     
     public boolean editar(entradas en){
     String SQL ="update entrada set nomProd=?, stock=?, idCategoria=?, fecha=?, idProveedor=?, precioE=?, precioV=?, total=? WHERE identrada = ?";
    try {
        con = cn.conectar();
        ps = con.prepareStatement(SQL);
        ps.setString(1, en.getNomProd());
        ps.setInt(2, en.getStock());
        ps.setInt(3, en.getIdCategoria());
        ps.setDate(4, en.getFecha());
        ps.setInt(5, en.getIdProveedor());
        ps.setDouble(6, en.getPrecioE());
        ps.setDouble(7, en.getPrecioV());
        ps.setDouble(8, en.getTotal());
        ps.setInt(9, en.getIdEntrada());
        
         return ps.executeUpdate() > 0;
      }catch (Exception e){
        JOptionPane.showConfirmDialog(null, e);
        return false;
      }
    }
       
    public boolean eliminar(entradas en) {
    String SQL = "delete from entrada where identrada=?";
    try {
        con = cn.conectar();
        ps = con.prepareStatement(SQL);
        
        ps.setInt(1, en.getIdEntrada());
        int filasAfectadas = ps.executeUpdate();
         return filasAfectadas > 0;
         
    } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, e);
        return false;
    }
  }
    
      public boolean buscar(entradas en) {
    String SQL = "select * from entrada where identrada=?";
    try {
        con = cn.conectar();
        ps = con.prepareStatement(SQL);
        ps.setInt(1, en.getIdEntrada());
        rs = ps.executeQuery();
        if (rs.next()){
            en.setIdEntrada(rs.getInt(1));
            en.setNomProd(rs.getString(2));
            en.setStock(rs.getInt(3));
            en.setIdCategoria(rs.getInt(4));
            en.setFecha(rs.getDate(5));
            en.setIdProveedor(rs.getInt(6));
            en.setPrecioE(rs.getDouble(7));
            en.setPrecioV(rs.getDouble(8));
            en.setTotal(rs.getDouble(9));
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