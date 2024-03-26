import java.util.Date;
import java.util.Scanner;

public class AskData {

    static Scanner sc = new Scanner(System.in);

    public static String askName() {
        System.out.print("Type the name: ");
        String name = sc.nextLine();
        return name;
    }

    public static String askLastname() {
        System.out.print("Type the lastname: ");
        String lastname = sc.nextLine();
        return lastname;
    }

    public static byte askOption() {
        System.out.print("Type the option: ");
        byte option = sc.nextByte();
        return option;
    }

    public static void bufferCleaner() {
        sc.nextLine();
    }

    public static String askIsbn() {
        System.out.print("Type the isbn: ");
        String isbn = sc.nextLine();
        return isbn;
    }

    public static boolean askIsAvailable() {
        System.out.print("Is available?: ");
        boolean isAvailable = sc.nextBoolean();
        return isAvailable;
    }

    public static Date askDate() {
        System.out.print("year: ");
        int year = sc.nextInt();
        System.out.print("Month: ");
        int month = sc.nextInt();
        System.out.print("Day: ");
        int day = sc.nextInt();
        @SuppressWarnings("deprecation")
        Date publishDate = new Date(year - 1900, month - 1, day);
        return publishDate;
    }

    public static String title() {
        System.out.print("Type the title: ");
        String title = sc.nextLine();
        return title;
    }

    public static int askIndex() {
        System.out.print("Type the index: ");
        int index = sc.nextInt();
        return index;
    }

}
