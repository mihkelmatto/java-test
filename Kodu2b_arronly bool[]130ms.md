// input int[n][n] kus n <= 3000
// output int[] kus on iga korduv arv kasvavas järjestuses, korduste arv korda

/*
[[2, 2, 1, 4],
 [4, 1, 2, 2],
 [7, 1, 2, 2],
 [2, 10, 2, 1]] >> outputs >> [1, 2, 2]
*/

import java.util.Arrays;

public class Kodu2b {

    public static int[] korduvadRidades(int[][] a) {
        // sort all
        for(int[] arr: a){
            Arrays.sort(arr);
        }

        // a[0] indeksid, kus duplikaadid asuvad
        boolean[] bools = new boolean[a[0].length];
        Arrays.fill(bools, true);
        int boolcount = bools.length;
        
        int start = 0;
        // loop through all subarrays (1 >> end)
        for(int i = 1; i < a.length; i++){
            int i1 = a[0].length-1;
            int i2 = a[i].length-1;

            // check pairs per row (end >> start)
            while(i1 >= start && i2 >= 0){
                if(!bools[i1]){
                    i1 -= 1;
                    continue;
                }

                
                if(a[0][i1] == a[i][i2]){
                    i1 -= 1;
                    i2 -= 1;
                }
                else if(a[0][i1] > a[i][i2]){
                    bools[i1] = false;
                    boolcount -= 1;
                    i1 -= 1;
                }
                else{
                    i2 -= 1;
                }
                
            }
            if(i1 >= 0) start = i1+1;
        }

        // build int[] ans
        boolcount -= start;

        int[] ans = new int[boolcount];
        int ansi = 0;
        for(int i = start; i<bools.length; i++){
            if(bools[i]) ans[ansi++] = a[0][i];       
        }
        return ans;
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
