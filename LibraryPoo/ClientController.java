import java.util.Date;
import java.util.Scanner;

public class ClientController {
    Scanner sc = new Scanner(System.in);

    public void modifyClient() {
        int index = AskData.askIndex();
        String name = AskData.askName();
        String lastname = AskData.askLastname();
        Date birthDay = AskData.askDate();
        ClientRepository.modifyClient(index, name, lastname, birthDay);
    }

    public void clientsMenu() {
        Byte option = 0;
        System.out.println(
                "\nType 1 to create a client\nType 2 to print clients\nType 3 to modify a client\nType 4 to delete a client");
        option = AskData.askOption();
        switch (option) {
            case 1:
                this.createClient();
                break;
            case 2:
                this.printClients();
                break;
            case 3:
                this.modifyClient();
                break;
            case 4:
                this.deleteCient();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    public void deleteCient() {
        int index = AskData.askIndex();
        ClientRepository.deleteClientByIndex(index);
    }

    public void createClient() {
        AskData.bufferCleaner();
        String name = AskData.askName();
        String lastname = AskData.askLastname();
        Date birthDay = AskData.askDate();
        Profile profile = new Profile(name, lastname, birthDay);
        Client client = new Client(profile);
        ClientRepository.createClient(client);
    }

    public void printClients() {
        byte option = 0;
        System.out.print("\nType 1 to print clients\nType 2 to print client borrowed books\n");
        option = AskData.askOption();
        switch (option) {
            case 1:
                ClientRepository.printAllClients();
                break;
            case 2:
                ClientRepository.printAllClients();
                int index = AskData.askIndex();
                ClientRepository.printClientBorrowedBooks(ClientRepository.getClientByIndex(index));
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

}
