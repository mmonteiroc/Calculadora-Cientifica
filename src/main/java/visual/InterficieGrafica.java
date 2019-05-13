package visual;

import evaluator.Evaluator;
import evaluator.Token;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

/**
 * Creado por: mmonteiro
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc
 * Paquete visual
 * Proyecto Calculadora
 */
public class InterficieGrafica extends JFrame {
    //Historico
    static List<String> historico = new LinkedList<String>();
    static int indexOperaciones = 1;

    // Privado
    private JPanel panel1;
    private JPanel PanelPrincipal;
    private JPanel ParteNorte;
    private JPanel PanelCentral;
    private JComboBox chooserHistorico;
    private JComboBox TipoOP;
    private JPanel panelSur;
    // Package

    JPanel Inputs;
    JTextField Entrada;
    JTextField Entrada2;

    JPanel output;
    JTextField Salida;


    // Card layout
    CardLayout cardLayout = new CardLayout();


    // Constructor
    public InterficieGrafica() {
        // Extablece panel principal
        this.setContentPane(panel1);

        this.setMinimumSize(new Dimension(450, 500));
        this.setMaximumSize(new Dimension(451, 501));
        this.setSize(new Dimension(450, 500));
        /*Barra menus*/
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        /*Menu File*/
        JMenu settings = new JMenu("Ajustes");
        menuBar.add(settings);



        /*Card settings*/
        KeyboardNormal kn = new KeyboardNormal(this);
        KeyboardRoman kr = new KeyboardRoman(this);
        final Historico historicoLayout = new Historico(this);
        KeyboardPolinomio kp = new KeyboardPolinomio(this);


        panelSur.setLayout(cardLayout);
        // Asignando layouts a panel sur
        panelSur.add(kn.getKeypadNormal(), "PanelNormal");
        panelSur.add(kr.getPanel(), "PanelRomano");
        panelSur.add(historicoLayout.getPanelPrincipal(), "PanelHistorico");
        panelSur.add(kp.getPanelPrincipal(), "PanlePolinomios");

        /*CARD CHOOSER KEYPAD*/
        TipoOP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Entrada2.setEnabled(false);
                Entrada2.setText("Activa polinomios para interactuar con este input");
                if (TipoOP.getSelectedIndex() == 0) {
                    // NORMAL
                    cardLayout.show(panelSur, "PanelNormal");
                } else if (TipoOP.getSelectedIndex() == 1) {
                    //Romano
                    cardLayout.show(panelSur, "PanelRomano");
                } else if (TipoOP.getSelectedIndex() == 2) {
                    // Calculos con polinomios
                    Entrada2.setEnabled(true);
                    Entrada2.setText("");
                    cardLayout.show(panelSur, "PanlePolinomios");
                }
            }
        });

        chooserHistorico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chooserHistorico.getSelectedIndex() == 0) {
                    // KEYPAD
                    cardLayout.show(panelSur, "PanelNormal");
                } else if (chooserHistorico.getSelectedIndex() == 1) {
                    // Historial
                    cardLayout.show(panelSur, "PanelHistorico");
                    historicoLayout.setValuesTable(historico);
                }
            }
        });

    }


}