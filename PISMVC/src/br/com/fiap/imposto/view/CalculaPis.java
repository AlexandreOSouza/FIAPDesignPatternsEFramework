package br.com.fiap.imposto.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

public class CalculaPis implements Observer, TelaDeImposto {

    private TextField txtValorFaturado;
    private Button btnCalcular;

    // Construtor para compor a tela
    public CalculaPis() {
        System.out.println("Construtor da View chamado");

        Frame frame = new Frame("Calculo do PIS MVC e Design Patterns");
        frame.add("North", new Label("Valor Faturado"));

        txtValorFaturado = new TextField();
        frame.add("Center", txtValorFaturado);

        Panel panel = new Panel();
        btnCalcular = new Button("Calcula PIS");
        panel.add(btnCalcular);
        frame.add("South", panel);

        frame.addWindowListener(new CloseListener());
        frame.setSize(200, 150);
        frame.setLocation(100, 100);
        frame.setVisible(true);
    }

    @Override
    public float getValor() {
        return Float.parseFloat(txtValorFaturado.getText());
    }

    /*
        Metodo que possibilita a View enviar a açao de calcular
        para o Controller chamar o Model
     */
    public void addController(ActionListener controller) {
        System.out.println("A View Adicionou o Controller");
        btnCalcular.addActionListener(controller);
    }

    /*
     * Update exibe uma mensagem na View contendo:
     * A classe Model
     * O toString sobreescrito
     * O valor do estado, atributo valorDoPis da classe Pis
     */
    // O metodo update sera chamado pelo model notifyObservers()
    @Override
    public void update(Observable model, Object modelValue) {
        String msg = model.getClass()
                + " "
                + model.toString()
                + " "
                + (Float) modelValue;

        JOptionPane.showMessageDialog(null, msg);
    }

    public static class CloseListener extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            e.getWindow().setVisible(false);
            System.exit(0);
        }
    }

}
