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

    public void Solution()
    {
        System.out.println("Root :"+root.data);

        System.out.print("Left boundary nodes :");
        left_boundary(root.left);
        System.out.println();

        System.out.print("Leaf nodes :");
        leaf_nodes(root);
        System.out.println();

        System.out.print("Right boundary nodes :");
        right_boundary(root.right);
        System.out.println();
    }

    private void left_boundary(node<T> root)
    {
        if(root!=null)
        {
            if(root.left!=null)
            {
                System.out.print(root.data+" ");
                left_boundary(root.left);
            }
            else if(root.right!=null)
            {
                System.out.println(root.data+" ");
                left_boundary(root.left);
            }
        }
        return ;
    }
    private void right_boundary(node<T> root)
    {
        if(root!=null)
        {
            if(root.right!=null)
            {
                right_boundary(root.right);
                System.out.print(root.data+" ");
            }
            else if(root.left!=null)
            {
                right_boundary(root.left);
                System.out.print(root.data+" ");
            }
        }
        return ;
    }
    private void leaf_nodes(node<T> root)
    {
        if(root!=null)
        {
            leaf_nodes(root.left);
            if(root.left==null && root.right==null)
            {
                System.out.print(root.data+" ");
            }
            leaf_nodes(root.right);
        }
        return ;
    }
}


public class Practical_6_3_b {
    public static void main(String[] args) {
        Tree<Integer> tree=new Tree<>(Arrays.asList(20,8,22,4,12,null,25,null,null,10,14,null,null));
        tree.Solution();
    }
}