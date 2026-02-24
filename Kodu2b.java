// input int[n][n] kus n <= 3000
// output int[] kus on iga korduv arv kasvavas järjestuses, korduste arv korda

/*
[[2, 2, 1, 4],
 [4, 1, 2, 2],
 [7, 1, 2, 2],
 [2, 10, 2, 1]] >> outputs >> [1, 2, 2]
*/

// 1 2 2 2 5 5 6
// 1 2 2 4 5 6 6
// 1 2 2 3 4 5 5
// 1 2 2 3 4 5 5

// 1 2 2 2 5 5 6
// 1 2 2 4 5 6 6

// 1 2 2 3 4 5 5
// 1 2 2 3 4 5 5


// iga rea kohta loed kokku arvu esinemise
// salvestatakse arv:min(value, newvalue)

import java.util.ArrayList;
import java.util.Arrays;

public class Kodu2b {

    public static int[] korduvadRidades(int[][] a) {
        int[] ans = new int[a.length];

        for(int i)

        for(int i = 0; i < a.length; i++){
            Arrays.sort(a[i]);
        }

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
