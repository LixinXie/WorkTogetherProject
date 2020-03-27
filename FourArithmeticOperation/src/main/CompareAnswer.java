package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CompareAnswer {
    //验证答案正误,list里面装两个list
    public static List<List> compareAnswer(File questionFile, File yourAnswerFile){
        List<List> compareResult = new ArrayList<>();
        List correctlist = new ArrayList();
        List wronglist = new ArrayList();

        compareResult.add(correctlist);
        compareResult.add(wronglist);
        return compareResult;
    }
}
