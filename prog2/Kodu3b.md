package prog2;
/*
# Programmi tööpõhimõte:
1. Leitakse ringide arv
iga ringi kohta:
2. maatriksi üks ring loetakse 1D-listiks
3. listi keeratakse
4. maatriksi ring kirjutatakse üle listi väärtustega


*/

import Helper;

public class Kodu3b {
    /*
    add == false: Loeb ringi elemendid listi
    add == true:  Loeb listi elemendid ringi
    n - ringi indeks väljast loetuna (0 = välimine)
    Töötab ka riba & punkti puhul

    tingimused:
    - n peab olema ringi suhtes 0:0 koordinaatidega (kõige vasak-ülemine element)
        ehk siis max n väärtus on ~pool lühema külje pikkust
    - int[] listi pikkus peab olema täpne (muidu rotate ei tööta)
    */
        public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4, 5},
            {1, 2, 3, 4, 5},
            {1, 2, 3, 4, 5},
        };
        int[][] m2 = {
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3}
        };
        int[][] m3 = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {9, 10, 11},
            {12, 13, 14},
            {15, 16, 17},
            {18, 19, 20},
            {21, 22, 23},
            {24, 25, 26}
        };
        m3 = pööre(m3, 3);
        Helper.print(m3);
    }


    public static void getcirc(int[][] matrix, int[] list, int n, boolean add) {
        int ylen = matrix.length;
        int xlen = matrix[0].length;
        int rlen = roundlen(matrix, n);

        // loop variables
        int y = n, x = n;
        int ymax = ylen-1-n, xmax = xlen-1-n;
        
        int indC = 0; // circle arr index
        int indL = 0; // list arr index

        // 1st add
        if(add) matrix[y][x] = list[indL++];
        else list[indC++] = matrix[y][x];

        // Index +- 1 > kui suunda pole vahetatud, siis lisab listi
        for(int i = 0; i < rlen-1; i++){ // rlen-1, sest esimene el. on juba lisatud.
            
            if      (y == n && x < xmax)    x++; // right
            else if (x == xmax && y < ymax) y++; // down
            else if (y == ymax && x > n)    x--; // left
            else if (x == n && y > n)       y--; // up

            if(add) matrix[y][x] = list[indL++];
            else list[indC++] = matrix[y][x];

        }
    }
    
    public static int[] rotate(int[] list, int n){
        int m = list.length;
        if(n<0) n = m+n;
        int[] rotated = new int[m];
        for(int i = 0; i<m; i++){
            rotated[(i+n) % m] = list[i];
        }
        return rotated;
    }

    public static int roundlen(int[][] a, int n){
        int x1len = a.length - 2 * n;
        int x2len = a[0].length - 2 * n;

        int rlen;
        if(x1len == 1 || x2len == 1) rlen = (int)Math.max(x1len, x2len); // 1-dimensional
        else rlen = 2*(x1len + x2len - 2); // 2-dimensional
        return rlen;
    }

    public static int[][] pööre(int[][] a, int k){
        int limit = (int) Math.ceil(Math.min(a.length, a[0].length)/2.0);

        for(int i = 0; i<limit; i++){
            int rlen = roundlen(a, i);
            int[] list = new int[rlen];
            getcirc(a, list, i, false);
            list = rotate(list, k);
            getcirc(a, list, i, true);
        }
        return a;
    }
}
