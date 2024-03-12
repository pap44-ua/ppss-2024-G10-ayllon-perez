package ppss;

public class TestableAlquilaCoche extends AlquilaCoches{

    @Override
    public IService getServicio()
    {
        return new Servicio();
    }

}
