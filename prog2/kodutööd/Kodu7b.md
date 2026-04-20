// ei tööta õigesti

public class Kodu7b {
    public static void main(String[] args) {
        System.out.println(kuningad(2, 2));
    }

    static long kuningad(int m, int n){
        long kuningaid = 0;
        if(m == 1 || n == 1){
            return (long) Math.pow(2, Math.max(m, n));
        } 
        if(m > 1 && n > 1){
            kuningaid += kuningad(m, n, 1, false);
            kuningaid += kuningad(m, n, 3, false);
            kuningaid += kuningad(m, n, 2, false);
            kuningaid += kuningad(m, n, 4, true);
        }
        return kuningaid;
    }

    static long kuningad(int m, int n, int x, boolean eelmine4){
        long summa = 0;
        int[] mlubatud = new int[0], nlubatud = new int[0];

        if(x == 0) return 0;
        if(m == 0 && n == 0) return 0;

        if(x == 1){
            if(m > 0){
                summa += 4;
                mlubatud =  new int[]{0, 2, 3, 4};
                if(!eelmine4) mlubatud[0] = 1;
            }
            if(m == 0 && n > 0){
                summa += 3;
                nlubatud = new int[]{0, 3, 4};
                if(!eelmine4) nlubatud[0] = 1;
            }
        }
        if(x == 2){
            if(m > 0){
                summa += 2;
                mlubatud =  new int[]{2, 4};
            }
            if(m == 0 && n > 0){
                summa += 4;
                nlubatud = new int[]{0, 2, 3, 4};
                if(!eelmine4) nlubatud[0] = 1;
            }
        }
        if(x == 3){
            if(m > 0){
                summa += 4;
                mlubatud =  new int[]{0, 2, 3, 4};
                if(!eelmine4) mlubatud[0] = 1;
            }
            if(m == 0 && n > 0){
                summa += 2;
                nlubatud = new int[]{2, 4};
            }
        }
        if(x == 4){
            if(m > 0){
                summa += 2;
                mlubatud =  new int[]{2, 4};
            }
            if(m == 0 && n > 0){
                summa += 2;
                nlubatud = new int[]{3, 4};
            }
        }

        for(int i : mlubatud){
            if(i == 0) continue;
            boolean temp = (i == 4) ? true : false;
            summa += kuningad(m-1, n, i, temp);
        }
        for(int i : nlubatud){
            if(i == 0) continue;
            boolean temp = (i == 4) ? true : false;
            summa += kuningad(m, n-1, i, temp);
        }

        return summa;
        
    }
}