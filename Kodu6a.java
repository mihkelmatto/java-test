import java.util.Arrays;

public class Kodu6a {
    public static void main(String[] args) {
        ul62a(3);
    }

    /*
    Loob kõik võimalikud avaldised, kasutades operaatoreid + - *
    Iga avaldis peab jääma vahemikku [x, y]
    int[] a - järjend, mille kõik elemendid osalevad originaaljärjestuses igas avaldises
    @return - Järjend, mille iga liige on formaadis "avaldis = tulemus" ning on sorteeritud tulemuste järgi kasvavas järjestuses
    
    */
    public static String[] avaldisedLõigus(int[] a, int x, int y){
        return avaldisedLõigus(a, x, y, "", 0);
    }

    public static String[] avaldisedLõigus(int[] a, int x, int y, String avaldis, int i){
        if(i == a.length){
            return avaldis;
        }
    }

}
