package visual;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Miguel Monteiro Claveri
 *
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc
 * Paquete visual
 * Proyecto Calculadora
 *
 * Esta clase nos permite definir un keypad para
 * poder trabajar con binario en nuestra applicacion
 */
public class KeyboardBinario {
    // Atributors
    private JPanel PanelPrincipal;
    private JButton a1Button;
    private JButton a0Button;
    private JButton ANDButton;
    private JButton ORButton;
    private JButton ClearALL;
    private JButton NOTNumButton;
    private JButton XORButton;
    // Este atributo solo sera 0 o 1
    // 0 si el input es el primero
    // 1 si el input es el segundo
    private int inputSeleccionado;


    /**
     * @param ig Interficie grafica que pasamos para que esta clase se
     *           pueda comunicar con la interficie que el usuario ve
     *           <p>
     *           Este constructor nos permite inicializar todos los
     *           listener de nuestros atributos como nosotros queramos
     */
    KeyboardBinario(final InterficieGrafica ig) {

        /*
         * Nos permite saber en que input el usuario intenta escribir
         * */
        inputSeleccionado = 0;
        ig.Entrada.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                inputSeleccionado = 0;
            }
        });
        ig.Entrada2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                inputSeleccionado = 1;
            }
        });

        // Añadimos numeros a los input
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputSeleccionado == 0) {
                    ig.Entrada.setText(ig.Entrada.getText() + "1");
                } else if (inputSeleccionado == 1) {
                    ig.Entrada2.setText(ig.Entrada2.getText() + "1");
                }
            }
        });
        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputSeleccionado == 0) {
                    ig.Entrada.setText(ig.Entrada.getText() + "0");
                } else if (inputSeleccionado == 1) {
                    ig.Entrada2.setText(ig.Entrada2.getText() + "0");
                }
            }
        });


        // Operamos con operacion AND
        ANDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long binary1 = Integer.parseInt(ig.Entrada.getText());
                long binary2 = Integer.parseInt(ig.Entrada2.getText());

                long resutl = toDecimal(binary1) & toDecimal(binary2);

                ig.Salida.setText(Long.toBinaryString(resutl));
            }
        });

        // Operamos con operacion OR
        ORButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long binary1 = Integer.parseInt(ig.Entrada.getText());
                long binary2 = Integer.parseInt(ig.Entrada2.getText());

                long resutl = toDecimal(binary1) | toDecimal(binary2);

                ig.Salida.setText(Long.toBinaryString(resutl));
            }
        });

        // Operamos con operacion XOR
        XORButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long binary1 = Integer.parseInt(ig.Entrada.getText());
                long binary2 = Integer.parseInt(ig.Entrada2.getText());

                long resutl = toDecimal(binary1) ^ toDecimal(binary2);

                ig.Salida.setText(Long.toBinaryString(resutl));
            }
        });

        // Operamos con operacion NOT
        NOTNumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long binary1 = Integer.parseInt(ig.Entrada.getText());
                long resutl = toDecimal(~binary1);
                ig.Salida.setText(Long.toBinaryString(resutl));
            }
        });

        // Borramos inputs y output
        ClearALL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText("");
                ig.Entrada2.setText("");
                ig.Salida.setText("");
            }
        });


    }

    /**
     * @return JPanel
     *
     * Este pequeño metodo nos permite retornar
     * el panel principal de esta clase
     */
    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }

    /**
     * @param n numero binario
     * @return decimal
     * <p>
     * Este metodo nos permite pasar
     * un numero de binario a decimal
     */
    private long toDecimal(long n) {
        long decimal = 0, p = 0;
        while (n != 0) {
            decimal += ((n % 10) * Math.pow(2, p));
            n = n / 10;
            p++;
        }
        return decimal;
    }
}
