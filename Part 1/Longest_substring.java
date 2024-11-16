import java.util.*;

public class Longest_substring {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String arr[]=str.split(" ");
        
        int max=arr[0].length();

        for(int i=1;i<arr.length;i++)
        {
            if(arr[i].length()>max)
            {
                max=arr[i].length();
            }
        }
        System.out.println(max);
        sc.close();
    }
}
