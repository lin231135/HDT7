package uvg.edu.gt;

/**
 * Clase que representa una asociación clave-valor.
 *
 * @param <K> El tipo de la clave.
 * @param <V> El tipo del valor.
 */
public class Association<K extends Comparable<K>, V> implements Comparable<Association<K, V>> {
    /** La clave de la asociación. */
    private K key;
    /** El valor de la asociación. */
    private V value;

    /**
     * Constructor que inicializa una asociación con la clave y el valor especificados.
     *
     * @param key La clave de la asociación.
     * @param value El valor de la asociación.
     */
    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Obtiene la clave de la asociación.
     *
     * @return La clave de la asociación.
     */
    public K getKey() {
        return key;
    }

    /**
     * Obtiene el valor de la asociación.
     *
     * @return El valor de la asociación.
     */
    public V getValue() {
        return value;
    }

    @Override
    public int compareTo(Association<K, V> other) {
        return this.key.compareTo(other.key);
    }
}
