import java.util.ArrayList;

public class AuthorRepository {

        private static ArrayList<Author> authors = new ArrayList<>();

        public static void addAuthor(Author author) {
                authors.add(author);
        }

        public static void deleteAuthor(int index) {
                authors.remove(index);
        }

        public static void printAllAuthors() {
                System.out.printf(
                                "----------------------------------------------------------------------\n");
                System.out.printf(
                                "                                  Authors                             \n");
                System.out.printf(
                                "----------------------------------------------------------------------\n");
                System.out.printf("| %18s | %20s | %8s |\n", "Name", "Last name", "Birthday");
                System.out.printf(
                                "----------------------------------------------------------------------\n");
                for (Author author : authors) {
                        System.out.printf("| %18s | %20s | %8s |\n", author.getProfile().getName(),
                                        author.getProfile().getLastName(),
                                        Formatter.Formatt(author.getProfile().getBirthdate()));
                }
                System.out.printf(
                                "----------------------------------------------------------------------\n");
        }

        public static ArrayList<Author> getAuthors() {
                return authors;
        }

        public static void setAuthors(ArrayList<Author> authors) {
                AuthorRepository.authors = authors;
        }

        public static Author getAuthorByIndex(int index) {
            return authors.get(index);             
        }

        
}
