package polinomios;

/**
 * Creado por: mmonteiro
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc
 * Paquete polinomios
 * Proyecto Calculadora
 */
public class Polynomial {
    //Atributos
    private float[] coeficientes;
    private float[] copiaSeguridad;

    /**
     * Constructor per defecte. Genera un polinomi zero
     */
    public Polynomial() {
        coeficientes = new float[1];
        coeficientes[0] = 0;
    }


    /**
     * @param coeficientes Recibimos un array con todos los coeficientes, lo que haremos primero de
     *                     todo es hacer una copa de ese array ya que asi si el original se modifica
     *                     nosotros seguiremos con el que nos hayan pasado desde el principio
     *                     <p>
     *                     Despues desde la izq iremos mirando los ceros que hay ya que los 0 a la izquierda no
     *                     nos interesan y despues desde el primer numero por la izq que no sea 0 lo copiaremos
     *                     a el array membre coeficientes
     */
    public Polynomial(float[] coeficientes) {
        //Lo que hago aqui es crear un nuevo array para no referenciar al
        // que nos pasan ya que el usuario podria modificar ese array
        //entonces usaremos una copia
        float[] newCoeficientes = new float[coeficientes.length];
        for (int i = 0; i < coeficientes.length; i++) {
            newCoeficientes[i] = coeficientes[i];
        }
        int x = 0;
        for (int i = 0; i < newCoeficientes.length; i++) {
            if (newCoeficientes[i] == 0) {
                x++;
            } else {
                break;
            }
        }
        if (x == newCoeficientes.length) {

            this.coeficientes = new float[1];
            this.coeficientes[0] = 0;
        } else {
            this.coeficientes = new float[newCoeficientes.length - x];
            for (int i = 0, j = x; i < this.coeficientes.length; i++, j++) {
                this.coeficientes[i] = newCoeficientes[j];
            }
        }

        this.copiaSeguridad = copiarArray(this.coeficientes);
    }

    /**
     * @param stringPolinomio Recibimos un polinomio en formato de String (2x^3 - 4 + 5x^2 + 32)
     *                        <p>
     *                        Esta funcion va leyendo el string monomio a monomio y lo que hace es ir
     *                        pasando esos monomios a otra funcion externa la cual se encargara de mirar la potencia de ese monomio
     *                        y añadirlo al array de coeficientes donde le toca
     */
    public Polynomial(String stringPolinomio) {

        if (stringPolinomio.length() == 1 || (stringPolinomio.length() == 2 && (stringPolinomio.charAt(0) == '-' || stringPolinomio.charAt(0) == '+'))) {
            this.coeficientes = new float[1];
            if (stringPolinomio.charAt(0) == 'x') {
                this.coeficientes = new float[2];
                this.coeficientes[0] = 1;
                this.coeficientes[1] = 0;

            } else {

                this.coeficientes[0] = Float.parseFloat(stringPolinomio);
            }
            return;
        }
        if (stringPolinomio.charAt(0) != 'x' && stringPolinomio.charAt(0) != '-' && stringPolinomio.charAt(0) != '+') {
            stringPolinomio = "+" + stringPolinomio;
        }

        // Rutina que elimina espacios
        StringBuilder polinomio = new StringBuilder();
        for (int i = 0; i < stringPolinomio.length(); i++) {
            if (stringPolinomio.charAt(i) != ' ') {
                polinomio.append(stringPolinomio.charAt(i));
            }
        }

        int mayorPotencia = buscarMayorPotencia(polinomio.toString());

        // Creamos el array del objeto con la longitud que le toca
        this.coeficientes = new float[mayorPotencia + 1];

        // Llamamos a la funcion que añade cada
        // monomio en la posicion de coeficientes que le pertañe
        String monomio = "";
        for (int i = 0; i < polinomio.length(); i++) {
            if ((polinomio.charAt(i) == '-' || polinomio.charAt(i) == '+') && i > 0) {
                creacionMonomio(monomio);
                monomio = "";
            }
            monomio = monomio + polinomio.charAt(i);
            if (i + 1 >= polinomio.length()) {
                creacionMonomio(monomio);
                monomio = "";
            }
        }

        invertirArray();


        if (this.coeficientes.length > 1) {
            //Comprovacion fallo 0 a la izq
            int comp = 0;
            while (true) {
                if (this.coeficientes[comp] == 0) {
                    // Si es todo 0 lo que hacemos es restaurar
                    //  el array y hacer que sea de longitud 1 con un 0
                    if (comp + 1 == this.coeficientes.length) {
                        this.coeficientes = new float[1];
                        this.coeficientes[0] = 0;
                        return;
                    }

                    comp++;
                    continue;
                } else {
                    break;
                }
            }

            // Si hay algun 0 a la izq lo que
            // hacemos es quitar esos 0 de la izquierda
            if (comp != 0) {
                int longi = this.coeficientes.length;
                float[] copia = new float[longi];

                for (int i = 0; i < longi; i++) {
                    copia[i] = this.coeficientes[i];
                }
                this.coeficientes = new float[longi - comp];
                for (int i = 0; i < this.coeficientes.length; i++) {
                    this.coeficientes[i] = copia[comp];
                    comp++;
                }
            }
        }
        this.copiaSeguridad = copiarArray(this.coeficientes);
    }


