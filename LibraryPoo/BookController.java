import java.util.Date;

public class BookController {

    public void createBook() {
        AskData.bufferCleaner();
        String isbn = AskData.askIsbn();
        String title = AskData.title();
        AuthorRepository.printAllAuthors();
        int index = AskData.askIndex();
        Date publishDate = AskData.askDate();
        boolean isAvailable = AskData.askIsAvailable();
        Book book = new Book(isbn, title, AuthorRepository.getAuthorByIndex(index), publishDate, isAvailable);
        AuthorRepository.getAuthorByIndex(index).addBookToAuthor(book, index);
        BookRepository.addBook(book);
    }

    public void deleteBookByIndex() {
        int index = AskData.askIndex();
        BookRepository.deleteBookByIndex(index);
    }

    public void modifyBookByIndex() {
        int index = AskData.askIndex();
        BookRepository.deleteBookByIndex(index);
    }

    public void printBooks() {
        byte option = 0;
        System.out
                .println(
                        "\nType 1 to print all books\nType 2 to print available books\nType 3 to print borrowed books");
        option = AskData.askOption();
        switch (option) {
            case 1:
                BookRepository.printAllBooks();
                break;
            case 2:
                BookRepository.printAvailableBooks();
                break;
            case 3:
                BookRepository.printBorrowedBooks();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    public void booksMenu() {
        Byte option = 0;
        System.out.println(
                "\nType 1 to create a book\nType 2 to print books\nType 3 to modify a book\nType 4 to delete a book");
        option = AskData.askOption();
        switch (option) {
            case 1:
                this.createBook();
                break;
            case 2:
                this.printBooks();
                break;
            case 3:
                this.modifyBookByIndex();
                break;
            case 4:
                this.deleteBookByIndex();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }
}
