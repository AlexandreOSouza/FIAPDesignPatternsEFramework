package br.com.fiap.imposto.control;

import br.com.fiap.imposto.model.Imposto;
import br.com.fiap.imposto.view.TelaDeImposto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// ImpostoController implementa ActionListener para capturar
// o evento do botao da View
public class ImpostoController implements ActionListener {

    // Interfaces do modelo e da view
    private Imposto model;
    private TelaDeImposto view;

    public ImpostoController(Imposto model, TelaDeImposto view) {
        System.out.println("Construtor do Controller chamado");
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        model.calculaImposto(view.getValor());
    }
}
