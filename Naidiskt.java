import java.util.Arrays;

public class Naidiskt {
    public static void main(String[] args) {
        int[][] a = {
            {1, 0, 0, 1, 3},
            {0, 1, 2, 1, 9},
            {0, 0, 0, 0, -1},
            {4, 0, 0, 0, 0}
        };

        int[][] b = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {10, 11, 12}
        };
        for(int i = 1; i<7; i++)kauss(i);
        // System.out.println(Arrays.toString(ussiMuster(b)));
    }

    public static void kauss(int n){
        if(n == 1){
            System.out.println("+");
            return;
        }
        
        int len = (1 + n) * n - n;
        
        int sum = 0;
        for(int i = 1; i<=n; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(" ".repeat(len));
            sb.replace(0+sum, sum+i, "+".repeat(i));
            sb.replace(len-1 - sum - i, len - sum, "+".repeat(i));

            System.out.println(sb.toString());
            sum += i;
        }
    }

    public static void suurA(int n){
        String p = "+";
        int sum = 0;
        for(int i = 0; i<n; i++){
            if(i == 0){
                System.out.println(" ".repeat(n) + p);
                sum--;
            }
            else if(i == n / 2) System.out.println(" ".repeat(n-i) + p.repeat(sum + 2));
            else System.out.println(" ".repeat(n-i) + p + " ".repeat(sum) + p);
            sum += 2;
        }
    }

    public static int[] ussiMuster(int[][] a){
        if(a.length == 1) return a[0];

        int[] muster = new int[a[0].length * a.length];
        int imuster = 0;

        int y = 0, x = 0;
        int ymax = a.length - 1;

        muster[imuster++] = a[y][x];
        while(imuster < muster.length){
            if(y < ymax && x % 2 == 0){
                muster[imuster++] = a[++y][x];
            }
            else if(y > 0 && x % 2 == 1){
                muster[imuster++] = a[--y][x];
            }
            else if(y == 0 || y == ymax){
                muster[imuster++] = a[y][++x];
            }
        } 
        return muster;
    }




    public static int[] ringid(int[][] a){
        int limit = ((int)Math.ceil(Math.min(a.length, a[0].length) / 2.0));
        int[] summad = new int[limit];
        int isum = 0;

        for(int i = 0; i<limit; i++){
            summad[isum++] = leiasumma(a, i);
        }
        return summad;
    }

    static int leiasumma(int[][] a, int n){
        int summa = 0;

        int x = n, y = n;
        int xmax = a[0].length - 1 - n;
        int ymax = a.length - 1 - n;

        int xlen = a[0].length - 2 * n;
        int ylen = a.length - 2 * n;
        int limit = 2 * (xlen + ylen - 2) - 1;
        System.out.printf("limit: %s, y: %s, x: %s\n", limit, ylen, xlen);

        summa += a[y][x];

        for(int i = 0; i<limit; i++){
            if(x < xmax && y == n){
                x++;
                summa += a[y][x];
            }
            else if(x == xmax && y < ymax){
                y++;
                summa += a[y][x];
            }
            else if(x > n && y == ymax){
                x--;
                summa += a[y][x];
            }
            else if(x == n && y > n){
                y--;
                summa += a[y][x];
            }
            // System.out.printf("y: %s, x: %s\n", y, x);
            if(a[y][x] != 0) System.out.println(a[y][x]);

        }
        return summa;
    }
}
