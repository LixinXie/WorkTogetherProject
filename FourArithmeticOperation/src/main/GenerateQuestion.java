package main;

import java.util.ArrayList;
import java.util.List;

public class GenerateQuestion {

    //生成题目，可被其他类调用
    public static List<String> generateQuestion(int n, int r){
        List<String> questionList = new ArrayList<>();
        return questionList;
    }
    //生成一个随机符号
    public char randomSymbol(){
        return '.';
    }
    //生成一个随机正整数
    public int randomInt(){
        return 0;
    }
    //生成一个含一个符号的题目
    public String oneSymbol(){
        return null;
    }
    //生成一个含两个符号的题目
    public String twoSymbol(){
        return null;
    }
    //生成一个含三个符号的题目
    public String threeSymbol(){
        return null;
    }
}
