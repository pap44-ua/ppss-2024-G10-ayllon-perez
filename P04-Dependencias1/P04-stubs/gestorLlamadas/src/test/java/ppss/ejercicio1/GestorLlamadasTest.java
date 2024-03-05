package ppss.ejercicio1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

public class GestorLlamadasTest {

    @Test
    public void C1_calculaConsumo_should_208_when_10_min_15_horas() {
        double consumo = GestorLlamadas.calculaConsumo(10,15);

        assertEquals(208,consumo);

    }
    @Test
    public void C2_calculaConsumo_should_105_when_10_min_22_horas() {
        double consumo = GestorLlamadas.calculaConsumo(10,22);

        assertEquals(105,consumo);

    }
}