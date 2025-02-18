import java.util.Scanner;

public class Tools {

    // 欢迎语
    public void welcome() {
        System.out.println("欢迎游玩猜数字游戏！");
    }

    // 游戏规则
    public void tipsBeforeGame() {
        System.out.println("游戏规则：");
        System.out.println("1. 系统会随机生成一个1-100之间的整数。");
        System.out.println("2. 你有一定次数的机会猜这个数字。");
        System.out.println("3. 系统会根据你的猜测，提示你猜的数字是偏大还是偏小。");
        System.out.println("祝你好运！");
    }

    // 展示并选择难度
    public int showAndSelectDifficulty(){
        System.out.println("可选择的游戏难度如下：");
        System.out.println("1. 简单Easy(10次机会)");
        System.out.println("2. 中等Medium(5次机会)");
        System.out.println("3. 困难Hard(3次机会)");
        Scanner sc = new Scanner(System.in);
        int selectedDifficulty = 0;
        while (true){
            System.out.print("请输入对应的数字选择难度：");
            if(sc.hasNextInt()) {
                selectedDifficulty = sc.nextInt();
                if (selectedDifficulty == 1 || selectedDifficulty == 2 || selectedDifficulty == 3) {
                    break;
                }else {
                    System.out.println("输入有误，请重新输入！"); // 数字不在1-3之间
                    System.out.println();
                }
            }else{
                System.out.println("输入有误，请重新输入！"); // 输入不是数字
                System.out.println();
                sc.next();
            }
        }
        return selectedDifficulty;
    }

    // 已选择的难度
    public void selectedDifficultyAndTimes(Difficulty difficulty,int times) {
        System.out.println("你选择了" + difficulty.getValue() + "难度，你有" + times + "次机会猜数字。");
    }
}
