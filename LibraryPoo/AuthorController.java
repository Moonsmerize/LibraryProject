
import java.util.Date;
import java.util.Scanner;

public class AuthorController {

    Scanner sc = new Scanner(System.in);

    public void createAuthor() {
        String name = AskData.askName();
        String lastname = AskData.askLastname();
        Date birthDay = AskData.askDate();
        Profile profile = new Profile(name, lastname, birthDay);
        Author author = new Author(profile);
        AuthorRepository.addAuthor(author);
    }

    public void deleteAuthor() {
        int index = AskData.askIndex();
        AuthorRepository.deleteAuthor(index);
    }

    public void modifyAuthorByIndex() {
        String name = AskData.askName();
        String lastname = AskData.askLastname();
        Date birthDay = AskData.askDate();
        Profile profile = new Profile(name, lastname, birthDay);
        Author author = new Author(profile);
        AuthorRepository.addAuthor(author);
    }

    public void printAllAuthors() {
        AuthorRepository.printAllAuthors();
    }

}
