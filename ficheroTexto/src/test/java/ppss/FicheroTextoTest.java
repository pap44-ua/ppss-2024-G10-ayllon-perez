package ppss;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;

import java.io.FileReader;
import java.io.IOException;

import static org.easymock.EasyMock.expect;
import static org.junit.jupiter.api.Assertions.*;

class FicheroTextoTest {

    @org.junit.jupiter.api.Test
    void C1_contarCaracteres() {
        String nombreFichero = "/src/test/resources/ficheroC1.txt";
        IMocksControl ctrl = EasyMock.createStrictControl();

        FicheroTexto ficheroPartialMock = EasyMock.partialMockBuilder(FicheroTexto.class).addMockedMethod("createFile", String.class).mock(ctrl);
        FileReader fileReaderMock = EasyMock.createMock(FileReader.class);

        assertDoesNotThrow(() -> {
            expect(ficheroPartialMock.createFile(nombreFichero)).andReturn(fileReaderMock);
            expect(fileReaderMock.read()).andReturn((int) 'a').andReturn((int) 'b').andThrow(new IOException());
        });
        ctrl.replay();
        FicheroException error = assertThrows(FicheroException.class, () -> ficheroPartialMock.contarCaracteres(nombreFichero));

        assertEquals("src/test/resources/ficheroC1.txt (Error al leer el archivo)",error.getMessage());
        ctrl.verify();
    }

    @org.junit.jupiter.api.Test
    void C2_contarCaracteres() {
        String nombreFichero = "/src/test/resources/ficheroC2.txt";
        IMocksControl ctrl = EasyMock.createStrictControl();

        FicheroTexto ficheroPartialMock = EasyMock.partialMockBuilder(FicheroTexto.class).addMockedMethod("createFile").mock(ctrl);
        FileReader fileReaderMock = EasyMock.createMock(FileReader.class);

        assertDoesNotThrow(() -> {
            expect(ficheroPartialMock.createFile(nombreFichero)).andReturn(fileReaderMock);
            expect(fileReaderMock.read()).andReturn((int) 'a').andReturn((int) 'b').andReturn((int) 'c').andReturn(-1);
            fileReaderMock.close();
            EasyMock.expectLastCall().andReturn(new IOException());
        });

        ctrl.replay();

        IOException error = assertThrows(IOException.class, () -> {
            ficheroPartialMock.contarCaracteres(nombreFichero);
        });

        assertEquals("src/test/resources/ficheroC2.txt (Error al cerrar el archivo)", error.getMessage());

        ctrl.verify();
    }

}