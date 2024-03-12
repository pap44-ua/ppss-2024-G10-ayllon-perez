package ppss.ejercicio2;

import org.junit.jupiter.api.*;
import ppss.ejercicio2.GestorLlamadasTesteable;

import static org.junit.jupiter.api.Assertions.*;


public class GestorLlamadasTest {
    GestorLlamadasTesteable gestorLlamadas;
    StubCalendario stubCalendario;
    @BeforeEach
    public void setp()
    {
        gestorLlamadas = new GestorLlamadasTesteable();
        stubCalendario = gestorLlamadas.getCalendario();
    }
    @Test
    public void C1_calculaConsumo_should_208_when_10_min_15_horas() {
        //gestorLlamadas.setHoraActual(15);
        gestorLlamadas.setHora(15);
        double consumo = gestorLlamadas.calculaConsumo(10);
        assertEquals(208,consumo);

    }
    @Test
    public void C2_calculaConsumo_should_105_when_10_min_22_horas() {
        //gestorLlamadas.setHoraActual(22);
        gestorLlamadas.setHora(22);
        double consumo = gestorLlamadas.calculaConsumo(10);

        assertEquals(105,consumo);

    }
}