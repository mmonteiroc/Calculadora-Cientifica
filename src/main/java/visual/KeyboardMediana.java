package visual;

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
 * Esta clase nos permite representar un
 * keypad especifico solo para calcular
 * medianas/varianças de conjuntos de numeros
 */
public class KeyboardMediana {
    // Atributos
    private JButton CLEARALLButton;
    private JPanel panlePrincipal;
    private JButton CALCULARMEDIANAButton;
    private JButton CALCULARVARIANÇAButton;


    /**
     * @param ig Interficie grafica que nos pasan para
     *           poder modificar lo que el usuario esta viendo
     *           <p>
     *           Constructor que usamos para inicializar todos
     *           los listener que necesitamos en este keypad
     */
    KeyboardMediana(final InterficieGrafica ig) {

        // listener para calcular la mediana de un conjunto de numeros
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

        // Listener para calcular la variança de un conjunto de numeros
        CALCULARVARIANÇAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] numeros = ig.Entrada.getText().split(",");
                LinkedList<Double> nums = new LinkedList<Double>();
                for (String num : numeros) {
                    nums.addLast(Double.parseDouble(num));
                }
                ig.Salida.setText(Math.sqrt(calcVariança(nums, calcMediana(nums))) + " variança");

                InterficieGrafica.historico.addLast(new String[]{
                        ig.Entrada.getText(),
                        ig.Salida.getText(),
                        "Mediana / Variança"
                });
            }
        });

        //Boton que nos permite borrar los input/output
        CLEARALLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Salida.setText("");
                ig.Entrada.setText("");
            }
        });
    }


    /**
     * @param nums conjunto de numeros a trabajar
     * @return retorna un double que es la mediana de dicho conjunto
     * <p>
     * Este metodo lo que hace es calcular la
     * mediana de un conjunto de numeros
     */
    private double calcMediana(LinkedList<Double> nums) {
        double result = 0;
        for (double d : nums) {
            result += d;
        }
        return result /= nums.size();
    }

    /**
     * @param nums conjunto de numeros a calcular
     * @param avg  mediana de dichos numeros a calcular
     * @return retorna un double que es la variança de dichos numeros
     * <p>
     * Este metodo lo que hace es calcular
     * la variança de un conjunto de numeros
     */
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

    /**
     * @return JPanel
     * <p>
     * Este metodo lo que hace es
     * retornar el panel principal de esta clase
     */
    public JPanel getPanlePrincipal() {
        return panlePrincipal;
    }
}
