import java.util.ArrayList;
import java.util.Arrays;

public class Kodu5b {
    public static void main(String[] args) {
        int[][] summad = summad(8);
        for(int[] rida : summad) System.out.println(Arrays.toString(rida));
    }

    /*
    Leida etteantud positiivse n kõikvõimalikud lahutused 2, 4, 6 summadeks
    - ei või olla kahte ühesugust arvu järjest
    - summad on erinevad kui järjekord on erinev

    nt: n = 8
    [[2, 4, 2], [2, 6], [6, 2]]
    pole lubatud: [2, 2, 2, 2], [2, 2, 4], [4, 2, 2], [4, 4]



     */
    static int[][] summad(int n){
        ArrayList<int[]> summad = new ArrayList<>();
        summad(n, 0, new int[0], summad);
        return summad.toArray(new int[summad.size()][]);
    }


    static void summad(int n, int viimanenr, String arvurida, ArrayList<String> arvuread){
        if(n <= 0){
            if(n==0) arvuread.add(arvurida);
            return;
        }
        if(n > 0){
            if(viimanenr != 2) summad(n-2, 2, arvurida + 2 + ", ", arvuread);
            if(viimanenr != 4) summad(n-4, 4, arvurida + 4 + ", ", arvuread);
            if(viimanenr != 6) summad(n-6, 6, arvurida + 6 + ", ", arvuread);
        }
    }

    static void summad(int n, int viimanenr, int[] arvurida, ArrayList<int[]> arvuread){
        if(n <= 0){
            if(n==0) arvuread.add(arvurida);
            return;
        }
        if(n > 0){
            if(viimanenr != 2) summad(n-2, 2, add(arvurida, 2), arvuread);
            if(viimanenr != 4) summad(n-4, 4, add(arvurida, 2), arvuread);
            if(viimanenr != 6) summad(n-6, 6, add(arvurida, 2), arvuread);
        }
    }

    static int[] add(int[] a, int n){
        int[] arr = new int[a.length + 1];
        int i = 0;
        for(int item : a) arr[i++] = item;
        arr[i++] = n;
        return arr;
    }



    /*
    Tagastab kõik laused, mis sisaldavad kõiki a ja b sõnu
    - kõik sõnad peab ära kasutama
    - sõna järjestus oma hulga suhtes peab säilima
    - sisendis on vähemalt 1-pikkusega arrayd
    */
    static String[] sõnepõime(String[] a, String[] b){
        return null;
    }
}
