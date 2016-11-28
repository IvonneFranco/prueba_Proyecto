/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import modelo.Modelo_Formulario;

/**
 *
 * @author Ivonne Franco
 */
public class Valida_Campos {
    
    Controlador_Formulario formulario = new Controlador_Formulario();
    /*
     * método para validar que contenga números un campo.
     *
    */
    
    public int  validanumero(String dato){
        int numero_cliente =0;
        if (dato.matches("[0-9]*")){
            numero_cliente=Integer.parseInt(dato);
            return numero_cliente;
        }else{
            return 0;
        }
    }
    /*
     * método para validar que un campo únicamente contega letras y números 
     * No *<>/*+-} etc.
     *
    */
    public String validaalfanumericos(String dato){
        char[] arreglocadena =dato.toCharArray();
        String valor ="";
        int contarvalor =0;
        int cuentafinal =dato.length();
        int sumarfinal = cuentafinal;
        for (int i = 0; i < arreglocadena.length; i++) {
            valor = arreglocadena[i]+"";
            if(validaletras(valor).equals("0")){
                if(validanumero(valor) != 0){
                    contarvalor ++;
                }else{
                    sumarfinal --;
                }
            }else{
                 contarvalor ++;
            }
        }
        if(sumarfinal == cuentafinal && sumarfinal != 0){
             return "1";
        }else{
            return "0";
        }
        
       
    }
    /*
     * método para validar que contenga letras un campo.
     *
    */
    public String  validaletras(String letras){
        
        String letra = "";
        if (letras.matches("[a-z]*")){
            
            return letras;
        }else{
            return "0";
        }
    }
    /*
     * método generador de folios en un con un random utilizando función math.
     * proyecto futuro utilizar números de Euler. o algoritmos con factorización.
    */
    public int generafolio(){
        int varible = (int)(Math.random()*(999999999-100000000+1)+100000000);
        return varible;
    }
    
}
