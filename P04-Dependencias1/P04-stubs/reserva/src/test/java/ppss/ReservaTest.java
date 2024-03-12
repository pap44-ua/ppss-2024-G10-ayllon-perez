package ppss;

import org.junit.jupiter.api.*;
import ppss.excepciones.*;

import static org.junit.jupiter.api.Assertions.*;

class ReservaTest { //Tengo que implementar STUB aun
    Reserva reserva;
    @Test
    void C1_realizaReserva_should_reservaException1_when_admin_incorrecto() {
        reserva = new Reserva();
        String login="xxxx";
        String password = "xxxx";
        String socio = "Luis";
        String[] isbns= {"11111"};

        ReservaException exception = assertThrows(ReservaException.class, () ->
                reserva.realizaReserva(login,password,socio,isbns)
                );
        assertEquals("ERROR de permisos", exception.getMessage());

    }

    @Test
    void C2_realizaReserva_should_ok_when_admin_incorrecto() {
        reserva = new Reserva();
        String login="ppss";
        String password = "ppss";
        String socio = "Luis";
        String[] isbns= {"11111","22222"};

        ReservaException exception = assertThrows(ReservaException.class, () ->
                reserva.realizaReserva(login,password,socio,isbns)
        );
        assertEquals("ERROR de permisos", exception.getMessage());

    }

    @Test
    void C3_realizaReserva_should_ReservaaException_when_isns_invalidos() {
        reserva = new Reserva();
        String login="ppss";
        String password = "ppss";
        String socio = "Luis";
        String[] isbns= {"11111","33333","44444"};

        ReservaException exception = assertThrows(ReservaException.class, () ->
                reserva.realizaReserva(login,password,socio,isbns)
        );
        assertEquals("ERROR de permisos", exception.getMessage());

    }
}