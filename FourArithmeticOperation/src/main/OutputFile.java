package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputFile {
    //输出题目文件
    public static void questionlist2file(File file, List<String> list){
        int i=1;//行号从1开始
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            for (String s : list) {
                writer.write(i+". "+s+" ="+"\n");
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
                writer.write(i+". "+s+"\n");
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
    public static void compareresultlist2file(File file, List<List> list){
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
           List correct = list.get(0);
           List wrong = list.get(1);

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
