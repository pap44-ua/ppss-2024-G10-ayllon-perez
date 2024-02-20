package ppss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FicheroTextoTest {
    FicheroTexto fichero;
    FicheroException fichExcp;

    @BeforeEach
    public void setup() {
        fichero = new FicheroTexto();
        fichExcp = new FicheroException();
    }

    @Test
    void C1_contarCaracteres_should_return_Exception_when_file_does_not_exist() {
        String archivo = "ficheroC1.txt";

        FicheroException excepcion = assertThrows(FicheroException.class, () ->
                fichero.contarCaracteres(archivo)
        );
    }

    @Test
    void C2_contarCaracteres_should_return_3_when_file_has_3_chars()
    {
        String archivo = "src/test/resources/ficheroCorrecto.txt";
        int contadorEsperado = 3;

        int contadora = 0;
        try {
            contadora = fichero.contarCaracteres(archivo);
        } catch (FicheroException e) {
            throw new RuntimeException(e);
        }

        assertEquals(contadorEsperado, contadora);
    }
}