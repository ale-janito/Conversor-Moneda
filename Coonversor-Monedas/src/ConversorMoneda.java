import java.util.*;

public class ConversorMoneda {

    // Método estático que realiza la conversión entre dos monedas
    public static double convertir(double cantidad, double tasaOrigen, double tasaDestino) {
        return cantidad / tasaOrigen * tasaDestino;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] codigos = {"USD", "ARS", "BOB", "BRL", "CLP", "COP"};
        Map<String, Double> tasas = new HashMap<>();

        try {
            // Llama a la API y convierte la respuesta JSON en objeto
            String json = ExchangeRateService.obtenerDatos();
            ExchangeRatesResponse response = UtilJson.parsear(json);

            // Llena el mapa con las tasas para las monedas seleccionadas
            for (String codigo : codigos) {
                tasas.put(codigo, response.getConversion_rates().get(codigo));
            }

            // Bucle principal del menú
            while (true) {
                System.out.println("\nSea bienvenido/a al Conversor de Moneda creado para Alura Latam:");
                for (int i = 0; i < codigos.length; i++) {
                    System.out.println((i + 1) + ". " + codigos[i]);
                }
                System.out.println("7. Convertir a todas las monedas");
                System.out.println("0. Salir");

                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();

                if (opcion == 0) break;

                // Opción para convertir a todas las monedas
                if (opcion == 7) {
                    System.out.print("Seleccione moneda Inicial (Selecciona el número): ");
                    int origenIdx = scanner.nextInt() - 1;

                    if (origenIdx < 0 || origenIdx >= codigos.length) {
                        System.out.println("Opción inválida vuelve a intentar.");
                        continue;
                    }

                    System.out.print("Ingrese monto a convertir: ");
                    double cantidad = scanner.nextDouble();

                    String monedaOrigen = codigos[origenIdx];
                    System.out.println("\n--- Conversión de " + cantidad + " " + monedaOrigen + " a todas las monedas ---");

                    for (int i = 0; i < codigos.length; i++) {
                        if (i == origenIdx) continue;
                        String monedaDestino = codigos[i];
                        double resultado = convertir(cantidad, tasas.get(monedaOrigen), tasas.get(monedaDestino));
                        System.out.printf("%.2f %s = %.2f %s%n", cantidad, monedaOrigen, resultado, monedaDestino);
                    }
                    continue; // Volver al menú
                }

                // Conversión entre dos monedas
                int origenIdx = opcion - 1;
                if (origenIdx < 0 || origenIdx >= codigos.length) {
                    System.out.println("Opción inválida.");
                    continue;
                }

                System.out.print("Seleccione moneda DESTINO (número): ");
                int destinoIdx = scanner.nextInt() - 1;

                if (destinoIdx < 0 || destinoIdx >= codigos.length) {
                    System.out.println("Opción inválida.");
                    continue;
                }

                System.out.print("Ingrese monto a convertir: ");
                double cantidad = scanner.nextDouble();

                String monedaOrigen = codigos[origenIdx];
                String monedaDestino = codigos[destinoIdx];

                double resultado = convertir(cantidad, tasas.get(monedaOrigen), tasas.get(monedaDestino));
                System.out.printf("Resultado: %.2f %s = %.2f %s%n", cantidad, monedaOrigen, resultado, monedaDestino);
            }

        } catch (Exception e) {
            System.out.println("Error al conectar con la API: " + e.getMessage());
        }

        scanner.close();
    }
}
