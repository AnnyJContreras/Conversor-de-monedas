import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ApiMonedas {

    private final String API_KEY = "b58a87c3e511f27bb9a4bed8";
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    //Devuelve la tasa de conversión entre monedaBase y monedaObjetivo
    public double obtenerMontos(String monedaBase, String monedaObjetivo) throws Exception {
        String url = String.format(
                "https://v6.exchangerate-api.com/v6/%s/latest/%s",
                API_KEY, monedaBase);

        // Configuración HttpRequest (URL, método, timeout, header)
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(10))
                .header("Accept", "application/json")
                .GET()
                .build();

        // Envio de solicitud con HttpClient y recibir la respuesta HttpResponse
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // Revisión del código HTTP recibido
        if (response.statusCode() != 200) {
            throw new RuntimeException("Error al consumir API: HTTP " + response.statusCode());
        }

        // Buscamos "conversion_rates" con GSON en el cuerpo JSON
        JsonObject json = gson.fromJson(response.body(), JsonObject.class);
        JsonObject rates = json.getAsJsonObject("conversion_rates");

        // Devolvemos solo la tasa solicitada
        return rates.get(monedaObjetivo).getAsDouble();
    }
}




