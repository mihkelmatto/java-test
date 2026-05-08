import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        read();
    }
    
    static void read(){
        try(
            BufferedReader reader = new BufferedReader(new InputStreamReader(new InputStream(new URI("https://courses.cs.ut.ee/2026/OOP/spring/Main/Practice11Harjutused?action=download&upname=ootel_arvutid.txt"))));
        ){
            ArrayList<String> lines = new ArrayList<>();
            String line;
            while((line = reader.readLine()) != null){
                lines.add(line);
            }
            System.out.println(lines);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static void write(){
        String[] data = {"abc", "def"};

        try(
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("andmed.txt", true)));
        ){
            for(String s : data){
                writer.append(s + "\n");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}