import java.util.*;

public class Binary_number_using_queue {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Queue<String> binary=new LinkedList<>();
        
        binary.offer("1");

        String str1,str2;

        System.out.print("Enter a number:");
        int n=sc.nextInt();

        for(int i=1;i<=n;i++)
        {
            str1=binary.remove();
            str2=str1;
            binary.offer(str1+"0");
            binary.offer(str2+"1");
            System.out.println(str1);
        }
        sc.close();
        return;
    }
}