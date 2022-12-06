package LAB03;

import java.util.Scanner;


public class Postfix {

    public static int priority(char u)
    {
        if(u=='+'||u=='-')
        {
            return 1;
        }
        if(u=='*'||u=='/')
        {
            return 2;
        }
        if(u=='^')
        {
            return 3;
        }
        return 0;
    }
    public static String infixToPostfix(String infix)
    {

        String result= "";
        Stack buffer=new Stack();

        for (int i=0; i<infix.length();i++)
        {
            char a=infix.charAt(i); //считываем каждый элемент строки с индексom i и сохраняем его в а
            if(i==0)
            {

                if(a=='*'||a=='/'||a=='^')
                {
                        throw new RuntimeException("Syntax error");
                }
            }
            if(i==infix.length()-1)
            {

                if(a=='+'||a=='-'||a=='*'||a=='/'||a=='^')
                {
                        throw new RuntimeException("Syntax error");
                }
            }
            if(a>=48&&a<=57||a>=65&&a<=90||a>=97&&a<=122)
            {
                result=result+a;
            }
            if (a == '(')
            {
                buffer.push(a);
            }
            if (a == ')')
            {
                while(buffer.peek() != '(')
                {
                    result=result+buffer.pop();

                }
                buffer.pop();
            }
            if (a=='^')
            {
                buffer.push(a);
            }
            if(a == '-' || a == '+' || a == '*' || a == '/')
            {
                while (!buffer.isEmpty() && buffer.peek()!='(' && priority(a)<=priority(buffer.peek()))
                {
                    result=result+buffer.pop();
                }
                buffer.push(a);
            }
        }
        while (!buffer.isEmpty())
        {
            result=result+buffer.pop();
        }
        return result;
    }

    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        System.out.print("Input an expression: ");
        String expression = in.nextLine();
        System.out.println("The Answer is: "+infixToPostfix(expression));//234+*87-/
        in.close();
    }



}

