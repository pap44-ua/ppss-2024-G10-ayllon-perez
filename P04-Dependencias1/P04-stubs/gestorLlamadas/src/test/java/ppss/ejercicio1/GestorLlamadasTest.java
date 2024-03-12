package ppss.ejercicio1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GestorLlamadasTest {
    GestorLlamadasTesteable gestorLlamadas;
    @BeforeEach
    public void setp()
    {
        gestorLlamadas = new GestorLlamadasTesteable();
    }
    @Test
    public void C1_calculaConsumo_should_208_when_10_min_15_horas() {
        gestorLlamadas.setHoraActual(15);
        double consumo = gestorLlamadas.calculaConsumo(10);

        assertEquals(208,consumo);

    }
    @Test
    public void C2_calculaConsumo_should_105_when_10_min_22_horas() {
        gestorLlamadas.setHoraActual(22);
        double consumo = gestorLlamadas.calculaConsumo(10);

        assertEquals(105,consumo);

    }
}