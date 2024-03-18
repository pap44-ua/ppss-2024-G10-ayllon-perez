package ppss;

import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;
import org.easymock.IMocksControl;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

class PremioTest {

    @Test
    void C1_compruebaPremio_should_Premiado_entrada_champions_when_0_con_07_and_entrada_final_champions() {
        float numAleatorio = 0.07F;
        String premio = "entrada final Champions";
        String resultadoEsperado = "Premiado con entrada final Champions";
        IMocksControl ctrl = createStrictControl();


        Premio partialMock = partialMockBuilder(Premio.class).addMockedMethod("generaNumero").createMock(ctrl);
        ClienteWebService mock = ctrl.createMock(ClienteWebService.class);

        partialMock.cliente = mock;

        expect(partialMock.generaNumero()).andReturn(numAleatorio);
        assertDoesNotThrow(() -> EasyMock.expect(mock.obtenerPremio()).andReturn(premio));

        ctrl.replay();
        EasyMock.verify();

        String resultado = partialMock.compruebaPremio();
        assertEquals(resultadoEsperado,resultado);


    }

    @Test
    void C2_compruebaPremio_should_Premiado_entrada_champions_when_0_con_07_and_entrada_final_champions() {
        float numAleatorio = 0.03F;
        String premio = "entrada final Champions";
        String resultadoEsperado = "No se ha podido obtener el premio";
        IMocksControl ctrl = createStrictControl();


        Premio partialMock = partialMockBuilder(Premio.class).addMockedMethod("generaNumero").createMock(ctrl);
        ClienteWebService mock = ctrl.createMock(ClienteWebService.class);

        partialMock.cliente = mock;

        expect(partialMock.generaNumero()).andReturn(numAleatorio);
        assertDoesNotThrow(() -> expect(mock.obtenerPremio()).andThrow(new ClienteWebServiceException()));

        ctrl.replay();
        EasyMock.verify();

        String resultado = partialMock.compruebaPremio();
        assertEquals(resultadoEsperado,resultado);

    }

    @Test
    void C3_compruebaPremio_should_Premiado_entrada_champions_when_0_con_07_and_entrada_final_champions() {
        float numAleatorio = 0.3F;
        String premio = "entrada final Champions";
        String resultadoEsperado = "Sin premio";
        IMocksControl ctrl = createStrictControl();


        Premio partialMock = partialMockBuilder(Premio.class).addMockedMethod("generaNumero").createMock(ctrl);
        ClienteWebService mock = ctrl.createMock(ClienteWebService.class);

        partialMock.cliente = mock;

        expect(partialMock.generaNumero()).andReturn(numAleatorio);
        assertDoesNotThrow(() -> EasyMock.expect(mock.obtenerPremio()).andReturn(premio));

        ctrl.replay();
        EasyMock.verify();

        String resultado = partialMock.compruebaPremio();
        assertEquals(resultadoEsperado,resultado);

    }
}

