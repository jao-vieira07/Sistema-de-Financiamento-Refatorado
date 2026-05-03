package model;

public class Terreno extends Financiamento {
    private String zonaLocal;

    public Terreno(Double valor, int prazoEmMeses, double jurosAnual, String zonaLocal) {
        super(valor, prazoEmMeses, jurosAnual);
        this.zonaLocal = zonaLocal;
    }

    @Override
    public double calcularPagamentoM() {
        return (this.valor / this.prazoEmMeses) * (1 + (this.jurosAnual / 12)) * 1.02;
    }

    public String getZonaLocal() {
        return zonaLocal;
    }

    @Override
    public String toString() {
        String sb = super.toString() + String.format("%-25s %s\n", "Localização/Zona:", this.getZonaLocal()) +
                "-".repeat(40) + "\n" +
                String.format("%-25s R$ %,.2f\n", "PARCELA MENSAL:", this.calcularPagamentoM()) +
                String.format("%-25s R$ %,.2f\n", "TOTAL DO CONTRATO:", (this.calcularPagamentoM() * this.prazoEmMeses)) +
                "=".repeat(40);
        return sb;
    }

}
