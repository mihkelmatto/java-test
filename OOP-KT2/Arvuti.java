import java.time.LocalDateTime;
import java.util.HashMap;

public class Arvuti {
    private String tootja;
    private boolean onKiirtöö;
    private LocalDateTime registreerimiseAeg;

    public Arvuti(String tootja, boolean onKiirtöö, LocalDateTime registreerimiseAeg){
        this.tootja = tootja;
        this.onKiirtöö = onKiirtöö;
        this.registreerimiseAeg = registreerimiseAeg;
    }

    @Override
    public String toString(){
        String too = (this.onKiirtöö) ? "kiirtoo" : "tavatoo";
        return String.format("Tootja: %s, %s, reg.aeg: %s", this.tootja, too, this.registreerimiseAeg.toString());
    }

    public double arvutaArveSumma(double baashind){
        double summa = 2;
        if(onKiirtöö) summa += 10;
        return summa + baashind;
    }

    public String getTootja(){
        return this.tootja;
    }

    public boolean onKiirtöö(){
        return this.onKiirtöö;
    }

    public LocalDateTime getRegistreerimiseAeg(){
        return this.registreerimiseAeg;
    }
}
