package banco.model;

import java.awt.Container;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import banco.interfaces.Operavel;

public abstract class ContaBancaria implements Operavel {
    protected String numeroConta;
    protected Cliente titular;
    protected double saldo;
    protected List<String> historico;

    public ContaBancaria(String numeroConta, Cliente titular, double saldo) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0.0;
        this.historico = new ArrayList<>();
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        registrarTransacao("Depósito de R$ " + valor);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            registrarTransacao("Saque de R$ " + valor);
        } else {
            registrarTransacao("Tentativa de saque sem saldo suficiente");
        }
        return false;
    }

    @Override
    public void exibirSaldo() {
        javax.swing.JOptionPane.showMessageDialog(null, 
            "Saldo da conta " + numeroConta + ": R$ " + saldo);
    }

    protected void registrarTransacao(String descricao) {
        historico.add(descricao);
    }

    public void exibirHistorico() {
        StringBuilder sb = new StringBuilder("Histórico da conta " + numeroConta + ":\n");
        for (String h : historico) {
            sb.append(h).append("\n");
        }
        javax.swing.JOptionPane.showMessageDialog(null, sb.toString());
    }

    public String getNumeroConta() { return numeroConta; }
    public Cliente getTitular() { return titular; }
    public double getSaldo() { return saldo; }

    public abstract void gerarExtrato();
        {
    }
}