package dataStructure;

public class Queue
{
    private Node first;
    private Node last;
    private Node next;
    private int lenght;

    public class Node
    {
        int value;
        Node next;

        Node(int value)
        {
            this.value = value;
        }

        public int getValue()
        {
            return this.value;
        }

    }

    public  Queue (int value)
    {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        lenght = 1;
    }

    public  void getFirst()
    {
        if (first == null)
        {
            System.out.println("A lista está vazia.");
        }
        else
        {
            System.out.println("First: " + first.value);
        }
    }


    public void getLast()
    {
        if (last == null)
        {
            System.out.println("A lista está vazia.");
        }
        else
        {
            System.out.println("Last: " + last.value);
        }
    }

    public void getLenght()
    {
        System.out.println("Lenght: " + lenght);
    }

    public void print()
    {
        Node newNode = first;

        System.out.println("###########################");
        if (lenght == 0)
        {
            System.out.println("A lista está vazia.");
        }
        else
        {
            while (newNode != null)
            {
                System.out.println(newNode.value);
                newNode = newNode.next;
            }
        }
        System.out.println("###########################");
    }

    public void enqueue(int value)
    {
        Node newNode = new Node(value);

        if (lenght == 0)
        {
            first = newNode;
            last = newNode;
        }
        else
        {
            last.next = newNode;
            last = newNode;
            newNode.next = null;
        }
        lenght ++;
    }

    public Node dequeue ()
    {
        if (lenght == 0)
        {
            return  null;
        }

        Node temp = first;

        if(lenght == 1)
        {
            first = null;
            last = null;
        }
        else
        {
            first = first.next;
            temp.next = null;
        }
        lenght -- ;
        return  temp;
    }


    public static void main(String[] args) {

        Queue myQueue = new Queue(7);
        myQueue.enqueue(3);
        myQueue.enqueue(5);
        myQueue.getFirst();
        myQueue.getLast();
        myQueue.print();
        myQueue.getLenght();
        System.out.println(myQueue.dequeue().value);
        System.out.println(myQueue.dequeue().value);
        System.out.println(myQueue.dequeue().value);

    }


}
