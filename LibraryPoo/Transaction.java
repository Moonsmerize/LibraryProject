import java.util.Date;
import java.util.UUID;

public class Transaction {

    ///////////////////////////////
    private String id;
    private String type;
    private Client client;
    private Book book;
    private Date date;
    ///////////////////////////////

    public Transaction(String id, String type, Client client, Book book, Date date) {
        this.id = id;
        this.type = type;
        this.client = client;
        this.book = book;
        this.date = date;
    }

    public Transaction() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void transaction(String type, Client client, Book book) {
        if (type.equalsIgnoreCase("borrow"))
            this.borrowABookByBook(client, book);
        if (type.equalsIgnoreCase("return"))
            this.returnABookByBook(client, book);
    }

    public static String generateUIDD() {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        return uuidAsString;
    }

    public void borrowABookByBook(Client client, Book book) {
        if (book.getIsAvailable() == true && client.getBorrowedBooks().size() < 3
                && BookRepository.getBooks().contains(book)) {
            client.getBorrowedBooks().add(book);
            book.setIsAvailable(false);
            String id = generateUIDD();
            Date date = new Date();
            Transaction transaction = new Transaction(id, "Borrow", client, book, date);
            TransactionRepository.addTransaction(transaction);
        } else {
            System.out.println("Cant borrow this book");
        }
    }

    public void borrowABookByIndex(Client client, int index) {
        if (BookRepository.getBookByIndex(index).getIsAvailable() == true && client.getBorrowedBooks().size() < 3) {
            client.getBorrowedBooks().add(BookRepository.getBookByIndex(index));
            BookRepository.getBookByIndex(index).setIsAvailable(false);
            String id = generateUIDD();
            Date date = new Date();
            Transaction transaction = new Transaction(id, "Borrow", client, BookRepository.getBookByIndex(index), date);
            TransactionRepository.addTransaction(transaction);
        } else {
            System.out.println("Cant borrow this book");
        }
    }

    public void returnABookByIndex(int index, Client client) {
        if (client.getBorrowedBooks().contains(BookRepository.getBookByIndex(index))) {
            client.getBorrowedBooks().remove(BookRepository.getBookByIndex(index));
            BookRepository.getBookByIndex(index).setIsAvailable(false);
            String id = generateUIDD();
            Date date = new Date();
            Transaction transaction = new Transaction(id, "Return", client, BookRepository.getBookByIndex(index), date);
            TransactionRepository.addTransaction(transaction);
        }

    }

    public void returnABookByBook(Client client, Book book) {
        if (client.getBorrowedBooks().contains(book) == true) {
            book.setIsAvailable(true);
            client.getBorrowedBooks().remove(book);
            String id = generateUIDD();
            Date date = new Date();
            Transaction transaction = new Transaction(id, "Return", client, book, date);
            TransactionRepository.addTransaction(transaction);
        } else {
            System.out.println("Can't return that book");
        }
    }

}
