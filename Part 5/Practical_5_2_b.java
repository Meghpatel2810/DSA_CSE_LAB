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
class queue<T>{
    node<T> front,rear;
    node<T> removal;

    queue()
    {
        front=null;
        rear=front;
    }

    void enqueue(T data)
    {
        if(rear==null)
        {
            front=new node<>(data);
            rear=front;
        }
        else
        rear.link=new node<>(data);
        return;
    }
    T dequeue()
    {
        if(front==null)
        {
            return null;
        }
        T item=front.data;
        removal=front;
        front=front.link;
        removal=null;
        return item;
    }
}

public class Practical_5_2_b {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        queue<Integer> q=new queue<>();

        int queries=sc.nextInt();
        for(int i=0;i<queries;i++)
        {
            int choice=sc.nextInt();

            if(choice==1)
            {
                q.enqueue(sc.nextInt());
            }
            else if(choice==2)
            {
                System.out.println(q.dequeue());
            }
            else
            {
                System.exit(0);
            }
        }
        sc.close();
        return;
    }
}