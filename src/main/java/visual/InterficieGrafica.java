package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * @author Miguel Monteiro Claveri
 * <p>
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc/Calculadora-Cientifica
 * Paquete visual
 * Proyecto Calculadora
 * <p>
 * Esta clase nos permite definir lo que sera
 * nuestra ventana prinicpal de nuestra clase
 */
public class InterficieGrafica extends JFrame {
    // Atributos
    // Package
    static LinkedList<String[]> historico = new LinkedList<String[]>();
    static int indexImpresas = 0;
    static int indexOperaciones = 1;
    JComboBox TipoOP;
    JPanel Inputs;
    JTextField Entrada;
    JTextField Entrada2;
    JPanel output;
    JTextField Salida;

    // Privado
    private JPanel panel1;
    private JPanel PanelPrincipal;
    private JPanel ParteNorte;
    private JPanel PanelCentral;
    private JComboBox chooserHistorico;
    private JPanel panelSur;
    private Font fuentePrinicpal = new Font("Arial", Font.PLAIN, 20);
    private CardLayout cardLayout = new CardLayout();


    /**
     * Este constructor lo que hace es inicializar todas las
     * variables que necesitamos para usar nuestra applicacion.
     * <p>
     * Aparte tambien definimos al inicio un par de variables
     * como el tamaño minimo/maximo de la ventana de la aplicacion etc
     * <p>
     * Este constructor no recibe ningun parametro
     */
    public InterficieGrafica() {
        // Extablece panel principal
        this.setContentPane(panel1);

        /*Definimos variables de nuestra ventana*/
        this.setMinimumSize(new Dimension(450, 500));
        this.setMaximumSize(new Dimension(451, 501));
        this.setSize(new Dimension(450, 500));
        this.output.setMinimumSize(new Dimension(200, 60));
        this.output.setMaximumSize(new Dimension(201, 65));
        this.output.setSize(new Dimension(20, 63));

        /*Barra menus*/
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        /*Menu Ajustes*/
        JMenu settings = new JMenu("Ajustes");
        menuBar.add(settings);
        JMenuItem mi = new JMenuItem("Editar fuente");
        settings.add(mi);
        final fontChooser f = new fontChooser(this);
        mi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(true);
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
        KeypadMoneda keypadMoneda = new KeypadMoneda(this);

        panelSur.setLayout(cardLayout);
        // Asignando layouts a panel sur
        panelSur.add(kn.getPanelPrincipal(), "PanelNormal");
        panelSur.add(kr.getPanelPrincipal(), "PanelRomano");
        panelSur.add(historicoLayout.getPanelPrincipal(), "PanelHistorico");
        panelSur.add(kp.getPanelPrincipal(), "PanlePolinomios");
        panelSur.add(keyboardMatrices.getPanelPrincipal(), "PanelMatrices");
        panelSur.add(keyboardBinario.getPanelPrincipal(), "PanelBinario");
        panelSur.add(keyboardVectores.getPanelPrincipal(), "PanelVectores");
        panelSur.add(keyboardFracciones.getPanelPrincipal(), "PanelFracciones");
        panelSur.add(conversionNumericas.getPanel1(), "conversionNum");
        panelSur.add(keyboardMediana.getPanlePrincipal(), "meidana");
        panelSur.add(cambiosDeUnidad.getPanelPrincipal(), "cambioUnidad");
        panelSur.add(keypadMoneda.getPanelPrincipal(), "Moneda");

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
                    // Fracciones
                    cardLayout.show(panelSur, "PanelFracciones");
                } else if (TipoOP.getSelectedIndex() == 8) {
                    // COnversion de numeros
                    cardLayout.show(panelSur, "conversionNum");
                } else if (TipoOP.getSelectedIndex() == 9) {
                    // Medianas y varainça
                    cardLayout.show(panelSur, "meidana");
                } else if (TipoOP.getSelectedIndex() == 10) {
                    // Cambios de unidades
                    cardLayout.show(panelSur, "cambioUnidad");
                } else if (TipoOP.getSelectedIndex() == 11) {
                    // Cambios de moneda
                    cardLayout.show(panelSur, "Moneda");
                }
            }
        });


        /*Definimos si queremos seleccionar historico o keypad*/
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

    /**
     * Este pequeño metodo nos permite
     * modificar la fuente que estamos usando
     */
    private void changeFont() {
        this.Entrada.setFont(this.fuentePrinicpal);
        this.Entrada2.setFont(this.fuentePrinicpal);
        this.Salida.setFont(this.fuentePrinicpal);
    }

    /**
     * @param fuentePrinicpal fuente a usar
     *                        <p>
     *                        Este otro metodo recibe que fuente hemos
     *                        de usar nueva y llama a changeFont
     */
    public void setFuentePrinicpal(Font fuentePrinicpal) {
        this.fuentePrinicpal = fuentePrinicpal;
        changeFont();
    }
}