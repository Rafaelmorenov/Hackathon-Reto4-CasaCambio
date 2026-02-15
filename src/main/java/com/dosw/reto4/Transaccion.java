package com.dosw.reto4;

public class Transaccion {
    private double montoOriginal;
    private String monedaOrigen;
    private String monedaDestino;
    private double montoConvertido;

    public Transaccion(double montoOriginal, String monedaOrigen, String monedaDestino, double montoConvertido) {
        this.montoOriginal = montoOriginal;
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.montoConvertido = montoConvertido;
    }

    public String getMonedaDestino() { return monedaDestino; }
    public double getMontoConvertido() { return montoConvertido; }
}
