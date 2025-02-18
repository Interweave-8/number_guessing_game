public enum Difficulty {

    EASY("Easy"), // 简单
    MEDIUM("Medium"), // 中等
    HARD("Hard"); // 困难

    // 通过枚举类型定义任务的难度
    private final String value;

    // 构造函数
    Difficulty(String value) {
        this.value = value;
    }

    // 获取枚举值
    public String getValue() {
        return value;
    }

}
