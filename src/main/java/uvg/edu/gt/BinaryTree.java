package uvg.edu.gt;

/**
 * Clase que representa un árbol binario.
 *
 * @param <E> El tipo de datos que contendrá el árbol, debe ser comparable.
 */
public class BinaryTree<E extends Comparable<E>> {
    /** El nodo raíz del árbol. */
    public Node<E> root;

    /**
     * Inserta un nuevo dato en el árbol.
     *
     * @param data El dato a insertar.
     */
    public void insert(E data) {
        root = insert(root, data);
    }

    /**
     * Método privado para insertar un dato en el árbol.
     *
     * @param node El nodo actual.
     * @param data El dato a insertar.
     * @return El nodo actualizado.
     */
    private Node<E> insert(Node<E> node, E data) {
        if (node == null) {
            return new Node<>(data);
        }

        if (data.compareTo(node.data) < 0) {
            node.left = insert(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insert(node.right, data);
        }

        return node;
    }

    /**
     * Realiza un recorrido inorder (en orden) del árbol.
     */
    public void inorder() {
        inorder(root);
    }

    /**
     * Método privado para realizar un recorrido inorder del árbol.
     *
     * @param node El nodo actual.
     */
    private void inorder(Node<E> node) {
        if (node != null) {
            inorder(node.left);
            System.out.println("(" + ((Association<String, String>) node.data).getKey() + ", " +
                    ((Association<String, String>) node.data).getValue() + ")");
            inorder(node.right);
        }
    }

    /**
     * Busca la traducción de una palabra en el árbol.
     *
     * @param node El nodo actual en la búsqueda.
     * @param word La palabra que se está buscando.
     * @return La asociación palabra-traducción si se encuentra, null de lo contrario.
     */
    public Association<String, String> findTranslation(Node<Association<String, String>> node, String word) {
        if (node == null) {
            return null;
        }

        int compareResult = word.compareTo(node.data.getKey());
        if (compareResult == 0) {
            return node.data;
        } else if (compareResult < 0) {
            return findTranslation(node.left, word);
        } else {
            return findTranslation(node.right, word);
        }
    }
}
