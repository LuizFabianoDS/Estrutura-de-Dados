package dataStructure;

public class Praticando
{
    private Node head;
    private Node tail;
    private int length;

    class Node
    {
        String data;
        Node next;
        private Node (String data)
        {
            this.data = data;
        }
    }

    public Praticando (String data)
    {
        length = 1;
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
    }

    public void getHead()
    {
        if(length == 0)
        {
            System.out.println("A lista está vazia.");
        }
        else
        {
            System.out.println("Head: " + head.data);
        }

    }

    public void getTail()
    {
        if(length == 0)
        {
            System.out.println("A lista está vazia.");
        }
        else
        {
            System.out.println("Tail: " + tail.data);
        }
    }

    public void prepend(String data)
    {
        Node newNode = new Node(data);

        if(length == 0)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            newNode.next = head;
            head = newNode;

        }

        length ++;
    }


    public void append (String data)
    {
        Node newNode = new Node(data);

        if(length == 0)
        {
            newNode = head;
            newNode = tail;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;

        }
        length ++;
    }

    public void print()
    {
        Node temp = this.head;

        System.out.println("##########################################");
        while (temp != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("##########################################");
    }

    public Node get(int index)
    {
        if(index < 0 || index > length) return null;

        Node temp = head;

        for(int i = 0; i < index; i++)
        {
            temp = temp.next;
        }
        return temp;
    }

    public void getLength()
    {
        if (length == 0)
        {
            System.out.println("A lista está vazia.");
        }
        else
        {
            System.out.println("Length: " + this.length);
        }
    }

    public Node set (int index,String data)
    {
        if(index < 0 || index > length - 1) return  null;

        Node percorrer = head;
        Node temp;

        for(int i = 0; i < index; i++)
        {
            percorrer = percorrer.next;
        }
        temp = percorrer;
        temp.data = data;

        return temp;
    }

    public boolean insert(int index,String data)
    {
        if(index < 0 || index > length) return  false;

        if(index == 0)
        {
            prepend(data);
            return true;
        }
        if (index == length)
        {
            append(data);
            return  true;
        }

        Node newNode = new Node(data);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node removeFirst()
    {
        if(length == 0)
        {
            System.out.println("A lista está vazia");
            return null;
        }

        Node temp = head;
        head = head.next;
        temp.next = null;
        length --;

        if(length == 0)
        {
            head = null;
            tail = null;
        }

        return temp;

    }

    public  Node removeLast()
    {
        if (length == 0)
        {
            System.out.println("A lista está vazia.");
            return null;
        }

        Node percorrer = head;
        Node temp = null;

        while (percorrer.next != tail)
        {
            percorrer = percorrer.next;
        }
        temp = tail;
        tail = percorrer;
        tail.next = null;

        length -- ;

        if(length == 0)
        {
            head = null;
            tail = null;
        }

        return temp;
    }

    public  Node remove (int index)
    {
        if(index < 0 || index > length) return null;
        if (index == 0) return  removeFirst();
        if (index == length -1) return removeLast();

        Node prev = get(index -1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length --;

        if (length == 0)
        {
            head = null;
            tail = null;
        }

        return prev;
    }


    public static void main(String[] args) {
        Praticando lista = new Praticando("Helena");
        lista.prepend("Minha");
        lista.insert(2,"é linda");
        lista.append("e cheirosa");

        /*
        lista.print();

        lista.getHead();
        lista.getTail();
        System.out.println("Nó pesquisado: " + lista.get(1).data);

        System.out.println("\n\nAlterando");
        lista.print();
        lista.set(0,"Dona");
        lista.print();

        System.out.println("\n\nInserindo");
        lista.insert(0,"Minha");
        lista.print();

         */

        lista.print();

        System.out.println("Removendo algum nó da lista\nNó removido: " + lista.remove(1).data);
        lista.print();

        lista.getLength();
    }
}
