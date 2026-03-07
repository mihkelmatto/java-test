public class Kodu3bL {
    // n ei tohi olla suurem kui 0.5 "diagonaali"
    // argument int[] list peab olema ringi pikkuse suhtes piisava suurusega 
    public static void getcirc(int[][] matrix, int[] list, int n, boolean add) {
        int reps = roundlen(matrix, n);

        // loop variables
        int x1 = n, x2 = n;
        boolean right, down, left, up;
        right = down = left = up = true;
        
        int indC = 0; // circle index
        int indL = 0; // list index

        // 1st add
        if(add) matrix[x1][x2] = list[indL++];
        else list[indC++] = matrix[x1][x2];

        // Index +- 1 > kui suunda pole vahetatud, siis lisab listi
        for(int i = n; i<reps-1 + n; i++){ // millegipärast reps-1
            
            if(right){
                if(x2 == matrix[0].length - n - 1){
                    right = false;
                    i--;
                    continue;
                }
                x2++;
            } 
            else if(down){
                if(x1 == matrix.length - n - 1){
                    down = false;
                    i--;
                    continue;
                }
                x1++;
            }
            else if(left) {
                if(x2 == n){
                    left = false;
                    i--;
                    continue;
                }
                x2--;
            }
            else if(up) {
                if(x1 == n){
                    up = false;
                    i--;
                    continue;
                }
                x1--;
            }

            if(add) matrix[x1][x2] = list[indL++];
            else list[indC++] = matrix[x1][x2];
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

        // calc loop reps
        int lenr;
        if(x1len == 1 || x2len == 1) lenr = (int)Math.max(x1len, x2len); // 1-dimensional
        else lenr = 2*(x1len + x2len - 2);
        return lenr;
    }

    public static int[][] pööre(int[][] a, int k){
        int min = (int)Math.min(a.length, a[0].length);
        int limit = (min % 2 == 0) ? min/2-1 : min/2;

        for(int i = 0; i<limit; i++){
            int rlen = roundlen(a, i);
            int[] list = new int[rlen];
            getcirc(a, list, i, false);
            list = rotate(list, k);
            getcirc(a, list, i, true);
        }
        return a;
    }


    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4, 5},
            {1, 2, 3, 4, 5},
            {1, 2, 3, 4, 5},
            {1, 2, 3, 4, 5}
        };
        int[][] m2 = {
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3}
        };        
    }
}
