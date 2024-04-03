import static org.junit.Assert.assertEquals;
import org.junit.Test;

import uvg.edu.gt.Main;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainTest {

    @Test
    public void testTranslateWords() {
        // Redirigir la salida estándar a un stream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Ejecutar el programa con palabras que están en el diccionario
        String[] args = { "The woman askedme to do my homework about my town." };
        Main.main(args);
        String output = outputStream.toString().trim();

        // Verificar la traducción de las palabras que están en el diccionario
        assertEquals("Relaciones ordenadas por la palabra en inglés: \r\n" + //
                        "(dog, perro)\r\n" + //
                        "(homework, tarea)\r\n" + //
                        "(house, casa)\r\n" + //
                        "(town, pueblo)\r\n" + //
                        "(woman, mujer)\r\n" + //
                        "(yes, sí)\r\n" + //
                        "Traducción del archivo de entrada: \r\n" + //
                        "*The* mujer *asked* *me* *to* *do* *my* tarea *about* *my* pueblo", output);

        // Restaurar la salida estándar
        System.setOut(originalOut);
    }
}
