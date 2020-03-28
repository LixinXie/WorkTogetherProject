package main;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static List<String> calculate(List<String> questionList){//计算题目表达式，题目中没有=和题号
        List<String> answerList = new ArrayList<>();
        for(int i=0;i<questionList.size();i++){
            String str = questionList.get(i);
            
        }
        return answerList;
    }
    //加法
    public static int add(int l, int r){
        return l+r;
    }
    //减法
    public static int sub(int l, int r){
        return l-r;
    }
    //乘法
    public static int mul(int l, int r){
        return l*r;
    }
    //除法
    public static String div(int l, int r){
        String result = null;
        if(l==r){//等于1的情况
            result = "1";
        }else if(l<r){//真分数情况
            if(maxCommonDivisor(l,r)==1){//已不可化简
                result = l+"/"+r;
            }else{//可化简
                int mcd = maxCommonDivisor(l,r);
                int rl = l/mcd;
                int rr = r/mcd;
                result = rl + "/" + rr;
            }
        }else{//假分数处理,转化为带分数形式
            int rl = l;
            int rr = r;
            if(maxCommonDivisor(l,r)!=1){//有公约数，先化简
                int mcd = maxCommonDivisor(l,r);
                rl = l/mcd;
                rr = r/mcd;
            }
            int c = rl/rr;//除数
            int y = rl%rr;//余数
            result = c + "'"+ y +"/" +rr;
        }
        return result;
    }
    //辗转相除法求两数最大公约数
    public static int maxCommonDivisor(int a, int b){
        if(b == 0){
            return a;
        }
        int r = a%b;
        return maxCommonDivisor(b,r);
    }
}
