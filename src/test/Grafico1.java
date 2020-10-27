package test;
import modelo.Utilerias;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

public class Grafico1 extends JFrame implements ActionListener, MouseListener {
    public static void main(String[] args) {
        new Grafico1();
    }

    JButton btnManual, btnContinuoAutomovil,btnContinuoAvion,btnBoth;
    JButton triangulo,rectangulo,poligono,circulo;

    int incAutomovil,incAvion;
    boolean bandAutomovil = true;
    boolean bandAvion = true;
    Timer TAutomovil, TAvion;
    String subImage[] = {"airplane.png", "airplaneback.png"};
    int subAvion = 0;
    JPanel north;
    Box figuras;
    boolean [] vb;

    public Grafico1(){
        super("Manejo de parte grafica");
        incAvion = incAutomovil = 0;
        TAutomovil = new Timer(70,this);
        TAvion = new Timer(25,this);
        TAvion.start();

        hazInterfaz();
        hazEscuchas();
        vb = new boolean[4];
        Arrays.fill(vb,false);
    }

    private void hazInterfaz(){
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        north = new JPanel();
        north.setLayout(new GridLayout(0,3));


        btnManual = new JButton("Avanza");
        btnContinuoAutomovil = new JButton("Movimiento continuo automovil");
        btnContinuoAvion = new JButton("Movimiento continuo avion");
        btnBoth = new JButton("Ambos");
        north.add(btnContinuoAvion);
        north.add(btnBoth);
        north.add(btnContinuoAutomovil);

        add(btnManual,BorderLayout.SOUTH);
        add(north,BorderLayout.NORTH);

        figuras = Box.createVerticalBox();
         triangulo = new JButton(" Triangulo       ");
         circulo = new JButton("Circulo            ");
         rectangulo = new JButton("Rectangulo    ");
         poligono = new JButton(" Poligono        ");

        figuras.add(triangulo);
        figuras.add(circulo);
        figuras.add(rectangulo);
        figuras.add(poligono);


        add(figuras,BorderLayout.EAST);
        this.setVisible(true);

    }

    private void hazEscuchas(){
        btnManual.addActionListener(this);
        btnContinuoAutomovil.addActionListener(this);
        triangulo.addMouseListener(this);
        poligono.addMouseListener(this);
        rectangulo.addMouseListener(this);
        circulo.addMouseListener(this);

    }


    public void paint(Graphics g){
        super.paint(g);
        g.drawString("Instituto Tecnologico de Culiacán",220,70);
        g.drawLine(20,75,580,75);
        g.drawString("Ingeniería en Sistemas Computacionales",190,90);
        g.setColor(Color.BLUE);
        g.fillRect(100,100,100,50);
        g.fillRoundRect(340,100,100,50,20,20);

        Color cafe = new Color(192,128,64);

        g.setColor(cafe);
        g.fillRect(30+ incAutomovil,200,150,80);
        g.setColor(Color.RED);
        g.fillOval(35+ incAutomovil,255,45,45);
        g.fillOval(130+ incAutomovil,255,45,45);
        g.setColor(Color.WHITE);

        if(bandAutomovil)
        g.fillRect(130+incAutomovil,210,50,30);
        else
        g.fillRect(30+incAutomovil,210,50,30);

        g.setColor(Color.black);
        g.drawLine(10,300,590,300);
        g.drawImage(Utilerias.AjustarImagen(subImage[subAvion],100,60).getImage(),incAvion+10,100,null);

        if(vb[0]) {
            g.drawLine(70, 310, 50, 360);
            g.drawLine(70, 310, 90, 360);
            g.drawLine(50, 360, 90, 360);

        }
        if(vb[2]){

            g.fillRect(160,310,80,50);
        }
        if(vb[1]){
            g.fillOval(220,310,45,50);
        }
        if(vb[3]){
            int [] vx = {120,90,150};
            int [] vy = {310,360,360};
            g.fillPolygon(vx,vy,vx.length);

        }
        }


    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * Para actualizar la pantalla existen estos metodos
         * revalidate()
         * repaint()
         * update(getGraphics()) //panel1.update(panel1.getGraphics()) // btn.update(btn.getGraphics())
         */


        if(e.getSource()== btnContinuoAutomovil){
            TAutomovil.setRepeats(true);
            TAutomovil.start();
            btnContinuoAutomovil.setEnabled(false);
            return;
        }

        if(e.getSource() == TAvion){

            if(incAvion <0 || 100+ incAvion > this.getWidth()) {

                if(bandAvion)
                    subAvion = 1;
                else
                    subAvion = 0;

                bandAvion =! bandAvion;
            }

            if(bandAvion)
                incAvion += 10;
            else
                incAvion -= 10;


            repaint();
            return;
        }


        //Coordenadas para indicar el cambio del sentido del vehiculo

        if(incAutomovil <0 || 200+ incAutomovil > this.getWidth())
            bandAutomovil =!bandAutomovil;

        if(bandAutomovil)
            incAutomovil += 10;
        else
            incAutomovil -= 10;



            repaint(10, 150, this.getWidth(), 150);

        }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if(e.getSource()==triangulo) {
         vb[0] = true;
            repaint();
            return;
        }

        if(e.getSource()==circulo) {
            vb[1] = true;
            repaint();
            return;
        }
        if(e.getSource()==rectangulo) {
            vb[2] = true;
            repaint();
            return;
        }
        if(e.getSource()==poligono) {
            vb[3] = true;
            repaint();
            return;
        }


    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==triangulo) {
            vb[0] = false;
            repaint();
            return;
        }
        if(e.getSource()==circulo) {
            vb[1] = false;
            repaint();
            return;
        }
        if(e.getSource()==rectangulo) {
            vb[2] = false;
            repaint();
            return;
        }

        if(e.getSource()==poligono) {
            vb[3] = false;
            repaint();
            return;
        }

    }
}
