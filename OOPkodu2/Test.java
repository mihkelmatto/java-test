package OOPkodu2;

public class Test {
    public static void main(String[] args) {
        Vaateratas vaateratas1 = new Vaateratas();
        Lõbustuspark lõbustuspark1 = new Lõbustuspark(vaateratas1);
        Külastaja külastaja1 = new Külastaja();
        
        lõbustuspark1.alustaSeiklust(külastaja1);
    }
}
