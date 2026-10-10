import java.util.Scanner;

public class Problem8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int m = sc.nextInt();
            char g;
            if (m >= 90) g = 'A';
            else if (m >= 75) g = 'B';
            else if (m >= 60) g = 'C';
            else if (m >= 40) g = 'D';
            else g = 'F';
            System.out.println("Grade " + g);
        }
    }
}