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
        List<String> list = new ArrayList<>();
        list = GenerateQuestion.generateQuestion(100,4);
        MyMathApp.printQuestion(list);
    }
    @Test
    public void testPrintAnsweer(){

    }
    @Test
    public void testCompareAnswer(){

    }
    @Test
    public void test(){
        String[] s = new String[2];
        s[1] = GenerateQuestion.threeSymbol(50);
        System.out.println(s[1]);

    }
    @Test
    public void testCalculator(){
        List<String> list = new ArrayList<>();
        list.add("1. 1+2=");
        list.add("2. 2*3=");
        list.add("3. 2-3=");
        List<String> answer = Calculator.calculate(list);
        for (String s : answer) {
            System.out.println(s);
        }
    }

}
