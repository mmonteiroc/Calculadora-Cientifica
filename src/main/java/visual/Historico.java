package visual;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * Creado por: mmonteiro
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc
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
        table1.setModel(tableModel);
    }

    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }


    void setValuesTable(List<String> filas) {
        DefaultTableModel tabla = (DefaultTableModel) table1.getModel();

        for (String fila : filas) {
            tabla.addRow(new String[]{fila
            });
        }


    }
}
