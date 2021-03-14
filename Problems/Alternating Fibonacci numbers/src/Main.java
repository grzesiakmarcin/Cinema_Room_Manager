import java.util.Scanner;

public class Main {

    public static long fib(long n) {

        long ans = fibonacci(n);
        if (n % 2 == 0) {
            ans = ans * -1;
            return (ans);
        } else
            return (ans);


    }

    public static long fibonacci(long n) {
        if (n <= 1) {return n;}

        return fibonacci(n - 2) + fibonacci(n - 1);
    }


    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fib(n));
    }

}