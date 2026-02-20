import java.util.*;

public class test {

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int n = 1000;

        List<Integer> circularPrimes = getCircularPrimes(n);

        Collections.sort(circularPrimes, Collections.reverseOrder());

        System.out.println("Antud lähtekoht: " + n);

        for (int i = 0; i < Math.min(5, circularPrimes.size()); i++) {
            System.out.println(circularPrimes.get(i));
        }

        System.out.println("Väiksemaid erinevaid algarvuringe: "
                + (circularPrimes.size() - 5));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000;
        System.out.println("Aeg ms: " + duration);
    }

    static List<Integer> getCircularPrimes(int n) {

        boolean[] prime = sieve(n);
        boolean[] visited = new boolean[n + 1];

        List<Integer> result = new ArrayList<>();

        for (int i = 11; i <= n; i += 2) {

            if (!prime[i] || visited[i]) continue;

            if (!validDigits(i)) continue;

            List<Integer> rotations = getRotations(i);

            boolean allPrime = true;

            for (int r : rotations) {
                if (r > n || !prime[r]) {
                    allPrime = false;
                    break;
                }
            }

            if (allPrime) {
                int max = 0;
                for (int r : rotations) {
                    visited[r] = true;
                    if (r > max) max = r;
                }
                result.add(max);
            }
        }

        return result;
    }

    static boolean[] sieve(int n) {

        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }

    static boolean validDigits(int num) {

        while (num > 0) {
            int d = num % 10;
            if (d == 0 || d == 2 || d == 4 || d == 5 || d == 6 || d == 8)
                return false;
            num /= 10;
        }
        return true;
    }

    static List<Integer> getRotations(int num) {

        List<Integer> rotations = new ArrayList<>();
        String s = Integer.toString(num);

        for (int i = 0; i < s.length(); i++) {
            rotations.add(Integer.parseInt(s));
            s = s.substring(1) + s.charAt(0);
        }

        return rotations;
    }
}



