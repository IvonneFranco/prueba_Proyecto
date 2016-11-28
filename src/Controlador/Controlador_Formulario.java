/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vistas.Inicio;
import Vistas.Menu;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ModeloTarjeta;

/**
 *
 * @author Ivonne Franco
 */
public class Controlador_Formulario {
    private final String tabla = "usuario";
    private final String tabla2 = "formulario";
    
    // consulta utilizada para obtener el cliente
    public int recuperarPorId(Connection conexion, int cliente) throws SQLException {
       int resultadoc=0;
        try{
            
            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM " + this.tabla + " WHERE cliente = ?");
            consulta.setInt(1, cliente);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                resultadoc = resultado.getInt(3);
                return resultadoc;
               
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return resultadoc;
    }
    // consulta utilizada para obtener el Nip y validar si es usuario cliente o Administrador
    public String recuperarPornip(Connection conexion, String nip) throws SQLException {
        String resultadoc="";
        
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM " + this.tabla + " WHERE nip = ?" );
            consulta.setString(1, nip);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                resultadoc = resultado.getString(4) +" "+resultado.getInt(1)+" "+ resultado.getInt(3);
                return resultadoc;
               
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return resultadoc;
    }
    // Insert para generar el formulario y almacenarlo en la BD.
    public void guardar(Connection conexion, ModeloTarjeta tarjeta) throws SQLException{
        try{
            
            PreparedStatement consulta;
            
                System.out.println(tarjeta.getId());
                consulta = conexion.prepareStatement("INSERT INTO " + this.tabla2 + "(id_formulario,nombre,cliente,folio,status,tarjeta,id) VALUES(?,?, ?, ?, ?, ?, ?)");
                consulta.setString(1, null);
                consulta.setString(2, tarjeta.getNombre());
                consulta.setInt(3, tarjeta.getCliente());
                consulta.setInt(4, tarjeta.getFolio());
                consulta.setString(5, tarjeta.getStatus());
                consulta.setString(6, tarjeta.getTarjeta());
                consulta.setInt(7, tarjeta.getId());
                consulta.execute();
            /*else{
                consulta = conexion.prepareStatement("UPDATE " + this.tabla2 + " SET nombre = ?, cliente = ?, folio = ?,status = ?, tarjeta = ?, id = ? WHERE id_formulario = ?");
                consulta.setString(1, tarjeta.getNombre());
                consulta.setInt(2, tarjeta.getCliente());
                consulta.setInt(3, tarjeta.getFolio());
                consulta.setString(4, tarjeta.getStatus());
                consulta.setString(5, tarjeta.getTarjeta());
                consulta.setInt(3, tarjeta.getId());
            }*/
            
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }

    /**
     *
     * @param conexion
     * @return
     * @throws SQLException
     */
    // consulta utilizada por el cliente para obtener los folios
    public ArrayList<ModeloTarjeta> recuperartarjetas(Connection conexion, int id) throws SQLException{
        ArrayList<ModeloTarjeta> tarjetas = new ArrayList<>();
        System.out.println(id);
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT *  FROM " + this.tabla2 + " WHERE id = "+ id +"");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                tarjetas.add( new ModeloTarjeta(resultado.getInt("id_formulario"),resultado.getString("nombre"),resultado.getInt("cliente"),resultado.getInt("folio"),resultado.getString("status"),resultado.getString("tarjeta"),resultado.getInt("id")));
               
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return tarjetas;
        
    }
    // Consulta las ls folios pendientes 
    // consulta utilizada por el administrador.
    public ArrayList<ModeloTarjeta> recuperarpendietes(Connection conexion, String valor ) throws SQLException{
        ArrayList<ModeloTarjeta> tarjetas = new ArrayList<>();
        
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT *  FROM formulario where status =? ");
            consulta.setString(1, valor);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                tarjetas.add( new ModeloTarjeta(resultado.getInt("id_formulario"),resultado.getString("nombre"),resultado.getInt("cliente"),resultado.getInt("folio"),resultado.getString("status"),resultado.getString("tarjeta"),resultado.getInt("id")));
               
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return tarjetas;
        
    }
    // métdo utilizado por el adminstrador para cambiar el estado de los folios.
    public void actualizar(Connection conexion, String estatus, int cliente, int folio ) throws SQLException{
        try{
            
            PreparedStatement consulta;
            
                consulta = conexion.prepareStatement("UPDATE " + this.tabla2 + " SET status = ? WHERE cliente = ? AND folio = ?");
                
                consulta.setString(1, estatus);
                consulta.setInt(2, cliente);
                consulta.setInt(3, folio);
                consulta.executeUpdate();
            
            
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
       
       
      
    
    
    
}
