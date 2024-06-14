package dataStructure;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;

public class Tree
{
    public Node root;



    public static class Node
    {
        public int value;
        public Node left;
        public Node right;

        public Node(int value)
        {
            this.value = value;
        }


        // Método usado para verificar se o nó é folha
        public boolean isLeaf()
        {
            // Se a esquerda ou direita DESSE NÓ for null, ele é uma folha
            return (this.left == null) && (this.right == null);
        }
    }

    public void insert(int value)
    {
        // Se a árvore está vazia, recebe um nó com o value inserido
        if(root == null) root = new Node(value);
        else
        {
            Node newNode = new Node(value);

            // Criando uma fila utilizando uma lista ligada fornecida pela
            // própria linguagem JAVA
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (queue.size() > 0) // Enquanto houver elementos na fila
            {
                // Ler o elemento da fila e retira-lo da fila
                Node currentNode = queue.remove();

                // Se o lado esquerdo do elemento estiver vazio
                if(currentNode.left == null)
                {
                    // Adicionar o novo nó à esquerda
                    currentNode.left = newNode;
                    break;
                }
                else
                {
                    // Se o lado esquerdo estiver preenchido,
                    // iremos adiciona-lo à fila
                    queue.add(currentNode.left);
                }

                if(currentNode.right == null)
                {
                    currentNode.right = newNode;
                    break;
                }
                else
                {
                    queue.add(currentNode.right);
                }
            }
        }
    }


    public void preOrder()
    {
        // Método usado para chamar o preOrder iniciando da raíz
        preOrder(root);
    }

    private void preOrder(Node node)
    {
        // RAIZ - ESQUERDA - DIREITA

        if (node == null) return;
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);

    }


    public void inOrder()
    {
        // Método usado para chamar o preOrder iniciando da raíz
        inOrder(root);
    }

    private void inOrder(Node node)
    {
        // ESQUERDA - RAÍZ - DIREITA

        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);

    }

    public void posOrder()
    {
        // Método usado para chamar o preOrder iniciando da raíz
        posOrder(root);
    }

    private void posOrder(Node node)
    {
        // ESQUERDA - DREITA - RAIZ

        if (node == null) return;
        posOrder(node.left);
        posOrder(node.right);
        System.out.println(node.value);

    }

    public void BFS()
    {
        // Se a árvore estiver vazia, não executará o bloco
        if (root == null) return;
        // Criando uma fila usando uma linkedList
        Queue<Node> queue = new LinkedList<>();
        queue.add(root); // Adicionando o nó raíz à fila

        while (!queue.isEmpty()) // Enquanto a fila não estiver vazia
        {
            // Cria um novo nó que recebe o nó removido
            // de acordo com a sequencia da árvore
            Node newNode = queue.remove();

            // Usa o nó removido para verificar se
            // o lado esquero ou direito do nó ESTÃO VAZIOS
            // se não estiverem, adicionam os nós à fila
            if(newNode.left != null) queue.add(newNode.left);
            if(newNode.right != null) queue.add(newNode.right);

            System.out.println(newNode.value);

        }
    }

    public static void main(String[] args)
    {

        Tree myTree = new Tree();
        myTree.insert(37);
        myTree.insert(11);
        myTree.insert(8);
        myTree.insert(66);
        myTree.insert(17);
        myTree.insert(42);
        myTree.insert(72);


        System.out.println("#############################");

        myTree.preOrder();

        System.out.println("#############################");



    }
}
