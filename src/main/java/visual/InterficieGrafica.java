package visual;

import evaluator.Evaluator;
import evaluator.Token;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creado por: mmonteiro
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc
 * Paquete visual
 * Proyecto Calculadora
 */
public class InterficieGrafica extends JFrame {
    private JPanel panel1;
    private JPanel PanelPrincipal;
    private JPanel ParteNorte;
    private JTextField Entrada;
    private JTextField Salida;
    private JPanel PanelCentral;

    // KEYPAD
    private JPanel Keypad;
    // Numeros
    private JButton boton0;
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JButton boton4;
    private JButton boton5;
    private JButton boton6;
    private JButton boton7;
    private JButton boton8;
    private JButton boton9;

    //Botones
    private JButton resta;
    private JButton Suma;
    private JButton botonComa;
    private JButton botonResultado;
    private JButton multiplicacion;
    private JButton dividir;
    private JButton borrar;


    // Constructor
    public InterficieGrafica() {
        // Extablece panel principal
        this.setContentPane(panel1);

        /*Barra menus*/
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        /*Menu File*/
        JMenu settings = new JMenu("Ajustes");
        menuBar.add(settings);

        /*Acciones añadir numeros*/

        boton0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Entrada.setText(Entrada.getText() + "0");

            }
        });
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Entrada.setText(Entrada.getText() + "1");

            }
        });
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Entrada.setText(Entrada.getText() + "2");

            }
        });
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Entrada.setText(Entrada.getText() + "3");

            }
        });
        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Entrada.setText(Entrada.getText() + "4");

            }
        });
        boton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Entrada.setText(Entrada.getText() + "5");

            }
        });
        boton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Entrada.setText(Entrada.getText() + "6");

            }
        });
        boton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Entrada.setText(Entrada.getText() + "7");

            }
        });
        boton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Entrada.setText(Entrada.getText() + "8");

            }
        });
        boton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Entrada.setText(Entrada.getText() + "9");

            }
        });

        /*Acciones añadir operaciones al input*/


        Suma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Entrada.setText(Entrada.getText() + "+");
            }
        });
        resta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Entrada.setText(Entrada.getText() + "-");
            }
        });
        multiplicacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Entrada.setText(Entrada.getText() + "*");
            }
        });
        dividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Entrada.setText(Entrada.getText() + "/");
            }
        });
        botonComa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Entrada.setText(Entrada.getText() + ".");
            }
        });



        /*Accion resultado*/
        botonResultado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Salida.setText(Evaluator.calculate(Entrada.getText()) + "");

            }
        });

        /*Accion borrar*/
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Entrada.setText("");
                Salida.setText("Resultado");
            }
        });
    }


}
