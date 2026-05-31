package banco.model;

import javax.swing.JOptionPane;

public class ContaPoupanca extends ContaBancaria {
    private double taxaRendimentoMensal;

    public ContaPoupanca(String numeroConta, Cliente titular, double taxaRendimentoMensal) {
        super(numeroConta, titular, 0.0); 
        this.taxaRendimentoMensal = taxaRendimentoMensal;
    }

    public double calcularRendimento() {
        return saldo * taxaRendimentoMensal;
    }

    public void aplicarRendimento() {
        double rendimento = calcularRendimento();
        saldo += rendimento;
        registrarTransacao("Rendimento aplicado: R$ " + rendimento);
    }

    @Override
    public void gerarExtrato() {
        JOptionPane.showMessageDialog(null,
            "Extrato Conta Poupança\nTitular: " + titular.getNome() +
            "\nSaldo: R$ " + saldo +
            "\nTaxa de Rendimento: " + (taxaRendimentoMensal * 100) + "%");
    }
}
