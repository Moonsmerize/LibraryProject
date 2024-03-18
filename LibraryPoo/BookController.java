
import java.util.Date;
import java.util.Scanner;

public class BookController {

    Scanner sc = new Scanner(System.in);

    public void createBook() {
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
        BookRepository.printAllBooks();
    }

}
