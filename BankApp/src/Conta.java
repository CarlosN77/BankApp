public class Conta {

    public int numerodeconta;
    private String titularprincipal;
    private String titularsecundario;
    public double saldo;

    public Conta(int numerodeconta, String titularprincipal, String titularsecundario, double saldo) {
        this.numerodeconta = numerodeconta;
        this.titularprincipal = titularprincipal;
        this.titularsecundario = titularsecundario;
        this.saldo = saldo;
    }

    public Conta(int accountNum) {
    }


    public int getNumerodeconta(int accountNum) {
        return numerodeconta;
    }

    public void setNumerodeconta(int numerodeconta) {
        this.numerodeconta = numerodeconta;
    }

    public String getTitularprincipal() {
        return titularprincipal;
    }

    public void setTitularprincipal(String titularprincipal) {
        this.titularprincipal = titularprincipal;
    }

    public String getTitularsecundario() {
        return titularsecundario;
    }

    public void setTitularsecundario(String titularsecundario) {
        this.titularsecundario = titularsecundario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void deposito(double quantia){
        if (quantia > 0) {
            saldo += quantia;
        } else {
            System.out.println("Impossivel depositar");
        }
    }

    public void levantar(double quantia) {
        if (quantia > 0 && quantia <= saldo) {
            saldo -= quantia;
        } else {
            System.out.println("Impossível levantar essa quantia, saldo insuficiente");
        }
    }

    public void transferir(Conta contaDestino, double quantia) {
        if(quantia > 0 && quantia <= saldo){
            this.saldo -= quantia;
            contaDestino.saldo += quantia;
        } else{
            System.out.println("Impossible to transfer, insufficient funds.");
        }
    }

    public void alterarpin(int novopin) {
        Cartão.pin = novopin;
    }


    public void transferir(int accountToTransfer, double amount) {
    }
}
