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
        List<String> questionlist = file2list(questionFilepath);
        List<String> answerlist = Calculator.calculate(questionlist);
        List<String> youranswerlist = file2list(yourAnswerFilepath);
        for(int i=0;i<questionlist.size();i++){
            if(answerlist.get(i).equals(youranswerlist.get(i))){
                correctlist.add(i+"");
            }else{
                wronglist.add(i+"");
            }
        }
        compareResult.add(correctlist);
        compareResult.add(wronglist);
        return compareResult;
    }
    public static List<String> file2list(String filepath) throws Exception {
        List<String> list = new ArrayList<>();
        FileReader fileReader = new FileReader(filepath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str = null;
        while ((str=bufferedReader.readLine())!=null){
            int begin = str.indexOf("、")+1;
            int end = str.indexOf("=");
            str.trim();
            str.replaceAll("\\s*","");
            str = str.substring(begin,end);
            list.add(str);
        }
        return list;
    }
}
