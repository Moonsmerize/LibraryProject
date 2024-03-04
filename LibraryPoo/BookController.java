import java.util.Date;
import java.util.Scanner;

public class BookController {
    
    Scanner sc = new Scanner(System.in);   

    public void createBook() {
        System.out.print("Type de isbn: ");
        String isbn = sc.nextLine();
        System.out.print("Type de title: ");
        String title = sc.nextLine();
        AuthorRepository.printAllAuthors();
        System.out.println("Author's index");
        int index = sc.nextInt();
        System.out.print("Is available?: ");
        Boolean isAvailable = sc.nextBoolean();
        System.out.print("year: ");
        int year = sc.nextInt();
        System.out.print("Month: ");
        int month = sc.nextInt();
        System.out.print("Day: ");
        int day = sc.nextInt();
        sc.nextLine();
        @SuppressWarnings("deprecation")
        Date publishDate = new Date(year - 1900, month - 1, day);
        Book book = new Book(isbn, title, AuthorRepository.getAuthorByIndex(index), publishDate, isAvailable);
        BookRepository.addBook(book);
    }

}
