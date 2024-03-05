package ppss;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AlquilaCochesTest {

    @Test
    void C1_calculaPrecio_should_75_when_no_es_festivo() {
        TipoCoche tipo = TipoCoche.TURISMO;
        LocalDate inicio = LocalDate.of(2024,5,18);
        int dias = 10;
        //Ns como hacer la tabla de pruebas de es_festivo()

    }
}