import java.util.*;

class node<T extends Comparable<T>>{
    T data;
    node<T> left;
    node<T> right;

    node()
    {
        data=null;
        left=right=null;
    }

    node(T data)
    {
        this.data=data;
        left=right=null;
    }
}

class BST<T extends Comparable<T>>{
    private node<T> root;

    BST()
    {
        root=null;
    }

    public void insert(T data)
    {
        root=insert(data, root);
        return ;
    }
    private node<T> insert(T data,node<T> root)
    {
        if(root==null)
        {
            root = new node<>(data);
        }
        else if(root.data.compareTo(data)>0)
        {
            root.left=insert(data, root.left);
        }
        else if(root.data.compareTo(data)<0)
        {
            root.right=insert(data, root.right);
        }

        return root;
    }

    public void Get_ans(T data)
    {
       node<T> ans=search(data, root);

       System.out.println((ans==null ? "null" : levelorder(ans)));
       return ;
    }

    private node<T> search(T data,node<T> root)
    {
        if(root==null)
        return null;
        else if(root.data.equals(data))
        {
            return root;
        }
        else if(root.data.compareTo(data)<0)
        {
            return search(data, root.right);
        }
        else
        {
            return search(data, root.left);
        }

    }
    private List<T> levelorder(node<T> root)
    {
        Queue<node<T>> q=new LinkedList<>();
        q.offer(root);

        List<T> ans=new LinkedList<>();

        while(!q.isEmpty())
        {
            node<T> curr=q.poll();
            
            ans.add(curr.data);

            if(curr.left!=null)
            q.offer(curr.left);
            if(curr.right!=null)
            q.offer(curr.right);
        }
        
        return ans;
    }
}   

public class Practical_7_1 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        BST<Integer> tree=new BST<>();

        System.out.print("Enter comma seprated elements:  ");
        String root[]=sc.nextLine().split(",");

        for(int i=0;i<root.length;i++)
        {
            tree.insert(Integer.parseInt(root[i]));
        }

        System.out.print("Enter the element you want to search :");
        tree.Get_ans(sc.nextInt());

        sc.close();
        return ;
    }
}