    /**
     * @param poligono recibimos dos poligonos (1 el que nos pasan y 2 el que pasamos llamando a el metodo)
     * @return devolvemos un nuevo polinomo que es el resultado de la suma de los dos polinomios
     * <p>
     * <p>
     * Este metodo lo que hace es recibir 2 polinomios, 1 el que le pasamos y otro el que llamamos a ese polinomio.
     * Primero identificamos cual de los dos tiene un mayor exponente y lo asignamos a mayor, el que es menor lo añadimos a menor.
     * Despues invertimos los dos arrays de coeficientes que tenemos (mayor y menor) y lo que hacemos es ir recorriendo el array
     * resultado el cual sera de la misma longitud que el mayor de los dos iniciales.
     * i mientras que i sea menos que la longitud del menor, iremos sumando las dos posiciones i de cada array
     * si i es mayor que la longitud del menor, lo que haremos sera simplemente añadir la posicion de i de mayor en la posicion de i de resultado
     */
    // Suma el polinomi amb un altre. No modifica el polinomi actual (this). Genera un de nou
    public Polynomial add(Polynomial poligono) {

        float[] mayor;
        float[] menor;
        if (this.coeficientes.length > poligono.coeficientes.length) {
            mayor = this.coeficientes;
            menor = poligono.coeficientes;
        } else {
            mayor = poligono.coeficientes;
            menor = this.coeficientes;
        }

        float[] resultado = new float[mayor.length];
        mayor = invertirArray(mayor);
        menor = invertirArray(menor);
        for (int i = 0; i < resultado.length; i++) {
            if (i >= menor.length) {
                resultado[i] = mayor[i];
            } else {
                resultado[i] = mayor[i] + menor[i];
            }
        }
        resultado = invertirArray(resultado);
        // RESTABLECEMOS LOS ARRAYS DE COEFICIENTES ORIGINALES
        mayor = invertirArray(mayor);
        menor = invertirArray(menor);
        return new Polynomial(resultado);
    }


    /**
     * @param polinomio recibimos dos polinomios (1 el que pasamos por parametro y 2 el que pasamos llamando al metodo (this))
     * @return devolvemos un nuevo polinomio que sera el resultado de la multiplicacion de los dos polinomios originales
     * <p>
     * Esta funcion lo que hace es identificar las dos mayores potencias de cada polinomio (la longitud de cada uno - 1)
     * lo que haremos sera dependiendo de cual sea mayor llamar a la funcion multiplicar de una o otra manera, esta funcion
     * nos retornara el array de el resultado, con ese array llamaremos al constructor de polinomio lo retornaremos
     */
    // Multiplica el polinomi amb un altre. No modifica el polinomi actual (this). Genera un de nou
    public Polynomial mult(Polynomial polinomio) {
        int mayorPotencia1 = this.coeficientes.length - 1, mayorPotencia2 = polinomio.coeficientes.length - 1, longitud = mayorPotencia1 + mayorPotencia2;

        float[] array;
        if (mayorPotencia1 > mayorPotencia2) {
            array = multiplicar(polinomio.coeficientes, this.coeficientes, longitud);
        } else {
            array = multiplicar(this.coeficientes, polinomio.coeficientes, longitud);
        }
        return new Polynomial(array);
    }


