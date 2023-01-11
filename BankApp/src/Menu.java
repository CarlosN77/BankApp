import java.util.Scanner;

public class Menu {




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
            System.out.println("2. Depositar");
            System.out.println("3. Levantar");
            System.out.println("4. Transferir");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int option = sc.nextInt();
            if (option == 1) {
                // code to select account
            } else if (option == 2) {
                // code to deposit
            } else if (option == 3) {
                // code to withdraw
            } else if (option == 4) {
                // code to transfer
            } else if (option == 5) {
                System.out.println("Saindo do menu...");
                break;
            } else {
                System.out.println("Opção inválida. Escolha uma opção válida.");
            }
        }
    }

    public static void ATMVirtual() {
        // code to use virtual ATM
    }
}
