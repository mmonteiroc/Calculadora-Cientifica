package visual;

import com.google.gson.Gson;
import jdk.nashorn.internal.parser.JSONParser;
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
import java.util.LinkedList;

/**
 * Creado por: mmonteiro
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc
 * Paquete visual
 * Proyecto Calculadora
 */
public class KeypadMoneda {

    private LinkedList<Double> currency = new LinkedList<Double>();
    private JPanel PanelPrincipal;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox2;

    KeypadMoneda(InterficieGrafica ig) {
        currency.addFirst(1d);
        textField1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (!textField1.getText().equals("")) calcCurrency();
            }
        });

        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textField1.getText().equals("")) calcCurrency();
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textField1.getText().equals("")) calcCurrency();
            }
        });


        initCurrency();
    }

    private void calcCurrency() {

        double currency1 = currency.get(comboBox1.getSelectedIndex());
        double currency2 = currency.get(comboBox2.getSelectedIndex());
        double dinero1 = Double.parseDouble(this.textField1.getText());


        if (currency1 != 0) {
            dinero1 = dinero1 / currency1;
        }

        this.textField2.setText(dinero1 * currency2 + "");
    }

    private void initCurrency() {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://data.fixer.io/api/latest?access_key=dc513faa3ddd0e89323611b54bb3031a&symbols=USD,CAD,CHF&format=1");
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseBody = "";
        try {
            responseBody = httpclient.execute(httpGet, responseHandler);

            int i = responseBody.indexOf("USD") + 5;
            String c = "";
            for (int j = i; j < responseBody.length(); j++) {
                if (responseBody.charAt(j) == ',') break;
                c += responseBody.charAt(j);
            }

            currency.addLast(Double.parseDouble(c));

            i = responseBody.indexOf("CAD") + 5;
            c = "";
            for (int j = i; j < responseBody.length(); j++) {
                if (responseBody.charAt(j) == ',') break;
                c += responseBody.charAt(j);
            }
            currency.addLast(Double.parseDouble(c));


            i = responseBody.indexOf("CHF") + 5;
            c = "";
            for (int j = i; j < responseBody.length(); j++) {
                if (responseBody.charAt(j) == '}') break;
                c += responseBody.charAt(j);
            }
            currency.addLast(Double.parseDouble(c));
        } catch (IOException e) {
            currency.addLast(1.12);
            currency.addLast(3.0);
            currency.addLast(1.13);
        }
    }


    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }
}
