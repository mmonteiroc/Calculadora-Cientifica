package visual;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;
/**
 * Creado por: mmonteiro
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc
 * Paquete visual
 * Proyecto Calculadora
 */
public class KeyboardVectores {
    private JPanel PanelPrincipal;
    private JButton moduloDelVectorButton;
    private JButton restaDeVectoresButton;
    private JButton sumaDeVectoresButton;
    private JButton distanciaEntre2VectoresButton;
    private JButton clearALLButton;

    KeyboardVectores(final InterficieGrafica ig) {

        sumaDeVectoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LinkedList<Integer[]> vectores = getVectors(ig.Entrada.getText());
                int x = 0;
                int y = 0;
                for (int i = 0; i < vectores.size(); i++) {
                    x += vectores.get(i)[0];
                    y += vectores.get(i)[1];
                }
                ig.Salida.setText("(" + x + "," + y + ")");
                InterficieGrafica.historico.addLast(new String[]{
                        ig.Entrada.getText(), "", "(" + x + "," + y + ")", "Vectores"
                });
            }
        });

        moduloDelVectorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LinkedList<Integer[]> vectores = getVectors(ig.Entrada.getText());
                double resultado = distanciaEntre(new Integer[]{0, 0}, vectores.get(0));
                ig.Salida.setText(resultado + "");
                InterficieGrafica.historico.addLast(new String[]{
                        ig.Entrada.getText(), "", "" + resultado, "Vectores"
                });
            }
        });


        restaDeVectoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LinkedList<Integer[]> vectores = getVectors(ig.Entrada.getText());

                int x = 0, y = 0;
                for (int i = 0; i < vectores.size(); i++) {

                    if (i % 2 == 0) {
                        x += vectores.get(i)[0];
                        y += vectores.get(i)[1];
                    } else {
                        x += vectores.get(i)[0] * (-1);
                        y += vectores.get(i)[1] * (-1);
                    }
                }
                ig.Salida.setText("(" + x + "," + y + ")");
                InterficieGrafica.historico.addLast(new String[]{
                        ig.Entrada.getText(), "", " (" + x + "," + y + ")", "Vectores"
                });
            }
        });

        distanciaEntre2VectoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LinkedList<Integer[]> vectores = getVectors(ig.Entrada.getText());

                double resultado = distanciaEntre(vectores.get(0), vectores.get(1));
                ig.Salida.setText(resultado + "");
                InterficieGrafica.historico.addLast(new String[]{
                        ig.Entrada.getText(), "", resultado + "", "Vectores"
                });

            }
        });

        clearALLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ig.Entrada.setText("");
            }
        });


    }


    private LinkedList<Integer[]> getVectors(String stringVectores) {
        LinkedList<Integer[]> vectores = new LinkedList<Integer[]>();
        Integer[] help = new Integer[2];
        int indexSupletorio = 0;
        for (int i = 0; i < stringVectores.length(); i++) {
            char caracter = stringVectores.charAt(i);
            if (Character.isDigit(caracter)) {
                char cero = 0;
                if (stringVectores.charAt(i - 1) == '-') {
                    help[indexSupletorio++] = Integer.parseInt(caracter + "") * (-1);
                } else {
                    help[indexSupletorio++] = Integer.parseInt(caracter + "");
                }

            }
            if (indexSupletorio >= 2) {
                indexSupletorio = 0;
                vectores.addLast(help);
                help = new Integer[2];
            }
        }
        System.out.println(Arrays.deepToString(vectores.toArray()));
        return vectores;
    }


    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }

    /**
     * @param a
     * @param b
     * @return
     */
    private double distanciaEntre(Integer[] a, Integer[] b) {
        double distancia = 0;
        double catetoA = a[0] - b[0], catetoB = a[1] - b[1];
        distancia = Math.sqrt((catetoA * catetoA) + (catetoB * catetoB));
        return distancia;
    }
}
