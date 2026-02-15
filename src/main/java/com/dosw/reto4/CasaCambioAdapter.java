package com.dosw.reto4;

public class CasaCambioAdapter implements IConversor {
    @Override
    public double convertir(double monto, String origen, String destino) {
        if (origen.equalsIgnoreCase(destino)) return monto;
        
        double tasaAUSD = obtenerTasaAUSD(origen);
        double tasaDesdeUSD = obtenerTasaDesdeUSD(destino);
        
        return monto * tasaAUSD * tasaDesdeUSD;
    }
    
    private double obtenerTasaAUSD(String moneda) {
        switch (moneda.toUpperCase()) {
            case "USD": return 1.0;
            case "EUR": return 1.1;
            case "JPY": return 0.0067;
            case "COP": return 0.00025;
            default: return 1.0;
        }
    }
    
    private double obtenerTasaDesdeUSD(String moneda) {
        switch (moneda.toUpperCase()) {
            case "USD": return 1.0;
            case "EUR": return 0.91;
            case "JPY": return 150.0;
            case "COP": return 4000.0;
            default: return 1.0;
        }
    }
}