    /**
     * @param p2 Segundo polinomio
     * @return devuelve un array de polinomios
     * <p>
     * Esta funcion utiliza un bucle anidado a otro leyendo dividendo
     * a dividendo y leyendo todos los divisores y los va asignando a la posicion que
     * le toca en el array de resultados, cuando acaba lo que hace
     * es retornar el array de residuo tambien.
     */
    public Polynomial[] div(Polynomial p2) {

        float[] dividendo = copiarArray(this.coeficientes);
        float[] divisor = copiarArray(p2.coeficientes);
        dividendo = invertirArray(dividendo);
        divisor = invertirArray(divisor);

        float[] coeficientesDivision;
        coeficientesDivision = new float[dividendo.length - 1];

        int posicion;
        int x;
        double divi;
        for (int i = dividendo.length - 1; i >= divisor.length - 1; i--) {
            divi = 0;
            x = 1;
            for (int j = divisor.length - 1; j >= 0; j--) {
                posicion = i - j;
                if (j == divisor.length - 1) {
                    if (posicion < 0) {
                        posicion = 0;
                    }
                    coeficientesDivision[posicion] = dividendo[i] / divisor[j];
                    divi = dividendo[i] / divisor[j];
                    dividendo[i] = 0;
                } else {
                    posicion = i - x;
                    if (posicion < 0) {
                        posicion = 0;
                    }
                    dividendo[posicion] += (float) ((divisor[j] * divi) * (-1));
                    x++;
                }
            }
        }
        Polynomial[] polinomios = {new Polynomial(invertirArray(coeficientesDivision)), new Polynomial(invertirArray(dividendo))};
        return polinomios;
    }


    /**
     * @return Retornamos un array de floats las cuales son las raices de ese polinomio ordenadas de menor a mayor
     * <p>
     * En este metodo lo que hacemos es ir comprovando posibilidades de sacar las raices (dependiendo
     * si son polinomios de primer grado, segundo, bicuadraticas etc)
     * entonces si no encontramos ninguna de esas posibilidades, esta funcion hara 1 vez rufini y despues hara recursividad
     * para volver a probar si podemos sacar las siguientes soluciones sin rufini
     */
    public float[] roots() {
        float[] divisores = new float[0];
        float[] cofi = copiarArray(this.coeficientes);

        boolean PrincipioFin = prueba(cofi);
        float[] resultado = new float[0];

        if (cofi.length == 1) {
            //No hay solucion
            return null;
        } else if (cofi.length == 2) {

            //Primer grado
            resultado = new float[1];
            resultado[0] = (cofi[1] * (-1)) / cofi[0];

        } else if (cofi.length == 3) {

            //Segundo grado
            float a = cofi[0];
            float b = cofi[1];
            float c = cofi[2];
            float discriminante = b * b - 4 * a * c;
            if (discriminante < 0) {
                return null;
            }
            resultado = segundoGrado(cofi);
        } else if (PrincipioFin) {
            //Todo es 0 excepto maximo exponente y termino independiente

            float a = cofi[0];
            float b = cofi[cofi.length - 1] * (-1);

            float discriminante = b / a;
            float indice = cofi.length - 1;
            if (discriminante < 0 && (indice % 2 == 0)) {
                return null;
            } else {
                resultado = calculosPrincipioYfin(cofi, indice, discriminante);
            }

        } else if (cofi.length == 5 && (cofi[1] == 0 && cofi[3] == 0)) {
            //Bicuadratica

            //Segundo grado
            float a = cofi[0];
            float b = cofi[2];
            float c = cofi[4];
            float discriminante = b * b - 4 * a * c;
            if (discriminante < 0) {
                return null;
            }
            float[] cofi1 = new float[3];
            cofi1[0] = cofi[0];
            cofi1[1] = cofi[2];
            cofi1[2] = cofi[4];
            resultado = segundoGrado(cofi1);

            float[] resultado1 = new float[resultado.length * 2];

            for (int i = 0, j = 0; i < resultado.length; i++, j++) {
                resultado1[j] = (float) Math.sqrt(resultado[i]);
                j++;
                resultado1[j] = (float) Math.sqrt(resultado[i]) * (-1);
            }

            resultado = resultado1;

        } else {

            // RUFINI

            float[] c = new float[this.coeficientes.length];
            float[] cIntermedio = new float[c.length];
            float[] cFinal = new float[c.length];

            c = copiarArray(this.coeficientes);

            int ii = 1;
            int divisor = 1;
            float[] ccopia = new float[0];

            boolean prova = false;
            while (ii > 0) {


                float indepe = c[c.length - 1];
                if (comprovar(divisor, divisores)) {
                    if (divisor > 0) {
                        divisor *= (-1);
                    } else {
                        divisor *= (-1);
                        divisor++;
                    }

                    continue;
                }

                if (indepe < 0) indepe *= (-1);
                for (int j = 0; divisor < indepe; divisor += 0) {

                    for (int i = 0; i < c.length; i++) {

                        cFinal[i] += c[i] + cIntermedio[i];

                        if (i + 1 != c.length) {
                            cIntermedio[i + 1] += cFinal[i] * divisor;
                        }
                    }

                    if (cFinal[cFinal.length - 1] == 0) {
                        break;
                    } else {
                        if (divisor > 0) {
                            divisor *= (-1);
                        } else {
                            divisor *= (-1);
                            divisor++;
                        }

                        cFinal = new float[cFinal.length];
                        cIntermedio = new float[cIntermedio.length];
                    }
                }
                float[] copiaDiv = copiarArray(divisores);
                divisores = new float[divisores.length + 1];

                for (int i = 0; i < divisores.length; i++) {
                    if (i >= copiaDiv.length) {
                        divisores[i] = divisor;
                        break;
                    }
                    divisores[i] = copiaDiv[i];
                }

                c = new float[cFinal.length - 1];
                for (int i = 0; i < c.length; i++) {
                    c[i] = cFinal[i];
                }

                cIntermedio = new float[c.length];
                cFinal = new float[c.length];
                ii--;
            }

            this.coeficientes = c;
            float[] otrosResultado = roots();

            int i = 0;

            resultado = new float[divisores.length + otrosResultado.length];
            while (i < divisores.length) {
                resultado[i] = divisores[i];
                i++;
            }
            while (i - divisores.length < otrosResultado.length) {

                resultado[i] = otrosResultado[i - divisores.length];
                i++;
            }

        }
        this.coeficientes = copiaSeguridad;
        resultado = burbuja(resultado);
        return resultado;
    }


