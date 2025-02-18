import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Tools tools = new Tools();

        tools.welcome();
        tools.tipsBeforeGame();
        int difficulty = tools.showAndSelectDifficulty();
        System.out.println(difficulty);

        String path = "static/difficulty.txt";
        File file = new File(path);
        if(!file.exists()){
            try{
                // 根据文件的父目录创建目录，父路径可以是多级目录
                Files.createDirectories(file.toPath().getParent());
                // 创建文件
                file.createNewFile();
                Other other = new Other();
                other.writeToFile();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        // 读取文件内容
        HashMap<Integer, String> map = new HashMap<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            System.out.println("读取文件内容:");
            while ((line = br.readLine()) != null) {
                String[] str = line.split(" ");
                map.put(Integer.parseInt(str[0]), str[1]);
//                System.out.println("当前读取的是：" + map.get(Integer.parseInt(str[0])));
            }
//            System.out.println(map);
        }catch (IOException e){
            e.printStackTrace();
        }




    }
}