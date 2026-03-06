public class Main {
    // n ei tohi olla suurem kui 0.5 "diagonaali"
    // argument int[] list peab olema ringi pikkuse suhtes piisava suurusega 
    public static void getcirc(int[][] matrix, int[] list, int n, boolean add) {
        int x1len = matrix.length - 2 * n;
        int x2len = matrix[0].length - 2 * n;

        // calc loop reps
        int reps;
        if(x1len == 1 | x2len == 1) reps = (int)Math.max(x1len, x2len); // 1-dimensional
        else reps = 2*(x1len + x2len - 2); // 2-dimensional

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
        int[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        getcirc(m3, list, 0, true);
        Helper.print(list);
        Helper.print(m3);
        
    }
}
