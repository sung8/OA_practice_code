package recursion_basic;

public class HelloWorldRecur {
    private static void printRecur(int n) {
        // base
        if (n > 0) {
            System.out.println("Hello World");
            printRecur(n - 1);
        }
    }

    public static void printRecur(String str, int index) {
        if (index < str.length()) {
            System.out.print(str.charAt(index));
            printRecur(str, index + 1);
        }
    }

    public static void main(String[] args) {
        printRecur(3);
        printRecur("hello there", 0);
    }
}
