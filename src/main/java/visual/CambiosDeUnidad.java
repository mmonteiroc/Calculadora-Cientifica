package visual;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Miguel Monteiro Claveri
 * <p>
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc
 * Paquete visual
 * Proyecto Calculadora
 * <p>
 * Esta clase nos permite crear un keypad que
 * usaremos para realizar cambios de unidad
 */
public class CambiosDeUnidad {
    /*Atributos*/
    private JPanel panelPrincipal;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox2;
    private JButton convertirButton;


    /**
     * @param ig Recibimos la interficie grafica que el usuario estara viendo
     *           <p>
     *           <p>
     *           Este metodo es el contructor de esta clase que nos permite definir un KeyPad para cambios de unidad.
     *           En este constructor lo que hacemos es añadir un listener de click al boton de convertir.
     */
    CambiosDeUnidad(final InterficieGrafica ig) {


        /*
         * Lo que hacemos es mirar que indices se han seleccionado, depsues lo que hacemos es decidir si
         * multiplicaremos por 10^n donde n es la diferencia de indicies o dividir por 10^n
         * */
        convertirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*INDICIES*/
                /*KM   HM   DAM   M   DM   CM   MM*/
                /* 0    1     2   3    4    5    6*/
                int index1, index2;
                index1 = comboBox1.getSelectedIndex();
                index2 = comboBox2.getSelectedIndex();

                int numberOfCeros = Math.abs(index1 - index2);

                if (index1 < index2) {
                    // Multiplicamos
                    textField2.setText(Double.parseDouble(textField1.getText()) * Math.pow(10, numberOfCeros) + "");
                } else if (index1 == index2) {
                    // Se queda el mismo valor que ha introducido
                    textField2.setText(textField1.getText());
                } else {
                    // Dividimos
                    textField2.setText(Double.parseDouble(textField1.getText()) / Math.pow(10, numberOfCeros) + "");
                }

                InterficieGrafica.historico.addLast(new String[]{
                        textField1.getText() + comboBox1.getSelectedItem().toString(),
                        "",
                        textField2.getText() + comboBox2.getSelectedItem().toString(),
                        "Unidades de mesura"
                });
            }
        });
    }

    /**
     * @return JPanel de esta clase
     * <p>
     * Este simple metodo nos retorna el
     * panel principal de esta clase.
     */
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
