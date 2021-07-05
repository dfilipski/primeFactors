import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to get its prime factors: ");
        int num = sc.nextInt();
        int[] factors = primeFactor(num);
        System.out.println(Arrays.toString(factors));
    }

    public static int[] primeFactor(int num) {
        int[] factors = new int[1024];

        return factors;
    }
}
