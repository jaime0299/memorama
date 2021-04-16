/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafico2;
import Grafico.*;
import Logica.Juego.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import Logica.Temporizador2.*;
import Grafico.HiloMusica.*;
import Grafico.Principal.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author jaime
 */
public class Juego extends javax.swing.JFrame {
    
    public Logica.Juego log=new Logica.Juego();
    public boolean volteada=false, volteada2=false, sigue=true;
    public ImageIcon ima1,img,ima2;
    public static JButton[] btns=new JButton[2], tods=new JButton[32];
    public int aciertos=0,n,indicasonido;
    public int[] numeros;
    public HiloMusica hilo;
    public static Thread tem,music;
    
    public Juego() {
        initComponents();
        
    }
    
    public void sonido(){
        String son="";
        if (indicasonido==1){
            son="correcto.mp3";
        }else if (indicasonido==2){
            son="incorrecto.mp3";
        }else if (indicasonido==3){
            son="gana.mp3";
        }else if (indicasonido==4){
            son="pierde.mp3";
        }
        
          try {
            FileInputStream fis;
            Player player;
            fis = new FileInputStream(son);
            
            BufferedInputStream bis = new BufferedInputStream(fis);

            player = new Player(bis);
            player.play();         
        } catch (JavaLayerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void lista(){
        tods[0]=c1;
        tods[1]=c2;
        tods[2]=c3;
        tods[3]=c4;
        tods[4]=c5;
        tods[5]=c6;
        tods[6]=c7;
        tods[7]=c8;
        tods[8]=c9;
        tods[9]=c10;
        tods[10]=c11;
        tods[11]=c12;
        tods[12]=c13;
        tods[13]=c14;
        tods[14]=c15;
        tods[15]=c16;
        tods[16]=c17;
        tods[17]=c18;
        tods[18]=c19;
        tods[19]=c20;
        tods[20]=c21;
        tods[21]=c22;
        tods[22]=c23;
        tods[23]=c24;
        tods[24]=c25;
        tods[25]=c26;
        tods[26]=c27;
        tods[27]=c28;
        tods[28]=c29;
        tods[29]=c30;
        tods[30]=c31;
        tods[31]=c32;
    }
    
    public void inicia(){
        lista();
        if(Grafico.Principal.facil.isSelected()){
            n=15;
            Logica.Temporizador2.nuHora=0;
            Logica.Temporizador2.nuMin=1;
            Logica.Temporizador2.nuSeg=0;
        }else if(Grafico.Principal.medio.isSelected()){
            n=23;
            Logica.Temporizador2.nuHora=0;
            Logica.Temporizador2.nuMin=1;
            Logica.Temporizador2.nuSeg=40;
        }else{
            n=31;
            Logica.Temporizador2.nuHora=0;
            Logica.Temporizador2.nuMin=2;
            Logica.Temporizador2.nuSeg=20;
        }
        int[] numeros=log.numerosCartas(n+1);
        
        for(int i=0;i<=n;i++){
            tods[i].setDisabledIcon(new ImageIcon(getClass().getResource("../Anime/c"+numeros[i]+".jpg")));
        }
        if(n<31){
            for(int i=n+1;i<=31;i++){
                tods[i].setVisible(false);
            }
        }
        Logica.Temporizador2 tempo=new Logica.Temporizador2();
        tem=new Thread(tempo);
        tem.start();
        hilo=new HiloMusica();
        music=new Thread(hilo);
        music.start();
    }
    
    public void Cambio(JButton btn){
        if (!volteada){
            btn.setEnabled(false);
            ima1=(ImageIcon) btn.getDisabledIcon();
            btns[0]=btn;
            volteada=true;
            volteada2=false;
        }else{
            btn.setEnabled(false);
            ima2=(ImageIcon) btn.getDisabledIcon();
            btns[1]=btn;
            volteada2=true;
        }
    }
    
    public void Compara(){
        if(volteada && volteada2){
            if(ima1.getDescription().compareTo(ima2.getDescription())!=0){
                btns[0].setEnabled(true);
                btns[1].setEnabled(true);
                indicasonido=2;
            }else{
                aciertos++;
                indicasonido=1;
            }
            volteada=false;
            sonido();
        }
        if (aciertos==(n+1)/2 && sigue){
            tem.stop();
            music.stop();
            indicasonido=3;
            sonido();
            JOptionPane.showMessageDialog(this, "Felicidades. Has Ganado!");
            sigue=false;
        }
    }
    public void acaba(){
        if(Logica.Temporizador.continua){
        music.stop();
        indicasonido=4;
        sonido();
        JOptionPane.showMessageDialog(this, "Has perdido. Te quedaste sin tiempo");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        c1 = new javax.swing.JButton();
        c2 = new javax.swing.JButton();
        c3 = new javax.swing.JButton();
        c4 = new javax.swing.JButton();
        c5 = new javax.swing.JButton();
        c6 = new javax.swing.JButton();
        c7 = new javax.swing.JButton();
        c8 = new javax.swing.JButton();
        c9 = new javax.swing.JButton();
        c10 = new javax.swing.JButton();
        c11 = new javax.swing.JButton();
        c12 = new javax.swing.JButton();
        c13 = new javax.swing.JButton();
        c14 = new javax.swing.JButton();
        c15 = new javax.swing.JButton();
        c16 = new javax.swing.JButton();
        c17 = new javax.swing.JButton();
        c18 = new javax.swing.JButton();
        c19 = new javax.swing.JButton();
        c20 = new javax.swing.JButton();
        c22 = new javax.swing.JButton();
        c23 = new javax.swing.JButton();
        c24 = new javax.swing.JButton();
        c27 = new javax.swing.JButton();
        c28 = new javax.swing.JButton();
        c31 = new javax.swing.JButton();
        c32 = new javax.swing.JButton();
        c21 = new javax.swing.JButton();
        c25 = new javax.swing.JButton();
        c29 = new javax.swing.JButton();
        c26 = new javax.swing.JButton();
        c30 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        c1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c1.setBorder(null);
        c1.setBorderPainted(false);
        c1.setContentAreaFilled(false);
        c1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c1.setFocusable(false);
        c1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c1MouseExited(evt);
            }
        });
        c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c1ActionPerformed(evt);
            }
        });

        c2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c2.setBorder(null);
        c2.setBorderPainted(false);
        c2.setContentAreaFilled(false);
        c2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c2.setFocusable(false);
        c2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c2MouseExited(evt);
            }
        });
        c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c2ActionPerformed(evt);
            }
        });

        c3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c3.setBorder(null);
        c3.setBorderPainted(false);
        c3.setContentAreaFilled(false);
        c3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c3.setFocusable(false);
        c3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c3MouseExited(evt);
            }
        });
        c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c3ActionPerformed(evt);
            }
        });

        c4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c4.setBorder(null);
        c4.setBorderPainted(false);
        c4.setContentAreaFilled(false);
        c4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c4.setFocusable(false);
        c4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c4MouseExited(evt);
            }
        });
        c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c4ActionPerformed(evt);
            }
        });

        c5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c5.setBorder(null);
        c5.setBorderPainted(false);
        c5.setContentAreaFilled(false);
        c5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c5.setFocusable(false);
        c5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c5MouseExited(evt);
            }
        });
        c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c5ActionPerformed(evt);
            }
        });

        c6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c6.setBorder(null);
        c6.setBorderPainted(false);
        c6.setContentAreaFilled(false);
        c6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c6.setFocusable(false);
        c6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c6MouseExited(evt);
            }
        });
        c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c6ActionPerformed(evt);
            }
        });

        c7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c7.setBorder(null);
        c7.setBorderPainted(false);
        c7.setContentAreaFilled(false);
        c7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c7.setFocusable(false);
        c7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c7MouseExited(evt);
            }
        });
        c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c7ActionPerformed(evt);
            }
        });

        c8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c8.setBorder(null);
        c8.setBorderPainted(false);
        c8.setContentAreaFilled(false);
        c8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c8.setFocusable(false);
        c8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c8MouseExited(evt);
            }
        });
        c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c8ActionPerformed(evt);
            }
        });

        c9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c9.setBorder(null);
        c9.setBorderPainted(false);
        c9.setContentAreaFilled(false);
        c9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c9.setFocusable(false);
        c9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c9MouseExited(evt);
            }
        });
        c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c9ActionPerformed(evt);
            }
        });

        c10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c10.setBorder(null);
        c10.setBorderPainted(false);
        c10.setContentAreaFilled(false);
        c10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c10.setFocusable(false);
        c10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c10MouseExited(evt);
            }
        });
        c10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c10ActionPerformed(evt);
            }
        });

        c11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c11.setBorder(null);
        c11.setBorderPainted(false);
        c11.setContentAreaFilled(false);
        c11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c11.setFocusable(false);
        c11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c11MouseExited(evt);
            }
        });
        c11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c11ActionPerformed(evt);
            }
        });

        c12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c12.setBorder(null);
        c12.setBorderPainted(false);
        c12.setContentAreaFilled(false);
        c12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c12.setFocusable(false);
        c12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c12MouseExited(evt);
            }
        });
        c12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c12ActionPerformed(evt);
            }
        });

        c13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c13.setBorder(null);
        c13.setBorderPainted(false);
        c13.setContentAreaFilled(false);
        c13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c13.setFocusable(false);
        c13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c13MouseExited(evt);
            }
        });
        c13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c13ActionPerformed(evt);
            }
        });

        c14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c14.setBorder(null);
        c14.setBorderPainted(false);
        c14.setContentAreaFilled(false);
        c14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c14.setFocusable(false);
        c14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c14MouseExited(evt);
            }
        });
        c14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c14ActionPerformed(evt);
            }
        });

        c15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c15.setBorder(null);
        c15.setBorderPainted(false);
        c15.setContentAreaFilled(false);
        c15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c15.setFocusable(false);
        c15.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c15MouseExited(evt);
            }
        });
        c15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c15ActionPerformed(evt);
            }
        });

        c16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c16.setBorder(null);
        c16.setBorderPainted(false);
        c16.setContentAreaFilled(false);
        c16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c16.setFocusable(false);
        c16.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c16MouseExited(evt);
            }
        });
        c16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c16ActionPerformed(evt);
            }
        });

        c17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c17.setBorder(null);
        c17.setBorderPainted(false);
        c17.setContentAreaFilled(false);
        c17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c17.setFocusable(false);
        c17.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c17MouseExited(evt);
            }
        });
        c17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c17ActionPerformed(evt);
            }
        });

        c18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c18.setBorder(null);
        c18.setBorderPainted(false);
        c18.setContentAreaFilled(false);
        c18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c18.setFocusable(false);
        c18.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c18MouseExited(evt);
            }
        });
        c18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c18ActionPerformed(evt);
            }
        });

        c19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c19.setBorder(null);
        c19.setBorderPainted(false);
        c19.setContentAreaFilled(false);
        c19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c19.setFocusable(false);
        c19.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c19MouseExited(evt);
            }
        });
        c19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c19ActionPerformed(evt);
            }
        });

        c20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c20.setBorder(null);
        c20.setBorderPainted(false);
        c20.setContentAreaFilled(false);
        c20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c20.setFocusable(false);
        c20.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c20MouseExited(evt);
            }
        });
        c20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c20ActionPerformed(evt);
            }
        });

        c22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c22.setBorder(null);
        c22.setBorderPainted(false);
        c22.setContentAreaFilled(false);
        c22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c22.setFocusable(false);
        c22.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c22MouseExited(evt);
            }
        });
        c22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c22ActionPerformed(evt);
            }
        });

        c23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c23.setBorder(null);
        c23.setBorderPainted(false);
        c23.setContentAreaFilled(false);
        c23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c23.setFocusable(false);
        c23.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c23MouseExited(evt);
            }
        });
        c23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c23ActionPerformed(evt);
            }
        });

        c24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c24.setBorder(null);
        c24.setBorderPainted(false);
        c24.setContentAreaFilled(false);
        c24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c24.setFocusable(false);
        c24.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c24MouseExited(evt);
            }
        });
        c24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c24ActionPerformed(evt);
            }
        });

        c27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c27.setBorder(null);
        c27.setBorderPainted(false);
        c27.setContentAreaFilled(false);
        c27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c27.setFocusable(false);
        c27.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c27MouseExited(evt);
            }
        });
        c27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c27ActionPerformed(evt);
            }
        });

        c28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c28.setBorder(null);
        c28.setBorderPainted(false);
        c28.setContentAreaFilled(false);
        c28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c28.setFocusable(false);
        c28.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c28MouseExited(evt);
            }
        });
        c28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c28ActionPerformed(evt);
            }
        });

        c31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c31.setBorder(null);
        c31.setBorderPainted(false);
        c31.setContentAreaFilled(false);
        c31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c31.setFocusable(false);
        c31.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c31MouseExited(evt);
            }
        });
        c31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c31ActionPerformed(evt);
            }
        });

        c32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c32.setBorder(null);
        c32.setBorderPainted(false);
        c32.setContentAreaFilled(false);
        c32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c32.setFocusable(false);
        c32.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c32MouseExited(evt);
            }
        });
        c32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c32ActionPerformed(evt);
            }
        });

        c21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c21.setBorder(null);
        c21.setBorderPainted(false);
        c21.setContentAreaFilled(false);
        c21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c21.setFocusable(false);
        c21.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c21MouseExited(evt);
            }
        });
        c21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c21ActionPerformed(evt);
            }
        });

        c25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c25.setBorder(null);
        c25.setBorderPainted(false);
        c25.setContentAreaFilled(false);
        c25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c25.setFocusable(false);
        c25.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c25MouseExited(evt);
            }
        });
        c25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c25ActionPerformed(evt);
            }
        });

        c29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c29.setBorder(null);
        c29.setBorderPainted(false);
        c29.setContentAreaFilled(false);
        c29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c29.setFocusable(false);
        c29.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c29MouseExited(evt);
            }
        });
        c29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c29ActionPerformed(evt);
            }
        });

        c26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c26.setBorder(null);
        c26.setBorderPainted(false);
        c26.setContentAreaFilled(false);
        c26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c26.setFocusable(false);
        c26.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c26MouseExited(evt);
            }
        });
        c26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c26ActionPerformed(evt);
            }
        });

        c30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso.jpg"))); // NOI18N
        c30.setBorder(null);
        c30.setBorderPainted(false);
        c30.setContentAreaFilled(false);
        c30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c30.setFocusable(false);
        c30.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Anime/reverso2.jpg"))); // NOI18N
        c30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c30MouseExited(evt);
            }
        });
        c30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c30ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(c13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(c9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c12))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(c5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(c6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(c7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(c8))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(c1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(c2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(c3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(c4))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(c20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c24)
                        .addGap(12, 12, 12)
                        .addComponent(c31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(c19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(c27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c28))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(c18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(c22)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(c26)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(c30))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(c17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(c21)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(c25)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(c29))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(c17)
                                    .addComponent(c21)
                                    .addComponent(c25)
                                    .addComponent(c29))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(c22)
                                    .addComponent(c18)
                                    .addComponent(c26)
                                    .addComponent(c30))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(c27)
                                        .addComponent(c28))
                                    .addComponent(c19)))
                            .addComponent(c23))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(c31)
                            .addComponent(c32)
                            .addComponent(c20)
                            .addComponent(c24)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(c1)
                            .addComponent(c2)
                            .addComponent(c3)
                            .addComponent(c4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(c5)
                            .addComponent(c6)
                            .addComponent(c7)
                            .addComponent(c8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(c9)
                            .addComponent(c10)
                            .addComponent(c11)
                            .addComponent(c12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(c13)
                            .addComponent(c14)
                            .addComponent(c15)
                            .addComponent(c16))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("jLabel2");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Tiempo:");

        jButton1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jButton1)
                .addGap(193, 193, 193)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c1ActionPerformed
        Cambio(c1);
    }//GEN-LAST:event_c1ActionPerformed

    private void c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c2ActionPerformed
        Cambio(c2);
    }//GEN-LAST:event_c2ActionPerformed

    private void c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c3ActionPerformed
        Cambio(c3);
    }//GEN-LAST:event_c3ActionPerformed

    private void c4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c4ActionPerformed
        Cambio(c4);
    }//GEN-LAST:event_c4ActionPerformed

    private void c5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c5ActionPerformed
        Cambio(c5);
    }//GEN-LAST:event_c5ActionPerformed

    private void c6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c6ActionPerformed
        Cambio(c6);
    }//GEN-LAST:event_c6ActionPerformed

    private void c7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c7ActionPerformed
        Cambio(c7);
    }//GEN-LAST:event_c7ActionPerformed

    private void c8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c8ActionPerformed
        Cambio(c8);
    }//GEN-LAST:event_c8ActionPerformed

    private void c9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c9ActionPerformed
        Cambio(c9);
    }//GEN-LAST:event_c9ActionPerformed

    private void c10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c10ActionPerformed
        Cambio(c10);
    }//GEN-LAST:event_c10ActionPerformed

    private void c11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c11ActionPerformed
        Cambio(c11);
    }//GEN-LAST:event_c11ActionPerformed

    private void c12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c12ActionPerformed
        Cambio(c12);
    }//GEN-LAST:event_c12ActionPerformed

    private void c13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c13ActionPerformed
        Cambio(c13);
    }//GEN-LAST:event_c13ActionPerformed

    private void c14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c14ActionPerformed
        Cambio(c14);
    }//GEN-LAST:event_c14ActionPerformed

    private void c15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c15ActionPerformed
        Cambio(c15);
    }//GEN-LAST:event_c15ActionPerformed

    private void c16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c16ActionPerformed
        Cambio(c16);
    }//GEN-LAST:event_c16ActionPerformed

    private void c1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c1MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c1MouseExited

    private void c2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c2MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c2MouseExited

    private void c3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c3MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c3MouseExited

    private void c4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c4MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c4MouseExited

    private void c5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c5MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c5MouseExited

    private void c6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c6MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c6MouseExited

    private void c7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c7MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c7MouseExited

    private void c8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c8MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c8MouseExited

    private void c9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c9MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c9MouseExited

    private void c10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c10MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c10MouseExited

    private void c11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c11MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c11MouseExited

    private void c12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c12MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c12MouseExited

    private void c13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c13MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c13MouseExited

    private void c14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c14MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c14MouseExited

    private void c15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c15MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c15MouseExited

    private void c16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c16MouseExited
        // TODO add your handling code here:Compara();
        Compara();
    }//GEN-LAST:event_c16MouseExited

    private void c17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c17MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c17MouseExited

    private void c17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c17ActionPerformed
        // TODO add your handling code here:
        Cambio(c17);
    }//GEN-LAST:event_c17ActionPerformed

    private void c18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c18MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c18MouseExited

    private void c18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c18ActionPerformed
        // TODO add your handling code here:
        Cambio(c18);
    }//GEN-LAST:event_c18ActionPerformed

    private void c19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c19MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c19MouseExited

    private void c19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c19ActionPerformed
        // TODO add your handling code here:
        Cambio(c19);
    }//GEN-LAST:event_c19ActionPerformed

    private void c20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c20MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c20MouseExited

    private void c20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c20ActionPerformed
        // TODO add your handling code here:
        Cambio(c20);
    }//GEN-LAST:event_c20ActionPerformed

    private void c21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c21MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c21MouseExited

    private void c21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c21ActionPerformed
        // TODO add your handling code here:
        Cambio(c21);
    }//GEN-LAST:event_c21ActionPerformed

    private void c22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c22MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c22MouseExited

    private void c22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c22ActionPerformed
        // TODO add your handling code here:
        Cambio(c22);
    }//GEN-LAST:event_c22ActionPerformed

    private void c23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c23MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c23MouseExited

    private void c23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c23ActionPerformed
        // TODO add your handling code here:
        Cambio(c23);
    }//GEN-LAST:event_c23ActionPerformed

    private void c24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c24MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c24MouseExited

    private void c24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c24ActionPerformed
        // TODO add your handling code here:
        Cambio(c24);
    }//GEN-LAST:event_c24ActionPerformed

    private void c25MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c25MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c25MouseExited

    private void c25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c25ActionPerformed
        // TODO add your handling code here:
        Cambio(c25);
    }//GEN-LAST:event_c25ActionPerformed

    private void c26MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c26MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c26MouseExited

    private void c26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c26ActionPerformed
        // TODO add your handling code here:
        Cambio(c26);
    }//GEN-LAST:event_c26ActionPerformed

    private void c27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c27MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c27MouseExited

    private void c27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c27ActionPerformed
        // TODO add your handling code here:
        Cambio(c27);
    }//GEN-LAST:event_c27ActionPerformed

    private void c28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c28MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c28MouseExited

    private void c28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c28ActionPerformed
        // TODO add your handling code here:
        Cambio(c28);
    }//GEN-LAST:event_c28ActionPerformed

    private void c29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c29MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c29MouseExited

    private void c29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c29ActionPerformed
        // TODO add your handling code here:
        Cambio(c29);
    }//GEN-LAST:event_c29ActionPerformed

    private void c30MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c30MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c30MouseExited

    private void c30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c30ActionPerformed
        // TODO add your handling code here:
        Cambio(c30);
    }//GEN-LAST:event_c30ActionPerformed

    private void c31MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c31MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c31MouseExited

    private void c31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c31ActionPerformed
        // TODO add your handling code here:
        Cambio(c31);
    }//GEN-LAST:event_c31ActionPerformed

    private void c32MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c32MouseExited
        // TODO add your handling code here:
        Compara();
    }//GEN-LAST:event_c32MouseExited

    private void c32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c32ActionPerformed
        Cambio(c32);
    }//GEN-LAST:event_c32ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Principal obj=new Principal();
        tem.stop();
        music.stop();
        dispose();
        obj.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton c1;
    public static javax.swing.JButton c10;
    public static javax.swing.JButton c11;
    public static javax.swing.JButton c12;
    public static javax.swing.JButton c13;
    public static javax.swing.JButton c14;
    public static javax.swing.JButton c15;
    public static javax.swing.JButton c16;
    public static javax.swing.JButton c17;
    public static javax.swing.JButton c18;
    public static javax.swing.JButton c19;
    public static javax.swing.JButton c2;
    public static javax.swing.JButton c20;
    public static javax.swing.JButton c21;
    public static javax.swing.JButton c22;
    public static javax.swing.JButton c23;
    public static javax.swing.JButton c24;
    public static javax.swing.JButton c25;
    public static javax.swing.JButton c26;
    public static javax.swing.JButton c27;
    public static javax.swing.JButton c28;
    public static javax.swing.JButton c29;
    public static javax.swing.JButton c3;
    public static javax.swing.JButton c30;
    public static javax.swing.JButton c31;
    public static javax.swing.JButton c32;
    public static javax.swing.JButton c4;
    public static javax.swing.JButton c5;
    public static javax.swing.JButton c6;
    public static javax.swing.JButton c7;
    public static javax.swing.JButton c8;
    public static javax.swing.JButton c9;
    private javax.swing.JButton jButton1;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    // End of variables declaration//GEN-END:variables
}
