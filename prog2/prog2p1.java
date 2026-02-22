package prog2;
class prog2p1 {
    public static void main(String[] args) {
        shiftnr(5);
    }
    static void shiftnr(int n){
        // ristkülik
        for(int i = 0; i <= n; i++){
            if(i == 0 || i == n){
                System.out.println("#".repeat(n));
            }
            else{
                System.out.println("#" + " ".repeat(n-2) + "#");
            }
        }
        // rööpkülik
        for(int i = 0; i <= n; i++){
            if(i == 0 || i == n){
                System.out.println(" ".repeat(i) + "#".repeat(n));
            }
            else{
                System.out.println(" ".repeat(i) + "#" + " ".repeat(n-2) + "#");
            }
        }
        // ül c - aritm.jada
        for(int i = 0, sum = 0; i <= n; i++){
            System.out.println(" ".repeat(sum) + "#".repeat(i));
            sum += i;
        }
        // ül d - aritm.jada
        for(int i = 1, sum = (1+n)*n/2; i <= n; i++){
            System.out.println(" ".repeat(sum - i) + "#".repeat(i));
            sum -= i;
        }
        // 
       
        for(int i = 0, sum = n; i <= n; i++){
            if(i == 0){
                 System.out.println("#".repeat(sum));
            }
            else{
                System.out.println("#".repeat(n/2) + " ".repeat() );
            }
            
        }

    }   
}
