import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class DifficultyFile {

    // 将难度和其对应的数字写入文件
    public void writeToFile() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "easy");
        map.put(2, "medium");
        map.put(3, "hard");
        String path = "static/difficulty.txt";
        System.out.println(System.getProperty("user.dir"));
        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
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

    public void createDifficultyTxtFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                // 根据文件的父目录创建目录，父路径可以是多级目录
                Files.createDirectories(file.toPath().getParent());
                // 创建文件
                file.createNewFile();
                DifficultyFile difficultyFile = new DifficultyFile();
                difficultyFile.writeToFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 读取文件内容,并将选择的数字转换为对应的难度，返回枚举类型
    public Difficulty readFromFile(String path,int difficultyInt) {
        HashMap<Integer, String> map = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] str = line.split(" ");
                map.put(Integer.parseInt(str[0]), str[1]);
//                System.out.println("当前读取的是：" + map.get(Integer.parseInt(str[0])));
            }
//            System.out.println(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 将数字转换为对应的难度，然后转成枚举类型
        String difficultyStr = map.get(difficultyInt).toUpperCase();
        Difficulty difficultyEnum = Difficulty.valueOf(difficultyStr);
        System.out.println("当前选择的难度是：" + difficultyEnum.getValue());
        return difficultyEnum;
    }

}
