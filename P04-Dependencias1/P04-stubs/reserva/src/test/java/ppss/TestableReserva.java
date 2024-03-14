package ppss;

import java.util.Objects;

public class TestableReserva extends Reserva{
    @Override
    public boolean compruebaPermisos(String login, String password, Usuario tipoUsu) {
        return Objects.equals(login, "ppss") && Objects.equals(password, "ppss");
    }
}
