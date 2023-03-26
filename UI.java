import java.util.ArrayList;

public class UI {
    static readFile read = new readFile();
    static Controlador cont = new Controlador();
    static ArrayList<String> total = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("\n¡Bienvenidos a un diccionario inglés - español - francés!\n");
        System.out.println("En este momento se leera el archivo de código...\n");
        total=read._readfile("C:\\Users\\villa\\Desktop\\Clases_S3\\Algoritmos\\Hoja-de-trabajo-7-MJV\\Archivo_de_Palabras.txt");
        System.out.println(total);
        System.out.println(read.Ingles_Temp);
        System.out.println(read.Espanol_Temp);
        System.out.println(read.Frances_Temp);
        System.out.println(total.get(0));
        System.out.println("\nEl programa ha terminado de interpretar las funciones\n");

        cont.guarda_en_arboles();
        cont.imprimir_in_order();
    }

}

//C:\\Users\\villa\\Desktop\\Clases_S3\\Algoritmos\\Hoja-de-trabajo-7-MJV\\Archivo_de_Palabras
//C:\\Users\\villa\\Desktop\\Clases_S3\\Algoritmos\\Hoja-de-trabajo-7-MJV\\Archivo_de_Oración_a_traducir
