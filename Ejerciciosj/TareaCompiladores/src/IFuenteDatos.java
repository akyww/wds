/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joel
 */
public interface IFuenteDatos {
    void abrir();
    void cerrar();
    boolean vacia();
    String leer();
}

