import java.util.ArrayList;
import java.util.HashMap;

public class Sessioon {
    private ArrayList<Arvuti> arvutid;
    private HashMap<String, Integer> parandatud;    // tootja: kogus
    private double raha;

    Sessioon(){
        this.arvutid = new ArrayList<>();
        this.parandatud = new HashMap<>();
        this.raha = 0.0;
    }

    public void paranda(Arvuti arvuti, double hind){
        String tootja = arvuti.getTootja();
        Integer kogus = this.parandatud.get(tootja);

        if(kogus == null) kogus = 1;
        else kogus++;

        this.parandatud.put(tootja, kogus);
        this.arvutid.remove(arvuti);
        this.raha += hind;
    }
    
    public void addArvuti(Arvuti arvuti){
        this.arvutid.add(arvuti);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(String s : parandatud.keySet()){
            sb.append(String.format("%s: %stk\n", s, parandatud.get(s)));
        }

        return String.format("""
             Sessiooni kokkuvõte:
             Teenitud raha: %s
             Parandatud arvuteid:
             %s
             Ootele jäi %s arvuti(t).   
                """, this.raha, sb, this.arvutid.size());
    }

}
