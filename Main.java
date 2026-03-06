public class Main {
    public static int[] getcirc(int[][] matrix, int n) {
        int x1len = matrix.length - 2 * n;
        int x2len = matrix[0].length - 2 * n;
        if(x1len <=0 | x2len <=0) return new int[0]; // 1x1 maatriks

        int reps = 0;
        // 1-dimensional
        if(x1len == 1 | x2len == 1) reps = (int)Math.max(x1len, x2len);
        // 2-dimensional
        else reps = 2*(x1len + x2len - 2);

        int[] circ = new int[reps];
        int ind = 0;


        // bools for directions?
        // esimene manuaalselt, --x, üles liikumine 1 võrra väiksema limiidiga
        

        int x1 = n, x2 = n;
        System.out.printf("x1len: %s, x2len: %s, x1: %s, x2: %s, reps: %s\n",x1len, x2len, x1, x2, reps);

        boolean right, down, left, up;
        right = down = left = up = true;

        circ[ind++] = matrix[x1][x2];
        for(int i = n; i<reps-1 + n; i++){ //////////
            
            if(right){
                if(x2 == matrix[0].length - n - 1){
                    right = false;
                    i--;
                    continue;
                }
                x2++;
            } 
            else if(down){ ////
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

            circ[ind++] = matrix[x1][x2];
        }

        return circ;
        
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
        int[][] m3 = new int[5][3];
        Helper.print(getcirc(m2, 1));
        
    }
}
