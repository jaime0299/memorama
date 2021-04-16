/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafico;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author jaime
 */
public class HiloMusica implements Runnable{
    
    @Override
    public void run() {
        try {
            FileInputStream fis;
            Player player;
            fis = new FileInputStream("m2.mp3");
            
            BufferedInputStream bis = new BufferedInputStream(fis);

            player = new Player(bis);
            player.play();         
        } catch (JavaLayerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       // throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
