/*  Challenge "Conversor de Monedas"
    Anny Jaramillo
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        conversor_Monedas conversor = new conversor_Monedas();
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Elige una opción: ");
            opcion = input.nextInt();

            switch (opcion) {
                /* Sin lambda
                case 1:
                    double monto1 = leerMonto(input);
                    convertir(converter, "USD", "ARS", monto1);
                    break; */
                case 1 -> convertir(conversor, "USD", "ARS", leerMonto(input));
                case 2 -> convertir(conversor, "ARS", "USD", leerMonto(input));
                case 3 -> convertir(conversor, "USD", "BRL", leerMonto(input));
                case 4 -> convertir(conversor, "BRL", "USD", leerMonto(input));
                case 5 -> convertir(conversor, "USD", "COP", leerMonto(input));
                case 6 -> convertir(conversor, "COP", "USD", leerMonto(input));
                case 7 -> System.out.println("Gracias por usar el conversor de monedas. ¡Hasta luego :) !");
                default -> System.out.println("Opción inválida, intenta nuevamente.");
            }

        } while (opcion != 7);

        input.close();
    }

    public static void mostrarMenu() {
        System.out.println("---------CONVERSOR DE MONEDAS---------- ");
        System.out.println("BIENVENID@ ");
        System.out.println("1. Dólar -> Peso argentino ");
        System.out.println("2. Peso argentino -> Dólar ");
        System.out.println("3. Dólar -> Real brasileño ");
        System.out.println("4. Real brasileño -> Dólar ");
        System.out.println("5. Dólar -> Peso colombiano ");
        System.out.println("6. Peso colombiano -> Dólar ");
        System.out.println("7. Salir ");
    }

    public static double leerMonto(Scanner input) {
        System.out.print("Ingresa el monto a convertir: ");
        return input.nextDouble();
    }

    public static void convertir(conversor_Monedas converter, String from, String to, double monto) {
        try {
            double resultado = converter.convertir(from, to, monto);
            System.out.printf("Convertiste %.2f %s a %.2f %s\n\n", monto, from, resultado, to);
        } catch (Exception e) {
            System.out.println("Ocurrió un error durante la conversión: " + e.getMessage());
        }
    }

}
