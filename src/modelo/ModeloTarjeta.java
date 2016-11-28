/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author arkai
 */
public class ModeloTarjeta {
    private Integer id_formulario;
    private String nombre; 
    private Integer cliente;
    private Integer folio; 
    private String status;
    private String tarjeta;
    private Integer id;
    
     public ModeloTarjeta(Integer id_formulario, String nombre, int cliente, int folio, String status, String tarjeta, int id) {
        this.id_formulario = id_formulario;
        this.nombre = nombre;
        this.cliente = cliente;
        this.folio = folio;
        this.status = status;
        this.tarjeta = tarjeta;
        this.id = id;
    }

    public ModeloTarjeta() {
         this.id_formulario = null;
        this.nombre = null;
        this.cliente = null;
        this.folio = null;
        this.status = null;
        this.tarjeta = null;
        this.id = null;
        }
     public Integer getId_formulario() {
        return id_formulario;
    }

    public void setId_formulario(Integer id_formulario) {
        this.id_formulario = id_formulario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
