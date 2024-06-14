package dataStructure;

public class BST
{

    private Node root;

    private class Node
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
            // Se a raiz for vazia
            root = new Node(value);
        }
        else
        {
            // Metodo recursivo para inserir na raiz
            insert(root,value);
        }
    }

    private void insert(Node node, int value)
    {
        //Se raiz for nula ou se o valor for igual ao valor da raiz
        if(node == null) return;
        if(value == root.value) return;

        // Se o valor for maior que a raiz, inserir a direita
        if(value > node.value)
        {
            // Se o nó da direita for vazio, recebe um nó com o valor inserido
            if(node.right == null) node.right = new Node(value);
            else insert(node.right,value); // Se não, refaz o método com esse valor
        }
        else
        {
            if(node.left == null) node.left = new Node(value);
            else insert(node.left,value);

        }
    }

    private void inOrder()
    {
        //Método recursivo
        inOrder(root);
    }

    private void inOrder(Node node)
    {
        // Se o nó for vazio
        if(node == null) return;
        inOrder(node.left); // Executa novamente o método com o nó esquerdo
        System.out.println(node.value); // Exibe o valor do nó
        inOrder(node.right); // Executa novamente com o nó direito
    }

    private boolean contains(int value)
    {
        //Método recursivo
        return contains(root,value);
    }

    private boolean contains(Node node, int value)
    {
        // Se o nó for nulo, não existe esse valor na árvore
        if(node == null) return false;
        // Se o valor do nó for igual ao valor pesquisado, o nó existe
        if(node.value == value) return true;

        // Se o valor for maior que o valor da raiz, retorna o método
        // e executa novamente buscando pela direita da árvore e passando
        // o valor que será buscado
        if(value > root.value) return contains(node.right,value);

        // senão, realiza o mesmo processo acima, porém
        // navegando pelo lado esquerdo da arvore
        else return contains(node.left,value);
    }


    // Método usado para identificar qual é a menor folha à esquerda
    // para fazer a remoção de um nó completo.
    // Substituiremos o valor que será removido pelo ultima folha esquerda
    // e logo após, excluiremos o ultimo nó
    private  int minValue(Node currentNode)
    {
            // Enquanto houver nós à esquerda
        while (currentNode.left != null)
        {
            // Nó recebe seu nó esquerdo e continua navegando pela arvore
            currentNode = currentNode.left;
        }

        return currentNode.value;
    }

    private void deleteNode(int value)
    {
        //Método recursivo
        root = deleteNode(root,value);
    }

    private Node deleteNode(final Node node, int value)
    {
        // Se o a raiz for vazia
        if (node == null) return null;

        // Se o valor inserido for maior que o valor da raiz
        if(value < node.value)
        {
            // método executado novamente usando o nó à esquerda
            node.left = deleteNode(node.left,value);
        }
        else if (value > node.value) // Se o valor inserido for maior que o valor do nó
        {
            // método executado novamente usando o nó à direita
            node.right = deleteNode(node.right,value);
        }
        else
        {
            // Se o nó esquerdo e direito estiverem vazios (folha), return null
            if(node.left == null && node.right == null)
            {
                return null;
            }
            else if (node.left == null) // Se esquerda estiver vazia,retorne o nó da direita
            {
                return node.right;
            }
            else if (node.right == null) // Se direita estiver vazia,retorne o nó da esquerda
            {
                return node.left;
            }
            else
            {
                // minValue recebe o nó da direita
                // que verifica qual o valor do último nó à esquerda
                // do nó inserido

                int minValue = minValue(node.right);
                node.value = minValue; // O nó inserido recebe o valor do último nó
                // O nó executará novamente o método,mas, dessa vez o valor pesquisado
                // para remover é o valor mínimo
                node.right = deleteNode(node.right,minValue);
            }
        }
        return node;
    }


    public static void main(String[] args) {

        BST tree = new BST();

        tree.insert(37);
        tree.insert(66);
        tree.insert(42);
        tree.insert(11);
        tree.insert(72);
        tree.insert(8);
        tree.insert(17);





        tree.deleteNode(8);

        tree.inOrder();
    }
}
