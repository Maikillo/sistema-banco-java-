package banco.model;

import javax.swing.JOptionPane;

public class ContaCorrente extends ContaBancaria {
    private double limiteChequeEspecial;

    public ContaCorrente(String numeroConta, Cliente titular, double limiteChequeEspecial) {
        super(numeroConta, titular, 0.0);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public void usarChequeEspecial(double valor) {
        if (valor <= limiteChequeEspecial) {
            saldo += valor;
            registrarTransacao("Uso de cheque especial: R$ " + valor);
        } else {
            registrarTransacao("Tentativa de uso acima do limite do cheque especial");
        }
    }

    @Override
    public void gerarExtrato() {
        JOptionPane.showMessageDialog(null,
            "Extrato Conta Corrente\nTitular: " + titular.getNome() +
            "\nSaldo: R$ " + saldo +
            "\nLimite Cheque Especial: R$ " + limiteChequeEspecial);
    }
}
