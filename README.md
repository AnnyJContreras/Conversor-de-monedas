# Conversor-de-monedas

Conversor de monedas en Java que consulta una API externa (ExchangeRate-API) para obtener tasas de cambio en tiempo real.

## Tecnologías utilizadas
* Java 11 o superior
* API ExchangeRate (v6)
* Librería Gson (`gson.jar`) 

## ¿Cómo funciona?
1. El usuario selecciona una opción del menú (por ejemplo: USD → ARS)
2. Ingresa el monto a convertir
3. El programa hace una solicitud HTTP a la API:<br>
   `https://v6.exchangerate-api.com/v6/<<API_KEY>>/latest/<<MONEDA_BASE>>`
4. Analiza el JSON recibido con Gson
5. Calcula el resultado y lo muestra al usuario

## Clases principales
* `Main` → Menú interactivo en consola  
* `ApiMonedas` → Realiza la llamada HTTP y obtiene la tasa de cambio  
* `conversor_Monedas` → Multiplica el monto por la tasa obtenida desde la API  