    /**
     * @param objeto donde objeto es otro polinomio
     * @return devuelve true/false dependiendo si los dos polinomios son iguales o no
     */
    // Torna "true" si els polinomis són iguals. Això és un override d'un mètode de la classe Object
    @Override
    public boolean equals(Object objeto) {
        Polynomial p1 = (Polynomial) objeto;
        if (p1.coeficientes.length != this.coeficientes.length) return false;
        for (int i = 0; i < this.coeficientes.length; i++) {
            if (this.coeficientes[i] != p1.coeficientes[i]) {
                return false;
            }
        }
        return true;
    }


    /**
     * @return Devolvemos un polinomio en forma de string
     * <p>
     * En esta funcion lo que hacemos es leer posicion a
     * posicion del array Coeficientes de ese polinomio, y
     * la vamos añadiendo con sus respectivas x si le pertañen y
     * sus respectivas potencias
     * <p>
     * Ejemplos:
     * [3,-2,0] --> 3x² -2x
     * [4,-1,0,11] --> 4x³ - x² + 11
     */
    // Torna la representació en forma de String del polinomi. Override d'un mètode de la classe Object
    @Override
    public String toString() {
        if (coeficientes.length == 1 && coeficientes[0] == 0) {
            return "0";
        }
        String devolver = "";
        float[] coeficientesInvertidos = invertirArray(this.coeficientes);
        String simbolo = "";
        int potencia = 0;
        int cof1 = 0;
        float cof2 = 0;

        for (int i = 0; i < coeficientesInvertidos.length; i++) {
            cof1 = (int) coeficientesInvertidos[i];
            cof2 = coeficientesInvertidos[i];
            if (coeficientesInvertidos[i] == 0) {
                continue;
            }
            if (coeficientesInvertidos[i] >= 0) {
                simbolo = "+";
            } else {
                simbolo = "-";
                cof1 = (int) coeficientesInvertidos[i] * (-1);
                cof2 = coeficientesInvertidos[i] * (-1);
            }

            if (cof1 == cof2) {// SE USARA NUMEROS ENTEROS
                if (i == 0) {
                    // Posicion 0 ira sin X

                    devolver = cof1 + devolver;
                } else if (i == 1) {
                    // Posicion 1 ira con X sin capellan
                    if (cof1 == 1) {
                        devolver = "x" + devolver;
                    } else {
                        devolver = cof1 + "x" + devolver;
                    }
                } else {
                    //Todas las demas posiciones iran con X y con ^ donde la potencia sera la I
                    if (cof1 == 1 || cof1 == -1) {
                        devolver = "x^" + i + devolver;
                    } else {
                        devolver = cof1 + "x^" + i + devolver;
                    }
                }
            } else {// SE USARA NUMEROS DECIMALES
                if (i == 0) {
                    // Posicion 0 ira sin X
                    devolver = coeficientesInvertidos[i] + devolver;
                } else if (i == 1) {
                    // Posicion 1 ira con X sin capellan
                    if (coeficientesInvertidos[i] == 1) {
                        devolver = "x" + devolver;

                    } else {
                        devolver = coeficientesInvertidos[i] + "x" + devolver;
                    }
                } else {
                    //Todas las demas posiciones iran con X y con ^ donde la potencia sera la I
                    if (cof1 == 1) {
                        devolver = "x^" + i + devolver;
                    } else {
                        float num = coeficientesInvertidos[i];
                        if (simbolo.equals("-")) {
                            num = num * (-1);
                        }
                        devolver = num + "x^" + i + devolver;
                    }
                }
            }

            if (i + 1 != coeficientesInvertidos.length) {
                devolver = " " + simbolo + " " + devolver;
            } else if (simbolo.equals("-")) {
                devolver = simbolo + "" + devolver;
            }
        }
        return devolver;
    }

