import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day1 {
    public static void solve(String input) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(input));
        int max = -1;
        int tmp = 0;
        String line = reader.readLine();
        while(line != null){
            if(line.isBlank()){
                if(tmp > max){
                    max = tmp;
                }
                tmp = 0;
            }
            else {
                tmp += Integer.valueOf(line);
            }
            line = reader.readLine();
        }
        System.out.println(max);
        reader.close();
    }   

    public static void solve2(String fileName) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line = reader.readLine();
        int[] max = {-1, -1, -1};
        int tmp = 0;
        while(line != null){
            if(line.isBlank()){
                updateMax(max, tmp);
                tmp = 0;
            }
            else{
                tmp += Integer.valueOf(line);
            }
            line = reader.readLine();
        }
        System.out.println(total(max));
        reader.close();
    }

    public static int[] updateMax(int[] max, int val){
        for (int i = 0; i < max.length; i++) {
            if(max[i] < val){
                max[i] =  val;
                return max;
            }
        }
        return max;
    }

    public static int total(int[] vals){
        int total = 0;
        for (int i : vals) {
            total += i;
        }
        return total;
    }
}