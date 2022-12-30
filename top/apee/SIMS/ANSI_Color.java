package top.apee.SIMS;

import java.util.Arrays;

/**
 * 带颜色的字符串工具类
 */
public class ANSI_Color {
    /**
     * 前景黑色
     */
    public static final int F_BLACK = 30;
    /**
     * 前景红色
     */
    public static final int F_RED = 31;
    /**
     * 前景绿色
     */
    public static final int F_GREEN = 32;
    /**
     * 前景黄色
     */
    public static final int F_YELLOW = 33;
    /**
     * 前景蓝色
     */
    public static final int F_BIUE = 34;
    /**
     * 前景品红色
     */
    public static final int F_MAGENTA = 35;
    /**
     * 前景青色
     */
    public static final int F_CYAN = 36;
    /**
     * 前景白色
     */
    public static final int F_WHITE = 37;
    /**
     * 前景默认
     */
    public static final int F_DEFAULT = 39;
    /**
     * 背景黑色
     */
    public static final int B_BLACK = 30;
    /**
     * 背景红色
     */
    public static final int B_RED = 41;
    /**
     * 背景绿色
     */
    public static final int B_GREEN = 42;
    /**
     * 背景黄色
     */
    public static final int B_YELLOW = 43;
    /**
     * 背景蓝色
     */
    public static final int B_BIUE = 44;
    /**
     * 背景品红色
     */
    public static final int B_MAGENTA = 45;
    /**
     * 背景青色
     */
    public static final int B_CYAN = 46;
    /**
     * 背景白色
     */
    public static final int B_WHITE = 47;
    /**
     * 背景默认
     */
    public static final int B_DEFAULT = 48;
    /**
     * 重置所有属性
     */
    public static final int RESET = 0;
    /**
     * 加粗样式
     */
    public static final int BOLD = 1;
    /**
     * 变细样式
     */
    public static final int LIGHT = 2;
    /**
     * 倾斜样式
     */
    public static final int ITALIC = 1;
    /**
     * 下划线样式
     */
    public static final int UNDERLINE = 1;
    /**
     * 闪烁样式
     */
    public static final int BLINK = 1;
    /**
     * 负片样式
     */
    public static final int NEGA = 1;
    /**
     * 透明样式
     */
    public static final int TRANSPARENT = 1;

    /**
     * 获取带颜色的字符串
     * 
     * 
     * @param text 待转换的文本
     * @param args 字体属性值
     * @return 带颜色的字符串
     */
    public static final String getString(String text, int... args) {
        String start = "\033[";
        String options = "";
        for (int i = 0; i < args.length; i++) {
            options += args[i];
            if (i < args.length - 1) {
                options += ";";
            } else {
                options += "m";
            }
        }
        String end = "\033[0m";
        return start + options + text + end;
    }

    /**
     * 获取加粗的带颜色文本
     * 
     * @param text 待转换的文本
     * @param args 字体属性值
     * @return 带颜色的字符串
     */
    public static final String getBoldString(String text, int... args) {
        int[] newArgs = Arrays.copyOf(args, args.length + 1);
        newArgs[args.length] = BOLD;
        return getString(text, newArgs);
    }
}
