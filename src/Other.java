import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Other {

    public void writeToFile() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"easy");
        map.put(2,"medium");
        map.put(3,"hard");
        String path = "static/difficulty.txt";
        System.out.println(System.getProperty("user.dir"));
        try{
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            for(Map.Entry<Integer, String> entry : map.entrySet()){
                bw.write(entry.getKey() + " " + entry.getValue());
                bw.newLine();
            }
            bw.close();
            fw.close();
            System.out.println("HashMap内容已成功写入 " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
