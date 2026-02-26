// input int[n][n] kus n <= 3000
// output int[] kus on iga korduv arv kasvavas järjestuses, korduste arv korda

/*
[[2, 2, 1, 4],
 [4, 1, 2, 2],
 [7, 1, 2, 2],
 [2, 10, 2, 1]] >> outputs >> [1, 2, 2]
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Kodu2b {

    public static int[] korduvadRidades(int[][] a) {
        // sort all
        for(int[] arr: a){
            Arrays.sort(arr);
        }
        // copy first row
        ArrayList<Integer> ans = new ArrayList<>();
        for(int item : a[0]) ans.add(item);

        int i1;
        int start = 0;
        // loop through all subarrays
        for(int i = 1; i < a.length; i++){
            i1 = ans.size()-1;
            int i2 = a[1].length-1;

            // check pairs per row
            while(i1 >= start && i2 >= 0){
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
            if(i1 >= 0) start = i1+1;
        }
        ans.subList(0, start).clear();
        
        
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

    }

}
