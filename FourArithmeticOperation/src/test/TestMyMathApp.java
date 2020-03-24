package test;

import main.GenerateQuestion;
import main.MyMathApp;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMyMathApp {

    @Test
    public void testPrintQuestion(){
        List<String> list = new ArrayList<>();
        list.add("1. 1+2=");
        list.add("2. 2+3=");
        list.add("3. 4+5=");
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
        char c = GenerateQuestion.randomSymbol();
        System.out.println(c);

    }
}
