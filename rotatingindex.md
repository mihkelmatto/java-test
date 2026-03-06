public class Main {
    public static int[] getcirc(int[][] matrix, int n){
        int x1max = matrix.length-1;
        int x2max = matrix[0].length-1;
        boolean onedim = (x1max == 0 | x2max == 0) ? true : false;
        int reps = (onedim) ? x1max + x2max + 1: (int)2*(x1max + x2max);

        int[] circ = new int[reps];
        int ind = 0;

        
        System.out.printf("x1: %s, x2: %s, reps: %s\n",x1max, x2max, reps);

        int x1 = n, x2 = n;
        for(int i = 0; i<reps; i++){
            if(x1 == n && x2 < x2max) circ[ind++] = matrix[x1][x2++];
            else if(x1 < x1max && x2 == x2max) circ[ind++] = matrix[x1++][x2];
            else if(!onedim && x1 == x1max && x2 > n) circ[ind++] = matrix[x1][x2--];
            else if(!onedim && x1 > n && x2 == n) circ[ind++] = matrix[x1--][x2];
        }
        return circ;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4}};
        Helper.print(getcirc(matrix, 0));
        
    }
}
