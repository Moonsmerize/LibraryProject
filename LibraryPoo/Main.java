public class Main {

    public static void main(String[] args) {

        Seeder.initialize();
        byte option = 0;

        do {
            System.out.println(
                    "\nType 1 for books menu\nType 2 for clients menu\nType 3 for authors menu\nType 4 for transactions menu\nType 0 to exit");
            option = AskData.askOption();
            switch (option) {
                case 1:
                    BookController bookController = new BookController();
                    bookController.booksMenu();
                    break;
                case 2:
                    ClientController clientController = new ClientController();
                    clientController.clientsMenu();
                    break;
                case 3:
                    AuthorController authorController = new AuthorController();
                    authorController.authorsMenu();
                    break;
                case 4:
                    TransactionController transactionController = new TransactionController();
                    transactionController.transactionsMenu();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (option != 0);

    }
}
