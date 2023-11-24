class ContaPoupanca extends TipoDeConta {
    public void depositar(double valor) {
        saldo += valor;
        System.out.printf("\nDepósito de R$ %.2f na Conta Poupança realizado com sucesso.", valor);
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.printf("\nSaque de R$ %.2f na Conta Poupança realizado com sucesso.", valor);
        } else {
            System.out.println("\nInfelizmente seu saldo é insuficiente para esse saque. Verifique o saldo e refaça a operação.");
        }
    }
}
