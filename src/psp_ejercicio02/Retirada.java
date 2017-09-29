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
public class Retirada extends Thread {

    Random rd = new Random();
    Almacen almacen;
    int dias = 1;

    public Retirada(String name, Almacen almacen) {
        super(name);
        this.almacen = almacen;
    }

    @Override
    public void run() {
        try {
            while (!almacen.error()) {
                System.out.println("Dia " + dias);
                sleep(2400);
                almacen.salida(1000+rd.nextInt(2000));
                dias++;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Retirada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
