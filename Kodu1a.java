//2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97.
// check: 2, 3, 5, 9, 16

// algarvu kontroll kuni ruutjuur x

// algarvu ring ei ole, kui
// sisaldab arve 0, 2, 4, 5, 6, 8
// kontrollid sisendit ennast, kui ta algab suurima numbriga
/*
 1. sisend paaris > paaritu
 2. iga paaritu arvu ja rotatsioonide kontroll: test <= n, isprime, vastasel juhul katkestab ja võtab järgmise paaritu arvu
 3. kui algarvuringi max ei ole veel primesets listis, siis lisab sinna
*/

import java.util.ArrayList;
import java.util.Collections;

public class Kodu1a {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        algarvuRingid5Suurimat(1000000);
        algarvuRingideArv(1000000);
        long endTime = System.nanoTime();    // lõpp
        long duration = (endTime - startTime) / 1000; // kestus nanosekundites
        System.out.println(duration);
    }

    static void algarvuRingid5Suurimat(int n){
        ArrayList<Integer> primesets = getprimesets(n);
        Collections.sort(primesets, Collections.reverseOrder());
        // primesets.subList(5, primesets.size()).clear();
        System.out.printf("Antud lähtekoht: %d\n", n);
        for(int i=0; i < Math.min(5, primesets.size()); i++){
            System.out.println(primesets.get(i));
        }
        System.out.printf("Väiksemaid erinevaid algarvuringe: %d\n", algarvuRingideArv(n) - 5);
    }

    static int algarvuRingideArv(int n){
        ArrayList<Integer> primesets = getprimesets(n);
        int arv = primesets.size();
        return arv;
    }

    static ArrayList<Integer> getprimesets(int num){
        ArrayList<Integer> primesets = new ArrayList<>();

        // proovib kõiki paarituid arve vahemikus [10, num] ja salvestab maksimaalsed väärtused primesets listi
        if(num % 2 == 0) num-= 1; // paaris > paaritu
        for(int i = num; i > 9; i -= 2){
            int testnum = i;                                // kirjutan üle rotatsioonide ajal, i puhul vist teeks katki
            int numlen = (int)(Math.log10(testnum)) + 1;    // arg for rotate()
            int maxitem = 0;
            boolean validnum = true; // isprime() && i<=num

            // rotatsioonide testimine kuni üks arv ei sobi (validnum) või jõuab lõpuni
            for(int j = 0; j<numlen; j++){ // kas intervall on õige? #########
                if(testnum <= num && numval(testnum) &&isprime(testnum)){
                    if(testnum > maxitem) maxitem = testnum;
                    testnum = rotate(testnum, numlen); // roteerib 1x liiga palju
                }
                else{
                    validnum = false;
                    break;
                }
            }
            if(validnum && !primesets.contains(maxitem)) primesets.add(maxitem);
        }
        return primesets;
    }

    static boolean numval(int num){
        String numstr = String.valueOf(num);
        if(num % 3 == 0) return false;
        if(numstr.matches(".*[024568].*")) return false;
        return true;
    }

    static int rotate(int num, int numlength){ // length juhuks, kui num lõpeb nulliga
        int newstart = num % 10;
        int newend = num / 10;
        for(int i = 0; i < numlength-1; i++){
            newstart *= 10;
        }
        return newstart + newend;
    }

    static boolean isprime(int num){ // input > 9, is an odd number -- ei pruugi olla
        int limit = (int)(Math.sqrt(num));
        for(int i=2; i<=limit; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
