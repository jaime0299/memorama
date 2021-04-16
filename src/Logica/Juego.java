/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Random;

/**
 *
 * @author jaime
 */
public class Juego {
    
    public int[] numerosCartas(int n){
        int numeros[]=new int[n];
        int count = 0;
        while (count<n){
            Random r=new Random();
            int na=r.nextInt(n/2)+1;
            int nvr=0;
            
            for(int i=0;i<n;i++){
                if(numeros[i]==na){
                    nvr++;
                }
            }
            if (nvr<2){
                numeros[count]=na;
                count++;
            }
        }
        return numeros;
    }
}
