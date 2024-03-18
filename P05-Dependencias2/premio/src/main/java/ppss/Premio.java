package ppss;

import java.util.Random;

public class Premio {
    private static final float PROBABILIDAD_PREMIO = 0.1f;
    public Random generador = new Random(System.currentTimeMillis());
    public ClienteWebService cliente = new ClienteWebService();
    public String compruebaPremio(){
        if(generaNumero() < PROBABILIDAD_PREMIO) { //Dependencia
            try {
                String premio = cliente.obtenerPremio(); //Dependencia
                return "Premiado con " + premio;
            } catch(ClienteWebServiceException e) {
                return "No se ha podido obtener el premio";
            }
        } else {
            return "Sin premio";
        }
    }

    public float generaNumero() {
        return generador.nextFloat();
    }
}