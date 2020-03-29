package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CompareAnswer {
    //验证答案正误,list里面装两个list
    public static List<List> compareAnswer(String questionFilepath, String yourAnswerFilepath) throws Exception {
        List<List> compareResult = new ArrayList<>();
        List<String> correctlist = new ArrayList();
        List<String> wronglist = new ArrayList();
        List<String> questionlist = questionfile2list(questionFilepath);
        List<String> answerlist = Calculator.calculate(questionlist);
        List<String> youranswerlist = answerfile2list(yourAnswerFilepath);
        for(int i=0;i<questionlist.size() && i<answerlist.size();i++){
            if(answerlist.get(i).equals(youranswerlist.get(i))){
                String str =i+1+"";//索引+1变题号
                correctlist.add(str);
            }else{
                String str =i+1+"";
                wronglist.add(str);
            }
        }
        compareResult.add(correctlist);
        compareResult.add(wronglist);
        return compareResult;
    }
    public static List<String> questionfile2list(String filepath) throws Exception {
        List<String> list = new ArrayList<>();
        FileReader fileReader = new FileReader(filepath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str = null;
        while ((str=bufferedReader.readLine())!=null){
            int begin = str.indexOf("、")+1;
            int end = str.indexOf(" =");
            str = str.substring(begin,end);
            str.replaceAll("\\s*","");
            list.add(str);
        }
        return list;
    }
    public static List<String> answerfile2list(String filepath) throws Exception {
        List<String> list = new ArrayList<>();
        FileReader fileReader = new FileReader(filepath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str = null;
        while ((str=bufferedReader.readLine())!=null){
            int begin = str.indexOf("、")+1;
            str = str.substring(begin);
            str.replaceAll("\\s*","");
            list.add(str);
        }
        return list;
    }
}
