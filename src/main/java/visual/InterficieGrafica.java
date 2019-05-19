package visual;

import evaluator.Evaluator;
import evaluator.Token;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Creado por: mmonteiro
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc/Calculadora-Cientifica
 * Paquete visual
 * Proyecto Calculadora
 */
public class InterficieGrafica extends JFrame {
    //Historico
    static LinkedList<String[]> historico = new LinkedList<String[]>();
    static int indexImpresas = 0;
    static int indexOperaciones = 1;

    // Privado
    private JPanel panel1;
    private JPanel PanelPrincipal;
    private JPanel ParteNorte;
    private JPanel PanelCentral;
    private JComboBox chooserHistorico;
    JComboBox TipoOP;
    private JPanel panelSur;
    // Package

    JPanel Inputs;
    JTextField Entrada;
    JTextField Entrada2;

    JPanel output;
    JTextField Salida;


    // Card layout
    private CardLayout cardLayout = new CardLayout();


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
        JMenuItem mi = new JMenuItem("prova");
        settings.add(mi);
        mi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prova p = new prova();
                p.setVisible(true);

            }
        });

        /*Card settings*/
        KeyboardNormal kn = new KeyboardNormal(this);
        KeyboardRoman kr = new KeyboardRoman(this);
        final Historico historicoLayout = new Historico(this);
        KeyboardPolinomio kp = new KeyboardPolinomio(this);
        KeyboardMatrices keyboardMatrices = new KeyboardMatrices(this);
        KeyboardBinario keyboardBinario = new KeyboardBinario(this);
        KeyboardVectores keyboardVectores = new KeyboardVectores(this);
        KeyboardFracciones keyboardFracciones = new KeyboardFracciones(this);
        ConversionNumericas conversionNumericas = new ConversionNumericas(this);
        KeyboardMediana keyboardMediana = new KeyboardMediana(this);
        CambiosDeUnidad cambiosDeUnidad = new CambiosDeUnidad(this);


        panelSur.setLayout(cardLayout);
        // Asignando layouts a panel sur
        panelSur.add(kn.getKeypadNormal(), "PanelNormal");
        panelSur.add(kr.getPanel(), "PanelRomano");
        panelSur.add(historicoLayout.getPanelPrincipal(), "PanelHistorico");
        panelSur.add(kp.getPanelPrincipal(), "PanlePolinomios");
        panelSur.add(keyboardMatrices.getPanelPrincipal(), "PanelMatrices");
        panelSur.add(keyboardBinario.getPanelPrincipal(), "PanelBinario");
        panelSur.add(keyboardVectores.getPanelPrincipal(), "PanelVectores");
        panelSur.add(keyboardFracciones.getPanelPrincipal(), "PanelFracciones");
        panelSur.add(conversionNumericas.getPanel1(), "conversionNum");
        panelSur.add(keyboardMediana.getPanlePrincipal(), "meidana");
        panelSur.add(cambiosDeUnidad.getPanelPrincipal(), "cambioUnidad");

        /*CARD CHOOSER KEYPAD*/
        TipoOP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Entrada2.setEnabled(false);
                Entrada.setEnabled(true);
                Entrada.setText("");
                Entrada2.setText("");
                chooserHistorico.setSelectedIndex(0);
                Entrada2.setText("Activa polinomios o binario para interactuar");
                if (TipoOP.getSelectedIndex() == 0 || TipoOP.getSelectedIndex() == 3) {
                    // Normal o Polaca inversa
                    cardLayout.show(panelSur, "PanelNormal");
                } else if (TipoOP.getSelectedIndex() == 1) {
                    //Romano
                    cardLayout.show(panelSur, "PanelRomano");
                } else if (TipoOP.getSelectedIndex() == 2) {
                    // Calculos con polinomios
                    Entrada2.setEnabled(true);
                    Entrada2.setText("");
                    cardLayout.show(panelSur, "PanlePolinomios");
                } else if (TipoOP.getSelectedIndex() == 4) {
                    // Matrices
                    Entrada.setEnabled(false);
                    cardLayout.show(panelSur, "PanelMatrices");
                } else if (TipoOP.getSelectedIndex() == 5) {
                    Entrada2.setEnabled(true);
                    Entrada2.setText("");
                    cardLayout.show(panelSur, "PanelBinario");
                } else if (TipoOP.getSelectedIndex() == 6) {
                    // Vectores
                    cardLayout.show(panelSur, "PanelVectores");
                } else if (TipoOP.getSelectedIndex() == 7) {
                    cardLayout.show(panelSur, "PanelFracciones");
                } else if (TipoOP.getSelectedIndex() == 8) {
                    cardLayout.show(panelSur, "conversionNum");
                } else if (TipoOP.getSelectedIndex() == 9) {
                    cardLayout.show(panelSur, "meidana");
                } else if (TipoOP.getSelectedIndex() == 10) {
                    cardLayout.show(panelSur, "cambioUnidad");
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