package ppss;

public class TestableReserva extends Reserva{
    @Override
    public boolean compruebaPermisos(String login, String password, Usuario tipoUsu) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
