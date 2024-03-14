package ppss;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class CalendarioStub extends Calendario{

    ArrayList<LocalDate> fechasFestivos = new ArrayList<>(Arrays.asList(
            LocalDate.of(2024, 6, 20),
            LocalDate.of(2024, 6, 24)
    ));
    ArrayList<LocalDate> fechasInvalidas = new ArrayList<>(Arrays.asList(
            LocalDate.of(2024, 4, 18),
            LocalDate.of(2024, 4, 21),
            LocalDate.of(2024, 4, 22)
    ));

    @Override
    public boolean es_festivo(LocalDate otroDia) throws CalendarioException{
        if (fechasInvalidas.contains(otroDia))
        {
            throw new CalendarioException();
        } else if (fechasFestivos.contains(otroDia))
        {
            return true;
        }
        else {
            return false;
        }
    }
}
