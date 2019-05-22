package visual;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.LinkedList;

/**
 * @author Miguel Monteiro Claveri
 * <p>
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc
 * Paquete visual
 * Proyecto Calculadora
 * <p>
 * Esta clase nos permite representar un keypad
 * el cual podremos usar para poder cambiar monedas
 */
public class KeypadMoneda {

    // Atributos
    private LinkedList<Double> currency = new LinkedList<Double>();
    private JPanel PanelPrincipal;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox2;
    private JButton updateCurrencysButton;

    /**
     * @param ig Interficie grafica que nos pasan
     *           para poder interactuar con lo que
     *           ve el usuario
     *           <p>
     *           Este constructor inicializamos los listeners
     *           que necesitaremos para poder interactuar con dicho keypad
     *           <p>
     *           Tambien llamamos al metodo initCurrency para inicializar
     *           las monedas
     */
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
        updateCurrencysButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initCurrency();
            }
        });

        initCurrency();
    }

    /**
     * Este metodo lo que hace es calcular
     * el cambio de una moneda a otra
     */
    private void calcCurrency() {

        double currency1 = currency.get(comboBox1.getSelectedIndex());
        double currency2 = currency.get(comboBox2.getSelectedIndex());
        double dinero1 = Double.parseDouble(this.textField1.getText());

        if (currency1 != 0) {
            dinero1 = dinero1 / currency1;
        }
        this.textField2.setText(dinero1 * currency2 + "");
    }

    /**
     * Este metodo nos sirve para inicializar la currency
     * que usaremos para hacer el cambio de moneda. Para hacerlo este
     * metodo se conecta a una api que nos retorna el valor actual de las monedas
     * comparadas con el euro, con esos valores sera con los que
     * trabajemos para convertir los valores.
     * <p>
     * En el caso de que  a la hora de recibir el valor por la api de error por
     * que no se ha podido establecer conexion ya sea por culpa del usuario o la api
     * lo que haremos sera inicializar las currency a un valor generico.
     */
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
            currency.addLast(1.50);
            currency.addLast(1.13);
        }
        if (!textField1.getText().equals("")) calcCurrency();
    }


    /**
     * @return JPanel
     * <p>
     * Este pequeño metodo nos sirve para
     * retornar el panel principal de la clase
     */
    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }

}



