import java.util.ArrayList;

public class Sessioon {
    private ArrayList<Arvuti> kiirtood;
    private ArrayList<Arvuti> tavatood;
    private ArrayList<Arvuti> tehtud;
    
    public Sessioon(ArrayList<Arvuti> arvutid){
        this.kiirtood = new ArrayList<>();
        this.tavatood = new ArrayList<>();
        this.tehtud = new ArrayList<>();

        for(Arvuti a : arvutid){
            if(a.onKiirtöö()) this.kiirtood.add(a);
            else this.tavatood.add(a);
        }
    }

    public void lisaArvuti(Arvuti arvuti){
        if(arvuti.onKiirtöö()) this.kiirtood.add(arvuti);
        else this.tavatood.add(arvuti);
    }

    public void parandaArvuti(Arvuti arvuti, double tasu){
        arvuti.setArvesumma(tasu);
        
        tehtud.add(arvuti);

        if(kiirtood.contains(arvuti)) kiirtood.remove(arvuti);
        else tavatood.remove(arvuti);
    }

    public ArrayList<Arvuti> getKiirtood(){
        return this.kiirtood;
    }

    public ArrayList<Arvuti> getTavatood(){
        return this.tavatood;
    }

    public ArrayList<Arvuti> getTehtud(){
        return this.tehtud;
    }
}
