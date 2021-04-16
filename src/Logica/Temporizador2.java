/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Grafico2.Juego.*;
/**
 *
 * @author jaime
 */
public class Temporizador2 extends Thread {
    public Temporizador2 () {// Contructor porque la clase es heredada 
        super();
    }
    public static int nuMin;//El Contador de minutos
    public static int nuSeg;//El Contador de de segundos
    public static int nuHora;//El Contador de Horas  
    public static boolean continua=true;
    @Override
    public void run() {
           try {//si ocurre un error al dormir el proceso(sleep(999))
                while(nuMin!=0 || nuSeg!=0 || nuHora!=0){//inicio del for infinito          
                    if(nuSeg!=0) {//si no es el ultimo segundo
                        nuSeg--;  //decremento el numero de segundos                                  
                    }else{
                        if(nuMin!=0){//si no es el ultimo minuto
                            nuSeg=59;//segundos comienzan en 59
                            nuMin--;//decremento el numero de minutos
                        }else{
                            if (nuHora!=0){
                                nuHora--;//decremento el numero de horas
                                nuMin=59;//minutos comienzan en 59
                                nuSeg=59;//segundos comienzan en 59
                            }
                    }
                }               
                Grafico2.Juego.jLabel1.setText(nuHora+":"+nuMin+":"+nuSeg);//Muestro en pantalla el temporizador
                System.out.println(nuHora+":"+nuMin+":"+nuSeg);
                sleep(998);//Duermo el hilo durante 999 milisegundos(casi un segundo, quintandole el tiempo de proceso)
                }
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
            Grafico2.Juego.music.stop();
            Grafico2.Juego obj = new Grafico2.Juego();
            obj.acaba();
        
    }
}
