package visual;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creado por: mmonteiro
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc
 * Paquete visual
 * Proyecto Calculadora
 */
public class ConversionNumericas {
    private JComboBox comboBox1;
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton convertButton;
    private JComboBox comboBox2;


    ConversionNumericas(InterficieGrafica ig) {
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Binario
                // Octal
                // Decimal
                // Hex
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
        });


    }


    // DECIMALES
    private String decimalToBinari(String s) {
        return Integer.toBinaryString(Integer.parseInt(s));
    }

    private String decimalToOctal(String s) {
        return Integer.toOctalString(Integer.parseInt(s));
    }

    private String decimalToHex(String s) {
        return Integer.toHexString(Integer.parseInt(s));
    }

    // BINARIOS
    private String binariToDecimal(String s) {
        return Integer.toString(toDecimal(Integer.parseInt(s)));
    }

    private String binariToOctal(String s) {
        return decimalToOctal(binariToDecimal(s));
    }

    private String binariToHex(String s) {
        return decimalToHex(binariToDecimal(s));
    }

    // Octal
    private String octalToDecimal(String s) {
        return Integer.toString(Integer.parseInt(s, 8));
    }

    private String octalToBinari(String s) {
        return decimalToBinari(octalToDecimal(s));
    }

    private String octalToHex(String s) {
        return decimalToHex(octalToDecimal(s));
    }

    // HEX
    private String hexToDecimal(String s) {
        return Integer.toString(Integer.parseInt(s, 16));
    }

    private String hexToBinari(String s) {
        return decimalToBinari(hexToDecimal(s));
    }

    private String hexToOctal(String s) {
        return decimalToOctal(hexToDecimal(s));
    }


    private int toDecimal(int n) {
        int decimal = 0, p = 0;
        while (n != 0) {
            decimal += ((n % 10) * Math.pow(2, p));
            n = n / 10;
            p++;
        }
        return decimal;
    }


    public JPanel getPanel1() {
        return panel1;
    }
}
