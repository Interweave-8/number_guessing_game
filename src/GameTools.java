
// 生成随机数
public class GameTools {
    private int randomNum;

    public int getRandomNum() {
        System.out.println("正在生成1-100之间的随机数...");
        randomNum = (int)(Math.random() * 100 + 1);
        System.out.println("随机数生成完毕");
        return randomNum;
    }



}
