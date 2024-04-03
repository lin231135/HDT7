package uvg.edu.gt;

/**
 * Clase que representa un nodo en un árbol binario.
 *
 * @param <E> El tipo de datos que contiene el nodo.
 */
public class Node<E> {
    /** El dato almacenado en el nodo. */
    E data;
    /** El hijo izquierdo del nodo. */
    Node<E> left;
    /** El hijo derecho del nodo. */
    Node<E> right;

    /**
     * Constructor que inicializa un nodo con el dato especificado.
     *
     * @param data El dato a almacenar en el nodo.
     */
    public Node(E data) {
        this.data = data;
        left = null;
        right = null;
    }
}
