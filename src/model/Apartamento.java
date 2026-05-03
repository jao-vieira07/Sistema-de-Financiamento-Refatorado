package model;

public class Apartamento extends Financiamento {
    private int numAndar;
    private int vagasGaragem;

    public Apartamento(Double valor, int prazoEmMeses, double jurosAnual, int numAndar, int vagasGaragem) {
        super(valor, prazoEmMeses, jurosAnual);
        this.numAndar = numAndar;
        this.vagasGaragem = vagasGaragem;
    }

    @Override
    public double calcularPagamentoM() {
        double taxaMensal = (this.jurosAnual / 100) / 12;
        return (this.valor * taxaMensal * Math.pow(1 + (taxaMensal), this.prazoEmMeses)) / (Math.pow(1 + taxaMensal, this.prazoEmMeses) - 1);
    }

    public int getNumAndar() {
        return numAndar;
    }

    public int getVagasGaragem() {
        return vagasGaragem;
    }

    @Override
    public String toString() {
        String sb = super.toString() + String.format("%-25s %dº\n", "Andar:", this.numAndar) +
                String.format("%-25s %d vaga(s)\n", "Vagas na Garagem:", this.vagasGaragem) +
                "-".repeat(40) + "\n" +
                String.format("%-25s R$ %,.2f\n", "PARCELA MENSAL:", this.calcularPagamentoM()) +
                String.format("%-25s R$ %,.2f\n", "TOTAL DO CONTRATO:", (this.calcularPagamentoM() * this.prazoEmMeses)) +
                "=".repeat(40);
        return sb;
    }
}
