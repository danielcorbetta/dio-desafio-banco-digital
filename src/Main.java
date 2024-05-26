public class Main {
    public static void main(String[] args) {
        Cliente daniel = new Cliente();
        daniel.setNome("Daniel");

        Conta cc = new ContaCorrente(daniel);
        Conta poupanca = new ContaPoupanca(daniel);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
