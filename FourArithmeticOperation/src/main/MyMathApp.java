package main;

import java.util.List;
import java.util.Scanner;

public class MyMathApp {

    public static void main(String[] args) throws Exception {
        int n;//题目个数
        int r;//数值取值范围
        System.out.println("欢迎使用四则运算");
        System.out.println("输入 -q 生成题目和答案");
        System.out.println("输入 -c 验证你的答案");
        System.out.println("-------------------");
        System.out.println("请选择你的操作：");
        Scanner scanner = new Scanner(System.in);
        String order = scanner.next();
        switch(order){
            case "-q":
                System.out.println("题目个数-n (请输入一个正整数)：");
                n=scanner.nextInt();
                System.out.println("数值取值范围-r (请输入一个正整数)：");
                r=scanner.nextInt();
                if(n<0||r<0){
                    System.out.println("请的输入有误！");
                    break;
                }
                long startTime = System.currentTimeMillis(); // 获取开始时间
                List<String> questionList = GenerateQuestion.generateQuestion(n,r);
                long endTime = System.currentTimeMillis(); // 获取结束时间


                long startTime2 = System.currentTimeMillis(); // 获取开始时间
                List<String> answerList = Calculator.calculate(questionList);
                long endTime2 = System.currentTimeMillis(); // 获取结束时间


                long startTime3 = System.currentTimeMillis(); // 获取开始时间
                OutputFile.printQuestion(questionList);
                long endTime3 = System.currentTimeMillis(); // 获取结束时间


                long startTime4 = System.currentTimeMillis(); // 获取开始时间
                OutputFile.printAnswer(answerList);
                long endTime4 = System.currentTimeMillis(); // 获取结束时间

                System.out.println("generateQuestion方法运行时间： " + (endTime - startTime) + "ms");
                System.out.println("calculate方法运行时间： " + (endTime2 - startTime2) + "ms");
                System.out.println("printQuestion方法运行时间： " + (endTime3 - startTime3) + "ms");
                System.out.println("printAnswer方法运行时间： " + (endTime4 - startTime4) + "ms");
                break;
            case "-c":
                System.out.println("请输入题目文件：");
                Scanner scanner1 = new Scanner(System.in);
                String questionfilepath = scanner1.nextLine();

                System.out.println("请输入答案文件：");
                Scanner scanner2 = new Scanner(System.in);
                String answerfilepath = scanner2.nextLine();

                List<List> result = CompareAnswer.compareAnswer(questionfilepath,answerfilepath);
                OutputFile.printCompareResult(result);
                break;
            default:
                System.out.println("你的输入有误！");
                break;
        }
    }
}
