import java.util.Scanner;
import java.util.Stack;

public class Evaluate_Postfix_Expression {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int operand1=0,operand2=0;

        Stack<Integer> stack=new Stack<Integer>();

        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='+' || str.charAt(i)=='-' || str.charAt(i)=='*' || str.charAt(i)=='/')
            {
                operand2 = stack.peek();
                stack.pop();
                operand1 =stack.peek();
                stack.pop();

                stack.push(choose_operation(operand1, operand2, str.charAt(i)));
            }
            else
            {
                stack.push(str.charAt(i)-'0');
            }
        }

        System.out.println(stack.peek());
        stack.pop();
        sc.close();
    }
    public static int choose_operation(int op1,int op2 ,char operator)
    {
        switch(operator)
        {
            case '+' : return op1+op2;
            case '-' : return op1-op2;
            case '*' : return op1*op2;
            case '/' : return op1/op2;
            default : return 0;
        }
    }
}