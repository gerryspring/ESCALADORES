package modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Semaforo extends Canvas implements ActionListener {

    Timer T , Check;

    Lienzo [] lienzos;

    boolean luces[];

    int pos = 1;
    int drawlocation = 0;

    Graphics g;
    Image buffer = null;

    public Semaforo(Lienzo jugadores []){
        this.lienzos = jugadores;

        luces = new boolean[3];

        Arrays.fill(luces,false);
        T  = new Timer(3000,this);
        Check = new Timer(200,this);
    }



    public void paint(Graphics g){
        if(buffer==null){
            buffer = createImage(getWidth(),getHeight());
            repaint();
            return;
        }

        if(this.g == null)
            this.g = buffer.getGraphics();

        Dibuja();
        g.drawImage(buffer,0,0,getWidth(),getHeight(),this);

    }
    public void Dibuja() {

        if(!luces[0])
            g.drawImage(Rutinas.AjustarImagen("semafororojo.png", this.getWidth(), this.getHeight()).getImage(), 0, 0, null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == T) {
            if (!luces[1]) {

                luces[0] = true; // semaforo verde deshabilitado
                g.drawImage(Rutinas.AjustarImagen("semaforoamarillo.png", this.getWidth(), this.getHeight()).getImage(), 0, 0, null);

                luces[1] = true;// semaforo amarillo deshabilitado

                repaint();
                return;
            }

            if (!luces[2]) {
                g.drawImage(Rutinas.AjustarImagen("semaforoverde.png", this.getWidth(), this.getHeight()).getImage(), 0, 0, null);
                T.stop();
                go(); //Empiezan a escalar
            }
            repaint();
        }
        if(e.getSource() == Check){
            for(int i=0;i<lienzos.length-1;i++) {
                if (lienzos[i].getdone()) {

                    if(pos ==1)
                        g.drawImage(Rutinas.AjustarImagen("pared.png", this.getWidth(), this.getHeight()).getImage(), 0, 0, null);

                    lienzos[i].setWinPos(pos);

                    if(pos <6) {

                        String mario ="MarioFaces/";

                        switch (lienzos[i].getDrawpos()){
                            case 1:mario += "facerojo.png";
                                break;
                            case 3:mario += "faceamarillo.png";
                                break;
                            case 5:mario += "faceblanco.png";
                                break;
                            case 7:mario += "facecafe.png";
                                break;
                            case 9:mario += "facemorado.png";
                                break;
                            case 11:mario += "facenegro.png";
                                break;
                            case 13:mario += "facerosa.png";
                                break;
                            case 15:mario += "faceverde.png";
                                break;
                            default: break;
                        }
                        g.drawImage(Rutinas.AjustarImagen(mario,this.getWidth(),160).getImage(),0, drawlocation,null);
                        drawlocation += 150;
                    }

                    repaint(); //**
                    pos++;
                }
                if(pos == lienzos.length){
                    Check.stop();
                }

            }
            for(int p=0;p<lienzos.length-1;p++){
                if(lienzos[p].getWinpos()>1)
                    lienzos[p].die();
            }
        }
    }

    private void go(){
        for(int i=0;i<lienzos.length-1;i++)
            lienzos[i].start();

        Check.start();

    }

    public void start(){
        T.start();
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

}
