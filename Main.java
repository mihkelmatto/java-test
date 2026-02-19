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
        int num = 106;
        int maxnum = get_maxnum(num);
        ArrayList<Integer> primesets = new ArrayList<>();

        // generate prime sets
        int[] testset;
        int testmax;
        for(int i = maxnum; i>9; i--){
            testmax = get_maxnum(i);
            if(testmax <= num){
                testset = rotation(i);
                if(get_isprime(testset)) primesets.add(testset[0]); // 0 as max index?
            }
        }
        // print
        // sort: duplicates, rotated versions
        System.out.println(primesets);
    }
    static int get_maxnum(int num){
        String numstr = String.valueOf(num);
        int maxdigit = 0;
        int maxindex = 0;
            for(int i = 0; i < numstr.length(); i++){
                int digit = Character.getNumericValue(numstr.charAt(i));
                if(digit>maxdigit){
                    maxdigit = digit;
                    maxindex = i;
                } 
            }
    return Integer.parseInt(numstr.substring(maxindex, numstr.length()) + numstr.substring(0, maxindex));
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



/* 
    static String get_maxdigit(String numstr){
        int maxdigit = 0;
        for(int i = 0; i < numstr.length(); i++){
            int digit = Character.getNumericValue(numstr.charAt(i));
            if(digit>maxdigit){
                maxdigit = digit;
            } 
        }
        return String.valueOf(maxdigit);
    }
*/