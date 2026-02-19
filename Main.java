//2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97.
// check: 2, 3, 5, 9, 16

// algarvu kontroll kuni ruutjuur x

// algarvu ring ei ole, kui
// sisaldab arve 0, 2, 4, 5, 6, 8
// kontrollid sisendit ennast, kui ta algab suurima numbriga
/*
 1. get max digit + location
 2. generate sets
 3. check prime for each item in set
 4. get max of each set, sorted
 5. output top 5 of max sorted
*/

public  class Main{
    public static void main(String[] args) {
        int num = 123;
        String numstr = String.valueOf(num);
        String maxdigit = get_maxdigit(numstr);

    }

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
    static int[] rotation(int num) {
        String numstr = String.valueOf(num);
        int[] set = new int[numstr.length()];

        for(int i = 0; i<numstr.length(); i++){
            String rotated = numstr.substring(i, numstr.length()) + numstr.substring(0, i);
            set[i] = Integer.parseInt(rotated);
        }
        return set;
    }

    static boolean get_isprime(int num) {
        if(num==1) return false;
        if(num==2) return true;
        if(num % 2 == 0 || num <= 0) return false;

        int limit = (int)(Math.sqrt(num));
        for(int i = 3; i <= limit; i+=2){
            if(num % i == 0){
                return false;
            }
        }
        
        return true;

    }
}