package ppss.ejercicio2;

import ppss.ejercicio2.Calendario;

public class GestorLlamadasTesteable extends GestorLlamadas {
    private int hora;
    public void setHora(int hora)
    {
        this.hora=hora;
    }
    @Override
    public StubCalendario getCalendario() {
        StubCalendario calendario = new StubCalendario();
        calendario.setHoraActual(hora);
        return calendario;
    }

}
