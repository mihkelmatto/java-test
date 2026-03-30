/***********************************
 * Programmeerimine II. LTAT.03.007
 * 2025/2026 kevadsemester
 *
 * Kodutöö nr 3b
 * Teema: Maatriksi elementide pööramine
 *
 * Autor: Mihkel Matto
 * 
 * Keelemudeli kasutamine:
 * Kasutatud ChatGPT mudelit järgmistel eesmärkidel:
 * - arutelu lahenduste ideede üle (Kas x idee töötaks, idee probleemkohtade leidmine,
 *                              tegevuste järjestus jms, ilma programmeerimiskeeli kasutamata)
 * - java programmi loogikavigade tuvastamine
 **********************************/




public class Kodu3b-esitus {
    /*
    Leiab maatriksist ringi või uuendab selle ringi elementide väärtusi.

    # parameetrid
    a - maatriks, millest ring moodustatakse
    l - 1-dimensiooniline järjend, kuhu salvestatakse ringi elemendid
    n - ringi indeks väljast loetuna (0 = välimine)
    lisa - tõeväärtus, mis määrab, kumba funktsiooni meetod peab täitma
        lisa == false: Loeb ringi elemendid 1d-järjendisse
        lisa == true:  Loeb 1d-järjendi elemendid ringi
    return - void, kirjutab üle ühe järjendi väärtused.
        lisa == false: kirjutab üle 1d-järjendi
        lisa == true: kirjutab üle maatriksi vastava ringi

    tingimused (Garanteeritud kutsuva meetodi poolt):
    - n peab olema ringi suhtes 0:0 koordinaatidega (kõige vasak-ülemine element)
        ehk siis max n väärtus on ~pool lühema külje pikkust
    - int[] 1d-järjendi pikkus peab olema täpne (muidu rotate ei tööta)
    */

    public static void ring(int[][] a, int[] l, int n, boolean lisa) {
        int ylen = a.length;
        int xlen = a[0].length;
        int rlen = lenR(a, n);

        // tsükli muutujad
        int y = n, x = n;
        int ymax = ylen-1-n, xmax = xlen-1-n;
        
        int iC = 0; // ringi indeks
        int iL = 0; // 1D-listi indeks

        // esimese elemendi käsitlemine
        if(lisa) a[y][x] = l[iL++];
        else l[iC++] = a[y][x];

        // ringjooneline liikumine, iga sammuga lisatakse vastav element listi.
        for(int i = 0; i < rlen-1; i++){ // rlen-1, sest esimene el. on juba lisatud.
            
            if      (y == n && x < xmax)    x++; // paremale
            else if (x == xmax && y < ymax) y++; // alla
            else if (y == ymax && x > n)    x--; // vasakule
            else if (x == n && y > n)       y--; // üles

            if(lisa) a[y][x] = l[iL++];
            else l[iC++] = a[y][x];

        }
    }

    /*
    1-dimensioonilise järjendi pööramine

    # parameetrid
    l - pööratav järjend
    n - pöörde sammude arv (n>=0 paremale; n<0 vasakule)
    return - pööratud järjend

    Negatiivne pööre teisendatakse positiivseks (pööre -n on samaväärne, kui pööre length-n)

    */
    public static int[] PööreL(int[] l, int n){
        int m = l.length;
        if(n<0) n = m+n;
        int[] l2 = new int[m];
        for(int i = 0; i<m; i++){
            l2[(i+n) % m] = l[i];
        }
        return l2;
    }

    /*
    leiab ringi pikkuse

    # parameetrid
    a - maatriks
    n - ringi indeks väljast loetuna (välimise indeks = 0)
    return - ringi pikkus
    */ 
    public static int lenR(int[][] a, int n){
        int x1len = a.length - 2 * n;
        int x2len = a[0].length - 2 * n;

        int rlen;
        if(x1len == 1 || x2len == 1) rlen = (int)Math.max(x1len, x2len); // 1-dimensional
        else rlen = 2*(x1len + x2len - 2); // 2-dimensional
        return rlen;
    }

    /*
    # Programmi tööpõhimõte:
    1. Leitakse ringide arv
    iga ringi kohta:
    2. maatriksi üks ring loetakse 1D-listiks
    3. listi keeratakse
    4. maatriksi ring kirjutatakse üle listi väärtustega


    # piir
    kasutatakse ringi alguskoordinaatide arvutamiseks.
    Maksimaalne alguskoordinaat:
    lühim külg / 2 - 1 (-1, sest indekseid loetakse nullist)
    kui lühim külg on paaritu arv, siis tuleb üles ümardada, et riba oleks k.a.

    # parameetrid:
    a - maatriks
    k - pöörde sammude arv
    return - pööratud maatriks
    */
    public static int[][] pööre(int[][] a, int k){
        int piir = (int) Math.ceil(Math.min(a.length, a[0].length)/2.0);

        for(int i = 0; i<piir; i++){
            int rlen = lenR(a, i);
            int[] l = new int[rlen];
            ring(a, l, i, false);
            l = PööreL(l, k);
            ring(a, l, i, true);
        }
        return a;
    }

    public static void main(String[] args) {
        int[][] m1 = {
            {1, 2, 3, 4, 5},
            {1, 2, 3, 4, 5},
            {1, 2, 3, 4, 5},
        };
        int[][] m2 = {
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3}
        };
        int[][] m3 = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {9, 10, 11},
            {12, 13, 14},
            {15, 16, 17},
            {18, 19, 20},
            {21, 22, 23},
            {24, 25, 26}
        };
        m3 = pööre(m3, 3);
        Helper.print(m3);
    }
}
