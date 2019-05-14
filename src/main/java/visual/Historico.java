package visual;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Creado por: mmonteiro
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc/Calculadora-Cientifica
 * Paquete visual
 * Proyecto Calculadora
 */
public class Historico {


    private JPanel PanelPrincipal;
    private JTable table1;

    // Constructor
    Historico(InterficieGrafica ig) {
        /*Modelo tabla*/
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Historial de operaciones");
        Font f = new Font(Font.SANS_SERIF, Font.BOLD, 15);

        table1.setEnabled(false);
        table1.setRowHeight(35);

        table1.setFont(f);
        table1.setModel(tableModel);
    }

    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }


    void setValuesTable(LinkedList<String> filas) {
        DefaultTableModel tabla = (DefaultTableModel) table1.getModel();

        for (int i = InterficieGrafica.indexImpresas; i < filas.size(); i++) {
            String fila = filas.get(i);
            tabla.addRow(new String[]{fila
            });
            InterficieGrafica.indexImpresas++;
        }


    }

}
