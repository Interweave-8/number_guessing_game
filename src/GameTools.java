
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

}
