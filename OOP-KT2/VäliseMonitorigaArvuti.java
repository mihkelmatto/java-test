import java.time.LocalDateTime;

public class VäliseMonitorigaArvuti extends Arvuti{

    public VäliseMonitorigaArvuti(String tootja, boolean onKiirtöö, LocalDateTime registreerimiseAeg){
        super(tootja, onKiirtöö, registreerimiseAeg);
    }
    
    @Override
    public double arvutaArveSumma(double baashind){
        return super.arvutaArveSumma(baashind) + 1;
    }
}
