# Conversor-Moneda
Conversor de monedas 
# 💱 Conversor de Monedas en Java

Este es un proyecto simple en Java que implementa un conversor de monedas utilizando la [ExchangeRate-API](https://www.exchangerate-api.com/). Permite convertir entre diferentes monedas de América Latina y Estados Unidos mediante una interfaz de consola.
![image](https://github.com/user-attachments/assets/54e19dc6-9124-4349-af03-ed05a3516d73)

Obtención de API 
![image](https://github.com/user-attachments/assets/93f849dd-4335-485e-b76d-80ffdd1838b0)
-Se obtienen hasta 1500 consultas al mes 

-Plan Free

-Solo login con correo 

## 🚀 Funcionalidades

- Consulta tasas de cambio en tiempo real desde la API.
- Conversión entre monedas: USD, ARS, BOB, BRL, CLP, COP.
- Opción para convertir una moneda a todas las demás.
- Menú interactivo en consola.
- Manejo de errores básicos.
- Modularizado con clases para mantener el código organizado.

## 🧱 Tecnologías usadas

- Java 11+ (requiere `HttpClient`, `HttpRequest`, `HttpResponse`)
- Gson para manejo de JSON
- API pública de ExchangeRate-API

## 📦 Estructura del proyecto
Conversor-Monedas/

├── ConversorMoneda.java # Clase principal con menú

├── ExchangeRateService.java # Solicita datos a la API

├── ExchangeRatesResponse.java # Modelo para parsear JSON

├── UtilJson.java # Utiliza Gson para leer JSON

├── gson-2.13.1.jar # Librería Gson (agregada manualmente)

└── README.md # Este archivo

Ejemplo de uso 
Sea bienvenido/a al Conversor de Moneda:
1. USD
2. ARS
3. BOB
4. BRL
5. CLP
6. COP
7. Convertir a todas las monedas
0. Salir
Seleccione una opción: 7
Seleccione moneda Inicial (número): 1
Ingrese monto a convertir: 10

--- Conversión de 10.00 USD a todas las monedas ---
10.00 USD = 9200.00 CLP
10.00 USD = 50.00 BRL
...

Salida Código

![image](https://github.com/user-attachments/assets/8791d8a5-ac97-4736-a002-f98ca09d7b14)

