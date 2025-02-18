
// 生成随机数
public class RandomNums {
    private int randomNum;

    RandomNums() {
        System.out.println("正在1-100之间的随机数");
        randomNum = (int)(Math.random() * 100 + 1);
    }

    public int getNum() {
        return randomNum;
    }
}
