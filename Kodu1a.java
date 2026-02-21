//2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97.
// algarvu kontroll kuni ruutjuur x

/*
 1. algarvude leidmine
 2. iga algarvu n -> 9 puhul kontroll, kas pöörded on algarvud
 3. kui kõik pöörded on algarvud, siis:
        primes[algarvud] = false duplikaatide eemaldamiseks
        lisada vastustesse suurim algarv (tsükli i)
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Kodu1a {
    public static void main(String[] args) {
        int input = 106;

        algarvuRingid5Suurimat(input);
        algarvuRingideArv(input);
    }

    static void algarvuRingid5Suurimat(int n){
        ArrayList<Integer> primesets = getprimesets(n);

        System.out.printf("Antud lähtekoht: %d\n", n);
        for(int i = 0; i<Math.min(5, primesets.size()); i++){
            System.out.println(primesets.get(i));
        }
        System.out.printf("Väiksemaid erinevaid algarvuringe: %d\n", algarvuRingideArv(n));
    }

    static int algarvuRingideArv(int n){
        ArrayList<Integer> primesets = getprimesets(n);
        return primesets.size();
    }

    static ArrayList<Integer> getprimesets(int n){
        boolean[] primes = getprimes(n);
        if(n % 2 == 0) n-=1; // paaris > paaritu

        ArrayList<Integer> primesets = new ArrayList<>();
        int numlen = (int)Math.log10(n) + 1;
        int pow10 = (int)Math.pow(10, numlen - 1); // numbri pikkus + rotate argument
        // iga algarv suuremast väiksemani (paaritu i)
        for(int i = n; i > 9; i-=2){
            if(primes[i]){
                if(i<pow10){
                numlen -= 1;
                pow10 = (int)Math.pow(10, numlen-1);
                }
                // pöörded
                int testnr = i;
                boolean valid = true;

                // Kontrollib, kas pöörded on algarvud ja lisab sobivusel testseti
                for(int j = 0; j < numlen-1; j++){
                    testnr = rotate(testnr, pow10);
                    if(testnr <= n && primes[testnr]){ // filtreerib <=n
                        primes[testnr] = false;
                    }
                    else{
                        valid = false;
                        break;
                    }
                }
                if(valid){
                    primesets.add(i);
                }
            }
        }
        return primesets;
    }

    static int rotate(int num, int pow10){ // length juhuks, kui num lõpeb nulliga
        return (num % 10) * pow10 + (num / 10);
    }

    static boolean[] getprimes(int n){
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        int limit = (int)Math.sqrt(n);

        for(int i=2; i<=limit; i++){
            if(primes[i]){
                int temp = i * i;
                while(temp <= n){
                    primes[temp] = false;
                    temp += i;
                }
            }
        }
        return primes;
    }

}
