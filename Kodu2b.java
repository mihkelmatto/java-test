// input int[n][n] kus n <= 3000
// output int[] kus on iga korduv arv kasvavas järjestuses, korduste arv korda

/*
[[2, 2, 1, 4],
 [4, 1, 2, 2],
 [7, 1, 2, 2],
 [2, 10, 2, 1]] >> outputs >> [1, 2, 2]
*/

// salvestada arvud i ja j, mis hoiavad indekseid meeles
// võrreldes rida1[i] ja rida2[j] ja iga kordusega ++ siis:
//  if(i == j): ans.add()
//  if(i != j): väiksem indeks -= 1
// 
// või siis iga kordusega i ja j väiksemaks ja tingimused pahupidi
// O(2n) + radix keerukus


// saaks ka mingi counting sort laadse asja abil teha??



// 1 2 2 2 5 5 6
// 1 2 2 4 5 6 6
// 1 2 2 3 4 5 5
// 1 2 2 3 4 5 5

// 2 2 5 6 7
// 2 4 5 6 6


// 120 312 589 19 38 52 

// 120 312 52 38 589 19
// 312 19 120 38 52 589
// 19 38 52 120 312 589

// 1 2 2 3 4 5 5
// 1 2 2 3 4 5 5


// iga rea kohta loed kokku arvu esinemise
// salvestatakse arv:min(value, newvalue)

import java.util.ArrayList;
import java.util.Arrays;

public class Kodu2b {

    public static int[] korduvadRidades(int[][] a) {
        for(int i = 0; i < a.length; i++){
            Arrays.sort(a[i]);
        }

        int[] ans = new int[a.length];
        int ansindex


        System.out.println(ans);
        return null;
    }

    public static void main(String[] args) {
        int[][] a = {
                {2, 2, 1, 4},
                {4, 1, 2, 2},
                {7, 1, 2, 2},
                {2, 10, 2, 1}
        };

        korduvadRidades(a);
    }

}
