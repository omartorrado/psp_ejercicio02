/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_ejercicio02;

/**
 *
 * @author otorradomiguez
 */
public class Almacen {
    private final int maximo=20000;
    private int stock=8000;
    private boolean hayError=false;
    
    public void entrada(int carga){
        if(stock+carga<=maximo){
            stock+=carga;
            System.out.println("Llegan "+carga+" piezas");
            System.out.println("Stock: "+stock);
        }else{
            System.out.println("Almacen lleno");
            hayError=true;
        }
    }
    
    public void salida(int piezas){
        if(stock>=piezas){
            stock-=piezas;
            System.out.println("Se envian "+piezas+" piezas");
            System.out.println("Stock: "+stock);
        }else{
            System.out.println("No hay stock suficiente para "+piezas+" piezas");
            hayError=true;
        }
    }
    
    public boolean error(){
        return hayError;
    }
}
