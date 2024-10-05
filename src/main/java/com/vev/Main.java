package com.vev;

public class Main {
    public static void main(String[] args) {
        Estacionamento e = new Estacionamento();
        Cliente c = new Cliente("2024-10-03 01:00", "2024-10-05 01:00", false);

        System.out.println(e.calculaValor(c));
    }
}