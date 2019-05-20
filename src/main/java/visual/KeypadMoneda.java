package visual;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import sun.net.www.http.HttpClient;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Currency;

/**
 * Creado por: mmonteiro
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc
 * Paquete visual
 * Proyecto Calculadora
 */
public class KeypadMoneda {

    private double[] currencyArray = {1, 1.12, 1.13, 1.50};
    private JPanel PanelPrincipal;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox2;

    KeypadMoneda(InterficieGrafica ig) {

        textField1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                calcCurrency();


                System.out.println();
            }
        });

        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcCurrency();
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcCurrency();
            }
        });


    }

    private void calcCurrency() {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://data.fixer.io/api/latest?access_key=dc513faa3ddd0e89323611b54bb3031a&symbols=USD,CAD,CHF&format=1");
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseBody = "";
        try {
            responseBody = httpclient.execute(httpGet, responseHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(responseBody);


        double currency1 = currencyArray[comboBox1.getSelectedIndex()];
        double currency2 = currencyArray[comboBox2.getSelectedIndex()];
        double dinero1 = Double.parseDouble(this.textField1.getText());


        if (currency1 != 0) {
            dinero1 = dinero1 / currency1;
        }

        this.textField2.setText(dinero1 * currency2 + "");
    }


    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }
}
