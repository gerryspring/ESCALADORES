package modelo;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.util.*;

public class Utilerias {

    public static ImageIcon AjustarImagen(String ico, int Ancho, int Alto)
    {
        ImageIcon tmpIconAux = new ImageIcon(ico);
        //Escalar Imagen
        ImageIcon tmpIcon = new ImageIcon(tmpIconAux.getImage().getScaledInstance(Ancho,
                Alto, Image.SCALE_SMOOTH));//SCALE_DEFAULT
        return tmpIcon;
    }


    public static int random(int maximo,int minimo){
        int aux = (int) (Math.random()*(maximo-minimo+1))+minimo;
        return aux;
    }

    public static void main(String[] args) {
        Integer [] numeros = {3, 5, 1, 2, 1, 7, 0, -1};
        Arrays.sort(numeros, Collections.reverseOrder());
        for (int n : numeros) {
            System.out.println(n);
        }

    }

    }



