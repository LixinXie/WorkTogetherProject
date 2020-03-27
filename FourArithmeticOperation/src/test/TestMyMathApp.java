package test;

import main.Calculator;
import main.GenerateQuestion;
import main.MyMathApp;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMyMathApp {

    @Test
    public void testPrintQuestion(){
        List<String> list = GenerateQuestion.generateQuestion(30,4);
        MyMathApp.printQuestion(list);
    }
    @Test
    public void testPrintAnsweer(){
        List<String> list = GenerateQuestion.generateQuestion(30,4);
        MyMathApp.printAnswer(list);
    }
    @Test
    public void testCompareAnswer(){

    }
    @Test
    public void test1(){
        String[] s = new String[2];
        s[1] = GenerateQuestion.oneSymbol(50);
        System.out.println(s[1]);
    }
    @Test
    public void test2(){
        String[] s = new String[2];
        s[1] = GenerateQuestion.twoSymbol(50);
        System.out.println(s[1]);
    }
    @Test
    public void test3(){
        String[] s = new String[2];
        s[1] = GenerateQuestion.threeSymbol(50);
        System.out.println(s[1]);

    }
    @Test
    public void testCalculator(){
        List<String> list = new ArrayList<>();
        list.add("1+2");
        list.add("2*3");
        list.add("2-3");
        List<String> answer = Calculator.calculate(list);
        for (String s : answer) {
            System.out.println(s);
        }
    }
    @Test
    public void testadd(){
        int s = Calculator.add(1,100);
        System.out.println(s);
    }
    @Test
    public void testsub(){
        int s = Calculator.sub(12,3);
        System.out.println(s);
    }
    @Test
    public void testmul(){
        int s = Calculator.mul(3,7);
        System.out.println(s);
    }
    @Test
    public void testdiv(){
        String result = Calculator.div(50,15);
        System.out.println(result);
    }
    @Test
    public void testmaxCommonDivisor(){
        int s = Calculator.maxCommonDivisor(0,20);
        System.out.println(s);
    }

}
