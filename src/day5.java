import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class day5 {
    static class data {
        public List<List<Character>> crates;
        public List<Integer[]> moves;

        public data(){
            crates = new ArrayList<>();
            moves = new ArrayList<>();
        }
    }        

    public static void solve(String fileName) throws IOException{
        data all = parse(fileName);
        for (Integer[] move : all.moves) {
            Character temp = ' ';
            for (int i = 0; i < move[0]; i++) {
                temp = pop(all.crates.get(move[1] - 1));
                all.crates.get(move[2] - 1).add(temp);
            }
        }
        for (List<Character> chars : all.crates) {
            System.out.print(chars.get(chars.size() - 1));
        }
        System.out.println();
    }

    public static void solve2(String fileName) throws IOException{
        data all = parse(fileName);
        List<Character> temp = new ArrayList<>();
        for (Integer[] move : all.moves) {
            temp = pop(all.crates.get(move[1] - 1), move[0]);
            all.crates.get(move[2] - 1).addAll(temp);
        }
        for (List<Character> chars : all.crates) {
            System.out.print(chars.get(chars.size() - 1));
        }
        System.out.println();
    }

    private static List<Character> pop(List<Character> list, Integer integer) {
        List<Character> chars = new ArrayList<>(integer);
        for (int i = 0; i < integer; i++) {
            chars.add(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }
        return chars;
    }

    private static Character pop(List<Character> list) {
        Character r = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return r;
    }

    private static data parse(String fileName) throws IOException{
        data alldata = new data();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        for (int i = 0; i < line.length()+1; i+=4) {
            alldata.crates.add(new ArrayList<>());
        }

        while (true) {
            if(line.isBlank()){
                break;
            }
            for (int i = 0; i < (line.length() + 1) / 4; i++) {
                if(Character.isLetter(line.charAt(1 + (4 * i))))
                    alldata.crates.get(i).add(0, line.charAt(1 +(4 * i)));
            }
            line = reader.readLine();
        }
        line = reader.readLine();

        while(line != null){
            String[] strs = line.split(" ");
            alldata.moves.add(
            new Integer[]{
                Integer.valueOf(strs[1]), 
                Integer.valueOf(strs[3]), 
                Integer.valueOf(strs[5])
            });
            line = reader.readLine();
        }
        reader.close();
        return alldata;
    }
}
