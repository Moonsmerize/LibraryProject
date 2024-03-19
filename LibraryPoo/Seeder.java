import java.util.Date;

public class Seeder {

    @SuppressWarnings("deprecation")
    public static void initialize() {

        Profile clientProfile1 = new Profile("Client1", "Apellido1", new Date(1971 - 1900, 4, 19));
        Profile clientProfile2 = new Profile("Client2", "Apellido2", new Date(1965 - 1900, 1, 20));
        Profile clientProfile3 = new Profile("Client3", "Apellido3", new Date(1998 - 1900, 3, 30));
        Profile clientProfile4 = new Profile("Client4", "Apellido4", new Date(1999 - 1900, 2, 07));
        Profile clientProfile5 = new Profile("Client5", "Apellido5", new Date(1953 - 1900, 5, 01));
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

        Profile authorProfile1 = new Profile("Autor1", "Apellido1", new Date(1970 - 1900, 9, 05));
        Profile authorProfile2 = new Profile("Autor2", "Apellido2", new Date(1970 - 1900, 11, 21));
        Profile authorProfile3 = new Profile("Autor3", "Apellido3", new Date(1970 - 1900, 10, 31));
        Profile authorProfile4 = new Profile("Autor4", "Apellido4", new Date(1970 - 1900, 6, 16));
        Profile authorProfile5 = new Profile("Autor5", "Apellido5", new Date(1970 - 1900, 7, 18));
        Author autor1 = new Author(authorProfile1);
        Author autor2 = new Author(authorProfile2);
        Author autor3 = new Author(authorProfile3);
        Author autor4 = new Author(authorProfile4);
        Author autor5 = new Author(authorProfile5);
        AuthorRepository.addAuthor(autor1);
        AuthorRepository.addAuthor(autor2);
        AuthorRepository.addAuthor(autor3);
        AuthorRepository.addAuthor(autor4);
        AuthorRepository.addAuthor(autor5);

        Book libro1 = new Book("ISBN123", "Libro1", autor1, new Date(1911 - 1900, 1, 22), true);
        Book libro2 = new Book("ISBN234", "Libro2", autor2, new Date(2001 - 1900, 11, 13), true);
        Book libro3 = new Book("ISBN656", "Libro3", autor3, new Date(2022 - 1900, 03, 29), true);
        Book libro4 = new Book("ISBN954", "Libro4", autor4, new Date(2019 - 1900, 9, 19), true);
        Book libro5 = new Book("ISBN154", "Libro5", autor5, new Date(1973 - 1900, 8, 31), true);
        BookRepository.addBook(libro1);
        BookRepository.addBook(libro2);
        BookRepository.addBook(libro3);
        BookRepository.addBook(libro4);
        BookRepository.addBook(libro5);

        BookRepository.printAllBooks();
        ClientRepository.printAllClients();
        AuthorRepository.printAllAuthors();

        Transaction transaction = new Transaction();
        System.out.println("lets borrow 3 books");
        transaction.transaction("borrow", client5, libro5);
        transaction.transaction("borrow", client5, libro3);
        transaction.transaction("borrow", client5, libro2);
        ClientRepository.printClientBorrowedBooks(client5);
        System.out.println("returned book 5");
        transaction.transaction("return", client5, libro5);
        BookRepository.printAllBooks();
        ClientRepository.printClientBorrowedBooks(client5);

        TransactionRepository.printAllTransactions();

    }

}
