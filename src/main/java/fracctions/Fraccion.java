package fracctions;

/**
 * Creado por: mmonteiro
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc
 * Paquete fracctions
 * Proyecto Calculadora
 */
public class Fraccion {

    // Atributos
    private double numerador;
    private double denominador;


    // Constructores
    public Fraccion(double numerador, double denominador) {
        this.denominador = denominador;
        this.numerador = numerador;
    }

    private Fraccion() {
    }

    public Fraccion sumar(Fraccion fraccion1) {
        Fraccion devolver = new Fraccion();

        double mcm = mcm(this.denominador, fraccion1.denominador);
        devolver.denominador = mcm;

        devolver.numerador += (mcm / this.denominador) * this.numerador;
        devolver.numerador += (mcm / fraccion1.denominador) * fraccion1.numerador;
        devolver.simplificar();
        return devolver;
    }


    public Fraccion restar(Fraccion fraccion1) {
        Fraccion devolver = new Fraccion();

        devolver.numerador = (this.numerador * fraccion1.denominador) - (this.denominador * fraccion1.numerador);
        devolver.denominador = this.denominador * fraccion1.denominador;
        devolver.simplificar();
        return devolver;
    }

    public Fraccion multiplicar(Fraccion fraccion1) {
        Fraccion devolver = new Fraccion();
        devolver.numerador = this.numerador * fraccion1.numerador;
        devolver.denominador = this.denominador * fraccion1.denominador;
        devolver.simplificar();
        return devolver;
    }

    public Fraccion dividir(Fraccion fraccion1) {
        Fraccion devolver = new Fraccion();
        devolver.numerador = this.denominador * fraccion1.numerador;
        devolver.denominador = this.numerador * fraccion1.denominador;
        devolver.simplificar();
        return devolver;
    }


    public void simplificar() {
        double mcd = this.mcd(this.numerador, this.denominador);
        this.numerador /= mcd;
        this.denominador /= mcd;
    }


    private double mcd(double numerador, double denominador) {
        double u = Math.abs(numerador);
        double v = Math.abs(denominador);
        if (v == 0) {
            return u;
        }
        double r;
        while (v != 0) {
            r = u % v;
            u = v;
            v = r;
        }
        return u;
    }

    private double mcm(double num1, double num2) {
        double mcm = 0;
        double a = Math.max(num1, num2);
        double b = Math.min(num1, num2);
        mcm = (a / mcd(a, b)) * b;
        return mcm;
    }

    @Override
    public String toString() {
        return this.numerador + "|" + this.denominador;
    }
}
