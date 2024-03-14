package ppss;

import ppss.excepciones.JDBCException;

import java.util.ArrayList;
import java.util.Arrays;

public class StubOperacion implements IOperacionBO{

    //Defino lo valido o invalido
    boolean accesobd = true;
    ArrayList<String> isbnsValidos = new ArrayList<>(Arrays.asList(
       "11111",
       "22222"
    ));

    String isbnValido1 = "11111";
    String isbnValido2 = "22222";

    String socio = "Luis";

    void setAccesobd(boolean acceso)
    {
        this.accesobd = acceso;
    }
    @Override
    public void operacionReserva(String socio, String isbn) throws IsbnInvalidoException, JDBCException, SocioInvalidoException {
        if (!accesobd)
        {
            throw new JDBCException();
        } else if (isbn != isbnValido1 && isbn!=isbnValido2) {
            throw new IsbnInvalidoException();
        } else if (socio != this.socio) {
            throw new SocioInvalidoException();
        }
    }
}
