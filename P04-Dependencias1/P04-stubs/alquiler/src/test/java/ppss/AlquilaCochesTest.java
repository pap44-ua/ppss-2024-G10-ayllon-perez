package ppss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AlquilaCochesTest {
    TestableAlquilaCoche alquilaCoches;
    CalendarioStub calendarioStub;
    ServicioStub servicioStub;

    @BeforeEach
    void setUp()
    {
        alquilaCoches = new TestableAlquilaCoche();
        calendarioStub = new CalendarioStub();

    }
    @Test
    void C1_calculaPrecio_should_75_when_no_es_festivo() {
        TipoCoche tipo = TipoCoche.TURISMO;
        LocalDate inicio = LocalDate.of(2024,5,18);
        int dias = 10;
        Ticket esperado = new Ticket();
        esperado.setPrecio_final(75);

        alquilaCoches.calendario = new CalendarioStub();

        Ticket salida = assertDoesNotThrow(() ->alquilaCoches.calculaPrecio(tipo,inicio,dias));


        assertEquals(esperado.getPrecio_final(),salida.getPrecio_final());

    }

    @Test
    void C2_calculaPrecio_should_62_5_when_es_festivo() {
        TipoCoche tipo = TipoCoche.TURISMO;
        LocalDate inicio = LocalDate.of(2024,6,19);
        int dias = 7;
        Ticket esperado = new Ticket();
        esperado.setPrecio_final(62.5F);

        alquilaCoches.calendario = new CalendarioStub();

        Ticket salida = assertDoesNotThrow(() ->alquilaCoches.calculaPrecio(tipo,inicio,dias));


        assertEquals(esperado.getPrecio_final(),salida.getPrecio_final());

    }

    @Test
    void C3_calculaPrecio_should_3_excepcion_when_es_dias_invalidos() {
        TipoCoche tipo = TipoCoche.TURISMO;
        LocalDate inicio = LocalDate.of(2024,4,17);
        int dias = 8;
        Ticket esperado = new Ticket();
        esperado.setPrecio_final(75);

        alquilaCoches.calendario = new CalendarioStub();

        MensajeException salida = assertThrows(MensajeException.class,() ->alquilaCoches.calculaPrecio(tipo,inicio,dias));

        assertEquals(salida.getMessage(),"Error en dia: 2024-04-18; Error en dia: 2024-04-21; Error en dia: 2024-04-22; ");




    }
}