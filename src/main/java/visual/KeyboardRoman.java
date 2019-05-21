package visual;

import evaluator.Evaluator;
import roman.RomanConverter;

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
 * Clase que nos permite representar un keypad
 * para poder trabajar con numeros romanos
 */
public class KeyboardRoman {

    // Atributos
    private JButton boton_I;
    private JButton suma;
    private JButton boton_V;
    private JButton boton_X;
    private JButton boton_L;
    private JButton boton_C;
    private JButton boton_D;
    private JButton boton_m;
    private JButton resta;
    private JButton division;
    private JButton multiplicar;
    private JButton Resultado;
    private JPanel panelPrincipal;
    private JButton clear;


    /**
     * @param ig Interficie grafica que nos pasan
     *           para poder interactuar con lo que
     *           ve el usuario
     *           <p>
     *           Este constructor nos permite inicializar todos los
     *           listener que usara el usuario para interactuar
     *           con los botones de dicho keypad
     */
    KeyboardRoman(final InterficieGrafica ig) {

        /*Acciones key romano*/
        boton_I.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "I");
            }
        });
        boton_V.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "V");
            }
        });
        boton_X.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "X");
            }
        });
        boton_C.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "C");
            }
        });
        boton_L.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "L");
            }
        });
        boton_D.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "D");
            }
        });
        boton_m.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "M");
            }
        });

        // Acciones para añadir operadores
        suma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "+");
            }
        });
        multiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "*");
            }
        });
        resta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "-");
            }
        });
        division.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "/");
            }
        });
        // Opcion borrar input y output
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText("");
                ig.Salida.setText("Resultado");
            }
        });

        // boton para calcular resultado
        Resultado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeros = "";
                String ayuda = "";
                String entrada = ig.Entrada.getText();
                RomanConverter rc;

                for (int i = 0; i < entrada.length(); i++) {
                    char car = entrada.charAt(i);
                    if (car == '+' || car == '-' || car == '/' || car == '*' || car == ' ' || car == ')') {
                        System.out.println(ayuda);
                        rc = new RomanConverter(ayuda);
                        ayuda = "";
                        numeros += rc.toInt();
                        numeros += car;
                    } else if (car == '(') {
                        numeros += car;
                    } else {
                        ayuda += car;
                    }
                }
                if (!ayuda.equals("")) {
                    numeros += new RomanConverter(ayuda).toInt();
                }
                System.out.println(numeros);
                int resultado = (int) Evaluator.calculate(numeros);

                String resultRomano = new RomanConverter(resultado).toString();
                ig.Salida.setText(resultRomano);
                InterficieGrafica.historico.addLast(new String[]{
                        ig.Entrada.getText(), "", resultRomano, "Romano"
                });

            }
        });
    }

    /**
     * @return JPanel
     * <p>
     * Este pequeño metodo nos sirve para
     * retornar el panel principal de la clase
     */
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
