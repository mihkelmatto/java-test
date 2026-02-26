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

import java.util.ArrayList;
import java.util.Arrays;

public class Kodu2b {

    public static int[] korduvadRidades(int[][] a) {
        // sort all
        for(int i = 0; i < a.length; i++){
            Arrays.sort(a[i]);
        }
        // copy first row
        ArrayList<Integer> ans = new ArrayList<>();
        for(int item : a[0]) ans.add(item);

        // loop through all subarrays
        for(int i = 1; i < a.length; i++){
            int i1 = ans.size()-1;
            int i2 = a[1].length-1;

            // check pairs per row
            while(i1 >= 0 && i2 >= 0){
                if(ans.get(i1) == a[i][i2]){
                    i1 -= 1;
                    i2 -= 1;
                }
                else if(ans.get(i1) > a[i][i2]){
                    ans.remove(i1);
                    i1 -= 1;
                }
                else if(ans.get(i1) < a[i][i2]){
                    // del a[i][i2], kuid pole tegelikult mõtet
                    i2 -= 1;
                }
            }
            if(i1 >= 0) ans.subList(0, i1+1).clear();
        }

        // ArrayList >> int[]
        int[] ansarr = new int[ans.size()];
        for(int i = 0; i<ans.size(); i++){
            ansarr[i] = ans.get(i);
        }

        return ansarr;
    }

    public static void main(String[] args) {
        int[][] a = {
                {2, 2, 1, 4},
                {4, 1, 2, 2},
                {7, 1, 2, 2},
                {2, 10, 2, 1}
        };
        int[] sets = korduvadRidades(a);
        Helper.print(sets);
    }

}
