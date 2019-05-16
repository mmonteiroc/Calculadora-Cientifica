package visual;

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
public class KeyboardBinario {
    private JPanel PanelPrincipal;
    private JButton a1Button;
    private JButton a0Button;
    private JButton ANDButton;
    private JButton ORButton;
    private JButton ClearALL;
    private JButton NOTNumButton;
    private JButton XORButton;


    KeyboardBinario(final InterficieGrafica ig) {
        // Tenemos que añadir elegir donde escribir
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "1");
            }
        });
        // Tenemos que añadir elegir donde escribir
        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText(ig.Entrada.getText() + "0");
            }
        });

        ANDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int binary1 = Integer.parseInt(ig.Entrada.getText());
                int binary2 = Integer.parseInt(ig.Entrada2.getText());

                int resutl = toDecimal(binary1) & toDecimal(binary2);

                ig.Salida.setText(Integer.toBinaryString(resutl));
            }
        });


        ORButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int binary1 = Integer.parseInt(ig.Entrada.getText());
                int binary2 = Integer.parseInt(ig.Entrada2.getText());

                int resutl = toDecimal(binary1) | toDecimal(binary2);

                ig.Salida.setText(Integer.toBinaryString(resutl));
            }
        });
        XORButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int binary1 = Integer.parseInt(ig.Entrada.getText());
                int binary2 = Integer.parseInt(ig.Entrada2.getText());

                int resutl = toDecimal(binary1) ^ toDecimal(binary2);

                ig.Salida.setText(Integer.toBinaryString(resutl));
            }
        });

        NOTNumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int binary1 = Integer.parseInt(ig.Entrada.getText());
                int resutl = toDecimal(~binary1);
                ig.Salida.setText(Integer.toBinaryString(resutl));
            }
        });

        ClearALL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText("");
                ig.Entrada2.setText("");
                ig.Salida.setText("");
            }
        });


    }

    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }

    private int toDecimal(int n) {
        int decimal = 0, p = 0;
        while (n != 0) {
            decimal += ((n % 10) * Math.pow(2, p));
            n = n / 10;
            p++;
        }
        return decimal;
    }
}
