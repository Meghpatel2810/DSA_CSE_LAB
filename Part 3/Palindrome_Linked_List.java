import java.util.*;

class node<T>{
    T data;
    node<T> link;
    node(){}
    node(T data)
    {
        this.data=data;
        link=null;
    }
}

class linkedlist<T>{
    node<T> head,temp;
    linkedlist(){ head=null; }

    public void insert(T data)
    {
        if(head==null)
        {
            head=new node<>(data);
        }
        else
        {
            temp=this.head;
            while(temp.link!=null)
            {
                temp=temp.link;
            }
            temp.link=new node<>(data);
        }
        return ;
    }
}

public class Palindrome_Linked_List {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        linkedlist<Integer> list=new linkedlist<>();

        int size=6;
        System.out.println("Enter list");
        for(int i=0;i<size;i++)
        {
            list.insert(sc.nextInt());
        }

        System.out.println(isPalindrome(list)==true ? "The list is palindrome" : "The list is not palindrome" );
        sc.close();
    }

    public static <T>boolean isPalindrome(linkedlist<T> list)
    {
        node<T> slow=list.head , fast=list.head , temp=list.head;
        int count=0;
        while(fast.link!=null && fast.link.link!=null)
        {
            fast=fast.link.link;
            slow=slow.link;
            count++;
        }
        if(count==0)
        {
            if(list.head.link==null)
            return true;
            else
            {
                return list.head.data==list.head.link.data;
            }
        }
        node<T> new_head=slow.link;

        new_head=reverse(new_head);

        while(new_head!=null)
        {
            System.out.println(new_head.data+" "+temp.data);
            if(!new_head.data.equals(temp.data))
            return false;

            temp=temp.link;
            new_head=new_head.link;
        }
        return true;
    }

    public static <T>node<T> reverse(node<T> head)
    {
        if(head==null)
        return null;

        node<T> prev=null;
        node<T> curr=head;
        node<T> next;

        while (curr != null) {  
            next = curr.link;
            curr.link = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}