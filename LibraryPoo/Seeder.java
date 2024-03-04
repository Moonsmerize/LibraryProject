import java.util.Date;

public class Seeder {

    @SuppressWarnings("deprecation")
    public static void initialize() {

        Profile clientProfile1 = new Profile("Client1", "Apellido1", new Date(1970, 3, 20));
        Profile clientProfile2 = new Profile("Client2", "Apellido2", new Date(1970, 3, 20));
        Profile clientProfile3 = new Profile("Client3", "Apellido3", new Date(1970, 3, 20));
        Profile clientProfile4 = new Profile("Client4", "Apellido4", new Date(1970, 3, 20));
        Profile clientProfile5 = new Profile("Client5", "Apellido5", new Date(1970, 3, 20));
        Client client1 = new Client(clientProfile1);
        Client client2 = new Client(clientProfile2);
        Client client3 = new Client(clientProfile3);
        Client client4 = new Client(clientProfile4);
        Client client5 = new Client(clientProfile5);
        ClientRepository.createClient(client1);
        ClientRepository.createClient(client2);
        ClientRepository.createClient(client3);
        ClientRepository.createClient(client4);
        ClientRepository.createClient(client5);

        Profile authorProfile1 = new Profile("Autor1", "Apellido1", new Date(1970, 3, 20));
        Profile authorProfile2 = new Profile("Autor2", "Apellido2", new Date(1970, 3, 20));
        Profile authorProfile3 = new Profile("Autor3", "Apellido3", new Date(1970, 3, 20));
        Profile authorProfile4 = new Profile("Autor4", "Apellido4", new Date(1970, 3, 20));
        Profile authorProfile5 = new Profile("Autor5", "Apellido5", new Date(1970, 3, 20));
        Author autor1 = new Author(authorProfile1);
        Author autor2 = new Author(authorProfile2);
        Author autor3 = new Author(authorProfile3);
        Author autor4 = new Author(authorProfile4);
        Author autor5 = new Author(authorProfile5);

        Book libro1 = new Book("ISBN123", "Libro1", autor1, new Date(), true);
        Book libro2 = new Book("ISBN234", "Libro2", autor2, new Date(), true);
        Book libro3 = new Book("ISBN656", "Libro3", autor3, new Date(), false);
        Book libro4 = new Book("ISBN954", "Libro4", autor4, new Date(), true);
        Book libro5 = new Book("ISBN154", "Libro5", autor5, new Date(), true);

        BookRepository.addBook(libro1);
        BookRepository.addBook(libro2);
        BookRepository.addBook(libro3);
        BookRepository.addBook(libro4);
        BookRepository.addBook(libro5);

        BookRepository.printAllBooks();
        ClientRepository.printAllClients();

    }

}
