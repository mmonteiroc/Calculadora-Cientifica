package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * @author Miguel Monteiro Claveri
 *
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc
 * Paquete visual
 * Proyecto Calculadora
 *
 * Esta clase nos permite crear un dialogo de JSwing el cual nos permite
 * seleccionar y modificar la fuente de nuestra calculadora
 */
public class fontChooser extends JDialog {

    // Atributos
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private InterficieGrafica ig;

    /**
     * @param ig interficie grafica que nos pasan al contruir esta clase
     *           <p>
     *           Este constructor lo que hacemos es definir ajustes del dialogo y
     *           definimos que acciones hacer cuando se pulsen los diferentes
     *           botones del dialogo
     */
    public fontChooser(InterficieGrafica ig) {
        this.setMinimumSize(new Dimension(300, 150));
        this.setMaximumSize(new Dimension(400, 400));
        this.setSize(new Dimension(350, 200));
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });
        this.ig = ig;


        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    /**
     * Este metodo nos permite guardar los cambios
     * hechos al modificar la fuente
     */
    private void onOK() {
        // add your code here
        this.ig.setFuentePrinicpal(new Font(this.comboBox1.getSelectedItem().toString(), this.comboBox2.getSelectedIndex(), Integer.parseInt(this.comboBox3.getSelectedItem().toString())));
        dispose();
    }


    /**
     * Este metodo lo que hace es descartar todos los
     * cambios hechos al modificar la fuente
     */
    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
