//2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97.
// algarvu kontroll kuni ruutjuur x


/*
 1. algarvude leidmine
 2. iga algarvu n -> 9 puhul kontroll, kas pöörded on algarvud
 3. kui kõik pöörded on algarvud, siis:
        primes[algarvud] = false duplikaatide eemaldamiseks
        lisada vastustesse suurim algarv (tsükli i)
 */
package prog2;
import java.util.ArrayList;
import java.util.Arrays;

class Kodu1a {
    public static void main(String[] args) {
        int input = 1000;
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
        if(n % 2 == 0) n-=1; // paaris > paaritu

        boolean[] primes = getprimes(n);
        ArrayList<Integer> primesets = new ArrayList<>();

        // pow10 = 10 (len-1) & rotate argument. Kui otse arvutada, siis on vahest aeglasem või läheb katki.
        int len = (int)Math.log10(n);
        int pow10 = (int)Math.pow(10, len);

        // i = algarv suuremast väiksemani
        for(int i = n; i > 9; i-=2){
            if(i<pow10) pow10 /= 10;
            if(!primes[i]) continue;
            
            // iga kasutatud primes >> false. Kui pööre pole algarv, siis katkestab
            int testnr = i;
            boolean valid = true;
            for(int j = 1; j < pow10; j*=10){
                testnr = rotate(testnr, pow10);

                if(testnr > n || !primes[testnr]) {
                    valid = false;
                    break;
                }
                
                primes[testnr] = false;
            }

            if(valid){
                primesets.add(i);
            }
        }
        return primesets;
    }

    static int rotate(int num, int pow10){ // length juhuks, kui num lõpeb nulliga
        return (num % 10) * pow10 + (num / 10);
    }

    static boolean[] getprimes(int n){ // Tagastab listi, mille algarvulised indeksid = true
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
