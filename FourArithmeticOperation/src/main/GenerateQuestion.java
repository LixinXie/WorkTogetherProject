package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateQuestion {

    //生成题目，可被其他类调用
    public static List<String> generateQuestion(int n, int r){
        List<String> questionList = new ArrayList<>();
        return questionList;
    }
    //生成一个随机符号
    public static char randomSymbol(){
        Character[] s = new Character[4];
        Random r= new Random();
        int i = r.nextInt(4);
        int b;
        s[0] = '+';
        s[1] = '-';
        s[2] = '*';
        s[3] = '/';

        return s[i];
    }

    //生成一个随机正整数
    public  static int randomInt(int r){
        Random ra = new Random();
        int i;
        i = ra.nextInt(r);
        return i;
    }

    //生成一个含一个符号的题目
    public static String oneSymbol(int r){
        String[] s = new String[2];
        int a,b;
        char c;
        c = randomSymbol();
        a = randomInt(r);
        b = randomInt(r);
        s[1] = a + "" + c + b;
        return s[1];
    }

    //生成一个含两个符号的题目
    public static String twoSymbol(int r){
        String[] s = new String[2];
        int a,b,c;
        char c1,c2;
        a = randomInt(r);
        b = randomInt(r);
        c = randomInt(r);
        c1 = randomSymbol();
        c2 = randomSymbol();
        s[1] =""+ a + c1 + b + c2 + c;
        return s[1];
    }

    //生成一个含三个符号的题目
    public static String threeSymbol(int r){
        String[] s = new String[2];
        int a,b,c,d;
        char c1,c2,c3;
        a = randomInt(r);
        b = randomInt(r);
        c = randomInt(r);
        d = randomInt(r);
        c1 = randomSymbol();
        c2 = randomSymbol();
        c3 = randomSymbol();
        s[1] = "" + a + c1 + b + c2 + c + c3 + d;
        return s[1];
    }
}