    //FUNCIONES QUE HE NECESITADO

    /**
     * @param coef1    Coeficientes del primero polinomio
     * @param coef2    Coeficientes del segundo polinomio
     * @param longitud es la longuitud que tendra que usar para crear el
     *                 array del nuevo polinomio resultante de la
     *                 multiplicación
     * @return devuelve array el cual sera los coeficientes del resultado de la multiplicacion
     * <p>
     * Este metodo recibe dos arrays de dos polinomios y lo que hace es ir recorriendo uno a
     * uno los coeficientes del primer polinomio, y los va multiplicando con todos los coeficientes
     * del segundo polinomio
     */
    private float[] multiplicar(float[] coef1, float[] coef2, int longitud) {
        float[] resultado = new float[longitud + 1];
        //invertimos los arrays
        coef1 = invertirArray(coef1);
        coef2 = invertirArray(coef2);

        for (int i = 0; i < coef1.length; i++) {
            for (int j = 0; j < coef2.length; j++) {
                resultado[i + j] += coef1[i] * coef2[j];
            }
        }
        resultado = invertirArray(resultado);
        return resultado;
    }

    /**
     * @param monomio Recibimos una String la cual contiene un monomio
     *                <p>
     *                Lo que hacemos es recibir un monomio, identificar cual es su potencia (sin incognita potencia = 0,
     *                con incognita potencia = 1, con incognita y potencia potencia=potencia)
     *                <p>
     *                Despues de identificar la potencia, identificamos el coeficiente de ese
     *                monomio y lo añadimos al array de coeficientes en la posicion(potencia)
     */
    private void creacionMonomio(String monomio) {
        String aPasar = "";
        boolean simbolo = true; // TRUE POSITIVO ---- FALSE NEGATIVO
        int potencia = 0;
        float coeficiente = 0;

        if (monomio.charAt(0) == '-') {
            // Definimos que el monomio es negativo
            simbolo = false;
        }
        if (monomio.contains("x")) {
            if (monomio.contains("^")) {
                if (monomio.charAt(0) == 'x') {
                    monomio = 1 + monomio;
                } else if (monomio.charAt(0) == '-' && monomio.charAt(1) == 'x') {
                    String monomio2 = "";
                    for (int i = 0; i < monomio.length(); i++) {
                        if (i == 1) {
                            monomio2 = monomio2 + 1;
                        }
                        monomio2 = monomio2 + monomio.charAt(i);
                    }
                }
                int i = monomio.length() - 1;
                while (true) {
                    if (monomio.charAt(i) == '^') {
                        break;
                    }
                    aPasar = monomio.charAt(i) + aPasar;
                    i--;
                }
                potencia = Integer.parseInt(aPasar);
                aPasar = "";
            } else {
                potencia = 1;
            }

            int i = 1;
            if (i + 1 >= monomio.length()) {
                // no hacemos nada
            } else {
                while (true) {
                    if (monomio.charAt(i) == 'x') break;
                    aPasar = aPasar + monomio.charAt(i);
                    if (i + 1 >= monomio.length()) {
                        break;
                    }
                    i++;
                }
            }

            if (aPasar.equals("")) {
                aPasar = "" + 1;
            } else if (aPasar.equals("-")) {
                aPasar = "" + (-1);
            }
            coeficiente = Float.parseFloat(aPasar);
        } else {
            potencia = 0;
            if (monomio.charAt(0) != '-' && monomio.charAt(0) != '+') {
                coeficiente = Float.parseFloat(monomio);
            } else {
                String monomio2 = "";
                for (int i = 1; i < monomio.length(); i++) {
                    monomio2 = monomio2 + monomio.charAt(i);
                }
                coeficiente = Float.parseFloat(monomio2);
            }
        }

        //multiplicacion del simbolo
        if (!simbolo) {
            coeficiente = coeficiente * (-1);
        }
        this.coeficientes[potencia] += coeficiente;
    }


