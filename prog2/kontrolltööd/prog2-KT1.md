/***********************************
 * Programmeerimine II. LTAT.03.007
 * 2025/2026 kevadsemester
 *
 * Kontrolltöö nr 1
 * Teema: järjendid
 *
 * Autor: Mihkel matto
 *
 **********************************/


import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Arrays;
public class Kt1 {

        public static void main(String[] args) {
        // Ülesanne 1 ---------------------------------
        int n = 4;
        // Ülesanne 2 ---------------------------------
        int[] massiiv1 = {1, 4, 3, 1, 4, 5, 8, 2, 6, 7};
        int[] massiiv2 = {2, 1, 7, 4, 9, 5, 4, 1, 6, 9};
        int[] test = {0, 0, 0, 0, 0};
        // Ülesanne 3 ---------------------------------
        int[][] maatriks1 = {
                {1, 2, 3},
                {4, 5, 2}};
        int x1 = 5;
        int[][] maatriks2 = {
                {1, 2, 3},
                {4, 5, 2},
                {1, 1, 4}};
        int x2 = 4;
        int[][] maatriks3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int x3 = 5;

        kauss(10);


    }



    /*
    Sisend: n>=2
    joonistab kausi, kus põhja pikkus on n ning servade paksus n-i
    põhja summa: k(k+1)/2 ?
    asub võimalikult vasakul ja pole tühje ridu
    
    +
     ++          ++
       +++    +++
          ++++
    */

    public static void kauss(int n) {
        int reapikkus = n * n;
        String rida = " ".repeat(reapikkus);

        int vahe = 0;

        for(int i = 1; i<=n; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(rida);

            sb = sb.replace(vahe, i+vahe, "+".repeat(i));
            sb = sb.replace(reapikkus - (i+vahe), reapikkus-vahe, "+".repeat(i));

            vahe += i;
            System.out.println(sb.toString());
        }
    }

    /*
    Tagastab eesosa lõppkoordinaadi ja tagasoa alguskoordinaadi, kus vastavate alamjärjendite summad on võrdsed.
    Leiab esimese ettejuhtuva komplekti või tagastab null, kui komplekt puudub.

    Alamjärjendite otsad ei tohi kokku puutuda
    !!! Peaks muidu töötama, aga kuskil on mingi indeks 1 võrra valesti

    int[] a = järjend, kust summasid otsitakse
    @return = int[2], kus esimene ja teine el. on vastavalt eesosa lõpp- või tagaosa alguskoordinaat
    */

    public static int[] võrdsedEesJaTaga(int[] a) {
        if(a.length < 3) return null;

        int[] vastus = new int[2];
        int sumparem = 0;
        int sumvasak = 0;

        // 1 võrra nihkes, sest +-y (prefiks)
        int i = -1;
        int j = a.length;

        // indeksid??
        while(i < j-1){
            System.out.printf("i: %s, j: %s\n", i, j);
            
            if(sumvasak == sumparem && sumvasak > 0 && sumparem > 0){
                vastus[0] = i;
                vastus[1] = j;
                break;
            }

            if(sumvasak == 0 && sumparem == 0){
                sumvasak += a[++i];
                sumparem += a[--j];
            }
            
            else if(sumvasak > sumparem){
                sumparem += a[--j];
            }
            else if(sumvasak < sumparem){
                sumvasak += a[++i];
            }
            System.out.printf("vasak: %s, parem: %s\n\n", sumvasak, sumparem);
        }
        ////
        if(vastus[0] == 0) return null;
        else return vastus;
    }

/*
Otsib sisendmaatriksist sisendmuutujale vastavad elemendid, 
seejärel kustutab (seab nullväärtuseks) maariksi sellised diagonaalid, mis läbivad antud väärtust.

int[][] a = sisendmaatriks
int x = element, mille suhtes diagonaalid kustutatakse
@return: int[][], sisendmaatriksi koopia, kust on vastavad diagonaalid kustutatud


*/
    public static int[][] kustutaDiag(int[][] a, int x) {
        int ylen = a.length;
        int xlen = a[0].length;

        int[][] uus = new int[ylen][xlen];

        // kopeerib maatriksi
        for(int i = 0; i<ylen; i++){
            for(int j = 0; j<xlen; j++){
                uus[i][j] = a[i][j];
            }
        }

        // otsib x-väärtusi ning laseb meetodil kustuta() eemaldada vastavad diagonaalid
        for(int i = 0; i<ylen; i++){
            for(int j = 0; j<xlen; j++){
                if(uus[i][j] == x) kustuta(uus, i, j);
            }
        }
        
        return uus;
    }

    /*
    Kustutab maatriksist selliste diagonaalide elemendid, mis läbivad sisendkoordinaate
    int[][] uus = sisendmaatriks
    int i = maatriksi y-koordinaat (kõrgus)
    int j = maatriksi x-koordinaat (laius)
    @return = void, muudab sisendmaatriksi väärtusi otse.

    Programm käib iga suuna läbi eraldi for-tsüklis ning seab väärtused nullideks.
    */
    public static void kustuta(int[][] uus, int i, int j){
        int ylen = uus.length;
        int xlen = uus[0].length;
        
        // üles-vasak
        int y = i, x = j;
        while(y >= 0 && x >= 0){
            uus[y][x] = 0;
            y--;
            x--;
        }
        // üles-parem
        y = i;
        x = j;
        while(y >= 0 && x < xlen){
            uus[y][x] = 0;
            y--;
            x++;
        }

        // alla-parem
        y = i;
        x = j;
        while(y < ylen && x < ylen){
            uus[y][x] = 0;
            y++;
            x++;
        }
        
        // alla-vasak
        y = i;
        x = j;
        while(y < ylen && x >= 0){
            uus[y][x] = 0;
            y++;
            x--;
        }
    }



}
