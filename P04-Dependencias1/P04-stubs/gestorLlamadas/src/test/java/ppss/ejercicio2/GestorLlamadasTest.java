package ppss.ejercicio2;

import org.junit.jupiter.api.Test;
import ppss.ejercicio1.GestorLlamadas;

import static org.junit.jupiter.api.Assertions.*;

class GestorLlamadasTest {

    @Test
    public void C1_calculaConsumo_should_208_when_10_min_15_horas() {
        double consumo = ppss.ejercicio1.GestorLlamadas.calculaConsumo(10,15);

        assertEquals(208,consumo);

    }
    @Test
    public void C2_calculaConsumo_should_105_when_10_min_22_horas() {
        double consumo = GestorLlamadas.calculaConsumo(10,22);

        assertEquals(105,consumo);

    }
}