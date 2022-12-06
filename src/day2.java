import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day2 {
    public static void solve(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line = reader.readLine();
        int totalScore = 0;
        while(line != null){
            String[] args = line.split(" ");
            totalScore += getNewScore(args);
            line = reader.readLine();
        }
        
        System.out.println(totalScore);
        reader.close();
    }

    public static int getScore(String[] args){
        if(args[1].equals("X")){
            switch (args[0]) {
                case "A":
                    return 4;
                case "B":
                    return 1; 
                case "C":
                    return 7;        
            }
        }
        if(args[1].equals("Y")){
            switch (args[0]) {
                case "A":
                    return 8;
                case "B":
                    return 5; 
                case "C":
                    return 2;        
            }
        }
        if(args[1].equals("Z")){
            switch (args[0]) {
                case "A":
                    return 3;
                case "B":
                    return 9; 
                case "C":
                    return 6;        
            }
        }
        return 0;
    }

    public static int getNewScore(String[] args){
        if(args[1].equals("X")){
            switch (args[0]) {
                case "A":
                    return 3;
                case "B":
                    return 1; 
                case "C":
                    return 2;        
            }
        }
        if(args[1].equals("Y")){
            switch (args[0]) {
                case "A":
                    return 4;
                case "B":
                    return 5; 
                case "C":
                    return 6;        
            }
        }
        if(args[1].equals("Z")){
            switch (args[0]) {
                case "A":
                    return 8;
                case "B":
                    return 9; 
                case "C":
                    return 7;        
            }
        }
        return 0;
    }
}
