public class Main {
    public static void main(String[] args) {
        int sum = add(1, 2, 3, 4, 5);
        System.out.println(sum);

    }
    static int add(int... numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
