import java.util.ArrayList;

    public class Helper {
        public static int[] join(ArrayList<Integer>[] arrs) {
        int itemcount = 0;
        for (ArrayList<Integer> list : arrs) {
            itemcount += list.size();
        }

        int[] joined = new int[itemcount];
        int index = 0;

        for (ArrayList<Integer> list : arrs) {
            for (int value : list) {
                joined[index++] = value;
            }
        }
        return joined;
    }

    public static int[] join(int[][] arrs){
        int itemcount = 0;
        for(int[] arr : arrs){
            itemcount += arr.length;
        }

        int[] joined = new int[itemcount];
        int index = 0;
        for(int[] arr : arrs){
            for(int i = 0; i<arr.length; i++){
                joined[index++] = arr[i];
            }
        }
        return joined;
    }

    public static void print(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void print(boolean[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void print(int[][] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                if (j < arr[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    static int[] radixsort(int[] unsorted){ // Max number range: about 2 000 000 000 (num shifting)
        int[] sorted = unsorted.clone();

        // get max/min
        int maxnr = 0;
        int minnr = 0;

        for (int i = 0; i < sorted.length; i++) {
            if(sorted[i] > maxnr) maxnr = sorted[i];
            if(sorted[i] < minnr) minnr = sorted[i];
        }

        // offset
        if(minnr < 0){
            maxnr -= minnr;
            for(int i = 0; i < sorted.length; i++){
                sorted[i] -= minnr;
            }
        }

        // sorting cycle
        for(int i = 1; i<= maxnr; i *= 10){
            int[] buckets = new int[10];

            // buckets >> frequency table
            for(int num : sorted){
                buckets[num / i % 10] += 1;
            }

            // buckets >> address table (inclusive prefix. Use shrinking indeces while joining)
            for(int j = 1; j < buckets.length; j++)
                buckets[j] += buckets[j - 1];

            // join buckets
            int[] temp = new int[sorted.length];

            for(int k = sorted.length - 1; k >= 0; k--){
                int digit = (sorted[k] / i) % 10;
                temp[--buckets[digit]] = sorted[k];
            }

            sorted = temp;
        }

        // reverse offset
        if(minnr < 0){
            for(int i = 0; i < sorted.length; i++){
                sorted[i] += minnr;
            }
        }
        return sorted;
    }

    static int[] radixsort_maxint(int[] unsorted){
        long[] sorted = new long[unsorted.length];
        for(int i = 0; i < unsorted.length; i++) sorted[i] = unsorted[i];

        // get max/min
        long maxnr = 0;
        long minnr = 0;

        for (int i = 0; i < sorted.length; i++) {
            if(sorted[i] > maxnr) maxnr = sorted[i];
            if(sorted[i] < minnr) minnr = sorted[i];
        }

        // offset
        if(minnr < 0){
            maxnr -= minnr;
            for(int i = 0; i < sorted.length; i++){
                sorted[i] -= minnr;
            }
        }

        // sorting cycle
        for(long i = 1; i <= maxnr; i *= 10){
            int[] buckets = new int[10];

            // buckets >> frequency table
            for(long num : sorted){
                buckets[(int)(num / i % 10)] += 1;
            }

            // buckets >> address table
            for(int j = 1; j < buckets.length; j++)
                buckets[j] += buckets[j - 1];

            // join buckets
            long[] temp = new long[sorted.length];

            for(int k = sorted.length - 1; k >= 0; k--){
                int digit = (int)((sorted[k] / i) % 10);
                temp[--buckets[digit]] = sorted[k];
            }

            sorted = temp;
        }

        // reverse offset
        if(minnr < 0){
            for(int i = 0; i < sorted.length; i++){
                sorted[i] += minnr;
            }
        }

        // convert back to int[]
        int[] result = new int[sorted.length];
        for(int i = 0; i < sorted.length; i++) result[i] = (int)sorted[i];
        return result;
    }


}
