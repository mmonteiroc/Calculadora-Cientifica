package visual;

import matrices.Invertir;
import matrices.Multiplicar;
import matrices.Transponer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Miguel Monteiro Claveri
 * <p>
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc/Calculadora-Cientifica
 * Paquete visual
 * Proyecto Calculadora
 * <p>
 * Esta clase nos permite crear un keypad
 * para poder trabajar y operar con matrices
 */
public class KeyboardMatrices {
    private JPanel PanelPrincipal;

    // Matriz 2
    private JTextField m2_1;
    private JTextField m2_2;
    private JTextField m2_3;
    private JTextField m2_4;
    private JTextField m2_5;
    private JTextField m2_6;
    private JTextField m2_7;
    private JTextField m2_8;
    private JTextField m2_9;
    private JTextField matriz2TextField;
    private JPanel Matriz2;

    // Matriz 1
    private JPanel Matriz1;
    private JTextField m1_1;
    private JTextField m1_2;
    private JTextField m1_3;
    private JTextField m1_4;
    private JTextField m1_5;
    private JTextField m1_6;
    private JTextField m1_7;
    private JTextField m1_8;
    private JTextField m1_9;
    private JTextField Matriz1TextField;

    // Matriz3
    private JTextField m3_1;
    private JTextField m3_3;
    private JTextField m3_4;
    private JTextField m3_6;
    private JTextField m3_7;
    private JTextField m3_9;
    private JTextField m3_5;
    private JTextField m3_2;
    private JTextField m3_8;
    private JTextField ResultTextField;

    // operaciones
    private JButton clearAllButton;
    private JButton invertirMatriz1Button;
    private JButton multiplicarMatricesButton;
    private JButton transponerMatriz1Button;


    /**
     * @param ig Este constructor lo que hace es inicializar todos los
     *           listener que nosotros necesitemos para poder trabajar con las matrices
     */
    KeyboardMatrices(InterficieGrafica ig) {

        /*Operaciones con las matrices*/
        transponerMatriz1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double[][] matriz1 = recogerMatriz1();
                double[][] transpuesta = Transponer.transponerMatriz(matriz1);
                rellenarResultado(transpuesta);

                String s1 = "Operacion " + InterficieGrafica.indexOperaciones++ + "";

            }
        });

        multiplicarMatricesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double[][] mat1 = recogerMatriz1();
                double[][] mat2 = recogerMatriz2();
                double[][] result = Multiplicar.multiplicaMatriu(mat1, mat2);
                rellenarResultado(result);
            }
        });

        invertirMatriz1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double[][] mat1 = recogerMatriz1();
                double[][] result = Invertir.matrizInversa(mat1);
                rellenarResultado(result);
            }
        });


        // Este listener de este boton nos permite borrar todos los campos
        clearAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m1_1.setText("");
                m1_2.setText("");
                m1_3.setText("");
                m1_4.setText("");
                m1_5.setText("");
                m1_6.setText("");
                m1_7.setText("");
                m1_8.setText("");
                m1_9.setText("");
                m2_1.setText("");
                m2_2.setText("");
                m2_3.setText("");
                m2_4.setText("");
                m2_5.setText("");
                m2_6.setText("");
                m2_7.setText("");
                m2_8.setText("");
                m2_9.setText("");
                m3_1.setText("");
                m3_2.setText("");
                m3_3.setText("");
                m3_4.setText("");
                m3_5.setText("");
                m3_6.setText("");
                m3_7.setText("");
                m3_8.setText("");
                m3_9.setText("");
            }
        });
    }


    /**
     * @return retorna una matriz
     * <p>
     * Este metodo nos permite recoger la matriz 1
     * y retornarla como array
     */
    private double[][] recogerMatriz1() {
        double[][] dev = new double[3][3];
        // Primera fila
        dev[0][0] = Integer.parseInt(m1_1.getText());
        dev[0][1] = Integer.parseInt(m1_2.getText());
        dev[0][2] = Integer.parseInt(m1_3.getText());
        dev[1][0] = Integer.parseInt(m1_4.getText());
        dev[1][1] = Integer.parseInt(m1_5.getText());
        dev[1][2] = Integer.parseInt(m1_6.getText());
        dev[2][0] = Integer.parseInt(m1_7.getText());
        dev[2][1] = Integer.parseInt(m1_8.getText());
        dev[2][2] = Integer.parseInt(m1_9.getText());
        return dev;
    }

    /**
     * @return retorna una matriz
     * <p>
     * Este metodo nos permite recoger la matriz 2
     * y retornarla como array
     */
    private double[][] recogerMatriz2() {
        double[][] devolver = new double[3][3];

        devolver[2][0] = Integer.parseInt(m2_7.getText());
        devolver[2][1] = Integer.parseInt(m2_8.getText());
        devolver[2][2] = Integer.parseInt(m2_9.getText());

        devolver[1][0] = Integer.parseInt(m2_4.getText());
        devolver[1][1] = Integer.parseInt(m2_5.getText());
        devolver[1][2] = Integer.parseInt(m2_6.getText());

        devolver[0][0] = Integer.parseInt(m2_1.getText());
        devolver[0][1] = Integer.parseInt(m2_2.getText());
        devolver[0][2] = Integer.parseInt(m2_3.getText());
        return devolver;
    }


    /**
     * @param mat recibe una matriz a escribir
     *            <p>
     *            Este metodo escribe los valores de una
     *            matriz en el panel visual de dicha matriz
     */
    private void rellenarResultado(double[][] mat) {
        m3_1.setText(mat[0][0] + "");
        m3_2.setText(mat[0][1] + "");
        m3_3.setText(mat[0][2] + "");

        m3_4.setText(mat[1][0] + "");
        m3_5.setText(mat[1][1] + "");
        m3_6.setText(mat[1][2] + "");

        m3_7.setText(mat[2][0] + "");
        m3_8.setText(mat[2][1] + "");
        m3_9.setText(mat[2][2] + "");
    }


    /**
     * @return JPanel
     * <p>
     * Este metodo lo que hace es
     * retornar el panel principal de esta clase
     */
    public JPanel getPanelPrincipal() {
        return this.PanelPrincipal;
    }
}
