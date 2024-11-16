import java.util.*;

class node<T>
{
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

    linkedlist() { head=null; }

    void insert(T data)
    {
        if(head==null)
        {
            head=new node<>(data);
            return;
        }
        
        temp=head;
        while(temp.link!=null)
        {
            temp=temp.link;
        }
        temp.link=new node<>(data);
        return ;
    }

    void Print_List()
    {
        temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+"->");
            temp=temp.link;
        }
        System.out.print("null");
        System.out.println();
        return ;
    }
}

public class Merge_Sorted_Linkedlist {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        linkedlist<String> list1=new linkedlist<>();
        linkedlist<String> list2=new linkedlist<>();
        int size1=3,size2=2;

        System.out.println("Enter list 1:");
        for(int i=0;i<size1;i++)
        {
            list1.insert(sc.nextLine());
        }
        System.out.println("Enter list 2:");
        for(int i=0;i<size2;i++)
        {
            list2.insert(sc.nextLine());
        }

        System.out.println();
        System.out.print("list 1: ");
        list1.Print_List();
        System.out.print("list 2: ");
        list2.Print_List();
        System.out.println();
        System.out.print("Sorted list: ");
        Sort(list1, list2).Print_List();
        sc.close();
    }

    public static <T extends Comparable<T>>linkedlist<T> Sort(linkedlist<T> list1,linkedlist<T> list2)
    {
        linkedlist<T> ans=new linkedlist<>();
        node<T> temp1=list1.head,temp2=list2.head;

        while(temp1!=null && temp2!=null)
        {
            if(temp1.data.compareTo(temp2.data)<0)
            {
                ans.insert(temp1.data);
                temp1=temp1.link;
            }
            else if(temp1.data.compareTo(temp2.data)>0)
            {
                ans.insert(temp2.data);
                temp2=temp2.link;
            }
            else
            {
                ans.insert(temp1.data);
                ans.insert(temp2.data);

                temp1=temp1.link;
                temp2=temp2.link;
            }
        }

        if(temp1!=null)
        {
            while(temp1!=null)
            {
                ans.insert(temp1.data);
                temp1=temp1.link;
            }
        }
        else
        {
            while(temp2!=null)
            {
                ans.insert(temp2.data);
                temp2=temp2.link;
            }
        }

        return ans;
    }
}