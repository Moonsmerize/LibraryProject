import java.util.ArrayList;

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

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void deleteTransactionByIndex(Transaction transaction, int index){
        transactions.remove(index);
    }

}
