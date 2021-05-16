/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

/**
 *
 * @author liset
 */
public class TablaSimbolos {
    Hashtable<String,Token> tabla;
    ArrayList<String> llaves ;
    public TablaSimbolos() {
        this.tabla = new Hashtable<>();
        this.llaves = new ArrayList();
    }
    public void agregarToken(Token nuevo,int linea){
        
        if(llaves.contains(nuevo.nombre)){
            tabla.get(nuevo.nombre).agregarLinea(linea);
            
        }   
        else{
            tabla.put(nuevo.nombre,nuevo);
            tabla.get(nuevo.nombre).agregarLinea(linea);
            llaves.add(nuevo.nombre);
        }
    }
    public String imprimirTablaSimbolos(){
        String simbolos = "Token                      Tipo de Token                       Linea\n\n";
        String lineas = "                       ";
        int linea;
        ArrayList lineasEncontradas = new ArrayList();
        
        for(int i=0;i<tabla.size();i++){
            simbolos += tabla.get(llaves.get(i)).nombre+ "                             " + tabla.get(llaves.get(i)).tipo.name();
            lineasEncontradas.clear();
            for(int k = 0 ; k < tabla.get(llaves.get(i)).cantidadLineas();k++){
                linea = (int) tabla.get(llaves.get(i)).obtenerLinea(k);
                if(Collections.frequency(tabla.get(llaves.get(i)).getLineas(),linea) > 1 && !lineasEncontradas.contains(linea)){
                    lineas +=  String.valueOf(linea) + "(" + String.valueOf(Collections.frequency(tabla.get(llaves.get(i)).getLineas(),linea))+")";
                    lineasEncontradas.add(linea);
                }
                else if (!lineasEncontradas.contains(linea)){
                    lineas +=String.valueOf(linea);
                }
                if(k <= tabla.get(llaves.get(i)).cantidadLineas()-1)
                    lineas+=",";
            
            }
            simbolos += lineas + "\n";
            lineas = "                       ";
        }
     
        return simbolos;
 
        
        
    }
    
    /*Metodo para mostrar los tokens en pantalla
    Guarda todos los tokens en una lista*/
    public ArrayList<String[]> getTokens() {
        ArrayList<String[]> tokens = new ArrayList<>();
        Integer linea;
        String lines, name, type;
        ArrayList lineasEncontradas = new ArrayList();
        for(Integer i=0;i<tabla.size();i++){
            name = tabla.get(llaves.get(i)).nombre;
            type = tabla.get(llaves.get(i)).tipo.name();
            lines = "";
            lineasEncontradas.clear();
            /*Revisar esto!!!*/
            for(int k = 0 ; k < tabla.get(llaves.get(i)).cantidadLineas();k++){
                linea = tabla.get(llaves.get(i)).obtenerLinea(k);
                if(Collections.frequency(tabla.get(llaves.get(i)).getLineas(),linea) > 1 && !lineasEncontradas.contains(linea)){
                    lines +=  String.valueOf(linea) + "(" + String.valueOf(Collections.frequency(tabla.get(llaves.get(i)).getLineas(),linea))+"),";
                    lineasEncontradas.add(linea);
                }
                else if (!lineasEncontradas.contains(linea)){
                    lines +=String.valueOf(linea)+",";
                }
            }
            lines = lines.substring(0, lines.length() - 1);
            String[] t  = {name,type,lines};
            tokens.add(t);
        }
        return tokens;
    }
}
