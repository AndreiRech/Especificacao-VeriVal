import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.vev.Cliente;
import com.vev.Estacionamento;

public class TesteEstacionamento {
    private Estacionamento e = null;

    @BeforeEach
    void setUp() {
        e = new Estacionamento();
    }

    // TESTES INVÁLIDOS COM ARGUMENTOS FALTANTES / INVALIDOS

    @Test
    void testeInvalidoArgumentosNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente(null, null, false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    void testeInvalidoFaltaAno() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("10-10 10:00", "2024-10-10 22:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    void testeInvalidoFaltaMesOuDia() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2024-10 10:00", "2024-10-10 22:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    void testeInvalidoFaltaHoras() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2024-10-10", "2024-10-10 22:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    void testeInvalidoFaltaMinutos() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2024-10-10 10", "2024-10-10 22:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    // TESTES INVÁLIDOS PARA ANOS

    @Test
    void testeInvalidoEntradaAnoLimiteInferior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("0000-10-10 10:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    void testeInvalidoEntradaAnoMenor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("999-10-10 10:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    void testeInvalidoEntradaAnoMaior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("10000-10-10 10:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    // TESTES INVÁLIDOS PARA MESES

    @Test
    void testeInvalidoEntradaMesLimiteSuperior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-13-10 10:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    void testeInvalidoEntradaMesLimiteInferior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-00-10 10:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    void testeInvalidoEntradaMesMaior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-100-10 10:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    void testeInvalidoEntradaMesMenor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-1-10 10:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    // TESTES INVALIDOS PARA DIAS

    @Test
    void testeInvalidoEntradaDiaLimiteSuperior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-10-32 10:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    void testeInvalidoEntradaDiaLimiteInferior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-10-00 10:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    void testeInvalidoEntradaDiaMaior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-10-100 10:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    void testeInvalidoEntradaDiaMenor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-10-1 10:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    // TESTES INVALIDOS PARA HORAS

    @Test
    void testeInvalidoEntradaHoraLimiteSuperior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-10-10 24:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    void testeInvalidoEntradaHoraMaior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-10-10 100:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    void testeInvalidoEntradaHoraMenor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-10-1 9:00", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    // TESTES INVALIDOS PARA HORAS

    @Test
    void testeInvalidoEntradaMinutoLimiteSuperior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-10-10 10:60", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    void testeInvalidoEntradaMinutoMaior() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-10-10 10:100", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    @Test
    void testeInvalidoEntradaMinutoMenor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2020-10-10 09:9", "2024-10-10 10:00", false);
        });

        String esperada = "Data em formato invalido. Use o formato: yyyy-MM-dd HH:mm";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    // TESTES INVALIDOS PARA SAIDA ACONTECER ANTES DA ENTRADA

    @Test
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
    void testeInvalidoSaidaAntesEntradaMinutos() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Cliente c = new Cliente("2024-12-10 10:01", "2024-12-10 10:00", false);
            e.calculaValor(c);
        });

        String esperada = "A entrada deve ocorrer em um momento anterior a saida.";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }

    // TESTES INVALIDOS PARA SAIDA / ENTRADA ACONTECER EM HORÁRIO INVÁLIDO

    @Test
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
    void testeInvalidoSaidaEntre() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Cliente c = new Cliente("2024-12-10 10:00", "2024-12-11 05:00", false);
            e.calculaValor(c);
        });

        String esperada = "Nem a entrada nem a saida podem ocorrer entre 02:00 e 08:00.";
        String resultado = exception.getMessage();
        
        assertTrue(resultado.contains(esperada));
    }
}
