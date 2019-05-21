package matrices;

/**
 * Creado por: mmonteiro
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc
 * Paquete matrices
 * Proyecto Calculadora
 */
public class Invertir {


    //OVERLOADING CON MENSAJE DE ERROR PREDEFINIDO
    //VERSION TOTALMENTE FUNCIONAL TODOS LOS TAMAÑOS CUADRADAS
    public static double[][] matrizInversa(double[][] matrix) {

        double det = determinante(matrix);
        if (det == 0) {
            throw new RuntimeException("No se puede calcular tu matriz");
        }

        double partDet = 1 / det;
        double[][] matTranspuesta = transponerMatriz(matrix);
        double[][] adjunta = adjuntar(matTranspuesta);
        double[][] matrizFinal = multiplicacion(adjunta, partDet);

        return matrizFinal;
    }


    private static double determinante(double[][] mat) {
        double det = 0;
        int cont = 0;
        if (mat.length == 2) {
            return (mat[0][0] * mat[1][1]) - (mat[0][1] * mat[1][0]);
        }
        for (int i = 0; i < mat.length; i++) {
            double elemento = mat[0][i];
            double[][] menor = sacarMenor(mat, 0, i);
            if (cont % 2 == 0) {
                det += elemento * determinante(menor);
                cont++;
            } else {
                det += (elemento * (-1)) * determinante(menor);
                cont++;
            }

        }

        return det;
    }

    private static double[][] sacarMenor(double[][] mat, int filaAquitar, int colAquitar) {

        double[][] devolver = new double[mat.length - 1][mat[0].length - 1];
        int j = 0, i = 0;

        for (int k = 0; k < mat.length; k++) {
            for (int l = 0; l < mat[0].length; l++) {
                if (l != colAquitar && k != filaAquitar) {
                    devolver[i][j] = mat[k][l];
                    j++;
                    if (j == devolver[0].length) {
                        i++;
                        j = 0;
                        if (i == devolver.length) {
                            return devolver;
                        }
                    }
                }
            }
        }

        return devolver;
    }

    private static double[][] transponerMatriz(double[][] matriz) {
        int longitudH = matriz.length, longitudV = matriz[0].length;
        double[][] matrizNueva = new double[longitudV][longitudH];
        for (int i = 0; i < longitudH; i++) {
            for (int j = 0; j < longitudV; j++) {
                matrizNueva[j][i] = matriz[i][j];
            }
        }
        return matrizNueva;
    }

    private static double[][] adjuntar(double[][] mat) {
        double[][] matAdj = new double[mat.length][mat[0].length];

        for (int i = 0; i < matAdj.length; i++) {
            for (int j = 0; j < matAdj[0].length; j++) {
                double[][] d = sacarMenor(mat, i, j);
                if (d.length == 1) {
                    matAdj[i][j] = d[0][0] * ((i + j) % 2 == 0 ? 1 : -1);
                } else {
                    matAdj[i][j] = determinante(d) * ((i + j) % 2 == 0 ? 1 : -1);
                }
            }
        }
        return matAdj;
    }

    private static double[][] multiplicacion(double[][] mat, double num) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = mat[i][j] * num;
            }
        }
        return mat;
    }

}