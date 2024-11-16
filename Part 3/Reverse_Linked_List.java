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

public class Reverse_Linked_List {
    public static void main(String[] args) {
        node<Integer> head=new node<>(1);
        head.link=new node<>(2);
        head.link.link=new node<>(3);
        head.link.link.link=new node<>(4);
        head.link.link.link.link=new node<>(5);

        PrintList(head);
        PrintList(reverse(head));
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

    public static <T>void PrintList(node<T> head)
    {
        node<T> temp=head;
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