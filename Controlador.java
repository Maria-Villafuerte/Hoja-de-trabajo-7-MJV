import java.util.ArrayList;
import java.util.Comparator;

public class Controlador {
    //Guardar datos

    //Crear un tree para cada idioma 
    String a;
    readFile read = new readFile();

    PrioridadComparador<Integer> comparadroPrioridad = new PrioridadComparador<>();
    Association<Integer, Palabra> extractorPrioridad = new Association<Integer, Palabra>();

    Comparator<Integer> intComparator = new Comparator<Integer>() {
        public int compare(Integer i1, Integer i2) {
            return i1 - i2;
        }
    };

    IGetKey<Integer, String> getKeyFunc = new IGetKey<Integer, String>() {
        @Override
        public Integer getKeyFromValue(String value) {
            return null;
        }

        public Integer getKey(String value) {
            return Integer.parseInt(value);
        }
    };

    //Creación de los tres árboles para el diccionario
    BinarySearchTree<Integer, String> Arbol_Epañol = new BinarySearchTree<>(intComparator, getKeyFunc);
    BinarySearchTree<Integer, String> Arbol_Ingles = new BinarySearchTree<>(intComparator, getKeyFunc);
    BinarySearchTree<Integer, String> Arbol_Frances = new BinarySearchTree<>(intComparator, getKeyFunc);


    //Método que guarda todos los datos en los árboles
    ArrayList<String> Espanol_Temp_en_cont = read.Espanol_Temp;
    ArrayList<String> Ingles_Temp_en_cont  = read.Ingles_Temp;
    ArrayList<String> Frances_Temp_en_cont  = read.Frances_Temp;
    public void guarda_en_arboles(){
        int cont = 1;
        for (String a:Espanol_Temp_en_cont) {
            Arbol_Epañol.insert(cont, a);
            cont++;
        }
        cont =1;
        for (String a:Ingles_Temp_en_cont) {
            Arbol_Ingles.insert(cont, a);
            cont++;
        }
        cont =1;
        for (String a:Frances_Temp_en_cont) {
            Arbol_Frances.insert(cont, a);
            cont++;
        }
    }


    public void In_Order(BinarySearchTree<Integer, String> aa, String ee){
        System.out.print("Desplegado con método InOrder " + ee);
        System.out.println("\n");
        aa.InOrderTraversal(new ITraversal<Integer, String>() {
            public void visit(TreeNode<Integer, String> node) {
                System.out.print("\t"+node.getValue() + "\n");
            }
        });
    }

    //Impimir los 3 árboles en in order
    public void imprimir_in_order(){
        In_Order(Arbol_Epañol, "Español");
        System.out.println("\n");
        In_Order(Arbol_Ingles, "Ingles");
        System.out.println("\n");
        In_Order(Arbol_Frances, "Frances");
    }

    //.add(new Palabra(1,"Hola"));


}
