/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import codigo.TipoToken;
import java.util.ArrayList;

/**
 *
 * @author liset
 */
public class Token {
    public String nombre;
    public TipoToken tipo;
    public ArrayList lineas;

    public Token(String nombre, TipoToken tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.lineas = new ArrayList();
    }
    public void agregarLinea(int linea){
        this.lineas.add(linea);
    }
    public int cantidadLineas(){
        return this.lineas.size();
    }
    public int obtenerLinea(int indice){
        return (int) this.lineas.get(indice);
    }

    public ArrayList getLineas() {
        return lineas;
    }
    
}
