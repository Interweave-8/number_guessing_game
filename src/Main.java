import java.util.Scanner;

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
        // 展示已选择的难度
        tools.selectedDifficultyAndTimes(difficulty, guessTimes);
        // 开始猜测
        Scanner sc = new Scanner(System.in);
        int usageTimes = 0;
        for (int i = 0; i < guessTimes; i++) {
            usageTimes++;
            System.out.println(); // 换行
            System.out.println("第" + usageTimes + "次猜测：");
            int guessNum = 0;
            while(true){
                System.out.print("请输入你猜测的数字：");
                if(sc.hasNextInt()){ // 输入是数字
                    guessNum = sc.nextInt();
                    if (guessNum < 1 || guessNum > 100) { // 输入不在1-100之间
                        System.out.println("请输入1-100之间的数字！");
                        System.out.println();
                    }
                    else{ // 输入合法
                        if (gameTools.guessNum(guessNum, randomNum)) { // 猜对了
                            System.out.println("游戏结束！");
                            return;
                        }
                        else { // 猜错了
                            if (i == guessTimes - 1) { // 次数用完
                                System.out.println("次数用完，游戏结束！");
                                break;
                            }
                            else { // 次数未用完
                                System.out.println("你还有" + (guessTimes - usageTimes) + "次机会！");
                                break;
                            }

                        }
                    }
                }else{ // 输入不是数字
                    System.out.println("无效输入，请输入数字！");
                    System.out.println();
                    sc.next(); // 清空输入
                }
            }
        }
    }
}
