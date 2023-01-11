
public class Main {
    public static void main(String[] args) {

        Database database = new Database();

        database.addClient(new Client(266150004, 1325, "Carlos Neves", 28102004, 219887656,963333545, "123@gmail.com", "homem da obra"));

        database.addClient(new Client(266155115, 1645, "Andre Pires", 29092003, 217765909,926678909, "abc@gmail.com", "desempregado"));


        /*for(Client cl : database.getClients()){

            System.out.println(cl.getNif());
        } */
        Menu.start();

    }
}