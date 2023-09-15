import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x, y, z;
        char directionInPlane;

        System.out.print("Enter initial coordinates in order (x, y, z): ");
        x = scanner.nextInt();
        y = scanner.nextInt();
        z = scanner.nextInt();

        System.out.print("\nEnter Initial Direction (N, S, E, W): ");
        directionInPlane = scanner.next().charAt(0);

        Chandrayan satellite = new Chandrayan(x, y, z, directionInPlane);

        char[] commands = {'f', 'r', 'u', 'b', 'l'};

        for (int i = 0; i < 5; i++) {
            switch (commands[i]) {
                case 'f':
                case 'b':
                    satellite.move(commands[i]);
                    satellite.printLocAndDir();
                    break;
                default:
                    satellite.turn(commands[i]);
                    satellite.printLocAndDir();
                    break;
            }
        }

        scanner.close();
    }
}
