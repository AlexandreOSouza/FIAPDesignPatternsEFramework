package br.com.fiap.imposto.model;

import java.util.Observable;

public class Pis extends Observable implements Imposto {

    final float ALIQUOTA = 0.65f;
    float valorPis = 0;

    public Pis() {
        System.out.println("Construtor do Model chamado");
    }

    public float getALIQUOTA() {
        return ALIQUOTA;
    }

    public float getValorPis() {
        return valorPis;
    }

    public void setValorPis(float valorPis) {
        this.valorPis = valorPis;
    }

    @Override
    public void calculaImposto(float valor) {
        valorPis = valor * ALIQUOTA;

        // setChanged altera o estado interno do objeto
        // para true, pois houve alteraçao no estado valorPis
        setChanged();

        // Os observadores devem ser notificados
        // Envia o valor do PIS como parte da mensagem de
        // notificaçao para a View que e um Observer
        notifyObservers(valorPis);
    }

    @Override
    public String toString() {
        return "Pis{" +
                "ALIQUOTA=" + ALIQUOTA +
                ", valorPis=" + valorPis +
                '}';
    }
}