    /**
     * @param polinomio Esta creacionMonomio recibe una String la cual contiene un polinomio
     * @return devuelve un Int el cual es la mayor potencia de ese polinomio que le hemos pasado
     * <p>
     * hasta que acabe el polinomio
     * Lo que hace esya creacionMonomio es recorrer el polinomio, y va mirando monomio a monomio cual
     * es su potencia y esa potencia actual la compara con la mayor potencia, en el case de que
     * la actual sea mayor a la mayor, se reestablece la mayor por la actual y vuelve a empezar
     */
    private int buscarMayorPotencia(String polinomio) {
        int mayorPotencia = 0;
        int potenciaActual = 0;
        String aPasar = "";
        // Encotrnamos la mayor potencia de todo el polinomo
        for (int i = 0; i < polinomio.length(); i++) {
            if (polinomio.charAt(i) == 'x') {
                if (i + 1 >= polinomio.length()) {
                    potenciaActual = 1;
                } else {
                    if (polinomio.charAt(i + 1) == '^') {
                        //Este bucle lo que hace es que te convierte numeros de mas de dos digitos a integer
                        for (int j = i + 2; j < polinomio.length(); j++) {
                            if (polinomio.charAt(j) == '-' || polinomio.charAt(j) == '+') {
                                i += j - i;
                                break;
                            }
                            aPasar += polinomio.charAt(j);
                        }
                        potenciaActual = Integer.parseInt(aPasar);
                    } else {
                        potenciaActual = 1;
                    }
                }
            }
            if (potenciaActual > mayorPotencia) {
                mayorPotencia = potenciaActual;
            }
            aPasar = "";
        }
        return mayorPotencia;
    }

    /**
     * @param array array a copiar
     * @return copia de array
     * <p>
     * FUNCION QUE TE DEVUELVE UNA
     * COPIA DE UN ARRAY QUE PASAMOS
     */
    private float[] copiarArray(float[] array) {
        float[] copia = new float[array.length];
        for (int i = 0; i < array.length; i++) {
            copia[i] = array[i];
        }
        return copia;
    }

    /**
     * @param coeficientes Recibe un array de floats
     * @return devuelve el mismo array que ha recibido pero invertido (IMPORTANTE, DEVUELVE UN NUEVO ARRAY, EL ORIGINAL NO SE MODIFICA)
     */
    private float[] invertirArray(float[] coeficientes) {

        //te devuelve una copia
        float[] nuevoCoeficiente = copiarArray(coeficientes);

        for (int i = 0, j = nuevoCoeficiente.length - 1; i < j; i++, j--) {

            float swap;
            swap = nuevoCoeficiente[i];
            nuevoCoeficiente[i] = nuevoCoeficiente[j];
            nuevoCoeficiente[j] = swap;

        }
        return nuevoCoeficiente;
    }

