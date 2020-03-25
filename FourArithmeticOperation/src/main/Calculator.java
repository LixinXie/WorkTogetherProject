package main;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static List<String> calculate(List<String> questionList){
        List<String> answerList = new ArrayList<>();
        for (int i=0;i<questionList.size();i++) {
            String questr = questionList.get(i);
            questr = questr.replaceAll("\\s*","");
            //questr = questr.replace("[\\d*\\.]","");
            questr = questr.replace("=","");
            answerList.add(questr);
            /*if(!questr.contains("(")){ //不含括号的题目
                int charnum = 0;
                answerList.add(questr);
            }else{}*/
        }
        return answerList;
    }
}
