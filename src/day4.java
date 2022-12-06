import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day4 {
    public static void solve(String fileName) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int total = 0;
        String line = reader.readLine();
        while(line != null){
            String[] parts = line.split(",");
            if(contains(parts[0], parts[1]))
                total++;
            
            line = reader.readLine();
        }

        System.out.println(total);
        reader.close();
    }

    public static void solve2(String fileName) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int total = 0;
        String line = reader.readLine();
        while(line != null){
            String[] parts = line.split(",");
            if(overlaps(parts[0], parts[1]))
                total++;
            
            line = reader.readLine();
        }

        System.out.println(total);
        reader.close();
    }

    private static boolean overlaps(String string, String string2) {
        if(
            (
                Integer.valueOf(string.split("-")[0]) <=
                Integer.valueOf(string2.split("-")[0])
            ) &&
            (
                Integer.valueOf(string.split("-")[1]) >=
                Integer.valueOf(string2.split("-")[0])
            )
        ){
            return true;
        }
        if(
            (
                Integer.valueOf(string.split("-")[0]) <=
                Integer.valueOf(string2.split("-")[1])
            ) &&
            (
                Integer.valueOf(string.split("-")[0]) >=
                Integer.valueOf(string2.split("-")[0])
            )
        ){
            return true;
        }
        return false;
    }

    private static boolean contains(String string, String string2) {
        if( 
            (
                Integer.valueOf(string.split("-")[0]) <=
                Integer.valueOf(string2.split("-")[0])
            ) &&
            (
                Integer.valueOf(string.split("-")[1]) >=
                Integer.valueOf(string2.split("-")[1])
            )
        ){
            return true;
        }
        if( 
            (
                Integer.valueOf(string.split("-")[0]) >=
                Integer.valueOf(string2.split("-")[0])
            ) &&
            (
                Integer.valueOf(string.split("-")[1]) <=
                Integer.valueOf(string2.split("-")[1])
            )
        ){
            return true;
        }
        return false;
    }
}
