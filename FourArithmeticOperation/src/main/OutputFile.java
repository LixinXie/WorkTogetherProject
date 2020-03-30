package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputFile {
    //输出题目文件
    public static void printQuestion(List<String> queList){
        File file = new File("./Exercises.txt");
        questionlist2file(file,queList);
        System.out.println("生成题目成功！");
    }
    //输出答案文件
    public static void printAnswer(List<String> ansList){
        File file = new File("./Answers.txt");
        answerlist2file(file,ansList);
        System.out.println("生成答案成功！");
    }
    //输出答案的比较结果
    public static void printCompareResult(List<List> resultList){
        File file = new File("./Grade.txt");
        compareresultlist2file(file,resultList);
        System.out.println("答案验证完成！");
    }
    //输出题目文件
    public static void questionlist2file(File file, List<String> list){
        int i=1;//行号从1开始
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            for (String s : list) {
                writer.write(i+"、"+s+" ="+"\n");
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //输出答案文件
    public static void answerlist2file(File file, List<String> list){
        int i=1;//行号从1开始
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            for (String s : list) {
                writer.write(i+"、"+s+"\n");
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //输出比较结果文件
    public static void compareresultlist2file(File file, List<List> list){
        BufferedWriter writer = null;
        int sumcorrect=0;
        int sumwrong=0;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            List correct = list.get(0);
            List wrong = list.get(1);
            sumcorrect=correct.size();
            sumwrong=wrong.size();
            writer.write("Correct: "+sumcorrect);
            writer.write(" (");
            for(int i=0;i<correct.size();i++){
                writer.write((String) correct.get(i));
                if(i<correct.size()-1){
                    writer.write(", ");
                }
            }
            writer.write(")");
            writer.write("\n");
            writer.write("Wrong: "+sumwrong);
            writer.write(" (");
            for(int j=0;j<wrong.size();j++){
                writer.write((String) wrong.get(j));
                if(j<wrong.size()-1){
                    writer.write(", ");
                }
            }
            writer.write(")");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
