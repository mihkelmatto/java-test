public class Test {
    public static void main(String[] args) {
        
    }

    public static void ul62a(int n){
        ul62a(n, "");
    }

    public static void ul62a(int n, String vektor){
        if(n == 0){
            System.out.println(vektor);
            return;
        }

        ul62a(n-1, vektor + "0");
        ul62a(n-1, vektor + "1");
    }
}