package matrices;

/**
 * Creado por: mmonteiro
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc
 * Paquete matrices
 * Proyecto Calculadora
 */
public class Transponer {
    public static double[][] transponerMatriz(double[][] matriz) {
        //Transposicion de matriz
        //Matriz original a[10][20]
        //Matriz nueva    b[20][10]
        int longitudH = matriz.length, longitudV = matriz[0].length;
        double[][] matrizNueva = new double[longitudV][longitudH];
        for (int i = 0; i < longitudH; i++) {
            for (int j = 0; j < longitudV; j++) {

                matrizNueva[j][i] = matriz[i][j];

            }
        }
        return matrizNueva;
    }
}
