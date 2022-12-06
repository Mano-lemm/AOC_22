import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class day6 {
    public static void solve(String fileName) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        char[] chars = reader.readLine().toCharArray();
        for (int i = 3; i < chars.length; i++) {
            if(allDistinct(chars[i - 3], chars[i - 2], chars[i - 1], chars[i])){
                System.out.println(i + 1);
                break;
            }
        }
        reader.close();
    }

    public static void solve2(String fileName) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        char[] chars = reader.readLine().toCharArray();
        for (int i = 13; i < chars.length; i++) {
            if(allDistinct(
                chars[i - 13], chars[i - 12], chars[i - 11], chars[i - 10],
                chars[i - 9], chars[i - 8], chars[i - 7], chars[i - 6],
                chars[i - 5], chars[i - 4], chars[i - 3], chars[i - 2],
                chars[i - 1], chars[i])){
                        System.out.println(i + 1);
                        break;
                    }
        }
        reader.close();
    }

    private static boolean allDistinct(char... chars) {
        Set<Character> set = new HashSet<>();
        for (Character character : chars) {
            set.add(character);
        }
        return set.size() == chars.length;
    }
}