    /**
     * Esta creacionMonomio lo que hace es al llamarla, invertimos
     * el array de coeficientes del objeto desde el cual llamamos
     * a esta creacionMonomio/metodo.
     * <p>
     * No recibe ningun parametro ni devuelve ningun otro parametro
     */
    private void invertirArray() {
        for (int i = 0, j = this.coeficientes.length - 1; i < j; i++, j--) {
            float swap;
            swap = this.coeficientes[i];
            this.coeficientes[i] = this.coeficientes[j];
            this.coeficientes[j] = swap;
        }
    }

    /**
     * @param ar Array a ordenar
     * @return Array ordenado
     * <p>
     * Este metodo nos permite ordenar de menor a mayor.
     * En el caso de que queramos ordenar de mayor a menor
     * llamamos a este metodo y despues sobre el resultado
     * que nos retorne llamamos al metodo invertir array
     */
    private float[] burbuja(float[] ar) {
        for (int i = ar.length, x = 0; i > x; i--, x++) {

            for (int j = 1; j < i; j++) {
                if (ar[j - 1] > ar[j]) {
                    float Swap1 = ar[j];
                    ar[j] = ar[j - 1];
                    ar[j - 1] = Swap1;
                }
            }
            for (int k = (i - 1); k > x; k--) {
                if (ar[k - 1] > ar[k]) {
                    float swap2 = ar[k];
                    ar[k] = ar[k - 1];
                    ar[k - 1] = swap2;
                }
            }

        }
        return ar;
    }


    /**
     * @param n         Numero
     * @param divisores array
     * @return TRUE / FALSE
     * <p>
     * Comprovamos si el numero que
     * nos pasa pertenece al array que nos pasan
     */
    private boolean comprovar(float n, float[] divisores) {

        for (int i = 0; i < divisores.length; i++) {
            if (divisores[i] == n) {
                return true;
            }
        }
        return false;

    }

    /**
     * @param cofi Array de floats de los coeficientes
     * @return retornamos un array con las soluciones
     * <p>
     * Este metodo lo que hace es calcular la solucion
     * de una equación de segundo grado, solo entra en
     * esta funcion si el discriminante es positivo,
     * vamos que como minimo tiene 1 solucion
     */
    private float[] segundoGrado(float[] cofi) {
        float a = cofi[0];
        float b = cofi[1];
        float c = cofi[2];
        float[] dev = new float[0];

        float discriminante = b * b - 4 * a * c;
        if (discriminante == 0) {
            float x = (float) (-b + Math.sqrt(discriminante)) / (2 * a);
            dev = new float[1];
            dev[0] = x;
            return dev;
        } else {
            float x1 = (float) (-b + Math.sqrt(discriminante)) / (2 * a);
            float x2 = (float) (-b - Math.sqrt(discriminante)) / (2 * a);
            dev = new float[2];
            dev[0] = x1;
            dev[1] = x2;
        }
        return dev;
    }

    /**
     * @param cofi          Array de floats
     * @param indice        es el indice de la raiz que hay que calcular
     * @param discriminante discriminante
     * @return devolvemos un array con las soluciones
     * <p>
     * tenemos un if con un else el cual definira si ese polinomio tiene 1 o 2 soluciones
     */
    private float[] calculosPrincipioYfin(float[] cofi, float indice, float discriminante) {
        float[] resultado = new float[0];
        if ((cofi.length - 1) % 2 == 0) {
            // DOS SOLUCIONES

            resultado = new float[2];
            resultado[0] = (float) Math.pow(discriminante, 1.0 / indice);
            resultado[1] = (float) Math.pow(discriminante, 1.0 / indice) * (-1);

        } else {
            // UNA SOLUCION
            boolean xx = false;
            resultado = new float[1];
            if (discriminante < 0) {
                discriminante = discriminante * (-1);
                xx = true;
            }
            resultado[0] = (float) Math.pow(discriminante, 1.0 / indice);
            if (xx) {
                resultado[0] = resultado[0] * (-1);
            }
        }
        return resultado;
    }


    /**
     * @param cofi Array de floats
     * @return boolean TRUE/FALSE
     * <p>
     * <p>
     * Metodo que nos sirve para comprovar si el array de coeficientes tiene
     * todo a ceros entre la primera posicion y la untima exclusive
     */
    private boolean prueba(float[] cofi) {
        int x = 0;
        for (int i = 0; i < cofi.length; i++) {
            if (cofi[i] != 0) x++;
        }

        return x == 2 || (x == 1 && cofi[cofi.length - 1] == 0);
    }
}
