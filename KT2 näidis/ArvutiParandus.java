import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ArvutiParandus {

    public static void main(String[] args) {
        args = new String[]{"andmed.txt"};
        Sessioon sessioon = new Sessioon();

        try(Scanner scanner = new Scanner(System.in)){
            while(true){    
                System.out.println("Kas soovid parandada (P), uut tööd registreerida (R) või lõpetada (L) ?");
                String in = scanner.nextLine();
                if(in.equals("P")){
                    parandus(sessioon);
                }
                else if(in.equals("R")){
                    registreeri(sessioon);
                }
                else if(in.equals("L")){
                    System.out.println(sessioon.toString());
                    salvestafail(sessioon);
                    break;
                }
                else{
                    System.out.printf("%s ei ole sobiv sisend!\n", in);
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static void parandus(Sessioon sessioon){
        try(Scanner scanner = new Scanner(System.in)){
            while(true){    
                System.out.println("Arvuti info: ");
                Arvuti arvuti = loeArvuti(scanner.nextLine());

                System.out.println("Sisesta parandamiseks kulunud aeg (täisminutites): ");
                arvuti.setParandusaeg(Integer.parseInt(scanner.nextLine()));

                System.out.println("Sisesta enda nimi: ");
                String parandaja = scanner.nextLine();

                
                double hind = arvuti.arvutaArveSumma(leiabaashind(parandaja));
                sessioon.paranda(arvuti, hind);
                System.out.printf("Töö tehtud, arve summa on %s €\n", hind);

                break;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static double leiabaashind(String parandaja){
        File file = new File("tunnitasud.dat");
        double hind = 1.0;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))){
            String line;
            reader.readLine();
            while((line = reader.readLine()) != null){
                if(line.equals(parandaja)){
                    hind = Double.parseDouble(reader.readLine().strip());
                    break;
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return hind;
    }

    static void registreeri(Sessioon sessioon){
        try(Scanner scanner = new Scanner(System.in)){
            while(true){    
                System.out.println("Sisesta töö kirjeldus: ");
                String in = scanner.nextLine();
                
                sessioon.addArvuti(loeArvuti(in));
                break;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static ArrayList<Arvuti> loefail(String path){
        ArrayList<Arvuti> arvutid = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))){
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

    static void salvestafail(Sessioon sessioon){
        File tehtud = new File("tehtud.dat");
        File ootel = new File("ootel.txt");

        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"))){
            String line;
            while((line = reader.readLine()) != null){
                arvutid.add(loeArvuti(line));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

    }

    static Arvuti loeArvuti(String kirjeldus){
        // aeg
        LocalDateTime aeg;
        String[] temp;
        if(kirjeldus.contains("@")){
            temp = kirjeldus.strip().split("@");
            aeg = LocalDateTime.parse(temp[1]);
            kirjeldus = temp[0];
        }
        else aeg = LocalDateTime.now();

        // firma, kiirtöö, monitor
        temp = kirjeldus.strip().split(";");

        if(temp.length > 3 || temp.length < 2){}// exception: vale pikkus
        if(!temp[1].equals("kiirtöö") || !temp[1].equals("tavatöö")){} // exception: pole valiidne töö
        if(temp.length == 3 && !temp[2].equals("monitoriga")){} // exception: monitori tekst katki

        boolean onKiirtöö = (temp[1].equals("kiirtöö")) ? true : false;
        if(temp.length == 2) return new Arvuti(temp[0], onKiirtöö, aeg);
        else return new VäliseMonitorigaArvuti(temp[0], onKiirtöö, aeg);

    }

}
