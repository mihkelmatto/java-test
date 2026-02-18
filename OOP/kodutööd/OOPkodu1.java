package OOP.kodutööd;
import java.util.Arrays;

public class OOPkodu1 {
    public static void main(String[] args) {
        args = new String[]{"3" ,"176" ,"179" ,"169" ,"2" ,"172" ,"167"};
        int argcounter = 0;

        // create poisid
        int[] poisid = new int[Integer.parseInt(args[argcounter++])];
        for(int i = 0; i < poisid.length; i++){
            poisid[i] = Integer.parseInt(args[argcounter++]);
        }
        // create tydrukud
        int[] tydrukud = new int[Integer.parseInt(args[argcounter++])];
        for(int i = 0; i < tydrukud.length; i++){
            tydrukud[i] = Integer.parseInt(args[argcounter++]);
        }

        // function call
        int[][]combined = combine(poisid, tydrukud);

        // print array
        System.out.printf("%3s, %3s\n", "p", "t");
        for(int i = 0; i < combined.length; i++){
            System.out.printf("%d, %d\n", combined[i][0], combined[i][1]);
        }
    }

    static int[][] combine(int[] poisid, int[]tydrukud) {
        Arrays.sort(poisid);
        Arrays.sort(tydrukud);

        int combinedlen = Math.min(poisid.length, tydrukud.length);
        int[][] combined = new int[combinedlen][2]; // {{p, t}, {p, t}}
        
        for (int i = 0; i < combinedlen; i++) {
            combined[i] = new int[]{poisid[i], tydrukud[i]};
        }
        return combined;
    }
}
