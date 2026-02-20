//2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97.
// check: 2, 3, 5, 9, 16

// algarvu kontroll kuni ruutjuur x

// algarvu ring ei ole, kui
// sisaldab arve 0, 2, 4, 5, 6, 8
// kontrollid sisendit ennast, kui ta algab suurima numbriga
/*
 1. get max nr
 2. generate sets
 3. check prime for each item in set
 4. get max of each set, sorted
 5. output top 5 of max sorted

 !! max nr of prime sets > primesets[x]
*/
import java.util.ArrayList;
import java.util.Collections;

public  class Kodu1av1{
    public static void main(String[] args) {
        int input = 1000000;
        algarvuRingid5Suurimat(input);
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

    static ArrayList<Integer> getprimesets(int n){
        ArrayList<Integer> primesets = new ArrayList<>();

        // generate prime sets
        if(n%2 ==0) n-= 1; // paaris > paaritu
        for(int i = n; i>9; i-=2){
            if(numval(i)){
                int[] testset = rotation(i);
                int max = 0;
                for(int j = 0; j < testset.length; j++){
                    if(testset[j] > max) max=testset[j];
                }
                if(max <= n && !primesets.contains(max) && get_isprime(testset)) primesets.add(max);
            }
        }
        return primesets;
    }

    static boolean numval(int num){
        String numstr = String.valueOf(num);
        if(num % 3 == 0) return false;
        if(numstr.matches(".*[024568].*")) return false;
        return true;
    }


    static int[] rotation(int num) {
        String numstr = String.valueOf(num);
        int[] set = new int[numstr.length()];

        for(int i = 0; i<numstr.length(); i++){
            String rotated = numstr.substring(i, numstr.length()) + numstr.substring(0, i);
            set[i] = Integer.parseInt(rotated);
        }
        return set;
    }

    static boolean get_isprime(int[] set) {
        for(int i = 0; i<set.length; i++){
            int num = set[i];
            // ei kontrolli num==1, num==2, num%2 ja num<=0, sest see on mujal kontrollitud
            int limit = (int)(Math.sqrt(num));
            for(int j = 3; j <= limit; j+=2){
                if(num % j == 0){
                    return false;
                }
            }
        }
        return true;
    }
}