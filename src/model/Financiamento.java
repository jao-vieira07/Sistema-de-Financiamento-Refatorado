package model;

public abstract class Financiamento {
    protected double valor;
    protected int prazoEmMeses;
    protected double jurosAnual;

    public Financiamento(double valor, int prazoEmMeses, double jurosAnual) {
        this.valor = valor;
        this.prazoEmMeses = prazoEmMeses;
        this.jurosAnual = jurosAnual;
    }

    public abstract double calcularPagamentoM();

    public Double getValor() {
        return valor;
    }

    public int getPrazoEmMeses() {
        return prazoEmMeses;
    }

    public double getJurosAnual() {
        return jurosAnual;
    }

    @Override
    public String toString() {
        String sb = "\n" + "=".repeat(40) + "\n" +
                String.format("%-25s %s\n", "TIPO DO IMÓVEL:", this.getClass().getSimpleName().toUpperCase()) +
                "-".repeat(40) + "\n" +
                String.format("%-25s R$ %,.2f\n", "Valor do Imóvel:", this.valor) +
                String.format("%-25s %d meses\n", "Prazo:", this.prazoEmMeses) +
                String.format("%-25s %.2f%%\n", "Taxa de Juros (Anual):", this.jurosAnual);
        return sb;
    }
}
