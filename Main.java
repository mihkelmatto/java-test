public class Main {
    public static void main(String[] args) {
        String x1 = "123";
        String x2 = "456";
        x1 = String.join(",", x1, x2);
        System.out.println(x1.codePointAt(2));
    }
}
