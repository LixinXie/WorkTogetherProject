package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateQuestion {

    //生成题目，可被其他类调用
    public static List<String> generateQuestion(int n, int r){
        List<String> questionList = new ArrayList<>();
        Random random = new Random();
        for(int i=0;i<n;i++){
            int j = random.nextInt(3);
            switch (j){
                case 0: questionList.add(oneSymbol(r));
                    break;
                case 1: questionList.add(twoSymbol(r));
                    break;
                case 2: questionList.add(threeSymbol(r));
                    break;
            }
        }
        return questionList;
    }
    //生成一个随机符号
    public static char randomSymbol(){
        Character[] s = new Character[4];
        Random r= new Random();
        int i = r.nextInt(4);
        int b;
        s[0] = '+';
        s[1] = '-';
        s[2] = '*';
        s[3] = '/';

        return s[i];
    }

    //生成一个随机正整数
    public static int randomInt(int r){
        Random ra = new Random();
        int i;
        while(true) {
            i = ra.nextInt(r);
            if(i!=0)break;
        }
        return i;
    }

    //生成一个含一个符号的题目
    public static String oneSymbol(int r){
        String[] s = new String[2];
        int a,b;
        char c;
        c = randomSymbol();
        a = randomInt(r);
        b = randomInt(r);
        while(c=='-'){//保证计算过程非负
            if(a-b>=0){
                break;
            }else
                c = randomSymbol();
        }
        s[1] = a + "" + c + b;
        return s[1];
    }

    //生成一个含两个符号的题目
    public static String twoSymbol(int r){
        String[] s = new String[2];
        int a,b,c;
        char c1,c2;
        a = randomInt(r);
        b = randomInt(r);
        c = randomInt(r);
        c1 = randomSymbol();
        c2 = randomSymbol();
        while(c1=='-'||c2=='-'){//保证计算过程非负；当符号为-时判断过程是否产生负数，产生负数则重新生成符号
            if(c1=='-'&&c2=='-'){// - -
                if(a-b-c>=0)
                    break;
            }else if(c1=='-'){// - 其他
                if(c2=='*' && a-(b*c)>=0){// - *
                    break;
                }if(c2=='/'&& a*c-b>=0){// - /
                    break;
                }
                if(c2=='+'&& a-b>=0)// - +
                    break;
            }else {// 其他 -
                if(c1=='+' && b-c>=0){// + -
                    break;
                }if(c1=='*' && (a*b)-c>=0){// * -
                    break;
                }if(c1== '/' && a-b*c>=0){// / -
                    break;
                }
            }
            c1 = randomSymbol();
            c2 = randomSymbol();
        }
        s[1] =""+ a + c1 + b + c2 + c;
        return s[1];
    }

    //生成一个含三个符号的题目
    public static String threeSymbol(int r){
        int a=0,b=0,c=0,d=0;
        String s;
        String s1,s2;
        char c1 = randomSymbol();
        char c2 = randomSymbol();
        char c3 = randomSymbol();
        a = randomInt(r);
        b = randomInt(r);
        c = randomInt(r);
        d = randomInt(r);
            if (c1 == '-' || c2 == '-' || c3 == '-') {
            while (true) {
                if (c1 == '-' && c2 == '-' && c3 == '-') {
                    if (a - b - c - d >= 0) break;
                }
                else if (c1=='-'&&c2=='-'){
                    if(c3=='+' && a-b-c>=0) break;
                   else if(c3=='*' && a-b-(c*d)>=0)break;
                   else if(c3=='/' && a*d-b*d-c>=0)break;
                }
                else if(c1=='-'&&c3=='-') {
                    if (c2 == '+' && a-b>=0 &&c-d>=0)break;
                   else if (c2 == '*' && a-(b*c)-d>=0)break;
                   else if (c2 == '/' && a*c-b-c*d>=0)break;
                }
                else if(c2=='-'&&c3=='-') {
                    if (c1 == '+' && b-c-d>=0)break;
                   else if (c1 == '*' && (a*b)-c-d>=0)break;
                   else if (c1 == '/' && a-b*c-b*d>=0)break;
                }
                else if(c1=='-'){
                    if(c2=='+') {
                        if(c3=='+' && a-b>=0)break;
                       else if(c3=='*' && a-b>=0)break;
                       else if(c3=='/' && a-b>=0)break;
                    }
                    else if(c2=='*'){
                        if(c3=='+' && a-(b*c)>=0)break;
                       else if(c3=='*' && a-(b*c*d)>=0)break;
                       else if(c3=='/' && a*d-b*c>=0)break;
                    }
                    else if(c2=='/'){
                        if(c3=='+' && a*c-b>=0)break;
                       else if(c3=='*' && a*c-b*d>=0)break;
                       else if(c3=='/' && a*c*d-b>=0)break;
                    }
                }
                else if(c2=='-')
                {
                    if(c1=='+') {
                        if(c3=='+' && b-c>=0)break;
                       else if(c3=='*' && (b-(c*d))>=0)break;
                       else if(c3=='/' && b*d-c>=0)break;
                    }
                    else if(c1=='*'){
                        if(c3=='+' && (a*b)-c>=0)break;
                       else if(c3=='*' && (a*b)-(c*d)>=0)break;
                       else if(c3=='/' && a*b*d-c>=0)break;
                    }
                    else if(c1=='/'){
                        if(c3=='+' && a-b*c>=0)break;
                       else if(c3=='*' && a-b*c*d>=0)break;
                       else if((c3=='/') &&a*d-b*c>=0)break;
                    }
                }
                else if(c3=='-')
                {
                    if(c1=='+') {
                        if(c2=='+' && c-d>=0)break;
                        else if(c2=='*' && ((b*c)-d)>=0)break;
                        else if(c2=='/' && b-c*d>=0)break;
                    }
                    else if(c1=='*'){
                        if(c2=='+' && c-d>=0)break;
                        else if(c2=='*' && (a*b*c-d)>=0)break;
                        else if(c2=='/' && a*b-c*d>=0)break;
                    }
                    else if(c1=='/'){
                        if(c2=='+' && c-d>=0)break;
                        else if(c2=='*' && a*c-b*d>=0)break;
                        else if(c2=='/' && a-b*c*d>=0)break;
                    }
                else continue;
                }
                c1 = randomSymbol();
                c2 = randomSymbol();
                c3 = randomSymbol();
             }
         }

        s =""+ a + c1 + b + c2 + c + c3 + d ;
        return s;
    }
}
