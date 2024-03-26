import java.util.Date;

public class TransactionController {

    public void transactionsMenu() {
        System.out.println(
                "\nType 1 to borrow a book\nType 2 to return a book\nType 3 to print transactions\n");
        Byte option = AskData.askOption();
        switch (option) {
            case 1:
                this.borrowABook();
                break;
            case 2:
                this.retrurnABook();
                break;
            case 3:
                this.printTransactions();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    public void printTransactions() {
        int index;
        Byte option = 0;
        System.out.println(
                "\nType 1 to print transactions by range\nType 2 to print transactions by client\nType 3 to print transactions by book\nType 4 to print all transactions\n");
        option = AskData.askOption();
        switch (option) {
            case 1:
                Date date1 = AskData.askDate();
                Date date2 = AskData.askDate();
                TransactionRepository.printTransactionsByDate(date1, date2);
                break;
            case 2:
                ClientRepository.printAllClients();
                index = AskData.askIndex();
                TransactionRepository.printTransactionsByClient(ClientRepository.getClientByIndex(index));
                break;
            case 3:
                BookRepository.printAllBooks();
                index = AskData.askIndex();
                TransactionRepository.printTransactionsByBook(BookRepository.getBookByIndex(index));
                break;
            case 4:
                TransactionRepository.printAllTransactions();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }

    }

    public void borrowABook() {
        BookRepository.printAvailableBooks();
        AskData.bufferCleaner();
        String isbn = AskData.askIsbn();
        ClientRepository.printAvailableClients();
        String name = AskData.askName();
        String lastname = AskData.askLastname();
        Book book = BookRepository.getBookByIsbn(isbn);
        Client client = ClientRepository.getClientByNameAndLastname(name, lastname);
        TransactionRepository.borrowABookByBook(client, book);
    }

    public void retrurnABook() {
        BookRepository.printBorrowedBooks();
        AskData.bufferCleaner();
        String isbn = AskData.askIsbn();
        ClientRepository.printAvailableClients();
        String name = AskData.askName();
        String lastname = AskData.askLastname();
        Book book = BookRepository.getBookByIsbn(isbn);
        Client client = ClientRepository.getClientByNameAndLastname(name, lastname);
        TransactionRepository.returnABookByBook(client, book);
    }

}
