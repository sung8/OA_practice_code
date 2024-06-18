package recursion_basic;

public class Fibonacci {
    public static int fib(int num) {
        // base
        if (num == 0)
            return 0;
        else if (num == 1)
            return 1;
        else
            return fib(num - 1) + fib(num - 2);
    }

    public static void main(String[] args) {
        System.out.println(fib(7));
    }
}
