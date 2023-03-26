import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Stack;

/**
 * @author - Grupo 7
 *         Maria José Villafuerte
 *         Fabiola Contreras
 *         Madeline Castro
 * 
 *         Codigo tomado de Hoja De Trabajo #2 y modificado para intérprete LISP
 *         Propósito: Leer el arhivo txt que tendrá las operaciones a realizar
 * @date 30/01/2023
 */

public class readFile {
  static ArrayList<String> total = new ArrayList<>();
  static ArrayList<String> Espanol_Temp = new ArrayList<>();
  static ArrayList<String> Ingles_Temp = new ArrayList<>();
  static ArrayList<String> Frances_Temp = new ArrayList<>();
  static ArrayList<String> oracion = new ArrayList<>();


  /**
   * Metodo que lee el documento con el código de LISP y guarda los datos
   * dentro de ArrayList
   * 
   * @param fpath Mensaje de lugar donde se encuentra el archivo datos.txt
   * @return data String
   */
  public static ArrayList<String> _readfile(String fpath) {
    try {
      File myObj = new File(fpath);
      Scanner myReader = new Scanner(myObj);

      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        total.add(data);
      }
      myReader.close();
      
      for (String Palabra_en_3_idiomas : total) {
        Stack<String> pila = new Stack<String>();
        String[] partes = Palabra_en_3_idiomas.split(",");
        for (String string : partes) {
          pila.push(string);
        }
        Frances_Temp.add(pila.pop());
        Espanol_Temp.add(pila.pop());
        Ingles_Temp.add(pila.pop());
      }

    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
      return total;
  }

  public static ArrayList<String> _readfile2(String fpath) {
    try {
      File myObj = new File(fpath);
      Scanner myReader = new Scanner(myObj);

      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        oracion.add(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return oracion;
  }
  static Scanner sc = new Scanner(System.in);

  public int menu_idiomas (){
    System.out.println("\t  1.) Español");
    System.out.println("\t  2.) Ingles");
    System.out.println("\t  3.) Frances");
    int a= sc.nextInt();

    if (!(a == 1 || a == 2 || a == 3)) {
        System.out.println("Error ingresa un dato válido");
        a= sc.nextInt();
      if (!(a == 1 || a == 2 || a == 3)) {
        Boolean no_ingresa = false;
        while (!no_ingresa){
          System.out.println("Error ingresa un dato válido");
          a= sc.nextInt();
          if (a == 1 || a == 2 || a == 3) {
            no_ingresa = true;
          }
        }

      }
    }
    return a;

  }

  /**
   * Divide los datos en un arraylist de acuerdo al delimitador dado
   * 
   * @param lista
   * @param delimitador
   * @return
   */
  public static ArrayList<String> split(ArrayList<String> lista, String delimitador) {
    ArrayList<String> subcadenas = new ArrayList<>();
    for (String cadena : lista) {
      String[] partes = cadena.split(delimitador);
      for (String parte : partes) {
        subcadenas.add(parte);
      }
    }
    return subcadenas;
  }
}
