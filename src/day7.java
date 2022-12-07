import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day7 {
    private static class dir{
        public List<file> files;
        public Map<String, dir> dirs;
        public dir parent;
        public Integer size;

        public dir(dir parent){
            files = new ArrayList<>();
            dirs = new HashMap<>();
            this.parent = parent;
        }
    }

    private static class file{
        public String name;
        public int size;

        public file(String name, int size){
            this.name = name;
            this.size = size;
        }
    }

    public static void solve(String fileName) throws IOException{
        dir root = parse(fileName);
        List<Integer> dirSizes = getDirSizesUnder100K(root);
        System.out.println(sum(dirSizes));
    }

    public static void solve2(String fileName) throws IOException{
        dir root = parse(fileName);
        getDirSizesUnder100K(root);
        System.out.println(smallestOverthreshHold(root, 30000000 - (70000000 - root.size)));
    }

    private static Long smallestOverthreshHold(day7.dir root, int threshhold) {
        Long min = Long.MAX_VALUE;
        if(root.size > threshhold){
            min = (long) root.size;
        }
        for (dir d : root.dirs.values()) {
            long val = smallestOverthreshHold(d, threshhold);
            if(val < min && val > threshhold){
                min = val;
            }
        }
        return min;
    }

    private static Integer sum(List<Integer> dirSizes) {
        int total = 0;
        for (Integer integer : dirSizes) {
            total += integer;
        }
        return total;
    }

    private static List<Integer> getDirSizesUnder100K(day7.dir root) {
        List<Integer> r = new ArrayList<>();
        if(getDirSize(root) < 100000){
            r.add(getDirSize(root));
        }
        for (dir entry : root.dirs.values()) {
            r.addAll(getDirSizesUnder100K(entry));
        }
        return r;
    }

    private static int getDirSize(day7.dir root) {
        if(root.size != null){
            return root.size;
        }
        int total = 0;
        for (file f : root.files) {
            total += f.size;
        }
        for (dir d : root.dirs.values()) {
            total += getDirSize(d);
        }
        root.size = total;
        return total;
    }

    private static day7.dir parse(String fileName) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String[] line = reader.readLine().split(" ");
        String rawLine = "";
        dir cur = new dir(null);

        while(rawLine != null){
            if(line[0].equals("$")){
                if(line[1].equals("cd")){
                    if(line[2].equals("/")){
                        while(cur.parent != null){
                            cur = cur.parent;
                        }
                    } else if(line[2].equals("..")){
                        cur = cur.parent;
                    } else{
                        cur = cur.dirs.get(line[2]);
                    }
                } else if(line[1].equals("ls")){
                    // do nothing
                }
            } else if(line[0].equals("dir")){
                cur.dirs.put(line[1], new dir(cur));
            } else {
                cur.files.add(new file(line[1], Integer.valueOf(line[0])));
            }

            rawLine = reader.readLine();
            if(rawLine != null){
                line = rawLine.split(" ");
            }
        }

        while(cur.parent != null){
            cur = cur.parent;
        }
        reader.close();
        return cur;
    }
}
