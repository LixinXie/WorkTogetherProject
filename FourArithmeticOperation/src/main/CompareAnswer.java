package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CompareAnswer {
    //验证答案正误,list里面装两个list
    public static List<List> compareAnswer(String questionFilepath, String yourAnswerFilepath){
        List<List> compareResult = new ArrayList<>();
        List correctlist = new ArrayList();
        List wronglist = new ArrayList();

        compareResult.add(correctlist);
        compareResult.add(wronglist);
        return compareResult;
    }
    public static List<String> file2list(String filepath) throws Exception {
        FileReader fileReader = new FileReader(filepath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> list = new ArrayList<>();
        String str = null;
        while ((str=bufferedReader.readLine())!=null){
            int begin = str.indexOf("[.]")+1;
            int end = str.indexOf("=");
            str = str.substring(begin,end);
            str.replace("[.]","");
            list.add(str);
        }
        return  list;
    }
}
