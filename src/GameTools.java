import java.util.Scanner;

// 生成随机数
public class GameTools {
    private int randomNum;

    // 生成1-100之间的随机数
    public int getRandomNum() {
        System.out.println("正在生成1-100之间的随机数...");
        randomNum = (int)(Math.random() * 100 + 1);
        System.out.println("随机数生成完毕");
        return randomNum;
    }

    // 猜测随机数
    public Boolean guessNum(int guessNum, int randomNum) {
        if (guessNum == randomNum) {
            System.out.println("恭喜你，猜对了！");
            return true;
        } else if (guessNum > randomNum) {
            System.out.println("猜大了！");
        } else {
            System.out.println("猜小了！");
        }
        return false;
    }

    // 开始猜测
    public void start(int guessTimes){
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
                        if (guessNum(guessNum, randomNum)) { // 猜对了
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
