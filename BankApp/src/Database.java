import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Database {

    static ArrayList<Client> clients = new ArrayList<>();


    public static void addClient(Client newClient) {
        clients.add(newClient);
    }

    public static List<Client> getClients() {
        return clients;
    }
}
