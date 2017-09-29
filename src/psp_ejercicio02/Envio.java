/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_ejercicio02;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author otorradomiguez
 */
public class Envio extends Thread {

    Random rd = new Random();
    Almacen almacen;

    public Envio(String name, Almacen almacen) {
        super(name);
        this.almacen = almacen;
    }

    @Override
    public void run() {
        try {
            while (!almacen.error()) {
                sleep(800);
                almacen.entrada(rd.nextInt(100));
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Envio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
