/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.conexion;
import modelo.proveedor;
import modelo.usuarios;


public class DaoUsuario {
    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;

    public usuarios login(String usuario, String pass){
        usuarios us=new usuarios();
        String sql = "SELECT * FROM usuarios WHERE usuario='" + usuario + "' and pass=aes_encrypt('" + pass + "', 'clave');";
    
        try {
            con =cn.conectar();
            ps =con.prepareStatement(sql);
            rs =ps.executeQuery();
        while(rs.next()){
            us.setIdusuario(rs.getInt(1));
            us.setNombre(rs.getString(2));
            us.setApellido(rs.getString(3));
            us.setDocumento(rs.getString(4));
            us.setTelefono(rs.getString(5));
            us.setCorreo(rs.getString(6));
            us.setTipoUsuario(rs.getString(7));
            us.setUsuario(rs.getString(8));
            us.setPassword(rs.getString(9));
        }
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null,ex);
        }
       
        return us;
    }
    
   public boolean insertar(String nombre, String apellido, String documento, String telefono, String correo, String tipouser, String user, String pass) {
    String SQL = "insert into usuarios (nombre, apellido, documento, telefono, correo, tipoUsuario, usuario, pass) "
               + "VALUES ('" + nombre + "','" + apellido + "','" + documento + "','" + telefono + "','" + correo + "','" + tipouser + "','" + user + "', aes_encrypt('" + pass + "','clave'))";
    
       try {
            con = cn.conectar();
            ps = con.prepareStatement(SQL);
           
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;
        }
    }
    
    public List<usuarios> listarUsuario() {
      List<usuarios> listaUsuarios = new ArrayList<>();
       String consultaSQL = "SELECT * FROM usuarios";
        try{
          con=(Connection) cn.conectar();
          ps=con.prepareStatement(consultaSQL);
          rs=ps.executeQuery();
          
          while(rs.next()){
            usuarios u = new usuarios();
            u.setIdusuario(rs.getInt(1));
            u.setNombre(rs.getString(2));
            u.setApellido(rs.getString(3));
            u.setDocumento(rs.getString(4));
            u.setTelefono(rs.getString(5));
            u.setCorreo(rs.getString(6));
            u.setTipoUsuario(rs.getString(7));
            u.setUsuario(rs.getString(8));
            u.setPassword(rs.getString(9));
           listaUsuarios.add(u);

          }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return listaUsuarios; 
        
    }
    
    
    public boolean buscar(usuarios u) {
    String SQL = "SELECT idUsuario, nombre, apellido, documento, telefono, correo, tipoUsuario, "
            + "usuario, " + "aes_decrypt(usuarios.pass, 'clave') as pass FROM usuarios WHERE documento=?";
    
    try {
        con = cn.conectar();
        ps = con.prepareStatement(SQL);
        ps.setString(1, u.getDocumento());
        
        rs = ps.executeQuery();
        if (rs.next()) {
           u.setIdusuario(rs.getInt(1));
           u.setNombre(rs.getString(2));
           u.setApellido(rs.getString(3));
           u.setDocumento(rs.getString(4));
           u.setTelefono(rs.getString(5));
           u.setCorreo(rs.getString(6));
           u.setTipoUsuario(rs.getString(7));
           u.setUsuario(rs.getString(8));
           u.setPassword(rs.getString(9));
            return true;
        } else {
            return false;
        }
    } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, e);
        return false;
    }
        }
    
     public boolean editar(String nombre, String apellido, String documento, String tel, String correo, String tipousuario, String user, String pass, int id) {
    String SQL = "update usuarios SET nombre='" + nombre + "',apellido='" + apellido + "',documento='" + documento + "',telefono='" + tel + "',"
               + "correo='" + correo + "',tipoUsuario='" + tipousuario + "',usuario='" + user + "',pass=aes_encrypt('" + pass + "','clave') WHERE idUsuario=" + id + ";";
    try {
        con = cn.conectar();
        ps = con.prepareStatement(SQL);
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

  public boolean eliminar(usuarios u) {
    String SQL = "delete from usuarios where idUsuario=?";
    try {
        con = cn.conectar();
        ps = con.prepareStatement(SQL);
        
        ps.setInt(1, u.getIdusuario());
        int filasAfectadas = ps.executeUpdate();
         return filasAfectadas > 0;
         
    } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, e);
        return false;
    }
  }
  
}
