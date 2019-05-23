package visual;

import polinomios.Polynomial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Miguel Monteiro Claveri
 * <p>
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc/Calculadora-Cientifica
 * Paquete visual
 * Proyecto Calculadora
 * <p>
 * Esta clase nos permite representar un keypad para
 * poder hacer operaciones con polinomio(s)
 */
public class KeyboardPolinomio {

    // Atributos
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
    private JTextField input;


    /**
     * @param ig Interficie grafica que nos pasan
     *           para poder interactuar con lo que
     *           ve el usuario
     *           <p>
     *           Este constructor inicializamos los listeners
     *           que necesitaremos para poder interactuar con dicho keypad
     */
    KeyboardPolinomio(final InterficieGrafica ig) {

        // Inicializamos listener para saber que input ha sido seleccionado
        input = ig.Entrada;
        ig.Entrada.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                input = ig.Entrada;
            }
        });
        ig.Entrada2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                input = ig.Entrada2;
            }
        });

        // TODOS LOS NUMEROS QUE APRETEMOS SE AÑADIRAN AL INPUT 1
        boton0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                input.setText(input.getText() + "0");
            }
        });
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText() + "1");
            }
        });
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText() + "2");
            }
        });
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText() + "3");
            }
        });
        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText() + "4");
            }
        });
        boton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText() + "5");
            }
        });
        boton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText() + "6");
            }
        });
        boton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText() + "7");
            }
        });
        boton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText() + "8");
            }
        });
        boton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText() + "9");
            }
        });

        // Operaciones
        Suma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText() + "+");
            }
        });
        resta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText() + "-");
            }
        });
        multiplicacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText() + "*");
            }
        });
        dividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText() + "/");
            }
        });
        botonComa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText() + ".");
            }
        });
        parDch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText() + ")");
            }
        });
        parIzq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText() + "(");
            }
        });
        exponente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText() + "^");
            }
        });
        incognitaXButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText() + "x");
            }
        });






        /*Acciones para trabajar con polinomios*/
        sumarPolButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial polinomio1 = new Polynomial(ig.Entrada.getText());
                Polynomial polinomio2 = new Polynomial(ig.Entrada2.getText());
                Polynomial resultado = polinomio1.add(polinomio2);
                ig.Salida.setText(resultado.toString());
                saveStory(new String[]{
                        ig.Entrada.getText() + " + " + ig.Entrada2.getText(), resultado.toString(), "Polinomios"
                });
            }
        });

        multiplicarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial polinomio1 = new Polynomial(ig.Entrada.getText());
                Polynomial polinomio2 = new Polynomial(ig.Entrada2.getText());
                Polynomial resultado = polinomio1.mult(polinomio2);
                ig.Salida.setText(resultado.toString());
                saveStory(new String[]{
                        ig.Entrada.getText() + " x " + ig.Entrada2.getText(), resultado.toString(), "Polinomios"
                });
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

                saveStory(new String[]{
                        ig.Entrada.getText() + " / " + ig.Entrada2.getText(), coef + "||" + residu, "Polinomios"
                });
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
                    s = "No tiene resultado";
                } else {
                    for (int i = 0; i < resultado.length; i++) {
                        if (i + 1 >= resultado.length) {
                            s += resultado[i];
                        } else {
                            s += resultado[i] + " || ";
                        }
                    }
                    System.out.println(s);
                    ig.Salida.setText(s);
                }


                // Save part
                saveStory(new String[]{
                        ig.Entrada.getText(), ig.Entrada2.getText(), s, "Polinomios"
                });
            }
        });



        /*Accion borrar*/
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada2.setText("");
                ig.Entrada.setText("");
                ig.Salida.setText("Resultado");
            }
        });


    }


    /**
     * @param s Array de Strings a guardar
     *          <p>
     *          Este metodo lo que hace es recibir un
     *          array de strings y guardarlo en la
     *          variable globar historico
     */
    private void saveStory(String[] s) {
        InterficieGrafica.historico.addLast(s);
    }

    /**
     * @return JPanel
     * <p>
     * Este pequeño metodo nos sirve para
     * retornar el panel principal de la clase
     */
    public JPanel getPanelPrincipal() {
        return this.PanelPrincipal;
    }
}
