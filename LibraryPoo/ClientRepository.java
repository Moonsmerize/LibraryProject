import java.util.ArrayList;
import java.util.Date;

public class ClientRepository {

    private static ArrayList<Client> clients = new ArrayList<>();

    public static void createClient(Client client) {
        clients.add(client);
    }

    public static void modifyClient(int index, String name, String lastname, Date Birthday) {
        clients.get(index).getProfile().setName(name);
        clients.get(index).getProfile().setLastName(lastname);
        clients.get(index).getProfile().setBirthdate(Birthday);
    }

    public static void printAllClients() {
        System.out.printf(
                "-------------------------------------------------------------\n");
        System.out.printf(
                "                            Clients                          \n");
        System.out.printf(
                "-------------------------------------------------------------\n");
        System.out.printf("| %18s | %20s | %13s |\n", "Name", "Last name", "Birthday");
        System.out.printf(
                "-------------------------------------------------------------\n");
        for (Client client : clients) {
            System.out.printf("| %18s | %20s | %13s |\n", client.getProfile().getName(),
                    client.getProfile().getLastName(),
                    Formatter.Formatt(client.getProfile().getBirthdate()));
        }
        System.out.printf(
                "-------------------------------------------------------------\n\n");
    }

    public static void deleteCient(int index) {
        if (clients.get(index).borrowedBooks.isEmpty()) {
            clients.remove(index);
        } else {
            System.out.println("Cant delete this client: ");
        }
    }

    public Client getClientByIndex(int index) {
        return clients.get(index);
    }

}
