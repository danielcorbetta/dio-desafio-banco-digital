public abstract class Conta implements IConta{

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;
    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if(valor <= this.getSaldo()){
            this.saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
            imprimirSaldoAtual();
        }else {
            System.out.println("Saldo insuficiente!");
            imprimirSaldoAtual();
        }
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depósito efetuado com sucesso!");
        imprimirSaldoAtual();
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(valor <= this.getSaldo()){
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Transferência realizada com sucesso!");
            imprimirSaldoAtual();
        }else {
            System.out.println("Saldo insuficiente!");
            imprimirSaldoAtual();
        }
    }
    @Override
    public void imprimirSaldoAtual(){
        System.out.println("Saldo atual: R$" + String.format("%.2f", this.getSaldo()));
    }
    protected void imprimirInfosComuns(){
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
