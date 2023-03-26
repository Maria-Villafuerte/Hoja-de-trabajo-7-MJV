import java.util.ArrayList;
import java.util.Comparator;

public class Diccionario {
    //Guardar datos

    //Crear un tree para cada idioma 
    String a;
    readFile read = new readFile();

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


    //Método para traducir una oración
    ArrayList<String> Oracion_traducida = new ArrayList<>();

    public void traducir_oracion(ArrayList<String> a, int idioma_de_oracion, int idioma_a_traducir){
        //1. Español 2.ingles 3. Frances
        Oracion_traducida.clear();
        System.out.println(a);
        BinarySearchTree<Integer, String> Arbol_de_idioma_de_la_oracion = new BinarySearchTree<>(intComparator, getKeyFunc);
        BinarySearchTree<Integer, String> Arbol_de_idioma_de_la_traducion= new BinarySearchTree<>(intComparator, getKeyFunc);
        if (idioma_de_oracion ==1){
            Arbol_de_idioma_de_la_oracion = Arbol_Epañol;
        } else if (idioma_de_oracion==2) {
            Arbol_de_idioma_de_la_oracion = Arbol_Ingles;
        }else if (idioma_de_oracion==3) {
            Arbol_de_idioma_de_la_oracion = Arbol_Frances;
        }
        if (idioma_a_traducir ==1){
           Arbol_de_idioma_de_la_traducion = Arbol_Epañol;
        } else if (idioma_a_traducir==2) {
            Arbol_de_idioma_de_la_traducion = Arbol_Ingles;
        }else if (idioma_a_traducir==3) {
            Arbol_de_idioma_de_la_traducion = Arbol_Frances;
        }
        //para saber que árbol usar

        for (String Palabra:a) {
            Palabra = Palabra.toLowerCase();
            //Que la palabra si este en el diccionario
            String palabra_a_buscar = Palabra;
            Integer llave_de_palabra_a_buscar = Arbol_de_idioma_de_la_oracion.getKey(palabra_a_buscar);
            String traduccion_de_palabra="";
            if (llave_de_palabra_a_buscar != null){
                traduccion_de_palabra = Arbol_de_idioma_de_la_traducion.search(llave_de_palabra_a_buscar);
            } else if (Palabra.equals(".")) {
                traduccion_de_palabra= ".";
            } else {
                traduccion_de_palabra = "*" +Palabra+ "*";
            }
            Oracion_traducida.add(traduccion_de_palabra);
            //Que la palabra no este en el diccionario
        }
        //palabra.toLowerCase()
        System.out.println("\nOración traducida:");
        for (int i = 0; i < Oracion_traducida.size(); i++) {
            System.out.print(Oracion_traducida.get(i) + " ");
        }
    }

}
