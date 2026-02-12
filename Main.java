public class Main {
    public static void main(String[] args) {
        String name = "Tim";
        char firstletter = name.charAt(0);
        int age = 20;
        double height = 20.3;

        System.out.printf("Hello, %s.\nYour name starts with a %c.\n", name, firstletter);
        System.out.printf("You are %d years old and about %.0f meters tall", age, height);
    }
}
