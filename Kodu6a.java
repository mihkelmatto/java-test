import java.util.ArrayList;
import java.util.Comparator;

public class Kodu6a {
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 1};

        String[] avaldised = avaldisedLõigus(a, 1, 1);
        for(String avaldis : avaldised) System.out.println(avaldis);
    }

    /*
    Loob kõik võimalikud avaldised, kasutades operaatoreid + - *
    Iga avaldis peab jääma vahemikku [x, y]
    int[] a - järjend, mille kõik elemendid osalevad originaaljärjestuses igas avaldises
    @return - Järjend, mille iga liige on formaadis "avaldis = tulemus" ning on sorteeritud tulemuste järgi kasvavas järjestuses
    
    */
    public static String[] avaldisedLõigus(int[] a, int x, int y){
        if(a.length == 0) return new String[0];
        ArrayList<String> avaldised = avaldisedLõigus(a, x, y, Integer.toString(a[0]), a[0], 1);
        return avaldised.toArray(new String[avaldised.size()]);
    }

    public static ArrayList<String> avaldisedLõigus(int[] a, int x, int y, String avaldis, int tulemus, int i){
        ArrayList<String> avaldised = new ArrayList<>();

        if(i == a.length){
            if(tulemus >= x && tulemus <= y){
                avaldised.add(avaldis + "=" + tulemus);
            }
            return avaldised;
        }

        avaldised.addAll(avaldisedLõigus(a, x, y, 
                                        avaldis + "+" + a[i], // avaldis
                                        tulemus + a[i],         // tulemus
                                        i+1));

        avaldised.addAll(avaldisedLõigus(a, x, y,
                                        avaldis + "-" + a[i], // avaldis
                                        tulemus - a[i],         // tulemus
                                        i+1));

        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int i1 = Integer.valueOf(s1.split("=")[1]);
                int i2 = Integer.valueOf(s2.split("=")[1]);
                return Integer.compare(i1, i2);
            }
        };

        avaldised.sort(cmp);
        return avaldised;
    }

}
