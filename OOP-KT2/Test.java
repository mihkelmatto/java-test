import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Arvuti arvuti = new Arvuti("t", false, null);
        Arvuti arvuti2 = new Arvuti("t", false, null);
        ArrayList<Arvuti> arvutid = new ArrayList<>();
        arvutid.add(arvuti);
        System.out.println(arvutid.contains(arvuti2));
    }
}
