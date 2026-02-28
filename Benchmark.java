import java.util.Random;

public class Benchmark {

    // Testitav meetod
    public static void testMethod() {
        // siia oma kood
        for (int i = 0; i < 10000; i++) {
            Math.sqrt(i);
        }
    }

    public static void main(String[] args) {
        // testi jaoks vajalikud muutujad
        int[][] a = generate();


        //


        int runs = 1000;          // mitu korda mõõta
        int warmup = 200;         // soojendus JIT jaoks

        // warmup (ei mõõdeta)
        for (int i = 0; i < warmup; i++) {
            Kodu2b.korduvadRidades(a);
        }

        long totalTimeNs = 0;

        for (int i = 0; i < runs; i++) {
            long start = System.nanoTime();
            Kodu2b.korduvadRidades(a);
            long end = System.nanoTime();

            totalTimeNs += (end - start);
        }

        double avgNs = (double) totalTimeNs / runs;
        double avgMs = avgNs / 1_000_000.0;

        System.out.println("Keskmine aeg: " + avgMs + " ms");
    }

    public static int[][] generate() {
        int n = 3000;
        int[][] matrix = new int[n][n];
        Random rnd = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rnd.nextInt(); // täis int vahemik
            }
        }

        return matrix;
    }
}