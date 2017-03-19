/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin.pkg22;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import static libreria.Libreria.pedirFloat;
import static libreria.Libreria.pedirInt;
import static libreria.Libreria.str;

/**
 *
 * @author Diego
 */
public class Libreria {
    private ArrayList <Libro> lista;
    private Scanner scan;
    private PrintWriter escribir;
    
    public void añadirLibro(){
        Libro lib = new Libro(str("Título"), str("Autor"), pedirFloat("Precio"), pedirInt("Unidades"));
        lista.add(lib);
    }
    
    public void ordenarLibros(){
        Collections.sort(lista);
    }
    
    public void mostrarTodo(){
        for(Libro lib:lista){
            System.out.println(lib);
        }
    }
    
    public void mostrar(){
        String buscando = str("¿Qué título quieres buscar?");
        int cont=0;
        for(int i = 0; i<lista.size(); i++){
            if(lista.get(i).getTitulo().equals(buscando)){
                System.out.println(lista.get(i));
                cont++;
            }
        }
        if(cont==0){
            System.out.println("No tenemos ese libro.");
        }
    }
    
    public void modificar(){
        String modificar = str("Título del libro a modificar:");
        for(int i = 0; i<lista.size(); i++){
            if(lista.get(i).getTitulo().equals(modificar)){
                lista.get(i).setTitulo(str("Título"));
                lista.get(i).setAutor(str("Autor"));
                lista.get(i).setPrecio(pedirFloat("Precio"));
                lista.get(i).setUnidades(pedirInt("Unidades"));
            }
        }
    }
    
    public void buscarAutor(){
        String buscaAutor = str("Introduce el autor que quieres buscar.");
        for(int i = 0; i<lista.size(); i++){
            if(lista.get(i).getAutor().equals(buscaAutor)){
                System.out.println(lista.get(i));
            }
        }
    }
    
    public void eliminaCero(){
        for(int i = 0; i<lista.size(); i++){
            if(lista.get(i).getUnidades()==0){
                lista.remove(i);
            }
        }
    }
    
    public void leerLibreria(){
        String[]aux;
        lista = new ArrayList <Libro>();
        try{
            scan = new Scanner(new File("libFich.txt"));
            while(scan.hasNextLine()){
                aux = scan.nextLine().split(",");
                Libro lib = new Libro(aux[0], aux[1], Float.parseFloat(aux[2]), Integer.parseInt(aux[3]));
                lista.add(lib);
            }
        }catch(Exception ex){
            System.out.println("Error");
        }finally{
            scan.close();
        }
    }
    
    public void escribirLibreria(){
        try{
            escribir = new PrintWriter(new File("libFich.txt"));
            for(int i = 0; i<lista.size(); i++){
                escribir.println(lista.get(i).getTitulo()+","+lista.get(i).getAutor()+","+lista.get(i).getPrecio()+","+lista.get(i).getUnidades());
            }
        }catch(Exception ex){
            System.out.println(ex + "Error");
        }finally{
            escribir.close();
        }
    }
}
