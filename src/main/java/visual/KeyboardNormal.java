package visual;

import evaluator.Evaluator;
import evaluator.Token;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creado por: mmonteiro
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc/Calculadora-Cientifica
 * Paquete visual
 * Proyecto Calculadora
 */
public class KeyboardNormal {
    private JPanel KeypadNormal;
    private JButton boton1;
    private JButton Suma;
    private JButton boton2;
    private JButton boton3;
    private JButton boton4;
    private JButton boton5;
    private JButton boton6;
    private JButton resta;
    private JButton boton7;
    private JButton boton8;
    private JButton boton9;
    private JButton boton0;
    private JButton botonComa;
    private JButton botonResultado;
    private JButton multiplicacion;
    private JButton dividir;
    private JButton borrar;
    private JButton sin;
    private JButton cos;
    private JButton logaritmo;
    private JButton parIzq;
    private JButton parDch;
    private JButton exponente;
    private JPanel KeyNormal;


    public KeyboardNormal(final InterficieGrafica ig) {



        /*Acciones añadir numeros*/

        boton0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "0");
            }
        });
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "1");
            }
        });
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "2");
            }
        });
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "3");
            }
        });
        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "4");
            }
        });
        boton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "5");
            }
        });
        boton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "6");
            }
        });
        boton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "7");
            }
        });
        boton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "8");
            }
        });
        boton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "9");
            }
        });

        /*Acciones añadir operaciones al input*/


        Suma.addActionListener(new ActionListener() {
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
        botonComa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + ".");
            }
        });
        parDch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + ")");
            }
        });
        parIzq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "(");
            }
        });
        exponente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "^");
            }
        });


        /*Accion resultado*/
        botonResultado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = "";

                if (ig.TipoOP.getSelectedIndex() == 0) {
                    // normal
                    result = "" + Evaluator.calculate(ig.Entrada.getText());
                    ig.Salida.setText(result);
                    ig.historico.addLast(new String[]{
                            ig.Entrada.getText(), "", result, "Decimal"
                    });
                } else if (ig.TipoOP.getSelectedIndex() == 3) {
                    // Polaca inversa
                    result = "" + Evaluator.calcRPN(Token.getTokens(ig.Entrada.getText()));
                    ig.Salida.setText(result);
                    ig.historico.addLast(new String[]{
                            ig.Entrada.getText(), "", result, "RPN"
                    });
                }



            }
        });

        cos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = String.format("%.3f DEGREES", Math.cos(Math.toRadians(Double.parseDouble(ig.Entrada.getText()))));
                ig.historico.addLast(new String[]{
                        ig.Entrada.getText(), "", s, "Decimal"
                });
                ig.Salida.setText(s);

            }
        });

        sin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = String.format("%.3f DEGREES", Math.sin(Math.toRadians(Double.parseDouble(ig.Entrada.getText()))));
                ig.historico.addLast(new String[]{
                        ig.Entrada.getText(), "", s, "Decimal"
                });
                ig.Salida.setText(s);

            }
        });


        /*Accion borrar*/
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText("");
                ig.Salida.setText("Resultado");
            }
        });
    }

    private double setDegrees(double radians) {

        return radians * 200 / Math.PI;

    }


    public JPanel getKeypadNormal() {
        return KeypadNormal;
    }
}
