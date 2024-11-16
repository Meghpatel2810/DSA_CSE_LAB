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

    public List<T> rightSideView() {
        List<T> li=new ArrayList<>();
        if(root==null)
        return li;
        
        Queue<node<T>> q=new LinkedList<>();
        
        q.offer(root);

        while(!q.isEmpty())
        {
            node<T> curr=new node<T>();
            List<T> level=new ArrayList<>();
            int size=q.size();

            for(int i=0;i<size;i++)
            {
                curr=q.poll();
                level.clear();
                level.add(curr.data);

                if(curr.left!=null)
                q.add(curr.left);
                if(curr.right!=null)
                q.add(curr.right);
            }
            li.add(level.removeLast());
        }
        return li;
    }
}

public class Practical_6_3_a {
    public static void main(String[] args) {
        Tree<Integer> t1,t2,t3;
        t1=new Tree<>(Arrays.asList(1,2,3,null,5,null,4));
        t2=new Tree<>(Arrays.asList(1,null,3));
        t3=new Tree<>(new ArrayList<Integer>());

        System.out.println(t1.rightSideView());
        System.out.println(t2.rightSideView());
        System.out.println(t3.rightSideView());
    }
}