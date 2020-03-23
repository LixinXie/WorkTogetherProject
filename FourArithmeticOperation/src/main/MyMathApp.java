package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyMathApp {

    public static void main(String[] args) {
        int n;//题目个数
        int r;//数值取值范围
        System.out.println("欢迎使用小学四则运算生成题目");
        System.out.println("-q 生成题目和答案");
        System.out.println("-c 验证你的答案");
        System.out.println("请选择你的操作：");
        Scanner scanner = new Scanner(System.in);
        String order = scanner.next();
        switch(order){
            case "-q":
                System.out.println("请输入生成题目个数-n");
                n=scanner.nextInt();
                System.out.println("请输入数值取值范围-r：");
                r=scanner.nextInt();
                List<String> questionList = new ArrayList<>();
                List<String> answerList = new ArrayList<>();
                questionList = GenerateQuestion.generateQuestion(n,r);
                answerList = Calculator.calculate(questionList);
                printQuestion(questionList);
                printAnswer(answerList);
                break;
            case "-c":

            default:
                System.out.println("你的输入有误！");
                break;
        }

    }
    //输出问题文件
    public static void printQuestion(List<String> queList){

    }
    //输出答案文件
    public static void printAnswer(List<String> ansList){

    }
    //比较正确答案与你的答案
    public static void compareAnswer(File questionfile, File answerfile, File youranswerfile){
        List<String> compareResult = new ArrayList<>();
    }
}
