import java.util.ArrayList;

public class BookRepository {

        private static ArrayList<Book> books = new ArrayList<>();

        public static void addBook(Book book) {
                books.add(book);
        }

        public static void deleteBookByIndex(int index) {
                if (getBookByIndex(index).getIsAvailable() == true) {
                        books.remove(index);
                } else {
                        System.out.println("Can't delete this book");
                }
        }

        public static Book getBookByIndex(int index) {
                return books.get(index);
        }

        public static void printAllBooks() {
                System.out.printf(
                                "---------------------------------------------------------------------------------------------------\n");
                System.out.printf(
                                "|                                          BOOKS                                                  |\n");
                System.out.printf(
                                "---------------------------------------------------------------------------------------------------\n");
                System.out.printf("| %18s | %20s | %20s | %15s | %10s |\n", "ISBN", "TITLE", "AUTHOR", "PUBLISH DATE",
                                "AVAILABLE");
                System.out.printf(
                                "---------------------------------------------------------------------------------------------------\n");
                for (Book book : books) {
                        System.out.printf("| %18s | %20s | %20s | %15s | %10s |\n", book.getIsbn(), book.getTitle(),
                                        book.getAuthor().getProfile().getName() + " "
                                                        + book.getAuthor().getProfile().getLastName(),
                                        Formatter.Formatt(book.getPublishDate()), book.getIsAvailable());
                }
                System.out.printf(
                                "---------------------------------------------------------------------------------------------------\n\n");
        }

        public static void printAvailableBooks() {
                System.out.printf(
                                "---------------------------------------------------------------------------------------------------\n");
                System.out.printf(
                                "                                           BOOKS                                           \n");
                System.out.printf(
                                "---------------------------------------------------------------------------------------------------\n");
                System.out.printf("| %18s | %20s | %20s | %15s | %10s |\n", "ISBN", "TITLE", "AUTHOR", "PUBLISH DATE",
                                "AVAILABLE");
                System.out.printf(
                                "---------------------------------------------------------------------------------------------------\n");
                for (Book book : books) {
                        if (book.getIsAvailable() == true) {
                                System.out.printf("| %18s | %20s | %20s | %15s | %10s |\n", book.getIsbn(),
                                                book.getTitle(),
                                                book.getAuthor().getProfile().getName() + " "
                                                                + book.getAuthor().getProfile().getLastName(),
                                                Formatter.Formatt(book.getPublishDate()), book.getIsAvailable());
                        }
                }
                System.out.printf(
                                "---------------------------------------------------------------------------------------------------\n");
        }

        public static void printBorrowedBooks() {
                System.out.printf(
                                "---------------------------------------------------------------------------------------------------\n");
                System.out.printf(
                                "                                           BOOKS                                           \n");
                System.out.printf(
                                "---------------------------------------------------------------------------------------------------\n");
                System.out.printf("| %18s | %20s | %20s | %15s | %10s |\n", "ISBN", "TITLE", "AUTHOR", "PUBLISH DATE",
                                "AVAILABLE");
                System.out.printf(
                                "---------------------------------------------------------------------------------------------------\n");
                for (Book book : books) {
                        if (book.getIsAvailable() == false) {
                                System.out.printf("| %18s | %20s | %20s | %15s | %10s |\n", book.getIsbn(),
                                                book.getTitle(),
                                                book.getAuthor().getProfile().getName() + " "
                                                                + book.getAuthor().getProfile().getLastName(),
                                                Formatter.Formatt(book.getPublishDate()), book.getIsAvailable());
                        }
                }
                System.out.printf(
                                "---------------------------------------------------------------------------------------------------\n");
        }

        public static ArrayList<Book> getBooks() {
                return books;
        }

        public static void setBooks(ArrayList<Book> books) {
                BookRepository.books = books;
        }
}
