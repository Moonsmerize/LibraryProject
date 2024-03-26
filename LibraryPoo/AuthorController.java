
import java.util.Date;
import java.util.Scanner;

public class AuthorController {

    Scanner sc = new Scanner(System.in);

    public void createAuthor() {
        AskData.bufferCleaner();
        String name = AskData.askName();
        String lastname = AskData.askLastname();
        Date birthDay = AskData.askDate();
        Profile profile = new Profile(name, lastname, birthDay);
        Author author = new Author(profile);
        AuthorRepository.addAuthor(author);
    }

    public void deleteAuthorByIndex() {
        int index = AskData.askIndex();
        AuthorRepository.deleteAuthor(index);
    }

    public void modifyAuthorByIndex(int index) {
        String name = AskData.askName();
        String lastname = AskData.askLastname();
        Date birthDay = AskData.askDate();
        Profile profile = new Profile(name, lastname, birthDay);
        AuthorRepository.getAuthorByIndex(index).setProfile(profile);
    }

    public void printAuthors() {
        byte option = 0;
        System.out.print("\nType 1 to print all authors\nType 2 to print author's books");
        option = sc.nextByte();
        switch (option) {
            case 1:
                AuthorRepository.printAllAuthors();
                break;
            case 2:
                BookRepository.printAvailableBooks();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    public void authorsMenu() {
        Byte option = 0;
        System.out.println(
                "\nType 1 to create an author\nType 2 to print authors\nType 3 to modify a book\nType 4 to delete an author");
        option = AskData.askOption();
        switch (option) {
            case 1:
                this.createAuthor();
                break;
            case 2:
                this.printAuthors();
                break;
            case 3:
                AuthorRepository.printAllAuthors();
                int index = AskData.askIndex();
                this.modifyAuthorByIndex(index);
                break;
            case 4:
                this.deleteAuthorByIndex();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

}
