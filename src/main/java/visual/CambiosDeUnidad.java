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
public class CambiosDeUnidad {

    private JPanel panelPrincipal;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox2;
    private JButton convertirButton;


    CambiosDeUnidad(final InterficieGrafica ig) {

        convertirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /*KM   HM   DAM   M   DM   CM   MM*/
                /* 0    1     2   3    4    5    6*/

                int index1, index2;
                index1 = comboBox1.getSelectedIndex();
                index2 = comboBox2.getSelectedIndex();

                int numberOfCeros = Math.abs(index1 - index2);

                if (index1 < index2) {
                    // MULTIPLY
                    textField2.setText(Double.parseDouble(textField1.getText()) * Math.pow(10, numberOfCeros) + "");
                } else if (index1 == index2) {
                    // WE DONT DO ANYTHING
                    textField2.setText(textField1.getText());
                } else {
                    // Divide
                    textField2.setText(Double.parseDouble(textField1.getText()) / Math.pow(10, numberOfCeros) + "");
                }
            }
        });

    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
