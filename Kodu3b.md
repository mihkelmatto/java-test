/*
pooldiagonaali = 0.5 * min(rowlen, columnlen)
for i in pooldiagonaali: ringi algusindeks = (i, i)
kordusi = 2* (rowlen+columnlen-2)
kordusi = liigutusi % kordusi
for j in kordusi: elemendi valik        | mõlemate indeksite liikumine sama loogika järgi
for k in kordusi: elemendi liigutamine  |

4x if-elif tingimust iga suuna kohta. Kui paremale-alla on liigutud, siis esimesed kaks tingimust blokeeritakse

//

Vajadusel joone pööramine


*/


public class Kodu3b {

    public static int[][] pööre(int[][] a, int pööre){
        int columnlen = a.length;
        int rowlen = a[0].length;
        int[][] temp = new int[columnlen][rowlen];

        // pööre % (0.5 "diagonaal")
        int roundstart = (int) 0.5 * Math.min(columnlen, rowlen);
        roundstart = pööre % roundstart;

        // ringi algusindeks = (x, x)
        for(int i = 0; i<roundstart; i++){
            int rep = 2 * (columnlen + rowlen - 1);
            int i1=i, i2=i;
            int item = a[i1][i2];

            for(int j = i; j<rep+i; j++){
                int top = j;
                int right = rowlen-
                if () {
                    
                }
                else if{

                }
            }
        }


        return temp;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {5, 2, 3, 9},
            {3, 4, 5, 7},
            {2, 8, 7, 8},
            {3, 4, 5, 7}};
    }
}
