import java.util.ArrayList;

    public class helper {
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
}
