package ppss.matriculacion.dao;

import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ppss.matriculacion.to.AlumnoTO;

import java.time.LocalDate;

public class AlumnoDAOIT {
    IAlumnoDAO alumnoDAO;
    private IDatabaseTester databaseTester;
    private IDatabaseConnection connection;

    AlumnoTO alumnoTO;

    @BeforeEach
    public void setup() throws Exception
    {

        String cadena_conexionDB = "jdbc:mysql://localhost:3306/matriculacion?useSSL=false";
        databaseTester = new JdbcDatabaseTester("com.mysql.cj.jdbc.Driver",
                cadena_conexionDB, "root", "ppss");
        connection = databaseTester.getConnection();

        IDataSet dataset = new FlatXmlDataFileLoader().load("/tabla2.xml");
        databaseTester.setDataSet(dataset);

        databaseTester.onSetup();


        alumnoDAO = new FactoriaDAO().getAlumnoDAO();
        alumnoTO = new AlumnoTO();

    }

    @Test
    public void testA1_addAlumno_should_return_tabla3_when_adds() throws Exception
    {
        alumnoTO.setNif( "33333333C");
        alumnoTO.setNombre( "Elena Aguirre Juarez");
        alumnoTO.setFechaNacimiento(LocalDate.of( 1985,02,22));

        //SUT
        Assertions.assertDoesNotThrow(()->alumnoDAO.addAlumno(alumnoTO));

        //
        IDatabaseConnection conexion = databaseTester.getConnection();
        IDataSet dataSet = conexion.createDataSet();
        ITable table = dataSet.getTable("alumnos");

        //creamos el dataset con el resultado esperado
        IDataSet expectedDataSet = new FlatXmlDataFileLoader().load("/tabla3.xml");
        ITable expectedTable = expectedDataSet.getTable("alumnos");

        Assertion.assertEquals(expectedTable, table);
    }

    @Test
    public void testA2_addAlumno_should_return_tabla3_when_adds() throws Exception
    {
        alumnoTO.setNif( "11111111A");
        alumnoTO.setNombre( "Alfonso Ramirez Ruiz");
        alumnoTO.setFechaNacimiento(LocalDate.of( 1982,02,22));

        //SUT
        DAOException error = Assertions.assertThrows(DAOException.class, () -> alumnoDAO.addAlumno(alumnoTO));

        Assertions.assertEquals("Error al conectar con BD", error.getMessage());

        /*
        IDatabaseConnection conexion = databaseTester.getConnection();
        IDataSet dataSet = conexion.createDataSet();
        ITable table = dataSet.getTable("alumnos");

        //creamos el dataset con el resultado esperado
        IDataSet expectedDataSet = new FlatXmlDataFileLoader().load("/tabla3.xml");
        ITable expectedTable = expectedDataSet.getTable("alumnos");

        Assertion.assertEquals(expectedTable, table);
        */
    }

    @Test
    public void testA3_addAlumno_should_return_tabla3_when_adds() throws Exception
    {
        alumnoTO.setNif( "44444444D");
        alumnoTO.setNombre(null);
        alumnoTO.setFechaNacimiento(LocalDate.of( 1982,02,22));

        //SUT
        DAOException error = Assertions.assertThrows(DAOException.class, () -> alumnoDAO.addAlumno(alumnoTO));

        Assertions.assertEquals("Error al conectar con BD", error.getMessage());

        /*
        IDatabaseConnection conexion = databaseTester.getConnection();
        IDataSet dataSet = conexion.createDataSet();
        ITable table = dataSet.getTable("alumnos");

        //creamos el dataset con el resultado esperado
        IDataSet expectedDataSet = new FlatXmlDataFileLoader().load("/tabla3.xml");
        ITable expectedTable = expectedDataSet.getTable("alumnos");

        Assertion.assertEquals(expectedTable, table);
        */
    }
    @Test
    public void testA4_addAlumno_should_return_tabla3_when_adds() throws Exception
    {
        alumnoTO = null;

        //SUT
        DAOException error = Assertions.assertThrows(DAOException.class, () -> alumnoDAO.addAlumno(alumnoTO));

        Assertions.assertEquals("Alumno nulo", error.getMessage());

        /*
        IDatabaseConnection conexion = databaseTester.getConnection();
        IDataSet dataSet = conexion.createDataSet();
        ITable table = dataSet.getTable("alumnos");

        //creamos el dataset con el resultado esperado
        IDataSet expectedDataSet = new FlatXmlDataFileLoader().load("/tabla3.xml");
        ITable expectedTable = expectedDataSet.getTable("alumnos");

        Assertion.assertEquals(expectedTable, table);
        */
    }

    @Test
    public void testA5_addAlumno_should_return_tabla3_when_adds() throws Exception
    {

        alumnoTO.setNif(null);
        alumnoTO.setNombre("Pedro Garcia Lopez");
        alumnoTO.setFechaNacimiento(LocalDate.of(19,02,22));
        //SUT
        DAOException error = Assertions.assertThrows(DAOException.class, () -> alumnoDAO.addAlumno(alumnoTO));

        Assertions.assertEquals("Error al conectar con BD", error.getMessage());

        /*
        IDatabaseConnection conexion = databaseTester.getConnection();
        IDataSet dataSet = conexion.createDataSet();
        ITable table = dataSet.getTable("alumnos");

        //creamos el dataset con el resultado esperado
        IDataSet expectedDataSet = new FlatXmlDataFileLoader().load("/tabla3.xml");
        ITable expectedTable = expectedDataSet.getTable("alumnos");

        Assertion.assertEquals(expectedTable, table);
        */
    }

    @Test
    public void testB1_addAlumno_should_return_tabla3_when_adds() throws Exception
    {

        alumnoTO.setNif("11111111A");

        //SUT
        Assertions.assertDoesNotThrow(() -> alumnoDAO.delAlumno(alumnoTO.getNif()));


        IDatabaseConnection conexion = databaseTester.getConnection();
        IDataSet dataSet = conexion.createDataSet();
        ITable table = dataSet.getTable("alumnos");

        //creamos el dataset con el resultado esperado
        IDataSet expectedDataSet = new FlatXmlDataFileLoader().load("/tabla4.xml");
        ITable expectedTable = expectedDataSet.getTable("alumnos");

        Assertion.assertEquals(expectedTable, table);

    }

    @Test
    public void testB2_addAlumno_should_return_tabla3_when_adds() throws Exception
    {

        alumnoTO.setNif("33333333C");

        //SUT
        DAOException error = Assertions.assertThrows(DAOException.class, () -> alumnoDAO.delAlumno(alumnoTO.getNif()));

        Assertions.assertEquals("No se ha borrado ningun alumno", error.getMessage());

        /*
        IDatabaseConnection conexion = databaseTester.getConnection();
        IDataSet dataSet = conexion.createDataSet();
        ITable table = dataSet.getTable("alumnos");

        //creamos el dataset con el resultado esperado
        IDataSet expectedDataSet = new FlatXmlDataFileLoader().load("/tabla3.xml");
        ITable expectedTable = expectedDataSet.getTable("alumnos");

        Assertion.assertEquals(expectedTable, table);
        */
    }


}
