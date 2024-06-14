package dataStructure;

public class BSTPratica
{
    // Inserir,inOrder,remover

    public Node root;

    public class Node
    {
        private int value;
        private Node left;
        private Node right;

        Node(int value)
        {
            this.value = value;
        }
    }


    public void insert(int value)
    {
        if (root == null)
        {
            root = new Node(value);
        }
        else
        {
            insert(root,value);
        }

    }

    private void insert(Node node, int value)
    {
        if (node == null) return;
        if(value == root.value) return;

        if(value > node.value)
        {
            if(node.right == null) node.right = new Node(value);
            else insert(node.right,value);
        }
        else
        {
            if (node.left == null) node.left = new Node(value);
            else insert(node.left,value);
        }
    }

    public void inOrder()
    {
        inOrder(root);
    }

    private void inOrder(Node node)
    {
        if (node == null) return;

        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public boolean contains(int value)
    {
        return contains(root,value);
    }

    private boolean contains(Node node, int value)
    {
        if (node == null) return false;
        if (value == node.value) return true;
        if(value > node.value) return contains(node.right,value);
        else return contains(node.left,value);
    }

    public int minValue(Node currentNode)
    {
        while (currentNode.left != null)
        {
            currentNode = currentNode.left;
        }

        return currentNode.value;
    }

    public void delete(int value)
    {
        root = delete(root,value);
    }

    private Node delete(Node node, int value)
    {
        if (node == null) return null;

        if(value < node.value)
        {
            node.left = delete(node.left,value);
        }
        else if(value > node.value)
        {
            node.right = delete(node.right,value);
        }
        else
        {
            if(node.left == null && node.right == null)
            {
                return null;
            }
            else if (node.left == null)
            {
                return node.right;
            }
            else if(node.right == null)
            {
                return node.left;
            }
            else
            {
                int minValue = minValue(node.right);
                node.value = minValue;
                node.right = delete(node.right,minValue);

            }
        }
        return node;
    }


    public static void main(String[] args)
    {
        BSTPratica tree = new BSTPratica();

        tree.insert(30);
        tree.insert(13);
        tree.insert(34);
        tree.insert(21);
        tree.insert(65);
        tree.insert(32);
        tree.insert(54);

        tree.inOrder();

        tree.contains(1);
        tree.contains(21);
        tree.delete(32);

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        tree.inOrder();

    }
}
