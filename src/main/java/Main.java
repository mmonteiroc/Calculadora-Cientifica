import visual.InterficieGrafica;

import javax.swing.*;

/**
 * Creado por: mmonteiro
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc/Calculadora-Cientifica
 * Paquete PACKAGE_NAME
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
