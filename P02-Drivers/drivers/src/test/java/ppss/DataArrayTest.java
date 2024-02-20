package ppss;

import jdk.jfr.MemoryAddress;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.api.DisplayName;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import static org.junit.jupiter.api.Assertions.*;

class DataArrayTest {

    DataArray dataArray;
    DataException dataException;

    @Test
    void  C1_delete_should_borrar_when_esta_solo_un_elemento () {
        int[] cadNum = {1,3,5,7};
        dataArray = new DataArray(cadNum);
        int elementoBorrar = 5;
        int[] cadEsperada = {1,3,7};
        int longEsperada = 3;

        assertDoesNotThrow(() ->dataArray.delete(elementoBorrar));
        int[] arrayResultado = dataArray.getColeccion();
        int longResultado = dataArray.size();
                assertAll(
                () -> assertArrayEquals(cadEsperada,arrayResultado),
                () -> assertEquals(longEsperada,longResultado)
        );

    }

    @Test
    void C2_delete_should_borrar_primero_when_esta_dos_veces_elemento()
    {
        int[] cadNum = {1,3,3,5,7};
        dataArray = new DataArray(cadNum);
        int elementoBorrar = 3;
        int[] cadEsperada = {1,3,5,7};
        int longEsperada = 4;

        assertDoesNotThrow(() ->dataArray.delete(elementoBorrar));
        int[] arrayResultado = dataArray.getColeccion();
        int longResultado = dataArray.size();
        assertAll(
                () -> assertArrayEquals(cadEsperada,arrayResultado),
                () -> assertEquals(longEsperada,longResultado)
        );
    }
    @Test
    void  C3_delete_should_borrar_when_esta_solo_un_elemento () {
        int[] cadNum = {1,2,3,4,5,6,7,8,9,10};
        dataArray = new DataArray(cadNum);
        int elementoBorrar = 4;
        int[] cadEsperada = {1,2,3,5,6,7,8,9,10};
        int longEsperada = 9;

        assertDoesNotThrow(() ->dataArray.delete(elementoBorrar));
        int[] arrayResultado = dataArray.getColeccion();
        int longResultado = dataArray.size();
        assertAll(
                () -> assertArrayEquals(cadEsperada,arrayResultado),
                () -> assertEquals(longEsperada,longResultado)
        );

    }

    @Test
    void C4_delete_should_DataException_when_coleccion_vacia()
    {
        int[] cadNum = {};
        dataArray = new DataArray(cadNum);
        int elementoBorrar = 8;
        int longEsperada = 0;


        DataException excepcion = assertThrows(DataException.class, () ->
                dataArray.delete(elementoBorrar)
        );

        int[] arrayResultado = dataArray.getColeccion();
        int longResultado = dataArray.size();
        assertAll(
                () -> assertEquals("No hay elementos en la colección",excepcion.getMessage()),
                () -> assertEquals(longEsperada,longResultado)
        );
    }

    @Test
    void C4_delete_should_DataException_when_elemento_negativo()
    {
        int[] cadNum = {1,3,5,7};
        dataArray = new DataArray(cadNum);
        int elementoBorrar = -5;
        int longEsperada = 4;


        DataException excepcion = assertThrows(DataException.class, () ->
                dataArray.delete(elementoBorrar)
        );

        assertEquals("El valor a borrar debe ser > 0",excepcion.getMessage());

    }

    @Test
    void C5_delete_should_DataException_when_elemento_negativo_y_coleccion_vacia()
    {
        int[] cadNum = {};
        dataArray = new DataArray(cadNum);
        int elementoBorrar = 0;


        DataException excepcion = assertThrows(DataException.class, () ->
                dataArray.delete(elementoBorrar)
        );


        assertEquals("Colección vacía. Y el valor a borrar debe ser > 0",excepcion.getMessage());
    }

    @Test
    void C6_delete_should_DataException_when_elemento_no_esta()
    {
        int[] cadNum = {1,3,5,7};
        dataArray = new DataArray(cadNum);
        int elementoBorrar = 4;
        int longEsperada = 0;


        DataException excepcion = assertThrows(DataException.class, () ->
                dataArray.delete(elementoBorrar)
        );
        assertEquals("Elemento no encontrado",excepcion.getMessage());

    }
    @Tag("parametrizados")
    @Tag("excepciones")
    @ParameterizedTest(name = "[{index}] Mesage exception should be {0}  when we want delete {1}")
    @DisplayName("delete_With_Exceptions_")
    @MethodSource("casosDePrueba")
    void C8_deleteWithException(String salidaEsperada, int item, int[] lista)
    {
        dataArray= new DataArray(lista);
        DataException excepcion = assertThrows(DataException.class, () ->
                dataArray.delete(item)
        );
        assertEquals(salidaEsperada,excepcion.getMessage());
    }

    private static Stream<Arguments> casosDePrueba()
    {
        return Stream.of(
                Arguments.of("No hay elementos en la colección", 8,new int[]{} ),
                Arguments.of("El valor a borrar debe ser > 0", -5, new int[] {1,3,5,7}),
                Arguments.of("Colección vacía. Y el valor a borrar debe ser > 0", 0,new int[]{} ),
                Arguments.of("Elemento no encontrado", 8, new int[]{1,3,5,7})
        );
    }
    @Tag("parametrizados")
    @ParameterizedTest(name = "[{index}] Mesage exception should be {0}  when we want delete {1}")
    @DisplayName("delete_With_Exceptions_")
    @MethodSource("casosDePrueba_without_excepctions")
    void C8_delete_Without_Exception(int[] salidaEsperada, int item, int[] lista)
    {
        dataArray=new DataArray(lista);
        assertDoesNotThrow(() ->dataArray.delete(item));

        int[] arrayResultado = dataArray.getColeccion();
        int longResultado = dataArray.size();
        assertArrayEquals(salidaEsperada,arrayResultado);
    }

    private static Stream<Arguments> casosDePrueba_without_excepctions()
    {
        return Stream.of(
                Arguments.of(new int[]{1,3,7}, 5,new int[]{1,3,5,7} ),
                Arguments.of(new int[]{1,3,5,7}, 3, new int[] {1,3,3,5,7}),
                Arguments.of(new int[]{1,2,3,5,6,7,8,9,10}, 4,new int[]{1,2,3,4,5,6,7,8,9,10} )
        );
    }

}