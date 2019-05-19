package visual;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Creado por: mmonteiro
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc
 * Paquete visual
 * Proyecto Calculadora
 */
public class KeyboardMediana {
    private JButton CLEARALLButton;
    private JPanel panlePrincipal;
    private JButton CALCULARMEDIANAButton;
    private JButton CALCULARVARIANÇAButton;


    KeyboardMediana(final InterficieGrafica ig) {
        CALCULARMEDIANAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] numeros = ig.Entrada.getText().split(",");
                LinkedList<Double> nums = new LinkedList<Double>();
                for (String num : numeros) {
                    nums.addLast(Double.parseDouble(num));
                }
                ig.Salida.setText(calcMediana(nums) + " mediana");

                InterficieGrafica.historico.addLast(new String[]{
                        ig.Entrada.getText(),
                        "",
                        ig.Salida.getText(),
                        "Mediana / Variança"

                });
            }
        });

        CALCULARVARIANÇAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] numeros = ig.Entrada.getText().split(",");
                LinkedList<Double> nums = new LinkedList<Double>();
                for (String num : numeros) {
                    nums.addLast(Double.parseDouble(num));
                }
                ig.Salida.setText(calcVariança(nums, calcMediana(nums)) + " variança");

                InterficieGrafica.historico.addLast(new String[]{
                        ig.Entrada.getText(),
                        ig.Salida.getText(),
                        "Mediana / Variança"

                });
            }
        });


    }


    private double calcMediana(LinkedList<Double> nums) {
        double result = 0;
        for (double d : nums) {
            result += d;
        }
        return result /= nums.size();
    }

    private double calcVariança(LinkedList<Double> nums, double avg) {
        double result = 0;
        double ayuda = 0;

        for (double d : nums) {
            ayuda = Math.pow(d - avg, 2);
            result += ayuda;
        }

        result /= nums.size() - 1;
        return result;
    }


    public JPanel getPanlePrincipal() {
        return panlePrincipal;
    }
}
