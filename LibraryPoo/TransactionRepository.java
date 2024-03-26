import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class TransactionRepository {

        ///////////////////////////////////////////////////////////////////////
        private static ArrayList<Transaction> transactions = new ArrayList<>();
        ///////////////////////////////////////////////////////////////////////

        public static ArrayList<Transaction> getTransactions() {
                return transactions;
        }

        public static void setTransactions(ArrayList<Transaction> transactions) {
                TransactionRepository.transactions = transactions;
        }

        public static void addTransaction(Transaction transaction) {
                transactions.add(transaction);
        }

        public static void deleteTransactionByIndex(Transaction transaction, int index) {
                transactions.remove(index);
        }

        public static void transaction(String type, Client client, Book book) {
                if (type.equalsIgnoreCase("borrow"))
                        borrowABookByBook(client, book);
                if (type.equalsIgnoreCase("return"))
                        returnABookByBook(client, book);
        }

        public static void borrowABookByBook(Client client, Book book) {
                if (book.getIsAvailable() == true
                                && client.getBorrowedBooks().size() < 3
                                && BookRepository.getBooks().contains(book)
                                && BookRepository.checkAvailableBooks() == true) {

                        client.getBorrowedBooks().add(book);
                        book.setIsAvailable(false);
                        String id = generateUIDD();
                        Date date = new Date();
                        Transaction transaction = new Transaction(id, "Borrow", client, book, date);
                        TransactionRepository.addTransaction(transaction);
                        System.out.println("Transaction done");
                } else if (BookRepository.checkAvailableBooks() == false) {
                        System.out.println("Not Avaliable books");
                } else {
                        System.out.println("Something went wrong");
                }
        }

        public static void returnABookByBook(Client client, Book book) {
                if (client.getBorrowedBooks().contains(book) == true
                                && BookRepository.getBooks().contains(book)) {

                        book.setIsAvailable(true);
                        client.getBorrowedBooks().remove(book);
                        String id = generateUIDD();
                        Date date = new Date();
                        Transaction transaction = new Transaction(id, "Return", client, book, date);
                        TransactionRepository.addTransaction(transaction);
                        System.out.println("Transaction done");
                } else {
                        System.out.println("Something went wrong");
                }
        }

        public static String generateUIDD() {
                UUID uuid = UUID.randomUUID();
                String uuidAsString = uuid.toString();
                return uuidAsString;
        }

        public static void printTransactionsByClient(Client client) {
                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------\n");
                System.out.printf(
                                "|                                                       Transactios                                                     |\n");
                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------\n");
                System.out.printf("| %36s | %6s | %20s | %15s | %28s |\n", "ID", "Type", "Client", "Book",
                                "Date");
                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------\n");
                for (Transaction transaction : transactions) {
                        if (transaction.getClient().equals(client)) {
                                System.out.printf("| %36s | %6s | %20s | %15s | %28s |\n", transaction.getId(),
                                                transaction.getType(),
                                                transaction.getClient().getProfile().getName() + " "
                                                                + transaction.getClient().getProfile().getLastName(),
                                                transaction.getBook().getTitle(),
                                                transaction.getDate());
                        }

                }
                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------\n\n");
        }

        public static void printTransactionsByBook(Book book) {
                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------\n");
                System.out.printf(
                                "|                                                       Transactios                                                     |\n");
                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------\n");
                System.out.printf("| %36s | %6s | %20s | %15s | %28s |\n", "ID", "Type", "Client", "Book",
                                "Date");
                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------\n");
                for (Transaction transaction : transactions) {
                        if (transaction.getBook().equals(book)) {
                                System.out.printf("| %36s | %6s | %20s | %15s | %28s |\n", transaction.getId(),
                                                transaction.getType(),
                                                transaction.getClient().getProfile().getName() + " "
                                                                + transaction.getClient().getProfile().getLastName(),
                                                transaction.getBook().getTitle(),
                                                transaction.getDate());
                        }

                }
                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------\n\n");
        }

        public static void printAllTransactions() {
                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------\n");
                System.out.printf(
                                "|                                                       Transactios                                                     |\n");
                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------\n");
                System.out.printf("| %36s | %6s | %20s | %15s | %28s |\n", "ID", "Type", "Client", "Book",
                                "Date");
                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------\n");
                for (Transaction transaction : transactions) {
                        System.out.printf("| %36s | %6s | %20s | %15s | %28s |\n", transaction.getId(),
                                        transaction.getType(),
                                        transaction.getClient().getProfile().getName() + " "
                                                        + transaction.getClient().getProfile().getLastName(),
                                        transaction.getBook().getTitle(),
                                        transaction.getDate());
                }
                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------\n\n");
        }

        public static void printTransactionsByDate(Date before, Date after) {

                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------\n");
                System.out.printf(
                                "|                                                       Transactios                                                     |\n");
                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------\n");
                System.out.printf("| %36s | %6s | %20s | %15s | %28s |\n", "ID", "Type", "Client", "Book",
                                "Date");
                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------\n");
                for (Transaction transaction : transactions) {
                        if (transaction.getDate().after(after) && transaction.getDate().before(before)) {
                                System.out.printf("| %36s | %6s | %20s | %15s | %28s |\n", transaction.getId(),
                                                transaction.getType(),
                                                transaction.getClient().getProfile().getName() + " "
                                                                + transaction.getClient().getProfile().getLastName(),
                                                transaction.getBook().getTitle(),
                                                transaction.getDate());
                        } else {
                                System.out.println("none to show");
                        }
                }
                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------\n\n");
        }

}
