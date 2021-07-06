import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to get its prime factors: ");
        int num = sc.nextInt();
        ArrayList<Integer> factors = primeFactor(num);
        System.out.println(factors);
    }

    public static int[] getPrimes(int max) {
        boolean[] A = new boolean[max + 1];
        Arrays.fill(A, true);
        A[0] = false;
        A[1] = false;

        for (int p = 2; p * p <= max; ++p) {
            if (A[p]) {
                for (int i = p * p; i <= max; i += p) {
                    A[i] = false;
                }
            }
        }

        int[] primes = new int[countTrue(A)];
        int j = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i]) {
                primes[j] = i;
                ++j;
            }
        }

        return primes;
    }

    public static int countTrue(boolean[] A) {
        int count = 0;
        for (boolean b : A) {
            if (b)
                ++count;
        }
        return count;
    }

    public static ArrayList<Integer> primeFactor(int num) {
        ArrayList<Integer> alFactors = new ArrayList<>();
        int[] primes = getPrimes(num);
        int workingNum = num;

        int i = 0;

        while (primes[i] <= Math.sqrt(num)) {
            if (isPrime(workingNum)) {
                alFactors.add(workingNum);
                break;
            }
            if (workingNum % primes[i] == 0) {
                workingNum /= primes[i];
                alFactors.add(primes[i]);
//                System.out.printf("Working %d\nPrime %d\n", workingNum, primes[i]);
            } else
                ++i;
        }


        return alFactors;
    }

    public static boolean isPrime(int n) {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        long sqrtN = (long)Math.sqrt(n)+1;
        for(long i = 6L; i <= sqrtN; i += 6) {
            if(n%(i-1) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    }

}
