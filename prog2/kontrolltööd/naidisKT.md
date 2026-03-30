public class naidisKT{
    public static void main(String[] args) {
        int[][] m1 = {
            {0, 0, 0, 1, 3},
            {0, 0, 2, 1, 9},
            {0, 0, 0, 0, -1},
            {4, 0, 0, 0, 0}
        };

        int[][] m2 = {
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3}
        };

        int[][] m3 = {
            {}
        };
        int[] ringid = ringid(m3);
        Helper.print(ringid);
        // out: [1, 4, 7, 10, 11, 8, 5, 2, 3, 6, 9, 12]
    }
    public static int[] ringid(int[][] a){
        int limit = Math.round(Math.min(a.length, a[0].length) / 2.0f);
        
        int[] ringid = new int[limit];
        int iR = 0;
        
        for(int i = 0; i<limit; i++){
            ringid[iR++] = ringisumma(a, i);
        }
        return ringid;
    }


    public static int ringisumma(int[][] a, int n){
        // loop variables
        int ylen = a.length- 2*n;
        int xlen = a[0].length - 2*n;

        int summa = 0;
        int y = n, x = n;
        
        // limit
        int limit = 2 * (ylen + xlen - 2);
        if(ylen == 1 || xlen == 1) limit = Math.max(ylen, xlen);

        //
        for(int i = 0; i<limit; i++){
            summa += a[y][x];
            System.out.printf("y: %s, x: %s\n", y, x);

            if(y == n && x < xlen-1 + n){
                x++;
            }
            else if(x == xlen-1 + n && y < ylen-1 + n){
                y++;
            }
            else if(y == ylen-1 + n && x > n){
                x--;
            }
            else if(x == n && y > 1 + n){
                y--;
            }
        }
        



        return summa;
    }



    public static int[] ussiMuster(int[][] a){
        int ylen = a.length;
        int xlen = a[0].length;
        int anslen = a.length * a[0].length;

        int[] ans = new int[anslen];
        int iAns = 0;

        int y = 0, x = 0;
        int dy = 1;

        while(!(y == ylen-1 && x == xlen)){
            // System.out.printf("y: %s, x: %s\n", y, x);

            ans[iAns++] = a[y][x];

            if(dy == 1 && y == ylen - 1){
                dy = -1;
                x++;
                continue;
            }
            else if(dy == -1 && y == 0){
                dy = 1;
                x++;
                continue;
            }

            y += dy;
        }



        return ans;
    }

    public static void suurA(int n){
        String mid;
        String c = "+";
        String e = " ";
        
        for(int i = 0; i<n; i++){
            String side = e.repeat(n - i - 1);
            
            if(i == 0) mid = c;
            else if(i == n/2) mid = c.repeat(2*i + 1);
            else mid = c + e.repeat(2*i - 1) + c;

            System.out.println(side + mid + side);
        }
    }
}

/*

*/