/***********************************
 * Programmeerimine II. LTAT.03.007
 * 2025/2026 kevadsemester
 *
 * Kodutöö nr 5b
 * Teema: Rekursioon
 *
 * Autor: Mihkel Matto
 * 
 **********************************/

import java.util.ArrayList;
import java.util.Arrays;

public class Kodu5b {
    public static void main(String[] args) {
        int[][] summad = summad(8);
        for(int[] rida : summad) System.out.println(Arrays.toString(rida));

        String[] a = {"kas", "mina"};
        String[] b = {"olen", "siin"};
        String[] c = sõnepõime(a, b);
        System.out.println(Arrays.toString(c));
    }

    /*
    Leiab etteantud positiivse n kõikvõimalikud lahutused 2, 4, 6 summadeks
    n - arv, mida summaks lahutatakse
    viimane - viimane lisatud arv
    rida - üks hulk, mille summa on n
    read - kõigi ridade hulk
    */
    static int[][] summad(int n){
        ArrayList<int[]> summad = new ArrayList<>();
        summad(n, 0, new int[0], summad);
        return summad.toArray(new int[summad.size()][]);
    }

    static void summad(int n, int viimane, int[] rida, ArrayList<int[]> read){
        if(n <= 0){
            if(n==0) read.add(rida);
            return;
        }
        if(n > 0){
            if(viimane != 2) summad(n-2, 2, add(rida, 2), read);
            if(viimane != 4) summad(n-4, 4, add(rida, 4), read);
            if(viimane != 6) summad(n-6, 6, add(rida, 6), read);
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

    a, b - sõnade hulk, millest lauseid moodustatakse
    ai, bi - indeksid a ja b jaoks
    lause - hetkel ehitatav lause
    laused - kõikide lausete hulk 
    */
    static String[] sõnepõime(String[] a, String[] b){
        ArrayList<String> lst = new ArrayList<>();
        sõnepõime(a, b, 0, 0, "", lst);
        return lst.toArray(new String[lst.size()]);
    }

    static void sõnepõime(String[] a, String[] b, int ai, int bi, String lause, ArrayList<String> laused){
        if(ai == a.length && bi == b.length){
            laused.add(lause.trim());
            return;
        }          
        if(ai < a.length){
            sõnepõime(a, b, ai + 1, bi, lause + " " + a[ai], laused);
        }
        if(bi < b.length){
            sõnepõime(a, b, ai, bi + 1, lause + " " + b[bi], laused);
        }
    }
}
