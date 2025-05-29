/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.conexion;
import modelo.salidas;


/**
 *
 * @author User
 */
public class DaoSalidas {
    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insertar(salidas sa){
        
        String SQL="insert into salidas (numSalida, idCliente, fecha, subtotal, igv, total) VALUES (?, ?, ?, ?, ?, ?)";
       try {
            con = cn.conectar();
            ps = con.prepareStatement(SQL);
            ps.setString(1, sa.getNumSalida());
            ps.setInt(2, sa.getIdCliente());
            ps.setDate(3, sa.getFecha());
            ps.setDouble(4, sa.getSubTotal());
            ps.setDouble(5, sa.getIgv());
            ps.setDouble(6, sa.getTotal());
            
            
            return ps.executeUpdate() > 0;
         } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            return false;
        }
   }
    
    
    public String numSalida() {
    String numero="";
    String SQL = "select max(idSalida) from salidas";
    
    try {
        con = cn.conectar();
        ps = con.prepareStatement(SQL);
        rs = ps.executeQuery();
        while (rs.next()) {
        numero = rs.getString(1);
   }
    } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, e);
      }
      return numero;
  }
    
    
    
   public boolean restarStock(int idSalida, int cant){
    String SQL = "UPDATE entrada set stock=stock-" + cant + " WHERE identrada=" + idSalida;
    try{
        con = cm.conectar();
        ps = con.prepareStatement(SQL);
        int n = ps.executeUpdate();
        if(n != 0){
            return true;
        } else {
            return false;
        }
    } catch (Exception e){
        return false;
    }
} 
    
}

