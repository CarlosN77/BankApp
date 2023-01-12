import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Menu {


    static Conta conta2 = new Conta(2, "Joao", "andre", 50);

    public static void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Fazer log in na app");
            System.out.println("2. Usar ATM");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int option = sc.nextInt();

            if (option == 1) {
                logIn();
            } else if (option == 2) {
                ATMVirtual();
            } else if (option == 3) {
                System.out.println("Adeus e até á proxima!");
                break;
            } else {
                System.out.println("Opção invalida. Escolha uma opção valida.");
            }
        }
    }

    public static void logIn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nif:");
        int nif = sc.nextInt();
        System.out.println("Enter password:");
        int password = sc.nextInt();

        for (Client c : Database.getClients()) {
            if (c.getNif() == nif && c.getSenha() == password) {
                System.out.println("Welcome, " + c.getNome());
                optionsAfterLogin(c);
            }
        }
        System.out.println("Invalid nif or password");
    }


    public static void optionsAfterLogin(Client loggedInClient) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Selecionar conta");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");

            int option = sc.nextInt();
            if (option == 1) {
                // code to select account
                List<Conta> contas = Collections.singletonList(loggedInClient.getConta());
                int i = 1;
                for (Conta c : contas) {
                    System.out.println(i + ". " + c.getTitularprincipal());
                    i++;
                }
                System.out.println("Escolha a conta que deseja usar: ");
                int accountOption = sc.nextInt();
                Conta selectedAccount = contas.get(accountOption - 1);
                accountOptions(selectedAccount);
            } else if (option == 2) {
                System.out.println("Saindo do menu...");
                break;
            } else {
                System.out.println("Opção inválida. Escolha uma opção válida.");
            }
        }
    }


    public static void accountOptions(Conta selectedAccount) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Depositar");
            System.out.println("2. Levantar");
            System.out.println("3. Transferir");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int option = sc.nextInt();
            if (option == 1) {
                // code to deposit
                System.out.println("Quanto quer depositar: ");
                double amount = sc.nextDouble();
                selectedAccount.deposito(amount);
                System.out.println("Novo saldo: " + selectedAccount.getSaldo());
            } else if (option == 2) {
                // code to withdraw
                System.out.println("Quanto quer levantar: ");
                double amount = sc.nextDouble();
                selectedAccount.levantar(amount);
                System.out.println("Novo saldo: " + selectedAccount.getSaldo());
            } else if (option == 3) {
                System.out.println("Insira o numero da conta para a qual quer transferir: ");
                int accountNum = sc.nextInt();
                int accountToTransfer = conta2.getNumerodeconta(accountNum);
                System.out.println("Qual o valor a transferir: ");
                double amount = sc.nextDouble();
                selectedAccount.transferir(accountToTransfer, amount);
                selectedAccount.setSaldo(selectedAccount.getSaldo() - amount);
                System.out.println("Novo saldo: " + selectedAccount.getSaldo());
            } else if (option == 4) {
                System.out.println("Saindo do menu...");
                break;
            }


        }
    }

    public static void ATMVirtual() {
        // code to use virtual ATM
    }
}

