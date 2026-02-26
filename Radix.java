public class Radix {
    public static void main(String[] args) {
        int[] unsorted = {120, 312, 589, 19, 38, 52, 1093, 10000, 1, 9, 5, 0};
        // int[] unsorted = {};
        int[] sorted = radixsort(unsorted);
        helper.print(sorted);
    }

    static int[] radixsort(int[] unsorted){ // x >= 0, max can't be 0
        int[] sorted;

        // get max length
        int maxnr = 0;
        for (int i = 0; i < unsorted.length; i++) {
            if(unsorted[i] > maxnr) maxnr = unsorted[i];
        }


        // sorting cycle
        for(int i = 1; maxnr/i > 0; i *= 10){
            int[] buckets = new int[10];

            // buckets >> frequency table
            for(int num : unsorted){
                buckets[num / i % 10] += 1;
            }

            // buckets >> address table (inclusive prefix. Use shrinking indeces while joining)
            int sum = 0;
            for(int j = 0; j < buckets.length; j++){
                sum += buckets[j];
                buckets[j] = sum;
            }

            // join buckets
            int[] temp = new int[unsorted.length];

            for(int k = unsorted.length - 1; k >= 0; k--){
                int digit = (unsorted[k] / i) % 10;
                temp[--buckets[digit]] = unsorted[k];
            }

            unsorted = temp.clone();
        }
        
        sorted = unsorted;
        return sorted;
    }
}
