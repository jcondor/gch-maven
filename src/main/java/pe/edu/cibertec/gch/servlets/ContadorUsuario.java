/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.cibertec.gch.servlets;

/**
 *
 * @author JavaADV-LM
 */
public class ContadorUsuario {
    private static final ContadorUsuario INSTANCIA = new ContadorUsuario();
    private int contador = 0;
    
    private ContadorUsuario() {
    } 
    
    public static ContadorUsuario instancia() {
        return INSTANCIA;
    }
    
    public void sumar() {
        contador++;
    }
    
    public int getContador() {
        return contador;
    }
}
