package ppss.ejercicio2;

public class StubCalendario extends Calendario{
    private int horaActual;

    public void setHoraActual(int hora)
    {
        this.horaActual=hora;
    }
    @Override
    public int getHoraActual() {
        return horaActual;
    }
}
