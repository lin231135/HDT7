package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

/**
 * Clase principal que contiene el punto de entrada del programa.
 * 
 * Autor: Javier Linares - 231135
 */

public class Main {
    /**
     * Punto de entrada del programa.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        // Crear un árbol binario para almacenar las asociaciones palabra-inglés/word-español
        BinaryTree<Association<String, String>> dictionary = new BinaryTree<>();
        try {
            // Leer el diccionario y crear el árbol binario
            BufferedReader br = new BufferedReader(new FileReader("diccionary.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("[(),]", ""); // Eliminar paréntesis y comas
                String[] parts = line.split("\\s+");
                String englishWord = parts[0].toLowerCase(Locale.ROOT);
                String spanishWord = parts[1].toLowerCase(Locale.ROOT);
                dictionary.insert(new Association<>(englishWord, spanishWord));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Imprimir las relaciones ordenadas por la palabra en inglés
        System.out.println("Relaciones ordenadas por la palabra en inglés: ");
        dictionary.inorder();
        System.out.println("Traducción del archivo de entrada: ");

        try {
            // Leer el archivo de texto a traducir
            BufferedReader br = new BufferedReader(new FileReader("text.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                // Dividir la línea en palabras
                String[] words = line.split("\\s+");
                for (String word : words) {
                    // Limpiar la palabra y convertirla a minúsculas
                    String cleanedWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase(Locale.ROOT);
                    // Buscar la traducción en el diccionario
                    Association<String, String> translation = findTranslation(dictionary.root, cleanedWord);
                    // Imprimir la traducción o la palabra original entre asteriscos
                    if (translation != null) {
                        System.out.print(translation.getValue() + " ");
                    } else {
                        System.out.print("*" + word + "* ");
                    }
                }
                System.out.println(); // Imprimir una nueva línea después de cada línea de texto
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca la traducción de una palabra en el diccionario.
     *
     * @param node El nodo actual en la búsqueda.
     * @param word La palabra que se está buscando.
     * @return La asociación palabra-traducción si se encuentra, null de lo contrario.
     */
    private static Association<String, String> findTranslation(Node<Association<String, String>> node, String word) {
        if (node == null) {
            return null;
        }

        int comparison = word.compareTo(node.data.getKey());
        if (comparison == 0) {
            return node.data;
        } else if (comparison < 0) {
            return findTranslation(node.left, word);
        } else {
            return findTranslation(node.right, word);
        }
    }
}
