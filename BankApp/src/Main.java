
public class Main {
    public static void main(String[] args) {

        Conta conta1 = new Conta(1,"Carlos", "andre",50);
        Conta conta2 = new Conta(2,"Joao", "andre",50);
        Database database = new Database();

        database.addClient(new Client(266150004, 1325, "Carlos Neves", conta1, 28102004, 219887656,963333545, "123@gmail.com", "homem da obra"));

        database.addClient(new Client(266155115, 1645, "Andre Pires", conta2,29092003, 217765909,926678909, "abc@gmail.com", "desempregado"));


        /*for(Client cl : database.getClients()){

            System.out.println(cl.getNif());
        } */
        Menu.start();


    }
}