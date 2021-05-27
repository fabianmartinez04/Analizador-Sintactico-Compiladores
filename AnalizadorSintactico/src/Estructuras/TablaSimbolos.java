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
    public void agregarToken(Token nuevo,int linea,int columna){
        
        if(llaves.contains(nuevo.nombre)){
            tabla.get(nuevo.nombre).agregarLinea(linea);
            tabla.get(nuevo.nombre).agregarColumna(columna);
            
        }   
        else{
            tabla.put(nuevo.nombre,nuevo);
            tabla.get(nuevo.nombre).agregarLinea(linea);
            tabla.get(nuevo.nombre).agregarColumna(columna);
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
        Integer columna;
        String lines, name, type,columns;
        ArrayList lineasEncontradas = new ArrayList();
        ArrayList columnasEncontradas = new ArrayList();
        for(Integer i=0;i<tabla.size();i++){
            name = tabla.get(llaves.get(i)).nombre;
            type = tabla.get(llaves.get(i)).tipo.name();
            lines = "";
            columns ="";
            lineasEncontradas.clear();
            columnasEncontradas.clear();
            /*Revisar esto!!!*/
            for (int j=0;j<tabla.get(llaves.get(i)).cantidadColumnas();j++){
                columna = tabla.get(llaves.get(i)).obtenerColumna(j);
                if(Collections.frequency(tabla.get(llaves.get(i)).getColumnas(),columna) > 1 && !columnasEncontradas.contains(columna)){
                    columns +=  String.valueOf(columna) + "(" + String.valueOf(Collections.frequency(tabla.get(llaves.get(i)).getColumnas(),columna))+"),";
                    columnasEncontradas.add(columna);
                }
                else if( !columnasEncontradas.contains(columna)){
                    columns += String.valueOf(columna)+",";
                    
                }
            }
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
            columns = columns.substring(0, columns.length() - 1);
            String[] t  = {name,type,lines,columns};
            tokens.add(t);
        }
        return tokens;
    }
}
