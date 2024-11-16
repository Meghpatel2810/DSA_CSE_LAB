import java.util.*;

public class Infix_to_Postfix {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println(get_Postfix(sc.next()));
        sc.close();
    }

    public static String get_Postfix(String infix)
    {
        Stack<Character> st=new Stack<>();
        String postfix="";
        
        for(int i=0;i<infix.length();i++)
        {
            if(infix.charAt(i)=='(')
            {
                st.push(infix.charAt(i));
            }
            else if(infix.charAt(i)==')')
            {
                while(st.peek()!='(' && !st.isEmpty())
                {
                    postfix+=st.pop();
                }
                st.pop();
            }
            else if(infix.charAt(i)=='+' || infix.charAt(i)=='-' || infix.charAt(i)=='*' || infix.charAt(i)=='/' || infix.charAt(i)=='^')
            {
                if(st.isEmpty() || Precendence(infix.charAt(i))>=Precendence(st.peek()))
                {
                    st.push(infix.charAt(i));
                }
                else
                {
                    while(!st.isEmpty() && Precendence(infix.charAt(i))<=Precendence(st.peek()))
                    {
                        System.out.println(postfix);
                        postfix+=st.pop();
                    }
                    st.push(infix.charAt(i));
                }
            }
            else
            {
                postfix+=infix.charAt(i);
            }
        }
        while(!st.isEmpty())
        {
            postfix+=st.pop();
        }

        return postfix;
    }

    public static int Precendence(char operator)
    {
        switch(operator)
        {
            case '^': return 4;
            case '*': return 3;
            case '/': return 3;
            case '+': return 2;
            case '-': return 1;
            default : return 0;
        }
    }
}