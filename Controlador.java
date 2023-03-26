import java.util.ArrayList;
import java.util.Comparator;

public class Controlador {
    //Guardar datos

    //Crear un tree para cada idioma 
    String a; 
    PrioridadComparador<Integer> comparadroPrioridad = new PrioridadComparador<>();
    Association<Integer, Palabra> extractorPrioridad = new Association<Integer, Palabra>(); 
    BinarySearchTree<Integer, String> arbol_de_palabras = new BinarySearchTree<Integer, String>(comparadroPrioridad, a);

    public void prueba(){
        arbol_de_palabras.insert(1, "Pato");
        System.out.println(arbol_de_palabras.search(1));

    }

    private BinarySearchTree<Integer, String> tree;

    //.add(new Palabra(1,"Hola"));


}
