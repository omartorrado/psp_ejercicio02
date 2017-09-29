/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_ejercicio02;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author otorradomiguez
 */
public class Psp_ejercicio02 {

    public static int num = 0;
    public static int dias[] = new int[20];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {            
        for (int n = 0; n < 20; n++) {
            Almacen almacen = new Almacen();
            Envio envio = new Envio("Envio", almacen);
            Retirada retirada = new Retirada("Retirada", almacen);
            num++;            
            envio.start();
            retirada.start();
            try {
                envio.join();
                retirada.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Psp_ejercicio02.class.getName()).log(Level.SEVERE, null, ex);
            }
            dias[n] = retirada.dias;
            n++;
        }
        for (int i = 0; i < 20; i++) {
            System.out.println("Iteracion " + i + " ha tardado " + dias[i]+" dias");
        }

    }
}
