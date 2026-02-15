package com.dosw.reto4;

import java.util.*;
import java.util.stream.Collectors;

public class Reto4CasaCambio {
    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);
        IConversor adaptador = new CasaCambioAdapter();
        List<Transaccion> historial = new ArrayList<>();

        System.out.print("Ingrese número de transacciones: ");
        int numTransacciones = sc.nextInt();

        for (int i = 1; i <= numTransacciones; i++) {
            System.out.println("Transacción " + i);
            System.out.print("Ingrese monto: ");
            double monto = sc.nextDouble();
            System.out.print("Ingrese moneda de origen: ");
            String origen = sc.next().toUpperCase();
            System.out.print("Ingrese monedas destino (separadas por coma): ");
            String[] destinos = sc.next().split(",");

            for (String d : destinos) {
                String destino = d.trim().toUpperCase();
                double resultado = adaptador.convertir(monto, origen, destino);
                historial.add(new Transaccion(monto, origen, destino, resultado));
                System.out.println("Convertido a " + destino + ": " + String.format("%.2f", resultado) + " " + destino);
            }
        }

        System.out.println("\nTotales por moneda");
        historial.stream()
            .collect(Collectors.groupingBy(
                Transaccion::getMonedaDestino,
                Collectors.summingDouble(Transaccion::getMontoConvertido)
            ))
            .forEach((moneda, total) -> System.out.println(moneda + ": " + String.format("%.2f", total) + " " + moneda));
    }
}
