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

    public void deleteCient() {
        int index = AskData.askIndex();
        ClientRepository.deleteClientByIndex(index);
    }

    public void createClient() {
        String name = AskData.askName();
        String lastname = AskData.askLastname();
        Date birthDay = AskData.askDate();
        Profile profile = new Profile(name, lastname, birthDay);
        Client client = new Client(profile);
        ClientRepository.createClient(client);
    }

    public void printCLient() {
        ClientRepository.printAllClients();
    }

}
