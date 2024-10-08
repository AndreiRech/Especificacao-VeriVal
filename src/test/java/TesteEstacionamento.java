import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.vev.Cliente;
import com.vev.Estacionamento;

/*
 * Os testes inválidos começam na linha 24 e vão até a linha 479
 * Os teste válido começam na linha 481 e vão até a linha 842
 * 
 * Caso deseje, é possível procurar um teste pelo nome constado no PDF.
 */

public class TesteEstacionamento {
    private Estacionamento e = null;

    @BeforeEach
    void setUp() {
        e = new Estacionamento();
    }

    @Test
    @DisplayName("Datas Null")
    void testeInvalidoArgumentosNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente(null, null, false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Ano faltante")
    void testeInvalidoFaltaAno() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("10-10 10:00", "2024-10-10 22:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Dia ou Mes faltante")
    void testeInvalidoFaltaMesOuDia() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2024-10 10:00", "2024-10-10 22:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Horario faltante")
    void testeInvalidoFaltaHoras() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2024-10-10", "2024-10-10 22:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Minutos faltantes")
    void testeInvalidoFaltaMinutos() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2024-10-10 10", "2024-10-10 22:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Ano fora do intervalo")
    void testeInvalidoEntradaAnoLimiteInferior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("0000-10-10 10:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Ano sem um digito")
    void testeInvalidoEntradaAnoMenor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("999-10-10 10:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Ano um digito a mais")
    void testeInvalidoEntradaAnoMaior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("10000-10-10 10:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Mes fora do intervalo")
    void testeInvalidoEntradaMesLimiteSuperior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-13-10 10:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Mes fora do intervalo")
    void testeInvalidoEntradaMesLimiteInferior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-00-10 10:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Mes com um digito a mais")
    void testeInvalidoEntradaMesMaior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-100-10 10:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Mes com um digito a menos")
    void testeInvalidoEntradaMesMenor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-1-10 10:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Dia fora do intervalo")
    void testeInvalidoEntradaDiaLimiteSuperior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-10-32 10:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Dia fora do intervalo")
    void testeInvalidoEntradaDiaLimiteInferior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-10-00 10:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Dia com um digito a mais")
    void testeInvalidoEntradaDiaMaior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-10-100 10:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Dia com um digito a menos")
    void testeInvalidoEntradaDiaMenor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-10-1 10:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Horas fora do intervalo")
    void testeInvalidoEntradaHoraLimiteSuperior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-10-10 24:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Horas com um digito a mais")
    void testeInvalidoEntradaHoraMaior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-10-10 100:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Horas com um digito a menos")
    void testeInvalidoEntradaHoraMenor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-10-10 9:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Minutos fora do intervalo")
    void testeInvalidoEntradaMinutoLimiteSuperior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-10-10 10:60", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Minutos com um digito a mais")
    void testeInvalidoEntradaMinutoMaior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-10-10 10:100", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Minutos com um digito a menos")
    void testeInvalidoEntradaMinutoMenor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-10-10 09:9", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Ano de entrada maior que de saida")
    void testeInvalidoSaidaAntesEntradaAno() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Cliente c = new Cliente("2024-12-10 10:00", "2023-12-10 20:00", false);
            e.calculaValor(c);
        });

        String esperada = "A entrada deve ocorrer em um momento anterior a saida.";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Mes de entrada maior que de saida")
    void testeInvalidoSaidaAntesEntradaMes() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Cliente c = new Cliente("2024-12-10 10:00", "2024-11-10 20:00", false);
            e.calculaValor(c);
        });

        String esperada = "A entrada deve ocorrer em um momento anterior a saida.";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Dia de entrada maior que de saida")
    void testeInvalidoSaidaAntesEntradaDia() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Cliente c = new Cliente("2024-12-10 10:00", "2024-12-09 20:00", false);
            e.calculaValor(c);
        });

        String esperada = "A entrada deve ocorrer em um momento anterior a saida.";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Hora de entrada maior que de saida")
    void testeInvalidoSaidaAntesEntradaHoras() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Cliente c = new Cliente("2024-12-10 10:00", "2024-12-10 09:00", false);
            e.calculaValor(c);
        });

        String esperada = "A entrada deve ocorrer em um momento anterior a saida.";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Minuto de entrada maior que de saida")
    void testeInvalidoSaidaAntesEntradaMinutos() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Cliente c = new Cliente("2024-12-10 10:01", "2024-12-10 10:00", false);
            e.calculaValor(c);
        });

        String esperada = "A entrada deve ocorrer em um momento anterior a saida.";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Entrada e saida em momentos iguais")
    void testeInvalidoMomentosIguais() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Cliente c = new Cliente("2024-12-10 10:00", "2024-12-10 10:00", false);
            e.calculaValor(c);
        });

        String esperada = "A entrada deve ocorrer em um momento anterior a saida.";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Entrada On-point (<2)")
    void testeInvalidoEntradaLimiteInferior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Cliente c = new Cliente("2024-12-10 02:00", "2024-12-10 10:00", false);
            e.calculaValor(c);
        });

        String esperada = "Nem a entrada nem a saida podem ocorrer entre 02:00 e 08:00.";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Entrada Off-point (>=8)")
    void testeInvalidoEntradaLimiteSuperior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Cliente c = new Cliente("2024-12-10 07:59", "2024-12-10 10:00", false);
            e.calculaValor(c);
        });

        String esperada = "Nem a entrada nem a saida podem ocorrer entre 02:00 e 08:00.";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Entrada dentro do intervalo (2<=x<8)")
    void testeInvalidoEntradaEntre() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Cliente c = new Cliente("2024-12-10 05:00", "2024-12-10 10:00", false);
            e.calculaValor(c);
        });

        String esperada = "Nem a entrada nem a saida podem ocorrer entre 02:00 e 08:00.";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Saida On-point (<2)")
    void testeInvalidoSaidaLimiteInferior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Cliente c = new Cliente("2024-12-10 10:00", "2024-12-11 02:00", false);
            e.calculaValor(c);
        });

        String esperada = "Nem a entrada nem a saida podem ocorrer entre 02:00 e 08:00.";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Saida Off-point (>=8)")
    void testeInvalidoSaidaLimiteSuperior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Cliente c = new Cliente("2024-12-10 10:00", "2024-12-11 07:59", false);
            e.calculaValor(c);
        });

        String esperada = "Nem a entrada nem a saida podem ocorrer entre 02:00 e 08:00.";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Saida dentro do intervalo (2<=x<8)")
    void testeInvalidoSaidaEntre() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Cliente c = new Cliente("2024-12-10 10:00", "2024-12-11 05:00", false);
            e.calculaValor(c);
        });

        String esperada = "Nem a entrada nem a saida podem ocorrer entre 02:00 e 08:00.";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    @DisplayName("Entrada On-point (>=8)")
    void testeEntrada() {
        Cliente c = new Cliente("2024-10-12 08:00", "2024-10-12 08:30", false);

        double esperado = 5.9;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Entrada On-point (>=8) VIP")
    void testeEntradaVip() {
        Cliente c = new Cliente("2024-10-12 08:00", "2024-10-12 08:30", true);

        double esperado = 2.95;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Entrada Off-point e Saida no mesmo dia (<2)")
    void testeEntradaSaidaMesmoDia() {
        Cliente c = new Cliente("2024-10-12 01:59", "2024-10-12 13:59", false);

        double esperado = 50;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Entrada Off-point e Saida no mesmo dia (<2) VIP")
    void testeEntradaSaidaMesmoDiaVip() {
        Cliente c = new Cliente("2024-10-12 01:59", "2024-10-12 13:59", true);

        double esperado = 25;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Entrada Off-point e Saida em dias diferentes (<2)")
    void testeEntradaSaidaDiasDiferentes() {
        Cliente c = new Cliente("2024-10-12 01:59", "2024-10-13 00:59", false);

        double esperado = 50;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Entrada Off-point e Saida em dias diferentes (<2) VIP")
    void testeEntradaSaidaDiasDiferentesVip() {
        Cliente c = new Cliente("2024-10-12 01:59", "2024-10-13 00:59", true);

        double esperado = 25;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Saida após mais de um dia")
    void testeSaidaMaisDeUmDia() {
        Cliente c = new Cliente("2024-10-12 10:40", "2024-10-14 10:40", false);

        double esperado = 100;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Saida após mais de um dia VIP")
    void testeSaidaMaisDeUmDiaVip() {
        Cliente c = new Cliente("2024-10-12 10:40", "2024-10-14 10:40", true);

        double esperado = 50;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Saida Off-Point (<2)")
    void testeSaida() {
        Cliente c = new Cliente("2024-10-12 11:35", "2024-10-13 01:59", false);

        double esperado = 40.9;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Saida Off-Point (<2) VIP")
    void testeSaidaVip() {
        Cliente c = new Cliente("2024-10-12 11:35", "2024-10-13 01:59", true);

        double esperado = 20.45;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Saida On-point e em dias diferentes (>=8)")
    void testeSaidaDiasDiferentes() {
        Cliente c = new Cliente("2024-10-12 22:00", "2024-10-13 08:00", false);

        double esperado = 50;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Saida On-point e em dias diferentes (>=8) VIP")
    void testeSaidaDiasDiferentesVip() {
        Cliente c = new Cliente("2024-10-12 22:00", "2024-10-13 08:00", true);

        double esperado = 25;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Tempo no Estacionamento On-Point de tarifa livre (>=8)")
    void testeTempoLivreDia() {
        Cliente c = new Cliente("2024-10-12 13:15", "2024-10-12 13:30", false);

        double esperado = 0;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Tempo no Estacionamento On-Point de tarifa livre (>=8) VIP")
    void testeTempoLivreDiaVip() {
        Cliente c = new Cliente("2024-10-12 13:15", "2024-10-12 13:30", true);

        double esperado = 0;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Tempo no Estacionamento On-Point de tarifa livre (<2)")
    void testeTempoLivreMadrugada() {
        Cliente c = new Cliente("2024-10-12 00:15", "2024-10-12 00:30", false);

        double esperado = 0;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Tempo no Estacionamento On-Point de tarifa livre (<2) VIP")
    void testeTempoLivreMadrugadaVip() {
        Cliente c = new Cliente("2024-10-12 00:15", "2024-10-12 00:30", true);

        double esperado = 0;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Tempo no Estacionamento On-Point até 1 hora e maior que 1 hora (>=8)")
    void testeTempo1HoraDia() {
        Cliente c = new Cliente("2024-10-12 14:50", "2024-10-12 15:50", false);

        double esperado = 5.9;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Tempo no Estacionamento On-Point até 1 hora e maior que 1 hora (>=8) VIP")
    void testeTempo1HoraDiaVip() {
        Cliente c = new Cliente("2024-10-12 14:50", "2024-10-12 15:50", true);

        double esperado = 2.95;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Tempo no Estacionamento On-Point até 1 hora e maior que 1 hora (<2)")
    void testeTempo1HoraMadrugada() {
        Cliente c = new Cliente("2024-10-12 00:50", "2024-10-12 01:50", false);

        double esperado = 5.9;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Tempo no Estacionamento On-Point até 1 hora e maior que 1 hora (<2) VIP")
    void testeTempo1HoraMadrugadaVip() {
        Cliente c = new Cliente("2024-10-12 00:50", "2024-10-12 01:50", true);

        double esperado = 2.95;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Tempo no Estacionamento Off-Point de tarifa livre (>=8)")
    void testeTempoForaTarifaLivreDia() {
        Cliente c = new Cliente("2024-10-12 10:16", "2024-10-12 10:32", false);

        double esperado = 5.9;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Tempo no Estacionamento Off-Point de tarifa livre (>=8) VIP")
    void testeTempoForaTarifaLivreDiaVip() {
        Cliente c = new Cliente("2024-10-12 10:16", "2024-10-12 10:32", true);

        double esperado = 2.95;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Tempo no Estacionamento Off-Point de tarifa livre (<2)")
    void testeTempoForaTarifaLivreMadrugada() {
        Cliente c = new Cliente("2024-10-12 00:16", "2024-10-12 00:32", false);

        double esperado = 5.9;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Tempo no Estacionamento Off-Point de tarifa livre (<2) VIP")
    void testeTempoForaTarifaLivreMadrugadaVip() {
        Cliente c = new Cliente("2024-10-12 00:16", "2024-10-12 00:32", true);

        double esperado = 2.95;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Tempo no Estacionamento Off-Point até 1 hora e maior que 1 hora (>=8)")
    void testeTempo1HoraMaisDia() {
        Cliente c = new Cliente("2024-10-12 17:00", "2024-10-12 18:01", false);

        double esperado = 8.4;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Tempo no Estacionamento Off-Point até 1 hora e maior que 1 hora (>=8) VIP")
    void testeTempo1HoraMaisDiaVip() {
        Cliente c = new Cliente("2024-10-12 17:00", "2024-10-12 18:01", true);

        double esperado = 4.2;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Tempo no Estacionamento Off-Point até 1 hora e maior que 1 hora (<2)")
    void testeTempo1HoraMaisMadrugada() {
        Cliente c = new Cliente("2024-10-12 00:00", "2024-10-12 01:01", false);

        double esperado = 8.4;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Tempo no Estacionamento Off-Point até 1 hora e maior que 1 hora (<2) VIP")
    void testeTempo1HoraMaisMadrugadaVip() {
        Cliente c = new Cliente("2024-10-12 00:00", "2024-10-12 01:01", true);

        double esperado = 4.2;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Caso limite (menor tempo possível) ")
    void testeMenorTempo() {
        Cliente c = new Cliente("2024-10-12 17:00", "2024-10-12 17:01", false);

        double esperado = 0;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Caso limite (menor tempo possível)  VIP")
    void testeMenorTempoVip() {
        Cliente c = new Cliente("2024-10-12 17:00", "2024-10-12 17:01", true);

        double esperado = 0;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Caso limite (maior valor de tarifa sem pernoitar)")
    void testeMaiorTarifaSemPernoite() {
        Cliente c = new Cliente("2024-10-12 08:00", "2024-10-13 01:59", false);

        double esperado = 48.4;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Caso limite (maior valor de tarifa sem pernoitar) VIP")
    void testeMaiorTarifaSemPernoiteVip() {
        Cliente c = new Cliente("2024-10-12 08:00", "2024-10-13 01:59", true);

        double esperado = 24.2;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Caso limite (maior valor de tarifa)")
    void testeMaiorTarifa() {
        Cliente c = new Cliente("0001-01-01 08:00", "9999-12-31 01:59", false);

        double esperado = 182602900;
        double resultado = e.calculaValor(c);

        assertEquals(esperado, resultado);
    }
}
