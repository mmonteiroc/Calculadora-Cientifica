package visual;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Miguel Monteiro Claveri
 * <p>
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc
 * Paquete visual
 * Proyecto Calculadora
 * <p>
 * Esta clase nos permite definir un keypad
 * para poder hacer conversiones numericas
 */
public class ConversionNumericas {

    // Atributos de la clase
    private JComboBox comboBox1;
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton convertButton;
    private JComboBox comboBox2;

    /**
     * @param ig Recibimos la interficie grafica que el usuario estara viendo
     *           <p>
     *           Este metodo es el contructor de esta clase que nos permite definir un KeyPad para conversiones de binaro hex octal y decimal.
     *           En este constructor lo que hacemos es añadir un listener de click al boton de convertir.
     */
    ConversionNumericas(InterficieGrafica ig) {
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertUnits();
            }
        });
    }


    /**
     * Este metodo lo que hace lo primero de todo es mirar
     * que indices de los dos combobox estan seleccionados
     * Despues hace un switchs para saber de que tipo de
     * numero a cual otro ha de convertir y llama a las
     * funciones pertinentes para convertirlos, despues
     * en el textfield de salida asignamos el valor transformado
     */
    private void convertUnits() {
        int n = comboBox1.getSelectedIndex();
        int n2 = comboBox2.getSelectedIndex();
        switch (n) {
            case 0:
                // Binari to :
                switch (n2) {
                    case 1:
                        textField2.setText(binariToOctal(textField1.getText()));
                        break;
                    case 2:
                        textField2.setText(binariToDecimal(textField1.getText()));
                        break;
                    case 3:
                        textField2.setText(binariToHex(textField1.getText()));
                        break;
                    default:
                        break;
                }
                break;
            case 1:
                // Octal to :
                switch (n2) {
                    case 0:
                        textField2.setText(octalToBinari(textField1.getText()));
                        break;
                    case 2:
                        textField2.setText(octalToDecimal(textField1.getText()));
                        break;
                    case 3:
                        textField2.setText(octalToHex(textField1.getText()));
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                // Decimal to :
                switch (n2) {
                    case 0:
                        textField2.setText(decimalToBinari(textField1.getText()));
                        break;
                    case 1:
                        textField2.setText(decimalToOctal(textField1.getText()));
                        break;
                    case 3:
                        textField2.setText(decimalToHex(textField1.getText()));
                        break;
                    default:
                        break;
                }
                break;
            case 3:
                // Hex to :
                switch (n2) {
                    case 0:
                        textField2.setText(hexToBinari(textField1.getText()));
                        break;
                    case 1:
                        textField2.setText(hexToOctal(textField1.getText()));
                        break;
                    case 2:
                        textField2.setText(hexToDecimal(textField1.getText()));
                        break;
                    default:
                        break;
                }
                break;


            default:
                break;
        }
    }


    // DECIMALES

    /**
     * @param s Decimal
     * @return Binario
     * <p>
     * Este metodo nos permite
     * transformar de decimal a binario
     */
    private String decimalToBinari(String s) {
        return Integer.toBinaryString(Integer.parseInt(s));
    }

    /**
     * @param s Decimal
     * @return Octal
     * <p>
     * Este metodo nos permite
     * transformar de decimal a Octal
     */
    private String decimalToOctal(String s) {
        return Integer.toOctalString(Integer.parseInt(s));
    }

    /**
     * @param s Decimal
     * @return Hex
     * <p>
     * Este metodo nos permite
     * transformar de decimal a Hex
     */
    private String decimalToHex(String s) {
        return Integer.toHexString(Integer.parseInt(s));
    }


    // BINARIOS

    /**
     * @param s Binario
     * @return Decimal
     * <p>
     * Este metodo nos permite
     * transformar de binario a decimal
     */
    private String binariToDecimal(String s) {
        return Integer.toString(toDecimal(Integer.parseInt(s)));
    }

    /**
     * @param s Binario
     * @return Octal
     * <p>
     * Este metodo nos permite
     * transformar de binario a Octal
     */
    private String binariToOctal(String s) {
        return decimalToOctal(binariToDecimal(s));
    }

    /**
     * @param s Binario
     * @return Hex
     * <p>
     * Este metodo nos permite
     * transformar de binario a Hex
     */
    private String binariToHex(String s) {
        return decimalToHex(binariToDecimal(s));
    }


    // Octal

    /**
     * @param s Octal
     * @return Decimal
     * <p>
     * Este metodo nos permite
     * transformar de octal a decimal
     */
    private String octalToDecimal(String s) {
        return Integer.toString(Integer.parseInt(s, 8));
    }

    /**
     * @param s Octal
     * @return Binario
     * <p>
     * Este metodo nos permite
     * transformar de octal a binario
     */
    private String octalToBinari(String s) {
        return decimalToBinari(octalToDecimal(s));
    }

    /**
     * @param s Octal
     * @return Hex
     * <p>
     * Este metodo nos permite
     * transformar de octal a Hex
     */
    private String octalToHex(String s) {
        return decimalToHex(octalToDecimal(s));
    }

    // HEX

    /**
     * @param s Hex
     * @return Decimal
     * <p>
     * Este metodo nos permite
     * transformar de hex a decimal
     */
    private String hexToDecimal(String s) {
        return Integer.toString(Integer.parseInt(s, 16));
    }

    /**
     * @param s Hex
     * @return binario
     * <p>
     * Este metodo nos permite
     * transformar de hex a binario
     */
    private String hexToBinari(String s) {
        return decimalToBinari(hexToDecimal(s));
    }

    /**
     * @param s Hex
     * @return Octal
     * <p>
     * Este metodo nos permite
     * transformar de hex a Octal
     */
    private String hexToOctal(String s) {
        return decimalToOctal(hexToDecimal(s));
    }


    /**
     * @param n numero en binario
     * @return numero convertido a deminal
     * <p>
     * Este metodo nos permite transformar
     * un numero binario a decimal
     */
    private int toDecimal(int n) {
        int decimal = 0, p = 0;
        while (n != 0) {
            decimal += ((n % 10) * Math.pow(2, p));
            n = n / 10;
            p++;
        }
        return decimal;
    }


    /**
     * @return JPanel de esta clase
     * <p>
     * Este simple metodo nos retorna el
     * panel principal de esta clase.
     */
    public JPanel getPanel1() {
        return panel1;
    }
}
