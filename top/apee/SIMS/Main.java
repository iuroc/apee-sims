package top.apee.SIMS;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * 主界面
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.loadMain();
    }

    /**
     * 载入主界面
     */
    public void loadMain() {
        System.out.print("欢迎来到 ");
        System.out.print(ANSI_Color.getBoldString("APEE 学生信息管理系统 "));
        System.out.println(ANSI_Color.getString("v1.0.0", ANSI_Color.F_BLACK));
        System.out.println("┌─────────────┐");
        System.out.println("│ " + ANSI_Color.getString("1. 用户登录", ANSI_Color.F_YELLOW) + " │");
        System.out.println("│ " + ANSI_Color.getString("2. 用户注册", ANSI_Color.F_YELLOW) + " │");
        System.out.println("└─────────────┘");
        Scanner scanner = new Scanner(System.in);
        System.out.print(ANSI_Color.getBoldString("请输入需要执行的操作序号：", ANSI_Color.F_CYAN));
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                this.loadLogin();
                break;
            case 2:
                break;
        }
        scanner.close();
    }

    /**
     * 加载登录界面
     */
    public void loadLogin() {
        Console console = System.console();
        System.out.print(ANSI_Color.getBoldString("请输入用户名：", ANSI_Color.F_BIUE));
        String userName = console.readLine();
        System.out.print(ANSI_Color.getBoldString("请输入密码：", ANSI_Color.F_BIUE));
        String password = new String(console.readPassword());
        System.out.println(userName);
        System.out.println(password);
    }

    /**
     * 读取指定路径的文本文件内容
     * 
     * @param path 文本文件路径
     * @return 文件内容
     */
    public String getFileText(String path) {
        String text = "";
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            try {
                while ((line = reader.readLine()) != null) {
                    text += line + "\n";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return text.substring(0, text.length() - 2);
    }

    public String[][] getUserInfo() {
        String text = this.getFileText("userInfo.txt");
        String[] lines = text.split("\n");
        String[][] result = new String[lines.length][2];
        for (int i = 0; i < lines.length; i++) {
            result[i] = lines[i].split(" ");
        }
        return result;
    }
}
/**
 * 表格框线
 * 
 * ┌─────────┬───┬───┐
 * │ (index) │ a │ b │
 * ├─────────┼───┼───┤
 * │ 0 │ 1 │ 2 │
 * │ 1 │ 1 │ 2 │
 * │ 2 │ 1 │ 2 │
 * │ 3 │ 1 │ 2 │
 * │ 4 │ 1 │ 2 │
 * └─────────┴───┴───┘
 * 
 * 
 * 
 * 
 * ┌─┐
 * │ │
 * └─┘
 */