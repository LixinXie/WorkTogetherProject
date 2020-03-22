package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MyMathApp {

    public static void main(String[] args) {

    }
    //输出问题文件
    public List<String> printQuestion(){
        List<String> questionList = new ArrayList<>();
        return questionList;
    }
    //输出答案文件
    public List<String> printAnswer(){
        List<String> answerfile = new ArrayList<>();
        return answerfile;
    }
    //比较正确答案与你的答案
    public List<String> compareAnswer(File questionfile, File answerfile, File youranswerfile){
        List<String> compareResult = new ArrayList<>();
        return compareResult;
    }
}
