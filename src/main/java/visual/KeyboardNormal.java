package visual;

import evaluator.Evaluator;
import evaluator.Token;

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
 */
public class KeyboardNormal {

    // atributos
    private JPanel panelPrincipal;
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
    private JButton ASCIIButton;


    /**
     * @param ig Interficie grafica que pasamos para
     *           poder modificar campos visuales que
     *           el usuario ve
     *           <p>
     *           Este constructor nos permite definir todos los
     *           listener que necesitamos en este keypad para ç
     *           poder hacer operaciones normales
     */
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
                    InterficieGrafica.historico.addLast(new String[]{
                            ig.Entrada.getText(), "", result, "Decimal"
                    });
                } else if (ig.TipoOP.getSelectedIndex() == 3) {
                    // Polaca inversa
                    result = "" + Evaluator.calcRPN(Token.getTokens(ig.Entrada.getText()));
                    ig.Salida.setText(result);
                    InterficieGrafica.historico.addLast(new String[]{
                            ig.Entrada.getText(), "", result, "RPN"
                    });
                }
            }
        });

        /*Operaciones trigonometricas*/
        cos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = String.format("%.3f DEGREES", Math.cos(Math.toRadians(Double.parseDouble(ig.Entrada.getText()))));
                InterficieGrafica.historico.addLast(new String[]{
                        ig.Entrada.getText(), "", s, "Decimal"
                });
                ig.Salida.setText(s);

            }
        });

        sin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = String.format("%.3f DEGREES", Math.sin(Math.toRadians(Double.parseDouble(ig.Entrada.getText()))));
                InterficieGrafica.historico.addLast(new String[]{
                        ig.Entrada.getText(), "", s, "Decimal"
                });
                ig.Salida.setText(s);

            }
        });
        logaritmo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double numero = Double.parseDouble(ig.Entrada.getText());
                String s = String.format("Log10(%.1f) = %.3f ", numero, Math.log10(numero));
                InterficieGrafica.historico.addLast(new String[]{
                        ig.Entrada.getText(), "", s, "Decimal"
                });
                ig.Salida.setText(s);
            }
        });

        /*Calcular codigo ascii/Unicode*/
        ASCIIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder devolver = new StringBuilder();
                char caracter = ' ';
                for (int i = 0; i < ig.Entrada.getText().length(); i++) {
                    caracter = ig.Entrada.getText().charAt(i);
                    devolver.append("(" + caracter + " " + (int) caracter + ") ");
                }
                ig.Salida.setText(devolver.toString());


                InterficieGrafica.historico.addLast(new String[]{
                        ig.Entrada.getText(),
                        ig.Entrada2.getText(),
                        ig.Salida.getText(),
                        "Decimal"
                });
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


    /**
     * @return JPanel
     * <p>
     * Este simple metodo retorna el
     * panel prinicpal de la clase
     */
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
