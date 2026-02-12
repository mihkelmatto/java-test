
import javax.sound.sampled.SourceDataLine;

public class Main {
    public static void main(String[] args) {
        String day = "Saturday";
        boolean weekday;

        switch(day) {
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> weekday = true;
            case "Saturday", "Sunday" -> weekday = false;
            default -> weekday = false;
        }
        if (weekday) {
            System.out.println("It's a weekday");
        }
        else{
            System.out.println("It's weekend");
        }
    }
}
