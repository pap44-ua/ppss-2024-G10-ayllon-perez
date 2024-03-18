package ppss;

import org.easymock.EasyMock;
import org.junit.*;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

public class GestorLlamadasTest {


    @Test
    public void C1_calcula_consumo_should_457_con_6_when_22m_10h()
    {
        int horas = 10;
        int minutos = 22;
        double resultadoEsperado = 457.6;

        GestorLlamadas partialMock = partialMockBuilder(GestorLlamadas.class).addMockedMethod("getCalendario").mock();
        Calendario mock = EasyMock.mock(Calendario.class);

        expect(mock.getHoraActual()).andReturn(horas);
        replay(mock);
        expect(partialMock.getCalendario()).andReturn(mock);
        replay(partialMock);

        double resultado = partialMock.calculaConsumo(minutos);

        assertEquals(resultadoEsperado,resultado);
        verify(mock);
        verify(partialMock);


    }

    @Test
    public void C2_calcula_consumo_should_136_con_5_when_13m_21h()
    {
        int horas = 21;
        int minutos = 13;
        double resultadoEsperado = 136.5;

        GestorLlamadas partialMock = partialMockBuilder(GestorLlamadas.class).addMockedMethod("getCalendario").mock();
        Calendario mock = EasyMock.mock(Calendario.class);

        expect(mock.getHoraActual()).andReturn(horas);
        replay(mock);
        expect(partialMock.getCalendario()).andReturn(mock);
        replay(partialMock);

        double resultado = partialMock.calculaConsumo(minutos);

        assertEquals(resultadoEsperado,resultado);
        verify(mock);
        verify(partialMock);


    }

}
