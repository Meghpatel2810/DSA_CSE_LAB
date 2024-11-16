import java.util.Scanner;

class queue{
    private int front,rear,size;
    private int arr[];

    public queue(int size)
    {
        front=0;
        rear=-1;
        this.size=size;
        arr=new int[size];
    }
    public void add(int num)
    {
        if(rear==size-1)
        {
            throw new ArrayIndexOutOfBoundsException("Queue has reached its limit");
        }
        else
        {
            rear++;
            arr[rear]=num;
        }
        return ;
    }
    public int remove()
    {
        if(front>rear)
        {
            throw new ArrayIndexOutOfBoundsException("Queue has no elements to remove");
        }
        else
        {
            int data=arr[front];
            front++;
            return data;
        }
    }
}

public class Queue_using_array {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter the size of the queue :");
        int size=sc.nextInt();
        System.out.print("Enter the number of queries :");
        int queries=sc.nextInt();
        
        if(size<1 || queries<1)
        {
            System.out.println("Invalid Value");
            System.exit(0);
        }

        queue obj=new queue(size);

        for(int i=1;i<=queries;i++)
        {
            int option=sc.nextInt();

            if(option==1)
            {
                try
                {
                    obj.add(sc.nextInt());

                }catch (ArrayIndexOutOfBoundsException error)
                {
                    error.printStackTrace();
                }
            }
            else if(option==2)
            {
                try
                {
                    System.out.println(obj.remove());
                }
                catch(ArrayIndexOutOfBoundsException error)
                {
                    error.printStackTrace();
                }
            }
            else
            {
                System.out.println("Invalid Value");
                break ;
            }
        }
        sc.close();
    }
}