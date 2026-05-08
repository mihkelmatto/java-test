import java.time.LocalDateTime;

public class Arvuti {
    private String tootja;
    private boolean onKiirtöö;
    private LocalDateTime registreerimiseAeg;
    private int parandusaeg;

    public Arvuti(String tootja, boolean onKiirtöö, LocalDateTime registreerimiseAeg){
        this.tootja = tootja;
        this.onKiirtöö = onKiirtöö;
        this.registreerimiseAeg = registreerimiseAeg;
        this.parandusaeg = 0;
    }

    public void setParandusaeg(int aeg){
        this.parandusaeg = aeg;
    }

    public double arvutaArveSumma(double baashind){
        double summa = 2.0;
        if(this.onKiirtöö) summa += 10;
        return summa + this.parandusaeg * baashind;
    }

    public String getTootja(){
        return this.tootja;
    }

    public boolean getOnKiirtöö(){
        return this.onKiirtöö;
    }

    public LocalDateTime getRegistreerimiseAeg(){
        return this.registreerimiseAeg;
    }

    @Override
    public String toString(){
        String töö = (this.onKiirtöö) ? "kiirtöö" : "tavatöö";
        return String.format("%s;%s@%s", tootja, töö, this.registreerimiseAeg.toString());
    }
}
