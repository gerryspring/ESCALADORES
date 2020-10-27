package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener {

    JMenuBar mb;
    JMenu MenuColores,MenuAnimales,MenuProfesiones,MenuAutos;
    JMenu coloresPasteles;
    JMenuItem pantallaAnimales;
    JMenuItem colorAzul,colorRojo,colorAmarillo;
    JMenuItem colorBeige,colorRosa,colorGris;
    JDialog pan;
    public Menu() {
        super("Manejo de menú");
        HazInterfaz();
        HazEscuchas();
    }
    private void HazInterfaz() {
        setSize(400,300);
        setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // creamos la barra del menu
        mb=new JMenuBar();
        setJMenuBar(mb);
        mb.setBackground(Color.cyan);
        MenuColores=new JMenu("Colores");
        MenuAnimales=new JMenu("Animales");
        MenuProfesiones=new JMenu("Profesiones");
        MenuAutos=new JMenu("Autos");

        mb.add(MenuColores);
        mb.add(MenuAnimales);
        mb.add(MenuProfesiones);
        mb.add(MenuAutos);


        colorAzul=new JMenuItem("Azul");
        colorRojo=new JMenuItem("Rojo");
        colorAmarillo=new JMenuItem("Amarillo");
        MenuColores.add(colorAzul);
        MenuColores.add(colorRojo);
        MenuColores.add(colorAmarillo);
        coloresPasteles=new JMenu("Colores pasteles");
        MenuColores.add(coloresPasteles);
        coloresPasteles.add(colorBeige=new JMenuItem("Beige"));
        coloresPasteles.add(colorRosa=new JMenuItem("Rosa"));
        coloresPasteles.add(colorGris=new JMenuItem("Gris"));

        pantallaAnimales=new JMenuItem("pantalla");
        MenuAnimales.add(pantallaAnimales);

        setVisible(true);
        pan=new JDialog();
        pan.setTitle("Manejo de animales");
        pan.setSize(600,400);
        pan.setLocationRelativeTo(null);
        pan.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pan.setModal(true);


    }
    private void HazEscuchas() {
        colorAzul.addActionListener(this);
        colorRojo.addActionListener(this);
        colorAmarillo.addActionListener(this);
        colorRosa.addActionListener(this);
        pantallaAnimales.addActionListener(this);
    }
    public static void main(String []a) {
        new Menu();
    }
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource()==colorAzul) {
            this.getContentPane().setBackground(Color.BLUE);
            mb.setBackground(Color.GREEN);
            return;
        }
        if(evt.getSource()==colorRojo) {
            this.getContentPane().setBackground(Color.RED);
            return;
        }
        if(evt.getSource()==colorAmarillo) {
            this.getContentPane().setBackground(Color.YELLOW);
            return;
        }
        if(evt.getSource()==colorRosa) {
            this.getContentPane().setBackground(Color.PINK);
            return;
        }
        if(evt.getSource()==pantallaAnimales) {

            pan.setVisible(true);
            return;
        }
    }
}