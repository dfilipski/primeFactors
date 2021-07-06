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

    public static int[] getPrimes(int max) {
        boolean[] A = new boolean[max + 1];
        Arrays.fill(A, true);
        A[0] = false;
        A[1] = false;

        for (int p = 2; p * p <= max; ++p) {
            if (A[p] == true) {
                for (int i = p * p; i <= max; i += p) {
                    A[i] = false;
                }
            }
        }

        int[] primes = new int[countTrue(A)];
        int j = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] == true) {
                primes[j] = i;
                ++j;
            }
        }

        return primes;
    }

    public static int countTrue(boolean[] A) {
        int count = 0;
        for (boolean b : A) {
            if (b == true)
                ++count;
        }
        return count;
    }

    public static int[] primeFactor(int num) {
        int[] factors = new int[num];
        int[] primes = getPrimes(num);

        return factors;
    }
}
