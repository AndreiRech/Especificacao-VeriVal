package com.vev;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Cliente {
    private boolean vip;
    private String inicio, fim;
    private double valor;
    private static final String FORMATO_DATA = "yyyy-MM-dd HH:mm";

    public Cliente(String inicio, String fim, boolean vip) {
        if (verificarFormatoData(inicio) && verificarFormatoData(fim)) {
            this.inicio = inicio;
            this.fim = fim;
            this.vip = vip;
            this.valor = 0;
        } else {
            throw new IllegalArgumentException("Data em formato inválido. Use o formato: " + FORMATO_DATA);
        }
    }

    private boolean verificarFormatoData(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATO_DATA);
        try {
            LocalDateTime.parse(data, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public String getInicio() {return this.inicio;}
    public String getFim() {return this.fim;}
    public boolean getVip() {return this.vip;}
    public double getValor() {return this.valor;}
    public void setValor(double valor) {this.valor = valor;}

    @Override
    public String toString() {
        return "Inicio = " +this.inicio +" | Fim = " +this.fim +" | Vip = " +this.vip +" | Valor = " +this.valor;
    }
}
