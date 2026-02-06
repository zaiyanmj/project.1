import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- ONLINE VOTING SYSTEM ---");
            System.out.println("1. Register");
            System.out.println("2. Vote");
            System.out.println("3. View Result");
            System.out.println("4. Exit");

            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Register.register();
                    break;
                case 2:
                    Vote.vote();
                    break;
                case 3:
                    Result.showResult();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
