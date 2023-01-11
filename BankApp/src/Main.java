
public class Main {
    public static void main(String[] args) {
        Client cliente = new Client(2,123, "car",28102004,92,81,"av","alm");
        Conta conta1 = new Conta(1,"a" ,"na", 50.00);
        Conta conta2 = new Conta(2, "b", "ya", 65.00);
        conta2.deposito(250.00);
        System.out.println("Balance da conta 2 : " + conta2.getSaldo() );
        conta1.deposito(100.00);
        System.out.println("Balance da conta 1 : " + conta1.getSaldo() );
        conta1.levantar(65.00);
        System.out.println("Balance da conta 1 depois do levantamento : " + conta1.getSaldo());
        conta2.transferir(conta1, 75.68);
        System.out.println("Balance da conta 2 depois da transferencia : " + conta2.getSaldo() );
        System.out.println("Balance da conta 1 depois da transferencia : " + conta1.getSaldo() );

    }
}