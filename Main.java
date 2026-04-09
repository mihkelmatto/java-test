import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] a = {"a + b = 1", "b  a s = 4", "c = 5"};
        ArrayList<String> avaldised = new ArrayList<>();
        for(String b : a) avaldised.add(b);

        ArrayList<String> tulemus = lisa(avaldised, "d = 9", 0);
        System.out.println(tulemus);

    }

    static ArrayList<String> lisa(ArrayList<String> list, String avaldis, int i){
        ArrayList<String> avaldised = new ArrayList<>();

        if(i == list.size()){
            avaldised.add(avaldis);
            return avaldised;
        }

        int tulemus = Integer.valueOf(avaldis.split(" = ")[1]);
        int temp = Integer.valueOf(list.get(i).split(" = ")[1]);
        
        if(tulemus < temp){
            avaldised.add(avaldis);
            avaldised.addAll(list.subList(i, list.size()));
            return avaldised;
        }
        else{
            avaldised.add(list.get(i));
            avaldised.addAll(lisa(list, avaldis, i+1));
        }
        return avaldised;
    }
}
