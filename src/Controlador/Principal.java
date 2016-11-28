/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vistas.Menu;
/**
 *
 * @author Ivonne Franco
 */

public class Principal {
    // aquí podrá correr el sistema.
    
    public static void main(String[] args) {
        
         Menu vista = new Menu();
         vista.setVisible(true);
         vista.setLocationRelativeTo(null);
         
    }

}