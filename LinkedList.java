package dataStructure;

import javax.management.NotificationEmitter;

public class LinkedList
{
    private Node head; // Cabeça da lista (1º Valor)
    private Node tail; // Calda da lista (Ultimo valor)
    private int length; // Tamanho da lista

    class Node // Classe interna para criação dos nós da lista
    {
        String data; // String para armazenar o conteúdo do nó
        Node next; // Próximo nó que será referenciado

        Node(String data) // Construtor do nó obrigatoriamente inserindo um valor
        {
            this.data = data;
        }
    }

    public LinkedList(String data)
    {
        length = 1; // Tamanho da lista é 1
        Node newNode = new Node(data); // Criando um novo nó
        // Head e Tail recebem o nó criado, pois é o único
        head = newNode;
        tail = newNode;
    }

    public void getHead()
    {
        if(this.head == null)
        {
            System.out.println("\nA head dessa lista está vazia.");
        }
        else
        {
            System.out.printf("\nHead: %s",head.data);
        }
    }


    public void getTail()
    {
        if(this.tail == null)
        {
            System.out.println("\nA cauda dessa lista está vazia.");
        }
        else
        {
            System.out.printf("\nTail: %s",tail.data);
        }

    }

    public void getLength()
    {
        System.out.printf("\nLenght: %s",this.length);
    }

    public void makeEmpty ()
    {
        head = null;
        tail = null;
        length = 0;
    }

    public void print()
    {
        System.out.println("\n####################################################");

        // Criando um nó temporário para percorrer a lista
        // O nó temporário iniciará na head,ou seja, primeira posição
        Node temporario = this.head;

        // Enquanto o nó temporário for diferente de vazio
        // Ou seja,enquanto houver elementos na lista
        while (temporario != null)
        {
            // Exibir na tela o conteúdo dos nós
            System.out.println(temporario.data);
            temporario = temporario.next;
        }

        System.out.println("####################################################");
    }

    public void prepend(String data)
    {
        // Cria um novo nó
        Node newNode = new Node(data);

        // Se a lista estiver vazia, esse nó sera a head e o tail
        if(length == 0)
        {
            head = newNode;
            tail = newNode;
        }
        else // Se houverem nós na lista
        {
            // O newNode.next, ou seja, o próximo valor referente a esse nó
            // Será o nó head. Dessa forma, o newNode entrará atras do nó head
            // Fazendo com que ele se torne o novo head

            newNode.next = head;
            head = newNode;

        }
        length ++;
    }

    public void append(String data)
    {
        Node newNode = new Node(data);
        if(length == 0) // Se a lista estiver vazia
        {
            // Head e tail recebem o newNode
            head = newNode;
            tail = newNode;
        }
        else
        {
            // A calda atual,antes da inserção deverá apontar para o novo nó
            tail.next = newNode;

            // Novo nó se tornara calda da lista
            tail = newNode;

        }

        length ++;
    }

    public Node get( int index)
    {
        // Se o index não existir na lista
        if(index < 0 || index > length) return null;

        Node temp = head; // Nó temporário para percorrer a lista

        // Percorrendo de 0 até o anterior ao index
        // O laço percorrerá até o anterior, pois dentro do laço
        // a variável temporária sempre estará recebendo o valor seguinte
        // Então, se o i estiver na posição 2, receberá o valor da posição 3
        for(int i = 0; i < index; i++)
        {
            temp = temp.next;
        }

        return temp;
    }

    public boolean set(int index,String data)
    {
        Node temp = get(index); // Recebendo nó do index inserido
        if(temp != null) // Se o nó for encontrado
        {
            temp.data = data; // Inserindo a nova data no nó temp
            return true;
        }
        return false;
    }

    public boolean insert(int index,String data)
    {
        if (index < 0 || index > length) return  false;

        if(index == 0)
        {
            // Adicionando ao início da lista
            prepend(data);
            return true;
        }

        if(index == length)
        {
            // Adicionando ao final da lista
            append(data);
            return true;
        }

        Node newNode = new Node(data); // Criando um novo nó

        // Criando um nó temporário para receber o valor anterior
        // ao index inserido
        Node temp = get(index - 1);

        // O próximo nó,referente ao meu novo nó, será o próximo nó
        // do meu nó temporário. Ou seja, IGUALAMOS o nó temporário com
        // o nó criado, ambos recebem a mesma posição
        // Porém, logo após definimos que o próximo nó ao temp,será o novo nó
        // Dessa forma,inserimos o novo nó após o nó temp

        newNode.next = temp.next; // Igualando as posições de node e temp
        temp.next = newNode; // A próxima posição de temp é o node
        length ++;
        return true;
    }

    public Node removeFirst() {
        if (length == 0) return null;

        Node temp = head; // Criando um nó temporário para armazenar a head
        head = head.next; // A nova head é atribuida como o nó seguinte

        // Para retirar o primeiro elemento da lista,dizemos que ele
        // não faz conexão com nenhum outro elemento.
        // Após dizer que o temp.next = null, retiramos ele da lista
        temp.next = null;

        length --; // Diminuindo 1 do tamanho da lista

        // Se o tamanho da lista após a remoção for 0
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public Node removeLast()
    {
        // Se a lista estiver vazia, retornar null
        if (length == 0) return null;

        // Nó criado para navegar, tendo como origem a head
        Node pre = head;

        // Nó temporário criado para armazenar o nó que será excluido
        Node temp =  null;

        // Enquanto o nó for diferente da tail
        while (pre.next != tail)
        {
            // O nó de navegação recebe o próximo nó
            pre = pre.next;
        }
        temp = tail; // temp recebe o ultimo nó
        tail = pre; // Último nó recebe o pre (Penultimo nó)
        tail.next = null; // Próximo nó apos o tail recebe null

        length --; // Reduzindo 1 do tamanho da lista

        // Se após a operação, a lista se tornou vazia...
        // Definir o head e a tail como null
        if(length == 0)
        {
            head = null;
            tail = null;
        }

        return temp;
    }

    public Node remove(int index)
    {
        if(index < 0 || index > length) return null;
        if(index == 0) return removeFirst();
        if(index == length-1) return removeLast();

        // Recebendo o nó anterior ao que desejamos deletar
        Node prev = get(index -1);

        // Fazendo um nó temporário e colocando ele na próxima posição
        // referente ao nó temporário
        // Exemplo: prev = 2 | prev.next = 3| temp = prev.next (3)
        // Dessa forma,substituindo a posição next do prev
        Node temp = prev.next;

        // Definindo que a próxima posição do prev é a próxima posição do next
        // Usando o exemplo acima como base, a prev.next = 4
        prev.next = temp.next;

        // Retirando o temp da lista, dizendo que o seu next é  nulo
        temp.next = null;

        // Diminuindo 1 do tamanho da lista
        length --;

        return temp;
    }


    public static void main(String[] args) {
        LinkedList lista = new LinkedList("Elemento 1");
        lista.append("Elemento 2");
        lista.append("Elemento 3");
        lista.prepend("Elemento 0");

        lista.insert(0, "Teste");
        lista.print();
    }







}
