/***********************************
 * Programmeerimine II. LTAT.03.007
 * 2025/2026 kevadsemester
 *
 * Kodutöö nr 8
 * Teema: SÕnetöötlus
 *
 * Autor: Mihkel Matto
 * 
 **********************************/

public class Kodu8 {
    public static void main(String[] args) {
        String kordus = "abbbaaacabbbbac";

        String h1 = "Mait Malmsten kehastus korstnapühkijaks.";
        String h2 = "aeggkioubkkbõaäö";
        System.out.println(kaashäälikuÜhendeid(h2));    
    }

    /*
    Eemaldab sisendsõnest kõik maksimaalse pikkusega tähekordused ja selle tõttu tekkinud tähekordused.
    Argumendid:
    String a        sisendsõne, millest kordusi eemaldatakse
    @return         sõne, millest on kõik kordused eemaldatud
    */
    public static String eemaldaKordusgrupid(String a){
        StringBuilder sb = new StringBuilder(a);
        while(true){
            if(sb.length() == 1) break;

            boolean kordusi = false;    // true kui tsükli jooksul on leitud kordusi
            int loendur = 1;            // loeb kokku, mitu ühesugust tähte on järjest nähtud.

            for(int i = sb.length()-2; i>=0; i--){
                if(sb.charAt(i) == sb.charAt(i+1)){
                    loendur++;
                    
                    // eemaldab enne tsükli lõppu viimased kordused
                    if(i == 0){
                        sb.replace(0, i+loendur, "");
                        kordusi = true;
                    }
                }
                else{
                    if(loendur > 1){
                        sb.replace(i+1, i+loendur+1, "");
                        kordusi = true;
                        loendur = 1;
                    }
                }
            }            
            // kui kordusi ei leitud, siis lõpetatakse programmi töö.
            if(!kordusi) break;
        }

        return sb.toString();
    }
    /*
    Leiab, mitu kaashäälikuühendit on antud sõnes.
    argumendid:
    String a    sõne, millest kaashäälikuühendeid otsitakse
    @return     kaashäälikuühendite arv

    **** Millegipärast loetakse kaashäälikuühendiks ükskõik mis sõna osa, mis on 2+ pikkusega ja kus esineb 2+ erinevat tähte, mis pole keeleliselt korrektne
        kui string s : kandidaadid loopi sisse panna hoopis häälikuÜhendid(), siis saaks ka keeleliselt korrektse vastuse.
    */
    public static int kaashäälikuÜhendeid(String a){
        a = a.toLowerCase();
        String eikaashäälikud = "[^bcdfghjklmnpqrsšzžtvwxy]";
        String[] kandidaadid = a.split(eikaashäälikud);

        int loendur = 0;
        for(String s : kandidaadid){
            if(s.length() > 1 && !s.equals(s.substring(0, 1).repeat(s.length()))) loendur++;
        };
        return loendur;
    }
    /*
    Loeb kokku, mitu häälikuühendit sisendis esineb.
    */
    static int häälikuÜhendeid(String a){
        if(a.length() <= 1) return 0;

        int ühendeid = 0;
        int loendur = 1;
        for(int i = a.length()-2; i >= 0; i--){
            if(a.charAt(i) == a.charAt(i+1)){
                if(loendur > 1) ühendeid++;
                loendur = 1;
            }
            else loendur++;
        }
        if(loendur > 1) ühendeid++;

        System.out.printf("a: %s, ühendeid: %s\n", a, ühendeid);
        return ühendeid;
    }

    public static String[] kõikTulemused(String s){
        return null;
    }

}
