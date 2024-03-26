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
                                "|                           Clients                         |\n");
                System.out.printf(
                                "-------------------------------------------------------------\n");
                System.out.printf("| %18s | %20s | %13s |\n", "Name", "Last name", "Birthday");
                System.out.printf(
                                "-------------------------------------------------------------\n");
                for (Client client : clients) {
                        System.out.printf("| %18s | %20s | %13s |\n", client.getProfile().getName(),
                                        client.getProfile().getLastName(),
                                        DateFormatter.Formatt(client.getProfile().getBirthdate()));
                }
                System.out.printf(
                                "-------------------------------------------------------------\n\n");
        }

        public static void deleteClientByIndex(int index) {
                if (clients.get(index).getBorrowedBooks().isEmpty()) {
                        clients.remove(index);
                } else {
                        System.out.println("Can't delete this client: ");
                }
        }

        public static Client getClientByIndex(int index) {
                return clients.get(index);
        }

        public static void printClientBorrowedBooks(Client client) {
                if (!client.getBorrowedBooks().isEmpty()) {
                        System.out.printf(
                                        "---------------------------------------------------------------------------------------------------\n");
                        System.out.printf(
                                        "|                             Client "
                                                        + client.getProfile().getName()
                                                        + " " + client.getProfile().getLastName() + " borrowed books"
                                                        + "                             |\n");
                        System.out.printf(
                                        "---------------------------------------------------------------------------------------------------\n");
                        System.out.printf("| %18s | %20s | %20s | %15s | %10s |\n", "ISBN", "TITLE", "AUTHOR",
                                        "PUBLISH DATE",
                                        "AVAILABLE");
                        System.out.printf(
                                        "---------------------------------------------------------------------------------------------------\n");
                        for (Book book : client.getBorrowedBooks()) {
                                System.out.printf("| %18s | %20s | %20s | %15s | %10s |\n", book.getIsbn(),
                                                book.getTitle(),
                                                book.getAuthor().getProfile().getName() + " "
                                                                + book.getAuthor().getProfile().getLastName(),
                                                DateFormatter.Formatt(book.getPublishDate()), book.getIsAvailable());
                        }
                        System.out.printf(
                                        "---------------------------------------------------------------------------------------------------\n");
                } else {
                        System.out.println("None to show");
                }
        }

        public static Client getClientByNameAndLastname(String name, String lastname) {
                for (Client client : clients) {
                        if (client.getProfile().getName().equals(name)
                                        && client.getProfile().getLastName().equals(lastname)) {
                                return client;
                        }
                }
                return null;
        }

        public static void printAvailableClients() {
                System.out.printf(
                                "-------------------------------------------------------------\n");
                System.out.printf(
                                "|                           Clients                         |\n");
                System.out.printf(
                                "-------------------------------------------------------------\n");
                System.out.printf("| %18s | %20s | %13s |\n", "Name", "Last name", "Birthday");
                System.out.printf(
                                "-------------------------------------------------------------\n");
                for (Client client : clients) {
                        if (client.borrowedBooks.size() < 3) {
                                System.out.printf("| %18s | %20s | %13s |\n", client.getProfile().getName(),
                                                client.getProfile().getLastName(),
                                                DateFormatter.Formatt(client.getProfile().getBirthdate()));
                        }
                }
                System.out.printf(
                                "-------------------------------------------------------------\n\n");
        }

        public static boolean checkClientExist(String name, String lastname) {
                for (Client client : clients) {
                        if (client.getProfile().getName().equals(name)
                                        && client.getProfile().getLastName().equals(lastname)) {
                                return true;
                        }
                }
                return false;
        }

}
