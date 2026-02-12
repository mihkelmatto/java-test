
public class prog2 {
    public static void main(String[] args) {

    f1(6);
    f2();
    }

public static void f2(){
    //4x + 3y − 9z = 5 // x, y, x <= 100
    for (int x = 0; x < 100; x++) {
        for (int y = 0; y < 100; y++) {
            for (int z = 0; z < 100; z++) {
                if ((4*x + 3*y − 9*z) == 5)
                    System.out.println();
    }
    }
    }

}



public static void f1(int x){
    int i = 0;

    System.out.println("#".repeat(x));
    for(i = 0; i < x-2; i++){
        System.out.println("#" + " ".repeat(x-2) + "#");
    } 
    System.out.println("#".repeat(x));



    System.out.println("#".repeat(x));
    for(i = 1; i < x-1; i++){
        System.out.println(" ".repeat(i) + "#" + " ".repeat(x-2) + "#");
    } 
    System.out.println(" ".repeat(i) + "#".repeat(x));



    for(i=1; i<=x; i++){
        System.out.println(" ".repeat(i) + "#".repeat(i));
    }

}


}
