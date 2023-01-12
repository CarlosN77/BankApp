import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Menu {

    static Database database = Database.getInstance();
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
        System.out.println("1. Log in");
        System.out.println("2. Sign up");
        System.out.print("Escolha uma opção: ");
        int option = sc.nextInt();

        switch (option) {
            case 1:
                System.out.println("Insira o NIF:");
                int nif = sc.nextInt();
                System.out.println("Insira a senha:");
                int password = sc.nextInt();

                for (Client c : database.getClient()) {
                    if (c.getNif() == nif && c.getSenha() == password) {
                        System.out.println("Bem vindo, " + c.getPrimeironome() + c.getSegundonome());
                        optionsAfterLogin(c);
                    }
                    System.out.println("Passord ou NIF invalido");
                }
            case 2:
                System.out.println("Insira o primeiro nome:");
                String primeironome = sc.next();
                System.out.println("Insira o segundo nome:");
                String segundonome = sc.next();
                System.out.println("Insira o seu NIF:");
                nif = sc.nextInt();
                System.out.println("Escolha uma password:");
                int senha = sc.nextInt();
                System.out.println("Qual a sua data de nascimento (YYYY-MM-DD): ");
                String dataNascimentoString = sc.next();
                String[] dataNascimentoArray = dataNascimentoString.split("-");
                int ano = Integer.parseInt(dataNascimentoArray[0]);
                int mes = Integer.parseInt(dataNascimentoArray[1]);
                int dia = Integer.parseInt(dataNascimentoArray[2]);
                LocalDate dataNascimento = LocalDate.of(ano, mes, dia);
                System.out.println("Insira o seu numero de telefone:");
                int telefone = sc.nextInt();
                System.out.println("Insira o seu numero de telefone:");
                int telemovel = sc.nextInt();
                System.out.println("Insira o seu email:");
                String email = sc.next();
                System.out.println("Qual a sua profissão:");
                String profissao = sc.next();
                // code to create account
                Client newClient = new Client(nif,senha,primeironome,segundonome,dataNascimento,telefone,telemovel,email,profissao);
                database.addClient(newClient);
                System.out.println("Conta criada com sucesso!");
                break;
            default:
                System.out.println("Escolha uma opção valida.");
                break;
        }
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

