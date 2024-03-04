import java.util.Date;
import java.util.Scanner;

public class ClientController {
    Scanner sc = new Scanner(System.in);

    public void modifyClient() {
        System.out.print("Type the index: ");
        int index = sc.nextInt();
        System.out.print("Type name: ");
        String name = sc.nextLine();
        System.out.print("Type lastname: ");
        String lastname = sc.nextLine();
        System.out.print("Year: ");
        int year = sc.nextInt();
        System.out.print("Month: ");
        int month = sc.nextInt();
        System.out.print("Day: ");
        int day = sc.nextInt();
        sc.nextLine();
        @SuppressWarnings("deprecation")
        Date birthDay = new Date(year - 1900, month - 1, day);
        ClientRepository.modifyClient(index, name, lastname, birthDay);
    }

    public void deleteCient() {
        System.out.print("Type the index: ");
        int index = sc.nextInt();
        ClientRepository.deleteCient(index);
    }

}
