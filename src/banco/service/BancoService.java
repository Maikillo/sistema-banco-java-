package banco.service;

import banco.model.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class BancoService {
    private List<ContaBancaria> contas = new ArrayList<>();

    public void cadastrarConta(ContaBancaria conta) {
        contas.add(conta);
    }

    public ContaBancaria buscarConta(String numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    public void listarTodasAsContas() {
        StringBuilder sb = new StringBuilder("=== Todas as Contas ===\n");
        for (ContaBancaria conta : contas) {
            sb.append("Nº: ").append(conta.getNumeroConta())
                .append(" | Titular: ").append(conta.getTitular().getNome())
                .append(" | Tipo: ").append(conta instanceof ContaCorrente ? "Corrente" : "Poupança")
                .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public double calcularPatrimonioTotal() {
        double total = 0;
        for (ContaBancaria conta : contas) {
            total += conta.getSaldo();
        }
        return total;
    }

    public void exibirRelatorioGeral() {
        JOptionPane.showMessageDialog(null,
            "Relatório Geral\n" +
            "Total de contas: " + contas.size() + "\n" +
            "Patrimônio Total: R$ " + calcularPatrimonioTotal());
    }
}
