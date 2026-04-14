import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> vektorid = v2(3);
        System.out.println(vektorid);
    }

    static void ul62a(int n){
        ul62a(n, "");
    }

    static void ul62a(int n, String vektor){
        if(n == 0){
            System.out.println(vektor);
            return;
        }

        ul62a(n-1, vektor + "0");
        ul62a(n-1, vektor + "1");
    }

    static ArrayList<String> v2(int n){
        return v2(n, "");
    }
    
    static ArrayList<String> v2(int n, String vektor){
        ArrayList<String> vektorid = new ArrayList<>();

        if(n==0){
            vektorid.add(vektor);
            return vektorid;
        }

        vektorid.addAll(v2(n-1, vektor + "0"));
        vektorid.addAll(v2(n-1, vektor + "1"));
        
        return vektorid;
    }

    static int rem(int x, int y){
        if(x < y) return x; // baasjuht

        else return rem(x-y, y);
    }

/*
    static String v2(int n){
        return v2(n, "");
    }

    static String v2(int n, String vektor){
        ArrayList<String> vektorid = new ArrayList<>();

        if(n == 0) return vektor;

        String s1 = v2(n-1, vektor + "0");
        String s2 = v2(n-1, vektor + "1");

    }
*/
}