import java.time.LocalDateTime;

public class VäliseMonitorigaArvuti extends Arvuti{
    public VäliseMonitorigaArvuti(String tootja, boolean onKiirtöö, LocalDateTime registreerimiseAeg){
        super(tootja, onKiirtöö, registreerimiseAeg);
    }

    @Override
    public double arvutaArveSumma(double baashind){
        return 1 + super.arvutaArveSumma(baashind);
    }

    @Override
    public String toString(){
        String[] s = super.toString().split("@");
        return String.format("%s;monitoriga@%s", s[0], s[1]);
    }
}
