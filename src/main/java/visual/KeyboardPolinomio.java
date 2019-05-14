package visual;

import evaluator.Evaluator;
import polinomios.Polynomial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creado por: mmonteiro
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc/Calculadora-Cientifica
 * Paquete visual
 * Proyecto Calculadora
 */
public class KeyboardPolinomio {
    private JPanel PanelPrincipal;
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
    private JButton multiplicacion;
    private JButton dividir;
    private JButton borrar;
    private JButton parIzq;
    private JButton parDch;
    private JButton exponente;
    private JButton incognitaXButton;
    private JButton sumarPolButton;
    private JButton multiplicarButton;
    private JButton dividirButton;
    private JButton raicesButton;


    KeyboardPolinomio(final InterficieGrafica ig) {

        /*Acciones añadir numeros*/


        boton0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if (ig.Entrada.){
                System.out.println("entrada 1 tiene focus");
                ig.Entrada.setText(ig.Entrada.getText() + "0");
                // }else{
                System.out.println("entrada 2 tiene focus");
                ig.Entrada2.setText(ig.Entrada2.getText() + "0");
                //}
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
        incognitaXButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "x");
            }
        });

        /*Accion resultado*/
        // Sumamos polinomios
        sumarPolButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial polinomio1 = new Polynomial(ig.Entrada.getText());
                Polynomial polinomio2 = new Polynomial(ig.Entrada2.getText());
                Polynomial resultado = polinomio1.add(polinomio2);
                ig.Salida.setText(resultado.toString());
                saveStory("Operación " + ig.indexOperaciones + "  :  " + ig.Entrada.getText() + " + " + ig.Entrada2.getText() + " -- Suma->" + resultado.toString());
            }
        });

        multiplicarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial polinomio1 = new Polynomial(ig.Entrada.getText());
                Polynomial polinomio2 = new Polynomial(ig.Entrada2.getText());
                Polynomial resultado = polinomio1.mult(polinomio2);
                ig.Salida.setText(resultado.toString());
                saveStory("Operación " + ig.indexOperaciones + "  :  " + ig.Entrada.getText() + " x " + ig.Entrada2.getText() + " -- multiplicación->" + resultado.toString());

            }
        });
        dividirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial polinomio1 = new Polynomial(ig.Entrada.getText());
                Polynomial polinomio2 = new Polynomial(ig.Entrada2.getText());
                Polynomial[] resultado = polinomio1.div(polinomio2);
                String coef = resultado[0].toString();
                String residu = resultado[1].toString();
                ig.Salida.setText("Coef: " + coef + " - Residuo: " + residu);

                saveStory("Operación " + ig.indexOperaciones + "  :  " + ig.Entrada.getText() + " / " + ig.Entrada2.getText() + " -- Division-> " + coef + "||" + residu);
            }
        });
        raicesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial polinomio1 = new Polynomial(ig.Entrada.getText());
                String s = "";
                float[] resultado = polinomio1.roots();
                if (resultado == null) {
                    ig.Salida.setText("No tiene resultado");
                } else {
                    for (int i = 0; i < resultado.length; i++) {
                        if (i + 1 >= resultado.length) {
                            s += resultado[i];
                        } else {
                            s += resultado[i] + " || ";
                        }
                    }
                    System.out.println(s);
                    ig.Salida.setText(s.toString());
                }


                // Save part
                saveStory("Operación " + ig.indexOperaciones + "  :  " + ig.Entrada.getText() + " -- roots --> " + s);
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

    void saveStory(String s) {
        InterficieGrafica.indexOperaciones++;
        InterficieGrafica.historico.addLast(s);
    }

    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }
}
