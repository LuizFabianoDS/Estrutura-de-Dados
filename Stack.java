package dataStructure;

import java.sql.SQLOutput;

public class Stack
{
    private Node top;
    private int height;

    public class Node
    {
        int value;
        Node next;

        private Node (int value)
        {
            this.value = value;
        }

        public  int getValue()
        {
            return value;
        }
    }

    public Stack(int value)
    {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void getTop ()
    {
        if (top == null)
        {
            System.out.println("A pilha está vazia");
        }
        else
        {
            System.out.println("Top: " + top.value);
        }
    }

    public  void getHeight()
    {
        System.out.println("Altura: " + height);
    }

    public void print() {

        System.out.println("##############################");

        if (top == null) {
            System.out.println("A pilha está vazia.");
        }
        else
        {
            Node temp = top;

            while(temp != null)
            {
                System.out.println(temp.value);
                temp = temp.next;
            }

        }
        System.out.println("##############################");
    }

    public void push(int value)
    {
        Node newNode = new Node(value);

        if (height == 0)
        {
            top = newNode;
        }
        else
        {
            newNode.next = top;
            top = newNode;
        }

        height ++;

    }

    public Node pop ()
    {
        if (height == 0) return null;

        Node temp = top;
        top = top.next;
        temp.next = null;

        height --;


        return temp;
    }


    public static void main(String[] args) {
        Stack myStack = new Stack(5);
        myStack.push(21);
        myStack.getHeight();


        System.out.println("Nó retirado: " + myStack.pop().value);
        myStack.getHeight();
        System.out.println("Nó retirado: " + myStack.pop().value);
        System.out.println(myStack.pop() == null);


    }
}
