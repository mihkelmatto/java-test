import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        arv(2, "0");
    }

    static void arv(int n, String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        arv(n-1, str + "0");
        arv(n-1, str + "1");
    }
}
