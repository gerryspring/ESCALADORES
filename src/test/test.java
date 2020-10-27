package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test extends JFrame implements ActionListener {
    public static void main(String[] args) {
        long start1 =  1602962481668L;
        long end1 = 1602962485701L;

        long start2 = 1602962481668L;
        long end2 = 1602962486194L;

        long dif1 = end1-start1;
        long dif2 = end2 - start2;

        boolean winner = dif1 < dif2;

        System.out.println(winner);

        System.out.println("DIFERENCIA DEL JUGADOR 1: " + dif1);

        System.out.println("DIFERENCIA DEL JUGADOR 2: " + dif2);
    }
    public test() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
