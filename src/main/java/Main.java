import visual.InterficieGrafica;

import javax.swing.*;

/**
 * @author Miguel Monteiro Claveri
 *
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc/Calculadora-Cientifica
 * Proyecto Calculadora
 */

public class Main {
    public static void main(String[] args) {

        InterficieGrafica frame = new InterficieGrafica();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);


    }
}
