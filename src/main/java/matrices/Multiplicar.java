package matrices;

/**
 * Creado por: mmonteiro
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc
 * Paquete matrices
 * Proyecto Calculadora
 */
public class Multiplicar {
    public static double[][] multiplicaMatriu(double[][] matriuA, double[][] matriuB) {
        int filaA = matriuA.length, columnaA = matriuA[0].length, filaB = matriuB.length, columnaB = matriuB[0].length;
        double[][] newMatriu = new double[matriuA.length][matriuB[0].length];

        if (columnaA == filaB) {
            for (int i = 0; i < newMatriu.length; i++) {
                for (int j = 0; j < newMatriu[0].length; j++) {

                    for (int z = 0; z < columnaA; z++) {
                        newMatriu[i][j] += matriuA[i][z] * matriuB[z][j];
                    }

                }
            }

        }
        return newMatriu;
    }
}
