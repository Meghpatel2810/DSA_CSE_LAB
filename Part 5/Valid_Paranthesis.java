import java.util.Scanner;
import java.util.Stack;
public class Valid_Paranthesis {

    public static boolean brackets(String str)
    {
        Stack<Character> stack=new Stack<Character>();

        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='{' || str.charAt(i)=='(' || str.charAt(i)=='[')
            {
                stack.push(str.charAt(i));
            }
            else if(str.charAt(i)=='}')
            {
                try{
                    if(stack.peek()=='{')
                    {
                        stack.pop();
                    }
                    else
                    {
                        return false;
                    }   
                }catch(Exception e)
                {
                    return false;
                }
            }
            else if(str.charAt(i)==']')
            {
                try{
                    if(stack.peek()=='[')
                    {
                        stack.pop();
                    }
                    else
                    {
                        return false;
                    }   
                }catch(Exception e)
                {
                    return false;
                }
            }
            else if(str.charAt(i)==')')
            {
                try{
                    if(stack.peek()=='(')
                    {
                        stack.pop();
                    }
                    else
                    {
                        return false;
                    }   
                }catch(Exception e)
                {
                    return false;
                }
            }
            else
            continue;
        }

        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(brackets(sc.next()));
        sc.close();
    }
}