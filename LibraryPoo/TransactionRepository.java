import java.util.ArrayList;
import java.util.Date;

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
                System.out.printf("| %36s | %6s | %20s | %15s | %28s |\n", transaction.getId(), transaction.getType(),
                        transaction.getClient().getProfile().getName() + " "
                                + transaction.getClient().getProfile().getLastName(),
                        transaction.getBook().getTitle(),
                        transaction.getDate());
            } else {

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
            System.out.printf("| %36s | %6s | %20s | %15s | %28s |\n", transaction.getId(), transaction.getType(),
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
                System.out.printf("| %36s | %6s | %20s | %15s | %28s |\n", transaction.getId(), transaction.getType(),
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
