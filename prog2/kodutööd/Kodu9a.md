/***********************************
 * Programmeerimine II. LTAT.03.007
 * 2025/2026 kevadsemester
 *
 * Kodutöö nr 9a
 * Teema: Sõnetöötlus
 *
 * Autor: Mihkel Matto
 * 
 **********************************/

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Kodu9a {
    /*
    Väljastab 10 kõige sagedasemalt esinevat sõna, järjestatud sageduse, seejärel leksikograafia põhjal.
    Kui kümnenda sõna sagedust jagab rohkem sõnu, siis väljastatakse ka need.
    Loetakse ainult sõnu, mille kohta esineb ka väikese algustähega variant.

    Argumendid:
    failinimi       fail, millest sõnu otsitakse
    @return         void, väljastab andmed terminali
    */

    public static void sagedasedSõnad(String failinimi) throws IOException{
        ArrayList<String> sonad = loefail(failinimi);
        Collections.sort(sonad);
        
        TreeMap<Integer, ArrayList<String>> sagedused = leiasagedused(sonad);
        
        int i = 10;
        for(int sagedus : sagedused.keySet()){
            if(i <= 0) break;

            List<String> kirjed = sagedused.get(sagedus);

            System.out.printf("%s korda: %s\n", sagedus, kirjed);
            i -= kirjed.size();
        }
    }

    /*
    Leiab sõnade esinemise sageduse ning tagastab vastavustabeli formaadis (Integer sagedus : ArrayList<String> sõna)
    Vastavustabel on sorteeritud sageduse kahanevad järjestuses ning iga kirje järjend on sorteeritud leksikograafiliselt
    Eeltingimuseks on sorteeritud sõnade järjend.

    Argumendid:
    sonad       massiiv, mille kohta sagedustabelit koostatakse
    @return     vastavustabel eelnevalt kirjeldatud formaadis
    */

    public static TreeMap<Integer, ArrayList<String>> leiasagedused(ArrayList<String> sonad){
        TreeMap<Integer, ArrayList<String>> sagedused = new TreeMap<>(Comparator.reverseOrder());

        String hetkesona = sonad.get(0); 
        int loendur = 1;
        

        for(int i = 1; i < sonad.size(); i++){
            String sona = sonad.get(i);

            if(sona.equals(hetkesona)){
                loendur++;
            }
            else{
                if(!sagedused.keySet().contains(loendur)){
                    sagedused.put(loendur, new ArrayList<String>());
                }
                sagedused.get(loendur).add(hetkesona);
                hetkesona = new String(sona);
                loendur = 1;
            }
        }

        if(!sagedused.keySet().contains(loendur)){
            sagedused.put(loendur, new ArrayList<String>());
        }
        sagedused.get(loendur).add(hetkesona);

        return sagedused;
    }

    /*
    Loeb failist sõnad ning salvestab ainult sellised, mis on:
    - 5+ pikkusega
    - suurtähega, juhul kui väiketähega varianti ei eksisteeri
    enne eelnevate tingimuste kontrollimist eemaldatakse ka märgid, mida ei esine eesti-ladina tähestikus

    Argumendid:
    failinimi   fail, kust sõnu loetakse
    @return     massiiv, kus on ainult sobivad sõnad
    */

    public static ArrayList<String> loefail(String failinimi) throws IOException{
        ArrayList<String> sonad = new ArrayList<>();
        ArrayList<String> suurtahega = new ArrayList<>();

        try(Scanner scanner = new Scanner(new File(failinimi), "UTF-8")){
            while(scanner.hasNextLine()){
                String[] rida = scanner.nextLine().strip().split(" ");

                for(String sona : rida){
                    sona = sona.replaceAll("[^a-zA-Z-õäöüÕÄÖÜ]", "");

                    if(sona.length() >= 5){
                        if(sona.equals(sona.toLowerCase())){
                            sonad.add(sona);
                        }
                        else suurtahega.add(sona);
                    }
                }
            }
        }
        for(String sona : suurtahega){
            if(sonad.contains(sona.toLowerCase())) sonad.add(sona.toLowerCase());
        }

        return sonad;
    }
}