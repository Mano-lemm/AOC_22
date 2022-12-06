import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class day3 {
    public static void solve(String fileName) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        int total = 0;
        while(line != null){
            String[] parts = divide(line);
            char overlap = getOverlap(parts[0], parts[1]);
            total += getPriority(overlap);
            line = reader.readLine();
        }

        System.out.println(total);
        reader.close();
    }

    public static void solve2(String fileName) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int total = 0;
        String[] lines = {"","",""};
        String newline = reader.readLine();
        while(newline != null || isfull(lines)){
            if(isfull(lines)){
                char overlap = getOverlap(lines);
                total += getPriority(overlap);
                lines = new String[]{"","",""};
                continue;
            }
            else{
                lines = append(lines, newline);
            }
            newline = reader.readLine();
        }

        System.out.println(total);
        reader.close();
    }

    private static String[] append(String[] lines, String newline) {
        for (int i = 0; i < lines.length; i++) {
            if(lines[i].isBlank()){
                lines[i] = newline;
                return lines;
            }
        }
        return lines;
    }

    private static boolean isfull(String[] lines) {
        for (String string : lines) {
            if(string.isBlank()){
                return false;
            }
        }
        return true;
    }

    private static int getPriority(char overlap) {
        if(overlap == 127){
            return 0;
        }
        if(overlap <= 90){
            return overlap - 38;
        }
        return overlap - 96;
    }

    private static List<Character> toCharArray(String string){
        List<Character> c = new ArrayList<>();
        for (char ch : string.toCharArray()) {
            c.add((Character) ch);   
        }
        return c;
    }

    private static char getOverlap(String... strings){
        Set<Character> overlap = new HashSet<>(toCharArray(strings[0]));
        for (String string : strings) {
            overlap.retainAll(toCharArray(string));
        }
        return (Character) overlap.toArray()[0];
    }

    private static String[] divide(String line) {
        String[] s = new String[2];
        char[] cs = line.toCharArray();
        s[0] = String.valueOf(Arrays.copyOfRange(cs, 0, cs.length / 2));
        s[1] = String.valueOf(Arrays.copyOfRange(cs, cs.length / 2, cs.length));
        return s;
    }
}
