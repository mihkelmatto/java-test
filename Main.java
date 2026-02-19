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

public  class Main{
    public static void main(String[] args) {
        int input = 1000;
        ArrayList<Integer> primesets = new ArrayList<>();

        // generate prime sets
        int[] testset;
        for(int i = input; i>9; i--){
            if(numval(i)){
                testset = rotation(i);
                int max = 0;
                for(int j = 0; j < testset.length; j++){
                    if(testset[j] > max) max=testset[j];
            }
            if(max <= input && !primesets.contains(max) && get_isprime(testset)) primesets.add(max);
            }
            
        }
        primesets.subList(5, primesets.size()).clear();
        System.out.println(primesets);
    }

    static boolean numval(int num){
        String numstr = String.valueOf(num);
        for(int i = 0; i < numstr.length(); i++){
            if(numstr.matches(".*[024568].*")){
                return false;
            }
        }
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
            
            if(num==1) return false;
            if(num==2) return true;
            if(num % 2 == 0 || num <= 0) return false;

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