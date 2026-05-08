import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Arvutiparandus {
    public static void main(String[] args) {
        String file = "andmed.txt"; // TODO: loe failinimi args[]-st
        Sessioon sessioon = new Sessioon(loeFail(file));

        try(Scanner scanner = new Scanner(System.in)){
            String in;
            while(true){
                System.out.println("Kas soovid parandada (P), uut tööd registreerida (R) või lõpetada (L) ?");
                in = scanner.nextLine();
                if(in.equals("P")){

                }
                else if(in.equals("R")){
                    registreeri(scanner, sessioon);
                }
                else if(in.equals("L")){

                }
                else{
                    System.out.println("Tegevust ei leitud. Proovi uuesti.");
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
    private static void registreeri(Scanner scanner, Sessioon sessioon){
        while(true){
            try{
                System.out.println("Sisesta töö kirjeldus: ");
                sessioon.lisaArvuti(loeArvuti(scanner.nextLine()));
                System.out.println("Töö registreeritud");
                return;
            }
            catch(FormaadiErind f){
                System.out.printf("Vigane sisestus! %s\n", f.getMessage());
            }
            catch(Exception e){
                System.out.println(e);
                return;
            }
        }
    }

    private static double leiaBaashind(String parandaja, int aegmin){
        String nimi;
        double tunnitasu = 0;

        try (DataInputStream in = new DataInputStream(
                new FileInputStream("tunnitasud.dat"))) {

            int arv = in.readInt();

            for (int i = 0; i < arv; i++) {
                nimi = in.readUTF();
                tunnitasu = in.readDouble();

                if(nimi.equals(parandaja)) break;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }   

        return aegmin/60.0 * tunnitasu;
    }

    private static ArrayList<Arvuti> loeFail(String path){
        ArrayList<Arvuti> arvutid = new ArrayList<>();
        try (
            InputStream s = path.startsWith("http://") || path.startsWith("https://")
                ? new URI(path).toURL().openStream()
                : new FileInputStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(s, "UTF-8"))
        ) {
            String line;
            while((line = reader.readLine()) != null){
                arvutid.add(loeArvuti(line));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return arvutid;
    }

    private static Arvuti loeArvuti(String kirjeldus) throws FormaadiErind{
        String[] temp = kirjeldus.strip().split("@");

        // kui kirjelduses pole aega, siis temp.length == 1
        LocalDateTime regaeg = LocalDateTime.now();
        if(temp.length == 2){
            regaeg = LocalDateTime.parse(temp[1]);
            temp = new String[]{temp[0]};
        }

        temp = temp[0].split(";");

        if(temp.length < 2 || temp.length > 3) throw new FormaadiErind("Loearvuti: Vale andmete kogus (2-3)");
        if(!(temp[1].equals("tavatöö") || temp[1].equals("kiirtöö"))) throw new FormaadiErind("Loearvuti: pole tavatöö ega kiirtöö");
        if(temp.length == 3 && !temp[2].equals("monitoriga")) throw new FormaadiErind("valed andmed kolmandas väljas (peab olema 'monitoriga'");

        boolean onkiirtoo = (temp[1].equals("kiirtöö")) ? true : false;
        if(temp.length == 3) return new VäliseMonitorigaArvuti(temp[0], onkiirtoo, regaeg);
        else return new Arvuti(temp[0], onkiirtoo, regaeg);
    }

    private static void kirjutaOotel(Sessioon sessioon){

    }


}

