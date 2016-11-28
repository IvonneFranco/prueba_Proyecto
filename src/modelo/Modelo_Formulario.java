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
public class Modelo_Formulario {
             
    private final Integer id_formulario;
    private String nombre;
    private Integer cliente;
    private String tipousuario;
    private Integer nip;
    
    public Modelo_Formulario() {
        this.id_formulario = null;
        this.nombre = null;
        this.cliente = null;
        this.tipousuario = null;
        this.nip = null;
    }
    public Modelo_Formulario(Integer id_formulario, String nombre, Integer cliente, String tipousuario, Integer nip) {
        this.id_formulario = id_formulario;
        this.nombre = nombre;
        this.cliente = cliente;
        this.tipousuario = tipousuario;
        this.nip = nip;
    }
     public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public String getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }

    public Integer getNip() {
        return nip;
    }

    public void setNip(Integer nip) {
        this.nip = nip;
    }
    @Override
     public String toString() {
        return "Modelo_Formulario{" + "id_formulario=" + id_formulario + ", nombre=" + nombre + ", cliente=" + cliente + ", tipousuario=" + tipousuario + ", nip=" + nip + '}';
    }
    
}
