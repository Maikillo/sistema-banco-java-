package banco.app;

import banco.model.*;
import banco.service.BancoService;
import javax.swing.JOptionPane;

public class SistemaBanco {
    public static void main(String[] args) {
        BancoService banco = new BancoService();
        int opcao;

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                "===== SISTEMA BANCÁRIO =====\n" +
                "1 – Cadastrar Conta Corrente\n" +
                "2 – Cadastrar Conta Poupança\n" +
                "3 – Depositar\n" +
                "4 – Sacar\n" +
                "5 – Consultar Saldo\n" +
                "6 – Exibir Extrato\n" +
                "7 – Histórico de Transações\n" +
                "8 – Listar Contas\n" +
                "9 – Relatório Geral\n" +
                "0 – Sair"));

            switch (opcao) {
                case 1:
                    String nome = JOptionPane.showInputDialog("Nome do Cliente:");
                    String cpf = JOptionPane.showInputDialog("CPF:");
                    String tel = JOptionPane.showInputDialog("Telefone:");
                    String numCC = JOptionPane.showInputDialog("Número da Conta:");
                    double limite = Double.parseDouble(JOptionPane.showInputDialog("Limite Cheque Especial:"));

                    Cliente clienteCC = new Cliente(nome, cpf, tel);
                    ContaCorrente cc = new ContaCorrente(numCC, clienteCC, limite);
                    banco.cadastrarConta(cc);
                    break;

                case 2:
                    nome = JOptionPane.showInputDialog("Nome do Cliente:");
                    cpf = JOptionPane.showInputDialog("CPF:");
                    tel = JOptionPane.showInputDialog("Telefone:");
                    String numCP = JOptionPane.showInputDialog("Número da Conta:");
                    double taxa = Double.parseDouble(JOptionPane.showInputDialog("Taxa de Rendimento (ex: 0.02):"));

                    Cliente clienteCP = new Cliente(nome, cpf, tel);
                    ContaPoupanca cp = new ContaPoupanca(numCP, clienteCP, taxa);
                    banco.cadastrarConta(cp);
                    break;

                case 3: 
                    String contaDep = JOptionPane.showInputDialog("Número da Conta:");
                    ContaBancaria contaD = banco.buscarConta(contaDep);
                    if (contaD != null) {
                        double valorDep = Double.parseDouble(JOptionPane.showInputDialog("Valor do depósito:"));
                        contaD.depositar(valorDep);
                    } else {
                        JOptionPane.showMessageDialog(null, "Conta não encontrada!");
                    }
                    break;

                case 4: 
                    String contaSac = JOptionPane.showInputDialog("Número da Conta:");
                    ContaBancaria contaS = banco.buscarConta(contaSac);
                    if (contaS != null) {
                        double valorSac = Double.parseDouble(JOptionPane.showInputDialog("Valor do saque:"));
                        contaS.sacar(valorSac);
                    } else {
                        JOptionPane.showMessageDialog(null, "Conta não encontrada!");
                    }
                    break;

                case 5: 
                    String contaSaldo = JOptionPane.showInputDialog("Número da Conta:");
                    ContaBancaria contaSal = banco.buscarConta(contaSaldo);
                    if (contaSal != null) {
                        contaSal.exibirSaldo();
                    } else {
                        JOptionPane.showMessageDialog(null, "Conta não encontrada!");
                    }
                    break;

                case 6: 
                    String contaExt = JOptionPane.showInputDialog("Número da Conta:");
                    ContaBancaria contaE = banco.buscarConta(contaExt);
                    if (contaE != null) {
                        contaE.gerarExtrato();
                    } else {
                        JOptionPane.showMessageDialog(null, "Conta não encontrada!");
                    }
                    break;

                case 7:
                    String contaHist = JOptionPane.showInputDialog("Número da Conta:");
                    ContaBancaria contaH = banco.buscarConta(contaHist);
                    if (contaH != null) {
                        contaH.exibirHistorico();
                    } else {
                        JOptionPane.showMessageDialog(null, "Conta não encontrada!");
                    }
                    break;

                case 8: 
                    banco.listarTodasAsContas();
                    break;

                case 9: 
                    banco.exibirRelatorioGeral();
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Encerrando o sistema...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (opcao != 0);
    }
}

