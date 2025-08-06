public class conversor_Monedas {
    private final ApiMonedas api = new ApiMonedas();

    public double convertir(String from, String to, double monto) throws Exception {
        double tasa = api.obtenerMontos(from, to);
        return monto * tasa;
    }
}
