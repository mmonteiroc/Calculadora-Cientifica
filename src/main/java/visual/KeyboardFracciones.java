package visual;

import fracctions.Fraccion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * @author Miguel Monteiro Claveri
 * <p>
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc
 * Paquete visual
 * Proyecto Calculadora
 * <p>
 * Esta clase nos permite definir un keypad
 * para trabajar con fracciones
 */
public class KeyboardFracciones {

    // Atributos
    private JPanel PanelPrincipal;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a3Button;
    private JButton a6Button;
    private JButton a8Button;
    private JButton a7Button;
    private JButton a9Button;
    private JButton a0Button;
    private JButton dividir;
    private JButton multiplicacion;
    private JButton resta;
    private JButton suma;
    private JButton fraccionButton;
    private JButton clearButton;
    private JButton calcularResultadoButton;
    private char SIMBOLO_FRACCION = '|';


    /**
     * @param ig Este constructor lo usamos para inicializar todos
     *           los listeners que nosotros necesitamos .
     */
    KeyboardFracciones(final InterficieGrafica ig) {

        // Listeners para añadir nums al input
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "1");
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "2");
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "3");
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "4");
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "5");
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "6");
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "7");
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "8");
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "9");
            }
        });
        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "0");
            }
        });

        // Listeners para añadir operadores al input
        suma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "+");
            }
        });
        resta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "-");
            }
        });
        multiplicacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "*");
            }
        });
        dividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "/");
            }
        });
        fraccionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "|");
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText("");
            }
        });


        // este listener lo que hace es llamar a la funcion calculateAllFraccions
        calcularResultadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fraccionsCalculated = calculateAllFraccions(ig.Entrada.getText());
                ig.Salida.setText(fraccionsCalculated);
                InterficieGrafica.historico.addLast(new String[]{
                        ig.Entrada.getText(), "", fraccionsCalculated, "Fracciones"
                });
            }
        });


    }


    /**
     * @param input String que representa todas las operaciones de fracciones
     * @return retornamos una string con la fraccion resultante de toda la operacion
     * <p>
     * Este metodo nos permite leer todas las fracciones de el input e ir
     * calculandolas hasta que hayamos calculado todas y retornamos la fraccion resultante
     */
    private String calculateAllFraccions(String input) {

        LinkedList<Fraccion> fraccions = new LinkedList<Fraccion>();

        char operador = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                if (i + 1 >= input.length()) {
                    // NO HACEMOS NADA
                    fraccions.addLast(new Fraccion(Double.parseDouble(input.charAt(i) + ""), 1));
                } else {
                    // HACEMOS
                    if (input.charAt(i + 1) == SIMBOLO_FRACCION) {
                        fraccions.addLast(new Fraccion(Double.parseDouble(input.charAt(i) + ""), Double.parseDouble(input.charAt(i + 2) + "")));
                    } else {
                        fraccions.addLast(new Fraccion(Double.parseDouble(input.charAt(i) + ""), 1));
                    }
                    i += 2;
                }
                if (operador != 0) {
                    // operamos
                    System.out.println(fraccions.get(0).toString() + "" + operador + fraccions.get(1).toString());

                    switch (operador) {

                        case '+':
                            fraccions.addLast(fraccions.get(0).sumar(fraccions.get(1)));
                            break;
                        case '-':
                            fraccions.addLast(fraccions.get(0).restar(fraccions.get(1)));
                            break;
                        case '*':
                            fraccions.addLast(fraccions.get(0).multiplicar(fraccions.get(1)));
                            break;
                        case '/':
                            fraccions.addLast(fraccions.get(0).dividir(fraccions.get(1)));
                            break;
                        default:
                            break;
                    }

                    fraccions.remove(0);
                    fraccions.remove(0);
                    operador = 0;
                }
            } else if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '/' || input.charAt(i) == '*') {
                // operador
                operador = input.charAt(i);
            }
        }

        return fraccions.get(0).toString();
    }


    /**
     * @return JPanel
     * <p>
     * Este simple metodo nos permite retornar el
     * panel prinicpal de nuestro keypad
     */
    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }
}
