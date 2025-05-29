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
import modelo.conexion;
import modelo.Clientes;

/**
 *
 * @author User
 */
public class DaoClientes {
    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insertar(Clientes c){
        
        String SQL="insert into clientes (nombre, apellido, documento, direccion, telefono, correo)VALUES (?,?,?,?,?,?)";
      
       try {
            con = cn.conectar();
            ps = con.prepareStatement(SQL);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getDocumento());
            ps.setString(4, c.getDireccion());
            ps.setString(5, c.getTelefono());
            ps.setString(6, c.getCorreo());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;
        }
    }
    
     public List<Clientes> listarClientes() {
      List<Clientes> listaClientes = new ArrayList<>();
       String consultaSQL = "SELECT * FROM clientes";
        try{
          con=(Connection) cn.conectar();
          ps=con.prepareStatement(consultaSQL);
          rs=ps.executeQuery();
          
          while(rs.next()){
            Clientes c = new Clientes();
            c.setIdCliente(rs.getInt(1));
            c.setNombre(rs.getString(2));
            c.setApellido(rs.getString(3));
            c.setDocumento(rs.getString(4));
            c.setDireccion(rs.getString(5));
            c.setTelefono(rs.getString(6));
            c.setCorreo(rs.getString(7));
            
           listaClientes.add(c);

          }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return listaClientes; 
     }
    
     
    public boolean editar(Clientes c) {
     String SQL = "update clientes set nombre=?, apellido=?, documento=?, direccion=?, telefono=?, correo=? where idCliente=?";
    try {
        con = cn.conectar();
        ps = con.prepareStatement(SQL);
        ps.setString(1, c.getNombre());
        ps.setString(2, c.getApellido());
        ps.setString(3, c.getDocumento());
        ps.setString(4, c.getDireccion());
        ps.setString(5, c.getTelefono());
        ps.setString(6, c.getCorreo());
        ps.setInt(7, c.getIdCliente());
        int n = ps.executeUpdate();
        if (n != 0) {
            return true;
        } else {
            return false;
        }
    } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, e);
        return false;
    }
   }
    
    public boolean eliminar(Clientes c) {
    String SQL = "delete from clientes where idCliente=?";
    try {
        con = cn.conectar();
        ps = con.prepareStatement(SQL);
        
        ps.setInt(1, c.getIdCliente());
        int filasAfectadas = ps.executeUpdate();
         return filasAfectadas > 0;
         
    } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, e);
        return false;
    }
}
    
    
    public boolean buscar(Clientes c) {
    String SQL = "select * from clientes where documento=?";
    
    try {
        con = cn.conectar();
        ps = con.prepareStatement(SQL);
        ps.setString(1, c.getDocumento());
        rs = ps.executeQuery();
        if (rs.next()) {
            c.setIdCliente(rs.getInt(1));
            c.setNombre(rs.getString(2));
            c.setApellido(rs.getString(3));
            c.setDocumento(rs.getString(4));
            c.setDireccion(rs.getString(5));
            c.setTelefono(rs.getString(6));
            c.setCorreo(rs.getString(7));
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
