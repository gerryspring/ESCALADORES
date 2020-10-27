package test;

import modelo.Utilerias;

import javax.swing.*;
import java.awt.*;

class myLienzo extends Canvas {
    private String nomImagen;

        public myLienzo(String nomImagen){
//            this.setSize(200,200);
            this.nomImagen = nomImagen;
        }

    public void paint(Graphics g){

            g.drawImage(Utilerias.AjustarImagen(nomImagen,70,120).getImage(),0,0,null);


        }

}


    public class GraficoLienzoCanvas extends JFrame {
        myLienzo lienzo1, lienzo2, lienzo3, lienzo4;
        JPanel panel;

        public GraficoLienzoCanvas(){
            super("Manejo de multiples lienzos.");
                HazInterfaz();
                HazEscuchas();

        }

        private void HazInterfaz(){

            setSize(500,400);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            lienzo1 = new myLienzo("MarioIconos/rojo1.png");
            lienzo2 = new myLienzo("MarioIconos/verde1.png");
            lienzo3 = new myLienzo("MarioIconos/amarillo1.png");
            lienzo4 = new myLienzo("MarioIconos/negro1.png");

            panel = new JPanel();
            panel.setLayout(new GridLayout(0,2));



            panel.add(lienzo1);
            panel.add(lienzo2);
            panel.add(lienzo3);
            panel.add(lienzo4);

            add(panel);
            setVisible(true);
        }


        private void HazEscuchas(){

        }

        public static void main(String[] args) {
            new GraficoLienzoCanvas();
        }

}

