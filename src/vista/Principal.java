package vista;

import modelo.Lienzo;
import modelo.Semaforo;

import javax.swing.*;
import java.awt.*;

public class Principal extends JFrame {

    Lienzo lienzos[];
    int cant;
    Semaforo semaforo;

    public Principal() {
        super("Mario's mini.game");
        do {
            String cantidad = JOptionPane.showInputDialog
             (
              "Ingrese cantidad de jugadores (maximo 8 | minimo 2)"
             );
            cant = Integer.parseInt(cantidad);
        } while (cant <= 1 || cant >8);
        hazInterfaz();
    }


    private void hazInterfaz() {
        setSize(180 * cant, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, cant + 1));
        lienzos = new Lienzo[cant + 1];
        for (int i = 0; i < cant; i++) {

            lienzos[i] = new Lienzo();
            add(lienzos[i]);
        }

        semaforo = new Semaforo(lienzos);
        add(semaforo);
        semaforo.start();
        setVisible(true);

    }



}
