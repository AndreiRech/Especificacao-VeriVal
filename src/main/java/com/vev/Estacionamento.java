package com.vev;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Estacionamento {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    
    public double calculaValor(Cliente cliente) {
        double valor = 0;

        LocalDateTime entrada = LocalDateTime.parse(cliente.getInicio(), formatter);
        LocalDateTime saida = LocalDateTime.parse(cliente.getFim(), formatter);

        Duration duracao = Duration.between(entrada, saida);

        valor = verificaHorario(entrada, saida, duracao);

        if(cliente.getVip()) valor /= 2;

        cliente.setValor(valor);
        return valor;
    }

    private double verificaHorario(LocalDateTime entrada, LocalDateTime saida, Duration duracao) {
        if(!entrada.isBefore(saida)) 
            throw new IllegalArgumentException("A entrada deve ocorrer em um momento anterior à saida.");

        if (horarioFuncionamento(entrada) || horarioFuncionamento(saida))
            throw new IllegalArgumentException("Nem a entrada nem a saída podem ocorrer entre 02:00 e 08:00.");

        long minutos = duracao.toMinutes();

        // Cortesia (ficou até 15 minutos)
        if(minutos <= 15) return 0;

        // Preço fixo (ficou até 60 minutos)
        if(minutos <= 60) return 5.90;

        // Pernoitou (mesmo dia)
        if (saida.getDayOfYear() == entrada.getDayOfYear() && saida.getHour() >= 8 && entrada.getHour() < 2) return 50;

        // Ficou mais de 1 hora e não pernoitou
        if(saida.getDayOfYear() == entrada.getDayOfYear() || (saida.getDayOfYear() == entrada.getDayOfYear()+1 && saida.getHour() < 2)) {
            long horas = (long) Math.ceil((minutos-60) / 60.0);
            return 5.90 + horas * 2.50;
        }

        // Pernoitou (mais de 1 dia)
        if (saida.getDayOfYear() > entrada.getDayOfYear() && saida.getHour() >= 8) {
            long pernoites = 0;

            LocalDateTime tempEntrada = entrada.withHour(8).withMinute(0);
            LocalDateTime tempSaida = saida.withHour(8).withMinute(0);

            while (tempEntrada.isBefore(tempSaida)) {
                pernoites++;
                tempEntrada = tempEntrada.plusDays(1);
            }

            return pernoites * 50;
        }

        return -1;
    }

    private boolean horarioFuncionamento(LocalDateTime horario) {
        int horas = horario.getHour();
        return horas >= 2 && horas < 8; 
    }
}

