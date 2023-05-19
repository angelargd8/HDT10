package src.Modelo;

import java.io.File;
import java.util.*;

public class Reader {
    // aqui puede cambiar la ruta
    private final String PATH = "logistica.txt";
    private ArrayList<String[]> lines = new ArrayList<String[]>();
    private Scanner sc;
    private File file;
    private HashMap<String,Integer> keysMap = new HashMap();


    /**
     * Metodo constructor, llama a la funcion para leer el archivo y otra para generar
     * un conjunto de todas las ciudades.
     */
    public Reader(){
        readFile();
        setKeys();
    }


    /**
     * Lee el archivo y pone todas sus lineas en un array bidimensional donde
     * la primera dimension representa la linea y la segunda una palabra específica
     * de la línea
     * @return devuelve un ArrayList de String[]
     */
    private ArrayList<String[]> readFile(){
        try {
            file = new File(PATH);
            sc = new Scanner(file);

            while (sc.hasNextLine()){
                String[] nodeElements = sc.nextLine().trim().split(" ");
                lines.add(nodeElements);
            }

            sc.close();
            return lines;

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);

            return lines;
        }
    }


    /**
     * Coloca todas las ciudades en un conjunto y posteriormente
     * les asigna un numero en un hashmap
     */
    private void setKeys(){
        HashSet<String> keys = new HashSet<>();

        for (String[] nodeArray: lines) {
            keys.add(nodeArray[0]);
            keys.add(nodeArray[1]);
        }

        int i = 0;
        for (String key: keys) {
            keysMap.put(key, i);
            i++;
        }
    }

    /**
     * Obtiene las llaves (ciudades) de la matriz
     * @return lista de las ciudades
     */
    public Set<String> getKeys(){
        Set<String> keys = keysMap.keySet();
        return keys;
    }


    /**
     * Genera la matriz de adyacencia
     * @param weatherIndex Número del 2 al 5 que representa el clima
     * @return devuelve una matriz de adyacencia según el clima
     */
    public Integer[][] makeMatrix(Integer weatherIndex){
        Integer size = keysMap.size();
        Integer[][] matrix = createEmptyMatrix(size);

        for (String[] array: lines) {
            Integer index1 = keysMap.get(array[0]);
            Integer index2 = keysMap.get(array[1]);

            Integer weight = Integer.parseInt(array[weatherIndex+1]);
            matrix[index1][index2] = weight;

        }

        return matrix;
    }


    /**
     * Genera un matriz cuadrada de tamaño n y la devuelve llena de ceros
     * @param size representa tamaño de la matriz
     * @return array bidimensional de números enteros
     */
    private Integer[][] createEmptyMatrix(Integer size){
        Integer[][] matrix = new Integer[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j){
                    matrix[i][j] = 0;
                }else{
                    matrix[i][j] = 999999999;
                }

            }
        }
        return matrix;
    }
}
