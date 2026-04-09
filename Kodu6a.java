import java.util.ArrayList;
import ee.ut.dendroloj.Dendrologist;
import ee.ut.dendroloj.Grow;

public class Kodu6a {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};

        // Dendrologist.wakeUp();
        String[] avaldised = avaldisedLõigus(a, 0, 100);

        for(String avaldis : avaldised) System.out.println(avaldis);
    }

    /*
    Loob kõik võimalikud avaldised, kasutades operaatoreid + - *
    Iga avaldis peab jääma vahemikku [x, y]
    int[] a - järjend, mille kõik elemendid osalevad originaaljärjestuses igas avaldises
    @return - Järjend, mille iga liige on formaadis "avaldis = tulemus" ning on sorteeritud tulemuste järgi kasvavas järjestuses
    
    */
    public static String[] avaldisedLõigus(int[] a, int x, int y){
        ArrayList<String> avaldised = avaldisedLõigus(a, x, y, Integer.toString(a[0]), a[0], a[0], 1);
        return avaldised.toArray(new String[avaldised.size()]);
    }

    // @Grow
    public static ArrayList<String> avaldisedLõigus(int[] a, int x, int y, String avaldis, int tulemus, int eelmineliidetav, int i){
        ArrayList<String> avaldised = new ArrayList<>();

        if(i == a.length){
            if(tulemus >= x && tulemus <= y){
                avaldised.add(avaldis + " = " + tulemus);
            }
            return avaldised;
        }

        avaldised.addAll(avaldisedLõigus(a, x, y, 
                                        avaldis + " + " + a[i], // avaldis
                                        tulemus + a[i],         // tulemus
                                        a[i],
                                        i+1));

        avaldised.addAll(avaldisedLõigus(a, x, y,
                                        avaldis + " - " + a[i], // avaldis
                                        tulemus - a[i],         // tulemus
                                        -a[i],
                                        i+1));

        avaldised.addAll(avaldisedLõigus(a, x, y,
                                        avaldis + " * " + a[i], // avaldis
                                        (tulemus - eelmineliidetav) + eelmineliidetav * a[i],   // tulemus
                                        eelmineliidetav * a[i],
                                        i+1));

        return avaldised;
    }

    static ArrayList<String> lisa(ArrayList<String> list, String avaldis){
        return lisa(list, avaldis, 0);
    }

    static ArrayList<String> lisa(ArrayList<String> list, String avaldis, int i){
        ArrayList<String> avaldised = new ArrayList<>();

        if(i == list.size()){
            avaldised.add(avaldis);
            return avaldised;
        }

        int tulemus = Integer.valueOf(avaldis.split(" = ")[1]);
        int temp = Integer.valueOf(list.get(i).split(" = ")[1]);
        
        if(tulemus < temp){
            avaldised.add(avaldis);
            avaldised.addAll(list.subList(i, list.size()));
            return avaldised;
        }
        else{
            avaldised.add(list.get(i));
            avaldised.addAll(lisa(list, avaldis, i+1));
        }
        return avaldised;
    }

}
