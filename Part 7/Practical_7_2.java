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
    private List<T> li=new ArrayList<>();

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

    public T kthSmallest(int k) {
        if(root==null)
        return null;

        inorder(root);
        return li.get(k-1);
    }
    private void inorder(node<T> root)
    {
        if(root!=null)
        {
            inorder(root.left);
            li.add(root.data);
            inorder(root.right);
        }
    }
}   


public class Practical_7_2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BST<Integer> tree=new BST<>();

        System.out.print("Enter comma seprated elements:  ");
        String root[]=sc.nextLine().split(",");

        for(int i=0;i<root.length;i++)
        {
            if(!root[i].equals("null"))
            tree.insert(Integer.parseInt(root[i]));
        }

        System.out.print("Enter K:");
        System.out.println(tree.kthSmallest(sc.nextInt()));
        sc.close();
        return ;
    }
}
