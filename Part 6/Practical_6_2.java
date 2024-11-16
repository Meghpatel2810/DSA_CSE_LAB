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

class Tree<T extends Comparable<T>>{
    private List<T> nodes;
    node<T> root;

    Tree(List<T> nodes)
    {
        this.nodes=nodes;
        root=create(root, 0);
    }

    private node<T> create(node<T> root,int index)
    {
        if(index>=nodes.size() || nodes.get(index)==null)
        {
            return null;
        }
        root=new node<>(nodes.get(index));
        root.left=create(root.left, 2*index+1);
        root.right=create(root.right, 2*index+2);
        return root;
    }

    public int maxDepth(node<T> root)
    {
        return root==null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right))+1 ;
    }
}

public class Practical_6_2 {

    public static void main(String[] args) {
        //EXAMPLES
        Tree<Integer> t1,t2;
        t1=new Tree<>(Arrays.asList(3,9,20,null,null,15,7));
        t2=new Tree<>(Arrays.asList(1,null,2));
        System.out.println(t1.maxDepth(t1.root));
        System.out.println(t2.maxDepth(t2.root));
    }
}