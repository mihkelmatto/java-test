package OOPkodu2;

public class Lõbustuspark {
    private Vaateratas lõbustus;
    public Lõbustuspark(Vaateratas lõbustus){
        this.lõbustus = lõbustus;
    }
    public void alustaSeiklust(Külastaja külastaja){
        System.out.println("alustan seiklust");
        lõbustus.lõbusta(külastaja);
        System.out.println(külastaja.kõikKirjeldused());
    }
}
