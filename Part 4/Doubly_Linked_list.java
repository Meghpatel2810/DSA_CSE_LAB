import java.util.*;

class node<T>{
    T data;
    node<T> prev;
    node<T> next;

    node(T data)
    {
        this.data=data;
        prev=null;
        next=null;
    }
}

class Linkedlist<T>{
    private node<T> head,temp;
    private node<T> removal;

    Linkedlist()
    {
        head=null;
    }

    public void addFirst(T data)
    {
        temp=new node<>(data);
        temp.next=head;

        if(head!=null)
        head.prev=temp;

        head=temp;
        return;
    }

    public void addLast(T data)
    {
        if(head==null)
        {
            addFirst(data);
            return;
        }
        temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=new node<>(data);
        temp.next.prev=temp;
        return;
    }

    public void removeFirst()
    {
        if(head==null)
        {
            System.out.println("List is empty");
            return ;
        }
        if(head.next==null)
        {
            head=null;
            System.gc();
            return;
        }
        head.next.prev=null;
        removal=head;
        head=head.next;
        removal=null;
        System.gc();
        return;
    }

    public void removeLast()
    {
        if(head==null)
        {
            System.out.println("List is empty");
            return ;
        }
        if(head.next==null)
        {
            head=null;
            System.gc();
            return;
        }
        temp=head;

        while (temp.next.next!=null) 
        {
            temp=temp.next;    
        }
        removal=temp.next;
        temp.next=null;
        removal=null;
        System.gc();
        return ;
    }


    public void Delete()
    {
        while(head!=null)
        {
            removeFirst();
        }
        return;
    }

    public void Print()
    {
        System.out.println("---------------------------------------------------------");
        temp=head;
        while(temp!=null)
        {
            // System.out.println(69);
            System.out.print(temp.data+"-");
            temp=temp.next;
        }
        System.out.println("null");
        System.out.println("---------------------------------------------------------");
        return ;
    }


}

public class Doubly_Linked_list {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        Linkedlist<String> list=new Linkedlist<>();

        while(true)
        {
            System.out.println("[0]Exit");
            System.out.println("[1]Add first");
            System.out.println("[2]Add last");
            System.out.println("[3]Remove First");
            System.out.println("[4]Remove last");
            System.out.println("[5]Delete list");
            System.out.println("[6]Print List");
            System.out.print("Enter your choice :");
            
            switch(sc.nextInt())
            {
                case 0:
                {
                    System.out.println("THANK YOU");
                    return ;
                }
                case 1:
                {
                    list.addFirst(sc.next());
                    break;
                }
                case 2:
                {
                    list.addLast(sc.next());
                    break;
                }
                case 3:
                {
                    list.removeFirst();
                    break;
                }
                case 4:
                {
                    list.removeLast();
                    break;
                }
                case 5:
                {
                    list.Delete();
                    break;
                }
                case 6:
                {
                    System.out.println();
                    list.Print();
                    break;
                }
                default :
                {
                    System.out.println("Invalis value");
                }
                System.out.println();
            }
        }
    }
}