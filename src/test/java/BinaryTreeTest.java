import org.junit.Test;

import uvg.edu.gt.Association;
import uvg.edu.gt.BinaryTree;

import static org.junit.Assert.*;

/**
 * Clase de pruebas para la clase BinaryTree.
 */
public class BinaryTreeTest {

    /**
     * Prueba para el método findTranslation de la clase BinaryTree.
     */
    @Test
    public void testFindTranslation() {
        // Crear un árbol binario y agregar algunas asociaciones palabra-traducción
        BinaryTree<Association<String, String>> tree = new BinaryTree<>();
        tree.insert(new Association<>("house", "casa"));
        tree.insert(new Association<>("dog", "perro"));
        tree.insert(new Association<>("homework", "tarea"));

        // Verificar la traducción de una palabra existente
        Association<String, String> translation1 = tree.findTranslation(tree.root, "house");
        assertEquals("casa", translation1.getValue());

        // Verificar la traducción de una palabra inexistente
        Association<String, String> translation2 = tree.findTranslation(tree.root, "cat");
        assertNull(translation2);
    }
}
