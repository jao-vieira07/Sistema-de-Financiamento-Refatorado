package model;

public class Casa extends Financiamento {
    private double areaCasa;
    private double areaTerreno;

    public Casa(Double valor, int prazoEmMeses,double jurosAnual, double areaCasa, double areaTerreno) {
        super(valor, prazoEmMeses, jurosAnual);
        this.areaCasa = areaCasa;
        this.areaTerreno = areaTerreno;
    }

    @Override
    public double calcularPagamentoM() {
        return (this.valor / this.prazoEmMeses) * (1 + (this.jurosAnual / 12)) + 80;
    }

    public double getAreaCasa() {
        return areaCasa;
    }

    public double getAreaTerreno() {
        return areaTerreno;
    }

    @Override
    public String toString() {
        String sb = super.toString() + String.format("%-25s %.2f m²\n", "Área da Casa:", this.areaCasa) +
                String.format("%-25s %.2f m²\n", "Área do Terreno:", this.areaTerreno) +
                "-".repeat(40) + "\n" +
                String.format("%-25s R$ %,.2f\n", "PARCELA MENSAL:", this.calcularPagamentoM()) +
                String.format("%-25s R$ %,.2f\n", "TOTAL DO CONTRATO:", (this.calcularPagamentoM() * this.prazoEmMeses)) +
                "=".repeat(40);
        return sb;
    }
}
