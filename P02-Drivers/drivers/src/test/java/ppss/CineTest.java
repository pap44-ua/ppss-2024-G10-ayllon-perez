package ppss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
//import org.junit.jupiter.params.provider.MethodSource;

//import org.junit.jupiter.params.provider.ValueSource;


import ppss.Cine;
import ppss.ButacasException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CineTest {
    Cine cine;
    ButacasException butExcp;

    @BeforeEach
    public void setup() {
        cine = new Cine();
        butExcp = new ButacasException();
    }

    @Test
    void C1_reservaButacas_should_return_Exception_when_fila_empty_and_want_3() {
        boolean[] asientos = {};
        int solicitados = 3;

        ButacasException excepcion = assertThrows(ButacasException.class, () ->
            cine.reservaButacas(asientos, solicitados)
        );

        assertEquals("No se puede procesar la solicitud", excepcion.getMessage());
    }

    @Test
    void C2_reservaButacas_should_return_false_when_fila_empty_and_want_zero() {
        boolean[] asientos = {};
        boolean[] arrayEsperado = {};
        int solicitados = 0;
        boolean resultado;

        resultado = assertDoesNotThrow(() -> cine.reservaButacas(asientos, solicitados));

        assertAll(
                () -> assertArrayEquals(arrayEsperado, asientos),
                () -> assertFalse(resultado)

        );
    }

    @Test
    void C3_reservaButacas_should_return_true_when_fila_has_3_seats_free_and_want_2()
    {
       boolean[]  asientos = {false,false,false,true,true};
       int solicitados = 2;
       boolean resultado;

       boolean[] arrayEsperado = {true,true,false,true,true};

        resultado = assertDoesNotThrow(() -> cine.reservaButacas(asientos, solicitados));

        assertAll(
               () -> assertArrayEquals(asientos,arrayEsperado),
               () -> assertTrue(resultado)
       );

    }
    @Test
    void C4_reservaButacas_should_return_false_when_no_free_seats_and_want_1()
    {
        boolean[] asientos = {true,true,true};
        boolean[] arrayEsperado = {true,true,true};
        int solicitados = 1;
        boolean resultado;

        resultado = assertDoesNotThrow(() -> cine.reservaButacas(asientos, solicitados));

        assertAll(
                () -> assertArrayEquals(arrayEsperado, asientos),
                () -> assertFalse(resultado)

        );
    }
    @Tag("parametrizados")
    @ParameterizedTest(name = "[{index}] should be {0} when we want {1} and {2}")
    @DisplayName("reservaButacas_")
    @MethodSource("casosDePrueba")
    void C5_reservaButacas(boolean expected, int solicitados, String cadena, boolean[] arrayDado, boolean[] arrayEsperado) {

        boolean resultado = assertDoesNotThrow(() -> cine.reservaButacas(arrayDado, solicitados));
        assertAll(
                () -> assertArrayEquals(arrayEsperado, arrayDado),
                () -> assertEquals(expected,resultado)

        );

    }

    private static Stream<Arguments> casosDePrueba()
    {
        return Stream.of(
                Arguments.of(false, 0 , "fila has no seats",new boolean[]{}, new boolean[]{}),
                Arguments.of(true, 2 , "there are 2 free seats", new boolean[]{false, false, false, true, true},new boolean[]{true, true, false, true, true}),
                Arguments.of(false, 1 , "all seats are already reserved", new boolean[]{true,true,true}, new boolean[]{true,true,true})
        );
    }
}
