package main;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static List<String> calculate(List<String> questionList){//计算题目表达式，题目中没有=和题号
        List<String> answerList = new ArrayList<>();
        for(int i=0;i<questionList.size();i++){
            String str = questionList.get(i);//从list中获取题目
            char[] strarray = str.toCharArray();//将当前题目字符串转化为字符数组
            int[] sysmbolindex = new int[3];//记录当前题目表达式中按顺序出现的计算符号的索引
            char[] sysmbol = new char[3];//记录当前题目表达式中按顺序出现的各个计算符号
            int x=0;//x标记当前sysmbolindex数组存放到第几个(索引)
            int y=0;//y标记当前sysmbol数组存放到第几个(索引)
            int sumsysmbol=0;//记录当前题目运算符个数
            for(int j=0;j<strarray.length;j++){//遍历字符数组记录运算符和运算符索引
                if(strarray[j]=='+'||strarray[j]=='-'||strarray[j]=='*'||strarray[j]=='/'){
                    sysmbolindex[x]=j;//记录当前运算符的索引
                    sysmbol[y]=strarray[j];//记录当前运算符
                    if(x<sysmbolindex.length-1)
                        x++;//将x向后移动一位
                    if(y<sysmbol.length-1)
                        y++;//将y向后移动一位
                    sumsysmbol++;//运算符个数加一
                }
            }
            if(sumsysmbol==1){//一运算符题目
                String result = null;
                int num1 = Integer.parseInt(str.substring(0,sysmbolindex[0]));//运算符左边的数
                int num2 = Integer.parseInt(str.substring(sysmbolindex[0]+1));//运算符右边的数
                result = twoNumCalculate(num1,num2,sysmbol[0]);
                answerList.add(result);
            }else if(sumsysmbol==2){//二运算符题目
                String result = null;
                int num1 = Integer.parseInt(str.substring(0,sysmbolindex[0]));
                int num2 = Integer.parseInt(str.substring(sysmbolindex[0]+1,sysmbolindex[1]));
                int num3 = Integer.parseInt(str.substring(sysmbolindex[1]+1));
                result = threeNumCalculate(num1,num2,num3,sysmbol[0],sysmbol[1]);
                answerList.add(result);
            }else if(sumsysmbol==3){//三运算符题目
                String result = null;
                int num1 = Integer.parseInt(str.substring(0,sysmbolindex[0]));
                int num2 = Integer.parseInt(str.substring(sysmbolindex[0]+1,sysmbolindex[1]));
                int num3 = Integer.parseInt(str.substring(sysmbolindex[1]+1,sysmbolindex[2]));
                int num4 = Integer.parseInt(str.substring(sysmbolindex[2]+1));
                result = fourNumCalculate(num1,num2,num3,num4,sysmbol[0],sysmbol[1],sysmbol[2]);
                answerList.add(result);
            }
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
        if(l==0){//被除数等于0
            result = "" + 0;
        }else if(r==0){//除数等于0
            result = "NaN";
        }else if(l==r){//等于1的情况
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
        }else{//被除数大于除数
            int rl = l;
            int rr = r;
            if(rl%rr==0)//可整除
                result = "" + rl/rr;
            else{//不可整除,假分数处理,转化为带分数形式
                if(maxCommonDivisor(l,r)!=1){//有公约数，先化简
                    int mcd = maxCommonDivisor(l,r);
                    rl = l/mcd;
                    rr = r/mcd;
                }
                int c = rl/rr;//除数
                int y = rl%rr;//余数
                result = c + "'"+ y +"/" +rr;
            }
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
    //二元运算
    public static String twoNumCalculate(int num1, int num2 , char s){
        String result = "";
        if(s=='+'){
            result = "" + add(num1,num2);
        }else if(s=='-'){
            result = "" + sub(num1,num2);
        }else if(s=='*'){
            result = "" + mul(num1,num2);
        }else if(s=='/'){
            result = div(num1,num2);
        }
        return result;
    }
    //三元运算
    public static String threeNumCalculate(int num1, int num2, int num3, char c1, char c2){
        String result = "";
        if(c1=='+'){
            switch (c2){
                case '+':result = "" + add(add(num1,num2),num3);break;
                case '-':result = "" + sub(add(num1,num2),num3);break;
                case '*':result = "" + add(num1,mul(num2,num3));break;
                case '/':result = div(num1*num3+num2,num3);break;
            }
        }else if(c1=='-'){
            switch (c2){
                case '+':result = "" + add(sub(num1,num2),num3);break;
                case '-':result = "" + sub(sub(num1,num2),num3);break;
                case '*':result = "" + sub(num1,mul(num2,num3));break;
                case '/':result = div(num1*num3-num2,num3);break;
            }
        }else if(c1=='*'){
            switch (c2){
                case '+':result = "" + add(mul(num1,num2),num3);break;
                case '-':result = "" + sub(mul(num1,num2),num3);break;
                case '*':result = "" + mul(mul(num1,num2),num3);break;
                case '/':result = div(num1*num2,num3);break;
            }
        }else if(c1=='/'){
            switch (c2){
                case '+':result = div(num1+num2*num3,num2);break;
                case '-':result = div(num1-num2*num3,num2);break;
                case '*':result = div(num1*num3,num2);break;
                case '/':result = div(num1,num2*num3);break;
            }
        }
        return result;
    }
    //四元运算
    public static String fourNumCalculate(int num1, int num2, int num3, int num4, char c1, char c2, char c3){
        String result = "";
        if(c1=='+'){//第一是+
            if (c2=='+'){
                switch (c3){
                    case '+':result = "" + add(add(add(num1,num2),num3),num4);break;
                    case '-':result = "" + sub(add(add(num1,num2),num3),num4);break;
                    case '*':result = "" + add(add(num1,num2),mul(num3,num4));break;
                    case '/':result = div(add(num1,num2)*num4+num3,num4);break;
                }
            }else if(c2=='-'){
                switch (c3){
                    case '+':result = "" + add(sub(add(num1,num2),num3),num4);break;
                    case '-':result = "" + sub(sub(add(num1,num2),num3),num4);break;
                    case '*':result = "" + sub(add(num1,num2),mul(num3,num4));break;
                    case '/':result = div(add(num1,num2)*num4-num3,num4);break;
                }
            }else if(c2=='*'){
                switch (c3){
                    case '+':result = "" + add(add(num1,mul(num2,num3)),num4);break;
                    case '-':result = "" + sub(add(num1,mul(num2,num3)),num4);break;
                    case '*':result = "" + add(num1,mul(mul(num2,num3),num4));break;
                    case '/':result = div(num1*num4+mul(num2,num3),num4);break;
                }
            }else if(c2=='/'){
                switch(c3){
                    case '+':result = div(add(num1,num4)*num3+num2,num3);break;
                    case '-':result = div(sub(num1,num4)*num3+num2,num3);break;
                    case '*':result = div(num1*num3+mul(num2,num4),num3);break;
                    case '/':result = div(num1*num3*num4+num2,num3*num4);break;
                }
            }
        }else if(c1=='-'){//第一是-
            if (c2=='+'){
                switch (c3){
                    case '+':result = "" + (num1-num2+num3+num4);break;
                    case '-':result = "" + (num1-num2+num3-num4);break;
                    case '*':result = "" + (num1-num2+num3*num4);break;
                    case '/':result = div((num1-num2)*num4+num3,num4);break;
                }
            }else if(c2=='-'){
                switch (c3){
                    case '+':result = "" + (num1-num2-num3+num4);break;
                    case '-':result = "" + (num1-num2-num3-num4);break;
                    case '*':result = "" + (num1-num2-num3*num4);break;
                    case '/':result = div((num1-num2)*num4-num3,num4);break;
                }
            }else if(c2=='*'){
                switch (c3){
                    case '+':result = "" + (num1-num2*num3+num4);break;
                    case '-':result = "" + (num1-num2*num3-num4);break;
                    case '*':result = "" + (num1-num2*num3*num4);break;
                    case '/':result = div(num1*num4-num2*num3,num4);break;
                }
            }else if(c2=='/'){
                switch(c3){
                    case '+':result = div((num1+num4)*num3-num2,num3);break;
                    case '-':result = div((num1-num4)*num3-num2,num3);break;
                    case '*':result = div(num1*num3-num2*num4,num3);break;
                    case '/':result = div(num1*num3*num4-num2,num3*num4);break;
                }
            }
        }else if(c1=='*'){//第一是*
            if (c2=='+'){
                switch (c3){
                    case '+':result = "" + (num1*num2+num3+num4);break;
                    case '-':result = "" + (num1*num2+num3-num4);break;
                    case '*':result = "" + (num1*num2+num3*num4);break;
                    case '/':result = div(num1*num2*num4+num3,num4);break;
                }
            }else if(c2=='-'){
                switch (c3){
                    case '+':result = "" + (num1*num2-num3+num4);break;
                    case '-':result = "" + (num1*num2-num3-num4);break;
                    case '*':result = "" + (num1*num2-num3*num4);break;
                    case '/':result = div(num1*num2*num4-num3,num4);break;
                }
            }else if(c2=='*'){
                switch (c3){
                    case '+':result = "" + (num1*num2*num3+num4);break;
                    case '-':result = "" + (num1*num2*num3-num4);break;
                    case '*':result = "" + (num1*num2*num3*num4);break;
                    case '/':result = div(num1*num2*num3,num4);break;
                }
            }else if(c2=='/'){
                switch(c3){
                    case '+':result = div(num1*num2+num3*num4,num3);break;
                    case '-':result = div(num1*num2-num3*num4,num3);break;
                    case '*':result = div(num1*num2*num4,num3);break;
                    case '/':result = div(num1*num2,num3*num4);break;
                }
            }
        }else if(c1=='/'){//第一是/
            if (c2=='+'){
                switch (c3){
                    case '+':result = div(num1+num2*num3+num2*num4,num2);break;
                    case '-':result = div(num1+num2*num3-num2*num4,num2);break;
                    case '*':result = div(num1+num2*num3*num4,num2);break;
                    case '/':result = div(num1*num4+num2*num3,num2*num4);break;
                }
            }else if(c2=='-'){
                switch (c3){
                    case '+':result = div(num1-num2*num3+num2*num4,num2);break;
                    case '-':result = div(num1-num2*num3-num2*num4,num2);break;
                    case '*':result = div(num1-num2*num3*num4,num2);break;
                    case '/':result = div(num1*num4-num2*num3,num2*num4);break;
                }
            }else if(c2=='*'){
                switch (c3){
                    case '+':result = div(num1*num3+num2*num4,num2);break;
                    case '-':result = div(num1*num3-num2*num4,num2);break;
                    case '*':result = div(num1*num3*num4,num2);break;
                    case '/':result = div(num1*num3,num2*num4);break;
                }
            }else if(c2=='/'){
                switch(c3){
                    case '+':result = div(num1+num2*num3*num4,num2*num3);break;
                    case '-':result = div(num1-num2*num3*num4,num2*num3);break;
                    case '*':result = div(num1*num4,num2*num3);break;
                    case '/':result = div(num1,num2*num3*num4);break;
                }
            }
        }
        return result;
    }
}
