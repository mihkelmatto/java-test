package OOPkodu2;

import java.util.ArrayList;
import java.util.List;

public class Külastaja {
    private List<String> külastuseKirjeldused;

    public Külastaja(){
        this.külastuseKirjeldused = new ArrayList<>();
    }
    public void lisaKirjeldus(String kirjeldus){
        this.külastuseKirjeldused.add(kirjeldus);
    }
    public List<String> kõikKirjeldused(){
        return this.külastuseKirjeldused;
    }
}
