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
    private node<T> root;

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

    public void inorder()
    {
        inorder(root);
        System.out.println();
        return;
    }
    private void inorder(node<T> root)
    {
        if(root!=null)
        {
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }

    public void postorder()
    {
        postorder(root);
        System.out.println();
        return;
    }
    private void postorder(node<T> root)
    {
        if(root!=null)
        {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
        
    }

    public void preorder()
    {
        preorder(root);
        System.out.println();
        return;
    }
    private void preorder(node<T> root)
    {
        if(root!=null)
        {
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }   
    }

    public void levelorder()
    {
        System.out.println(nodes);
    }
    
}

public class Practical_6_1 {
    public static void main(String[] args) {
        Tree<Integer> tree=new Tree<>(Arrays.asList(3,5,20,null,null,9,7));
        tree.inorder();
        tree.postorder();
        tree.preorder();
        tree.levelorder();
    }
}