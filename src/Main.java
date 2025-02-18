import javax.print.attribute.standard.MediaSize;
import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // 创建一个Tools对象
        Tools tools = new Tools();
        // 创建一个DifficultyFile对象
        DifficultyFile difficultyFile = new DifficultyFile();
        // 创建一个GameTools对象
        GameTools gameTools = new GameTools();

        // 创建一个难度的枚举类型，用于存放选择的难度
        Difficulty difficulty = null;
        // 存储猜测次数
        int guessTimes = 0;

        /* 初始欢迎界面与难度选择 */
        tools.welcome();
        tools.tipsBeforeGame();
        int difficultyInt = tools.showAndSelectDifficulty();

        /* 解析选择的游戏难度 */
        // 存放难度和其对应的数字的文件
        String path = "static/difficulty.txt";
        // 检查文件是否存在，不存在则创建文件
        difficultyFile.createDifficultyTxtFile(path);
        // 读取文件内容,并将选择的数字转换为对应的难度，返回枚举类型，存放在difficulty中
        difficulty = difficultyFile.readFromFile(path, difficultyInt);
        switch (difficulty) {
            case EASY:
                guessTimes = 10;
                System.out.println("你选择了简单难度，你有10次机会猜测");
                break;
            case MEDIUM:
                guessTimes = 5;
                break;
            case HARD:
                guessTimes = 3;
                break;
        }

        /* 正式开始游戏 */
        // 生成一个随机数
        int randomNum = gameTools.getRandomNum();
        // 猜测次数

    }
}