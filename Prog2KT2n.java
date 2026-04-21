import java.util.Arrays;

public class Prog2KT2n {
    public static void main(String[] args) {
        int[] a = {};
        int[] b = {};
        int[] c = addAll(a, b);
        System.out.println(Arrays.toString(c));
    }

    public static int[] korruta2ga(int[] a){
        return korruta2ga(a, 0, false);
    }
    public static int[] korruta2ga(int[] a, int i, boolean nullid){
        int[] uus = new int[1];
        if(a[i] == 0)

        if(i == a.length-1){
            return uus;
        }


        return uus;
    }

    static int[] addAll(int[] a, int[] b){
        int[] combined = new int[a.length + b.length];
        
        for(int i = 0; i<combined.length; i++){
            if(i<a.length) combined[i] = a[i];
            else combined[i] = b[i-a.length];
        }

        return combined;
    }
}