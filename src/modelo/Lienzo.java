package modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Lienzo extends Canvas implements ActionListener {

    private final int meta = 110;
    private final int inicio = 550;

    int sub, mariopos;
    Timer T, Falling;
    private static int mario;
    boolean vb[];
    int subImage;
    boolean death = false;

    Graphics g;
    Image buffer = null;

    int fall = 0;

    private int drawpos, cant, winpos;
    long start, end;

    public Lienzo() {
        sub = 0;
        cant = 100;
        vb = new boolean[4];
        Arrays.fill(vb, true);
        T = new Timer(150, this);
        Falling = new Timer(100, this);

    }


    public void paint(Graphics g) {
        if (buffer == null) {
            buffer = createImage(getWidth(), getHeight());
            this.g = buffer.getGraphics();
            repaint();
            return;
        }


        Dibuja();
        g.drawImage(buffer, 0, 0, getWidth(), getHeight(), this);


    }


    public void Dibuja() {
        drawpos = getHeight() - cant;
        if (!vb[2]) {
            if (getWinpos() > 5) {
                g.drawImage(Rutinas.AjustarImagen("perdedor.png", this.getWidth(), this.getHeight()).getImage(), 0, 0, null);
                g.drawImage(Rutinas.AjustarImagen("deathmario.png", 50, 80).getImage(), 50, meta + fall, null);
                if(meta == inicio-50)
                    Falling.stop();

                Falling.start();
                return;
            } else
                g.drawImage(Rutinas.AjustarImagen("fondoganador.png", this.getWidth(), this.getHeight()).getImage(), 0, 0, null);

        } else
            g.drawImage(Rutinas.AjustarImagen("jugador.png", this.getWidth(), this.getHeight()).getImage(), 0, 0, null);

        if (vb[0]) {
            mario += 2;
            g.drawImage(Rutinas.AjustarImagen(("MarioIconos/mario") + (mario - 1) + ".png", 50, 80).getImage(), 50, drawpos, null);
            subImage = mario - 1;
            mariopos = subImage;
            vb[0] = false;
        } else {

            g.drawImage(Rutinas.AjustarImagen(("MarioIconos/mario") + (subImage) + ".png", 50, 80).getImage(), 50, drawpos, null);

        }

    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }


    public void die() {
        death = true;
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == T) {
            if (vb[1]) {
                subImage++;
                vb[1] = false;
            } else {
                subImage--;
                vb[1] = true;
            }

            int random = Rutinas.nextInt(1, 10);

            if (random == 1) {
                if (drawpos >= inicio)
                    return;
                int can = Rutinas.nextInt(10, 20);
                cant -= can;
            } else {
                int can = Rutinas.nextInt(25, 35);
                cant += can;

                if (drawpos <= meta) {

                    drawpos -= (drawpos - meta);
                    T.stop();
                    end = System.currentTimeMillis() - start;

                    vb[2] = false;
                    vb[3] = false;
                    System.out.println("Tiempo: " + end + "\nJugador: " + getName());
                }

            }

            repaint();
        }
        if (e.getSource() == Falling) {

            fall += 100;

        }


        repaint();
    }

    public int getDrawpos() {
        return mariopos;
    }

    public int getWinpos() {
        return winpos;
    }

    public String getName() {
        switch (mariopos) {
            case 1:
                return "Mario rojo";
            case 3:
                return "Mario amarillo";
            case 5:
                return "Mario blanco ";
            case 7:
                return "Mario cafe";
            case 9:
                return "Mario morado";
            case 11:
                return "Mario negro";
            case 13:
                return "Mario rosa";
            case 15:
                return "Mario verde";
        }
        return null;
    }

    public void start() {
        T.start();
        start = System.currentTimeMillis();
    }

    public boolean getdone() {
        return !vb[3];
    }


    public void setWinPos(int pos) {
        winpos = pos;
        vb[3] = true;

    }


}
