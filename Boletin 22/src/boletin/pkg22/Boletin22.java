/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin.pkg22;

import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class Boletin22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Libreria lib = new Libreria();
        lib.leerLibreria();
        int select;
        do{
            select = Integer.parseInt(JOptionPane.showInputDialog("1: Añadir.\n2: Buscar un libro.\n3: Mostrar todos los libros.\n4: Eliminar todos los que tengan 0 unidades.\n5: Modificar libro.\n6: Ordenar libros.\n7: Buscar los libros de un autor.\n8: Guardar datos de la librería.\n9: Salir."));
            switch(select){
                case 1: lib.añadirLibro();
                        break;
                case 2: lib.mostrar();
                        break;
                case 3: lib.mostrarTodo();
                        break;
                case 4: lib.eliminaCero();
                        break;
                case 5: lib.modificar();
                        break;
                case 6: lib.ordenarLibros();
                        break;
                case 7: lib.buscarAutor();
                        break;
                case 8: lib.escribirLibreria();
                        break;
            }
        }while(select<9);
    }
}
