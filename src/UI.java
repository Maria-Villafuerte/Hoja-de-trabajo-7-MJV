
import java.util.ArrayList;
import java.util.Scanner;


public class UI {
    static readFile read = new readFile();
    static Scanner sc = new Scanner(System.in);
    static Diccionario cont = new Diccionario();
    static ArrayList<String> total = new ArrayList<>();
    static ArrayList<String> oracion_temp = read._readfile2("src\\Archivo_de_Oración_a_traducir.txt");


    public static void main(String[] args) {
        oracion_temp=read.split(oracion_temp, " ");
        System.out.println("\n¡Bienvenidos a un diccionario inglés - español - francés!");
        System.out.println("En este momento se leera el archivo de código...");
        total = read._readfile("src\\Archivo_de_Palabras.txt");
        cont.guarda_en_arboles();
        System.out.println("Las palabras se han guardado en el diccionario");
        boolean salir = false;
        while (!salir) {
            // display menu and get user input
            System.out.println("\nAhora qué desea hacer?");
            System.out.println("\t  1.) Desplegar las palabras InOrder");
            System.out.println("\t  2.) Traducir una oración");
            System.out.println("\t  3.) Salir");
            int opcion_de_menu = sc.nextInt();

            switch (opcion_de_menu) {
                case 1:
                    cont.imprimir_in_order();
                    break;
                case 2:
                    //1. Español 2.ingles 3. Frances
                    System.out.println("De qué idioma es el texto?");
                    int idioma_de_oracion =  read.menu_idiomas();
                    System.out.println("A qué idioma quieres traducirlo");
                    int idioma_de_traduccion = read.menu_idiomas();
                    cont.traducir_oracion(oracion_temp,idioma_de_oracion,idioma_de_traduccion);
                    break;
                case 3:
                    System.out.println("\nEl programa ha terminado\n");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
    }

}
}

//C:\\Users\\villa\\Desktop\\Clases_S3\\Algoritmos\\Hoja-de-trabajo-7-MJV\\src\\Archivo_de_Oración_a_traducir.txt
//Archivo_de_Palabras.txt
//C:\Users\villa\Desktop\Clases_S3\Algoritmos\Hoja-de-trabajo-7-MJV\src\Archivo_de_Oración_a_traducir.txt
//C:\\Users\\villa\\Desktop\\Clases_S3\\Algoritmos\\Hoja-de-trabajo-7-MJV\\src\\Archivo_de_Palabras.txt
//C:\\Users\\villa\\Desktop\\Clases_S3\\Algoritmos\\Hoja-de-trabajo-7-MJV\\Archivo_de_Oración_a_traducir
